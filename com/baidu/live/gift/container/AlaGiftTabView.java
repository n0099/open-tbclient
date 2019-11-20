package com.baidu.live.gift.container;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.resourceloader.BdResourceCallback;
import com.baidu.live.adp.lib.resourceloader.BdResourceLoader;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.imageview.BdImage;
import com.baidu.live.gift.container.a;
import com.baidu.live.gift.g;
import com.baidu.live.gift.graffitiGift.AlaGiftDrawPanel;
import com.baidu.live.gift.h;
import com.baidu.live.gift.k;
import com.baidu.live.gift.widget.panel.GiftPanelNumRoundRectView;
import com.baidu.live.gift.widget.panel.GiftPanelOperationSendView;
import com.baidu.live.gift.widget.panel.GiftPanelTabView;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.BaseViewPager;
import com.baidu.live.tbadk.core.view.BdGridView;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.tieba.view.GradientTextView;
import com.baidu.live.view.RoundRectPageIndicator;
import com.baidu.live.view.d;
import com.baidu.live.view.input.AlaLiveInputEditView;
import com.baidu.live.view.input.b;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes6.dex */
public class AlaGiftTabView implements ViewPager.OnPageChangeListener, b.a {
    private int XT;
    private boolean XV;
    public ArrayList<h> YM;
    private ArrayList<com.baidu.live.gift.a.a> YN;
    private ArrayList<com.baidu.live.gift.a.b> YO;
    private final String YS;
    private final int YT;
    private final int YU;
    private boolean YV;
    private ViewGroup YW;
    protected ViewGroup YX;
    protected ViewGroup YY;
    protected View YZ;
    private int ZA;
    private g ZB;
    private int ZC;
    private SparseIntArray ZD;
    private SparseBooleanArray ZE;
    private View.OnClickListener ZF;
    private AlaLiveInputEditView ZG;
    private ViewGroup ZH;
    private ImageButton ZI;
    private TextView ZJ;
    private AlaGiftDrawPanel ZK;
    private boolean ZL;
    private int ZM;
    private int ZN;
    private boolean ZO;
    private int ZP;
    private SparseBooleanArray ZQ;
    private Set<String> ZR;
    private boolean ZS;
    private boolean ZT;
    private int ZU;
    private com.baidu.live.view.d ZV;
    private boolean ZW;
    private int ZX;
    private View.OnClickListener ZY;
    private View.OnClickListener ZZ;
    private GiftPanelNumRoundRectView Za;
    public TextView Zb;
    protected BaseViewPager Zc;
    protected RoundRectPageIndicator Zd;
    protected HorizontalScrollView Ze;
    protected LinearLayout Zf;
    protected View Zg;
    private CommonEmptyView Zh;
    private FrameLayout Zi;
    private FrameLayout Zj;
    private View Zk;
    private com.baidu.live.gift.container.c Zl;
    public GiftPanelTabView Zm;
    private TextView Zn;
    private TextView Zo;
    private TextView Zp;
    public GiftPanelOperationSendView Zq;
    private ImageButton Zr;
    private List<View> Zs;
    private AlaGiftPagerAdapter Zt;
    private c Zu;
    private int Zv;
    private int Zw;
    private int Zx;
    private boolean Zy;
    private boolean Zz;
    AdapterView.OnItemClickListener aaa;
    Runnable aab;
    Runnable aac;
    private AlaGiftDrawPanel.a aad;
    CustomMessageListener aae;
    CustomMessageListener aaf;
    private boolean isLandscape;
    private TbPageContext mContext;
    private int mSelectedPosition;
    private int mType;
    private String otherParams;

    /* loaded from: classes6.dex */
    public interface c {
        void qA();
    }

    public AlaGiftTabView(TbPageContext tbPageContext, View.OnClickListener onClickListener, boolean z, String str) {
        this.YS = "live_key_privilege_tab_unlock_giftid_array_" + (TbadkCoreApplication.getCurrentAccountInfo() == null ? "" : TbadkCoreApplication.getCurrentAccountInfo().getID());
        this.YT = 10;
        this.YU = 100;
        this.Zs = new ArrayList();
        this.Zv = 0;
        this.Zw = 0;
        this.mSelectedPosition = 0;
        this.Zx = 0;
        this.ZD = new SparseIntArray();
        this.ZE = new SparseBooleanArray();
        this.isLandscape = false;
        this.ZL = false;
        this.ZM = -1;
        this.ZN = -1;
        this.ZO = false;
        this.XV = false;
        this.XT = -1;
        this.ZQ = new SparseBooleanArray();
        this.ZR = new HashSet();
        this.ZW = false;
        this.ZY = new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.Zl == null) {
                    AlaGiftTabView.this.Zl = new com.baidu.live.gift.container.c(AlaGiftTabView.this.mContext, AlaGiftTabView.this.mType, AlaGiftTabView.this.aaa);
                }
                AlaGiftTabView.this.ao(true);
                AlaGiftTabView.this.Zl.a(AlaGiftTabView.this.YZ, AlaGiftTabView.this.YO, AlaGiftTabView.this.isLandscape, new PopupWindow.OnDismissListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.9.1
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public void onDismiss() {
                        AlaGiftTabView.this.ao(false);
                    }
                });
            }
        };
        this.ZZ = new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaGiftTabView.this.ZI.setEnabled(false);
                AlaGiftTabView.this.ZK.rh();
            }
        };
        this.aaa = new AdapterView.OnItemClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.11
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                g.a aVar;
                AlaGiftTabView.this.Zl.dismiss();
                if (AlaGiftTabView.this.YO == null || AlaGiftTabView.this.YO.size() <= 0) {
                    AlaGiftTabView.this.ct("1");
                } else if (i != AlaGiftTabView.this.YO.size()) {
                    com.baidu.live.gift.a.b bVar = (com.baidu.live.gift.a.b) AlaGiftTabView.this.YO.get(i);
                    if (bVar != null) {
                        int number = bVar.getNumber();
                        if (AlaGiftTabView.this.mType == 1 && (aVar = AlaGiftTabView.this.ZB.Wo) != null) {
                            if (number == -1) {
                                number = aVar.Ws;
                            }
                            if (number > AlaGiftTabView.this.ZX) {
                                number = AlaGiftTabView.this.ZX;
                            }
                        }
                        AlaGiftTabView.this.ct(String.valueOf(number));
                    }
                } else {
                    AlaGiftTabView.this.qo();
                }
            }
        };
        this.aab = new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.14
            @Override // java.lang.Runnable
            public void run() {
                AlaGiftTabView.this.ZG.getEditView().requestFocus();
                AlaGiftTabView.this.ZG.getEditView().requestFocusFromTouch();
                BdUtilHelper.showSoftKeyPad(AlaGiftTabView.this.mContext.getPageActivity(), AlaGiftTabView.this.ZG.getEditView());
            }
        };
        this.aac = new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.15
            @Override // java.lang.Runnable
            public void run() {
                BdUtilHelper.hideSoftKeyPad(AlaGiftTabView.this.mContext.getPageActivity(), AlaGiftTabView.this.ZG.getEditView());
            }
        };
        this.aad = new AlaGiftDrawPanel.a() { // from class: com.baidu.live.gift.container.AlaGiftTabView.5
            @Override // com.baidu.live.gift.graffitiGift.AlaGiftDrawPanel.a
            public void bp(int i) {
                AlaGiftTabView.this.ZJ.setText(String.format(AlaGiftTabView.this.mContext.getString(a.i.ala_gift_draw_title_drawing), Integer.valueOf(i), AlaGiftTabView.this.ZB.pd(), Long.valueOf(JavaTypesHelper.toLong(AlaGiftTabView.this.ZB.getPrice(), 0L) * i)));
                int dimensionPixelOffset = AlaGiftTabView.this.mContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_ds22);
                Drawable drawable = AlaGiftTabView.this.mContext.getPageActivity().getResources().getDrawable(a.f.sdk_icon_huobi_tdou18);
                drawable.setBounds(0, 0, dimensionPixelOffset, dimensionPixelOffset);
                AlaGiftTabView.this.ZJ.setCompoundDrawables(null, null, drawable, null);
                if (i > 0) {
                    AlaGiftTabView.this.ZI.setEnabled(true);
                    AlaGiftTabView.this.ZK.setTipImageVisibility(8);
                    AlaGiftTabView.this.YZ.setVisibility(4);
                    AlaGiftTabView.this.ZJ.setVisibility(0);
                } else {
                    AlaGiftTabView.this.ZK.setTipImageVisibility(0);
                    AlaGiftTabView.this.ZJ.setVisibility(8);
                    AlaGiftTabView.this.ZI.setEnabled(false);
                }
                AlaGiftTabView.this.ZC = i;
            }
        };
        this.aae = new CustomMessageListener(2913078) { // from class: com.baidu.live.gift.container.AlaGiftTabView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.d.c)) {
                    com.baidu.live.d.c cVar = (com.baidu.live.d.c) customResponsedMessage.getData();
                    if ((cVar.Vg == 1 || cVar.Vg == 2 || cVar.Vg == 5 || cVar.Vg == 6) && cVar.Vh != null) {
                        AlaGiftTabView.this.cu(cVar.Vh.getId());
                    }
                }
            }
        };
        this.aaf = new CustomMessageListener(2913120) { // from class: com.baidu.live.gift.container.AlaGiftTabView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaGiftTabView.this.am(true);
                if (AlaGiftTabView.this.ZB != null && AlaGiftTabView.this.a(AlaGiftTabView.this.ZB) && AlaGiftTabView.this.YV) {
                    AlaGiftTabView.this.Zq.setStyle(AlaGiftTabView.this.ZB.pj() ? 2 : 1);
                    AlaGiftTabView.this.Za.setStyleEnabled(true);
                }
            }
        };
        this.mContext = tbPageContext;
        this.otherParams = str;
        this.ZF = onClickListener;
        this.ZL = z;
        this.YW = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.live_gift_panel_fragment, (ViewGroup) null);
        this.isLandscape = 2 == UtilHelper.getRealScreenOrientation(this.mContext.getPageActivity());
        initViews();
        initListener();
        this.ZA = BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds36);
        if (this.isLandscape) {
            this.ZU = (ScreenHelper.getRealScreenHeight(this.mContext.getPageActivity()) - (BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds112) * 2)) - BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds16);
            this.Zc.getLayoutParams().height = this.ZU;
        } else {
            this.Zc.getLayoutParams().height = BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds192) * 2;
        }
        this.Zc.requestLayout();
    }

    public void setType(int i) {
        this.mType = i;
        switch (this.mType) {
            case 0:
                this.ZX = 9999;
                break;
            case 1:
                this.ZX = 999;
                break;
        }
        this.ZG.setMaxText(String.valueOf(this.ZX));
        this.ZG.setHintText(String.format(Locale.getDefault(), this.mContext.getString(a.i.ala_send_gift_count_hint), Integer.valueOf(this.ZX)));
    }

    public void al(boolean z) {
        this.ZT = z;
    }

    public void onVisibilityChanged(boolean z) {
        al(z);
        if (z) {
            bi(this.Zx);
        }
    }

    public View getRootView() {
        return this.YW;
    }

    private void initViews() {
        int realScreenHeight = ScreenHelper.getRealScreenHeight(this.mContext.getPageActivity());
        this.YX = (ViewGroup) this.YW.findViewById(a.g.gift_list_layout);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(this.mContext.getResources().getColor(a.d.live_gift_panel_primary));
        float dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        if (this.isLandscape) {
            gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
        } else {
            gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
        }
        this.YX.setBackgroundDrawable(gradientDrawable);
        this.YX.getLayoutParams().width = realScreenHeight;
        this.YY = (ViewGroup) this.YW.findViewById(a.g.gift_tab_input_parent);
        this.YZ = this.YW.findViewById(a.g.gift_count_layout);
        this.YZ.setOnClickListener(this.ZY);
        this.Za = (GiftPanelNumRoundRectView) this.YW.findViewById(a.g.gift_count_round);
        this.Zb = (TextView) this.YW.findViewById(a.g.gift_count_input);
        this.Zb.setText("1");
        this.Zb.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
        this.Zg = this.YW.findViewById(a.g.gift_lower_layout);
        this.Zc = (BaseViewPager) this.YW.findViewById(a.g.gift_viewpager);
        this.Zc.setOnPageChangeListener(this);
        this.Zd = (RoundRectPageIndicator) this.YW.findViewById(a.g.gift_tab_indicator);
        this.Zf = (LinearLayout) this.YW.findViewById(a.g.gift_tab_layout);
        this.Ze = (HorizontalScrollView) this.YW.findViewById(a.g.gift_tab_scrollview);
        if (this.ZL) {
            this.Ze.setVisibility(8);
        }
        this.Zn = (TextView) this.YW.findViewById(a.g.current_money);
        int dimensionPixelOffset2 = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds22);
        Drawable drawable = this.mContext.getResources().getDrawable(a.f.sdk_icon_huobi_tdou18);
        drawable.setBounds(0, 0, dimensionPixelOffset2, dimensionPixelOffset2);
        this.Zn.setCompoundDrawables(drawable, null, null, null);
        this.Zn.setOnClickListener(this.ZF);
        this.Zo = (TextView) this.YW.findViewById(a.g.current_flower);
        this.Zo.setOnClickListener(this.ZF);
        this.Zq = (GiftPanelOperationSendView) this.YW.findViewById(a.g.donate);
        this.Zp = (TextView) this.YW.findViewById(a.g.current_recharge);
        this.Zp.setOnClickListener(this.ZF);
        this.Zq.setOnClickListener(this.ZF);
        this.Zi = (FrameLayout) this.YW.findViewById(a.g.tab_container_view);
        this.Zj = (FrameLayout) this.YW.findViewById(a.g.layout_error);
        this.Zj.getLayoutParams().width = realScreenHeight;
        this.Zh = new CommonEmptyView(this.mContext.getPageActivity());
        this.Zh.setVisibility(8);
        this.Zh.addToParent(this.Zj);
        this.Zm = (GiftPanelTabView) this.YW.findViewById(a.g.tab);
        this.Zk = this.YW.findViewById(a.g.donate_layout);
        ql();
        this.ZH = (ViewGroup) this.YW.findViewById(a.g.ala_gift_draw_layout);
        this.ZH.setVisibility(8);
        this.ZK = (AlaGiftDrawPanel) this.YW.findViewById(a.g.ala_gift_draw_panel);
        this.ZK.setGiftDrawEventListener(this.aad);
        this.ZK.setGiftCountRange(10, 100);
        this.Zr = (ImageButton) this.YW.findViewById(a.g.ala_gift_draw_hide_btn);
        this.Zr.setOnClickListener(this.ZF);
        this.ZI = (ImageButton) this.YW.findViewById(a.g.ala_gift_draw_clean_btn);
        this.ZI.setOnClickListener(this.ZZ);
        this.ZI.setEnabled(false);
        this.ZJ = (TextView) this.YW.findViewById(a.g.ala_gift_draw_title);
        View findViewById = this.YW.findViewById(a.g.ala_gift_draw_title_layout);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.height = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds128);
        } else {
            layoutParams.height = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds128) - UtilHelper.getStatusBarHeight();
        }
        findViewById.setLayoutParams(layoutParams);
        findViewById.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }

    public void qk() {
        this.ZS = true;
        this.Zn.setVisibility(8);
        this.Zo.setVisibility(8);
        this.Zp.setVisibility(8);
    }

    public void am(boolean z) {
        this.YV = z;
    }

    public void b(boolean z, String str, String str2, String str3) {
        if (com.baidu.live.l.a.uB().uF() && z) {
            this.Zp.setText(this.mContext.getPageActivity().getString(a.i.first_recharge_text));
            if (!this.ZR.contains(str)) {
                LogManager.getFirstChargeLogger().doDisplayLiveFirstChargePanelEntryLog(str, str2, str3, this.otherParams);
                this.ZR.add(str);
            }
        }
    }

    public void aP(int i) {
        this.ZP = i;
    }

    private void ql() {
        this.ZG = new AlaLiveInputEditView(this.mContext.getPageActivity());
        this.ZG.setVisibility(8);
        this.ZG.setEditViewConfirmCallBack(this);
        this.YY.addView(this.ZG, new RelativeLayout.LayoutParams(-1, -2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        private int mPosition;

        public b(int i) {
            this.mPosition = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlaGiftTabView.this.bi(this.mPosition);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bi(int i) {
        qp();
        bj(i);
        this.Zc.setCurrentItem(this.Zv);
        qt();
    }

    private void bj(int i) {
        int min = Math.min(i, this.ZD.size());
        int i2 = 0;
        for (int i3 = 0; i3 < min; i3++) {
            i2 += this.ZD.get(i3);
        }
        this.Zv = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a implements AdapterView.OnItemClickListener {
        private a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AlaGiftTabView.this.Zw = AlaGiftTabView.this.Zv;
            AlaGiftTabView.this.a((com.baidu.live.gift.container.a) adapterView.getAdapter(), i);
        }
    }

    public void a(com.baidu.live.gift.container.a aVar, int i) {
        int i2;
        boolean z;
        boolean z2;
        g.a aVar2;
        boolean z3 = true;
        if (this.ZT) {
            this.mSelectedPosition = i;
            qp();
            if (aVar != null) {
                g item = aVar.getItem(i);
                if (item != null) {
                    this.ZB = item;
                    aVar.bd(i);
                    aVar.notifyDataSetChanged();
                    this.Zk.setVisibility(aVar.getCount() > 0 ? 0 : 4);
                    ct("1");
                    if (this.mType == 1 && (aVar2 = this.ZB.Wo) != null && !TextUtils.isEmpty(aVar2.Wu)) {
                        this.mContext.showToast(aVar2.Wu);
                    }
                    int i3 = -1;
                    if (this.mType == 0) {
                        if (this.ZB.pq()) {
                            this.Zq.setStyle(this.ZB.pj() ? 4 : 3);
                            this.Za.setStyleEnabled(false);
                            this.ZH.setVisibility(8);
                            if (!TextUtils.isEmpty(this.ZB.pl())) {
                                this.mContext.showToast(this.ZB.pl());
                                return;
                            }
                            return;
                        }
                        boolean a2 = a(this.ZB);
                        if (a2 && !this.YV) {
                            qm();
                            this.Zq.setStyle(this.ZB.pj() ? 4 : 3);
                            this.Za.setStyleEnabled(false);
                            this.ZH.setVisibility(8);
                            return;
                        }
                        this.Zq.setEnabled(true);
                        if (this.ZB.ps()) {
                            this.ZH.setVisibility(8);
                            this.ZK.rh();
                            if (this.ZB.pp() == 6 && this.XT < 3) {
                                i3 = 3;
                            } else if (this.ZB.pp() == 7 && this.XT < 7) {
                                i3 = 7;
                            } else if (this.ZB.pp() == 8 && this.XT < 13) {
                                i3 = 13;
                            } else if (this.ZB.pp() == 9 && this.XT < 22) {
                                i3 = 22;
                            } else if (this.ZB.pp() == 10 && this.XT < 29) {
                                i3 = 29;
                            } else if (this.ZB.pp() == 11 && this.XT < 39) {
                                i3 = 39;
                            } else if (this.ZB.pp() == 12 && this.XT < 47) {
                                i3 = 47;
                            }
                        }
                        boolean z4 = i3 == -1;
                        if (z4) {
                            this.Zq.setStyle(this.ZB.pj() ? 2 : 1);
                        } else {
                            this.Zq.setStyle(this.ZB.pj() ? 4 : 3);
                        }
                        this.Za.setStyleEnabled(z4);
                        i2 = i3;
                        z = a2;
                    } else {
                        this.Zq.setStyle(this.ZB.pj() ? 2 : 1);
                        if (this.ZB.Wo != null && this.ZB.Wo.Wr != null && this.ZB.Wo.Wr.equals("20")) {
                            this.Zq.setText("使用");
                        } else {
                            this.Zq.setText("赠送");
                        }
                        this.Za.setStyleEnabled(true);
                        i2 = -1;
                        z = false;
                    }
                    if (this.ZB.pk()) {
                        an(true);
                        this.ZJ.setVisibility(8);
                    } else {
                        an(false);
                    }
                    if (this.mType == 0) {
                        if (this.ZB.pn() && !com.baidu.live.gift.b.b.rd().ci(this.ZB.pc())) {
                            BdUtilHelper.showLongToast(this.mContext.getPageActivity(), this.mContext.getString(a.i.send_undownload_gift_toast));
                            return;
                        }
                        if (TextUtils.isEmpty(this.ZB.pl()) || !this.ZB.pq() || z) {
                            z2 = false;
                        } else {
                            this.mContext.showToast(this.ZB.pl());
                            z2 = true;
                        }
                        if (z2 || !this.ZB.ps() || i2 == -1) {
                            z3 = z2;
                        } else {
                            this.mContext.showToast(String.format(this.mContext.getString(a.i.send_family_level_gift_toast_live), Integer.valueOf(i2)));
                        }
                        if (!z3 && this.ZB.po()) {
                            BdUtilHelper.showLongToast(this.mContext.getPageActivity(), this.mContext.getString(a.i.send_broadcast_gift_toast));
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.Zq.setStyle(3);
                return;
            }
            this.Zq.setStyle(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(g gVar) {
        if (com.baidu.live.l.a.uB().aku != null && com.baidu.live.l.a.uB().aku.TJ != null) {
            String str = com.baidu.live.l.a.uB().aku.TJ.Te;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.pp()))) {
                return true;
            }
        }
        return false;
    }

    private void qm() {
        if (!this.Zz) {
            this.ZV = new com.baidu.live.view.d(this.mContext.getPageActivity());
            this.ZV.setCancelable(false);
            this.ZV.setCanceledOnTouchOutside(false);
            this.ZV.aU(false);
            this.ZV.k(this.mContext.getPageActivity().getString(a.i.need_join_guard_club_title), String.format(this.mContext.getPageActivity().getString(a.i.need_join_guard_club_content), Integer.valueOf(this.ZP)), this.mContext.getPageActivity().getString(a.i.ala_gift_join_now), this.mContext.getPageActivity().getString(a.i.ala_gift_think));
            this.ZV.setTitleTextColor(ViewCompat.MEASURED_STATE_MASK);
            this.ZV.cp(-10066330);
            this.ZV.cq(ViewCompat.MEASURED_STATE_MASK);
            this.ZV.a(new d.a() { // from class: com.baidu.live.gift.container.AlaGiftTabView.12
                @Override // com.baidu.live.view.d.a
                public void qy() {
                    AlaGiftTabView.this.Zz = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913119));
                }

                @Override // com.baidu.live.view.d.a
                public void qz() {
                    AlaGiftTabView.this.Zz = false;
                }
            });
            this.ZV.show();
            this.Zz = true;
            LogManager.getGuardClubLogger().doDisplayLiveGiftPopupLog(null, null, null, this.otherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an(boolean z) {
        int i = 0;
        if (z && com.baidu.live.l.a.uB().ajF.Qz) {
            if (Build.VERSION.SDK_INT != 26) {
                this.mContext.getPageActivity().setRequestedOrientation(1);
                this.ZW = true;
            }
            this.ZH.setVisibility(0);
            this.ZK.setTipImageVisibility(0);
            this.ZK.rh();
            BdResourceLoader.getInstance().loadResource(this.ZB.pf(), 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.gift.container.AlaGiftTabView.13
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                public void onLoaded(BdImage bdImage, String str, int i2) {
                    super.onLoaded((AnonymousClass13) bdImage, str, i2);
                    if (bdImage == null || bdImage.getRawBitmap() == null) {
                        BdUtilHelper.showToast(AlaGiftTabView.this.mContext.getPageActivity(), AlaGiftTabView.this.mContext.getPageActivity().getString(a.i.ala_gift_noimage_tip));
                    } else if (str != null && str.equals(AlaGiftTabView.this.ZB.pf())) {
                        AlaGiftTabView.this.ZK.setGiftBitmp(bdImage.getRawBitmap());
                    }
                }
            }, null);
            this.YZ.setVisibility(4);
            this.Zq.setStyle(1);
            return;
        }
        if (Build.VERSION.SDK_INT != 26 && this.ZW) {
            this.mContext.getPageActivity().setRequestedOrientation(3);
            this.ZW = false;
        }
        this.ZH.setVisibility(8);
        this.ZK.rh();
        View view = this.YZ;
        if (this.ZB == null || !this.ZB.pj()) {
            i = 4;
        }
        view.setVisibility(i);
    }

    public boolean qn() {
        return this.ZG.getVisibility() == 0;
    }

    public void bk(int i) {
        if (this.ZG != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ZG.getLayoutParams();
            layoutParams.topMargin = i;
            this.ZG.setLayoutParams(layoutParams);
        }
    }

    public void qo() {
        this.ZG.tI();
        this.ZG.getEditView().setFocusable(true);
        this.ZG.getEditView().setFocusableInTouchMode(true);
        this.ZG.getEditView().postDelayed(this.aab, 100L);
    }

    public void qp() {
        this.ZG.setVisibility(8);
        this.ZG.getEditView().post(this.aac);
    }

    public AlaLiveInputEditView qq() {
        return this.ZG;
    }

    @Override // com.baidu.live.view.input.b.a
    public void cs(String str) {
        qp();
        if (JavaTypesHelper.toInt(str, 0) <= 0) {
            str = "1";
        }
        ct(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ct(String str) {
        this.Zb.setText(str);
        this.Zb.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(str.length() >= 4 ? a.e.sdk_fontsize20 : a.e.sdk_fontsize24));
        ao(false);
        if (this.ZB != null && this.ZB.pj()) {
            this.YZ.setVisibility(0);
            this.ZC = JavaTypesHelper.toInt(this.Zb.getText().toString(), 1);
            return;
        }
        this.YZ.setVisibility(4);
        this.ZC = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao(boolean z) {
        this.Zb.setGravity(17);
        if (z) {
            this.Zb.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_icon_tabbar_arrow_down, 0);
        } else {
            this.Zb.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_icon_tabbar_arrow_up, 0);
        }
    }

    public void a(boolean z, ArrayList<h> arrayList, ArrayList<com.baidu.live.gift.a.a> arrayList2, ArrayList<com.baidu.live.gift.a.b> arrayList3, boolean z2) {
        this.YM = arrayList;
        this.YN = arrayList2;
        this.YO = arrayList3;
        this.Zy = false;
        if (this.YN == null || this.YN.isEmpty()) {
            this.Ze.setVisibility(8);
        }
        e(z, z2);
    }

    public void l(String str, int i) {
        if (!TextUtils.isEmpty(str) && this.mType == 1 && this.Zs != null) {
            for (View view : this.Zs) {
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
                                ((com.baidu.live.gift.container.a) ((GridView) childAt).getAdapter()).l(str, i);
                            }
                        }
                    }
                }
            }
        }
    }

    public void e(boolean z, boolean z2) {
        qr();
        qx();
        if (this.YM == null || this.YM.size() <= 0 || !z2) {
            kr();
            if (this.Zd != null) {
                this.Zd.setVisibility(4);
            }
            this.Zk.setVisibility(4);
            this.Zh.reset();
            this.Zh.setTitle(a.i.sdk_net_fail_tip_rank);
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                this.Zh.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            } else {
                this.Zh.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            this.Zh.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaGiftTabView.this.Zu != null) {
                        AlaGiftTabView.this.Zu.qA();
                    }
                }
            });
            this.Zh.setVisibility(0);
            return;
        }
        this.Zh.setVisibility(8);
        this.Zk.setVisibility(0);
        this.Zg.setVisibility(0);
        if (z) {
            f(this.YN);
        }
        c(this.YM, z);
        ct("1");
    }

    private void kr() {
        this.Zv = 0;
        this.Zw = 0;
        this.mSelectedPosition = 0;
        this.Zx = 0;
        if (this.ZD != null) {
            this.ZD.clear();
        }
        if (this.Zs != null) {
            this.Zs.clear();
        }
        if (this.Zc != null) {
            this.Zc.setAdapter(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar) {
        if (gVar == null) {
            return false;
        }
        if (!a(this.ZB) || this.YV) {
            if (gVar.ps()) {
                if (gVar.pp() == 6 && this.XT < 3) {
                    return false;
                }
                if (gVar.pp() == 7 && this.XT < 7) {
                    return false;
                }
                if (gVar.pp() == 8 && this.XT < 13) {
                    return false;
                }
                if (gVar.pp() == 9 && this.XT < 22) {
                    return false;
                }
                if (gVar.pp() == 10 && this.XT < 29) {
                    return false;
                }
                if (gVar.pp() == 11 && this.XT < 39) {
                    return false;
                }
                if (gVar.pp() == 12 && this.XT < 47) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private void qr() {
        if (ListUtils.getCount(this.YN) != 0 && ListUtils.getCount(this.YM) != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<com.baidu.live.gift.a.a> it = this.YN.iterator();
            while (it.hasNext()) {
                com.baidu.live.gift.a.a next = it.next();
                if (next != null && (TextUtils.isEmpty(next.getCategoryName()) || (this.mType == 0 && ListUtils.getCount(next.qC()) == 0))) {
                    arrayList.add(next);
                    Iterator<h> it2 = this.YM.iterator();
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
                Iterator<h> it3 = this.YM.iterator();
                while (it3.hasNext()) {
                    ListIterator<g> listIterator = it3.next().pt().listIterator();
                    while (listIterator.hasNext()) {
                        g next3 = listIterator.next();
                        if (next3 != null && next3.pk()) {
                            listIterator.remove();
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                this.YN.removeAll(arrayList);
            }
            if (arrayList2.size() > 0) {
                this.YM.removeAll(arrayList2);
            }
        }
    }

    private void c(ArrayList<h> arrayList, boolean z) {
        boolean z2;
        int i;
        ArrayList subList;
        int i2;
        int i3;
        g gVar;
        List<g> pt;
        if (arrayList != null) {
            this.ZD.clear();
            this.Zs.clear();
            this.Zc.setAdapter(null);
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
                    if (hVar == null || (pt = hVar.pt()) == null || pt.isEmpty()) {
                        i4 = i5 + 1;
                    } else {
                        z2 = false;
                        break;
                    }
                }
            }
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= arrayList.size()) {
                    break;
                }
                if (z2) {
                    this.Zs.add(bl(i7));
                    this.ZD.append(i7, 1);
                } else {
                    h hVar2 = arrayList.get(i7);
                    int categoryId = hVar2.getCategoryId();
                    List<g> pt2 = hVar2.pt();
                    if (pt2 == null) {
                        i = 0;
                    } else {
                        i = pt2.size();
                    }
                    int i8 = 0;
                    if (i <= 0) {
                        i8 = 1;
                        ArrayList arrayList2 = new ArrayList();
                        if (this.ZE.get(i7)) {
                            this.Zs.add(ap(true));
                        } else {
                            this.Zs.add(b(arrayList2, -1, i7));
                        }
                    } else if (pt2 != null) {
                        int i9 = this.isLandscape ? 12 : 8;
                        int ceil = (int) Math.ceil(i / i9);
                        for (int i10 = 0; i10 < ceil; i10++) {
                            if (i10 == ceil - 1) {
                                if (i10 * i9 == i - 1) {
                                    ArrayList arrayList3 = new ArrayList();
                                    arrayList3.add(pt2.get(i - 1));
                                    subList = arrayList3;
                                } else {
                                    subList = pt2.subList(i10 * i9, i);
                                }
                            } else {
                                subList = pt2.subList(i10 * i9, (i10 + 1) * i9);
                            }
                            if (i7 == 0 && i10 == 0 && z) {
                                this.Zs.add(b(subList, 0, i7));
                                this.ZB = subList.get(0);
                                this.ZH.removeCallbacks(null);
                                this.ZH.postDelayed(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        boolean pk = AlaGiftTabView.this.ZB.pk();
                                        AlaGiftTabView.this.an(pk);
                                        if (!pk) {
                                            boolean b2 = AlaGiftTabView.this.b(AlaGiftTabView.this.ZB);
                                            if (!b2) {
                                                AlaGiftTabView.this.Zq.setStyle(AlaGiftTabView.this.ZB.pj() ? 4 : 3);
                                            } else {
                                                AlaGiftTabView.this.Zq.setStyle(AlaGiftTabView.this.ZB.pj() ? 2 : 1);
                                            }
                                            AlaGiftTabView.this.Za.setStyleEnabled(b2);
                                        }
                                    }
                                }, 100L);
                            } else {
                                if (this.ZM != categoryId || ListUtils.isEmpty(subList)) {
                                    i2 = -1;
                                } else {
                                    int i11 = 0;
                                    while (true) {
                                        i3 = i11;
                                        if (i3 >= subList.size()) {
                                            gVar = null;
                                            i3 = -1;
                                            break;
                                        }
                                        gVar = subList.get(i3);
                                        if (gVar == null || !gVar.pc().equals(String.valueOf(this.ZN))) {
                                            i11 = i3 + 1;
                                        } else {
                                            this.mSelectedPosition = i3;
                                            break;
                                        }
                                    }
                                    if (gVar == null && subList.size() > 0) {
                                        gVar = subList.get(0);
                                    }
                                    if (gVar != null) {
                                        this.ZB = gVar;
                                    }
                                    i2 = i3;
                                }
                                this.Zs.add(b(subList, i2, i7));
                            }
                        }
                        i8 = ceil;
                    }
                    this.ZD.append(i7, i8);
                }
                i6 = i7 + 1;
            }
            this.Zt = new AlaGiftPagerAdapter(this.Zs);
            this.Zc.setAdapter(this.Zt);
            qs();
            this.Zc.setCurrentItem(this.Zv);
            qt();
            if (this.Zx == 0) {
                onPageSelected(0);
            }
        }
    }

    private void qs() {
        if (!this.ZO && this.ZM >= 0 && !ListUtils.isEmpty(this.YN)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.YN.size()) {
                    break;
                }
                com.baidu.live.gift.a.a aVar = this.YN.get(i2);
                if (aVar == null || this.ZM != aVar.getCategoryId()) {
                    i = i2 + 1;
                } else {
                    bj(i2);
                    break;
                }
            }
            this.Zw = this.Zv;
            this.ZO = true;
        }
    }

    private View ap(boolean z) {
        FrameLayout frameLayout = new FrameLayout(this.mContext.getPageActivity());
        CommonEmptyView commonEmptyView = new CommonEmptyView(this.mContext.getPageActivity());
        commonEmptyView.setTitle(a.i.sdk_net_fail_tip_rank);
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            commonEmptyView.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
        } else {
            commonEmptyView.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        commonEmptyView.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.Zu != null) {
                    AlaGiftTabView.this.Zu.qA();
                }
            }
        });
        commonEmptyView.addToParent(frameLayout);
        return frameLayout;
    }

    private FrameLayout b(List<g> list, int i, int i2) {
        FrameLayout frameLayout = new FrameLayout(this.mContext.getPageActivity());
        com.baidu.live.gift.container.a aVar = new com.baidu.live.gift.container.a(this.mContext, this.mType);
        aVar.ak(this.XV);
        aVar.setGiftItems(list);
        aVar.bc(this.XT);
        aVar.bd(i);
        if (this.isLandscape) {
            aVar.be(this.ZU / 3);
        }
        BdGridView bdGridView = new BdGridView(this.mContext.getPageActivity());
        bdGridView.setNumColumns(4);
        bdGridView.setVerticalScrollBarEnabled(false);
        bdGridView.setSelector(a.d.sdk_transparent);
        bdGridView.setAdapter((ListAdapter) aVar);
        bdGridView.setOnItemClickListener(new a());
        bdGridView.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.4
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                Object tag = view.getTag();
                if (tag instanceof a.C0064a) {
                    ((a.C0064a) tag).recycle();
                }
            }
        });
        frameLayout.addView(bdGridView, new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    private FrameLayout bl(int i) {
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
    private void f(ArrayList<com.baidu.live.gift.a.a> arrayList) {
        boolean z;
        if (arrayList != null && arrayList.size() > 0) {
            if (!this.ZL) {
                this.Ze.setVisibility(0);
            }
            this.Zf.removeAllViews();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                com.baidu.live.gift.a.a aVar = arrayList.get(i);
                if (!TextUtils.isEmpty(aVar.getCategoryName()) && (this.mType != 0 || (aVar.qC() != null && aVar.qC().size() > 0))) {
                    ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.ala_gift_tab_item, (ViewGroup) null);
                    GradientTextView gradientTextView = (GradientTextView) viewGroup.findViewById(a.g.text_view);
                    gradientTextView.setCheckStrEquals(false);
                    gradientTextView.setText(aVar.getCategoryName());
                    viewGroup.setOnClickListener(new b(i));
                    if (i != 0) {
                        layoutParams.leftMargin = this.ZA;
                    }
                    if (this.YM.size() > i && this.YM.get(i) != null) {
                        for (g gVar : this.YM.get(i).pt()) {
                            if (gVar != null && gVar.pi() != 6) {
                                z = false;
                                break;
                            }
                        }
                    }
                    z = true;
                    viewGroup.setTag(Boolean.valueOf(z));
                    this.Zf.addView(viewGroup, layoutParams);
                }
            }
            bm(this.Zx);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x01c8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01f3  */
    @SuppressLint({"ResourceAsColor"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void bm(int i) {
        JSONArray jSONArray;
        JSONException e;
        List<g> pt;
        int childCount = this.Zf.getChildCount();
        if (i >= 0 && i < childCount) {
            if ((this.Zx != i || !this.Zy) && this.YN.size() > i && this.YN.get(i) != null) {
                int min = Math.min(i, this.ZD.size());
                int i2 = 0;
                for (int i3 = 0; i3 < min; i3++) {
                    i2 += this.ZD.get(i3);
                }
                if (this.Zs.size() > i2 && this.YM.size() > i && (this.Zs.get(i2) instanceof ViewGroup)) {
                    this.Zw = i2;
                    h hVar = this.YM.get(i);
                    if (hVar != null && hVar.pt() != null && !hVar.pt().isEmpty()) {
                        this.ZB = this.YM.get(i).pt().get(0);
                        ViewGroup viewGroup = (ViewGroup) this.Zs.get(i2);
                        int i4 = 0;
                        while (true) {
                            if (i4 >= viewGroup.getChildCount()) {
                                break;
                            } else if (!(viewGroup.getChildAt(i4) instanceof GridView)) {
                                i4++;
                            } else {
                                com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) ((GridView) viewGroup.getChildAt(i4)).getAdapter();
                                if (this.ZB != null && aVar != null) {
                                    a(aVar, 0);
                                    if (this.ZT) {
                                        this.Zy = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (this.YN.size() > i && this.YN.get(i) != null) {
                int categoryId = this.YN.get(i).getCategoryId();
                if (!this.ZQ.get(categoryId)) {
                    LogManager.getGiftLogger().doDisplayGiftTabLog(null, this.otherParams, String.valueOf(categoryId));
                    this.ZQ.put(categoryId, true);
                }
            }
            for (int i5 = 0; i5 < childCount; i5++) {
                ViewGroup viewGroup2 = (ViewGroup) this.Zf.getChildAt(i5);
                GradientTextView gradientTextView = (GradientTextView) viewGroup2.findViewById(a.g.text_view);
                ImageView imageView = (ImageView) viewGroup2.findViewById(a.g.icon_new_unlock_gift);
                imageView.setVisibility(8);
                h hVar2 = this.YM.get(i5);
                if (hVar2.pu()) {
                    HashSet hashSet = new HashSet();
                    String string = SharedPrefHelper.getInstance().getString(this.YS, "");
                    if (TextUtils.isEmpty(string)) {
                        jSONArray = null;
                    } else {
                        try {
                            jSONArray = new JSONArray(string);
                            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                                try {
                                    hashSet.add(jSONArray.optString(i6));
                                } catch (JSONException e2) {
                                    e = e2;
                                    e.printStackTrace();
                                    pt = hVar2.pt();
                                    if (pt != null) {
                                    }
                                    if (i5 == i) {
                                    }
                                    if (i5 == i) {
                                    }
                                }
                            }
                        } catch (JSONException e3) {
                            jSONArray = null;
                            e = e3;
                        }
                    }
                    pt = hVar2.pt();
                    if (pt != null) {
                        ArrayList arrayList = new ArrayList();
                        int i7 = 0;
                        while (true) {
                            int i8 = i7;
                            if (i8 >= pt.size()) {
                                break;
                            }
                            g gVar = pt.get(i8);
                            if (!gVar.pq() && !hashSet.contains(gVar.pc())) {
                                arrayList.add(gVar.pc());
                            }
                            i7 = i8 + 1;
                        }
                        if (!arrayList.isEmpty()) {
                            if (i5 != i) {
                                imageView.setVisibility(0);
                            } else {
                                if (jSONArray == null) {
                                    jSONArray = new JSONArray();
                                }
                                for (int i9 = 0; i9 < arrayList.size(); i9++) {
                                    jSONArray.put(arrayList.get(i9));
                                }
                                SharedPrefHelper.getInstance().putString(this.YS, jSONArray.toString());
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
                    gradientTextView.setGradientTextColor(-57754, -39399);
                    gradientTextView.setTypeface(Typeface.defaultFromStyle(1));
                    bn(i);
                    this.Zx = i;
                    this.Ze.scrollTo(viewGroup2.getLeft(), 0);
                }
                if (i5 == i) {
                    if (viewGroup2.getTag() instanceof Boolean) {
                        if (((Boolean) viewGroup2.getTag()).booleanValue()) {
                            aq(false);
                        } else {
                            aq(true);
                        }
                    } else {
                        aq(true);
                    }
                }
            }
        }
    }

    private void aq(boolean z) {
        int i = 8;
        if (this.Zn != null) {
            this.Zn.setVisibility(z ? this.ZS ? 8 : 0 : 8);
        }
        if (this.Zo != null) {
            TextView textView = this.Zo;
            if (!z && !this.ZS) {
                i = 0;
            }
            textView.setVisibility(i);
        }
    }

    private void bn(int i) {
        int childCount = this.Zf.getChildCount();
        if (i >= 0 && i < childCount && this.YM != null && this.YM.size() > i && this.YM.get(i) != null) {
            this.ZE.get(i);
        }
    }

    public void n(int i, int i2) {
        this.ZM = i;
        this.ZN = i2;
    }

    public void w(long j) {
        if (this.Zn != null) {
            if (j >= 100 && (this.XV || com.baidu.live.l.a.uB().ajF.Ry)) {
                this.Zn.setText(new DecimalFormat("0.###K").format(JavaTypesHelper.toDouble(String.valueOf(j), 0.0d) / 1000.0d));
                return;
            }
            this.Zn.setText(String.valueOf(j));
        }
    }

    public void x(long j) {
        if (this.Zo != null) {
            this.Zo.setText(String.valueOf(j));
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
        this.Zv = i;
        qt();
        if (i >= 0 && i < this.Zs.size() && (this.Zs.get(i) instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) this.Zs.get(i);
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                if (viewGroup.getChildAt(i2) instanceof GridView) {
                    GridView gridView = (GridView) viewGroup.getChildAt(i2);
                    if (gridView.getAdapter() != null) {
                        com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) gridView.getAdapter();
                        if (aVar.qe() >= 0 && i != this.Zw) {
                            aVar.bd(-1);
                        }
                        if (aVar.qe() < 0 && i == this.Zw) {
                            aVar.bd(this.mSelectedPosition);
                        }
                        aVar.notifyDataSetChanged();
                        this.Zk.setVisibility(aVar.getCount() <= 0 ? 4 : 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private void qt() {
        int i = 0;
        for (int i2 = 0; i2 < this.ZD.size(); i2++) {
            for (int i3 = 0; i3 < this.ZD.get(i2); i3++) {
                if (i + i3 == this.Zv) {
                    if (this.ZD.get(i2) <= 1) {
                        this.Zd.setVisibility(4);
                    } else {
                        this.Zd.setVisibility(0);
                    }
                    this.Zd.setCount(this.ZD.get(i2));
                    this.Zd.onPageSelected(i3);
                    bm(i2);
                    return;
                }
            }
            i += this.ZD.get(i2);
        }
    }

    public g qu() {
        return this.ZB;
    }

    public k qv() {
        k kVar = new k();
        kVar.WW = BdUtilHelper.dip2px(this.mContext.getPageActivity(), 32.0f);
        kVar.WX.addAll(this.ZK.getPoints());
        kVar.WU = this.ZK.getMeasuredHeight();
        kVar.WT = this.ZK.getMeasuredWidth();
        Rect rect = new Rect();
        this.ZK.getGlobalVisibleRect(rect);
        kVar.WR = rect.left;
        kVar.WS = rect.top;
        kVar.WY = kVar.WX.size();
        kVar.WZ = new Rect(0, 0, rect.width(), rect.height());
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext.getPageActivity());
        kVar.WP = screenDimensions[0];
        kVar.WQ = screenDimensions[1];
        return kVar;
    }

    public int qw() {
        return this.ZC;
    }

    public void a(DialogInterface.OnCancelListener onCancelListener) {
    }

    public void qx() {
    }

    public void a(c cVar) {
        this.Zu = cVar;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.aae);
        MessageManager.getInstance().registerListener(this.aaf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cu(final String str) {
        if (!ListUtils.isEmpty(this.Zs) && !TextUtils.isEmpty(str)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.8
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.Zs) {
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
                                        ((com.baidu.live.gift.container.a) gridView.getAdapter()).a(gridView, str);
                                    }
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aae);
        MessageManager.getInstance().unRegisterListener(this.aaf);
        if (this.ZV != null) {
            this.ZV.dismiss();
        }
    }

    public void ak(boolean z) {
        this.XV = z;
    }

    public void bo(int i) {
        this.XT = i;
    }
}

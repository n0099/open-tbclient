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
    private int Yl;
    private boolean Yn;
    private FrameLayout ZA;
    private FrameLayout ZB;
    private View ZC;
    private com.baidu.live.gift.container.c ZD;
    public GiftPanelTabView ZE;
    private TextView ZF;
    private TextView ZG;
    private TextView ZH;
    public GiftPanelOperationSendView ZI;
    private ImageButton ZJ;
    private List<View> ZK;
    private AlaGiftPagerAdapter ZL;
    private c ZM;
    private int ZN;
    private int ZO;
    private int ZP;
    private boolean ZQ;
    private boolean ZR;
    private int ZS;
    private g ZT;
    private int ZU;
    private SparseIntArray ZV;
    private SparseBooleanArray ZW;
    private View.OnClickListener ZX;
    private AlaLiveInputEditView ZY;
    private ViewGroup ZZ;
    public ArrayList<h> Ze;
    private ArrayList<com.baidu.live.gift.a.a> Zf;
    private ArrayList<com.baidu.live.gift.a.b> Zg;
    private final String Zk;
    private final int Zl;
    private final int Zm;
    private boolean Zn;
    private ViewGroup Zo;
    protected ViewGroup Zp;
    protected ViewGroup Zq;
    protected View Zr;
    private GiftPanelNumRoundRectView Zs;
    public TextView Zt;
    protected BaseViewPager Zu;
    protected RoundRectPageIndicator Zv;
    protected HorizontalScrollView Zw;
    protected LinearLayout Zx;
    protected View Zy;
    private CommonEmptyView Zz;
    private ImageButton aaa;
    private TextView aab;
    private AlaGiftDrawPanel aac;
    private boolean aad;
    private int aae;
    private int aaf;
    private boolean aag;
    private int aah;
    private SparseBooleanArray aai;
    private Set<String> aaj;
    private boolean aak;
    private boolean aal;
    private int aam;
    private com.baidu.live.view.d aan;
    private boolean aao;
    private int aap;
    private View.OnClickListener aaq;
    private View.OnClickListener aar;
    AdapterView.OnItemClickListener aas;
    Runnable aat;
    Runnable aau;
    private AlaGiftDrawPanel.a aav;
    CustomMessageListener aaw;
    CustomMessageListener aax;
    private boolean isLandscape;
    private TbPageContext mContext;
    private int mSelectedPosition;
    private int mType;
    private String otherParams;

    /* loaded from: classes6.dex */
    public interface c {
        void qz();
    }

    public AlaGiftTabView(TbPageContext tbPageContext, View.OnClickListener onClickListener, boolean z, String str) {
        this.Zk = "live_key_privilege_tab_unlock_giftid_array_" + (TbadkCoreApplication.getCurrentAccountInfo() == null ? "" : TbadkCoreApplication.getCurrentAccountInfo().getID());
        this.Zl = 10;
        this.Zm = 100;
        this.ZK = new ArrayList();
        this.ZN = 0;
        this.ZO = 0;
        this.mSelectedPosition = 0;
        this.ZP = 0;
        this.ZV = new SparseIntArray();
        this.ZW = new SparseBooleanArray();
        this.isLandscape = false;
        this.aad = false;
        this.aae = -1;
        this.aaf = -1;
        this.aag = false;
        this.Yn = false;
        this.Yl = -1;
        this.aai = new SparseBooleanArray();
        this.aaj = new HashSet();
        this.aao = false;
        this.aaq = new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.ZD == null) {
                    AlaGiftTabView.this.ZD = new com.baidu.live.gift.container.c(AlaGiftTabView.this.mContext, AlaGiftTabView.this.mType, AlaGiftTabView.this.aas);
                }
                AlaGiftTabView.this.ao(true);
                AlaGiftTabView.this.ZD.a(AlaGiftTabView.this.Zr, AlaGiftTabView.this.Zg, AlaGiftTabView.this.isLandscape, new PopupWindow.OnDismissListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.9.1
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public void onDismiss() {
                        AlaGiftTabView.this.ao(false);
                    }
                });
            }
        };
        this.aar = new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaGiftTabView.this.aaa.setEnabled(false);
                AlaGiftTabView.this.aac.rg();
            }
        };
        this.aas = new AdapterView.OnItemClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.11
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                g.a aVar;
                AlaGiftTabView.this.ZD.dismiss();
                if (AlaGiftTabView.this.Zg == null || AlaGiftTabView.this.Zg.size() <= 0) {
                    AlaGiftTabView.this.ct("1");
                } else if (i != AlaGiftTabView.this.Zg.size()) {
                    com.baidu.live.gift.a.b bVar = (com.baidu.live.gift.a.b) AlaGiftTabView.this.Zg.get(i);
                    if (bVar != null) {
                        int number = bVar.getNumber();
                        if (AlaGiftTabView.this.mType == 1 && (aVar = AlaGiftTabView.this.ZT.WH) != null) {
                            if (number == -1) {
                                number = aVar.WL;
                            }
                            if (number > AlaGiftTabView.this.aap) {
                                number = AlaGiftTabView.this.aap;
                            }
                        }
                        AlaGiftTabView.this.ct(String.valueOf(number));
                    }
                } else {
                    AlaGiftTabView.this.qn();
                }
            }
        };
        this.aat = new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.14
            @Override // java.lang.Runnable
            public void run() {
                AlaGiftTabView.this.ZY.getEditView().requestFocus();
                AlaGiftTabView.this.ZY.getEditView().requestFocusFromTouch();
                BdUtilHelper.showSoftKeyPad(AlaGiftTabView.this.mContext.getPageActivity(), AlaGiftTabView.this.ZY.getEditView());
            }
        };
        this.aau = new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.15
            @Override // java.lang.Runnable
            public void run() {
                BdUtilHelper.hideSoftKeyPad(AlaGiftTabView.this.mContext.getPageActivity(), AlaGiftTabView.this.ZY.getEditView());
            }
        };
        this.aav = new AlaGiftDrawPanel.a() { // from class: com.baidu.live.gift.container.AlaGiftTabView.5
            @Override // com.baidu.live.gift.graffitiGift.AlaGiftDrawPanel.a
            public void bp(int i) {
                AlaGiftTabView.this.aab.setText(String.format(AlaGiftTabView.this.mContext.getString(a.i.ala_gift_draw_title_drawing), Integer.valueOf(i), AlaGiftTabView.this.ZT.pd(), Long.valueOf(JavaTypesHelper.toLong(AlaGiftTabView.this.ZT.getPrice(), 0L) * i)));
                int dimensionPixelOffset = AlaGiftTabView.this.mContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_ds22);
                Drawable drawable = AlaGiftTabView.this.mContext.getPageActivity().getResources().getDrawable(a.f.sdk_icon_huobi_tdou18);
                drawable.setBounds(0, 0, dimensionPixelOffset, dimensionPixelOffset);
                AlaGiftTabView.this.aab.setCompoundDrawables(null, null, drawable, null);
                if (i > 0) {
                    AlaGiftTabView.this.aaa.setEnabled(true);
                    AlaGiftTabView.this.aac.setTipImageVisibility(8);
                    AlaGiftTabView.this.Zr.setVisibility(4);
                    AlaGiftTabView.this.aab.setVisibility(0);
                } else {
                    AlaGiftTabView.this.aac.setTipImageVisibility(0);
                    AlaGiftTabView.this.aab.setVisibility(8);
                    AlaGiftTabView.this.aaa.setEnabled(false);
                }
                AlaGiftTabView.this.ZU = i;
            }
        };
        this.aaw = new CustomMessageListener(2913078) { // from class: com.baidu.live.gift.container.AlaGiftTabView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.d.c)) {
                    com.baidu.live.d.c cVar = (com.baidu.live.d.c) customResponsedMessage.getData();
                    if ((cVar.Vz == 1 || cVar.Vz == 2 || cVar.Vz == 5 || cVar.Vz == 6) && cVar.VA != null) {
                        AlaGiftTabView.this.cu(cVar.VA.getId());
                    }
                }
            }
        };
        this.aax = new CustomMessageListener(2913120) { // from class: com.baidu.live.gift.container.AlaGiftTabView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaGiftTabView.this.am(true);
                if (AlaGiftTabView.this.ZT != null && AlaGiftTabView.this.a(AlaGiftTabView.this.ZT) && AlaGiftTabView.this.Zn) {
                    AlaGiftTabView.this.ZI.setStyle(AlaGiftTabView.this.ZT.pj() ? 2 : 1);
                    AlaGiftTabView.this.Zs.setStyleEnabled(true);
                }
            }
        };
        this.mContext = tbPageContext;
        this.otherParams = str;
        this.ZX = onClickListener;
        this.aad = z;
        this.Zo = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.live_gift_panel_fragment, (ViewGroup) null);
        this.isLandscape = 2 == UtilHelper.getRealScreenOrientation(this.mContext.getPageActivity());
        initViews();
        initListener();
        this.ZS = BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds36);
        if (this.isLandscape) {
            this.aam = (ScreenHelper.getRealScreenHeight(this.mContext.getPageActivity()) - (BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds112) * 2)) - BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds16);
            this.Zu.getLayoutParams().height = this.aam;
        } else {
            this.Zu.getLayoutParams().height = BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds192) * 2;
        }
        this.Zu.requestLayout();
    }

    public void setType(int i) {
        this.mType = i;
        switch (this.mType) {
            case 0:
                this.aap = 9999;
                break;
            case 1:
                this.aap = 999;
                break;
        }
        this.ZY.setMaxText(String.valueOf(this.aap));
        this.ZY.setHintText(String.format(Locale.getDefault(), this.mContext.getString(a.i.ala_send_gift_count_hint), Integer.valueOf(this.aap)));
    }

    public void al(boolean z) {
        this.aal = z;
    }

    public void onVisibilityChanged(boolean z) {
        al(z);
        if (z) {
            bi(this.ZP);
        }
    }

    public View getRootView() {
        return this.Zo;
    }

    private void initViews() {
        int realScreenHeight = ScreenHelper.getRealScreenHeight(this.mContext.getPageActivity());
        this.Zp = (ViewGroup) this.Zo.findViewById(a.g.gift_list_layout);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(this.mContext.getResources().getColor(a.d.live_gift_panel_primary));
        float dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        if (this.isLandscape) {
            gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
        } else {
            gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
        }
        this.Zp.setBackgroundDrawable(gradientDrawable);
        this.Zp.getLayoutParams().width = realScreenHeight;
        this.Zq = (ViewGroup) this.Zo.findViewById(a.g.gift_tab_input_parent);
        this.Zr = this.Zo.findViewById(a.g.gift_count_layout);
        this.Zr.setOnClickListener(this.aaq);
        this.Zs = (GiftPanelNumRoundRectView) this.Zo.findViewById(a.g.gift_count_round);
        this.Zt = (TextView) this.Zo.findViewById(a.g.gift_count_input);
        this.Zt.setText("1");
        this.Zt.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
        this.Zy = this.Zo.findViewById(a.g.gift_lower_layout);
        this.Zu = (BaseViewPager) this.Zo.findViewById(a.g.gift_viewpager);
        this.Zu.setOnPageChangeListener(this);
        this.Zv = (RoundRectPageIndicator) this.Zo.findViewById(a.g.gift_tab_indicator);
        this.Zx = (LinearLayout) this.Zo.findViewById(a.g.gift_tab_layout);
        this.Zw = (HorizontalScrollView) this.Zo.findViewById(a.g.gift_tab_scrollview);
        if (this.aad) {
            this.Zw.setVisibility(8);
        }
        this.ZF = (TextView) this.Zo.findViewById(a.g.current_money);
        int dimensionPixelOffset2 = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds22);
        Drawable drawable = this.mContext.getResources().getDrawable(a.f.sdk_icon_huobi_tdou18);
        drawable.setBounds(0, 0, dimensionPixelOffset2, dimensionPixelOffset2);
        this.ZF.setCompoundDrawables(drawable, null, null, null);
        this.ZF.setOnClickListener(this.ZX);
        this.ZG = (TextView) this.Zo.findViewById(a.g.current_flower);
        this.ZG.setOnClickListener(this.ZX);
        this.ZI = (GiftPanelOperationSendView) this.Zo.findViewById(a.g.donate);
        this.ZH = (TextView) this.Zo.findViewById(a.g.current_recharge);
        this.ZH.setOnClickListener(this.ZX);
        this.ZI.setOnClickListener(this.ZX);
        this.ZA = (FrameLayout) this.Zo.findViewById(a.g.tab_container_view);
        this.ZB = (FrameLayout) this.Zo.findViewById(a.g.layout_error);
        this.ZB.getLayoutParams().width = realScreenHeight;
        this.Zz = new CommonEmptyView(this.mContext.getPageActivity());
        this.Zz.setVisibility(8);
        this.Zz.addToParent(this.ZB);
        this.ZE = (GiftPanelTabView) this.Zo.findViewById(a.g.tab);
        this.ZC = this.Zo.findViewById(a.g.donate_layout);
        qk();
        this.ZZ = (ViewGroup) this.Zo.findViewById(a.g.ala_gift_draw_layout);
        this.ZZ.setVisibility(8);
        this.aac = (AlaGiftDrawPanel) this.Zo.findViewById(a.g.ala_gift_draw_panel);
        this.aac.setGiftDrawEventListener(this.aav);
        this.aac.setGiftCountRange(10, 100);
        this.ZJ = (ImageButton) this.Zo.findViewById(a.g.ala_gift_draw_hide_btn);
        this.ZJ.setOnClickListener(this.ZX);
        this.aaa = (ImageButton) this.Zo.findViewById(a.g.ala_gift_draw_clean_btn);
        this.aaa.setOnClickListener(this.aar);
        this.aaa.setEnabled(false);
        this.aab = (TextView) this.Zo.findViewById(a.g.ala_gift_draw_title);
        View findViewById = this.Zo.findViewById(a.g.ala_gift_draw_title_layout);
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

    public void qj() {
        this.aak = true;
        this.ZF.setVisibility(8);
        this.ZG.setVisibility(8);
        this.ZH.setVisibility(8);
    }

    public void am(boolean z) {
        this.Zn = z;
    }

    public void b(boolean z, String str, String str2, String str3) {
        if (com.baidu.live.l.a.uA().uE() && z) {
            this.ZH.setText(this.mContext.getPageActivity().getString(a.i.first_recharge_text));
            if (!this.aaj.contains(str)) {
                LogManager.getFirstChargeLogger().doDisplayLiveFirstChargePanelEntryLog(str, str2, str3, this.otherParams);
                this.aaj.add(str);
            }
        }
    }

    public void aP(int i) {
        this.aah = i;
    }

    private void qk() {
        this.ZY = new AlaLiveInputEditView(this.mContext.getPageActivity());
        this.ZY.setVisibility(8);
        this.ZY.setEditViewConfirmCallBack(this);
        this.Zq.addView(this.ZY, new RelativeLayout.LayoutParams(-1, -2));
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
        qo();
        bj(i);
        this.Zu.setCurrentItem(this.ZN);
        qs();
    }

    private void bj(int i) {
        int min = Math.min(i, this.ZV.size());
        int i2 = 0;
        for (int i3 = 0; i3 < min; i3++) {
            i2 += this.ZV.get(i3);
        }
        this.ZN = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a implements AdapterView.OnItemClickListener {
        private a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AlaGiftTabView.this.ZO = AlaGiftTabView.this.ZN;
            AlaGiftTabView.this.a((com.baidu.live.gift.container.a) adapterView.getAdapter(), i);
        }
    }

    public void a(com.baidu.live.gift.container.a aVar, int i) {
        int i2;
        boolean z;
        boolean z2;
        g.a aVar2;
        boolean z3 = true;
        if (this.aal) {
            this.mSelectedPosition = i;
            qo();
            if (aVar != null) {
                g item = aVar.getItem(i);
                if (item != null) {
                    this.ZT = item;
                    aVar.bd(i);
                    aVar.notifyDataSetChanged();
                    this.ZC.setVisibility(aVar.getCount() > 0 ? 0 : 4);
                    ct("1");
                    if (this.mType == 1 && (aVar2 = this.ZT.WH) != null && !TextUtils.isEmpty(aVar2.WN)) {
                        this.mContext.showToast(aVar2.WN);
                    }
                    int i3 = -1;
                    if (this.mType == 0) {
                        if (this.ZT.pq()) {
                            this.ZI.setStyle(this.ZT.pj() ? 4 : 3);
                            this.Zs.setStyleEnabled(false);
                            this.ZZ.setVisibility(8);
                            if (!TextUtils.isEmpty(this.ZT.pl())) {
                                this.mContext.showToast(this.ZT.pl());
                                return;
                            }
                            return;
                        }
                        boolean a2 = a(this.ZT);
                        if (a2 && !this.Zn) {
                            ql();
                            this.ZI.setStyle(this.ZT.pj() ? 4 : 3);
                            this.Zs.setStyleEnabled(false);
                            this.ZZ.setVisibility(8);
                            return;
                        }
                        this.ZI.setEnabled(true);
                        if (this.ZT.ps()) {
                            this.ZZ.setVisibility(8);
                            this.aac.rg();
                            if (this.ZT.pp() == 6 && this.Yl < 3) {
                                i3 = 3;
                            } else if (this.ZT.pp() == 7 && this.Yl < 7) {
                                i3 = 7;
                            } else if (this.ZT.pp() == 8 && this.Yl < 13) {
                                i3 = 13;
                            } else if (this.ZT.pp() == 9 && this.Yl < 22) {
                                i3 = 22;
                            } else if (this.ZT.pp() == 10 && this.Yl < 29) {
                                i3 = 29;
                            } else if (this.ZT.pp() == 11 && this.Yl < 39) {
                                i3 = 39;
                            } else if (this.ZT.pp() == 12 && this.Yl < 47) {
                                i3 = 47;
                            }
                        }
                        boolean z4 = i3 == -1;
                        if (z4) {
                            this.ZI.setStyle(this.ZT.pj() ? 2 : 1);
                        } else {
                            this.ZI.setStyle(this.ZT.pj() ? 4 : 3);
                        }
                        this.Zs.setStyleEnabled(z4);
                        i2 = i3;
                        z = a2;
                    } else {
                        this.ZI.setStyle(this.ZT.pj() ? 2 : 1);
                        if (this.ZT.WH != null && this.ZT.WH.WK != null && this.ZT.WH.WK.equals("20")) {
                            this.ZI.setText("使用");
                        } else {
                            this.ZI.setText("赠送");
                        }
                        this.Zs.setStyleEnabled(true);
                        i2 = -1;
                        z = false;
                    }
                    if (this.ZT.pk()) {
                        an(true);
                        this.aab.setVisibility(8);
                    } else {
                        an(false);
                    }
                    if (this.mType == 0) {
                        if (this.ZT.pn() && !com.baidu.live.gift.b.b.rc().ci(this.ZT.pc())) {
                            BdUtilHelper.showLongToast(this.mContext.getPageActivity(), this.mContext.getString(a.i.send_undownload_gift_toast));
                            return;
                        }
                        if (TextUtils.isEmpty(this.ZT.pl()) || !this.ZT.pq() || z) {
                            z2 = false;
                        } else {
                            this.mContext.showToast(this.ZT.pl());
                            z2 = true;
                        }
                        if (z2 || !this.ZT.ps() || i2 == -1) {
                            z3 = z2;
                        } else {
                            this.mContext.showToast(String.format(this.mContext.getString(a.i.send_family_level_gift_toast_live), Integer.valueOf(i2)));
                        }
                        if (!z3 && this.ZT.po()) {
                            BdUtilHelper.showLongToast(this.mContext.getPageActivity(), this.mContext.getString(a.i.send_broadcast_gift_toast));
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.ZI.setStyle(3);
                return;
            }
            this.ZI.setStyle(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(g gVar) {
        if (com.baidu.live.l.a.uA().akM != null && com.baidu.live.l.a.uA().akM.Ud != null) {
            String str = com.baidu.live.l.a.uA().akM.Ud.Tx;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.pp()))) {
                return true;
            }
        }
        return false;
    }

    private void ql() {
        if (!this.ZR) {
            this.aan = new com.baidu.live.view.d(this.mContext.getPageActivity());
            this.aan.setCancelable(false);
            this.aan.setCanceledOnTouchOutside(false);
            this.aan.aU(false);
            this.aan.k(this.mContext.getPageActivity().getString(a.i.need_join_guard_club_title), String.format(this.mContext.getPageActivity().getString(a.i.need_join_guard_club_content), Integer.valueOf(this.aah)), this.mContext.getPageActivity().getString(a.i.ala_gift_join_now), this.mContext.getPageActivity().getString(a.i.ala_gift_think));
            this.aan.setTitleTextColor(ViewCompat.MEASURED_STATE_MASK);
            this.aan.cp(-10066330);
            this.aan.cq(ViewCompat.MEASURED_STATE_MASK);
            this.aan.a(new d.a() { // from class: com.baidu.live.gift.container.AlaGiftTabView.12
                @Override // com.baidu.live.view.d.a
                public void qx() {
                    AlaGiftTabView.this.ZR = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913119));
                }

                @Override // com.baidu.live.view.d.a
                public void qy() {
                    AlaGiftTabView.this.ZR = false;
                }
            });
            this.aan.show();
            this.ZR = true;
            LogManager.getGuardClubLogger().doDisplayLiveGiftPopupLog(null, null, null, this.otherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an(boolean z) {
        int i = 0;
        if (z && com.baidu.live.l.a.uA().ajX.Rb) {
            if (Build.VERSION.SDK_INT != 26) {
                this.mContext.getPageActivity().setRequestedOrientation(1);
                this.aao = true;
            }
            this.ZZ.setVisibility(0);
            this.aac.setTipImageVisibility(0);
            this.aac.rg();
            BdResourceLoader.getInstance().loadResource(this.ZT.pf(), 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.gift.container.AlaGiftTabView.13
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                public void onLoaded(BdImage bdImage, String str, int i2) {
                    super.onLoaded((AnonymousClass13) bdImage, str, i2);
                    if (bdImage == null || bdImage.getRawBitmap() == null) {
                        BdUtilHelper.showToast(AlaGiftTabView.this.mContext.getPageActivity(), AlaGiftTabView.this.mContext.getPageActivity().getString(a.i.ala_gift_noimage_tip));
                    } else if (str != null && str.equals(AlaGiftTabView.this.ZT.pf())) {
                        AlaGiftTabView.this.aac.setGiftBitmp(bdImage.getRawBitmap());
                    }
                }
            }, null);
            this.Zr.setVisibility(4);
            this.ZI.setStyle(1);
            return;
        }
        if (Build.VERSION.SDK_INT != 26 && this.aao) {
            this.mContext.getPageActivity().setRequestedOrientation(3);
            this.aao = false;
        }
        this.ZZ.setVisibility(8);
        this.aac.rg();
        View view = this.Zr;
        if (this.ZT == null || !this.ZT.pj()) {
            i = 4;
        }
        view.setVisibility(i);
    }

    public boolean qm() {
        return this.ZY.getVisibility() == 0;
    }

    public void bk(int i) {
        if (this.ZY != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ZY.getLayoutParams();
            layoutParams.topMargin = i;
            this.ZY.setLayoutParams(layoutParams);
        }
    }

    public void qn() {
        this.ZY.tH();
        this.ZY.getEditView().setFocusable(true);
        this.ZY.getEditView().setFocusableInTouchMode(true);
        this.ZY.getEditView().postDelayed(this.aat, 100L);
    }

    public void qo() {
        this.ZY.setVisibility(8);
        this.ZY.getEditView().post(this.aau);
    }

    public AlaLiveInputEditView qp() {
        return this.ZY;
    }

    @Override // com.baidu.live.view.input.b.a
    public void cs(String str) {
        qo();
        if (JavaTypesHelper.toInt(str, 0) <= 0) {
            str = "1";
        }
        ct(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ct(String str) {
        this.Zt.setText(str);
        this.Zt.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(str.length() >= 4 ? a.e.sdk_fontsize20 : a.e.sdk_fontsize24));
        ao(false);
        if (this.ZT != null && this.ZT.pj()) {
            this.Zr.setVisibility(0);
            this.ZU = JavaTypesHelper.toInt(this.Zt.getText().toString(), 1);
            return;
        }
        this.Zr.setVisibility(4);
        this.ZU = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao(boolean z) {
        this.Zt.setGravity(17);
        if (z) {
            this.Zt.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_icon_tabbar_arrow_down, 0);
        } else {
            this.Zt.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_icon_tabbar_arrow_up, 0);
        }
    }

    public void a(boolean z, ArrayList<h> arrayList, ArrayList<com.baidu.live.gift.a.a> arrayList2, ArrayList<com.baidu.live.gift.a.b> arrayList3, boolean z2) {
        this.Ze = arrayList;
        this.Zf = arrayList2;
        this.Zg = arrayList3;
        this.ZQ = false;
        if (this.Zf == null || this.Zf.isEmpty()) {
            this.Zw.setVisibility(8);
        }
        e(z, z2);
    }

    public void l(String str, int i) {
        if (!TextUtils.isEmpty(str) && this.mType == 1 && this.ZK != null) {
            for (View view : this.ZK) {
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
        qq();
        qw();
        if (this.Ze == null || this.Ze.size() <= 0 || !z2) {
            kr();
            if (this.Zv != null) {
                this.Zv.setVisibility(4);
            }
            this.ZC.setVisibility(4);
            this.Zz.reset();
            this.Zz.setTitle(a.i.sdk_net_fail_tip_rank);
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                this.Zz.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            } else {
                this.Zz.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            this.Zz.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaGiftTabView.this.ZM != null) {
                        AlaGiftTabView.this.ZM.qz();
                    }
                }
            });
            this.Zz.setVisibility(0);
            return;
        }
        this.Zz.setVisibility(8);
        this.ZC.setVisibility(0);
        this.Zy.setVisibility(0);
        if (z) {
            kr();
            f(this.Zf);
        }
        c(this.Ze, z);
        ct("1");
    }

    private void kr() {
        this.ZN = 0;
        this.ZO = 0;
        this.mSelectedPosition = 0;
        this.ZP = 0;
        if (this.ZV != null) {
            this.ZV.clear();
        }
        if (this.ZK != null) {
            this.ZK.clear();
        }
        if (this.Zu != null) {
            this.Zu.setAdapter(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar) {
        if (gVar == null) {
            return false;
        }
        if (!a(this.ZT) || this.Zn) {
            if (gVar.ps()) {
                if (gVar.pp() == 6 && this.Yl < 3) {
                    return false;
                }
                if (gVar.pp() == 7 && this.Yl < 7) {
                    return false;
                }
                if (gVar.pp() == 8 && this.Yl < 13) {
                    return false;
                }
                if (gVar.pp() == 9 && this.Yl < 22) {
                    return false;
                }
                if (gVar.pp() == 10 && this.Yl < 29) {
                    return false;
                }
                if (gVar.pp() == 11 && this.Yl < 39) {
                    return false;
                }
                if (gVar.pp() == 12 && this.Yl < 47) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private void qq() {
        if (ListUtils.getCount(this.Zf) != 0 && ListUtils.getCount(this.Ze) != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<com.baidu.live.gift.a.a> it = this.Zf.iterator();
            while (it.hasNext()) {
                com.baidu.live.gift.a.a next = it.next();
                if (next != null && (TextUtils.isEmpty(next.getCategoryName()) || (this.mType == 0 && ListUtils.getCount(next.qB()) == 0))) {
                    arrayList.add(next);
                    Iterator<h> it2 = this.Ze.iterator();
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
                Iterator<h> it3 = this.Ze.iterator();
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
                this.Zf.removeAll(arrayList);
            }
            if (arrayList2.size() > 0) {
                this.Ze.removeAll(arrayList2);
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
            this.ZV.clear();
            this.ZK.clear();
            this.Zu.setAdapter(null);
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
                    this.ZK.add(bl(i7));
                    this.ZV.append(i7, 1);
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
                        if (this.ZW.get(i7)) {
                            this.ZK.add(ap(true));
                        } else {
                            this.ZK.add(b(arrayList2, -1, i7));
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
                                this.ZK.add(b(subList, 0, i7));
                                this.ZT = subList.get(0);
                                this.ZZ.removeCallbacks(null);
                                this.ZZ.postDelayed(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        boolean pk = AlaGiftTabView.this.ZT.pk();
                                        AlaGiftTabView.this.an(pk);
                                        if (!pk) {
                                            boolean b2 = AlaGiftTabView.this.b(AlaGiftTabView.this.ZT);
                                            if (!b2) {
                                                AlaGiftTabView.this.ZI.setStyle(AlaGiftTabView.this.ZT.pj() ? 4 : 3);
                                            } else {
                                                AlaGiftTabView.this.ZI.setStyle(AlaGiftTabView.this.ZT.pj() ? 2 : 1);
                                            }
                                            AlaGiftTabView.this.Zs.setStyleEnabled(b2);
                                        }
                                    }
                                }, 100L);
                            } else {
                                if (this.aae != categoryId || ListUtils.isEmpty(subList)) {
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
                                        if (gVar == null || !gVar.pc().equals(String.valueOf(this.aaf))) {
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
                                        this.ZT = gVar;
                                    }
                                    i2 = i3;
                                }
                                this.ZK.add(b(subList, i2, i7));
                            }
                        }
                        i8 = ceil;
                    }
                    this.ZV.append(i7, i8);
                }
                i6 = i7 + 1;
            }
            this.ZL = new AlaGiftPagerAdapter(this.ZK);
            this.Zu.setAdapter(this.ZL);
            qr();
            this.Zu.setCurrentItem(this.ZN);
            qs();
            if (this.ZP == 0) {
                onPageSelected(0);
            }
        }
    }

    private void qr() {
        if (!this.aag && this.aae >= 0 && !ListUtils.isEmpty(this.Zf)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.Zf.size()) {
                    break;
                }
                com.baidu.live.gift.a.a aVar = this.Zf.get(i2);
                if (aVar == null || this.aae != aVar.getCategoryId()) {
                    i = i2 + 1;
                } else {
                    bj(i2);
                    break;
                }
            }
            this.ZO = this.ZN;
            this.aag = true;
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
                if (AlaGiftTabView.this.ZM != null) {
                    AlaGiftTabView.this.ZM.qz();
                }
            }
        });
        commonEmptyView.addToParent(frameLayout);
        return frameLayout;
    }

    private FrameLayout b(List<g> list, int i, int i2) {
        FrameLayout frameLayout = new FrameLayout(this.mContext.getPageActivity());
        com.baidu.live.gift.container.a aVar = new com.baidu.live.gift.container.a(this.mContext, this.mType);
        aVar.ak(this.Yn);
        aVar.setGiftItems(list);
        aVar.bc(this.Yl);
        aVar.bd(i);
        if (this.isLandscape) {
            aVar.be(this.aam / 3);
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
            if (!this.aad) {
                this.Zw.setVisibility(0);
            }
            this.Zx.removeAllViews();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                com.baidu.live.gift.a.a aVar = arrayList.get(i);
                if (!TextUtils.isEmpty(aVar.getCategoryName()) && (this.mType != 0 || (aVar.qB() != null && aVar.qB().size() > 0))) {
                    ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.ala_gift_tab_item, (ViewGroup) null);
                    GradientTextView gradientTextView = (GradientTextView) viewGroup.findViewById(a.g.text_view);
                    gradientTextView.setCheckStrEquals(false);
                    gradientTextView.setText(aVar.getCategoryName());
                    viewGroup.setOnClickListener(new b(i));
                    if (i != 0) {
                        layoutParams.leftMargin = this.ZS;
                    }
                    if (this.Ze.size() > i && this.Ze.get(i) != null) {
                        for (g gVar : this.Ze.get(i).pt()) {
                            if (gVar != null && gVar.pi() != 6) {
                                z = false;
                                break;
                            }
                        }
                    }
                    z = true;
                    viewGroup.setTag(Boolean.valueOf(z));
                    this.Zx.addView(viewGroup, layoutParams);
                }
            }
            bm(this.ZP);
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
        int childCount = this.Zx.getChildCount();
        if (i >= 0 && i < childCount) {
            if ((this.ZP != i || !this.ZQ) && this.Zf.size() > i && this.Zf.get(i) != null) {
                int min = Math.min(i, this.ZV.size());
                int i2 = 0;
                for (int i3 = 0; i3 < min; i3++) {
                    i2 += this.ZV.get(i3);
                }
                if (this.ZK.size() > i2 && this.Ze.size() > i && (this.ZK.get(i2) instanceof ViewGroup)) {
                    this.ZO = i2;
                    h hVar = this.Ze.get(i);
                    if (hVar != null && hVar.pt() != null && !hVar.pt().isEmpty()) {
                        this.ZT = this.Ze.get(i).pt().get(0);
                        ViewGroup viewGroup = (ViewGroup) this.ZK.get(i2);
                        int i4 = 0;
                        while (true) {
                            if (i4 >= viewGroup.getChildCount()) {
                                break;
                            } else if (!(viewGroup.getChildAt(i4) instanceof GridView)) {
                                i4++;
                            } else {
                                com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) ((GridView) viewGroup.getChildAt(i4)).getAdapter();
                                if (this.ZT != null && aVar != null) {
                                    a(aVar, 0);
                                    if (this.aal) {
                                        this.ZQ = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (this.Zf.size() > i && this.Zf.get(i) != null) {
                int categoryId = this.Zf.get(i).getCategoryId();
                if (!this.aai.get(categoryId)) {
                    LogManager.getGiftLogger().doDisplayGiftTabLog(null, this.otherParams, String.valueOf(categoryId));
                    this.aai.put(categoryId, true);
                }
            }
            for (int i5 = 0; i5 < childCount; i5++) {
                ViewGroup viewGroup2 = (ViewGroup) this.Zx.getChildAt(i5);
                GradientTextView gradientTextView = (GradientTextView) viewGroup2.findViewById(a.g.text_view);
                ImageView imageView = (ImageView) viewGroup2.findViewById(a.g.icon_new_unlock_gift);
                imageView.setVisibility(8);
                h hVar2 = this.Ze.get(i5);
                if (hVar2.pu()) {
                    HashSet hashSet = new HashSet();
                    String string = SharedPrefHelper.getInstance().getString(this.Zk, "");
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
                                SharedPrefHelper.getInstance().putString(this.Zk, jSONArray.toString());
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
                    this.ZP = i;
                    this.Zw.scrollTo(viewGroup2.getLeft(), 0);
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
        if (this.ZF != null) {
            this.ZF.setVisibility(z ? this.aak ? 8 : 0 : 8);
        }
        if (this.ZG != null) {
            TextView textView = this.ZG;
            if (!z && !this.aak) {
                i = 0;
            }
            textView.setVisibility(i);
        }
    }

    private void bn(int i) {
        int childCount = this.Zx.getChildCount();
        if (i >= 0 && i < childCount && this.Ze != null && this.Ze.size() > i && this.Ze.get(i) != null) {
            this.ZW.get(i);
        }
    }

    public void p(int i, int i2) {
        this.aae = i;
        this.aaf = i2;
    }

    public void x(long j) {
        if (this.ZF != null) {
            if (j >= 100 && (this.Yn || com.baidu.live.l.a.uA().ajX.Sb)) {
                this.ZF.setText(new DecimalFormat("0.###K").format(JavaTypesHelper.toDouble(String.valueOf(j), 0.0d) / 1000.0d));
                return;
            }
            this.ZF.setText(String.valueOf(j));
        }
    }

    public void y(long j) {
        if (this.ZG != null) {
            this.ZG.setText(String.valueOf(j));
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
        this.ZN = i;
        qs();
        if (i >= 0 && i < this.ZK.size() && (this.ZK.get(i) instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) this.ZK.get(i);
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                if (viewGroup.getChildAt(i2) instanceof GridView) {
                    GridView gridView = (GridView) viewGroup.getChildAt(i2);
                    if (gridView.getAdapter() != null) {
                        com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) gridView.getAdapter();
                        if (aVar.qd() >= 0 && i != this.ZO) {
                            aVar.bd(-1);
                        }
                        if (aVar.qd() < 0 && i == this.ZO) {
                            aVar.bd(this.mSelectedPosition);
                        }
                        aVar.notifyDataSetChanged();
                        this.ZC.setVisibility(aVar.getCount() <= 0 ? 4 : 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private void qs() {
        int i = 0;
        for (int i2 = 0; i2 < this.ZV.size(); i2++) {
            for (int i3 = 0; i3 < this.ZV.get(i2); i3++) {
                if (i + i3 == this.ZN) {
                    if (this.ZV.get(i2) <= 1) {
                        this.Zv.setVisibility(4);
                    } else {
                        this.Zv.setVisibility(0);
                    }
                    this.Zv.setCount(this.ZV.get(i2));
                    this.Zv.onPageSelected(i3);
                    bm(i2);
                    return;
                }
            }
            i += this.ZV.get(i2);
        }
    }

    public g qt() {
        return this.ZT;
    }

    public k qu() {
        k kVar = new k();
        kVar.Xo = BdUtilHelper.dip2px(this.mContext.getPageActivity(), 32.0f);
        kVar.Xp.addAll(this.aac.getPoints());
        kVar.Xm = this.aac.getMeasuredHeight();
        kVar.Xl = this.aac.getMeasuredWidth();
        Rect rect = new Rect();
        this.aac.getGlobalVisibleRect(rect);
        kVar.Xj = rect.left;
        kVar.Xk = rect.top;
        kVar.Xq = kVar.Xp.size();
        kVar.Xr = new Rect(0, 0, rect.width(), rect.height());
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext.getPageActivity());
        kVar.Xh = screenDimensions[0];
        kVar.Xi = screenDimensions[1];
        return kVar;
    }

    public int qv() {
        return this.ZU;
    }

    public void a(DialogInterface.OnCancelListener onCancelListener) {
    }

    public void qw() {
    }

    public void a(c cVar) {
        this.ZM = cVar;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.aaw);
        MessageManager.getInstance().registerListener(this.aax);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cu(final String str) {
        if (!ListUtils.isEmpty(this.ZK) && !TextUtils.isEmpty(str)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.8
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.ZK) {
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
        MessageManager.getInstance().unRegisterListener(this.aaw);
        MessageManager.getInstance().unRegisterListener(this.aax);
        if (this.aan != null) {
            this.aan.dismiss();
        }
    }

    public void ak(boolean z) {
        this.Yn = z;
    }

    public void bo(int i) {
        this.Yl = i;
    }
}

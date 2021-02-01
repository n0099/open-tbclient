package com.baidu.live.gift.container;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.gift.aa;
import com.baidu.live.gift.ac;
import com.baidu.live.gift.g;
import com.baidu.live.gift.widget.panel.GiftPanelCountBadgeView;
import com.baidu.live.lottie.LottieAnimationView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private static SimpleDateFormat aZG;
    private int aZH;
    private int aZI;
    private int aZJ;
    private int aZK;
    private boolean aZL;
    private final Context mContext;
    private int aZD = -1;
    private int mSelectedPosition = -1;
    private boolean aZF = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.gift.container.a.1
        private void a(g gVar, C0173a c0173a) {
            com.baidu.live.gift.c gM;
            if (gVar.Ef() && !com.baidu.live.gift.c.b.Hr().ge(gVar.DR()) && (gM = com.baidu.live.gift.c.b.Hr().gM(gVar.DR())) != null) {
                com.baidu.live.gift.c.a.Hq().a(gM.aVs, true);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view.getTag(a.f.TAG_GIFT_ITEM) instanceof g) && (view.getTag(a.f.TAG_GIFT_VIEW_HOLDER) instanceof C0173a)) {
                C0173a c0173a = (C0173a) view.getTag(a.f.TAG_GIFT_VIEW_HOLDER);
                g gVar = (g) view.getTag(a.f.TAG_GIFT_ITEM);
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(a.this.mContext.getApplicationContext(), a.this.mContext.getString(a.h.sdk_neterror));
                } else {
                    a(gVar, c0173a);
                }
            }
        }
    };
    private List<g> aZE = Collections.synchronizedList(new ArrayList());

    public a(Context context) {
        this.mContext = context;
    }

    public void setGiftItems(List<g> list) {
        if (this.aZE == null) {
            this.aZE = Collections.synchronizedList(new ArrayList());
        } else {
            this.aZE.clear();
        }
        if (list != null) {
            this.aZE.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void E(String str, int i) {
        if (this.aZE != null) {
            for (g gVar : this.aZE) {
                if (gVar.aVX != null && gVar.DR().equals(str)) {
                    gVar.aVX.aWm = i;
                }
            }
            notifyDataSetChanged();
        }
    }

    public void cP(int i) {
        this.aZD = i;
    }

    public void cQ(int i) {
        this.mSelectedPosition = i;
    }

    public int FV() {
        return this.mSelectedPosition;
    }

    public void bF(boolean z) {
        this.aZF = z;
    }

    public void cR(int i) {
        this.aZH = i;
        float dimensionPixelOffset = (i * 1.0f) / this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds192);
        this.aZI = (int) (this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds100) * dimensionPixelOffset);
        this.aZJ = (int) (this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds12) * dimensionPixelOffset);
        this.aZK = (int) (dimensionPixelOffset * this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds8));
    }

    public void bj(boolean z) {
        this.aZL = z;
    }

    public void a(AbsListView absListView, boolean z) {
        int firstVisiblePosition;
        View childAt;
        this.aZL = z;
        int count = getCount();
        if (count != 0) {
            for (int i = 0; i < count; i++) {
                if (getItem(i).Et() && i >= (firstVisiblePosition = absListView.getFirstVisiblePosition()) && i <= absListView.getLastVisiblePosition() && (childAt = absListView.getChildAt(i - firstVisiblePosition)) != null) {
                    getView(i, childAt, absListView);
                }
            }
        }
    }

    public void a(AbsListView absListView, String str, String str2) {
        int count;
        int firstVisiblePosition;
        View childAt;
        com.baidu.live.gift.c gM;
        if (!TextUtils.isEmpty(str) && (count = getCount()) != 0) {
            int i = 0;
            while (true) {
                if (i >= count) {
                    i = -1;
                    break;
                }
                g item = getItem(i);
                if (item != null && !TextUtils.isEmpty(item.DR()) && (gM = com.baidu.live.gift.c.b.Hr().gM(item.DR())) != null && !TextUtils.isEmpty(gM.getDynamicGiftId()) && gM.getDynamicGiftId().equals(str) && ac.gr(item.DR()).equals(str2)) {
                    break;
                }
                i++;
            }
            if (i >= 0 && i >= (firstVisiblePosition = absListView.getFirstVisiblePosition()) && i <= absListView.getLastVisiblePosition() && (childAt = absListView.getChildAt(i - firstVisiblePosition)) != null) {
                getView(i, childAt, absListView);
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aZE == null) {
            return 0;
        }
        return this.aZE.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: cS */
    public g getItem(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.aZE.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0173a c0173a;
        int i2;
        String formatGiftNumForTDouDisPlay;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.ala_gift_list_item, viewGroup, false);
            view.setBackgroundResource(a.e.sdk_transparent_bg);
            C0173a c0173a2 = new C0173a();
            c0173a2.aZN = (TbImageView) view.findViewById(a.f.gift_thumbnail);
            c0173a2.aZN.setDefaultBgResource(a.e.icon_live_gift_default);
            c0173a2.aZN.setDefaultErrorResource(a.e.icon_live_gift_default);
            c0173a2.aZN.setAutoChangeStyle(false);
            c0173a2.aZQ = view.findViewById(a.f.layout_gift_item_name);
            c0173a2.aZR = (TextView) view.findViewById(a.f.gift_name);
            c0173a2.aZS = (TextView) view.findViewById(a.f.tv_gift_item_longpress_tip);
            c0173a2.aZT = (TextView) view.findViewById(a.f.gift_price);
            c0173a2.aZO = (RelativeLayout) view.findViewById(a.f.llCarom);
            c0173a2.aZU = (TextView) view.findViewById(a.f.gift_carom_txt);
            c0173a2.aZW = view.findViewById(a.f.in_progress);
            c0173a2.aZX = (LottieAnimationView) view.findViewById(a.f.lottie_downloading);
            c0173a2.aZX.loop(true);
            c0173a2.aZX.setAnimation("live_gift_panel_downloading.json");
            c0173a2.aZY = view.findViewById(a.f.selected_bg);
            c0173a2.aZV = (TextView) view.findViewById(a.f.tv_privilege);
            c0173a2.aZP = (LinearLayout) view.findViewById(a.f.ll_privilege);
            c0173a2.aZZ = (GiftPanelCountBadgeView) view.findViewById(a.f.badge_pkg_count);
            c0173a2.aZZ.setPlusThreshold(999, true);
            c0173a2.baa = (FrameLayout) view.findViewById(a.f.layout_script);
            c0173a2.bab = (TextView) view.findViewById(a.f.tv_script);
            view.setTag(c0173a2);
            a(view, c0173a2);
            c0173a = c0173a2;
        } else {
            c0173a = (C0173a) view.getTag();
        }
        a(view, c0173a);
        c0173a.FX();
        if (i == this.mSelectedPosition) {
            c0173a.FW();
        }
        g item = getItem(i);
        g.b bVar = item.aVX;
        c0173a.aZS.setTag(a.f.TAG_GIFT_ITEM, item);
        if (viewGroup.getChildCount() == i) {
            c0173a.aZS.setVisibility(4);
        }
        if (item != null) {
            if (item.isRed()) {
                c0173a.aZN.setImageResource(a.e.live_gift_red_enter);
                c0173a.aZR.setText(this.mContext.getString(a.h.sdk_red_pkt_send));
                c0173a.aZT.setText("");
            } else {
                c0173a.aZN.startLoad(item.getThumbnail_url(), 10, false);
                c0173a.aZR.setText(item.DS());
                boolean z = item instanceof aa;
                if (!z) {
                    double d = JavaTypesHelper.toDouble(String.valueOf(item.getPrice()), 0.0d);
                    if (d >= 100.0d && ((this.aZF || com.baidu.live.ae.a.Qj().buX.aMr) && !item.Ee())) {
                        formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
                    } else {
                        formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(item.getPrice()));
                    }
                    c0173a.aZT.setText(formatGiftNumForTDouDisPlay);
                    if (item.Ee()) {
                        c0173a.aZT.setText(this.mContext.getString(a.h.ala_gift_price_flower_label, formatGiftNumForTDouDisPlay));
                    } else {
                        c0173a.aZT.setText(this.mContext.getString(a.h.ala_gift_price_tdou_label, formatGiftNumForTDouDisPlay));
                    }
                } else {
                    aa aaVar = (aa) item;
                    if (aaVar.Fk() && aaVar.aYb != null && aaVar.aYb.size() > 0) {
                        StringBuilder sb = new StringBuilder("碎片进展");
                        int i3 = 0;
                        Iterator<aa.a> it = aaVar.aYb.iterator();
                        while (true) {
                            i2 = i3;
                            if (!it.hasNext()) {
                                break;
                            }
                            i3 = it.next().num > 0 ? i2 + 1 : i2;
                        }
                        sb.append("（");
                        sb.append(i2);
                        sb.append("/");
                        sb.append(aaVar.aYb.size());
                        sb.append("）");
                        c0173a.aZT.setText(sb.toString());
                    } else if (bVar != null) {
                        if (bVar.aWn > 0) {
                            c0173a.aZT.setText(aP(bVar.aWn) + " 失效");
                        } else if (bVar.aWn == -1) {
                            c0173a.aZT.setText("长久有效");
                        } else {
                            c0173a.aZT.setText("");
                        }
                    } else {
                        c0173a.aZT.setText("");
                    }
                }
                c0173a.aZO.setClickable(false);
                c0173a.aZO.setVisibility(8);
                c0173a.aZU.setBackgroundColor(0);
                c0173a.aZP.setVisibility(8);
                c0173a.aZN.setAlpha(1.0f);
                c0173a.aZT.setAlpha(1.0f);
                c0173a.aZR.setAlpha(1.0f);
                c0173a.aZZ.setVisibility(8);
                c0173a.aZW.setVisibility(4);
                c0173a.aZX.cancelAnimation();
                if (!z) {
                    if (item.Er()) {
                        c0173a.aZN.setAlpha(0.5f);
                        c0173a.aZT.setAlpha(0.5f);
                        c0173a.aZR.setAlpha(0.5f);
                        c0173a.aZO.setVisibility(8);
                        c0173a.aZP.setVisibility(0);
                        if (!TextUtils.isEmpty(item.Es())) {
                            c0173a.aZV.setText(item.Es());
                        } else {
                            c0173a.aZV.setText("");
                        }
                        String Es = item.Es();
                        if (item.Eh()) {
                            if (item.Ej()) {
                                c0173a.aZP.setBackgroundResource(a.e.live_gift_item_script_lock_activity);
                            } else if (item.Ek()) {
                                c0173a.aZP.setBackgroundResource(a.e.live_gift_item_script_lock_power);
                            } else {
                                c0173a.aZP.setBackgroundResource(a.e.live_gift_item_script_lock_level);
                            }
                        } else if (Es.equals("活动")) {
                            c0173a.aZP.setBackgroundResource(a.e.live_gift_item_script_lock_activity);
                        } else {
                            c0173a.aZP.setBackgroundResource(a.e.live_gift_item_script_lock_level);
                        }
                    } else if (item.Ef()) {
                        c0173a.aZO.setVisibility(0);
                        if (!com.baidu.live.gift.c.b.Hr().ge(item.DR())) {
                            c0173a.aZU.setText(" ");
                            c0173a.aZU.setBackgroundResource(a.e.live_gift_panel_item_script_download);
                            c0173a.aZO.setTag(a.f.TAG_GIFT_ITEM, item);
                            c0173a.aZO.setTag(a.f.TAG_GIFT_VIEW_HOLDER, c0173a);
                            c0173a.aZO.setClickable(true);
                            c0173a.aZO.setOnClickListener(this.mOnClickListener);
                            if (com.baidu.live.gift.c.a.Hq().at(item.DR(), ac.gr(item.DR()))) {
                                c0173a.aZN.setAlpha(0.5f);
                                c0173a.aZT.setAlpha(0.5f);
                                c0173a.aZR.setAlpha(0.5f);
                                c0173a.aZW.setVisibility(0);
                                c0173a.aZX.playAnimation();
                                c0173a.aZO.setVisibility(4);
                            } else if (com.baidu.live.gift.c.b.Hr().gM(item.DR()) != null) {
                                c0173a.aZW.setVisibility(4);
                                c0173a.aZX.cancelAnimation();
                                c0173a.aZO.setVisibility(0);
                            } else {
                                a(c0173a, item);
                            }
                        } else {
                            a(c0173a, item);
                        }
                    } else {
                        a(c0173a, item);
                    }
                } else if (bVar != null) {
                    if (bVar.aWm > 0) {
                        c0173a.aZZ.setCount(bVar.aWm);
                        c0173a.aZZ.setVisibility(0);
                    } else {
                        c0173a.aZZ.setVisibility(8);
                    }
                }
            }
        }
        return view;
    }

    private void a(C0173a c0173a, g gVar) {
        c0173a.aZW.setVisibility(4);
        c0173a.aZX.cancelAnimation();
        if (gVar.Eh()) {
            c0173a.aZO.setVisibility(0);
            String Es = gVar.Es();
            c0173a.aZU.setText(Es);
            if (gVar.Ej()) {
                if (TextUtils.isEmpty(Es)) {
                    c0173a.aZU.setText(a.h.ala_gift_type_activity);
                }
                c0173a.aZU.setBackgroundResource(a.e.live_gift_panel_item_script_activity);
            } else if (gVar.Ei()) {
                if (TextUtils.isEmpty(Es)) {
                    c0173a.aZU.setText(a.h.ala_gift_type_discount);
                }
                c0173a.aZU.setBackgroundResource(a.e.live_gift_panel_item_script_discount);
            } else if (gVar.Ek()) {
                if (TextUtils.isEmpty(Es)) {
                    c0173a.aZU.setText(a.h.ala_gift_type_privilege);
                }
                c0173a.aZU.setBackgroundResource(a.e.live_gift_panel_item_script_power);
            } else if (gVar.Em()) {
                if (TextUtils.isEmpty(Es)) {
                    c0173a.aZU.setText(a.h.ala_gift_broadcast_txt);
                }
                c0173a.aZU.setBackgroundResource(a.e.live_gift_panel_item_script_broadcast);
            } else if (gVar.El()) {
                if (TextUtils.isEmpty(Es)) {
                    c0173a.aZU.setText(a.h.ala_gift_draw_txt);
                }
                c0173a.aZU.setBackgroundResource(a.e.live_gift_panel_item_script_graffiti);
            } else if (gVar.Eo()) {
                if (TextUtils.isEmpty(Es)) {
                    Es = this.mContext.getString(a.h.ala_gift_type_new);
                    c0173a.aZU.setText(a.h.ala_gift_type_new);
                }
                if (Es != null && Es.length() == 1) {
                    c0173a.aZU.setBackgroundResource(a.e.live_gift_panel_item_script_new);
                } else {
                    c0173a.aZU.setBackgroundResource(a.e.live_gift_panel_item_script_new_wide);
                }
            } else {
                c0173a.aZO.setVisibility(8);
            }
        } else if (gVar.Ev()) {
            c0173a.aZO.setVisibility(0);
            String Es2 = gVar.Es();
            if (TextUtils.isEmpty(Es2)) {
                c0173a.aZU.setText(a.h.ala_gift_privilege_level);
            } else {
                c0173a.aZU.setText(Es2);
            }
            c0173a.aZU.setBackgroundResource(a.e.live_gift_panel_item_script_level);
        } else if (gVar.Et() && !this.aZL) {
            c0173a.aZN.setAlpha(0.5f);
            c0173a.aZT.setAlpha(0.5f);
            c0173a.aZR.setAlpha(0.5f);
            c0173a.aZO.setVisibility(8);
            c0173a.aZP.setBackgroundResource(a.e.live_gift_item_script_lock_level);
            c0173a.aZP.setVisibility(0);
            c0173a.aZV.setText(a.h.ala_gift_privilege_throne);
        } else if (gVar.Eb()) {
            c0173a.aZO.setVisibility(0);
            String Es3 = gVar.Es();
            if (TextUtils.isEmpty(Es3)) {
                c0173a.aZU.setText(a.h.ala_gift_draw_txt);
            } else {
                c0173a.aZU.setText(Es3);
            }
            c0173a.aZU.setBackgroundResource(a.e.live_gift_panel_item_script_graffiti);
        } else if (gVar.Ec()) {
            c0173a.aZO.setVisibility(0);
            String Es4 = gVar.Es();
            if (TextUtils.isEmpty(Es4)) {
                c0173a.aZU.setText(a.h.ala_gift_combo_txt);
            } else {
                c0173a.aZU.setText(Es4);
            }
            c0173a.aZU.setBackgroundResource(a.e.live_gift_panel_item_script_graffiti);
        } else if (gVar.Ep()) {
            String Es5 = gVar.Es();
            if (TextUtils.isEmpty(Es5)) {
                c0173a.aZU.setText(a.h.ala_gift_broadcast_txt);
            } else {
                c0173a.aZU.setText(Es5);
            }
            c0173a.aZU.setBackgroundResource(a.e.live_gift_panel_item_script_broadcast);
        } else if (!TextUtils.isEmpty(gVar.Es())) {
            String Es6 = gVar.Es();
            c0173a.aZO.setVisibility(0);
            c0173a.aZU.setText(Es6);
            if ("活动".equals(Es6)) {
                c0173a.aZU.setBackgroundResource(a.e.live_gift_panel_item_script_activity);
            } else if ("折扣".equals(Es6)) {
                c0173a.aZU.setBackgroundResource(a.e.live_gift_panel_item_script_discount);
            } else if (Es6 != null && Es6.length() == 1) {
                c0173a.aZU.setBackgroundResource(a.e.live_gift_panel_item_script_new);
            } else {
                c0173a.aZU.setBackgroundResource(a.e.live_gift_panel_item_script_new_wide);
            }
        } else {
            c0173a.aZO.setVisibility(8);
        }
    }

    /* renamed from: com.baidu.live.gift.container.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0173a {
        public TbImageView aZN;
        public RelativeLayout aZO;
        public LinearLayout aZP;
        public View aZQ;
        public TextView aZR;
        public TextView aZS;
        public TextView aZT;
        public TextView aZU;
        public TextView aZV;
        public View aZW;
        public LottieAnimationView aZX;
        public View aZY;
        public GiftPanelCountBadgeView aZZ;
        public FrameLayout baa;
        public TextView bab;
        public AnimatorSet bac;

        public void recycle() {
            if (this.aZX != null) {
                this.aZX.cancelAnimation();
            }
            FY();
        }

        public void FW() {
            if (this.aZY != null) {
                this.aZY.setVisibility(0);
            }
            N(this.aZN);
        }

        public void FX() {
            if (this.aZY != null) {
                this.aZY.setVisibility(8);
            }
            FY();
        }

        private void N(View view) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0.9f);
            ofFloat.setDuration(500);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.setRepeatCount(-1);
            ofFloat.setRepeatMode(2);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.9f);
            ofFloat2.setDuration(500);
            ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat2.setRepeatCount(-1);
            ofFloat2.setRepeatMode(2);
            this.bac = new AnimatorSet();
            this.bac.play(ofFloat).with(ofFloat2);
            this.bac.start();
        }

        public void FY() {
            if (this.bac != null) {
                this.bac.cancel();
                this.bac = null;
            }
        }
    }

    private void a(View view, C0173a c0173a) {
        if (this.aZH > 0 && this.aZI > 0) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams.height != this.aZH) {
                layoutParams.height = this.aZH;
                view.setLayoutParams(layoutParams);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) c0173a.aZN.getLayoutParams();
            if (layoutParams2.width != this.aZI || layoutParams2.height != this.aZI || layoutParams2.topMargin != this.aZJ) {
                layoutParams2.width = this.aZI;
                layoutParams2.height = this.aZI;
                layoutParams2.topMargin = this.aZJ;
                c0173a.aZN.setLayoutParams(layoutParams2);
            }
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) c0173a.aZQ.getLayoutParams();
            if (layoutParams3.topMargin != this.aZK) {
                layoutParams3.topMargin = this.aZK;
                c0173a.aZQ.setLayoutParams(layoutParams3);
            }
        }
    }

    private static String aP(long j) {
        if (aZG == null) {
            aZG = new SimpleDateFormat("yyyy.MM.dd");
        }
        return aZG.format(Long.valueOf(1000 * j));
    }
}

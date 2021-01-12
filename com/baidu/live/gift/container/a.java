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
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private static SimpleDateFormat aWA;
    private int aWB;
    private int aWC;
    private int aWD;
    private int aWE;
    private boolean aWF;
    private final Context mContext;
    private int aWx = -1;
    private int mSelectedPosition = -1;
    private boolean aWz = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.gift.container.a.1
        private void a(g gVar, C0172a c0172a) {
            com.baidu.live.gift.c go;
            if (gVar.CP() && !com.baidu.live.gift.c.b.Gb().fJ(gVar.CC()) && (go = com.baidu.live.gift.c.b.Gb().go(gVar.CC())) != null) {
                com.baidu.live.gift.c.a.Ga().a(go.aSo, true);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view.getTag(a.f.TAG_GIFT_ITEM) instanceof g) && (view.getTag(a.f.TAG_GIFT_VIEW_HOLDER) instanceof C0172a)) {
                C0172a c0172a = (C0172a) view.getTag(a.f.TAG_GIFT_VIEW_HOLDER);
                g gVar = (g) view.getTag(a.f.TAG_GIFT_ITEM);
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(a.this.mContext.getApplicationContext(), a.this.mContext.getString(a.h.sdk_neterror));
                } else {
                    a(gVar, c0172a);
                }
            }
        }
    };
    private List<g> aWy = Collections.synchronizedList(new ArrayList());

    public a(Context context) {
        this.mContext = context;
    }

    public void setGiftItems(List<g> list) {
        if (this.aWy == null) {
            this.aWy = Collections.synchronizedList(new ArrayList());
        } else {
            this.aWy.clear();
        }
        if (list != null) {
            this.aWy.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void D(String str, int i) {
        if (this.aWy != null) {
            for (g gVar : this.aWy) {
                if (gVar.aSS != null && gVar.CC().equals(str)) {
                    gVar.aSS.aTh = i;
                }
            }
            notifyDataSetChanged();
        }
    }

    public void cK(int i) {
        this.aWx = i;
    }

    public void cL(int i) {
        this.mSelectedPosition = i;
    }

    public int EF() {
        return this.mSelectedPosition;
    }

    public void bA(boolean z) {
        this.aWz = z;
    }

    public void cM(int i) {
        this.aWB = i;
        float dimensionPixelOffset = (i * 1.0f) / this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds192);
        this.aWC = (int) (this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds100) * dimensionPixelOffset);
        this.aWD = (int) (this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds12) * dimensionPixelOffset);
        this.aWE = (int) (dimensionPixelOffset * this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds8));
    }

    public void bh(boolean z) {
        this.aWF = z;
    }

    public void a(AbsListView absListView, boolean z) {
        int firstVisiblePosition;
        View childAt;
        this.aWF = z;
        int count = getCount();
        if (count != 0) {
            for (int i = 0; i < count; i++) {
                if (getItem(i).Dd() && i >= (firstVisiblePosition = absListView.getFirstVisiblePosition()) && i <= absListView.getLastVisiblePosition() && (childAt = absListView.getChildAt(i - firstVisiblePosition)) != null) {
                    getView(i, childAt, absListView);
                }
            }
        }
    }

    public void a(AbsListView absListView, String str, String str2) {
        int count;
        int firstVisiblePosition;
        View childAt;
        com.baidu.live.gift.c go;
        if (!TextUtils.isEmpty(str) && (count = getCount()) != 0) {
            int i = 0;
            while (true) {
                if (i >= count) {
                    i = -1;
                    break;
                }
                g item = getItem(i);
                if (item != null && !TextUtils.isEmpty(item.CC()) && (go = com.baidu.live.gift.c.b.Gb().go(item.CC())) != null && !TextUtils.isEmpty(go.getDynamicGiftId()) && go.getDynamicGiftId().equals(str) && ac.fV(item.CC()).equals(str2)) {
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
        if (this.aWy == null) {
            return 0;
        }
        return this.aWy.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: cN */
    public g getItem(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.aWy.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0172a c0172a;
        int i2;
        String formatGiftNumForTDouDisPlay;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.ala_gift_list_item, viewGroup, false);
            view.setBackgroundResource(a.e.sdk_transparent_bg);
            C0172a c0172a2 = new C0172a();
            c0172a2.aWH = (TbImageView) view.findViewById(a.f.gift_thumbnail);
            c0172a2.aWH.setDefaultBgResource(a.e.icon_live_gift_default);
            c0172a2.aWH.setDefaultErrorResource(a.e.icon_live_gift_default);
            c0172a2.aWH.setAutoChangeStyle(false);
            c0172a2.aWK = view.findViewById(a.f.layout_gift_item_name);
            c0172a2.aWL = (TextView) view.findViewById(a.f.gift_name);
            c0172a2.aWM = (TextView) view.findViewById(a.f.tv_gift_item_longpress_tip);
            c0172a2.aWN = (TextView) view.findViewById(a.f.gift_price);
            c0172a2.aWI = (RelativeLayout) view.findViewById(a.f.llCarom);
            c0172a2.aWO = (TextView) view.findViewById(a.f.gift_carom_txt);
            c0172a2.aWQ = view.findViewById(a.f.in_progress);
            c0172a2.aWR = (LottieAnimationView) view.findViewById(a.f.lottie_downloading);
            c0172a2.aWR.loop(true);
            c0172a2.aWR.setAnimation("live_gift_panel_downloading.json");
            c0172a2.aWS = view.findViewById(a.f.selected_bg);
            c0172a2.aWP = (TextView) view.findViewById(a.f.tv_privilege);
            c0172a2.aWJ = (LinearLayout) view.findViewById(a.f.ll_privilege);
            c0172a2.aWT = (GiftPanelCountBadgeView) view.findViewById(a.f.badge_pkg_count);
            c0172a2.aWT.setPlusThreshold(999, true);
            c0172a2.aWU = (FrameLayout) view.findViewById(a.f.layout_script);
            c0172a2.aWV = (TextView) view.findViewById(a.f.tv_script);
            view.setTag(c0172a2);
            if (this.aWB <= 0 || this.aWC <= 0) {
                c0172a = c0172a2;
            } else {
                view.getLayoutParams().height = this.aWB;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c0172a2.aWH.getLayoutParams();
                layoutParams.width = this.aWC;
                layoutParams.height = this.aWC;
                layoutParams.topMargin = this.aWD;
                ((RelativeLayout.LayoutParams) c0172a2.aWK.getLayoutParams()).topMargin = this.aWE;
                c0172a = c0172a2;
            }
        } else {
            c0172a = (C0172a) view.getTag();
        }
        c0172a.EH();
        if (i == this.mSelectedPosition) {
            c0172a.EG();
        }
        g item = getItem(i);
        g.b bVar = item.aSS;
        c0172a.aWM.setTag(a.f.TAG_GIFT_ITEM, item);
        if (viewGroup.getChildCount() == i) {
            c0172a.aWM.setVisibility(4);
        }
        if (item != null) {
            if (item.isRed()) {
                c0172a.aWH.setImageResource(a.e.live_gift_red_enter);
                c0172a.aWL.setText(this.mContext.getString(a.h.sdk_red_pkt_send));
                c0172a.aWN.setText("");
            } else {
                c0172a.aWH.startLoad(item.getThumbnail_url(), 10, false);
                c0172a.aWL.setText(item.CD());
                boolean z = item instanceof aa;
                if (!z) {
                    double d = JavaTypesHelper.toDouble(String.valueOf(item.getPrice()), 0.0d);
                    if (d >= 100.0d && ((this.aWz || com.baidu.live.af.a.OJ().bru.aJH) && !item.CO())) {
                        formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
                    } else {
                        formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(item.getPrice()));
                    }
                    c0172a.aWN.setText(formatGiftNumForTDouDisPlay);
                    if (item.CO()) {
                        c0172a.aWN.setText(this.mContext.getString(a.h.ala_gift_price_flower_label, formatGiftNumForTDouDisPlay));
                    } else {
                        c0172a.aWN.setText(this.mContext.getString(a.h.ala_gift_price_tdou_label, formatGiftNumForTDouDisPlay));
                    }
                } else {
                    aa aaVar = (aa) item;
                    if (aaVar.DU() && aaVar.aUT != null && aaVar.aUT.size() > 0) {
                        StringBuilder sb = new StringBuilder("碎片进展");
                        int i3 = 0;
                        Iterator<aa.a> it = aaVar.aUT.iterator();
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
                        sb.append(aaVar.aUT.size());
                        sb.append("）");
                        c0172a.aWN.setText(sb.toString());
                    } else if (bVar != null) {
                        if (bVar.aTi > 0) {
                            c0172a.aWN.setText(aM(bVar.aTi) + " 失效");
                        } else if (bVar.aTi == -1) {
                            c0172a.aWN.setText("长久有效");
                        } else {
                            c0172a.aWN.setText("");
                        }
                    } else {
                        c0172a.aWN.setText("");
                    }
                }
                c0172a.aWI.setClickable(false);
                c0172a.aWI.setVisibility(8);
                c0172a.aWO.setBackgroundColor(0);
                c0172a.aWJ.setVisibility(8);
                c0172a.aWH.setAlpha(1.0f);
                c0172a.aWN.setAlpha(1.0f);
                c0172a.aWL.setAlpha(1.0f);
                c0172a.aWT.setVisibility(8);
                c0172a.aWQ.setVisibility(4);
                c0172a.aWR.cancelAnimation();
                if (!z) {
                    if (item.Db()) {
                        c0172a.aWH.setAlpha(0.5f);
                        c0172a.aWN.setAlpha(0.5f);
                        c0172a.aWL.setAlpha(0.5f);
                        c0172a.aWI.setVisibility(8);
                        c0172a.aWJ.setVisibility(0);
                        if (!TextUtils.isEmpty(item.Dc())) {
                            c0172a.aWP.setText(item.Dc());
                        } else {
                            c0172a.aWP.setText("");
                        }
                        String Dc = item.Dc();
                        if (item.CR()) {
                            if (item.CT()) {
                                c0172a.aWJ.setBackgroundResource(a.e.live_gift_item_script_lock_activity);
                            } else if (item.CU()) {
                                c0172a.aWJ.setBackgroundResource(a.e.live_gift_item_script_lock_power);
                            } else {
                                c0172a.aWJ.setBackgroundResource(a.e.live_gift_item_script_lock_level);
                            }
                        } else if (Dc.equals("活动")) {
                            c0172a.aWJ.setBackgroundResource(a.e.live_gift_item_script_lock_activity);
                        } else {
                            c0172a.aWJ.setBackgroundResource(a.e.live_gift_item_script_lock_level);
                        }
                    } else if (item.CP()) {
                        c0172a.aWI.setVisibility(0);
                        if (!com.baidu.live.gift.c.b.Gb().fJ(item.CC())) {
                            c0172a.aWO.setText(" ");
                            c0172a.aWO.setBackgroundResource(a.e.live_gift_panel_item_script_download);
                            c0172a.aWI.setTag(a.f.TAG_GIFT_ITEM, item);
                            c0172a.aWI.setTag(a.f.TAG_GIFT_VIEW_HOLDER, c0172a);
                            c0172a.aWI.setClickable(true);
                            c0172a.aWI.setOnClickListener(this.mOnClickListener);
                            if (com.baidu.live.gift.c.a.Ga().at(item.CC(), ac.fV(item.CC()))) {
                                c0172a.aWH.setAlpha(0.5f);
                                c0172a.aWN.setAlpha(0.5f);
                                c0172a.aWL.setAlpha(0.5f);
                                c0172a.aWQ.setVisibility(0);
                                c0172a.aWR.playAnimation();
                                c0172a.aWI.setVisibility(4);
                            } else if (com.baidu.live.gift.c.b.Gb().go(item.CC()) != null) {
                                c0172a.aWQ.setVisibility(4);
                                c0172a.aWR.cancelAnimation();
                                c0172a.aWI.setVisibility(0);
                            } else {
                                a(c0172a, item);
                            }
                        } else {
                            a(c0172a, item);
                        }
                    } else {
                        a(c0172a, item);
                    }
                } else if (bVar != null) {
                    if (bVar.aTh > 0) {
                        c0172a.aWT.setCount(bVar.aTh);
                        c0172a.aWT.setVisibility(0);
                    } else {
                        c0172a.aWT.setVisibility(8);
                    }
                }
            }
        }
        return view;
    }

    private void a(C0172a c0172a, g gVar) {
        c0172a.aWQ.setVisibility(4);
        c0172a.aWR.cancelAnimation();
        if (gVar.CR()) {
            c0172a.aWI.setVisibility(0);
            String Dc = gVar.Dc();
            c0172a.aWO.setText(Dc);
            if (gVar.CT()) {
                if (TextUtils.isEmpty(Dc)) {
                    c0172a.aWO.setText(a.h.ala_gift_type_activity);
                }
                c0172a.aWO.setBackgroundResource(a.e.live_gift_panel_item_script_activity);
            } else if (gVar.CS()) {
                if (TextUtils.isEmpty(Dc)) {
                    c0172a.aWO.setText(a.h.ala_gift_type_discount);
                }
                c0172a.aWO.setBackgroundResource(a.e.live_gift_panel_item_script_discount);
            } else if (gVar.CU()) {
                if (TextUtils.isEmpty(Dc)) {
                    c0172a.aWO.setText(a.h.ala_gift_type_privilege);
                }
                c0172a.aWO.setBackgroundResource(a.e.live_gift_panel_item_script_power);
            } else if (gVar.CW()) {
                if (TextUtils.isEmpty(Dc)) {
                    c0172a.aWO.setText(a.h.ala_gift_broadcast_txt);
                }
                c0172a.aWO.setBackgroundResource(a.e.live_gift_panel_item_script_broadcast);
            } else if (gVar.CV()) {
                if (TextUtils.isEmpty(Dc)) {
                    c0172a.aWO.setText(a.h.ala_gift_draw_txt);
                }
                c0172a.aWO.setBackgroundResource(a.e.live_gift_panel_item_script_graffiti);
            } else if (gVar.CY()) {
                if (TextUtils.isEmpty(Dc)) {
                    Dc = this.mContext.getString(a.h.ala_gift_type_new);
                    c0172a.aWO.setText(a.h.ala_gift_type_new);
                }
                if (Dc != null && Dc.length() == 1) {
                    c0172a.aWO.setBackgroundResource(a.e.live_gift_panel_item_script_new);
                } else {
                    c0172a.aWO.setBackgroundResource(a.e.live_gift_panel_item_script_new_wide);
                }
            } else {
                c0172a.aWI.setVisibility(8);
            }
        } else if (gVar.Df()) {
            c0172a.aWI.setVisibility(0);
            String Dc2 = gVar.Dc();
            if (TextUtils.isEmpty(Dc2)) {
                c0172a.aWO.setText(a.h.ala_gift_privilege_level);
            } else {
                c0172a.aWO.setText(Dc2);
            }
            c0172a.aWO.setBackgroundResource(a.e.live_gift_panel_item_script_level);
        } else if (gVar.Dd() && !this.aWF) {
            c0172a.aWH.setAlpha(0.5f);
            c0172a.aWN.setAlpha(0.5f);
            c0172a.aWL.setAlpha(0.5f);
            c0172a.aWI.setVisibility(8);
            c0172a.aWJ.setBackgroundResource(a.e.live_gift_item_script_lock_level);
            c0172a.aWJ.setVisibility(0);
            c0172a.aWP.setText(a.h.ala_gift_privilege_throne);
        } else if (gVar.CL()) {
            c0172a.aWI.setVisibility(0);
            String Dc3 = gVar.Dc();
            if (TextUtils.isEmpty(Dc3)) {
                c0172a.aWO.setText(a.h.ala_gift_draw_txt);
            } else {
                c0172a.aWO.setText(Dc3);
            }
            c0172a.aWO.setBackgroundResource(a.e.live_gift_panel_item_script_graffiti);
        } else if (gVar.CM()) {
            c0172a.aWI.setVisibility(0);
            String Dc4 = gVar.Dc();
            if (TextUtils.isEmpty(Dc4)) {
                c0172a.aWO.setText(a.h.ala_gift_combo_txt);
            } else {
                c0172a.aWO.setText(Dc4);
            }
            c0172a.aWO.setBackgroundResource(a.e.live_gift_panel_item_script_graffiti);
        } else if (gVar.CZ()) {
            String Dc5 = gVar.Dc();
            if (TextUtils.isEmpty(Dc5)) {
                c0172a.aWO.setText(a.h.ala_gift_broadcast_txt);
            } else {
                c0172a.aWO.setText(Dc5);
            }
            c0172a.aWO.setBackgroundResource(a.e.live_gift_panel_item_script_broadcast);
        } else if (!TextUtils.isEmpty(gVar.Dc())) {
            String Dc6 = gVar.Dc();
            c0172a.aWI.setVisibility(0);
            c0172a.aWO.setText(Dc6);
            if ("活动".equals(Dc6)) {
                c0172a.aWO.setBackgroundResource(a.e.live_gift_panel_item_script_activity);
            } else if ("折扣".equals(Dc6)) {
                c0172a.aWO.setBackgroundResource(a.e.live_gift_panel_item_script_discount);
            } else if (Dc6 != null && Dc6.length() == 1) {
                c0172a.aWO.setBackgroundResource(a.e.live_gift_panel_item_script_new);
            } else {
                c0172a.aWO.setBackgroundResource(a.e.live_gift_panel_item_script_new_wide);
            }
        } else {
            c0172a.aWI.setVisibility(8);
        }
    }

    /* renamed from: com.baidu.live.gift.container.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0172a {
        public TbImageView aWH;
        public RelativeLayout aWI;
        public LinearLayout aWJ;
        public View aWK;
        public TextView aWL;
        public TextView aWM;
        public TextView aWN;
        public TextView aWO;
        public TextView aWP;
        public View aWQ;
        public LottieAnimationView aWR;
        public View aWS;
        public GiftPanelCountBadgeView aWT;
        public FrameLayout aWU;
        public TextView aWV;
        public AnimatorSet aWW;

        public void recycle() {
            if (this.aWR != null) {
                this.aWR.cancelAnimation();
            }
            EI();
        }

        public void EG() {
            if (this.aWS != null) {
                this.aWS.setVisibility(0);
            }
            N(this.aWH);
        }

        public void EH() {
            if (this.aWS != null) {
                this.aWS.setVisibility(8);
            }
            EI();
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
            this.aWW = new AnimatorSet();
            this.aWW.play(ofFloat).with(ofFloat2);
            this.aWW.start();
        }

        public void EI() {
            if (this.aWW != null) {
                this.aWW.cancel();
                this.aWW = null;
            }
        }
    }

    private static String aM(long j) {
        if (aWA == null) {
            aWA = new SimpleDateFormat("yyyy.MM.dd");
        }
        return aWA.format(Long.valueOf(1000 * j));
    }
}

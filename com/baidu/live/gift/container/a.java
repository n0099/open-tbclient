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
    private static SimpleDateFormat bbo;
    private int bbp;
    private int bbq;
    private int bbr;
    private int bbs;
    private boolean bbt;
    private final Context mContext;
    private int bbl = -1;
    private int mSelectedPosition = -1;
    private boolean bbn = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.gift.container.a.1
        private void a(g gVar, C0181a c0181a) {
            com.baidu.live.gift.c hA;
            if (gVar.GK() && !com.baidu.live.gift.c.b.JW().gV(gVar.Gx()) && (hA = com.baidu.live.gift.c.b.JW().hA(gVar.Gx())) != null) {
                com.baidu.live.gift.c.a.JV().a(hA.aXb, true);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view.getTag(a.f.TAG_GIFT_ITEM) instanceof g) && (view.getTag(a.f.TAG_GIFT_VIEW_HOLDER) instanceof C0181a)) {
                C0181a c0181a = (C0181a) view.getTag(a.f.TAG_GIFT_VIEW_HOLDER);
                g gVar = (g) view.getTag(a.f.TAG_GIFT_ITEM);
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(a.this.mContext.getApplicationContext(), a.this.mContext.getString(a.h.sdk_neterror));
                } else {
                    a(gVar, c0181a);
                }
            }
        }
    };
    private List<g> bbm = Collections.synchronizedList(new ArrayList());

    public a(Context context) {
        this.mContext = context;
    }

    public void setGiftItems(List<g> list) {
        if (this.bbm == null) {
            this.bbm = Collections.synchronizedList(new ArrayList());
        } else {
            this.bbm.clear();
        }
        if (list != null) {
            this.bbm.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void D(String str, int i) {
        if (this.bbm != null) {
            for (g gVar : this.bbm) {
                if (gVar.aXF != null && gVar.Gx().equals(str)) {
                    gVar.aXF.aXU = i;
                }
            }
            notifyDataSetChanged();
        }
    }

    public void eq(int i) {
        this.bbl = i;
    }

    public void er(int i) {
        this.mSelectedPosition = i;
    }

    public int IA() {
        return this.mSelectedPosition;
    }

    public void bE(boolean z) {
        this.bbn = z;
    }

    public void es(int i) {
        this.bbp = i;
        float dimensionPixelOffset = (i * 1.0f) / this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds192);
        this.bbq = (int) (this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds100) * dimensionPixelOffset);
        this.bbr = (int) (this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds12) * dimensionPixelOffset);
        this.bbs = (int) (dimensionPixelOffset * this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds8));
    }

    public void bl(boolean z) {
        this.bbt = z;
    }

    public void a(AbsListView absListView, boolean z) {
        int firstVisiblePosition;
        View childAt;
        this.bbt = z;
        int count = getCount();
        if (count != 0) {
            for (int i = 0; i < count; i++) {
                if (getItem(i).GY() && i >= (firstVisiblePosition = absListView.getFirstVisiblePosition()) && i <= absListView.getLastVisiblePosition() && (childAt = absListView.getChildAt(i - firstVisiblePosition)) != null) {
                    getView(i, childAt, absListView);
                }
            }
        }
    }

    public void a(AbsListView absListView, String str, String str2) {
        int count;
        int firstVisiblePosition;
        View childAt;
        com.baidu.live.gift.c hA;
        if (!TextUtils.isEmpty(str) && (count = getCount()) != 0) {
            int i = 0;
            while (true) {
                if (i >= count) {
                    i = -1;
                    break;
                }
                g item = getItem(i);
                if (item != null && !TextUtils.isEmpty(item.Gx()) && (hA = com.baidu.live.gift.c.b.JW().hA(item.Gx())) != null && !TextUtils.isEmpty(hA.getDynamicGiftId()) && hA.getDynamicGiftId().equals(str) && ac.hh(item.Gx()).equals(str2)) {
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
        if (this.bbm == null) {
            return 0;
        }
        return this.bbm.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: et */
    public g getItem(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.bbm.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0181a c0181a;
        int i2;
        String formatGiftNumForTDouDisPlay;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.ala_gift_list_item, viewGroup, false);
            view.setBackgroundResource(a.e.sdk_transparent_bg);
            C0181a c0181a2 = new C0181a();
            c0181a2.bbv = (TbImageView) view.findViewById(a.f.gift_thumbnail);
            c0181a2.bbv.setDefaultBgResource(a.e.icon_live_gift_default);
            c0181a2.bbv.setDefaultErrorResource(a.e.icon_live_gift_default);
            c0181a2.bbv.setAutoChangeStyle(false);
            c0181a2.bby = view.findViewById(a.f.layout_gift_item_name);
            c0181a2.bbz = (TextView) view.findViewById(a.f.gift_name);
            c0181a2.bbA = (TextView) view.findViewById(a.f.tv_gift_item_longpress_tip);
            c0181a2.bbB = (TextView) view.findViewById(a.f.gift_price);
            c0181a2.bbw = (RelativeLayout) view.findViewById(a.f.llCarom);
            c0181a2.bbC = (TextView) view.findViewById(a.f.gift_carom_txt);
            c0181a2.bbE = view.findViewById(a.f.in_progress);
            c0181a2.bbF = (LottieAnimationView) view.findViewById(a.f.lottie_downloading);
            c0181a2.bbF.loop(true);
            c0181a2.bbF.setAnimation("live_gift_panel_downloading.json");
            c0181a2.bbG = view.findViewById(a.f.selected_bg);
            c0181a2.bbD = (TextView) view.findViewById(a.f.tv_privilege);
            c0181a2.bbx = (LinearLayout) view.findViewById(a.f.ll_privilege);
            c0181a2.bbH = (GiftPanelCountBadgeView) view.findViewById(a.f.badge_pkg_count);
            c0181a2.bbH.setPlusThreshold(999, true);
            c0181a2.bbI = (FrameLayout) view.findViewById(a.f.layout_script);
            c0181a2.bbJ = (TextView) view.findViewById(a.f.tv_script);
            view.setTag(c0181a2);
            if (this.bbp <= 0 || this.bbq <= 0) {
                c0181a = c0181a2;
            } else {
                view.getLayoutParams().height = this.bbp;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c0181a2.bbv.getLayoutParams();
                layoutParams.width = this.bbq;
                layoutParams.height = this.bbq;
                layoutParams.topMargin = this.bbr;
                ((RelativeLayout.LayoutParams) c0181a2.bby.getLayoutParams()).topMargin = this.bbs;
                c0181a = c0181a2;
            }
        } else {
            c0181a = (C0181a) view.getTag();
        }
        c0181a.IC();
        if (i == this.mSelectedPosition) {
            c0181a.IB();
        }
        g item = getItem(i);
        g.b bVar = item.aXF;
        c0181a.bbA.setTag(a.f.TAG_GIFT_ITEM, item);
        if (viewGroup.getChildCount() == i) {
            c0181a.bbA.setVisibility(4);
        }
        if (item != null) {
            if (item.isRed()) {
                c0181a.bbv.setImageResource(a.e.live_gift_red_enter);
                c0181a.bbz.setText(this.mContext.getString(a.h.sdk_red_pkt_send));
                c0181a.bbB.setText("");
            } else {
                c0181a.bbv.startLoad(item.getThumbnail_url(), 10, false);
                c0181a.bbz.setText(item.Gy());
                boolean z = item instanceof aa;
                if (!z) {
                    double d = JavaTypesHelper.toDouble(String.valueOf(item.getPrice()), 0.0d);
                    if (d >= 100.0d && ((this.bbn || com.baidu.live.af.a.SE().bwi.aOu) && !item.GJ())) {
                        formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
                    } else {
                        formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(item.getPrice()));
                    }
                    c0181a.bbB.setText(formatGiftNumForTDouDisPlay);
                    if (item.GJ()) {
                        c0181a.bbB.setText(this.mContext.getString(a.h.ala_gift_price_flower_label, formatGiftNumForTDouDisPlay));
                    } else {
                        c0181a.bbB.setText(this.mContext.getString(a.h.ala_gift_price_tdou_label, formatGiftNumForTDouDisPlay));
                    }
                } else {
                    aa aaVar = (aa) item;
                    if (aaVar.HP() && aaVar.aZG != null && aaVar.aZG.size() > 0) {
                        StringBuilder sb = new StringBuilder("碎片进展");
                        int i3 = 0;
                        Iterator<aa.a> it = aaVar.aZG.iterator();
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
                        sb.append(aaVar.aZG.size());
                        sb.append("）");
                        c0181a.bbB.setText(sb.toString());
                    } else if (bVar != null) {
                        if (bVar.aXV > 0) {
                            c0181a.bbB.setText(aM(bVar.aXV) + " 失效");
                        } else if (bVar.aXV == -1) {
                            c0181a.bbB.setText("长久有效");
                        } else {
                            c0181a.bbB.setText("");
                        }
                    } else {
                        c0181a.bbB.setText("");
                    }
                }
                c0181a.bbw.setClickable(false);
                c0181a.bbw.setVisibility(8);
                c0181a.bbC.setBackgroundColor(0);
                c0181a.bbx.setVisibility(8);
                c0181a.bbv.setAlpha(1.0f);
                c0181a.bbB.setAlpha(1.0f);
                c0181a.bbz.setAlpha(1.0f);
                c0181a.bbH.setVisibility(8);
                c0181a.bbE.setVisibility(4);
                c0181a.bbF.cancelAnimation();
                if (!z) {
                    if (item.GW()) {
                        c0181a.bbv.setAlpha(0.5f);
                        c0181a.bbB.setAlpha(0.5f);
                        c0181a.bbz.setAlpha(0.5f);
                        c0181a.bbw.setVisibility(8);
                        c0181a.bbx.setVisibility(0);
                        if (!TextUtils.isEmpty(item.GX())) {
                            c0181a.bbD.setText(item.GX());
                        } else {
                            c0181a.bbD.setText("");
                        }
                        String GX = item.GX();
                        if (item.GM()) {
                            if (item.GO()) {
                                c0181a.bbx.setBackgroundResource(a.e.live_gift_item_script_lock_activity);
                            } else if (item.GP()) {
                                c0181a.bbx.setBackgroundResource(a.e.live_gift_item_script_lock_power);
                            } else {
                                c0181a.bbx.setBackgroundResource(a.e.live_gift_item_script_lock_level);
                            }
                        } else if (GX.equals("活动")) {
                            c0181a.bbx.setBackgroundResource(a.e.live_gift_item_script_lock_activity);
                        } else {
                            c0181a.bbx.setBackgroundResource(a.e.live_gift_item_script_lock_level);
                        }
                    } else if (item.GK()) {
                        c0181a.bbw.setVisibility(0);
                        if (!com.baidu.live.gift.c.b.JW().gV(item.Gx())) {
                            c0181a.bbC.setText(" ");
                            c0181a.bbC.setBackgroundResource(a.e.live_gift_panel_item_script_download);
                            c0181a.bbw.setTag(a.f.TAG_GIFT_ITEM, item);
                            c0181a.bbw.setTag(a.f.TAG_GIFT_VIEW_HOLDER, c0181a);
                            c0181a.bbw.setClickable(true);
                            c0181a.bbw.setOnClickListener(this.mOnClickListener);
                            if (com.baidu.live.gift.c.a.JV().au(item.Gx(), ac.hh(item.Gx()))) {
                                c0181a.bbv.setAlpha(0.5f);
                                c0181a.bbB.setAlpha(0.5f);
                                c0181a.bbz.setAlpha(0.5f);
                                c0181a.bbE.setVisibility(0);
                                c0181a.bbF.playAnimation();
                                c0181a.bbw.setVisibility(4);
                            } else if (com.baidu.live.gift.c.b.JW().hA(item.Gx()) != null) {
                                c0181a.bbE.setVisibility(4);
                                c0181a.bbF.cancelAnimation();
                                c0181a.bbw.setVisibility(0);
                            } else {
                                a(c0181a, item);
                            }
                        } else {
                            a(c0181a, item);
                        }
                    } else {
                        a(c0181a, item);
                    }
                } else if (bVar != null) {
                    if (bVar.aXU > 0) {
                        c0181a.bbH.setCount(bVar.aXU);
                        c0181a.bbH.setVisibility(0);
                    } else {
                        c0181a.bbH.setVisibility(8);
                    }
                }
            }
        }
        return view;
    }

    private void a(C0181a c0181a, g gVar) {
        c0181a.bbE.setVisibility(4);
        c0181a.bbF.cancelAnimation();
        if (gVar.GM()) {
            c0181a.bbw.setVisibility(0);
            String GX = gVar.GX();
            c0181a.bbC.setText(GX);
            if (gVar.GO()) {
                if (TextUtils.isEmpty(GX)) {
                    c0181a.bbC.setText(a.h.ala_gift_type_activity);
                }
                c0181a.bbC.setBackgroundResource(a.e.live_gift_panel_item_script_activity);
            } else if (gVar.GN()) {
                if (TextUtils.isEmpty(GX)) {
                    c0181a.bbC.setText(a.h.ala_gift_type_discount);
                }
                c0181a.bbC.setBackgroundResource(a.e.live_gift_panel_item_script_discount);
            } else if (gVar.GP()) {
                if (TextUtils.isEmpty(GX)) {
                    c0181a.bbC.setText(a.h.ala_gift_type_privilege);
                }
                c0181a.bbC.setBackgroundResource(a.e.live_gift_panel_item_script_power);
            } else if (gVar.GR()) {
                if (TextUtils.isEmpty(GX)) {
                    c0181a.bbC.setText(a.h.ala_gift_broadcast_txt);
                }
                c0181a.bbC.setBackgroundResource(a.e.live_gift_panel_item_script_broadcast);
            } else if (gVar.GQ()) {
                if (TextUtils.isEmpty(GX)) {
                    c0181a.bbC.setText(a.h.ala_gift_draw_txt);
                }
                c0181a.bbC.setBackgroundResource(a.e.live_gift_panel_item_script_graffiti);
            } else if (gVar.GT()) {
                if (TextUtils.isEmpty(GX)) {
                    GX = this.mContext.getString(a.h.ala_gift_type_new);
                    c0181a.bbC.setText(a.h.ala_gift_type_new);
                }
                if (GX != null && GX.length() == 1) {
                    c0181a.bbC.setBackgroundResource(a.e.live_gift_panel_item_script_new);
                } else {
                    c0181a.bbC.setBackgroundResource(a.e.live_gift_panel_item_script_new_wide);
                }
            } else {
                c0181a.bbw.setVisibility(8);
            }
        } else if (gVar.Ha()) {
            c0181a.bbw.setVisibility(0);
            String GX2 = gVar.GX();
            if (TextUtils.isEmpty(GX2)) {
                c0181a.bbC.setText(a.h.ala_gift_privilege_level);
            } else {
                c0181a.bbC.setText(GX2);
            }
            c0181a.bbC.setBackgroundResource(a.e.live_gift_panel_item_script_level);
        } else if (gVar.GY() && !this.bbt) {
            c0181a.bbv.setAlpha(0.5f);
            c0181a.bbB.setAlpha(0.5f);
            c0181a.bbz.setAlpha(0.5f);
            c0181a.bbw.setVisibility(8);
            c0181a.bbx.setBackgroundResource(a.e.live_gift_item_script_lock_level);
            c0181a.bbx.setVisibility(0);
            c0181a.bbD.setText(a.h.ala_gift_privilege_throne);
        } else if (gVar.GG()) {
            c0181a.bbw.setVisibility(0);
            String GX3 = gVar.GX();
            if (TextUtils.isEmpty(GX3)) {
                c0181a.bbC.setText(a.h.ala_gift_draw_txt);
            } else {
                c0181a.bbC.setText(GX3);
            }
            c0181a.bbC.setBackgroundResource(a.e.live_gift_panel_item_script_graffiti);
        } else if (gVar.GH()) {
            c0181a.bbw.setVisibility(0);
            String GX4 = gVar.GX();
            if (TextUtils.isEmpty(GX4)) {
                c0181a.bbC.setText(a.h.ala_gift_combo_txt);
            } else {
                c0181a.bbC.setText(GX4);
            }
            c0181a.bbC.setBackgroundResource(a.e.live_gift_panel_item_script_graffiti);
        } else if (gVar.GU()) {
            String GX5 = gVar.GX();
            if (TextUtils.isEmpty(GX5)) {
                c0181a.bbC.setText(a.h.ala_gift_broadcast_txt);
            } else {
                c0181a.bbC.setText(GX5);
            }
            c0181a.bbC.setBackgroundResource(a.e.live_gift_panel_item_script_broadcast);
        } else if (!TextUtils.isEmpty(gVar.GX())) {
            String GX6 = gVar.GX();
            c0181a.bbw.setVisibility(0);
            c0181a.bbC.setText(GX6);
            if ("活动".equals(GX6)) {
                c0181a.bbC.setBackgroundResource(a.e.live_gift_panel_item_script_activity);
            } else if ("折扣".equals(GX6)) {
                c0181a.bbC.setBackgroundResource(a.e.live_gift_panel_item_script_discount);
            } else if (GX6 != null && GX6.length() == 1) {
                c0181a.bbC.setBackgroundResource(a.e.live_gift_panel_item_script_new);
            } else {
                c0181a.bbC.setBackgroundResource(a.e.live_gift_panel_item_script_new_wide);
            }
        } else {
            c0181a.bbw.setVisibility(8);
        }
    }

    /* renamed from: com.baidu.live.gift.container.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0181a {
        public TextView bbA;
        public TextView bbB;
        public TextView bbC;
        public TextView bbD;
        public View bbE;
        public LottieAnimationView bbF;
        public View bbG;
        public GiftPanelCountBadgeView bbH;
        public FrameLayout bbI;
        public TextView bbJ;
        public AnimatorSet bbK;
        public TbImageView bbv;
        public RelativeLayout bbw;
        public LinearLayout bbx;
        public View bby;
        public TextView bbz;

        public void recycle() {
            if (this.bbF != null) {
                this.bbF.cancelAnimation();
            }
            ID();
        }

        public void IB() {
            if (this.bbG != null) {
                this.bbG.setVisibility(0);
            }
            N(this.bbv);
        }

        public void IC() {
            if (this.bbG != null) {
                this.bbG.setVisibility(8);
            }
            ID();
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
            this.bbK = new AnimatorSet();
            this.bbK.play(ofFloat).with(ofFloat2);
            this.bbK.start();
        }

        public void ID() {
            if (this.bbK != null) {
                this.bbK.cancel();
                this.bbK = null;
            }
        }
    }

    private static String aM(long j) {
        if (bbo == null) {
            bbo = new SimpleDateFormat("yyyy.MM.dd");
        }
        return bbo.format(Long.valueOf(1000 * j));
    }
}

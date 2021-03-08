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
    private static SimpleDateFormat bbh;
    private int bbi;
    private int bbj;
    private int bbk;
    private int bbl;
    private boolean bbm;
    private final Context mContext;
    private int bbe = -1;
    private int mSelectedPosition = -1;
    private boolean bbg = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.gift.container.a.1
        private void a(g gVar, C0179a c0179a) {
            com.baidu.live.gift.c gS;
            if (gVar.Ei() && !com.baidu.live.gift.c.b.Hu().gk(gVar.DU()) && (gS = com.baidu.live.gift.c.b.Hu().gS(gVar.DU())) != null) {
                com.baidu.live.gift.c.a.Ht().a(gS.aWS, true);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view.getTag(a.f.TAG_GIFT_ITEM) instanceof g) && (view.getTag(a.f.TAG_GIFT_VIEW_HOLDER) instanceof C0179a)) {
                C0179a c0179a = (C0179a) view.getTag(a.f.TAG_GIFT_VIEW_HOLDER);
                g gVar = (g) view.getTag(a.f.TAG_GIFT_ITEM);
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(a.this.mContext.getApplicationContext(), a.this.mContext.getString(a.h.sdk_neterror));
                } else {
                    a(gVar, c0179a);
                }
            }
        }
    };
    private List<g> bbf = Collections.synchronizedList(new ArrayList());

    public a(Context context) {
        this.mContext = context;
    }

    public void setGiftItems(List<g> list) {
        if (this.bbf == null) {
            this.bbf = Collections.synchronizedList(new ArrayList());
        } else {
            this.bbf.clear();
        }
        if (list != null) {
            this.bbf.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void E(String str, int i) {
        if (this.bbf != null) {
            for (g gVar : this.bbf) {
                if (gVar.aXx != null && gVar.DU().equals(str)) {
                    gVar.aXx.aXM = i;
                }
            }
            notifyDataSetChanged();
        }
    }

    public void cQ(int i) {
        this.bbe = i;
    }

    public void cR(int i) {
        this.mSelectedPosition = i;
    }

    public int FY() {
        return this.mSelectedPosition;
    }

    public void bF(boolean z) {
        this.bbg = z;
    }

    public void cS(int i) {
        this.bbi = i;
        float dimensionPixelOffset = (i * 1.0f) / this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds192);
        this.bbj = (int) (this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds100) * dimensionPixelOffset);
        this.bbk = (int) (this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds12) * dimensionPixelOffset);
        this.bbl = (int) (dimensionPixelOffset * this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds8));
    }

    public void bj(boolean z) {
        this.bbm = z;
    }

    public void a(AbsListView absListView, boolean z) {
        int firstVisiblePosition;
        View childAt;
        this.bbm = z;
        int count = getCount();
        if (count != 0) {
            for (int i = 0; i < count; i++) {
                if (getItem(i).Ew() && i >= (firstVisiblePosition = absListView.getFirstVisiblePosition()) && i <= absListView.getLastVisiblePosition() && (childAt = absListView.getChildAt(i - firstVisiblePosition)) != null) {
                    getView(i, childAt, absListView);
                }
            }
        }
    }

    public void a(AbsListView absListView, String str, String str2) {
        int count;
        int firstVisiblePosition;
        View childAt;
        com.baidu.live.gift.c gS;
        if (!TextUtils.isEmpty(str) && (count = getCount()) != 0) {
            int i = 0;
            while (true) {
                if (i >= count) {
                    i = -1;
                    break;
                }
                g item = getItem(i);
                if (item != null && !TextUtils.isEmpty(item.DU()) && (gS = com.baidu.live.gift.c.b.Hu().gS(item.DU())) != null && !TextUtils.isEmpty(gS.getDynamicGiftId()) && gS.getDynamicGiftId().equals(str) && ac.gy(item.DU()).equals(str2)) {
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
        if (this.bbf == null) {
            return 0;
        }
        return this.bbf.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: cT */
    public g getItem(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.bbf.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0179a c0179a;
        int i2;
        String formatGiftNumForTDouDisPlay;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.ala_gift_list_item, viewGroup, false);
            view.setBackgroundResource(a.e.sdk_transparent_bg);
            C0179a c0179a2 = new C0179a();
            c0179a2.bbo = (TbImageView) view.findViewById(a.f.gift_thumbnail);
            c0179a2.bbo.setDefaultBgResource(a.e.icon_live_gift_default);
            c0179a2.bbo.setDefaultErrorResource(a.e.icon_live_gift_default);
            c0179a2.bbo.setAutoChangeStyle(false);
            c0179a2.bbr = view.findViewById(a.f.layout_gift_item_name);
            c0179a2.bbs = (TextView) view.findViewById(a.f.gift_name);
            c0179a2.bbt = (TextView) view.findViewById(a.f.tv_gift_item_longpress_tip);
            c0179a2.bbu = (TextView) view.findViewById(a.f.gift_price);
            c0179a2.bbp = (RelativeLayout) view.findViewById(a.f.llCarom);
            c0179a2.bbv = (TextView) view.findViewById(a.f.gift_carom_txt);
            c0179a2.bbx = view.findViewById(a.f.in_progress);
            c0179a2.bby = (LottieAnimationView) view.findViewById(a.f.lottie_downloading);
            c0179a2.bby.loop(true);
            c0179a2.bby.setAnimation("live_gift_panel_downloading.json");
            c0179a2.bbz = view.findViewById(a.f.selected_bg);
            c0179a2.bbw = (TextView) view.findViewById(a.f.tv_privilege);
            c0179a2.bbq = (LinearLayout) view.findViewById(a.f.ll_privilege);
            c0179a2.bbA = (GiftPanelCountBadgeView) view.findViewById(a.f.badge_pkg_count);
            c0179a2.bbA.setPlusThreshold(999, true);
            c0179a2.bbB = (FrameLayout) view.findViewById(a.f.layout_script);
            c0179a2.bbC = (TextView) view.findViewById(a.f.tv_script);
            view.setTag(c0179a2);
            a(view, c0179a2);
            c0179a = c0179a2;
        } else {
            c0179a = (C0179a) view.getTag();
        }
        a(view, c0179a);
        c0179a.Ga();
        if (i == this.mSelectedPosition) {
            c0179a.FZ();
        }
        g item = getItem(i);
        g.b bVar = item.aXx;
        c0179a.bbt.setTag(a.f.TAG_GIFT_ITEM, item);
        if (viewGroup.getChildCount() == i) {
            c0179a.bbt.setVisibility(4);
        }
        if (item != null) {
            if (item.isRed()) {
                c0179a.bbo.setImageResource(a.e.live_gift_red_enter);
                c0179a.bbs.setText(this.mContext.getString(a.h.sdk_red_pkt_send));
                c0179a.bbu.setText("");
            } else {
                c0179a.bbo.startLoad(item.getThumbnail_url(), 10, false);
                c0179a.bbs.setText(item.DV());
                boolean z = item instanceof aa;
                if (!z) {
                    double d = JavaTypesHelper.toDouble(String.valueOf(item.getPrice()), 0.0d);
                    if (d >= 100.0d && ((this.bbg || com.baidu.live.ae.a.Qm().bwx.aNR) && !item.Eh())) {
                        formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
                    } else {
                        formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(item.getPrice()));
                    }
                    c0179a.bbu.setText(formatGiftNumForTDouDisPlay);
                    if (item.Eh()) {
                        c0179a.bbu.setText(this.mContext.getString(a.h.ala_gift_price_flower_label, formatGiftNumForTDouDisPlay));
                    } else {
                        c0179a.bbu.setText(this.mContext.getString(a.h.ala_gift_price_tdou_label, formatGiftNumForTDouDisPlay));
                    }
                } else {
                    aa aaVar = (aa) item;
                    if (aaVar.Fn() && aaVar.aZB != null && aaVar.aZB.size() > 0) {
                        StringBuilder sb = new StringBuilder("碎片进展");
                        int i3 = 0;
                        Iterator<aa.a> it = aaVar.aZB.iterator();
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
                        sb.append(aaVar.aZB.size());
                        sb.append("）");
                        c0179a.bbu.setText(sb.toString());
                    } else if (bVar != null) {
                        if (bVar.aXN > 0) {
                            c0179a.bbu.setText(aP(bVar.aXN) + " 失效");
                        } else if (bVar.aXN == -1) {
                            c0179a.bbu.setText("长久有效");
                        } else {
                            c0179a.bbu.setText("");
                        }
                    } else {
                        c0179a.bbu.setText("");
                    }
                }
                c0179a.bbp.setClickable(false);
                c0179a.bbp.setVisibility(8);
                c0179a.bbv.setBackgroundColor(0);
                c0179a.bbq.setVisibility(8);
                c0179a.bbo.setAlpha(1.0f);
                c0179a.bbu.setAlpha(1.0f);
                c0179a.bbs.setAlpha(1.0f);
                c0179a.bbA.setVisibility(8);
                c0179a.bbx.setVisibility(4);
                c0179a.bby.cancelAnimation();
                if (!z) {
                    if (item.Eu()) {
                        c0179a.bbo.setAlpha(0.5f);
                        c0179a.bbu.setAlpha(0.5f);
                        c0179a.bbs.setAlpha(0.5f);
                        c0179a.bbp.setVisibility(8);
                        c0179a.bbq.setVisibility(0);
                        if (!TextUtils.isEmpty(item.Ev())) {
                            c0179a.bbw.setText(item.Ev());
                        } else {
                            c0179a.bbw.setText("");
                        }
                        String Ev = item.Ev();
                        if (item.Ek()) {
                            if (item.Em()) {
                                c0179a.bbq.setBackgroundResource(a.e.live_gift_item_script_lock_activity);
                            } else if (item.En()) {
                                c0179a.bbq.setBackgroundResource(a.e.live_gift_item_script_lock_power);
                            } else {
                                c0179a.bbq.setBackgroundResource(a.e.live_gift_item_script_lock_level);
                            }
                        } else if (Ev.equals("活动")) {
                            c0179a.bbq.setBackgroundResource(a.e.live_gift_item_script_lock_activity);
                        } else {
                            c0179a.bbq.setBackgroundResource(a.e.live_gift_item_script_lock_level);
                        }
                    } else if (item.Ei()) {
                        c0179a.bbp.setVisibility(0);
                        if (!com.baidu.live.gift.c.b.Hu().gk(item.DU())) {
                            c0179a.bbv.setText(" ");
                            c0179a.bbv.setBackgroundResource(a.e.live_gift_panel_item_script_download);
                            c0179a.bbp.setTag(a.f.TAG_GIFT_ITEM, item);
                            c0179a.bbp.setTag(a.f.TAG_GIFT_VIEW_HOLDER, c0179a);
                            c0179a.bbp.setClickable(true);
                            c0179a.bbp.setOnClickListener(this.mOnClickListener);
                            if (com.baidu.live.gift.c.a.Ht().at(item.DU(), ac.gy(item.DU()))) {
                                c0179a.bbo.setAlpha(0.5f);
                                c0179a.bbu.setAlpha(0.5f);
                                c0179a.bbs.setAlpha(0.5f);
                                c0179a.bbx.setVisibility(0);
                                c0179a.bby.playAnimation();
                                c0179a.bbp.setVisibility(4);
                            } else if (com.baidu.live.gift.c.b.Hu().gS(item.DU()) != null) {
                                c0179a.bbx.setVisibility(4);
                                c0179a.bby.cancelAnimation();
                                c0179a.bbp.setVisibility(0);
                            } else {
                                a(c0179a, item);
                            }
                        } else {
                            a(c0179a, item);
                        }
                    } else {
                        a(c0179a, item);
                    }
                } else if (bVar != null) {
                    if (bVar.aXM > 0) {
                        c0179a.bbA.setCount(bVar.aXM);
                        c0179a.bbA.setVisibility(0);
                    } else {
                        c0179a.bbA.setVisibility(8);
                    }
                }
            }
        }
        return view;
    }

    private void a(C0179a c0179a, g gVar) {
        c0179a.bbx.setVisibility(4);
        c0179a.bby.cancelAnimation();
        if (gVar.Ek()) {
            c0179a.bbp.setVisibility(0);
            String Ev = gVar.Ev();
            c0179a.bbv.setText(Ev);
            if (gVar.Em()) {
                if (TextUtils.isEmpty(Ev)) {
                    c0179a.bbv.setText(a.h.ala_gift_type_activity);
                }
                c0179a.bbv.setBackgroundResource(a.e.live_gift_panel_item_script_activity);
            } else if (gVar.El()) {
                if (TextUtils.isEmpty(Ev)) {
                    c0179a.bbv.setText(a.h.ala_gift_type_discount);
                }
                c0179a.bbv.setBackgroundResource(a.e.live_gift_panel_item_script_discount);
            } else if (gVar.En()) {
                if (TextUtils.isEmpty(Ev)) {
                    c0179a.bbv.setText(a.h.ala_gift_type_privilege);
                }
                c0179a.bbv.setBackgroundResource(a.e.live_gift_panel_item_script_power);
            } else if (gVar.Ep()) {
                if (TextUtils.isEmpty(Ev)) {
                    c0179a.bbv.setText(a.h.ala_gift_broadcast_txt);
                }
                c0179a.bbv.setBackgroundResource(a.e.live_gift_panel_item_script_broadcast);
            } else if (gVar.Eo()) {
                if (TextUtils.isEmpty(Ev)) {
                    c0179a.bbv.setText(a.h.ala_gift_draw_txt);
                }
                c0179a.bbv.setBackgroundResource(a.e.live_gift_panel_item_script_graffiti);
            } else if (gVar.Er()) {
                if (TextUtils.isEmpty(Ev)) {
                    Ev = this.mContext.getString(a.h.ala_gift_type_new);
                    c0179a.bbv.setText(a.h.ala_gift_type_new);
                }
                if (Ev != null && Ev.length() == 1) {
                    c0179a.bbv.setBackgroundResource(a.e.live_gift_panel_item_script_new);
                } else {
                    c0179a.bbv.setBackgroundResource(a.e.live_gift_panel_item_script_new_wide);
                }
            } else {
                c0179a.bbp.setVisibility(8);
            }
        } else if (gVar.Ey()) {
            c0179a.bbp.setVisibility(0);
            String Ev2 = gVar.Ev();
            if (TextUtils.isEmpty(Ev2)) {
                c0179a.bbv.setText(a.h.ala_gift_privilege_level);
            } else {
                c0179a.bbv.setText(Ev2);
            }
            c0179a.bbv.setBackgroundResource(a.e.live_gift_panel_item_script_level);
        } else if (gVar.Ew() && !this.bbm) {
            c0179a.bbo.setAlpha(0.5f);
            c0179a.bbu.setAlpha(0.5f);
            c0179a.bbs.setAlpha(0.5f);
            c0179a.bbp.setVisibility(8);
            c0179a.bbq.setBackgroundResource(a.e.live_gift_item_script_lock_level);
            c0179a.bbq.setVisibility(0);
            c0179a.bbw.setText(a.h.ala_gift_privilege_throne);
        } else if (gVar.Ee()) {
            c0179a.bbp.setVisibility(0);
            String Ev3 = gVar.Ev();
            if (TextUtils.isEmpty(Ev3)) {
                c0179a.bbv.setText(a.h.ala_gift_draw_txt);
            } else {
                c0179a.bbv.setText(Ev3);
            }
            c0179a.bbv.setBackgroundResource(a.e.live_gift_panel_item_script_graffiti);
        } else if (gVar.Ef()) {
            c0179a.bbp.setVisibility(0);
            String Ev4 = gVar.Ev();
            if (TextUtils.isEmpty(Ev4)) {
                c0179a.bbv.setText(a.h.ala_gift_combo_txt);
            } else {
                c0179a.bbv.setText(Ev4);
            }
            c0179a.bbv.setBackgroundResource(a.e.live_gift_panel_item_script_graffiti);
        } else if (gVar.Es()) {
            String Ev5 = gVar.Ev();
            if (TextUtils.isEmpty(Ev5)) {
                c0179a.bbv.setText(a.h.ala_gift_broadcast_txt);
            } else {
                c0179a.bbv.setText(Ev5);
            }
            c0179a.bbv.setBackgroundResource(a.e.live_gift_panel_item_script_broadcast);
        } else if (!TextUtils.isEmpty(gVar.Ev())) {
            String Ev6 = gVar.Ev();
            c0179a.bbp.setVisibility(0);
            c0179a.bbv.setText(Ev6);
            if ("活动".equals(Ev6)) {
                c0179a.bbv.setBackgroundResource(a.e.live_gift_panel_item_script_activity);
            } else if ("折扣".equals(Ev6)) {
                c0179a.bbv.setBackgroundResource(a.e.live_gift_panel_item_script_discount);
            } else if (Ev6 != null && Ev6.length() == 1) {
                c0179a.bbv.setBackgroundResource(a.e.live_gift_panel_item_script_new);
            } else {
                c0179a.bbv.setBackgroundResource(a.e.live_gift_panel_item_script_new_wide);
            }
        } else {
            c0179a.bbp.setVisibility(8);
        }
    }

    /* renamed from: com.baidu.live.gift.container.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0179a {
        public GiftPanelCountBadgeView bbA;
        public FrameLayout bbB;
        public TextView bbC;
        public AnimatorSet bbD;
        public TbImageView bbo;
        public RelativeLayout bbp;
        public LinearLayout bbq;
        public View bbr;
        public TextView bbs;
        public TextView bbt;
        public TextView bbu;
        public TextView bbv;
        public TextView bbw;
        public View bbx;
        public LottieAnimationView bby;
        public View bbz;

        public void recycle() {
            if (this.bby != null) {
                this.bby.cancelAnimation();
            }
            Gb();
        }

        public void FZ() {
            if (this.bbz != null) {
                this.bbz.setVisibility(0);
            }
            N(this.bbo);
        }

        public void Ga() {
            if (this.bbz != null) {
                this.bbz.setVisibility(8);
            }
            Gb();
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
            this.bbD = new AnimatorSet();
            this.bbD.play(ofFloat).with(ofFloat2);
            this.bbD.start();
        }

        public void Gb() {
            if (this.bbD != null) {
                this.bbD.cancel();
                this.bbD = null;
            }
        }
    }

    private void a(View view, C0179a c0179a) {
        if (this.bbi > 0 && this.bbj > 0) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams.height != this.bbi) {
                layoutParams.height = this.bbi;
                view.setLayoutParams(layoutParams);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) c0179a.bbo.getLayoutParams();
            if (layoutParams2.width != this.bbj || layoutParams2.height != this.bbj || layoutParams2.topMargin != this.bbk) {
                layoutParams2.width = this.bbj;
                layoutParams2.height = this.bbj;
                layoutParams2.topMargin = this.bbk;
                c0179a.bbo.setLayoutParams(layoutParams2);
            }
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) c0179a.bbr.getLayoutParams();
            if (layoutParams3.topMargin != this.bbl) {
                layoutParams3.topMargin = this.bbl;
                c0179a.bbr.setLayoutParams(layoutParams3);
            }
        }
    }

    private static String aP(long j) {
        if (bbh == null) {
            bbh = new SimpleDateFormat("yyyy.MM.dd");
        }
        return bbh.format(Long.valueOf(1000 * j));
    }
}

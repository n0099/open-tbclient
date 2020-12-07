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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private static SimpleDateFormat aZH;
    private int aZI;
    private int aZJ;
    private int aZK;
    private int aZL;
    private boolean aZM;
    private final Context mContext;
    private int aZE = -1;
    private int mSelectedPosition = -1;
    private boolean aZG = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.gift.container.a.1
        private void a(g gVar, C0187a c0187a) {
            com.baidu.live.gift.c hP;
            if (gVar.Hj() && !com.baidu.live.gift.c.b.Kv().hk(gVar.GX()) && (hP = com.baidu.live.gift.c.b.Kv().hP(gVar.GX())) != null) {
                com.baidu.live.gift.c.a.Ku().a(hP.aVv, true);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view.getTag(a.f.TAG_GIFT_ITEM) instanceof g) && (view.getTag(a.f.TAG_GIFT_VIEW_HOLDER) instanceof C0187a)) {
                C0187a c0187a = (C0187a) view.getTag(a.f.TAG_GIFT_VIEW_HOLDER);
                g gVar = (g) view.getTag(a.f.TAG_GIFT_ITEM);
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(a.this.mContext.getApplicationContext(), a.this.mContext.getString(a.h.sdk_neterror));
                } else {
                    a(gVar, c0187a);
                }
            }
        }
    };
    private List<g> aZF = Collections.synchronizedList(new ArrayList());

    public a(Context context) {
        this.mContext = context;
    }

    public void setGiftItems(List<g> list) {
        if (this.aZF == null) {
            this.aZF = Collections.synchronizedList(new ArrayList());
        } else {
            this.aZF.clear();
        }
        if (list != null) {
            this.aZF.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void C(String str, int i) {
        if (this.aZF != null) {
            for (g gVar : this.aZF) {
                if (gVar.aVZ != null && gVar.GX().equals(str)) {
                    gVar.aVZ.aWo = i;
                }
            }
            notifyDataSetChanged();
        }
    }

    public void es(int i) {
        this.aZE = i;
    }

    public void et(int i) {
        this.mSelectedPosition = i;
    }

    public int getSelectedPosition() {
        return this.mSelectedPosition;
    }

    public void bG(boolean z) {
        this.aZG = z;
    }

    public void eu(int i) {
        this.aZI = i;
        float dimensionPixelOffset = (i * 1.0f) / this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds192);
        this.aZJ = (int) (this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds100) * dimensionPixelOffset);
        this.aZK = (int) (this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds12) * dimensionPixelOffset);
        this.aZL = (int) (dimensionPixelOffset * this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds8));
    }

    public void bo(boolean z) {
        this.aZM = z;
    }

    public void a(AbsListView absListView, boolean z) {
        int firstVisiblePosition;
        View childAt;
        this.aZM = z;
        int count = getCount();
        if (count != 0) {
            for (int i = 0; i < count; i++) {
                if (getItem(i).Hx() && i >= (firstVisiblePosition = absListView.getFirstVisiblePosition()) && i <= absListView.getLastVisiblePosition() && (childAt = absListView.getChildAt(i - firstVisiblePosition)) != null) {
                    getView(i, childAt, absListView);
                }
            }
        }
    }

    public void a(AbsListView absListView, String str, String str2) {
        int count;
        int firstVisiblePosition;
        View childAt;
        com.baidu.live.gift.c hP;
        if (!TextUtils.isEmpty(str) && (count = getCount()) != 0) {
            int i = 0;
            while (true) {
                if (i >= count) {
                    i = -1;
                    break;
                }
                g item = getItem(i);
                if (item != null && !TextUtils.isEmpty(item.GX()) && (hP = com.baidu.live.gift.c.b.Kv().hP(item.GX())) != null && !TextUtils.isEmpty(hP.getDynamicGiftId()) && hP.getDynamicGiftId().equals(str) && ac.hw(item.GX()).equals(str2)) {
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
        if (this.aZF == null) {
            return 0;
        }
        return this.aZF.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ev */
    public g getItem(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.aZF.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0187a c0187a;
        int i2;
        String formatGiftNumForTDouDisPlay;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.ala_gift_list_item, viewGroup, false);
            view.setBackgroundResource(a.e.sdk_transparent_bg);
            C0187a c0187a2 = new C0187a();
            c0187a2.aZO = (TbImageView) view.findViewById(a.f.gift_thumbnail);
            c0187a2.aZO.setDefaultBgResource(a.e.icon_live_gift_default);
            c0187a2.aZO.setDefaultErrorResource(a.e.icon_live_gift_default);
            c0187a2.aZO.setAutoChangeStyle(false);
            c0187a2.aZR = view.findViewById(a.f.layout_gift_item_name);
            c0187a2.aZS = (TextView) view.findViewById(a.f.gift_name);
            c0187a2.aZT = (TextView) view.findViewById(a.f.tv_gift_item_longpress_tip);
            c0187a2.aZU = (TextView) view.findViewById(a.f.gift_price);
            c0187a2.aZP = (RelativeLayout) view.findViewById(a.f.llCarom);
            c0187a2.aZV = (TextView) view.findViewById(a.f.gift_carom_txt);
            c0187a2.aZX = view.findViewById(a.f.in_progress);
            c0187a2.aZY = (LottieAnimationView) view.findViewById(a.f.lottie_downloading);
            c0187a2.aZY.loop(true);
            c0187a2.aZY.setAnimation("live_gift_panel_downloading.json");
            c0187a2.aZZ = view.findViewById(a.f.selected_bg);
            c0187a2.aZW = (TextView) view.findViewById(a.f.tv_privilege);
            c0187a2.aZQ = (LinearLayout) view.findViewById(a.f.ll_privilege);
            c0187a2.baa = (GiftPanelCountBadgeView) view.findViewById(a.f.badge_pkg_count);
            c0187a2.baa.setPlusThreshold(999, true);
            c0187a2.bab = (FrameLayout) view.findViewById(a.f.layout_script);
            c0187a2.bac = (TextView) view.findViewById(a.f.tv_script);
            view.setTag(c0187a2);
            if (this.aZI <= 0 || this.aZJ <= 0) {
                c0187a = c0187a2;
            } else {
                view.getLayoutParams().height = this.aZI;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c0187a2.aZO.getLayoutParams();
                layoutParams.width = this.aZJ;
                layoutParams.height = this.aZJ;
                layoutParams.topMargin = this.aZK;
                ((RelativeLayout.LayoutParams) c0187a2.aZR.getLayoutParams()).topMargin = this.aZL;
                c0187a = c0187a2;
            }
        } else {
            c0187a = (C0187a) view.getTag();
        }
        c0187a.Ja();
        if (i == this.mSelectedPosition) {
            c0187a.IZ();
        }
        g item = getItem(i);
        g.b bVar = item.aVZ;
        c0187a.aZT.setTag(a.f.TAG_GIFT_ITEM, item);
        if (viewGroup.getChildCount() == i) {
            c0187a.aZT.setVisibility(4);
        }
        if (item != null) {
            if (item.isRed()) {
                c0187a.aZO.setImageResource(a.e.live_gift_red_enter);
                c0187a.aZS.setText(this.mContext.getString(a.h.sdk_red_pkt_send));
                c0187a.aZU.setText("");
            } else {
                c0187a.aZO.startLoad(item.getThumbnail_url(), 10, false);
                c0187a.aZS.setText(item.GY());
                boolean z = item instanceof aa;
                if (!z) {
                    double d = JavaTypesHelper.toDouble(String.valueOf(item.getPrice()), 0.0d);
                    if (d >= 100.0d && ((this.aZG || com.baidu.live.ae.a.RB().brA.aNQ) && !item.Hi())) {
                        formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
                    } else {
                        formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(item.getPrice()));
                    }
                    c0187a.aZU.setText(formatGiftNumForTDouDisPlay);
                    if (item.Hi()) {
                        c0187a.aZU.setText(this.mContext.getString(a.h.ala_gift_price_flower_label, formatGiftNumForTDouDisPlay));
                    } else {
                        c0187a.aZU.setText(this.mContext.getString(a.h.ala_gift_price_tdou_label, formatGiftNumForTDouDisPlay));
                    }
                } else {
                    aa aaVar = (aa) item;
                    if (aaVar.Io() && aaVar.aYb != null && aaVar.aYb.size() > 0) {
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
                        c0187a.aZU.setText(sb.toString());
                    } else if (bVar != null) {
                        if (bVar.aWp > 0) {
                            c0187a.aZU.setText(aN(bVar.aWp) + " 失效");
                        } else if (bVar.aWp == -1) {
                            c0187a.aZU.setText("长久有效");
                        } else {
                            c0187a.aZU.setText("");
                        }
                    } else {
                        c0187a.aZU.setText("");
                    }
                }
                c0187a.aZP.setClickable(false);
                c0187a.aZP.setVisibility(8);
                c0187a.aZV.setBackgroundColor(0);
                c0187a.aZQ.setVisibility(8);
                c0187a.aZO.setAlpha(1.0f);
                c0187a.aZU.setAlpha(1.0f);
                c0187a.aZS.setAlpha(1.0f);
                c0187a.baa.setVisibility(8);
                c0187a.aZX.setVisibility(4);
                c0187a.aZY.cancelAnimation();
                if (!z) {
                    if (item.Hv()) {
                        c0187a.aZO.setAlpha(0.5f);
                        c0187a.aZU.setAlpha(0.5f);
                        c0187a.aZS.setAlpha(0.5f);
                        c0187a.aZP.setVisibility(8);
                        c0187a.aZQ.setVisibility(0);
                        if (!TextUtils.isEmpty(item.Hw())) {
                            c0187a.aZW.setText(item.Hw());
                        } else {
                            c0187a.aZW.setText("");
                        }
                        String Hw = item.Hw();
                        if (item.Hl()) {
                            if (item.Hn()) {
                                c0187a.aZQ.setBackgroundResource(a.e.live_gift_item_script_lock_activity);
                            } else if (item.Ho()) {
                                c0187a.aZQ.setBackgroundResource(a.e.live_gift_item_script_lock_power);
                            } else {
                                c0187a.aZQ.setBackgroundResource(a.e.live_gift_item_script_lock_level);
                            }
                        } else if (Hw.equals("活动")) {
                            c0187a.aZQ.setBackgroundResource(a.e.live_gift_item_script_lock_activity);
                        } else {
                            c0187a.aZQ.setBackgroundResource(a.e.live_gift_item_script_lock_level);
                        }
                    } else if (item.Hj()) {
                        c0187a.aZP.setVisibility(0);
                        if (!com.baidu.live.gift.c.b.Kv().hk(item.GX())) {
                            c0187a.aZV.setText(" ");
                            c0187a.aZV.setBackgroundResource(a.e.live_gift_panel_item_script_download);
                            c0187a.aZP.setTag(a.f.TAG_GIFT_ITEM, item);
                            c0187a.aZP.setTag(a.f.TAG_GIFT_VIEW_HOLDER, c0187a);
                            c0187a.aZP.setClickable(true);
                            c0187a.aZP.setOnClickListener(this.mOnClickListener);
                            if (com.baidu.live.gift.c.a.Ku().aw(item.GX(), ac.hw(item.GX()))) {
                                c0187a.aZO.setAlpha(0.5f);
                                c0187a.aZU.setAlpha(0.5f);
                                c0187a.aZS.setAlpha(0.5f);
                                c0187a.aZX.setVisibility(0);
                                c0187a.aZY.playAnimation();
                                c0187a.aZP.setVisibility(4);
                            } else if (com.baidu.live.gift.c.b.Kv().hP(item.GX()) != null) {
                                c0187a.aZX.setVisibility(4);
                                c0187a.aZY.cancelAnimation();
                                c0187a.aZP.setVisibility(0);
                            } else {
                                a(c0187a, item);
                            }
                        } else {
                            a(c0187a, item);
                        }
                    } else {
                        a(c0187a, item);
                    }
                } else if (bVar != null) {
                    if (bVar.aWo > 0) {
                        c0187a.baa.setCount(bVar.aWo);
                        c0187a.baa.setVisibility(0);
                    } else {
                        c0187a.baa.setVisibility(8);
                    }
                }
            }
        }
        return view;
    }

    private void a(C0187a c0187a, g gVar) {
        c0187a.aZX.setVisibility(4);
        c0187a.aZY.cancelAnimation();
        if (gVar.Hl()) {
            c0187a.aZP.setVisibility(0);
            String Hw = gVar.Hw();
            c0187a.aZV.setText(Hw);
            if (gVar.Hn()) {
                if (TextUtils.isEmpty(Hw)) {
                    c0187a.aZV.setText(a.h.ala_gift_type_activity);
                }
                c0187a.aZV.setBackgroundResource(a.e.live_gift_panel_item_script_activity);
            } else if (gVar.Hm()) {
                if (TextUtils.isEmpty(Hw)) {
                    c0187a.aZV.setText(a.h.ala_gift_type_discount);
                }
                c0187a.aZV.setBackgroundResource(a.e.live_gift_panel_item_script_discount);
            } else if (gVar.Ho()) {
                if (TextUtils.isEmpty(Hw)) {
                    c0187a.aZV.setText(a.h.ala_gift_type_privilege);
                }
                c0187a.aZV.setBackgroundResource(a.e.live_gift_panel_item_script_power);
            } else if (gVar.Hq()) {
                if (TextUtils.isEmpty(Hw)) {
                    c0187a.aZV.setText(a.h.ala_gift_broadcast_txt);
                }
                c0187a.aZV.setBackgroundResource(a.e.live_gift_panel_item_script_broadcast);
            } else if (gVar.Hp()) {
                if (TextUtils.isEmpty(Hw)) {
                    c0187a.aZV.setText(a.h.ala_gift_draw_txt);
                }
                c0187a.aZV.setBackgroundResource(a.e.live_gift_panel_item_script_graffiti);
            } else if (gVar.Hs()) {
                if (TextUtils.isEmpty(Hw)) {
                    Hw = this.mContext.getString(a.h.ala_gift_type_new);
                    c0187a.aZV.setText(a.h.ala_gift_type_new);
                }
                if (Hw != null && Hw.length() == 1) {
                    c0187a.aZV.setBackgroundResource(a.e.live_gift_panel_item_script_new);
                } else {
                    c0187a.aZV.setBackgroundResource(a.e.live_gift_panel_item_script_new_wide);
                }
            } else {
                c0187a.aZP.setVisibility(8);
            }
        } else if (gVar.Hz()) {
            c0187a.aZP.setVisibility(0);
            String Hw2 = gVar.Hw();
            if (TextUtils.isEmpty(Hw2)) {
                c0187a.aZV.setText(a.h.ala_gift_privilege_level);
            } else {
                c0187a.aZV.setText(Hw2);
            }
            c0187a.aZV.setBackgroundResource(a.e.live_gift_panel_item_script_level);
        } else if (gVar.Hx() && !this.aZM) {
            c0187a.aZO.setAlpha(0.5f);
            c0187a.aZU.setAlpha(0.5f);
            c0187a.aZS.setAlpha(0.5f);
            c0187a.aZP.setVisibility(8);
            c0187a.aZQ.setBackgroundResource(a.e.live_gift_item_script_lock_level);
            c0187a.aZQ.setVisibility(0);
            c0187a.aZW.setText(a.h.ala_gift_privilege_throne);
        } else if (gVar.Hf()) {
            c0187a.aZP.setVisibility(0);
            String Hw3 = gVar.Hw();
            if (TextUtils.isEmpty(Hw3)) {
                c0187a.aZV.setText(a.h.ala_gift_draw_txt);
            } else {
                c0187a.aZV.setText(Hw3);
            }
            c0187a.aZV.setBackgroundResource(a.e.live_gift_panel_item_script_graffiti);
        } else if (gVar.Hg()) {
            c0187a.aZP.setVisibility(0);
            String Hw4 = gVar.Hw();
            if (TextUtils.isEmpty(Hw4)) {
                c0187a.aZV.setText(a.h.ala_gift_combo_txt);
            } else {
                c0187a.aZV.setText(Hw4);
            }
            c0187a.aZV.setBackgroundResource(a.e.live_gift_panel_item_script_graffiti);
        } else if (gVar.Ht()) {
            String Hw5 = gVar.Hw();
            if (TextUtils.isEmpty(Hw5)) {
                c0187a.aZV.setText(a.h.ala_gift_broadcast_txt);
            } else {
                c0187a.aZV.setText(Hw5);
            }
            c0187a.aZV.setBackgroundResource(a.e.live_gift_panel_item_script_broadcast);
        } else if (!TextUtils.isEmpty(gVar.Hw())) {
            String Hw6 = gVar.Hw();
            c0187a.aZP.setVisibility(0);
            c0187a.aZV.setText(Hw6);
            if ("活动".equals(Hw6)) {
                c0187a.aZV.setBackgroundResource(a.e.live_gift_panel_item_script_activity);
            } else if ("折扣".equals(Hw6)) {
                c0187a.aZV.setBackgroundResource(a.e.live_gift_panel_item_script_discount);
            } else if (Hw6 != null && Hw6.length() == 1) {
                c0187a.aZV.setBackgroundResource(a.e.live_gift_panel_item_script_new);
            } else {
                c0187a.aZV.setBackgroundResource(a.e.live_gift_panel_item_script_new_wide);
            }
        } else {
            c0187a.aZP.setVisibility(8);
        }
    }

    /* renamed from: com.baidu.live.gift.container.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0187a {
        public TbImageView aZO;
        public RelativeLayout aZP;
        public LinearLayout aZQ;
        public View aZR;
        public TextView aZS;
        public TextView aZT;
        public TextView aZU;
        public TextView aZV;
        public TextView aZW;
        public View aZX;
        public LottieAnimationView aZY;
        public View aZZ;
        public GiftPanelCountBadgeView baa;
        public FrameLayout bab;
        public TextView bac;
        public AnimatorSet bad;

        public void recycle() {
            if (this.aZY != null) {
                this.aZY.cancelAnimation();
            }
            Jb();
        }

        public void IZ() {
            if (this.aZZ != null) {
                this.aZZ.setVisibility(0);
            }
            N(this.aZO);
        }

        public void Ja() {
            if (this.aZZ != null) {
                this.aZZ.setVisibility(8);
            }
            Jb();
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
            this.bad = new AnimatorSet();
            this.bad.play(ofFloat).with(ofFloat2);
            this.bad.start();
        }

        public void Jb() {
            if (this.bad != null) {
                this.bad.cancel();
                this.bad = null;
            }
        }
    }

    private static String aN(long j) {
        if (aZH == null) {
            aZH = new SimpleDateFormat("yyyy.MM.dd");
        }
        return aZH.format(Long.valueOf(1000 * j));
    }
}

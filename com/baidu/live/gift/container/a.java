package com.baidu.live.gift.container;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.gift.g;
import com.baidu.live.gift.v;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private static SimpleDateFormat aGT;
    private int aGU;
    private int aGV;
    private int aGW;
    private int aGX;
    private int aGY;
    private boolean aGZ;
    private TbPageContext mContext;
    private int mType;
    private int aGQ = -1;
    private int mSelectedPosition = -1;
    private boolean aGS = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.gift.container.a.1
        private void a(g gVar, C0163a c0163a) {
            com.baidu.live.gift.c fi;
            if (gVar.xx() && !com.baidu.live.gift.b.b.Ah().eJ(gVar.xl()) && (fi = com.baidu.live.gift.b.b.Ah().fi(gVar.xl())) != null) {
                com.baidu.live.gift.b.a.a(fi.aDK, true);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view.getTag(a.g.TAG_GIFT_ITEM) instanceof g) && (view.getTag(a.g.TAG_GIFT_VIEW_HOLDER) instanceof C0163a)) {
                C0163a c0163a = (C0163a) view.getTag(a.g.TAG_GIFT_VIEW_HOLDER);
                g gVar = (g) view.getTag(a.g.TAG_GIFT_ITEM);
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(a.this.mContext.getPageActivity(), a.this.mContext.getString(a.i.sdk_neterror));
                } else {
                    a(gVar, c0163a);
                }
            }
        }
    };
    private List<g> aGR = Collections.synchronizedList(new ArrayList());

    public a(TbPageContext tbPageContext, int i) {
        this.mContext = tbPageContext;
        this.mType = i;
    }

    public void setGiftItems(List<g> list) {
        if (this.aGR == null) {
            this.aGR = Collections.synchronizedList(new ArrayList());
        } else {
            this.aGR.clear();
        }
        if (list != null) {
            this.aGR.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void z(String str, int i) {
        if (this.aGR != null) {
            for (g gVar : this.aGR) {
                if (gVar.aEl != null && gVar.xl().equals(str)) {
                    gVar.aEl.aEs = i;
                }
            }
            notifyDataSetChanged();
        }
    }

    public void bR(int i) {
        this.aGQ = i;
    }

    public void bS(int i) {
        this.mSelectedPosition = i;
    }

    public int getSelectedPosition() {
        return this.mSelectedPosition;
    }

    public void bf(boolean z) {
        this.aGS = z;
    }

    public void bT(int i) {
        this.aGU = i;
        float dimensionPixelOffset = (i * 1.0f) / this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds192);
        this.aGV = (int) (this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds100) * dimensionPixelOffset);
        this.aGW = (int) (this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds12) * dimensionPixelOffset);
        this.aGX = (int) (this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds8) * dimensionPixelOffset);
        this.aGY = (int) (dimensionPixelOffset * this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds4));
    }

    public void aQ(boolean z) {
        this.aGZ = z;
    }

    public void a(AbsListView absListView, boolean z) {
        int firstVisiblePosition;
        View childAt;
        this.aGZ = z;
        int count = getCount();
        if (count != 0) {
            for (int i = 0; i < count; i++) {
                if (getItem(i).xK() && i >= (firstVisiblePosition = absListView.getFirstVisiblePosition()) && i <= absListView.getLastVisiblePosition() && (childAt = absListView.getChildAt(i - firstVisiblePosition)) != null) {
                    getView(i, childAt, absListView);
                }
            }
        }
    }

    public void a(AbsListView absListView, String str, String str2) {
        int count;
        int firstVisiblePosition;
        View childAt;
        com.baidu.live.gift.c fi;
        if (!TextUtils.isEmpty(str) && (count = getCount()) != 0) {
            int i = 0;
            while (true) {
                if (i >= count) {
                    i = -1;
                    break;
                }
                g item = getItem(i);
                if (item != null && !TextUtils.isEmpty(item.xl()) && (fi = com.baidu.live.gift.b.b.Ah().fi(item.xl())) != null && !TextUtils.isEmpty(fi.getDynamicGiftId()) && fi.getDynamicGiftId().equals(str) && v.eS(item.xl()).equals(str2)) {
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
        if (this.aGR == null) {
            return 0;
        }
        return this.aGR.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: bU */
    public g getItem(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.aGR.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0163a c0163a;
        g.a aVar;
        String formatGiftNumForTDouDisPlay;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.ala_gift_list_item, viewGroup, false);
            view.setBackgroundResource(a.f.sdk_transparent_bg);
            C0163a c0163a2 = new C0163a();
            c0163a2.aHb = (TbImageView) view.findViewById(a.g.gift_thumbnail);
            c0163a2.aHb.setDefaultBgResource(a.f.icon_live_gift_default);
            c0163a2.aHb.setDefaultErrorResource(a.f.icon_live_gift_default);
            c0163a2.aHb.setAutoChangeStyle(false);
            c0163a2.aHe = (TextView) view.findViewById(a.g.gift_name);
            c0163a2.aHf = (TextView) view.findViewById(a.g.gift_price);
            c0163a2.aHc = (RelativeLayout) view.findViewById(a.g.llCarom);
            c0163a2.aHg = (TextView) view.findViewById(a.g.gift_carom_txt);
            c0163a2.aHi = view.findViewById(a.g.in_progress);
            c0163a2.aHj = (LottieAnimationView) view.findViewById(a.g.lottie_downloading);
            c0163a2.aHj.loop(true);
            c0163a2.aHj.setAnimation("live_gift_panel_downloading.json");
            c0163a2.aHk = view.findViewById(a.g.selected_bg);
            c0163a2.aHh = (TextView) view.findViewById(a.g.tv_privilege);
            c0163a2.aHd = (LinearLayout) view.findViewById(a.g.ll_privilege);
            c0163a2.aHl = (FrameLayout) view.findViewById(a.g.layout_pkg_count);
            c0163a2.aHm = (ImageView) view.findViewById(a.g.iv_pkg_count);
            c0163a2.aHn = (TextView) view.findViewById(a.g.tv_pkg_count);
            c0163a2.aHo = (FrameLayout) view.findViewById(a.g.layout_script);
            c0163a2.aHp = (TextView) view.findViewById(a.g.tv_script);
            view.setTag(c0163a2);
            if (this.aGU <= 0 || this.aGV <= 0) {
                c0163a = c0163a2;
            } else {
                view.getLayoutParams().height = this.aGU;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c0163a2.aHb.getLayoutParams();
                layoutParams.width = this.aGV;
                layoutParams.height = this.aGV;
                layoutParams.topMargin = this.aGW;
                ((RelativeLayout.LayoutParams) c0163a2.aHe.getLayoutParams()).topMargin = this.aGX;
                ((RelativeLayout.LayoutParams) c0163a2.aHf.getLayoutParams()).topMargin = this.aGY;
                c0163a = c0163a2;
            }
        } else {
            c0163a = (C0163a) view.getTag();
        }
        c0163a.yV();
        if (i == this.mSelectedPosition) {
            c0163a.yU();
        }
        g item = getItem(i);
        if (this.mType != 1) {
            aVar = null;
        } else {
            aVar = item.aEl;
        }
        if (item != null) {
            if (item.isRed()) {
                c0163a.aHb.setImageResource(a.f.live_gift_red_enter);
                c0163a.aHe.setText(this.mContext.getPageActivity().getString(a.i.sdk_red_pkt_send));
                c0163a.aHf.setText("");
            } else {
                c0163a.aHb.startLoad(item.xo(), 10, false);
                c0163a.aHe.setText(item.xm());
                if (this.mType == 0) {
                    double d = JavaTypesHelper.toDouble(String.valueOf(item.getPrice()), 0.0d);
                    if (d >= 100.0d && ((this.aGS || com.baidu.live.v.a.Ge().aWF.axV) && !item.xw())) {
                        formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
                    } else {
                        formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(item.getPrice()));
                    }
                    c0163a.aHf.setText(formatGiftNumForTDouDisPlay);
                    if (item.xw()) {
                        c0163a.aHf.setText(this.mContext.getPageActivity().getString(a.i.ala_gift_price_flower_label, new Object[]{formatGiftNumForTDouDisPlay}));
                    } else {
                        c0163a.aHf.setText(this.mContext.getPageActivity().getString(a.i.ala_gift_price_tdou_label, new Object[]{formatGiftNumForTDouDisPlay}));
                    }
                } else if (this.mType == 1) {
                    if (aVar != null) {
                        c0163a.aHf.setText(aa(aVar.aEt) + " 失效");
                    } else {
                        c0163a.aHf.setText("");
                    }
                }
                c0163a.aHc.setClickable(false);
                c0163a.aHc.setVisibility(8);
                c0163a.aHg.setBackgroundColor(0);
                c0163a.aHd.setVisibility(8);
                c0163a.aHb.setAlpha(1.0f);
                c0163a.aHf.setAlpha(1.0f);
                c0163a.aHe.setAlpha(1.0f);
                c0163a.aHl.setVisibility(8);
                c0163a.aHi.setVisibility(4);
                c0163a.aHj.cancelAnimation();
                if (this.mType == 0) {
                    if (item.xI()) {
                        c0163a.aHb.setAlpha(0.5f);
                        c0163a.aHf.setAlpha(0.5f);
                        c0163a.aHe.setAlpha(0.5f);
                        c0163a.aHc.setVisibility(8);
                        c0163a.aHd.setVisibility(0);
                        if (!TextUtils.isEmpty(item.xJ())) {
                            c0163a.aHh.setText(item.xJ());
                        } else {
                            c0163a.aHh.setText("");
                        }
                        String xJ = item.xJ();
                        if (item.xz()) {
                            if (item.xB()) {
                                c0163a.aHd.setBackgroundResource(a.f.live_gift_item_script_lock_activity);
                            } else if (item.xC()) {
                                c0163a.aHd.setBackgroundResource(a.f.live_gift_item_script_lock_power);
                            } else {
                                c0163a.aHd.setBackgroundResource(a.f.live_gift_item_script_lock_level);
                            }
                        } else if (xJ.equals("活动")) {
                            c0163a.aHd.setBackgroundResource(a.f.live_gift_item_script_lock_activity);
                        } else {
                            c0163a.aHd.setBackgroundResource(a.f.live_gift_item_script_lock_level);
                        }
                    } else if (item.xx()) {
                        c0163a.aHc.setVisibility(0);
                        if (!com.baidu.live.gift.b.b.Ah().eJ(item.xl())) {
                            c0163a.aHg.setText(" ");
                            c0163a.aHg.setBackgroundResource(a.f.live_gift_panel_item_script_download);
                            c0163a.aHc.setTag(a.g.TAG_GIFT_ITEM, item);
                            c0163a.aHc.setTag(a.g.TAG_GIFT_VIEW_HOLDER, c0163a);
                            c0163a.aHc.setClickable(true);
                            c0163a.aHc.setOnClickListener(this.mOnClickListener);
                            if (com.baidu.live.gift.b.a.an(item.xl(), v.eS(item.xl()))) {
                                c0163a.aHb.setAlpha(0.5f);
                                c0163a.aHf.setAlpha(0.5f);
                                c0163a.aHe.setAlpha(0.5f);
                                c0163a.aHi.setVisibility(0);
                                c0163a.aHj.playAnimation();
                                c0163a.aHc.setVisibility(4);
                            } else {
                                c0163a.aHi.setVisibility(4);
                                c0163a.aHj.cancelAnimation();
                                c0163a.aHc.setVisibility(0);
                            }
                        } else {
                            a(c0163a, item);
                        }
                    } else {
                        a(c0163a, item);
                    }
                } else if (this.mType == 1 && aVar != null) {
                    if (aVar.aEs > 999) {
                        c0163a.aHm.setImageResource(a.f.live_icon_gift_panel_package_count_large);
                        c0163a.aHn.setText("999+");
                    } else {
                        c0163a.aHm.setImageResource(a.f.live_icon_gift_panel_package_count_small);
                        c0163a.aHn.setText(String.valueOf(aVar.aEs));
                    }
                    c0163a.aHl.setVisibility(0);
                }
            }
        }
        return view;
    }

    private void a(C0163a c0163a, g gVar) {
        c0163a.aHi.setVisibility(4);
        c0163a.aHj.cancelAnimation();
        if (gVar.xz()) {
            c0163a.aHc.setVisibility(0);
            String xJ = gVar.xJ();
            c0163a.aHg.setText(xJ);
            if (gVar.xB()) {
                if (TextUtils.isEmpty(xJ)) {
                    c0163a.aHg.setText(a.i.ala_gift_type_activity);
                }
                c0163a.aHg.setBackgroundResource(a.f.live_gift_panel_item_script_activity);
            } else if (gVar.xA()) {
                if (TextUtils.isEmpty(xJ)) {
                    c0163a.aHg.setText(a.i.ala_gift_type_discount);
                }
                c0163a.aHg.setBackgroundResource(a.f.live_gift_panel_item_script_discount);
            } else if (gVar.xC()) {
                if (TextUtils.isEmpty(xJ)) {
                    c0163a.aHg.setText(a.i.ala_gift_type_privilege);
                }
                c0163a.aHg.setBackgroundResource(a.f.live_gift_panel_item_script_power);
            } else if (gVar.xE()) {
                if (TextUtils.isEmpty(xJ)) {
                    c0163a.aHg.setText(a.i.ala_gift_broadcast_txt);
                }
                c0163a.aHg.setBackgroundResource(a.f.live_gift_panel_item_script_broadcast);
            } else if (gVar.xD()) {
                if (TextUtils.isEmpty(xJ)) {
                    c0163a.aHg.setText(a.i.ala_gift_draw_txt);
                }
                c0163a.aHg.setBackgroundResource(a.f.live_gift_panel_item_script_graffiti);
            } else if (gVar.xF()) {
                if (TextUtils.isEmpty(xJ)) {
                    xJ = this.mContext.getPageActivity().getString(a.i.ala_gift_type_new);
                    c0163a.aHg.setText(a.i.ala_gift_type_new);
                }
                if (xJ != null && xJ.length() == 1) {
                    c0163a.aHg.setBackgroundResource(a.f.live_gift_panel_item_script_new);
                } else {
                    c0163a.aHg.setBackgroundResource(a.f.live_gift_panel_item_script_new_wide);
                }
            } else {
                c0163a.aHc.setVisibility(8);
            }
        } else if (gVar.xL()) {
            c0163a.aHc.setVisibility(0);
            String xJ2 = gVar.xJ();
            if (TextUtils.isEmpty(xJ2)) {
                c0163a.aHg.setText(a.i.ala_gift_privilege_level);
            } else {
                c0163a.aHg.setText(xJ2);
            }
            c0163a.aHg.setBackgroundResource(a.f.live_gift_panel_item_script_level);
        } else if (gVar.xK() && !this.aGZ) {
            c0163a.aHb.setAlpha(0.5f);
            c0163a.aHf.setAlpha(0.5f);
            c0163a.aHe.setAlpha(0.5f);
            c0163a.aHc.setVisibility(8);
            c0163a.aHd.setBackgroundResource(a.f.live_gift_item_script_lock_level);
            c0163a.aHd.setVisibility(0);
            c0163a.aHh.setText(a.i.ala_gift_privilege_throne);
        } else if (gVar.xt()) {
            c0163a.aHc.setVisibility(0);
            String xJ3 = gVar.xJ();
            if (TextUtils.isEmpty(xJ3)) {
                c0163a.aHg.setText(a.i.ala_gift_draw_txt);
            } else {
                c0163a.aHg.setText(xJ3);
            }
            c0163a.aHg.setBackgroundResource(a.f.live_gift_panel_item_script_graffiti);
        } else if (gVar.xu()) {
            c0163a.aHc.setVisibility(0);
            String xJ4 = gVar.xJ();
            if (TextUtils.isEmpty(xJ4)) {
                c0163a.aHg.setText(a.i.ala_gift_combo_txt);
            } else {
                c0163a.aHg.setText(xJ4);
            }
            c0163a.aHg.setBackgroundResource(a.f.live_gift_panel_item_script_graffiti);
        } else if (gVar.xG()) {
            String xJ5 = gVar.xJ();
            if (TextUtils.isEmpty(xJ5)) {
                c0163a.aHg.setText(a.i.ala_gift_broadcast_txt);
            } else {
                c0163a.aHg.setText(xJ5);
            }
            c0163a.aHg.setBackgroundResource(a.f.live_gift_panel_item_script_broadcast);
        } else if (!TextUtils.isEmpty(gVar.xJ())) {
            String xJ6 = gVar.xJ();
            c0163a.aHc.setVisibility(0);
            c0163a.aHg.setText(xJ6);
            if ("活动".equals(xJ6)) {
                c0163a.aHg.setBackgroundResource(a.f.live_gift_panel_item_script_activity);
            } else if ("折扣".equals(xJ6)) {
                c0163a.aHg.setBackgroundResource(a.f.live_gift_panel_item_script_discount);
            } else if (xJ6 != null && xJ6.length() == 1) {
                c0163a.aHg.setBackgroundResource(a.f.live_gift_panel_item_script_new);
            } else {
                c0163a.aHg.setBackgroundResource(a.f.live_gift_panel_item_script_new_wide);
            }
        } else {
            c0163a.aHc.setVisibility(8);
        }
    }

    /* renamed from: com.baidu.live.gift.container.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0163a {
        public TbImageView aHb;
        public RelativeLayout aHc;
        public LinearLayout aHd;
        public TextView aHe;
        public TextView aHf;
        public TextView aHg;
        public TextView aHh;
        public View aHi;
        public LottieAnimationView aHj;
        public View aHk;
        public FrameLayout aHl;
        public ImageView aHm;
        public TextView aHn;
        public FrameLayout aHo;
        public TextView aHp;
        public AnimatorSet aHq;

        public void recycle() {
            if (this.aHj != null) {
                this.aHj.cancelAnimation();
            }
            yW();
        }

        public void yU() {
            if (this.aHk != null) {
                this.aHk.setVisibility(0);
            }
            M(this.aHb);
        }

        public void yV() {
            if (this.aHk != null) {
                this.aHk.setVisibility(8);
            }
            yW();
        }

        private void M(View view) {
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
            this.aHq = new AnimatorSet();
            this.aHq.play(ofFloat).with(ofFloat2);
            this.aHq.start();
        }

        public void yW() {
            if (this.aHq != null) {
                this.aHq.cancel();
                this.aHq = null;
            }
        }
    }

    private static String aa(long j) {
        if (aGT == null) {
            aGT = new SimpleDateFormat("MM.dd");
        }
        return aGT.format(Long.valueOf(1000 * j));
    }
}

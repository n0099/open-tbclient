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
import com.baidu.live.gift.aa;
import com.baidu.live.gift.g;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private static SimpleDateFormat aYc;
    private int aYd;
    private int aYe;
    private int aYf;
    private int aYg;
    private boolean aYh;
    private TbPageContext mContext;
    private int mType;
    private int aXZ = -1;
    private int mSelectedPosition = -1;
    private boolean aYb = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.gift.container.a.1
        private void a(g gVar, C0184a c0184a) {
            com.baidu.live.gift.c hx;
            if (gVar.Ge() && !com.baidu.live.gift.b.b.Je().gV(gVar.FT()) && (hx = com.baidu.live.gift.b.b.Je().hx(gVar.FT())) != null) {
                com.baidu.live.gift.b.a.Jd().a(hx.aUe, true);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view.getTag(a.f.TAG_GIFT_ITEM) instanceof g) && (view.getTag(a.f.TAG_GIFT_VIEW_HOLDER) instanceof C0184a)) {
                C0184a c0184a = (C0184a) view.getTag(a.f.TAG_GIFT_VIEW_HOLDER);
                g gVar = (g) view.getTag(a.f.TAG_GIFT_ITEM);
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(a.this.mContext.getPageActivity(), a.this.mContext.getString(a.h.sdk_neterror));
                } else {
                    a(gVar, c0184a);
                }
            }
        }
    };
    private List<g> aYa = Collections.synchronizedList(new ArrayList());

    public a(TbPageContext tbPageContext, int i) {
        this.mContext = tbPageContext;
        this.mType = i;
    }

    public void setGiftItems(List<g> list) {
        if (this.aYa == null) {
            this.aYa = Collections.synchronizedList(new ArrayList());
        } else {
            this.aYa.clear();
        }
        if (list != null) {
            this.aYa.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void A(String str, int i) {
        if (this.aYa != null) {
            for (g gVar : this.aYa) {
                if (gVar.aUI != null && gVar.FT().equals(str)) {
                    gVar.aUI.aUV = i;
                }
            }
            notifyDataSetChanged();
        }
    }

    public void ec(int i) {
        this.aXZ = i;
    }

    public void ed(int i) {
        this.mSelectedPosition = i;
    }

    public int getSelectedPosition() {
        return this.mSelectedPosition;
    }

    public void bv(boolean z) {
        this.aYb = z;
    }

    public void ee(int i) {
        this.aYd = i;
        float dimensionPixelOffset = (i * 1.0f) / this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds192);
        this.aYe = (int) (this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds100) * dimensionPixelOffset);
        this.aYf = (int) (this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds12) * dimensionPixelOffset);
        this.aYg = (int) (dimensionPixelOffset * this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds8));
    }

    public void be(boolean z) {
        this.aYh = z;
    }

    public void a(AbsListView absListView, boolean z) {
        int firstVisiblePosition;
        View childAt;
        this.aYh = z;
        int count = getCount();
        if (count != 0) {
            for (int i = 0; i < count; i++) {
                if (getItem(i).Gs() && i >= (firstVisiblePosition = absListView.getFirstVisiblePosition()) && i <= absListView.getLastVisiblePosition() && (childAt = absListView.getChildAt(i - firstVisiblePosition)) != null) {
                    getView(i, childAt, absListView);
                }
            }
        }
    }

    public void a(AbsListView absListView, String str, String str2) {
        int count;
        int firstVisiblePosition;
        View childAt;
        com.baidu.live.gift.c hx;
        if (!TextUtils.isEmpty(str) && (count = getCount()) != 0) {
            int i = 0;
            while (true) {
                if (i >= count) {
                    i = -1;
                    break;
                }
                g item = getItem(i);
                if (item != null && !TextUtils.isEmpty(item.FT()) && (hx = com.baidu.live.gift.b.b.Je().hx(item.FT())) != null && !TextUtils.isEmpty(hx.getDynamicGiftId()) && hx.getDynamicGiftId().equals(str) && aa.hh(item.FT()).equals(str2)) {
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
        if (this.aYa == null) {
            return 0;
        }
        return this.aYa.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ef */
    public g getItem(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.aYa.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0184a c0184a;
        String formatGiftNumForTDouDisPlay;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.g.ala_gift_list_item, viewGroup, false);
            view.setBackgroundResource(a.e.sdk_transparent_bg);
            C0184a c0184a2 = new C0184a();
            c0184a2.aYj = (TbImageView) view.findViewById(a.f.gift_thumbnail);
            c0184a2.aYj.setDefaultBgResource(a.e.icon_live_gift_default);
            c0184a2.aYj.setDefaultErrorResource(a.e.icon_live_gift_default);
            c0184a2.aYj.setAutoChangeStyle(false);
            c0184a2.aYm = view.findViewById(a.f.layout_gift_item_name);
            c0184a2.aYn = (TextView) view.findViewById(a.f.gift_name);
            c0184a2.aYo = (TextView) view.findViewById(a.f.tv_gift_item_longpress_tip);
            c0184a2.aYp = (TextView) view.findViewById(a.f.gift_price);
            c0184a2.aYk = (RelativeLayout) view.findViewById(a.f.llCarom);
            c0184a2.aYq = (TextView) view.findViewById(a.f.gift_carom_txt);
            c0184a2.aYs = view.findViewById(a.f.in_progress);
            c0184a2.aYt = (LottieAnimationView) view.findViewById(a.f.lottie_downloading);
            c0184a2.aYt.loop(true);
            c0184a2.aYt.setAnimation("live_gift_panel_downloading.json");
            c0184a2.aYu = view.findViewById(a.f.selected_bg);
            c0184a2.aYr = (TextView) view.findViewById(a.f.tv_privilege);
            c0184a2.aYl = (LinearLayout) view.findViewById(a.f.ll_privilege);
            c0184a2.aYv = (FrameLayout) view.findViewById(a.f.layout_pkg_count);
            c0184a2.aYw = (ImageView) view.findViewById(a.f.iv_pkg_count);
            c0184a2.aYx = (TextView) view.findViewById(a.f.tv_pkg_count);
            c0184a2.aYy = (FrameLayout) view.findViewById(a.f.layout_script);
            c0184a2.aYz = (TextView) view.findViewById(a.f.tv_script);
            view.setTag(c0184a2);
            if (this.aYd <= 0 || this.aYe <= 0) {
                c0184a = c0184a2;
            } else {
                view.getLayoutParams().height = this.aYd;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c0184a2.aYj.getLayoutParams();
                layoutParams.width = this.aYe;
                layoutParams.height = this.aYe;
                layoutParams.topMargin = this.aYf;
                ((RelativeLayout.LayoutParams) c0184a2.aYm.getLayoutParams()).topMargin = this.aYg;
                c0184a = c0184a2;
            }
        } else {
            c0184a = (C0184a) view.getTag();
        }
        c0184a.HT();
        if (i == this.mSelectedPosition) {
            c0184a.HS();
        }
        g item = getItem(i);
        g.b bVar = null;
        if (this.mType == 1) {
            bVar = item.aUI;
        }
        c0184a.aYo.setTag(a.f.TAG_GIFT_ITEM, item);
        if (viewGroup.getChildCount() == i) {
            c0184a.aYo.setVisibility(4);
        }
        if (item != null) {
            if (item.isRed()) {
                c0184a.aYj.setImageResource(a.e.live_gift_red_enter);
                c0184a.aYn.setText(this.mContext.getPageActivity().getString(a.h.sdk_red_pkt_send));
                c0184a.aYp.setText("");
            } else {
                c0184a.aYj.startLoad(item.getThumbnail_url(), 10, false);
                c0184a.aYn.setText(item.FU());
                if (this.mType == 0) {
                    double d = JavaTypesHelper.toDouble(String.valueOf(item.getPrice()), 0.0d);
                    if (d >= 100.0d && ((this.aYb || com.baidu.live.aa.a.PQ().bod.aMG) && !item.Gd())) {
                        formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
                    } else {
                        formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(item.getPrice()));
                    }
                    c0184a.aYp.setText(formatGiftNumForTDouDisPlay);
                    if (item.Gd()) {
                        c0184a.aYp.setText(this.mContext.getPageActivity().getString(a.h.ala_gift_price_flower_label, new Object[]{formatGiftNumForTDouDisPlay}));
                    } else {
                        c0184a.aYp.setText(this.mContext.getPageActivity().getString(a.h.ala_gift_price_tdou_label, new Object[]{formatGiftNumForTDouDisPlay}));
                    }
                } else if (this.mType == 1) {
                    if (bVar != null && bVar.aUW > 0) {
                        c0184a.aYp.setText(ap(bVar.aUW) + " 失效");
                    } else {
                        c0184a.aYp.setText("");
                    }
                }
                c0184a.aYk.setClickable(false);
                c0184a.aYk.setVisibility(8);
                c0184a.aYq.setBackgroundColor(0);
                c0184a.aYl.setVisibility(8);
                c0184a.aYj.setAlpha(1.0f);
                c0184a.aYp.setAlpha(1.0f);
                c0184a.aYn.setAlpha(1.0f);
                c0184a.aYv.setVisibility(8);
                c0184a.aYs.setVisibility(4);
                c0184a.aYt.cancelAnimation();
                if (this.mType == 0) {
                    if (item.Gq()) {
                        c0184a.aYj.setAlpha(0.5f);
                        c0184a.aYp.setAlpha(0.5f);
                        c0184a.aYn.setAlpha(0.5f);
                        c0184a.aYk.setVisibility(8);
                        c0184a.aYl.setVisibility(0);
                        if (!TextUtils.isEmpty(item.Gr())) {
                            c0184a.aYr.setText(item.Gr());
                        } else {
                            c0184a.aYr.setText("");
                        }
                        String Gr = item.Gr();
                        if (item.Gg()) {
                            if (item.Gi()) {
                                c0184a.aYl.setBackgroundResource(a.e.live_gift_item_script_lock_activity);
                            } else if (item.Gj()) {
                                c0184a.aYl.setBackgroundResource(a.e.live_gift_item_script_lock_power);
                            } else {
                                c0184a.aYl.setBackgroundResource(a.e.live_gift_item_script_lock_level);
                            }
                        } else if (Gr.equals("活动")) {
                            c0184a.aYl.setBackgroundResource(a.e.live_gift_item_script_lock_activity);
                        } else {
                            c0184a.aYl.setBackgroundResource(a.e.live_gift_item_script_lock_level);
                        }
                    } else if (item.Ge()) {
                        c0184a.aYk.setVisibility(0);
                        if (!com.baidu.live.gift.b.b.Je().gV(item.FT())) {
                            c0184a.aYq.setText(" ");
                            c0184a.aYq.setBackgroundResource(a.e.live_gift_panel_item_script_download);
                            c0184a.aYk.setTag(a.f.TAG_GIFT_ITEM, item);
                            c0184a.aYk.setTag(a.f.TAG_GIFT_VIEW_HOLDER, c0184a);
                            c0184a.aYk.setClickable(true);
                            c0184a.aYk.setOnClickListener(this.mOnClickListener);
                            if (com.baidu.live.gift.b.a.Jd().as(item.FT(), aa.hh(item.FT()))) {
                                c0184a.aYj.setAlpha(0.5f);
                                c0184a.aYp.setAlpha(0.5f);
                                c0184a.aYn.setAlpha(0.5f);
                                c0184a.aYs.setVisibility(0);
                                c0184a.aYt.playAnimation();
                                c0184a.aYk.setVisibility(4);
                            } else if (com.baidu.live.gift.b.b.Je().hx(item.FT()) != null) {
                                c0184a.aYs.setVisibility(4);
                                c0184a.aYt.cancelAnimation();
                                c0184a.aYk.setVisibility(0);
                            } else {
                                a(c0184a, item);
                            }
                        } else {
                            a(c0184a, item);
                        }
                    } else {
                        a(c0184a, item);
                    }
                } else if (this.mType == 1 && bVar != null) {
                    if (bVar.aUV > 999) {
                        c0184a.aYw.setImageResource(a.e.live_icon_gift_panel_package_count_large);
                        c0184a.aYx.setText("999+");
                    } else {
                        c0184a.aYw.setImageResource(a.e.live_icon_gift_panel_package_count_small);
                        c0184a.aYx.setText(String.valueOf(bVar.aUV));
                    }
                    c0184a.aYv.setVisibility(0);
                }
            }
        }
        return view;
    }

    private void a(C0184a c0184a, g gVar) {
        c0184a.aYs.setVisibility(4);
        c0184a.aYt.cancelAnimation();
        if (gVar.Gg()) {
            c0184a.aYk.setVisibility(0);
            String Gr = gVar.Gr();
            c0184a.aYq.setText(Gr);
            if (gVar.Gi()) {
                if (TextUtils.isEmpty(Gr)) {
                    c0184a.aYq.setText(a.h.ala_gift_type_activity);
                }
                c0184a.aYq.setBackgroundResource(a.e.live_gift_panel_item_script_activity);
            } else if (gVar.Gh()) {
                if (TextUtils.isEmpty(Gr)) {
                    c0184a.aYq.setText(a.h.ala_gift_type_discount);
                }
                c0184a.aYq.setBackgroundResource(a.e.live_gift_panel_item_script_discount);
            } else if (gVar.Gj()) {
                if (TextUtils.isEmpty(Gr)) {
                    c0184a.aYq.setText(a.h.ala_gift_type_privilege);
                }
                c0184a.aYq.setBackgroundResource(a.e.live_gift_panel_item_script_power);
            } else if (gVar.Gl()) {
                if (TextUtils.isEmpty(Gr)) {
                    c0184a.aYq.setText(a.h.ala_gift_broadcast_txt);
                }
                c0184a.aYq.setBackgroundResource(a.e.live_gift_panel_item_script_broadcast);
            } else if (gVar.Gk()) {
                if (TextUtils.isEmpty(Gr)) {
                    c0184a.aYq.setText(a.h.ala_gift_draw_txt);
                }
                c0184a.aYq.setBackgroundResource(a.e.live_gift_panel_item_script_graffiti);
            } else if (gVar.Gn()) {
                if (TextUtils.isEmpty(Gr)) {
                    Gr = this.mContext.getPageActivity().getString(a.h.ala_gift_type_new);
                    c0184a.aYq.setText(a.h.ala_gift_type_new);
                }
                if (Gr != null && Gr.length() == 1) {
                    c0184a.aYq.setBackgroundResource(a.e.live_gift_panel_item_script_new);
                } else {
                    c0184a.aYq.setBackgroundResource(a.e.live_gift_panel_item_script_new_wide);
                }
            } else {
                c0184a.aYk.setVisibility(8);
            }
        } else if (gVar.Gt()) {
            c0184a.aYk.setVisibility(0);
            String Gr2 = gVar.Gr();
            if (TextUtils.isEmpty(Gr2)) {
                c0184a.aYq.setText(a.h.ala_gift_privilege_level);
            } else {
                c0184a.aYq.setText(Gr2);
            }
            c0184a.aYq.setBackgroundResource(a.e.live_gift_panel_item_script_level);
        } else if (gVar.Gs() && !this.aYh) {
            c0184a.aYj.setAlpha(0.5f);
            c0184a.aYp.setAlpha(0.5f);
            c0184a.aYn.setAlpha(0.5f);
            c0184a.aYk.setVisibility(8);
            c0184a.aYl.setBackgroundResource(a.e.live_gift_item_script_lock_level);
            c0184a.aYl.setVisibility(0);
            c0184a.aYr.setText(a.h.ala_gift_privilege_throne);
        } else if (gVar.Ga()) {
            c0184a.aYk.setVisibility(0);
            String Gr3 = gVar.Gr();
            if (TextUtils.isEmpty(Gr3)) {
                c0184a.aYq.setText(a.h.ala_gift_draw_txt);
            } else {
                c0184a.aYq.setText(Gr3);
            }
            c0184a.aYq.setBackgroundResource(a.e.live_gift_panel_item_script_graffiti);
        } else if (gVar.Gb()) {
            c0184a.aYk.setVisibility(0);
            String Gr4 = gVar.Gr();
            if (TextUtils.isEmpty(Gr4)) {
                c0184a.aYq.setText(a.h.ala_gift_combo_txt);
            } else {
                c0184a.aYq.setText(Gr4);
            }
            c0184a.aYq.setBackgroundResource(a.e.live_gift_panel_item_script_graffiti);
        } else if (gVar.Go()) {
            String Gr5 = gVar.Gr();
            if (TextUtils.isEmpty(Gr5)) {
                c0184a.aYq.setText(a.h.ala_gift_broadcast_txt);
            } else {
                c0184a.aYq.setText(Gr5);
            }
            c0184a.aYq.setBackgroundResource(a.e.live_gift_panel_item_script_broadcast);
        } else if (!TextUtils.isEmpty(gVar.Gr())) {
            String Gr6 = gVar.Gr();
            c0184a.aYk.setVisibility(0);
            c0184a.aYq.setText(Gr6);
            if ("活动".equals(Gr6)) {
                c0184a.aYq.setBackgroundResource(a.e.live_gift_panel_item_script_activity);
            } else if ("折扣".equals(Gr6)) {
                c0184a.aYq.setBackgroundResource(a.e.live_gift_panel_item_script_discount);
            } else if (Gr6 != null && Gr6.length() == 1) {
                c0184a.aYq.setBackgroundResource(a.e.live_gift_panel_item_script_new);
            } else {
                c0184a.aYq.setBackgroundResource(a.e.live_gift_panel_item_script_new_wide);
            }
        } else {
            c0184a.aYk.setVisibility(8);
        }
    }

    /* renamed from: com.baidu.live.gift.container.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0184a {
        public AnimatorSet aYA;
        public TbImageView aYj;
        public RelativeLayout aYk;
        public LinearLayout aYl;
        public View aYm;
        public TextView aYn;
        public TextView aYo;
        public TextView aYp;
        public TextView aYq;
        public TextView aYr;
        public View aYs;
        public LottieAnimationView aYt;
        public View aYu;
        public FrameLayout aYv;
        public ImageView aYw;
        public TextView aYx;
        public FrameLayout aYy;
        public TextView aYz;

        public void recycle() {
            if (this.aYt != null) {
                this.aYt.cancelAnimation();
            }
            HU();
        }

        public void HS() {
            if (this.aYu != null) {
                this.aYu.setVisibility(0);
            }
            N(this.aYj);
        }

        public void HT() {
            if (this.aYu != null) {
                this.aYu.setVisibility(8);
            }
            HU();
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
            this.aYA = new AnimatorSet();
            this.aYA.play(ofFloat).with(ofFloat2);
            this.aYA.start();
        }

        public void HU() {
            if (this.aYA != null) {
                this.aYA.cancel();
                this.aYA = null;
            }
        }
    }

    private static String ap(long j) {
        if (aYc == null) {
            aYc = new SimpleDateFormat("MM.dd");
        }
        return aYc.format(Long.valueOf(1000 * j));
    }
}

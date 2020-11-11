package com.baidu.live.yuyingift.container;

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
import com.baidu.live.gift.ah;
import com.baidu.live.gift.ak;
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
    private int bPU;
    private TbPageContext mContext;
    private int mType;
    private int aXZ = -1;
    private int mSelectedPosition = -1;
    private boolean aYb = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.yuyingift.container.a.1
        private void a(g gVar, C0237a c0237a) {
            com.baidu.live.gift.c hx;
            if (gVar.Ge() && gVar.aUP == 0 && !com.baidu.live.yuyingift.b.b.XE().gV(gVar.FT()) && (hx = com.baidu.live.yuyingift.b.b.XE().hx(gVar.FT())) != null) {
                ak.Hx().a(hx.aUe, true, true);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view.getTag(a.f.TAG_GIFT_ITEM) instanceof g) && (view.getTag(a.f.TAG_GIFT_VIEW_HOLDER) instanceof C0237a)) {
                C0237a c0237a = (C0237a) view.getTag(a.f.TAG_GIFT_VIEW_HOLDER);
                g gVar = (g) view.getTag(a.f.TAG_GIFT_ITEM);
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(a.this.mContext.getPageActivity(), a.this.mContext.getString(a.h.sdk_neterror));
                } else {
                    a(gVar, c0237a);
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
        this.aYg = (int) (this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds8) * dimensionPixelOffset);
        this.bPU = (int) (dimensionPixelOffset * this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds4));
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

    public void a(AbsListView absListView, String str, String str2, int i) {
        int count;
        int firstVisiblePosition;
        View childAt;
        com.baidu.live.gift.c hx;
        if (!TextUtils.isEmpty(str) && (count = getCount()) != 0) {
            int i2 = 0;
            while (true) {
                if (i2 >= count) {
                    i2 = -1;
                    break;
                }
                g item = getItem(i2);
                if (item == null || TextUtils.isEmpty(item.FT()) || (hx = com.baidu.live.yuyingift.b.b.XE().hx(item.FT())) == null || TextUtils.isEmpty(hx.getDynamicGiftId()) || !hx.getDynamicGiftId().equals(str) || !TextUtils.equals(ah.hh(item.FT()), str2)) {
                    i2++;
                } else {
                    item.aUP = i;
                    break;
                }
            }
            if (i2 >= 0 && i2 >= (firstVisiblePosition = absListView.getFirstVisiblePosition()) && i2 <= absListView.getLastVisiblePosition() && (childAt = absListView.getChildAt(i2 - firstVisiblePosition)) != null) {
                getView(i2, childAt, absListView);
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
        C0237a c0237a;
        g.b bVar;
        String formatGiftNumForTDouDisPlay;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.g.yuyin_ala_gift_list_item, viewGroup, false);
            view.setBackgroundResource(a.e.sdk_transparent_bg);
            C0237a c0237a2 = new C0237a();
            c0237a2.aYj = (TbImageView) view.findViewById(a.f.gift_thumbnail);
            c0237a2.aYj.setDefaultBgResource(a.e.icon_live_gift_default);
            c0237a2.aYj.setDefaultErrorResource(a.e.icon_live_gift_default);
            c0237a2.aYj.setAutoChangeStyle(false);
            c0237a2.aYn = (TextView) view.findViewById(a.f.gift_name);
            c0237a2.aYp = (TextView) view.findViewById(a.f.gift_price);
            c0237a2.aYk = (RelativeLayout) view.findViewById(a.f.llCarom);
            c0237a2.bPX = (LottieAnimationView) view.findViewById(a.f.yuyin_ala_gift_lottie_downloading);
            c0237a2.bPW = (ImageView) view.findViewById(a.f.yuyin_gift_downloading_progress);
            c0237a2.aYq = (TextView) view.findViewById(a.f.gift_carom_txt);
            c0237a2.aYu = view.findViewById(a.f.selected_bg);
            c0237a2.aYr = (TextView) view.findViewById(a.f.tv_privilege);
            c0237a2.aYl = (LinearLayout) view.findViewById(a.f.ll_privilege);
            c0237a2.aYv = (FrameLayout) view.findViewById(a.f.layout_pkg_count);
            c0237a2.aYw = (ImageView) view.findViewById(a.f.iv_pkg_count);
            c0237a2.aYx = (TextView) view.findViewById(a.f.tv_pkg_count);
            c0237a2.aYy = (FrameLayout) view.findViewById(a.f.layout_script);
            c0237a2.aYz = (TextView) view.findViewById(a.f.tv_script);
            c0237a2.bPX.loop(true);
            c0237a2.bPX.setAnimation("yuyin_live_gift_panel_downloading.json");
            view.setTag(c0237a2);
            if (this.aYd <= 0 || this.aYe <= 0) {
                c0237a = c0237a2;
            } else {
                view.getLayoutParams().height = this.aYd;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c0237a2.aYj.getLayoutParams();
                layoutParams.width = this.aYe;
                layoutParams.height = this.aYe;
                layoutParams.topMargin = this.aYf;
                ((RelativeLayout.LayoutParams) c0237a2.aYn.getLayoutParams()).topMargin = this.aYg;
                ((RelativeLayout.LayoutParams) c0237a2.aYp.getLayoutParams()).topMargin = this.bPU;
                c0237a = c0237a2;
            }
        } else {
            c0237a = (C0237a) view.getTag();
        }
        c0237a.HT();
        if (i == this.mSelectedPosition) {
            c0237a.HS();
        }
        g item = getItem(i);
        if (this.mType != 1) {
            bVar = null;
        } else {
            bVar = item.aUI;
        }
        if (item != null) {
            if (item.isRed()) {
                c0237a.aYj.setImageResource(a.e.live_gift_red_enter);
                c0237a.bPW.setVisibility(8);
                c0237a.bPX.setVisibility(8);
                c0237a.bPX.cancelAnimation();
                c0237a.aYn.setText(this.mContext.getPageActivity().getString(a.h.sdk_red_pkt_send));
                c0237a.aYp.setText("");
            } else {
                c0237a.aYj.startLoad(item.getThumbnail_url(), 10, false);
                c0237a.aYn.setText(item.FU());
                if (this.mType == 0) {
                    double d = JavaTypesHelper.toDouble(String.valueOf(item.getPrice()), 0.0d);
                    if (d >= 100.0d && ((this.aYb || com.baidu.live.aa.a.PQ().bod.aMG) && !item.Gd())) {
                        formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
                    } else {
                        formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(item.getPrice()));
                    }
                    c0237a.aYp.setText(formatGiftNumForTDouDisPlay);
                    if (item.Gd()) {
                        c0237a.aYp.setText(this.mContext.getPageActivity().getString(a.h.ala_gift_price_flower_label, new Object[]{formatGiftNumForTDouDisPlay}));
                    } else {
                        c0237a.aYp.setText(this.mContext.getPageActivity().getString(a.h.ala_gift_price_tdou_label, new Object[]{formatGiftNumForTDouDisPlay}));
                    }
                } else if (this.mType == 1) {
                    if (bVar != null && bVar.aUW > 0) {
                        c0237a.aYp.setText(ap(bVar.aUW) + " 失效");
                    } else {
                        c0237a.aYp.setText("");
                    }
                }
                c0237a.aYk.setClickable(false);
                c0237a.aYk.setVisibility(8);
                c0237a.aYq.setBackgroundColor(0);
                c0237a.aYl.setVisibility(8);
                c0237a.aYj.setAlpha(1.0f);
                c0237a.aYp.setAlpha(1.0f);
                c0237a.aYn.setAlpha(1.0f);
                c0237a.aYv.setVisibility(8);
                c0237a.bPX.setVisibility(8);
                c0237a.bPW.setVisibility(8);
                if (this.mType == 0) {
                    if (item.Gq()) {
                        c0237a.aYj.setAlpha(0.5f);
                        c0237a.aYp.setAlpha(0.5f);
                        c0237a.aYn.setAlpha(0.5f);
                        c0237a.aYk.setVisibility(8);
                        c0237a.aYl.setVisibility(0);
                        if (!TextUtils.isEmpty(item.Gr())) {
                            c0237a.aYr.setText(item.Gr());
                        } else {
                            c0237a.aYr.setText("");
                        }
                        String Gr = item.Gr();
                        if (item.Gg()) {
                            if (item.Gi()) {
                                c0237a.aYl.setBackgroundResource(a.e.live_gift_item_script_lock_activity);
                            } else if (item.Gj()) {
                                c0237a.aYl.setBackgroundResource(a.e.live_gift_item_script_lock_power);
                            } else {
                                c0237a.aYl.setBackgroundResource(a.e.live_gift_item_script_lock_level);
                            }
                        } else if (Gr.equals("活动")) {
                            c0237a.aYl.setBackgroundResource(a.e.live_gift_item_script_lock_activity);
                        } else {
                            c0237a.aYl.setBackgroundResource(a.e.live_gift_item_script_lock_level);
                        }
                    } else if (item.Ge()) {
                        c0237a.aYk.setVisibility(0);
                        if (!com.baidu.live.yuyingift.b.b.XE().gV(item.FT())) {
                            c0237a.aYq.setText(" ");
                            c0237a.aYk.setClickable(true);
                            c0237a.bPW.setTag(a.f.TAG_GIFT_ITEM, item);
                            c0237a.bPW.setTag(a.f.TAG_GIFT_VIEW_HOLDER, c0237a);
                            c0237a.bPW.setOnClickListener(this.mOnClickListener);
                            if (item.aUP < 100) {
                                c0237a.aYj.setAlpha(0.5f);
                                c0237a.aYp.setAlpha(0.5f);
                                c0237a.aYn.setAlpha(0.5f);
                                c0237a.aYk.setVisibility(4);
                                if (item.aUP == 0) {
                                    c0237a.bPW.setVisibility(0);
                                    c0237a.bPX.setVisibility(8);
                                    c0237a.bPX.cancelAnimation();
                                } else {
                                    c0237a.bPX.setVisibility(0);
                                    c0237a.bPX.playAnimation();
                                }
                            } else if (com.baidu.live.yuyingift.b.b.XE().hx(item.FT()) != null) {
                                c0237a.bPX.setVisibility(8);
                                c0237a.bPX.cancelAnimation();
                                c0237a.aYk.setVisibility(0);
                            } else {
                                a(c0237a, item);
                            }
                        } else {
                            a(c0237a, item);
                        }
                    } else {
                        a(c0237a, item);
                    }
                } else if (this.mType == 1 && bVar != null) {
                    if (bVar.aUV > 999) {
                        c0237a.aYw.setImageResource(a.e.live_icon_gift_panel_package_count_large);
                        c0237a.aYx.setText("999+");
                    } else {
                        c0237a.aYw.setImageResource(a.e.live_icon_gift_panel_package_count_small);
                        c0237a.aYx.setText(String.valueOf(bVar.aUV));
                    }
                    c0237a.aYv.setVisibility(0);
                }
            }
        }
        return view;
    }

    private void a(C0237a c0237a, g gVar) {
        c0237a.bPW.setVisibility(8);
        c0237a.bPX.setVisibility(8);
        c0237a.bPX.cancelAnimation();
        if (gVar.Gg()) {
            c0237a.aYk.setVisibility(0);
            String Gr = gVar.Gr();
            c0237a.aYq.setText(Gr);
            if (gVar.Gi()) {
                if (TextUtils.isEmpty(Gr)) {
                    c0237a.aYq.setText(a.h.ala_gift_type_activity);
                }
                c0237a.aYq.setBackgroundResource(a.e.live_gift_panel_item_script_activity);
            } else if (gVar.Gh()) {
                if (TextUtils.isEmpty(Gr)) {
                    c0237a.aYq.setText(a.h.ala_gift_type_discount);
                }
                c0237a.aYq.setBackgroundResource(a.e.live_gift_panel_item_script_discount);
            } else if (gVar.Gj()) {
                if (TextUtils.isEmpty(Gr)) {
                    c0237a.aYq.setText(a.h.ala_gift_type_privilege);
                }
                c0237a.aYq.setBackgroundResource(a.e.live_gift_panel_item_script_power);
            } else if (gVar.Gl()) {
                if (TextUtils.isEmpty(Gr)) {
                    c0237a.aYq.setText(a.h.ala_gift_broadcast_txt);
                }
                c0237a.aYq.setBackgroundResource(a.e.live_gift_panel_item_script_broadcast);
            } else if (gVar.Gk()) {
                if (TextUtils.isEmpty(Gr)) {
                    c0237a.aYq.setText(a.h.ala_gift_draw_txt);
                }
                c0237a.aYq.setBackgroundResource(a.e.live_gift_panel_item_script_graffiti);
            } else if (gVar.Gn()) {
                if (TextUtils.isEmpty(Gr)) {
                    Gr = this.mContext.getPageActivity().getString(a.h.ala_gift_type_new);
                    c0237a.aYq.setText(a.h.ala_gift_type_new);
                }
                if (Gr != null && Gr.length() == 1) {
                    c0237a.aYq.setBackgroundResource(a.e.live_gift_panel_item_script_new);
                } else {
                    c0237a.aYq.setBackgroundResource(a.e.live_gift_panel_item_script_new_wide);
                }
            } else {
                c0237a.aYk.setVisibility(8);
            }
        } else if (gVar.Gt()) {
            c0237a.aYk.setVisibility(0);
            String Gr2 = gVar.Gr();
            if (TextUtils.isEmpty(Gr2)) {
                c0237a.aYq.setText(a.h.ala_gift_privilege_level);
            } else {
                c0237a.aYq.setText(Gr2);
            }
            c0237a.aYq.setBackgroundResource(a.e.live_gift_panel_item_script_level);
        } else if (gVar.Gs() && !this.aYh) {
            c0237a.aYj.setAlpha(0.5f);
            c0237a.aYp.setAlpha(0.5f);
            c0237a.aYn.setAlpha(0.5f);
            c0237a.aYk.setVisibility(8);
            c0237a.aYl.setBackgroundResource(a.e.live_gift_item_script_lock_level);
            c0237a.aYl.setVisibility(0);
            c0237a.aYr.setText(a.h.ala_gift_privilege_throne);
        } else if (gVar.Ga()) {
            c0237a.aYk.setVisibility(0);
            String Gr3 = gVar.Gr();
            if (TextUtils.isEmpty(Gr3)) {
                c0237a.aYq.setText(a.h.ala_gift_draw_txt);
            } else {
                c0237a.aYq.setText(Gr3);
            }
            c0237a.aYq.setBackgroundResource(a.e.live_gift_panel_item_script_graffiti);
        } else if (gVar.Gb()) {
            c0237a.aYk.setVisibility(0);
            String Gr4 = gVar.Gr();
            if (TextUtils.isEmpty(Gr4)) {
                c0237a.aYq.setText(a.h.ala_gift_combo_txt);
            } else {
                c0237a.aYq.setText(Gr4);
            }
            c0237a.aYq.setBackgroundResource(a.e.live_gift_panel_item_script_graffiti);
        } else if (gVar.Go()) {
            String Gr5 = gVar.Gr();
            if (TextUtils.isEmpty(Gr5)) {
                c0237a.aYq.setText(a.h.ala_gift_broadcast_txt);
            } else {
                c0237a.aYq.setText(Gr5);
            }
            c0237a.aYq.setBackgroundResource(a.e.live_gift_panel_item_script_broadcast);
        } else if (!TextUtils.isEmpty(gVar.Gr())) {
            String Gr6 = gVar.Gr();
            c0237a.aYk.setVisibility(0);
            c0237a.aYq.setText(Gr6);
            if ("活动".equals(Gr6)) {
                c0237a.aYq.setBackgroundResource(a.e.live_gift_panel_item_script_activity);
            } else if ("折扣".equals(Gr6)) {
                c0237a.aYq.setBackgroundResource(a.e.live_gift_panel_item_script_discount);
            } else if (Gr6 != null && Gr6.length() == 1) {
                c0237a.aYq.setBackgroundResource(a.e.live_gift_panel_item_script_new);
            } else {
                c0237a.aYq.setBackgroundResource(a.e.live_gift_panel_item_script_new_wide);
            }
        } else {
            c0237a.aYk.setVisibility(8);
        }
    }

    /* renamed from: com.baidu.live.yuyingift.container.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0237a {
        public AnimatorSet aYA;
        public TbImageView aYj;
        public RelativeLayout aYk;
        public LinearLayout aYl;
        public TextView aYn;
        public TextView aYp;
        public TextView aYq;
        public TextView aYr;
        public View aYu;
        public FrameLayout aYv;
        public ImageView aYw;
        public TextView aYx;
        public FrameLayout aYy;
        public TextView aYz;
        public ImageView bPW;
        public LottieAnimationView bPX;

        public void recycle() {
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

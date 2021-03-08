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
import com.baidu.live.gift.aj;
import com.baidu.live.gift.am;
import com.baidu.live.gift.g;
import com.baidu.live.lottie.LottieAnimationView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private static SimpleDateFormat bbh;
    private int bZT;
    private int bbi;
    private int bbj;
    private int bbk;
    private int bbl;
    private boolean bbm;
    private TbPageContext mContext;
    private int mType;
    private int bbe = -1;
    private int mSelectedPosition = -1;
    private boolean bbg = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.yuyingift.container.a.1
        private void a(g gVar, C0242a c0242a) {
            com.baidu.live.gift.c gS;
            if (gVar.Ei() && gVar.aXG == 0 && !com.baidu.live.yuyingift.b.b.Za().gk(gVar.DU()) && (gS = com.baidu.live.yuyingift.b.b.Za().gS(gVar.DU())) != null) {
                am.FF().a(gS.aWS, true);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view.getTag(a.f.TAG_GIFT_ITEM) instanceof g) && (view.getTag(a.f.TAG_GIFT_VIEW_HOLDER) instanceof C0242a)) {
                C0242a c0242a = (C0242a) view.getTag(a.f.TAG_GIFT_VIEW_HOLDER);
                g gVar = (g) view.getTag(a.f.TAG_GIFT_ITEM);
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(a.this.mContext.getPageActivity(), a.this.mContext.getString(a.h.sdk_neterror));
                } else {
                    a(gVar, c0242a);
                }
            }
        }
    };
    private List<g> bbf = Collections.synchronizedList(new ArrayList());

    public a(TbPageContext tbPageContext, int i) {
        this.mContext = tbPageContext;
        this.mType = i;
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
        this.bbl = (int) (this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds8) * dimensionPixelOffset);
        this.bZT = (int) (dimensionPixelOffset * this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds4));
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

    public void a(AbsListView absListView, String str, String str2, int i) {
        int count;
        int firstVisiblePosition;
        View childAt;
        com.baidu.live.gift.c gS;
        if (!TextUtils.isEmpty(str) && (count = getCount()) != 0) {
            int i2 = 0;
            while (true) {
                if (i2 >= count) {
                    i2 = -1;
                    break;
                }
                g item = getItem(i2);
                if (item == null || TextUtils.isEmpty(item.DU()) || (gS = com.baidu.live.yuyingift.b.b.Za().gS(item.DU())) == null || TextUtils.isEmpty(gS.getDynamicGiftId()) || !gS.getDynamicGiftId().equals(str) || !TextUtils.equals(aj.gy(item.DU()), str2)) {
                    i2++;
                } else {
                    item.aXG = i;
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
        C0242a c0242a;
        g.b bVar;
        String formatGiftNumForTDouDisPlay;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.g.yuyin_ala_gift_list_item, viewGroup, false);
            view.setBackgroundResource(a.e.sdk_transparent_bg);
            C0242a c0242a2 = new C0242a();
            c0242a2.bbo = (TbImageView) view.findViewById(a.f.gift_thumbnail);
            c0242a2.bbo.setDefaultBgResource(a.e.icon_live_gift_default);
            c0242a2.bbo.setDefaultErrorResource(a.e.icon_live_gift_default);
            c0242a2.bbo.setAutoChangeStyle(false);
            c0242a2.bbs = (TextView) view.findViewById(a.f.gift_name);
            c0242a2.bbu = (TextView) view.findViewById(a.f.gift_price);
            c0242a2.bbp = (RelativeLayout) view.findViewById(a.f.llCarom);
            c0242a2.bZW = (LottieAnimationView) view.findViewById(a.f.yuyin_ala_gift_lottie_downloading);
            c0242a2.bZV = (ImageView) view.findViewById(a.f.yuyin_gift_downloading_progress);
            c0242a2.bbv = (TextView) view.findViewById(a.f.gift_carom_txt);
            c0242a2.bbz = view.findViewById(a.f.selected_bg);
            c0242a2.bbw = (TextView) view.findViewById(a.f.tv_privilege);
            c0242a2.bbq = (LinearLayout) view.findViewById(a.f.ll_privilege);
            c0242a2.bZX = (FrameLayout) view.findViewById(a.f.layout_pkg_count);
            c0242a2.bZY = (ImageView) view.findViewById(a.f.iv_pkg_count);
            c0242a2.bZZ = (TextView) view.findViewById(a.f.tv_pkg_count);
            c0242a2.bbB = (FrameLayout) view.findViewById(a.f.layout_script);
            c0242a2.bbC = (TextView) view.findViewById(a.f.tv_script);
            c0242a2.bZW.loop(true);
            c0242a2.bZW.setAnimation("yuyin_live_gift_panel_downloading.json");
            view.setTag(c0242a2);
            if (this.bbi <= 0 || this.bbj <= 0) {
                c0242a = c0242a2;
            } else {
                view.getLayoutParams().height = this.bbi;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c0242a2.bbo.getLayoutParams();
                layoutParams.width = this.bbj;
                layoutParams.height = this.bbj;
                layoutParams.topMargin = this.bbk;
                ((RelativeLayout.LayoutParams) c0242a2.bbs.getLayoutParams()).topMargin = this.bbl;
                ((RelativeLayout.LayoutParams) c0242a2.bbu.getLayoutParams()).topMargin = this.bZT;
                c0242a = c0242a2;
            }
        } else {
            c0242a = (C0242a) view.getTag();
        }
        c0242a.Ga();
        if (i == this.mSelectedPosition) {
            c0242a.FZ();
        }
        g item = getItem(i);
        if (this.mType != 1) {
            bVar = null;
        } else {
            bVar = item.aXx;
        }
        if (item != null) {
            if (item.isRed()) {
                c0242a.bbo.setImageResource(a.e.live_gift_red_enter);
                c0242a.bZV.setVisibility(8);
                c0242a.bZW.setVisibility(8);
                c0242a.bZW.cancelAnimation();
                c0242a.bbs.setText(this.mContext.getPageActivity().getString(a.h.sdk_red_pkt_send));
                c0242a.bbu.setText("");
            } else {
                c0242a.bbo.startLoad(item.getThumbnail_url(), 10, false);
                c0242a.bbs.setText(item.DV());
                if (this.mType == 0) {
                    double d = JavaTypesHelper.toDouble(String.valueOf(item.getPrice()), 0.0d);
                    if (d >= 100.0d && ((this.bbg || com.baidu.live.ae.a.Qm().bwx.aNR) && !item.Eh())) {
                        formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
                    } else {
                        formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(item.getPrice()));
                    }
                    c0242a.bbu.setText(formatGiftNumForTDouDisPlay);
                    if (item.Eh()) {
                        c0242a.bbu.setText(this.mContext.getPageActivity().getString(a.h.ala_gift_price_flower_label, new Object[]{formatGiftNumForTDouDisPlay}));
                    } else {
                        c0242a.bbu.setText(this.mContext.getPageActivity().getString(a.h.ala_gift_price_tdou_label, new Object[]{formatGiftNumForTDouDisPlay}));
                    }
                } else if (this.mType == 1) {
                    if (bVar != null && bVar.aXN > 0) {
                        c0242a.bbu.setText(aP(bVar.aXN) + " 失效");
                    } else {
                        c0242a.bbu.setText("");
                    }
                }
                c0242a.bbp.setClickable(false);
                c0242a.bbp.setVisibility(8);
                c0242a.bbv.setBackgroundColor(0);
                c0242a.bbq.setVisibility(8);
                c0242a.bbo.setAlpha(1.0f);
                c0242a.bbu.setAlpha(1.0f);
                c0242a.bbs.setAlpha(1.0f);
                c0242a.bZX.setVisibility(8);
                c0242a.bZW.setVisibility(8);
                c0242a.bZV.setVisibility(8);
                if (this.mType == 0) {
                    if (item.Eu()) {
                        c0242a.bbo.setAlpha(0.5f);
                        c0242a.bbu.setAlpha(0.5f);
                        c0242a.bbs.setAlpha(0.5f);
                        c0242a.bbp.setVisibility(8);
                        c0242a.bbq.setVisibility(0);
                        if (!TextUtils.isEmpty(item.Ev())) {
                            c0242a.bbw.setText(item.Ev());
                        } else {
                            c0242a.bbw.setText("");
                        }
                        String Ev = item.Ev();
                        if (item.Ek()) {
                            if (item.Em()) {
                                c0242a.bbq.setBackgroundResource(a.e.live_gift_item_script_lock_activity);
                            } else if (item.En()) {
                                c0242a.bbq.setBackgroundResource(a.e.live_gift_item_script_lock_power);
                            } else {
                                c0242a.bbq.setBackgroundResource(a.e.live_gift_item_script_lock_level);
                            }
                        } else if (Ev.equals("活动")) {
                            c0242a.bbq.setBackgroundResource(a.e.live_gift_item_script_lock_activity);
                        } else {
                            c0242a.bbq.setBackgroundResource(a.e.live_gift_item_script_lock_level);
                        }
                    } else if (item.Ei()) {
                        c0242a.bbp.setVisibility(0);
                        if (!com.baidu.live.yuyingift.b.b.Za().gk(item.DU())) {
                            c0242a.bbv.setText(" ");
                            c0242a.bbp.setClickable(true);
                            c0242a.bZV.setTag(a.f.TAG_GIFT_ITEM, item);
                            c0242a.bZV.setTag(a.f.TAG_GIFT_VIEW_HOLDER, c0242a);
                            c0242a.bZV.setOnClickListener(this.mOnClickListener);
                            if (item.aXG < 100) {
                                c0242a.bbo.setAlpha(0.5f);
                                c0242a.bbu.setAlpha(0.5f);
                                c0242a.bbs.setAlpha(0.5f);
                                c0242a.bbp.setVisibility(4);
                                if (item.aXG == 0) {
                                    c0242a.bZV.setVisibility(0);
                                    c0242a.bZW.setVisibility(8);
                                    c0242a.bZW.cancelAnimation();
                                } else {
                                    c0242a.bZW.setVisibility(0);
                                    c0242a.bZW.playAnimation();
                                }
                            } else if (com.baidu.live.yuyingift.b.b.Za().gS(item.DU()) != null) {
                                c0242a.bZW.setVisibility(8);
                                c0242a.bZW.cancelAnimation();
                                c0242a.bbp.setVisibility(0);
                            } else {
                                a(c0242a, item);
                            }
                        } else {
                            a(c0242a, item);
                        }
                    } else {
                        a(c0242a, item);
                    }
                } else if (this.mType == 1 && bVar != null) {
                    if (bVar.aXM > 999) {
                        c0242a.bZY.setImageResource(a.e.live_icon_gift_panel_package_count_large);
                        c0242a.bZZ.setText("999+");
                    } else {
                        c0242a.bZY.setImageResource(a.e.live_icon_gift_panel_package_count_small);
                        c0242a.bZZ.setText(String.valueOf(bVar.aXM));
                    }
                    c0242a.bZX.setVisibility(0);
                }
            }
        }
        return view;
    }

    private void a(C0242a c0242a, g gVar) {
        c0242a.bZV.setVisibility(8);
        c0242a.bZW.setVisibility(8);
        c0242a.bZW.cancelAnimation();
        if (gVar.Ek()) {
            c0242a.bbp.setVisibility(0);
            String Ev = gVar.Ev();
            c0242a.bbv.setText(Ev);
            if (gVar.Em()) {
                if (TextUtils.isEmpty(Ev)) {
                    c0242a.bbv.setText(a.h.ala_gift_type_activity);
                }
                c0242a.bbv.setBackgroundResource(a.e.live_gift_panel_item_script_activity);
            } else if (gVar.El()) {
                if (TextUtils.isEmpty(Ev)) {
                    c0242a.bbv.setText(a.h.ala_gift_type_discount);
                }
                c0242a.bbv.setBackgroundResource(a.e.live_gift_panel_item_script_discount);
            } else if (gVar.En()) {
                if (TextUtils.isEmpty(Ev)) {
                    c0242a.bbv.setText(a.h.ala_gift_type_privilege);
                }
                c0242a.bbv.setBackgroundResource(a.e.live_gift_panel_item_script_power);
            } else if (gVar.Ep()) {
                if (TextUtils.isEmpty(Ev)) {
                    c0242a.bbv.setText(a.h.ala_gift_broadcast_txt);
                }
                c0242a.bbv.setBackgroundResource(a.e.live_gift_panel_item_script_broadcast);
            } else if (gVar.Eo()) {
                if (TextUtils.isEmpty(Ev)) {
                    c0242a.bbv.setText(a.h.ala_gift_draw_txt);
                }
                c0242a.bbv.setBackgroundResource(a.e.live_gift_panel_item_script_graffiti);
            } else if (gVar.Er()) {
                if (TextUtils.isEmpty(Ev)) {
                    Ev = this.mContext.getPageActivity().getString(a.h.ala_gift_type_new);
                    c0242a.bbv.setText(a.h.ala_gift_type_new);
                }
                if (Ev != null && Ev.length() == 1) {
                    c0242a.bbv.setBackgroundResource(a.e.live_gift_panel_item_script_new);
                } else {
                    c0242a.bbv.setBackgroundResource(a.e.live_gift_panel_item_script_new_wide);
                }
            } else {
                c0242a.bbp.setVisibility(8);
            }
        } else if (gVar.Ey()) {
            c0242a.bbp.setVisibility(0);
            String Ev2 = gVar.Ev();
            if (TextUtils.isEmpty(Ev2)) {
                c0242a.bbv.setText(a.h.ala_gift_privilege_level);
            } else {
                c0242a.bbv.setText(Ev2);
            }
            c0242a.bbv.setBackgroundResource(a.e.live_gift_panel_item_script_level);
        } else if (gVar.Ew() && !this.bbm) {
            c0242a.bbo.setAlpha(0.5f);
            c0242a.bbu.setAlpha(0.5f);
            c0242a.bbs.setAlpha(0.5f);
            c0242a.bbp.setVisibility(8);
            c0242a.bbq.setBackgroundResource(a.e.live_gift_item_script_lock_level);
            c0242a.bbq.setVisibility(0);
            c0242a.bbw.setText(a.h.ala_gift_privilege_throne);
        } else if (gVar.Ee()) {
            c0242a.bbp.setVisibility(0);
            String Ev3 = gVar.Ev();
            if (TextUtils.isEmpty(Ev3)) {
                c0242a.bbv.setText(a.h.ala_gift_draw_txt);
            } else {
                c0242a.bbv.setText(Ev3);
            }
            c0242a.bbv.setBackgroundResource(a.e.live_gift_panel_item_script_graffiti);
        } else if (gVar.Ef()) {
            c0242a.bbp.setVisibility(0);
            String Ev4 = gVar.Ev();
            if (TextUtils.isEmpty(Ev4)) {
                c0242a.bbv.setText(a.h.ala_gift_combo_txt);
            } else {
                c0242a.bbv.setText(Ev4);
            }
            c0242a.bbv.setBackgroundResource(a.e.live_gift_panel_item_script_graffiti);
        } else if (gVar.Es()) {
            String Ev5 = gVar.Ev();
            if (TextUtils.isEmpty(Ev5)) {
                c0242a.bbv.setText(a.h.ala_gift_broadcast_txt);
            } else {
                c0242a.bbv.setText(Ev5);
            }
            c0242a.bbv.setBackgroundResource(a.e.live_gift_panel_item_script_broadcast);
        } else if (!TextUtils.isEmpty(gVar.Ev())) {
            String Ev6 = gVar.Ev();
            c0242a.bbp.setVisibility(0);
            c0242a.bbv.setText(Ev6);
            if ("活动".equals(Ev6)) {
                c0242a.bbv.setBackgroundResource(a.e.live_gift_panel_item_script_activity);
            } else if ("折扣".equals(Ev6)) {
                c0242a.bbv.setBackgroundResource(a.e.live_gift_panel_item_script_discount);
            } else if (Ev6 != null && Ev6.length() == 1) {
                c0242a.bbv.setBackgroundResource(a.e.live_gift_panel_item_script_new);
            } else {
                c0242a.bbv.setBackgroundResource(a.e.live_gift_panel_item_script_new_wide);
            }
        } else {
            c0242a.bbp.setVisibility(8);
        }
    }

    /* renamed from: com.baidu.live.yuyingift.container.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0242a {
        public ImageView bZV;
        public LottieAnimationView bZW;
        public FrameLayout bZX;
        public ImageView bZY;
        public TextView bZZ;
        public FrameLayout bbB;
        public TextView bbC;
        public AnimatorSet bbD;
        public TbImageView bbo;
        public RelativeLayout bbp;
        public LinearLayout bbq;
        public TextView bbs;
        public TextView bbu;
        public TextView bbv;
        public TextView bbw;
        public View bbz;

        public void recycle() {
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

    private static String aP(long j) {
        if (bbh == null) {
            bbh = new SimpleDateFormat("MM.dd");
        }
        return bbh.format(Long.valueOf(1000 * j));
    }
}

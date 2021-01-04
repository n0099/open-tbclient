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
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private static SimpleDateFormat bbo;
    private int bZd;
    private int bbp;
    private int bbq;
    private int bbr;
    private int bbs;
    private boolean bbt;
    private TbPageContext mContext;
    private int mType;
    private int bbl = -1;
    private int mSelectedPosition = -1;
    private boolean bbn = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.yuyingift.container.a.1
        private void a(g gVar, C0244a c0244a) {
            com.baidu.live.gift.c hA;
            if (gVar.GK() && gVar.aXO == 0 && !com.baidu.live.yuyingift.b.b.aaZ().gV(gVar.Gx()) && (hA = com.baidu.live.yuyingift.b.b.aaZ().hA(gVar.Gx())) != null) {
                am.Ih().a(hA.aXb, true);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view.getTag(a.f.TAG_GIFT_ITEM) instanceof g) && (view.getTag(a.f.TAG_GIFT_VIEW_HOLDER) instanceof C0244a)) {
                C0244a c0244a = (C0244a) view.getTag(a.f.TAG_GIFT_VIEW_HOLDER);
                g gVar = (g) view.getTag(a.f.TAG_GIFT_ITEM);
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(a.this.mContext.getPageActivity(), a.this.mContext.getString(a.h.sdk_neterror));
                } else {
                    a(gVar, c0244a);
                }
            }
        }
    };
    private List<g> bbm = Collections.synchronizedList(new ArrayList());

    public a(TbPageContext tbPageContext, int i) {
        this.mContext = tbPageContext;
        this.mType = i;
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
        this.bbs = (int) (this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds8) * dimensionPixelOffset);
        this.bZd = (int) (dimensionPixelOffset * this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds4));
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

    public void a(AbsListView absListView, String str, String str2, int i) {
        int count;
        int firstVisiblePosition;
        View childAt;
        com.baidu.live.gift.c hA;
        if (!TextUtils.isEmpty(str) && (count = getCount()) != 0) {
            int i2 = 0;
            while (true) {
                if (i2 >= count) {
                    i2 = -1;
                    break;
                }
                g item = getItem(i2);
                if (item == null || TextUtils.isEmpty(item.Gx()) || (hA = com.baidu.live.yuyingift.b.b.aaZ().hA(item.Gx())) == null || TextUtils.isEmpty(hA.getDynamicGiftId()) || !hA.getDynamicGiftId().equals(str) || !TextUtils.equals(aj.hh(item.Gx()), str2)) {
                    i2++;
                } else {
                    item.aXO = i;
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
        C0244a c0244a;
        g.b bVar;
        String formatGiftNumForTDouDisPlay;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.g.yuyin_ala_gift_list_item, viewGroup, false);
            view.setBackgroundResource(a.e.sdk_transparent_bg);
            C0244a c0244a2 = new C0244a();
            c0244a2.bbv = (TbImageView) view.findViewById(a.f.gift_thumbnail);
            c0244a2.bbv.setDefaultBgResource(a.e.icon_live_gift_default);
            c0244a2.bbv.setDefaultErrorResource(a.e.icon_live_gift_default);
            c0244a2.bbv.setAutoChangeStyle(false);
            c0244a2.bbz = (TextView) view.findViewById(a.f.gift_name);
            c0244a2.bbB = (TextView) view.findViewById(a.f.gift_price);
            c0244a2.bbw = (RelativeLayout) view.findViewById(a.f.llCarom);
            c0244a2.bZg = (LottieAnimationView) view.findViewById(a.f.yuyin_ala_gift_lottie_downloading);
            c0244a2.bZf = (ImageView) view.findViewById(a.f.yuyin_gift_downloading_progress);
            c0244a2.bbC = (TextView) view.findViewById(a.f.gift_carom_txt);
            c0244a2.bbG = view.findViewById(a.f.selected_bg);
            c0244a2.bbD = (TextView) view.findViewById(a.f.tv_privilege);
            c0244a2.bbx = (LinearLayout) view.findViewById(a.f.ll_privilege);
            c0244a2.bZh = (FrameLayout) view.findViewById(a.f.layout_pkg_count);
            c0244a2.bZi = (ImageView) view.findViewById(a.f.iv_pkg_count);
            c0244a2.bZj = (TextView) view.findViewById(a.f.tv_pkg_count);
            c0244a2.bbI = (FrameLayout) view.findViewById(a.f.layout_script);
            c0244a2.bbJ = (TextView) view.findViewById(a.f.tv_script);
            c0244a2.bZg.loop(true);
            c0244a2.bZg.setAnimation("yuyin_live_gift_panel_downloading.json");
            view.setTag(c0244a2);
            if (this.bbp <= 0 || this.bbq <= 0) {
                c0244a = c0244a2;
            } else {
                view.getLayoutParams().height = this.bbp;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c0244a2.bbv.getLayoutParams();
                layoutParams.width = this.bbq;
                layoutParams.height = this.bbq;
                layoutParams.topMargin = this.bbr;
                ((RelativeLayout.LayoutParams) c0244a2.bbz.getLayoutParams()).topMargin = this.bbs;
                ((RelativeLayout.LayoutParams) c0244a2.bbB.getLayoutParams()).topMargin = this.bZd;
                c0244a = c0244a2;
            }
        } else {
            c0244a = (C0244a) view.getTag();
        }
        c0244a.IC();
        if (i == this.mSelectedPosition) {
            c0244a.IB();
        }
        g item = getItem(i);
        if (this.mType != 1) {
            bVar = null;
        } else {
            bVar = item.aXF;
        }
        if (item != null) {
            if (item.isRed()) {
                c0244a.bbv.setImageResource(a.e.live_gift_red_enter);
                c0244a.bZf.setVisibility(8);
                c0244a.bZg.setVisibility(8);
                c0244a.bZg.cancelAnimation();
                c0244a.bbz.setText(this.mContext.getPageActivity().getString(a.h.sdk_red_pkt_send));
                c0244a.bbB.setText("");
            } else {
                c0244a.bbv.startLoad(item.getThumbnail_url(), 10, false);
                c0244a.bbz.setText(item.Gy());
                if (this.mType == 0) {
                    double d = JavaTypesHelper.toDouble(String.valueOf(item.getPrice()), 0.0d);
                    if (d >= 100.0d && ((this.bbn || com.baidu.live.af.a.SE().bwi.aOu) && !item.GJ())) {
                        formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
                    } else {
                        formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(item.getPrice()));
                    }
                    c0244a.bbB.setText(formatGiftNumForTDouDisPlay);
                    if (item.GJ()) {
                        c0244a.bbB.setText(this.mContext.getPageActivity().getString(a.h.ala_gift_price_flower_label, new Object[]{formatGiftNumForTDouDisPlay}));
                    } else {
                        c0244a.bbB.setText(this.mContext.getPageActivity().getString(a.h.ala_gift_price_tdou_label, new Object[]{formatGiftNumForTDouDisPlay}));
                    }
                } else if (this.mType == 1) {
                    if (bVar != null && bVar.aXV > 0) {
                        c0244a.bbB.setText(aM(bVar.aXV) + " 失效");
                    } else {
                        c0244a.bbB.setText("");
                    }
                }
                c0244a.bbw.setClickable(false);
                c0244a.bbw.setVisibility(8);
                c0244a.bbC.setBackgroundColor(0);
                c0244a.bbx.setVisibility(8);
                c0244a.bbv.setAlpha(1.0f);
                c0244a.bbB.setAlpha(1.0f);
                c0244a.bbz.setAlpha(1.0f);
                c0244a.bZh.setVisibility(8);
                c0244a.bZg.setVisibility(8);
                c0244a.bZf.setVisibility(8);
                if (this.mType == 0) {
                    if (item.GW()) {
                        c0244a.bbv.setAlpha(0.5f);
                        c0244a.bbB.setAlpha(0.5f);
                        c0244a.bbz.setAlpha(0.5f);
                        c0244a.bbw.setVisibility(8);
                        c0244a.bbx.setVisibility(0);
                        if (!TextUtils.isEmpty(item.GX())) {
                            c0244a.bbD.setText(item.GX());
                        } else {
                            c0244a.bbD.setText("");
                        }
                        String GX = item.GX();
                        if (item.GM()) {
                            if (item.GO()) {
                                c0244a.bbx.setBackgroundResource(a.e.live_gift_item_script_lock_activity);
                            } else if (item.GP()) {
                                c0244a.bbx.setBackgroundResource(a.e.live_gift_item_script_lock_power);
                            } else {
                                c0244a.bbx.setBackgroundResource(a.e.live_gift_item_script_lock_level);
                            }
                        } else if (GX.equals("活动")) {
                            c0244a.bbx.setBackgroundResource(a.e.live_gift_item_script_lock_activity);
                        } else {
                            c0244a.bbx.setBackgroundResource(a.e.live_gift_item_script_lock_level);
                        }
                    } else if (item.GK()) {
                        c0244a.bbw.setVisibility(0);
                        if (!com.baidu.live.yuyingift.b.b.aaZ().gV(item.Gx())) {
                            c0244a.bbC.setText(" ");
                            c0244a.bbw.setClickable(true);
                            c0244a.bZf.setTag(a.f.TAG_GIFT_ITEM, item);
                            c0244a.bZf.setTag(a.f.TAG_GIFT_VIEW_HOLDER, c0244a);
                            c0244a.bZf.setOnClickListener(this.mOnClickListener);
                            if (item.aXO < 100) {
                                c0244a.bbv.setAlpha(0.5f);
                                c0244a.bbB.setAlpha(0.5f);
                                c0244a.bbz.setAlpha(0.5f);
                                c0244a.bbw.setVisibility(4);
                                if (item.aXO == 0) {
                                    c0244a.bZf.setVisibility(0);
                                    c0244a.bZg.setVisibility(8);
                                    c0244a.bZg.cancelAnimation();
                                } else {
                                    c0244a.bZg.setVisibility(0);
                                    c0244a.bZg.playAnimation();
                                }
                            } else if (com.baidu.live.yuyingift.b.b.aaZ().hA(item.Gx()) != null) {
                                c0244a.bZg.setVisibility(8);
                                c0244a.bZg.cancelAnimation();
                                c0244a.bbw.setVisibility(0);
                            } else {
                                a(c0244a, item);
                            }
                        } else {
                            a(c0244a, item);
                        }
                    } else {
                        a(c0244a, item);
                    }
                } else if (this.mType == 1 && bVar != null) {
                    if (bVar.aXU > 999) {
                        c0244a.bZi.setImageResource(a.e.live_icon_gift_panel_package_count_large);
                        c0244a.bZj.setText("999+");
                    } else {
                        c0244a.bZi.setImageResource(a.e.live_icon_gift_panel_package_count_small);
                        c0244a.bZj.setText(String.valueOf(bVar.aXU));
                    }
                    c0244a.bZh.setVisibility(0);
                }
            }
        }
        return view;
    }

    private void a(C0244a c0244a, g gVar) {
        c0244a.bZf.setVisibility(8);
        c0244a.bZg.setVisibility(8);
        c0244a.bZg.cancelAnimation();
        if (gVar.GM()) {
            c0244a.bbw.setVisibility(0);
            String GX = gVar.GX();
            c0244a.bbC.setText(GX);
            if (gVar.GO()) {
                if (TextUtils.isEmpty(GX)) {
                    c0244a.bbC.setText(a.h.ala_gift_type_activity);
                }
                c0244a.bbC.setBackgroundResource(a.e.live_gift_panel_item_script_activity);
            } else if (gVar.GN()) {
                if (TextUtils.isEmpty(GX)) {
                    c0244a.bbC.setText(a.h.ala_gift_type_discount);
                }
                c0244a.bbC.setBackgroundResource(a.e.live_gift_panel_item_script_discount);
            } else if (gVar.GP()) {
                if (TextUtils.isEmpty(GX)) {
                    c0244a.bbC.setText(a.h.ala_gift_type_privilege);
                }
                c0244a.bbC.setBackgroundResource(a.e.live_gift_panel_item_script_power);
            } else if (gVar.GR()) {
                if (TextUtils.isEmpty(GX)) {
                    c0244a.bbC.setText(a.h.ala_gift_broadcast_txt);
                }
                c0244a.bbC.setBackgroundResource(a.e.live_gift_panel_item_script_broadcast);
            } else if (gVar.GQ()) {
                if (TextUtils.isEmpty(GX)) {
                    c0244a.bbC.setText(a.h.ala_gift_draw_txt);
                }
                c0244a.bbC.setBackgroundResource(a.e.live_gift_panel_item_script_graffiti);
            } else if (gVar.GT()) {
                if (TextUtils.isEmpty(GX)) {
                    GX = this.mContext.getPageActivity().getString(a.h.ala_gift_type_new);
                    c0244a.bbC.setText(a.h.ala_gift_type_new);
                }
                if (GX != null && GX.length() == 1) {
                    c0244a.bbC.setBackgroundResource(a.e.live_gift_panel_item_script_new);
                } else {
                    c0244a.bbC.setBackgroundResource(a.e.live_gift_panel_item_script_new_wide);
                }
            } else {
                c0244a.bbw.setVisibility(8);
            }
        } else if (gVar.Ha()) {
            c0244a.bbw.setVisibility(0);
            String GX2 = gVar.GX();
            if (TextUtils.isEmpty(GX2)) {
                c0244a.bbC.setText(a.h.ala_gift_privilege_level);
            } else {
                c0244a.bbC.setText(GX2);
            }
            c0244a.bbC.setBackgroundResource(a.e.live_gift_panel_item_script_level);
        } else if (gVar.GY() && !this.bbt) {
            c0244a.bbv.setAlpha(0.5f);
            c0244a.bbB.setAlpha(0.5f);
            c0244a.bbz.setAlpha(0.5f);
            c0244a.bbw.setVisibility(8);
            c0244a.bbx.setBackgroundResource(a.e.live_gift_item_script_lock_level);
            c0244a.bbx.setVisibility(0);
            c0244a.bbD.setText(a.h.ala_gift_privilege_throne);
        } else if (gVar.GG()) {
            c0244a.bbw.setVisibility(0);
            String GX3 = gVar.GX();
            if (TextUtils.isEmpty(GX3)) {
                c0244a.bbC.setText(a.h.ala_gift_draw_txt);
            } else {
                c0244a.bbC.setText(GX3);
            }
            c0244a.bbC.setBackgroundResource(a.e.live_gift_panel_item_script_graffiti);
        } else if (gVar.GH()) {
            c0244a.bbw.setVisibility(0);
            String GX4 = gVar.GX();
            if (TextUtils.isEmpty(GX4)) {
                c0244a.bbC.setText(a.h.ala_gift_combo_txt);
            } else {
                c0244a.bbC.setText(GX4);
            }
            c0244a.bbC.setBackgroundResource(a.e.live_gift_panel_item_script_graffiti);
        } else if (gVar.GU()) {
            String GX5 = gVar.GX();
            if (TextUtils.isEmpty(GX5)) {
                c0244a.bbC.setText(a.h.ala_gift_broadcast_txt);
            } else {
                c0244a.bbC.setText(GX5);
            }
            c0244a.bbC.setBackgroundResource(a.e.live_gift_panel_item_script_broadcast);
        } else if (!TextUtils.isEmpty(gVar.GX())) {
            String GX6 = gVar.GX();
            c0244a.bbw.setVisibility(0);
            c0244a.bbC.setText(GX6);
            if ("活动".equals(GX6)) {
                c0244a.bbC.setBackgroundResource(a.e.live_gift_panel_item_script_activity);
            } else if ("折扣".equals(GX6)) {
                c0244a.bbC.setBackgroundResource(a.e.live_gift_panel_item_script_discount);
            } else if (GX6 != null && GX6.length() == 1) {
                c0244a.bbC.setBackgroundResource(a.e.live_gift_panel_item_script_new);
            } else {
                c0244a.bbC.setBackgroundResource(a.e.live_gift_panel_item_script_new_wide);
            }
        } else {
            c0244a.bbw.setVisibility(8);
        }
    }

    /* renamed from: com.baidu.live.yuyingift.container.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0244a {
        public ImageView bZf;
        public LottieAnimationView bZg;
        public FrameLayout bZh;
        public ImageView bZi;
        public TextView bZj;
        public TextView bbB;
        public TextView bbC;
        public TextView bbD;
        public View bbG;
        public FrameLayout bbI;
        public TextView bbJ;
        public AnimatorSet bbK;
        public TbImageView bbv;
        public RelativeLayout bbw;
        public LinearLayout bbx;
        public TextView bbz;

        public void recycle() {
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
            bbo = new SimpleDateFormat("MM.dd");
        }
        return bbo.format(Long.valueOf(1000 * j));
    }
}

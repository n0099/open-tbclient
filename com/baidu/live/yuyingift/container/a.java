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
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.gift.ai;
import com.baidu.live.gift.al;
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
    private static SimpleDateFormat aWK;
    private int aWL;
    private int aWM;
    private int aWN;
    private int aWO;
    private boolean aWP;
    private int bKo;
    private TbPageContext mContext;
    private int mType;
    private int aWH = -1;
    private int mSelectedPosition = -1;
    private boolean aWJ = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.yuyingift.container.a.1
        private void a(g gVar, C0225a c0225a) {
            if (gVar.FD() && !com.baidu.live.yuyingift.b.b.Vf().gQ(gVar.Fs())) {
                com.baidu.live.gift.c hq = com.baidu.live.yuyingift.b.b.Vf().hq(gVar.Fs());
                BdLog.e("dynamicgift是否在动效礼物列表中：" + hq);
                if (hq != null) {
                    al.GW().a(hq.aSL, true);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view.getTag(a.g.TAG_GIFT_ITEM) instanceof g) && (view.getTag(a.g.TAG_GIFT_VIEW_HOLDER) instanceof C0225a)) {
                C0225a c0225a = (C0225a) view.getTag(a.g.TAG_GIFT_VIEW_HOLDER);
                g gVar = (g) view.getTag(a.g.TAG_GIFT_ITEM);
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(a.this.mContext.getPageActivity(), a.this.mContext.getString(a.i.sdk_neterror));
                } else {
                    a(gVar, c0225a);
                }
            }
        }
    };
    private List<g> aWI = Collections.synchronizedList(new ArrayList());

    public a(TbPageContext tbPageContext, int i) {
        this.mContext = tbPageContext;
        this.mType = i;
    }

    public void setGiftItems(List<g> list) {
        if (this.aWI == null) {
            this.aWI = Collections.synchronizedList(new ArrayList());
        } else {
            this.aWI.clear();
        }
        if (list != null) {
            this.aWI.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void A(String str, int i) {
        if (this.aWI != null) {
            for (g gVar : this.aWI) {
                if (gVar.aTp != null && gVar.Fs().equals(str)) {
                    gVar.aTp.aTC = i;
                }
            }
            notifyDataSetChanged();
        }
    }

    public void ec(int i) {
        this.aWH = i;
    }

    public void ed(int i) {
        this.mSelectedPosition = i;
    }

    public int getSelectedPosition() {
        return this.mSelectedPosition;
    }

    public void bu(boolean z) {
        this.aWJ = z;
    }

    public void ee(int i) {
        this.aWL = i;
        float dimensionPixelOffset = (i * 1.0f) / this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds192);
        this.aWM = (int) (this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds100) * dimensionPixelOffset);
        this.aWN = (int) (this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds12) * dimensionPixelOffset);
        this.aWO = (int) (this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds8) * dimensionPixelOffset);
        this.bKo = (int) (dimensionPixelOffset * this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds4));
    }

    public void bd(boolean z) {
        this.aWP = z;
    }

    public void a(AbsListView absListView, boolean z) {
        int firstVisiblePosition;
        View childAt;
        this.aWP = z;
        int count = getCount();
        if (count != 0) {
            for (int i = 0; i < count; i++) {
                if (getItem(i).FR() && i >= (firstVisiblePosition = absListView.getFirstVisiblePosition()) && i <= absListView.getLastVisiblePosition() && (childAt = absListView.getChildAt(i - firstVisiblePosition)) != null) {
                    getView(i, childAt, absListView);
                }
            }
        }
    }

    public void a(AbsListView absListView, String str, String str2) {
        int count;
        int firstVisiblePosition;
        View childAt;
        com.baidu.live.gift.c hq;
        if (!TextUtils.isEmpty(str) && (count = getCount()) != 0) {
            int i = 0;
            while (true) {
                if (i >= count) {
                    i = -1;
                    break;
                }
                g item = getItem(i);
                if (item != null && !TextUtils.isEmpty(item.Fs()) && (hq = com.baidu.live.yuyingift.b.b.Vf().hq(item.Fs())) != null && !TextUtils.isEmpty(hq.getDynamicGiftId()) && hq.getDynamicGiftId().equals(str) && TextUtils.equals(ai.hb(item.Fs()), str2)) {
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
        if (this.aWI == null) {
            return 0;
        }
        return this.aWI.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ef */
    public g getItem(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.aWI.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0225a c0225a;
        g.b bVar;
        String formatGiftNumForTDouDisPlay;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.ala_gift_list_item, viewGroup, false);
            view.setBackgroundResource(a.f.sdk_transparent_bg);
            C0225a c0225a2 = new C0225a();
            c0225a2.aWR = (TbImageView) view.findViewById(a.g.gift_thumbnail);
            c0225a2.aWR.setDefaultBgResource(a.f.icon_live_gift_default);
            c0225a2.aWR.setDefaultErrorResource(a.f.icon_live_gift_default);
            c0225a2.aWR.setAutoChangeStyle(false);
            c0225a2.aWV = (TextView) view.findViewById(a.g.gift_name);
            c0225a2.aWX = (TextView) view.findViewById(a.g.gift_price);
            c0225a2.aWS = (RelativeLayout) view.findViewById(a.g.llCarom);
            c0225a2.aWY = (TextView) view.findViewById(a.g.gift_carom_txt);
            c0225a2.aXa = view.findViewById(a.g.in_progress);
            c0225a2.aXb = (LottieAnimationView) view.findViewById(a.g.lottie_downloading);
            c0225a2.aXb.loop(true);
            c0225a2.aXb.setAnimation("yuyin_live_gift_panel_downloading.json");
            c0225a2.aXc = view.findViewById(a.g.selected_bg);
            c0225a2.aWZ = (TextView) view.findViewById(a.g.tv_privilege);
            c0225a2.aWT = (LinearLayout) view.findViewById(a.g.ll_privilege);
            c0225a2.aXd = (FrameLayout) view.findViewById(a.g.layout_pkg_count);
            c0225a2.aXe = (ImageView) view.findViewById(a.g.iv_pkg_count);
            c0225a2.aXf = (TextView) view.findViewById(a.g.tv_pkg_count);
            c0225a2.aXg = (FrameLayout) view.findViewById(a.g.layout_script);
            c0225a2.aXh = (TextView) view.findViewById(a.g.tv_script);
            view.setTag(c0225a2);
            if (this.aWL <= 0 || this.aWM <= 0) {
                c0225a = c0225a2;
            } else {
                view.getLayoutParams().height = this.aWL;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c0225a2.aWR.getLayoutParams();
                layoutParams.width = this.aWM;
                layoutParams.height = this.aWM;
                layoutParams.topMargin = this.aWN;
                ((RelativeLayout.LayoutParams) c0225a2.aWV.getLayoutParams()).topMargin = this.aWO;
                ((RelativeLayout.LayoutParams) c0225a2.aWX.getLayoutParams()).topMargin = this.bKo;
                c0225a = c0225a2;
            }
        } else {
            c0225a = (C0225a) view.getTag();
        }
        c0225a.Hs();
        if (i == this.mSelectedPosition) {
            c0225a.Hr();
        }
        g item = getItem(i);
        if (this.mType != 1) {
            bVar = null;
        } else {
            bVar = item.aTp;
        }
        if (item != null) {
            if (item.isRed()) {
                c0225a.aWR.setImageResource(a.f.live_gift_red_enter);
                c0225a.aWV.setText(this.mContext.getPageActivity().getString(a.i.sdk_red_pkt_send));
                c0225a.aWX.setText("");
            } else {
                c0225a.aWR.startLoad(item.getThumbnail_url(), 10, false);
                c0225a.aWV.setText(item.Ft());
                if (this.mType == 0) {
                    double d = JavaTypesHelper.toDouble(String.valueOf(item.getPrice()), 0.0d);
                    if (d >= 100.0d && ((this.aWJ || com.baidu.live.z.a.Pq().bmJ.aLG) && !item.FC())) {
                        formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
                    } else {
                        formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(item.getPrice()));
                    }
                    c0225a.aWX.setText(formatGiftNumForTDouDisPlay);
                    if (item.FC()) {
                        c0225a.aWX.setText(this.mContext.getPageActivity().getString(a.i.ala_gift_price_flower_label, new Object[]{formatGiftNumForTDouDisPlay}));
                    } else {
                        c0225a.aWX.setText(this.mContext.getPageActivity().getString(a.i.ala_gift_price_tdou_label, new Object[]{formatGiftNumForTDouDisPlay}));
                    }
                } else if (this.mType == 1) {
                    if (bVar != null) {
                        c0225a.aWX.setText(ad(bVar.aTD) + " 失效");
                    } else {
                        c0225a.aWX.setText("");
                    }
                }
                c0225a.aWS.setClickable(false);
                c0225a.aWS.setVisibility(8);
                c0225a.aWY.setBackgroundColor(0);
                c0225a.aWT.setVisibility(8);
                c0225a.aWR.setAlpha(1.0f);
                c0225a.aWX.setAlpha(1.0f);
                c0225a.aWV.setAlpha(1.0f);
                c0225a.aXd.setVisibility(8);
                c0225a.aXa.setVisibility(4);
                c0225a.aXb.cancelAnimation();
                if (this.mType == 0) {
                    if (item.FP()) {
                        c0225a.aWR.setAlpha(0.5f);
                        c0225a.aWX.setAlpha(0.5f);
                        c0225a.aWV.setAlpha(0.5f);
                        c0225a.aWS.setVisibility(8);
                        c0225a.aWT.setVisibility(0);
                        if (!TextUtils.isEmpty(item.FQ())) {
                            c0225a.aWZ.setText(item.FQ());
                        } else {
                            c0225a.aWZ.setText("");
                        }
                        String FQ = item.FQ();
                        if (item.FF()) {
                            if (item.FH()) {
                                c0225a.aWT.setBackgroundResource(a.f.live_gift_item_script_lock_activity);
                            } else if (item.FI()) {
                                c0225a.aWT.setBackgroundResource(a.f.live_gift_item_script_lock_power);
                            } else {
                                c0225a.aWT.setBackgroundResource(a.f.live_gift_item_script_lock_level);
                            }
                        } else if (FQ.equals("活动")) {
                            c0225a.aWT.setBackgroundResource(a.f.live_gift_item_script_lock_activity);
                        } else {
                            c0225a.aWT.setBackgroundResource(a.f.live_gift_item_script_lock_level);
                        }
                    } else if (item.FD()) {
                        c0225a.aWS.setVisibility(0);
                        if (!com.baidu.live.yuyingift.b.b.Vf().gQ(item.Fs())) {
                            c0225a.aWY.setText(" ");
                            c0225a.aWY.setBackgroundResource(a.f.live_gift_panel_item_script_download);
                            c0225a.aWS.setTag(a.g.TAG_GIFT_ITEM, item);
                            c0225a.aWS.setTag(a.g.TAG_GIFT_VIEW_HOLDER, c0225a);
                            c0225a.aWS.setClickable(true);
                            c0225a.aWS.setOnClickListener(this.mOnClickListener);
                            if (al.GW().ar(item.Fs(), ai.hb(item.Fs()))) {
                                c0225a.aWR.setAlpha(0.5f);
                                c0225a.aWX.setAlpha(0.5f);
                                c0225a.aWV.setAlpha(0.5f);
                                c0225a.aXa.setVisibility(0);
                                c0225a.aXb.playAnimation();
                                c0225a.aWS.setVisibility(4);
                            } else if (com.baidu.live.yuyingift.b.b.Vf().hq(item.Fs()) != null) {
                                c0225a.aXa.setVisibility(4);
                                c0225a.aXb.cancelAnimation();
                                c0225a.aWS.setVisibility(0);
                            } else {
                                a(c0225a, item);
                            }
                        } else {
                            a(c0225a, item);
                        }
                    } else {
                        a(c0225a, item);
                    }
                } else if (this.mType == 1 && bVar != null) {
                    if (bVar.aTC > 999) {
                        c0225a.aXe.setImageResource(a.f.live_icon_gift_panel_package_count_large);
                        c0225a.aXf.setText("999+");
                    } else {
                        c0225a.aXe.setImageResource(a.f.live_icon_gift_panel_package_count_small);
                        c0225a.aXf.setText(String.valueOf(bVar.aTC));
                    }
                    c0225a.aXd.setVisibility(0);
                }
            }
        }
        return view;
    }

    private void a(C0225a c0225a, g gVar) {
        c0225a.aXa.setVisibility(4);
        c0225a.aXb.cancelAnimation();
        if (gVar.FF()) {
            c0225a.aWS.setVisibility(0);
            String FQ = gVar.FQ();
            c0225a.aWY.setText(FQ);
            if (gVar.FH()) {
                if (TextUtils.isEmpty(FQ)) {
                    c0225a.aWY.setText(a.i.ala_gift_type_activity);
                }
                c0225a.aWY.setBackgroundResource(a.f.live_gift_panel_item_script_activity);
            } else if (gVar.FG()) {
                if (TextUtils.isEmpty(FQ)) {
                    c0225a.aWY.setText(a.i.ala_gift_type_discount);
                }
                c0225a.aWY.setBackgroundResource(a.f.live_gift_panel_item_script_discount);
            } else if (gVar.FI()) {
                if (TextUtils.isEmpty(FQ)) {
                    c0225a.aWY.setText(a.i.ala_gift_type_privilege);
                }
                c0225a.aWY.setBackgroundResource(a.f.live_gift_panel_item_script_power);
            } else if (gVar.FK()) {
                if (TextUtils.isEmpty(FQ)) {
                    c0225a.aWY.setText(a.i.ala_gift_broadcast_txt);
                }
                c0225a.aWY.setBackgroundResource(a.f.live_gift_panel_item_script_broadcast);
            } else if (gVar.FJ()) {
                if (TextUtils.isEmpty(FQ)) {
                    c0225a.aWY.setText(a.i.ala_gift_draw_txt);
                }
                c0225a.aWY.setBackgroundResource(a.f.live_gift_panel_item_script_graffiti);
            } else if (gVar.FM()) {
                if (TextUtils.isEmpty(FQ)) {
                    FQ = this.mContext.getPageActivity().getString(a.i.ala_gift_type_new);
                    c0225a.aWY.setText(a.i.ala_gift_type_new);
                }
                if (FQ != null && FQ.length() == 1) {
                    c0225a.aWY.setBackgroundResource(a.f.live_gift_panel_item_script_new);
                } else {
                    c0225a.aWY.setBackgroundResource(a.f.live_gift_panel_item_script_new_wide);
                }
            } else {
                c0225a.aWS.setVisibility(8);
            }
        } else if (gVar.FS()) {
            c0225a.aWS.setVisibility(0);
            String FQ2 = gVar.FQ();
            if (TextUtils.isEmpty(FQ2)) {
                c0225a.aWY.setText(a.i.ala_gift_privilege_level);
            } else {
                c0225a.aWY.setText(FQ2);
            }
            c0225a.aWY.setBackgroundResource(a.f.live_gift_panel_item_script_level);
        } else if (gVar.FR() && !this.aWP) {
            c0225a.aWR.setAlpha(0.5f);
            c0225a.aWX.setAlpha(0.5f);
            c0225a.aWV.setAlpha(0.5f);
            c0225a.aWS.setVisibility(8);
            c0225a.aWT.setBackgroundResource(a.f.live_gift_item_script_lock_level);
            c0225a.aWT.setVisibility(0);
            c0225a.aWZ.setText(a.i.ala_gift_privilege_throne);
        } else if (gVar.Fz()) {
            c0225a.aWS.setVisibility(0);
            String FQ3 = gVar.FQ();
            if (TextUtils.isEmpty(FQ3)) {
                c0225a.aWY.setText(a.i.ala_gift_draw_txt);
            } else {
                c0225a.aWY.setText(FQ3);
            }
            c0225a.aWY.setBackgroundResource(a.f.live_gift_panel_item_script_graffiti);
        } else if (gVar.FA()) {
            c0225a.aWS.setVisibility(0);
            String FQ4 = gVar.FQ();
            if (TextUtils.isEmpty(FQ4)) {
                c0225a.aWY.setText(a.i.ala_gift_combo_txt);
            } else {
                c0225a.aWY.setText(FQ4);
            }
            c0225a.aWY.setBackgroundResource(a.f.live_gift_panel_item_script_graffiti);
        } else if (gVar.FN()) {
            String FQ5 = gVar.FQ();
            if (TextUtils.isEmpty(FQ5)) {
                c0225a.aWY.setText(a.i.ala_gift_broadcast_txt);
            } else {
                c0225a.aWY.setText(FQ5);
            }
            c0225a.aWY.setBackgroundResource(a.f.live_gift_panel_item_script_broadcast);
        } else if (!TextUtils.isEmpty(gVar.FQ())) {
            String FQ6 = gVar.FQ();
            c0225a.aWS.setVisibility(0);
            c0225a.aWY.setText(FQ6);
            if ("活动".equals(FQ6)) {
                c0225a.aWY.setBackgroundResource(a.f.live_gift_panel_item_script_activity);
            } else if ("折扣".equals(FQ6)) {
                c0225a.aWY.setBackgroundResource(a.f.live_gift_panel_item_script_discount);
            } else if (FQ6 != null && FQ6.length() == 1) {
                c0225a.aWY.setBackgroundResource(a.f.live_gift_panel_item_script_new);
            } else {
                c0225a.aWY.setBackgroundResource(a.f.live_gift_panel_item_script_new_wide);
            }
        } else {
            c0225a.aWS.setVisibility(8);
        }
    }

    /* renamed from: com.baidu.live.yuyingift.container.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0225a {
        public TbImageView aWR;
        public RelativeLayout aWS;
        public LinearLayout aWT;
        public TextView aWV;
        public TextView aWX;
        public TextView aWY;
        public TextView aWZ;
        public View aXa;
        public LottieAnimationView aXb;
        public View aXc;
        public FrameLayout aXd;
        public ImageView aXe;
        public TextView aXf;
        public FrameLayout aXg;
        public TextView aXh;
        public AnimatorSet aXi;

        public void recycle() {
            if (this.aXb != null) {
                this.aXb.cancelAnimation();
            }
            Ht();
        }

        public void Hr() {
            if (this.aXc != null) {
                this.aXc.setVisibility(0);
            }
            N(this.aWR);
        }

        public void Hs() {
            if (this.aXc != null) {
                this.aXc.setVisibility(8);
            }
            Ht();
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
            this.aXi = new AnimatorSet();
            this.aXi.play(ofFloat).with(ofFloat2);
            this.aXi.start();
        }

        public void Ht() {
            if (this.aXi != null) {
                this.aXi.cancel();
                this.aXi = null;
            }
        }
    }

    private static String ad(long j) {
        if (aWK == null) {
            aWK = new SimpleDateFormat("MM.dd");
        }
        return aWK.format(Long.valueOf(1000 * j));
    }
}

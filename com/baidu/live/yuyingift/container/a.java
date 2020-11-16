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
    private static SimpleDateFormat aWr;
    private int aWs;
    private int aWt;
    private int aWu;
    private int aWv;
    private boolean aWw;
    private int bOk;
    private TbPageContext mContext;
    private int mType;
    private int aWo = -1;
    private int mSelectedPosition = -1;
    private boolean aWq = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.yuyingift.container.a.1
        private void a(g gVar, C0235a c0235a) {
            com.baidu.live.gift.c hr;
            if (gVar.Fv() && gVar.aTe == 0 && !com.baidu.live.yuyingift.b.b.WV().gP(gVar.Fk()) && (hr = com.baidu.live.yuyingift.b.b.WV().hr(gVar.Fk())) != null) {
                ak.GO().a(hr.aSt, true, true);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view.getTag(a.f.TAG_GIFT_ITEM) instanceof g) && (view.getTag(a.f.TAG_GIFT_VIEW_HOLDER) instanceof C0235a)) {
                C0235a c0235a = (C0235a) view.getTag(a.f.TAG_GIFT_VIEW_HOLDER);
                g gVar = (g) view.getTag(a.f.TAG_GIFT_ITEM);
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(a.this.mContext.getPageActivity(), a.this.mContext.getString(a.h.sdk_neterror));
                } else {
                    a(gVar, c0235a);
                }
            }
        }
    };
    private List<g> aWp = Collections.synchronizedList(new ArrayList());

    public a(TbPageContext tbPageContext, int i) {
        this.mContext = tbPageContext;
        this.mType = i;
    }

    public void setGiftItems(List<g> list) {
        if (this.aWp == null) {
            this.aWp = Collections.synchronizedList(new ArrayList());
        } else {
            this.aWp.clear();
        }
        if (list != null) {
            this.aWp.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void A(String str, int i) {
        if (this.aWp != null) {
            for (g gVar : this.aWp) {
                if (gVar.aSX != null && gVar.Fk().equals(str)) {
                    gVar.aSX.aTk = i;
                }
            }
            notifyDataSetChanged();
        }
    }

    public void dY(int i) {
        this.aWo = i;
    }

    public void dZ(int i) {
        this.mSelectedPosition = i;
    }

    public int getSelectedPosition() {
        return this.mSelectedPosition;
    }

    public void bx(boolean z) {
        this.aWq = z;
    }

    public void ea(int i) {
        this.aWs = i;
        float dimensionPixelOffset = (i * 1.0f) / this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds192);
        this.aWt = (int) (this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds100) * dimensionPixelOffset);
        this.aWu = (int) (this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds12) * dimensionPixelOffset);
        this.aWv = (int) (this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds8) * dimensionPixelOffset);
        this.bOk = (int) (dimensionPixelOffset * this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds4));
    }

    public void bg(boolean z) {
        this.aWw = z;
    }

    public void a(AbsListView absListView, boolean z) {
        int firstVisiblePosition;
        View childAt;
        this.aWw = z;
        int count = getCount();
        if (count != 0) {
            for (int i = 0; i < count; i++) {
                if (getItem(i).FJ() && i >= (firstVisiblePosition = absListView.getFirstVisiblePosition()) && i <= absListView.getLastVisiblePosition() && (childAt = absListView.getChildAt(i - firstVisiblePosition)) != null) {
                    getView(i, childAt, absListView);
                }
            }
        }
    }

    public void a(AbsListView absListView, String str, String str2, int i) {
        int count;
        int firstVisiblePosition;
        View childAt;
        com.baidu.live.gift.c hr;
        if (!TextUtils.isEmpty(str) && (count = getCount()) != 0) {
            int i2 = 0;
            while (true) {
                if (i2 >= count) {
                    i2 = -1;
                    break;
                }
                g item = getItem(i2);
                if (item == null || TextUtils.isEmpty(item.Fk()) || (hr = com.baidu.live.yuyingift.b.b.WV().hr(item.Fk())) == null || TextUtils.isEmpty(hr.getDynamicGiftId()) || !hr.getDynamicGiftId().equals(str) || !TextUtils.equals(ah.hb(item.Fk()), str2)) {
                    i2++;
                } else {
                    item.aTe = i;
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
        if (this.aWp == null) {
            return 0;
        }
        return this.aWp.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: eb */
    public g getItem(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.aWp.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0235a c0235a;
        g.b bVar;
        String formatGiftNumForTDouDisPlay;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.g.yuyin_ala_gift_list_item, viewGroup, false);
            view.setBackgroundResource(a.e.sdk_transparent_bg);
            C0235a c0235a2 = new C0235a();
            c0235a2.aWy = (TbImageView) view.findViewById(a.f.gift_thumbnail);
            c0235a2.aWy.setDefaultBgResource(a.e.icon_live_gift_default);
            c0235a2.aWy.setDefaultErrorResource(a.e.icon_live_gift_default);
            c0235a2.aWy.setAutoChangeStyle(false);
            c0235a2.aWC = (TextView) view.findViewById(a.f.gift_name);
            c0235a2.aWE = (TextView) view.findViewById(a.f.gift_price);
            c0235a2.aWz = (RelativeLayout) view.findViewById(a.f.llCarom);
            c0235a2.bOn = (LottieAnimationView) view.findViewById(a.f.yuyin_ala_gift_lottie_downloading);
            c0235a2.bOm = (ImageView) view.findViewById(a.f.yuyin_gift_downloading_progress);
            c0235a2.aWF = (TextView) view.findViewById(a.f.gift_carom_txt);
            c0235a2.aWJ = view.findViewById(a.f.selected_bg);
            c0235a2.aWG = (TextView) view.findViewById(a.f.tv_privilege);
            c0235a2.aWA = (LinearLayout) view.findViewById(a.f.ll_privilege);
            c0235a2.aWK = (FrameLayout) view.findViewById(a.f.layout_pkg_count);
            c0235a2.aWL = (ImageView) view.findViewById(a.f.iv_pkg_count);
            c0235a2.aWM = (TextView) view.findViewById(a.f.tv_pkg_count);
            c0235a2.aWN = (FrameLayout) view.findViewById(a.f.layout_script);
            c0235a2.aWO = (TextView) view.findViewById(a.f.tv_script);
            c0235a2.bOn.loop(true);
            c0235a2.bOn.setAnimation("yuyin_live_gift_panel_downloading.json");
            view.setTag(c0235a2);
            if (this.aWs <= 0 || this.aWt <= 0) {
                c0235a = c0235a2;
            } else {
                view.getLayoutParams().height = this.aWs;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c0235a2.aWy.getLayoutParams();
                layoutParams.width = this.aWt;
                layoutParams.height = this.aWt;
                layoutParams.topMargin = this.aWu;
                ((RelativeLayout.LayoutParams) c0235a2.aWC.getLayoutParams()).topMargin = this.aWv;
                ((RelativeLayout.LayoutParams) c0235a2.aWE.getLayoutParams()).topMargin = this.bOk;
                c0235a = c0235a2;
            }
        } else {
            c0235a = (C0235a) view.getTag();
        }
        c0235a.Hk();
        if (i == this.mSelectedPosition) {
            c0235a.Hj();
        }
        g item = getItem(i);
        if (this.mType != 1) {
            bVar = null;
        } else {
            bVar = item.aSX;
        }
        if (item != null) {
            if (item.isRed()) {
                c0235a.aWy.setImageResource(a.e.live_gift_red_enter);
                c0235a.bOm.setVisibility(8);
                c0235a.bOn.setVisibility(8);
                c0235a.bOn.cancelAnimation();
                c0235a.aWC.setText(this.mContext.getPageActivity().getString(a.h.sdk_red_pkt_send));
                c0235a.aWE.setText("");
            } else {
                c0235a.aWy.startLoad(item.getThumbnail_url(), 10, false);
                c0235a.aWC.setText(item.Fl());
                if (this.mType == 0) {
                    double d = JavaTypesHelper.toDouble(String.valueOf(item.getPrice()), 0.0d);
                    if (d >= 100.0d && ((this.aWq || com.baidu.live.aa.a.Ph().bms.aKV) && !item.Fu())) {
                        formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
                    } else {
                        formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(item.getPrice()));
                    }
                    c0235a.aWE.setText(formatGiftNumForTDouDisPlay);
                    if (item.Fu()) {
                        c0235a.aWE.setText(this.mContext.getPageActivity().getString(a.h.ala_gift_price_flower_label, new Object[]{formatGiftNumForTDouDisPlay}));
                    } else {
                        c0235a.aWE.setText(this.mContext.getPageActivity().getString(a.h.ala_gift_price_tdou_label, new Object[]{formatGiftNumForTDouDisPlay}));
                    }
                } else if (this.mType == 1) {
                    if (bVar != null && bVar.aTl > 0) {
                        c0235a.aWE.setText(ap(bVar.aTl) + " 失效");
                    } else {
                        c0235a.aWE.setText("");
                    }
                }
                c0235a.aWz.setClickable(false);
                c0235a.aWz.setVisibility(8);
                c0235a.aWF.setBackgroundColor(0);
                c0235a.aWA.setVisibility(8);
                c0235a.aWy.setAlpha(1.0f);
                c0235a.aWE.setAlpha(1.0f);
                c0235a.aWC.setAlpha(1.0f);
                c0235a.aWK.setVisibility(8);
                c0235a.bOn.setVisibility(8);
                c0235a.bOm.setVisibility(8);
                if (this.mType == 0) {
                    if (item.FH()) {
                        c0235a.aWy.setAlpha(0.5f);
                        c0235a.aWE.setAlpha(0.5f);
                        c0235a.aWC.setAlpha(0.5f);
                        c0235a.aWz.setVisibility(8);
                        c0235a.aWA.setVisibility(0);
                        if (!TextUtils.isEmpty(item.FI())) {
                            c0235a.aWG.setText(item.FI());
                        } else {
                            c0235a.aWG.setText("");
                        }
                        String FI = item.FI();
                        if (item.Fx()) {
                            if (item.Fz()) {
                                c0235a.aWA.setBackgroundResource(a.e.live_gift_item_script_lock_activity);
                            } else if (item.FA()) {
                                c0235a.aWA.setBackgroundResource(a.e.live_gift_item_script_lock_power);
                            } else {
                                c0235a.aWA.setBackgroundResource(a.e.live_gift_item_script_lock_level);
                            }
                        } else if (FI.equals("活动")) {
                            c0235a.aWA.setBackgroundResource(a.e.live_gift_item_script_lock_activity);
                        } else {
                            c0235a.aWA.setBackgroundResource(a.e.live_gift_item_script_lock_level);
                        }
                    } else if (item.Fv()) {
                        c0235a.aWz.setVisibility(0);
                        if (!com.baidu.live.yuyingift.b.b.WV().gP(item.Fk())) {
                            c0235a.aWF.setText(" ");
                            c0235a.aWz.setClickable(true);
                            c0235a.bOm.setTag(a.f.TAG_GIFT_ITEM, item);
                            c0235a.bOm.setTag(a.f.TAG_GIFT_VIEW_HOLDER, c0235a);
                            c0235a.bOm.setOnClickListener(this.mOnClickListener);
                            if (item.aTe < 100) {
                                c0235a.aWy.setAlpha(0.5f);
                                c0235a.aWE.setAlpha(0.5f);
                                c0235a.aWC.setAlpha(0.5f);
                                c0235a.aWz.setVisibility(4);
                                if (item.aTe == 0) {
                                    c0235a.bOm.setVisibility(0);
                                    c0235a.bOn.setVisibility(8);
                                    c0235a.bOn.cancelAnimation();
                                } else {
                                    c0235a.bOn.setVisibility(0);
                                    c0235a.bOn.playAnimation();
                                }
                            } else if (com.baidu.live.yuyingift.b.b.WV().hr(item.Fk()) != null) {
                                c0235a.bOn.setVisibility(8);
                                c0235a.bOn.cancelAnimation();
                                c0235a.aWz.setVisibility(0);
                            } else {
                                a(c0235a, item);
                            }
                        } else {
                            a(c0235a, item);
                        }
                    } else {
                        a(c0235a, item);
                    }
                } else if (this.mType == 1 && bVar != null) {
                    if (bVar.aTk > 999) {
                        c0235a.aWL.setImageResource(a.e.live_icon_gift_panel_package_count_large);
                        c0235a.aWM.setText("999+");
                    } else {
                        c0235a.aWL.setImageResource(a.e.live_icon_gift_panel_package_count_small);
                        c0235a.aWM.setText(String.valueOf(bVar.aTk));
                    }
                    c0235a.aWK.setVisibility(0);
                }
            }
        }
        return view;
    }

    private void a(C0235a c0235a, g gVar) {
        c0235a.bOm.setVisibility(8);
        c0235a.bOn.setVisibility(8);
        c0235a.bOn.cancelAnimation();
        if (gVar.Fx()) {
            c0235a.aWz.setVisibility(0);
            String FI = gVar.FI();
            c0235a.aWF.setText(FI);
            if (gVar.Fz()) {
                if (TextUtils.isEmpty(FI)) {
                    c0235a.aWF.setText(a.h.ala_gift_type_activity);
                }
                c0235a.aWF.setBackgroundResource(a.e.live_gift_panel_item_script_activity);
            } else if (gVar.Fy()) {
                if (TextUtils.isEmpty(FI)) {
                    c0235a.aWF.setText(a.h.ala_gift_type_discount);
                }
                c0235a.aWF.setBackgroundResource(a.e.live_gift_panel_item_script_discount);
            } else if (gVar.FA()) {
                if (TextUtils.isEmpty(FI)) {
                    c0235a.aWF.setText(a.h.ala_gift_type_privilege);
                }
                c0235a.aWF.setBackgroundResource(a.e.live_gift_panel_item_script_power);
            } else if (gVar.FC()) {
                if (TextUtils.isEmpty(FI)) {
                    c0235a.aWF.setText(a.h.ala_gift_broadcast_txt);
                }
                c0235a.aWF.setBackgroundResource(a.e.live_gift_panel_item_script_broadcast);
            } else if (gVar.FB()) {
                if (TextUtils.isEmpty(FI)) {
                    c0235a.aWF.setText(a.h.ala_gift_draw_txt);
                }
                c0235a.aWF.setBackgroundResource(a.e.live_gift_panel_item_script_graffiti);
            } else if (gVar.FE()) {
                if (TextUtils.isEmpty(FI)) {
                    FI = this.mContext.getPageActivity().getString(a.h.ala_gift_type_new);
                    c0235a.aWF.setText(a.h.ala_gift_type_new);
                }
                if (FI != null && FI.length() == 1) {
                    c0235a.aWF.setBackgroundResource(a.e.live_gift_panel_item_script_new);
                } else {
                    c0235a.aWF.setBackgroundResource(a.e.live_gift_panel_item_script_new_wide);
                }
            } else {
                c0235a.aWz.setVisibility(8);
            }
        } else if (gVar.FK()) {
            c0235a.aWz.setVisibility(0);
            String FI2 = gVar.FI();
            if (TextUtils.isEmpty(FI2)) {
                c0235a.aWF.setText(a.h.ala_gift_privilege_level);
            } else {
                c0235a.aWF.setText(FI2);
            }
            c0235a.aWF.setBackgroundResource(a.e.live_gift_panel_item_script_level);
        } else if (gVar.FJ() && !this.aWw) {
            c0235a.aWy.setAlpha(0.5f);
            c0235a.aWE.setAlpha(0.5f);
            c0235a.aWC.setAlpha(0.5f);
            c0235a.aWz.setVisibility(8);
            c0235a.aWA.setBackgroundResource(a.e.live_gift_item_script_lock_level);
            c0235a.aWA.setVisibility(0);
            c0235a.aWG.setText(a.h.ala_gift_privilege_throne);
        } else if (gVar.Fr()) {
            c0235a.aWz.setVisibility(0);
            String FI3 = gVar.FI();
            if (TextUtils.isEmpty(FI3)) {
                c0235a.aWF.setText(a.h.ala_gift_draw_txt);
            } else {
                c0235a.aWF.setText(FI3);
            }
            c0235a.aWF.setBackgroundResource(a.e.live_gift_panel_item_script_graffiti);
        } else if (gVar.Fs()) {
            c0235a.aWz.setVisibility(0);
            String FI4 = gVar.FI();
            if (TextUtils.isEmpty(FI4)) {
                c0235a.aWF.setText(a.h.ala_gift_combo_txt);
            } else {
                c0235a.aWF.setText(FI4);
            }
            c0235a.aWF.setBackgroundResource(a.e.live_gift_panel_item_script_graffiti);
        } else if (gVar.FF()) {
            String FI5 = gVar.FI();
            if (TextUtils.isEmpty(FI5)) {
                c0235a.aWF.setText(a.h.ala_gift_broadcast_txt);
            } else {
                c0235a.aWF.setText(FI5);
            }
            c0235a.aWF.setBackgroundResource(a.e.live_gift_panel_item_script_broadcast);
        } else if (!TextUtils.isEmpty(gVar.FI())) {
            String FI6 = gVar.FI();
            c0235a.aWz.setVisibility(0);
            c0235a.aWF.setText(FI6);
            if ("活动".equals(FI6)) {
                c0235a.aWF.setBackgroundResource(a.e.live_gift_panel_item_script_activity);
            } else if ("折扣".equals(FI6)) {
                c0235a.aWF.setBackgroundResource(a.e.live_gift_panel_item_script_discount);
            } else if (FI6 != null && FI6.length() == 1) {
                c0235a.aWF.setBackgroundResource(a.e.live_gift_panel_item_script_new);
            } else {
                c0235a.aWF.setBackgroundResource(a.e.live_gift_panel_item_script_new_wide);
            }
        } else {
            c0235a.aWz.setVisibility(8);
        }
    }

    /* renamed from: com.baidu.live.yuyingift.container.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0235a {
        public LinearLayout aWA;
        public TextView aWC;
        public TextView aWE;
        public TextView aWF;
        public TextView aWG;
        public View aWJ;
        public FrameLayout aWK;
        public ImageView aWL;
        public TextView aWM;
        public FrameLayout aWN;
        public TextView aWO;
        public AnimatorSet aWP;
        public TbImageView aWy;
        public RelativeLayout aWz;
        public ImageView bOm;
        public LottieAnimationView bOn;

        public void recycle() {
            Hl();
        }

        public void Hj() {
            if (this.aWJ != null) {
                this.aWJ.setVisibility(0);
            }
            N(this.aWy);
        }

        public void Hk() {
            if (this.aWJ != null) {
                this.aWJ.setVisibility(8);
            }
            Hl();
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
            this.aWP = new AnimatorSet();
            this.aWP.play(ofFloat).with(ofFloat2);
            this.aWP.start();
        }

        public void Hl() {
            if (this.aWP != null) {
                this.aWP.cancel();
                this.aWP = null;
            }
        }
    }

    private static String ap(long j) {
        if (aWr == null) {
            aWr = new SimpleDateFormat("MM.dd");
        }
        return aWr.format(Long.valueOf(1000 * j));
    }
}

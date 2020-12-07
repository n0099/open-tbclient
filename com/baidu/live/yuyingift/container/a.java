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
    private static SimpleDateFormat aZH;
    private int aZI;
    private int aZJ;
    private int aZK;
    private int aZL;
    private boolean aZM;
    private int bTr;
    private TbPageContext mContext;
    private int mType;
    private int aZE = -1;
    private int mSelectedPosition = -1;
    private boolean aZG = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.yuyingift.container.a.1
        private void a(g gVar, C0244a c0244a) {
            com.baidu.live.gift.c hP;
            if (gVar.Hj() && gVar.aWi == 0 && !com.baidu.live.yuyingift.b.b.Zu().hk(gVar.GX()) && (hP = com.baidu.live.yuyingift.b.b.Zu().hP(gVar.GX())) != null) {
                am.IF().a(hP.aVv, true, true);
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
    private List<g> aZF = Collections.synchronizedList(new ArrayList());

    public a(TbPageContext tbPageContext, int i) {
        this.mContext = tbPageContext;
        this.mType = i;
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
        this.aZL = (int) (this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds8) * dimensionPixelOffset);
        this.bTr = (int) (dimensionPixelOffset * this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds4));
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

    public void a(AbsListView absListView, String str, String str2, int i) {
        int count;
        int firstVisiblePosition;
        View childAt;
        com.baidu.live.gift.c hP;
        if (!TextUtils.isEmpty(str) && (count = getCount()) != 0) {
            int i2 = 0;
            while (true) {
                if (i2 >= count) {
                    i2 = -1;
                    break;
                }
                g item = getItem(i2);
                if (item == null || TextUtils.isEmpty(item.GX()) || (hP = com.baidu.live.yuyingift.b.b.Zu().hP(item.GX())) == null || TextUtils.isEmpty(hP.getDynamicGiftId()) || !hP.getDynamicGiftId().equals(str) || !TextUtils.equals(aj.hw(item.GX()), str2)) {
                    i2++;
                } else {
                    item.aWi = i;
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
        C0244a c0244a;
        g.b bVar;
        String formatGiftNumForTDouDisPlay;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.g.yuyin_ala_gift_list_item, viewGroup, false);
            view.setBackgroundResource(a.e.sdk_transparent_bg);
            C0244a c0244a2 = new C0244a();
            c0244a2.aZO = (TbImageView) view.findViewById(a.f.gift_thumbnail);
            c0244a2.aZO.setDefaultBgResource(a.e.icon_live_gift_default);
            c0244a2.aZO.setDefaultErrorResource(a.e.icon_live_gift_default);
            c0244a2.aZO.setAutoChangeStyle(false);
            c0244a2.aZS = (TextView) view.findViewById(a.f.gift_name);
            c0244a2.aZU = (TextView) view.findViewById(a.f.gift_price);
            c0244a2.aZP = (RelativeLayout) view.findViewById(a.f.llCarom);
            c0244a2.bTu = (LottieAnimationView) view.findViewById(a.f.yuyin_ala_gift_lottie_downloading);
            c0244a2.bTt = (ImageView) view.findViewById(a.f.yuyin_gift_downloading_progress);
            c0244a2.aZV = (TextView) view.findViewById(a.f.gift_carom_txt);
            c0244a2.aZZ = view.findViewById(a.f.selected_bg);
            c0244a2.aZW = (TextView) view.findViewById(a.f.tv_privilege);
            c0244a2.aZQ = (LinearLayout) view.findViewById(a.f.ll_privilege);
            c0244a2.bTv = (FrameLayout) view.findViewById(a.f.layout_pkg_count);
            c0244a2.bTw = (ImageView) view.findViewById(a.f.iv_pkg_count);
            c0244a2.bTx = (TextView) view.findViewById(a.f.tv_pkg_count);
            c0244a2.bab = (FrameLayout) view.findViewById(a.f.layout_script);
            c0244a2.bac = (TextView) view.findViewById(a.f.tv_script);
            c0244a2.bTu.loop(true);
            c0244a2.bTu.setAnimation("yuyin_live_gift_panel_downloading.json");
            view.setTag(c0244a2);
            if (this.aZI <= 0 || this.aZJ <= 0) {
                c0244a = c0244a2;
            } else {
                view.getLayoutParams().height = this.aZI;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c0244a2.aZO.getLayoutParams();
                layoutParams.width = this.aZJ;
                layoutParams.height = this.aZJ;
                layoutParams.topMargin = this.aZK;
                ((RelativeLayout.LayoutParams) c0244a2.aZS.getLayoutParams()).topMargin = this.aZL;
                ((RelativeLayout.LayoutParams) c0244a2.aZU.getLayoutParams()).topMargin = this.bTr;
                c0244a = c0244a2;
            }
        } else {
            c0244a = (C0244a) view.getTag();
        }
        c0244a.Ja();
        if (i == this.mSelectedPosition) {
            c0244a.IZ();
        }
        g item = getItem(i);
        if (this.mType != 1) {
            bVar = null;
        } else {
            bVar = item.aVZ;
        }
        if (item != null) {
            if (item.isRed()) {
                c0244a.aZO.setImageResource(a.e.live_gift_red_enter);
                c0244a.bTt.setVisibility(8);
                c0244a.bTu.setVisibility(8);
                c0244a.bTu.cancelAnimation();
                c0244a.aZS.setText(this.mContext.getPageActivity().getString(a.h.sdk_red_pkt_send));
                c0244a.aZU.setText("");
            } else {
                c0244a.aZO.startLoad(item.getThumbnail_url(), 10, false);
                c0244a.aZS.setText(item.GY());
                if (this.mType == 0) {
                    double d = JavaTypesHelper.toDouble(String.valueOf(item.getPrice()), 0.0d);
                    if (d >= 100.0d && ((this.aZG || com.baidu.live.ae.a.RB().brA.aNQ) && !item.Hi())) {
                        formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
                    } else {
                        formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(item.getPrice()));
                    }
                    c0244a.aZU.setText(formatGiftNumForTDouDisPlay);
                    if (item.Hi()) {
                        c0244a.aZU.setText(this.mContext.getPageActivity().getString(a.h.ala_gift_price_flower_label, new Object[]{formatGiftNumForTDouDisPlay}));
                    } else {
                        c0244a.aZU.setText(this.mContext.getPageActivity().getString(a.h.ala_gift_price_tdou_label, new Object[]{formatGiftNumForTDouDisPlay}));
                    }
                } else if (this.mType == 1) {
                    if (bVar != null && bVar.aWp > 0) {
                        c0244a.aZU.setText(aN(bVar.aWp) + " 失效");
                    } else {
                        c0244a.aZU.setText("");
                    }
                }
                c0244a.aZP.setClickable(false);
                c0244a.aZP.setVisibility(8);
                c0244a.aZV.setBackgroundColor(0);
                c0244a.aZQ.setVisibility(8);
                c0244a.aZO.setAlpha(1.0f);
                c0244a.aZU.setAlpha(1.0f);
                c0244a.aZS.setAlpha(1.0f);
                c0244a.bTv.setVisibility(8);
                c0244a.bTu.setVisibility(8);
                c0244a.bTt.setVisibility(8);
                if (this.mType == 0) {
                    if (item.Hv()) {
                        c0244a.aZO.setAlpha(0.5f);
                        c0244a.aZU.setAlpha(0.5f);
                        c0244a.aZS.setAlpha(0.5f);
                        c0244a.aZP.setVisibility(8);
                        c0244a.aZQ.setVisibility(0);
                        if (!TextUtils.isEmpty(item.Hw())) {
                            c0244a.aZW.setText(item.Hw());
                        } else {
                            c0244a.aZW.setText("");
                        }
                        String Hw = item.Hw();
                        if (item.Hl()) {
                            if (item.Hn()) {
                                c0244a.aZQ.setBackgroundResource(a.e.live_gift_item_script_lock_activity);
                            } else if (item.Ho()) {
                                c0244a.aZQ.setBackgroundResource(a.e.live_gift_item_script_lock_power);
                            } else {
                                c0244a.aZQ.setBackgroundResource(a.e.live_gift_item_script_lock_level);
                            }
                        } else if (Hw.equals("活动")) {
                            c0244a.aZQ.setBackgroundResource(a.e.live_gift_item_script_lock_activity);
                        } else {
                            c0244a.aZQ.setBackgroundResource(a.e.live_gift_item_script_lock_level);
                        }
                    } else if (item.Hj()) {
                        c0244a.aZP.setVisibility(0);
                        if (!com.baidu.live.yuyingift.b.b.Zu().hk(item.GX())) {
                            c0244a.aZV.setText(" ");
                            c0244a.aZP.setClickable(true);
                            c0244a.bTt.setTag(a.f.TAG_GIFT_ITEM, item);
                            c0244a.bTt.setTag(a.f.TAG_GIFT_VIEW_HOLDER, c0244a);
                            c0244a.bTt.setOnClickListener(this.mOnClickListener);
                            if (item.aWi < 100) {
                                c0244a.aZO.setAlpha(0.5f);
                                c0244a.aZU.setAlpha(0.5f);
                                c0244a.aZS.setAlpha(0.5f);
                                c0244a.aZP.setVisibility(4);
                                if (item.aWi == 0) {
                                    c0244a.bTt.setVisibility(0);
                                    c0244a.bTu.setVisibility(8);
                                    c0244a.bTu.cancelAnimation();
                                } else {
                                    c0244a.bTu.setVisibility(0);
                                    c0244a.bTu.playAnimation();
                                }
                            } else if (com.baidu.live.yuyingift.b.b.Zu().hP(item.GX()) != null) {
                                c0244a.bTu.setVisibility(8);
                                c0244a.bTu.cancelAnimation();
                                c0244a.aZP.setVisibility(0);
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
                    if (bVar.aWo > 999) {
                        c0244a.bTw.setImageResource(a.e.live_icon_gift_panel_package_count_large);
                        c0244a.bTx.setText("999+");
                    } else {
                        c0244a.bTw.setImageResource(a.e.live_icon_gift_panel_package_count_small);
                        c0244a.bTx.setText(String.valueOf(bVar.aWo));
                    }
                    c0244a.bTv.setVisibility(0);
                }
            }
        }
        return view;
    }

    private void a(C0244a c0244a, g gVar) {
        c0244a.bTt.setVisibility(8);
        c0244a.bTu.setVisibility(8);
        c0244a.bTu.cancelAnimation();
        if (gVar.Hl()) {
            c0244a.aZP.setVisibility(0);
            String Hw = gVar.Hw();
            c0244a.aZV.setText(Hw);
            if (gVar.Hn()) {
                if (TextUtils.isEmpty(Hw)) {
                    c0244a.aZV.setText(a.h.ala_gift_type_activity);
                }
                c0244a.aZV.setBackgroundResource(a.e.live_gift_panel_item_script_activity);
            } else if (gVar.Hm()) {
                if (TextUtils.isEmpty(Hw)) {
                    c0244a.aZV.setText(a.h.ala_gift_type_discount);
                }
                c0244a.aZV.setBackgroundResource(a.e.live_gift_panel_item_script_discount);
            } else if (gVar.Ho()) {
                if (TextUtils.isEmpty(Hw)) {
                    c0244a.aZV.setText(a.h.ala_gift_type_privilege);
                }
                c0244a.aZV.setBackgroundResource(a.e.live_gift_panel_item_script_power);
            } else if (gVar.Hq()) {
                if (TextUtils.isEmpty(Hw)) {
                    c0244a.aZV.setText(a.h.ala_gift_broadcast_txt);
                }
                c0244a.aZV.setBackgroundResource(a.e.live_gift_panel_item_script_broadcast);
            } else if (gVar.Hp()) {
                if (TextUtils.isEmpty(Hw)) {
                    c0244a.aZV.setText(a.h.ala_gift_draw_txt);
                }
                c0244a.aZV.setBackgroundResource(a.e.live_gift_panel_item_script_graffiti);
            } else if (gVar.Hs()) {
                if (TextUtils.isEmpty(Hw)) {
                    Hw = this.mContext.getPageActivity().getString(a.h.ala_gift_type_new);
                    c0244a.aZV.setText(a.h.ala_gift_type_new);
                }
                if (Hw != null && Hw.length() == 1) {
                    c0244a.aZV.setBackgroundResource(a.e.live_gift_panel_item_script_new);
                } else {
                    c0244a.aZV.setBackgroundResource(a.e.live_gift_panel_item_script_new_wide);
                }
            } else {
                c0244a.aZP.setVisibility(8);
            }
        } else if (gVar.Hz()) {
            c0244a.aZP.setVisibility(0);
            String Hw2 = gVar.Hw();
            if (TextUtils.isEmpty(Hw2)) {
                c0244a.aZV.setText(a.h.ala_gift_privilege_level);
            } else {
                c0244a.aZV.setText(Hw2);
            }
            c0244a.aZV.setBackgroundResource(a.e.live_gift_panel_item_script_level);
        } else if (gVar.Hx() && !this.aZM) {
            c0244a.aZO.setAlpha(0.5f);
            c0244a.aZU.setAlpha(0.5f);
            c0244a.aZS.setAlpha(0.5f);
            c0244a.aZP.setVisibility(8);
            c0244a.aZQ.setBackgroundResource(a.e.live_gift_item_script_lock_level);
            c0244a.aZQ.setVisibility(0);
            c0244a.aZW.setText(a.h.ala_gift_privilege_throne);
        } else if (gVar.Hf()) {
            c0244a.aZP.setVisibility(0);
            String Hw3 = gVar.Hw();
            if (TextUtils.isEmpty(Hw3)) {
                c0244a.aZV.setText(a.h.ala_gift_draw_txt);
            } else {
                c0244a.aZV.setText(Hw3);
            }
            c0244a.aZV.setBackgroundResource(a.e.live_gift_panel_item_script_graffiti);
        } else if (gVar.Hg()) {
            c0244a.aZP.setVisibility(0);
            String Hw4 = gVar.Hw();
            if (TextUtils.isEmpty(Hw4)) {
                c0244a.aZV.setText(a.h.ala_gift_combo_txt);
            } else {
                c0244a.aZV.setText(Hw4);
            }
            c0244a.aZV.setBackgroundResource(a.e.live_gift_panel_item_script_graffiti);
        } else if (gVar.Ht()) {
            String Hw5 = gVar.Hw();
            if (TextUtils.isEmpty(Hw5)) {
                c0244a.aZV.setText(a.h.ala_gift_broadcast_txt);
            } else {
                c0244a.aZV.setText(Hw5);
            }
            c0244a.aZV.setBackgroundResource(a.e.live_gift_panel_item_script_broadcast);
        } else if (!TextUtils.isEmpty(gVar.Hw())) {
            String Hw6 = gVar.Hw();
            c0244a.aZP.setVisibility(0);
            c0244a.aZV.setText(Hw6);
            if ("活动".equals(Hw6)) {
                c0244a.aZV.setBackgroundResource(a.e.live_gift_panel_item_script_activity);
            } else if ("折扣".equals(Hw6)) {
                c0244a.aZV.setBackgroundResource(a.e.live_gift_panel_item_script_discount);
            } else if (Hw6 != null && Hw6.length() == 1) {
                c0244a.aZV.setBackgroundResource(a.e.live_gift_panel_item_script_new);
            } else {
                c0244a.aZV.setBackgroundResource(a.e.live_gift_panel_item_script_new_wide);
            }
        } else {
            c0244a.aZP.setVisibility(8);
        }
    }

    /* renamed from: com.baidu.live.yuyingift.container.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0244a {
        public TbImageView aZO;
        public RelativeLayout aZP;
        public LinearLayout aZQ;
        public TextView aZS;
        public TextView aZU;
        public TextView aZV;
        public TextView aZW;
        public View aZZ;
        public ImageView bTt;
        public LottieAnimationView bTu;
        public FrameLayout bTv;
        public ImageView bTw;
        public TextView bTx;
        public FrameLayout bab;
        public TextView bac;
        public AnimatorSet bad;

        public void recycle() {
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
            aZH = new SimpleDateFormat("MM.dd");
        }
        return aZH.format(Long.valueOf(1000 * j));
    }
}

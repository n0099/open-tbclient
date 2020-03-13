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
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.gift.g;
import com.baidu.live.gift.t;
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
    private static SimpleDateFormat aiP;
    private int aiQ;
    private int aiR;
    private int aiS;
    private boolean aiT;
    private TbPageContext mContext;
    private int mType;
    private int aiM = -1;
    private int mSelectedPosition = -1;
    private boolean aiO = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.gift.container.a.1
        private void a(g gVar, C0085a c0085a) {
            com.baidu.live.gift.c dH;
            if ((gVar.rJ() || gVar.rS()) && !com.baidu.live.gift.b.b.uu().dm(gVar.rx()) && (dH = com.baidu.live.gift.b.b.uu().dH(gVar.rx())) != null) {
                com.baidu.live.gift.b.a.a(dH.afL, true);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view.getTag(a.g.TAG_GIFT_ITEM) instanceof g) && (view.getTag(a.g.TAG_GIFT_VIEW_HOLDER) instanceof C0085a)) {
                C0085a c0085a = (C0085a) view.getTag(a.g.TAG_GIFT_VIEW_HOLDER);
                g gVar = (g) view.getTag(a.g.TAG_GIFT_ITEM);
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(a.this.mContext.getPageActivity(), a.this.mContext.getString(a.i.sdk_neterror));
                } else {
                    a(gVar, c0085a);
                }
            }
        }
    };
    private List<g> aiN = Collections.synchronizedList(new ArrayList());

    public a(TbPageContext tbPageContext, int i) {
        this.mContext = tbPageContext;
        this.mType = i;
    }

    public void setGiftItems(List<g> list) {
        if (this.aiN == null) {
            this.aiN = Collections.synchronizedList(new ArrayList());
        } else {
            this.aiN.clear();
        }
        if (list != null) {
            this.aiN.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void p(String str, int i) {
        if (this.aiN != null) {
            for (g gVar : this.aiN) {
                if (gVar.agn != null && gVar.rx().equals(str)) {
                    gVar.agn.agu = i;
                }
            }
            notifyDataSetChanged();
        }
    }

    public void bv(int i) {
        this.aiM = i;
    }

    public void bw(int i) {
        this.mSelectedPosition = i;
    }

    public int getSelectedPosition() {
        return this.mSelectedPosition;
    }

    public void aC(boolean z) {
        this.aiO = z;
    }

    public void bx(int i) {
        this.aiQ = i;
        float dimensionPixelOffset = (i * 1.0f) / this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds192);
        this.aiR = (int) (this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds100) * dimensionPixelOffset);
        this.aiS = (int) (dimensionPixelOffset * this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds18));
    }

    public void aq(boolean z) {
        this.aiT = z;
    }

    public void a(AbsListView absListView, boolean z) {
        int firstVisiblePosition;
        View childAt;
        this.aiT = z;
        int count = getCount();
        if (count != 0) {
            for (int i = 0; i < count; i++) {
                if (getItem(i).rW() && i >= (firstVisiblePosition = absListView.getFirstVisiblePosition()) && i <= absListView.getLastVisiblePosition() && (childAt = absListView.getChildAt(i - firstVisiblePosition)) != null) {
                    getView(i, childAt, absListView);
                }
            }
        }
    }

    public void a(AbsListView absListView, String str, String str2) {
        int count;
        int firstVisiblePosition;
        View childAt;
        com.baidu.live.gift.c dH;
        if (!TextUtils.isEmpty(str) && (count = getCount()) != 0) {
            int i = 0;
            while (true) {
                if (i >= count) {
                    i = -1;
                    break;
                }
                g item = getItem(i);
                if (item != null && !TextUtils.isEmpty(item.rx()) && (dH = com.baidu.live.gift.b.b.uu().dH(item.rx())) != null && !TextUtils.isEmpty(dH.getDynamicGiftId()) && dH.getDynamicGiftId().equals(str) && t.dt(item.rx()).equals(str2)) {
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
        if (this.aiN == null) {
            return 0;
        }
        return this.aiN.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: by */
    public g getItem(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.aiN.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0085a c0085a;
        g.a aVar;
        String formatGiftNumForTDouDisPlay;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.ala_gift_list_item, viewGroup, false);
            view.setBackgroundResource(a.f.sdk_transparent_bg);
            C0085a c0085a2 = new C0085a();
            c0085a2.aiV = (TbImageView) view.findViewById(a.g.gift_thumbnail);
            c0085a2.aiV.setDefaultBgResource(a.f.icon_live_gift_default);
            c0085a2.aiV.setDefaultErrorResource(a.f.icon_live_gift_default);
            c0085a2.aiV.setAutoChangeStyle(false);
            c0085a2.aiY = (TextView) view.findViewById(a.g.gift_name);
            c0085a2.aiZ = (TextView) view.findViewById(a.g.gift_price);
            c0085a2.aiW = (RelativeLayout) view.findViewById(a.g.llCarom);
            c0085a2.aja = (TextView) view.findViewById(a.g.gift_carom_txt);
            c0085a2.ajc = view.findViewById(a.g.in_progress);
            c0085a2.ajd = (LottieAnimationView) view.findViewById(a.g.lottie_downloading);
            c0085a2.ajd.loop(true);
            c0085a2.ajd.setAnimation("live_gift_panel_downloading.json");
            c0085a2.aje = view.findViewById(a.g.selected_bg);
            c0085a2.ajb = (TextView) view.findViewById(a.g.tv_privilege);
            c0085a2.aiX = (LinearLayout) view.findViewById(a.g.ll_privilege);
            c0085a2.ajf = (FrameLayout) view.findViewById(a.g.layout_pkg_count);
            c0085a2.ajg = (ImageView) view.findViewById(a.g.iv_pkg_count);
            c0085a2.ajh = (TextView) view.findViewById(a.g.tv_pkg_count);
            c0085a2.aji = (FrameLayout) view.findViewById(a.g.layout_script);
            c0085a2.ajj = (TextView) view.findViewById(a.g.tv_script);
            view.setTag(c0085a2);
            if (this.aiQ <= 0 || this.aiR <= 0) {
                c0085a = c0085a2;
            } else {
                view.getLayoutParams().height = this.aiQ;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c0085a2.aiV.getLayoutParams();
                layoutParams.width = this.aiR;
                layoutParams.height = this.aiR;
                layoutParams.topMargin = this.aiS;
                c0085a = c0085a2;
            }
        } else {
            c0085a = (C0085a) view.getTag();
        }
        c0085a.tl();
        if (i == this.mSelectedPosition) {
            c0085a.tk();
        }
        g item = getItem(i);
        if (this.mType != 1) {
            aVar = null;
        } else {
            aVar = item.agn;
        }
        if (item != null) {
            if (item.isRed()) {
                c0085a.aiV.setImageResource(a.f.live_gift_red_enter);
                c0085a.aiY.setText(this.mContext.getPageActivity().getString(a.i.sdk_red_pkt_send));
                c0085a.aiZ.setText("");
            } else {
                c0085a.aiV.startLoad(item.rA(), 10, false);
                c0085a.aiY.setText(item.ry());
                if (this.mType == 0) {
                    double d = JavaTypesHelper.toDouble(String.valueOf(item.getPrice()), 0.0d);
                    if (d >= 100.0d && ((this.aiO || com.baidu.live.v.a.zl().awC.aaq) && !item.rI())) {
                        formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
                    } else {
                        formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(item.getPrice()));
                    }
                    c0085a.aiZ.setText(formatGiftNumForTDouDisPlay);
                    if (item.rI()) {
                        c0085a.aiZ.setText(this.mContext.getPageActivity().getString(a.i.ala_gift_price_flower_label, new Object[]{formatGiftNumForTDouDisPlay}));
                    } else {
                        c0085a.aiZ.setText(this.mContext.getPageActivity().getString(a.i.ala_gift_price_tdou_label, new Object[]{formatGiftNumForTDouDisPlay}));
                    }
                } else if (this.mType == 1) {
                    if (aVar != null) {
                        c0085a.aiZ.setText(y(aVar.agv) + " 失效");
                    } else {
                        c0085a.aiZ.setText("");
                    }
                }
                c0085a.aiW.setClickable(false);
                c0085a.aiX.setVisibility(8);
                c0085a.aiV.setAlpha(1.0f);
                c0085a.aiZ.setAlpha(1.0f);
                c0085a.aiY.setAlpha(1.0f);
                c0085a.ajf.setVisibility(8);
                c0085a.ajc.setVisibility(4);
                c0085a.ajd.cancelAnimation();
                if (this.mType == 0) {
                    if (item.rU()) {
                        c0085a.aiV.setAlpha(0.5f);
                        c0085a.aiZ.setAlpha(0.5f);
                        c0085a.aiY.setAlpha(0.5f);
                        c0085a.aiW.setVisibility(8);
                        c0085a.aiX.setVisibility(0);
                        if (!TextUtils.isEmpty(item.rV())) {
                            c0085a.ajb.setText(item.rV());
                        } else {
                            c0085a.ajb.setText("");
                        }
                        String rV = item.rV();
                        if (item.rL()) {
                            if (item.rN()) {
                                c0085a.aiX.setBackgroundResource(a.f.live_gift_item_script_lock_activity);
                            } else if (item.rO()) {
                                c0085a.aiX.setBackgroundResource(a.f.live_gift_item_script_lock_power);
                            } else {
                                c0085a.aiX.setBackgroundResource(a.f.live_gift_item_script_lock_level);
                            }
                        } else if (rV.equals("活动")) {
                            c0085a.aiX.setBackgroundResource(a.f.live_gift_item_script_lock_activity);
                        } else {
                            c0085a.aiX.setBackgroundResource(a.f.live_gift_item_script_lock_level);
                        }
                    } else if (item.rJ() || item.rS()) {
                        c0085a.aiW.setVisibility(0);
                        if (!com.baidu.live.gift.b.b.uu().dm(item.rx())) {
                            c0085a.aja.setText(HanziToPinyin.Token.SEPARATOR);
                            c0085a.aja.setBackgroundResource(a.f.live_gift_panel_item_script_download);
                            c0085a.aiW.setTag(a.g.TAG_GIFT_ITEM, item);
                            c0085a.aiW.setTag(a.g.TAG_GIFT_VIEW_HOLDER, c0085a);
                            c0085a.aiW.setClickable(true);
                            c0085a.aiW.setOnClickListener(this.mOnClickListener);
                            if (com.baidu.live.gift.b.a.Y(item.rx(), t.dt(item.rx()))) {
                                c0085a.aiV.setAlpha(0.5f);
                                c0085a.aiZ.setAlpha(0.5f);
                                c0085a.aiY.setAlpha(0.5f);
                                c0085a.ajc.setVisibility(0);
                                c0085a.ajd.playAnimation();
                                c0085a.aiW.setVisibility(4);
                            } else {
                                c0085a.ajc.setVisibility(4);
                                c0085a.ajd.cancelAnimation();
                                c0085a.aiW.setVisibility(0);
                            }
                        } else {
                            a(c0085a, item);
                        }
                    } else {
                        a(c0085a, item);
                    }
                } else if (this.mType == 1 && aVar != null) {
                    if (aVar.agu > 999) {
                        c0085a.ajg.setImageResource(a.f.live_icon_gift_panel_package_count_large);
                        c0085a.ajh.setText("999+");
                    } else {
                        c0085a.ajg.setImageResource(a.f.live_icon_gift_panel_package_count_small);
                        c0085a.ajh.setText(String.valueOf(aVar.agu));
                    }
                    c0085a.ajf.setVisibility(0);
                }
            }
        }
        return view;
    }

    private void a(C0085a c0085a, g gVar) {
        c0085a.ajc.setVisibility(4);
        c0085a.ajd.cancelAnimation();
        if (gVar.rL()) {
            c0085a.aiW.setVisibility(0);
            String rV = gVar.rV();
            c0085a.aja.setText(rV);
            if (gVar.rN()) {
                if (TextUtils.isEmpty(rV)) {
                    c0085a.aja.setText(a.i.ala_gift_type_activity);
                }
                c0085a.aja.setBackgroundResource(a.f.live_gift_panel_item_script_activity);
            } else if (gVar.rM()) {
                if (TextUtils.isEmpty(rV)) {
                    c0085a.aja.setText(a.i.ala_gift_type_discount);
                }
                c0085a.aja.setBackgroundResource(a.f.live_gift_panel_item_script_discount);
            } else if (gVar.rO()) {
                if (TextUtils.isEmpty(rV)) {
                    c0085a.aja.setText(a.i.ala_gift_type_privilege);
                }
                c0085a.aja.setBackgroundResource(a.f.live_gift_panel_item_script_power);
            } else if (gVar.rQ()) {
                if (TextUtils.isEmpty(rV)) {
                    c0085a.aja.setText(a.i.ala_gift_broadcast_txt);
                }
                c0085a.aja.setBackgroundResource(a.f.live_gift_panel_item_script_broadcast);
            } else if (gVar.rP()) {
                if (TextUtils.isEmpty(rV)) {
                    c0085a.aja.setText(a.i.ala_gift_draw_txt);
                }
                c0085a.aja.setBackgroundResource(a.f.live_gift_panel_item_script_graffiti);
            } else if (gVar.rR()) {
                if (TextUtils.isEmpty(rV)) {
                    rV = this.mContext.getPageActivity().getString(a.i.ala_gift_type_new);
                    c0085a.aja.setText(a.i.ala_gift_type_new);
                }
                if (rV != null && rV.length() == 1) {
                    c0085a.aja.setBackgroundResource(a.f.live_gift_panel_item_script_new);
                } else {
                    c0085a.aja.setBackgroundResource(a.f.live_gift_panel_item_script_new_wide);
                }
            } else {
                c0085a.aiW.setVisibility(8);
            }
        } else if (gVar.rX()) {
            c0085a.aiW.setVisibility(0);
            String rV2 = gVar.rV();
            if (TextUtils.isEmpty(rV2)) {
                c0085a.aja.setText(a.i.ala_gift_privilege_level);
            } else {
                c0085a.aja.setText(rV2);
            }
            c0085a.aja.setBackgroundResource(a.f.live_gift_panel_item_script_level);
        } else if (gVar.rW() && !this.aiT) {
            c0085a.aiV.setAlpha(0.5f);
            c0085a.aiZ.setAlpha(0.5f);
            c0085a.aiY.setAlpha(0.5f);
            c0085a.aiW.setVisibility(8);
            c0085a.aiX.setBackgroundResource(a.f.live_gift_item_script_lock_level);
            c0085a.aiX.setVisibility(0);
            c0085a.ajb.setText(a.i.ala_gift_privilege_throne);
        } else if (gVar.rF()) {
            c0085a.aiW.setVisibility(0);
            String rV3 = gVar.rV();
            if (TextUtils.isEmpty(rV3)) {
                c0085a.aja.setText(a.i.ala_gift_draw_txt);
            } else {
                c0085a.aja.setText(rV3);
            }
            c0085a.aja.setBackgroundResource(a.f.live_gift_panel_item_script_graffiti);
        } else if (gVar.rG()) {
            c0085a.aiW.setVisibility(0);
            String rV4 = gVar.rV();
            if (TextUtils.isEmpty(rV4)) {
                c0085a.aja.setText(a.i.ala_gift_combo_txt);
            } else {
                c0085a.aja.setText(rV4);
            }
            c0085a.aja.setBackgroundResource(a.f.live_gift_panel_item_script_graffiti);
        } else if (gVar.rS()) {
            String rV5 = gVar.rV();
            if (TextUtils.isEmpty(rV5)) {
                c0085a.aja.setText(a.i.ala_gift_broadcast_txt);
            } else {
                c0085a.aja.setText(rV5);
            }
            c0085a.aja.setBackgroundResource(a.f.live_gift_panel_item_script_broadcast);
        } else if (!TextUtils.isEmpty(gVar.rV())) {
            String rV6 = gVar.rV();
            c0085a.aiW.setVisibility(0);
            c0085a.aja.setText(rV6);
            if ("活动".equals(rV6)) {
                c0085a.aja.setBackgroundResource(a.f.live_gift_panel_item_script_activity);
            } else if ("折扣".equals(rV6)) {
                c0085a.aja.setBackgroundResource(a.f.live_gift_panel_item_script_discount);
            } else if (rV6 != null && rV6.length() == 1) {
                c0085a.aja.setBackgroundResource(a.f.live_gift_panel_item_script_new);
            } else {
                c0085a.aja.setBackgroundResource(a.f.live_gift_panel_item_script_new_wide);
            }
        } else {
            c0085a.aiW.setVisibility(8);
        }
    }

    /* renamed from: com.baidu.live.gift.container.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0085a {
        public TbImageView aiV;
        public RelativeLayout aiW;
        public LinearLayout aiX;
        public TextView aiY;
        public TextView aiZ;
        public TextView aja;
        public TextView ajb;
        public View ajc;
        public LottieAnimationView ajd;
        public View aje;
        public FrameLayout ajf;
        public ImageView ajg;
        public TextView ajh;
        public FrameLayout aji;
        public TextView ajj;
        public AnimatorSet ajk;

        public void recycle() {
            if (this.ajd != null) {
                this.ajd.cancelAnimation();
            }
            tm();
        }

        public void tk() {
            if (this.aje != null) {
                this.aje.setVisibility(0);
            }
            L(this.aiV);
        }

        public void tl() {
            if (this.aje != null) {
                this.aje.setVisibility(8);
            }
            tm();
        }

        private void L(View view) {
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
            this.ajk = new AnimatorSet();
            this.ajk.play(ofFloat).with(ofFloat2);
            this.ajk.start();
        }

        public void tm() {
            if (this.ajk != null) {
                this.ajk.cancel();
                this.ajk = null;
            }
        }
    }

    private static String y(long j) {
        if (aiP == null) {
            aiP = new SimpleDateFormat("MM.dd");
        }
        return aiP.format(Long.valueOf(1000 * j));
    }
}

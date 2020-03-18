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
    private static SimpleDateFormat aiZ;
    private int aja;
    private int ajb;
    private int ajc;
    private boolean ajd;
    private TbPageContext mContext;
    private int mType;
    private int aiW = -1;
    private int mSelectedPosition = -1;
    private boolean aiY = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.gift.container.a.1
        private void a(g gVar, C0085a c0085a) {
            com.baidu.live.gift.c dG;
            if ((gVar.rO() || gVar.rX()) && !com.baidu.live.gift.b.b.uz().dl(gVar.rC()) && (dG = com.baidu.live.gift.b.b.uz().dG(gVar.rC())) != null) {
                com.baidu.live.gift.b.a.a(dG.afV, true);
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
    private List<g> aiX = Collections.synchronizedList(new ArrayList());

    public a(TbPageContext tbPageContext, int i) {
        this.mContext = tbPageContext;
        this.mType = i;
    }

    public void setGiftItems(List<g> list) {
        if (this.aiX == null) {
            this.aiX = Collections.synchronizedList(new ArrayList());
        } else {
            this.aiX.clear();
        }
        if (list != null) {
            this.aiX.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void p(String str, int i) {
        if (this.aiX != null) {
            for (g gVar : this.aiX) {
                if (gVar.agx != null && gVar.rC().equals(str)) {
                    gVar.agx.agE = i;
                }
            }
            notifyDataSetChanged();
        }
    }

    public void bv(int i) {
        this.aiW = i;
    }

    public void bw(int i) {
        this.mSelectedPosition = i;
    }

    public int getSelectedPosition() {
        return this.mSelectedPosition;
    }

    public void aC(boolean z) {
        this.aiY = z;
    }

    public void bx(int i) {
        this.aja = i;
        float dimensionPixelOffset = (i * 1.0f) / this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds192);
        this.ajb = (int) (this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds100) * dimensionPixelOffset);
        this.ajc = (int) (dimensionPixelOffset * this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds18));
    }

    public void aq(boolean z) {
        this.ajd = z;
    }

    public void a(AbsListView absListView, boolean z) {
        int firstVisiblePosition;
        View childAt;
        this.ajd = z;
        int count = getCount();
        if (count != 0) {
            for (int i = 0; i < count; i++) {
                if (getItem(i).sb() && i >= (firstVisiblePosition = absListView.getFirstVisiblePosition()) && i <= absListView.getLastVisiblePosition() && (childAt = absListView.getChildAt(i - firstVisiblePosition)) != null) {
                    getView(i, childAt, absListView);
                }
            }
        }
    }

    public void a(AbsListView absListView, String str, String str2) {
        int count;
        int firstVisiblePosition;
        View childAt;
        com.baidu.live.gift.c dG;
        if (!TextUtils.isEmpty(str) && (count = getCount()) != 0) {
            int i = 0;
            while (true) {
                if (i >= count) {
                    i = -1;
                    break;
                }
                g item = getItem(i);
                if (item != null && !TextUtils.isEmpty(item.rC()) && (dG = com.baidu.live.gift.b.b.uz().dG(item.rC())) != null && !TextUtils.isEmpty(dG.getDynamicGiftId()) && dG.getDynamicGiftId().equals(str) && t.ds(item.rC()).equals(str2)) {
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
        if (this.aiX == null) {
            return 0;
        }
        return this.aiX.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: by */
    public g getItem(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.aiX.get(i);
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
            c0085a2.ajf = (TbImageView) view.findViewById(a.g.gift_thumbnail);
            c0085a2.ajf.setDefaultBgResource(a.f.icon_live_gift_default);
            c0085a2.ajf.setDefaultErrorResource(a.f.icon_live_gift_default);
            c0085a2.ajf.setAutoChangeStyle(false);
            c0085a2.aji = (TextView) view.findViewById(a.g.gift_name);
            c0085a2.ajj = (TextView) view.findViewById(a.g.gift_price);
            c0085a2.ajg = (RelativeLayout) view.findViewById(a.g.llCarom);
            c0085a2.ajk = (TextView) view.findViewById(a.g.gift_carom_txt);
            c0085a2.ajm = view.findViewById(a.g.in_progress);
            c0085a2.ajn = (LottieAnimationView) view.findViewById(a.g.lottie_downloading);
            c0085a2.ajn.loop(true);
            c0085a2.ajn.setAnimation("live_gift_panel_downloading.json");
            c0085a2.ajo = view.findViewById(a.g.selected_bg);
            c0085a2.ajl = (TextView) view.findViewById(a.g.tv_privilege);
            c0085a2.ajh = (LinearLayout) view.findViewById(a.g.ll_privilege);
            c0085a2.ajp = (FrameLayout) view.findViewById(a.g.layout_pkg_count);
            c0085a2.ajq = (ImageView) view.findViewById(a.g.iv_pkg_count);
            c0085a2.ajr = (TextView) view.findViewById(a.g.tv_pkg_count);
            c0085a2.ajs = (FrameLayout) view.findViewById(a.g.layout_script);
            c0085a2.ajt = (TextView) view.findViewById(a.g.tv_script);
            view.setTag(c0085a2);
            if (this.aja <= 0 || this.ajb <= 0) {
                c0085a = c0085a2;
            } else {
                view.getLayoutParams().height = this.aja;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c0085a2.ajf.getLayoutParams();
                layoutParams.width = this.ajb;
                layoutParams.height = this.ajb;
                layoutParams.topMargin = this.ajc;
                c0085a = c0085a2;
            }
        } else {
            c0085a = (C0085a) view.getTag();
        }
        c0085a.tr();
        if (i == this.mSelectedPosition) {
            c0085a.tq();
        }
        g item = getItem(i);
        if (this.mType != 1) {
            aVar = null;
        } else {
            aVar = item.agx;
        }
        if (item != null) {
            if (item.isRed()) {
                c0085a.ajf.setImageResource(a.f.live_gift_red_enter);
                c0085a.aji.setText(this.mContext.getPageActivity().getString(a.i.sdk_red_pkt_send));
                c0085a.ajj.setText("");
            } else {
                c0085a.ajf.startLoad(item.rF(), 10, false);
                c0085a.aji.setText(item.rD());
                if (this.mType == 0) {
                    double d = JavaTypesHelper.toDouble(String.valueOf(item.getPrice()), 0.0d);
                    if (d >= 100.0d && ((this.aiY || com.baidu.live.v.a.zs().awM.aaA) && !item.rN())) {
                        formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
                    } else {
                        formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(item.getPrice()));
                    }
                    c0085a.ajj.setText(formatGiftNumForTDouDisPlay);
                    if (item.rN()) {
                        c0085a.ajj.setText(this.mContext.getPageActivity().getString(a.i.ala_gift_price_flower_label, new Object[]{formatGiftNumForTDouDisPlay}));
                    } else {
                        c0085a.ajj.setText(this.mContext.getPageActivity().getString(a.i.ala_gift_price_tdou_label, new Object[]{formatGiftNumForTDouDisPlay}));
                    }
                } else if (this.mType == 1) {
                    if (aVar != null) {
                        c0085a.ajj.setText(y(aVar.agF) + " 失效");
                    } else {
                        c0085a.ajj.setText("");
                    }
                }
                c0085a.ajg.setClickable(false);
                c0085a.ajh.setVisibility(8);
                c0085a.ajf.setAlpha(1.0f);
                c0085a.ajj.setAlpha(1.0f);
                c0085a.aji.setAlpha(1.0f);
                c0085a.ajp.setVisibility(8);
                c0085a.ajm.setVisibility(4);
                c0085a.ajn.cancelAnimation();
                if (this.mType == 0) {
                    if (item.rZ()) {
                        c0085a.ajf.setAlpha(0.5f);
                        c0085a.ajj.setAlpha(0.5f);
                        c0085a.aji.setAlpha(0.5f);
                        c0085a.ajg.setVisibility(8);
                        c0085a.ajh.setVisibility(0);
                        if (!TextUtils.isEmpty(item.sa())) {
                            c0085a.ajl.setText(item.sa());
                        } else {
                            c0085a.ajl.setText("");
                        }
                        String sa = item.sa();
                        if (item.rQ()) {
                            if (item.rS()) {
                                c0085a.ajh.setBackgroundResource(a.f.live_gift_item_script_lock_activity);
                            } else if (item.rT()) {
                                c0085a.ajh.setBackgroundResource(a.f.live_gift_item_script_lock_power);
                            } else {
                                c0085a.ajh.setBackgroundResource(a.f.live_gift_item_script_lock_level);
                            }
                        } else if (sa.equals("活动")) {
                            c0085a.ajh.setBackgroundResource(a.f.live_gift_item_script_lock_activity);
                        } else {
                            c0085a.ajh.setBackgroundResource(a.f.live_gift_item_script_lock_level);
                        }
                    } else if (item.rO() || item.rX()) {
                        c0085a.ajg.setVisibility(0);
                        if (!com.baidu.live.gift.b.b.uz().dl(item.rC())) {
                            c0085a.ajk.setText(HanziToPinyin.Token.SEPARATOR);
                            c0085a.ajk.setBackgroundResource(a.f.live_gift_panel_item_script_download);
                            c0085a.ajg.setTag(a.g.TAG_GIFT_ITEM, item);
                            c0085a.ajg.setTag(a.g.TAG_GIFT_VIEW_HOLDER, c0085a);
                            c0085a.ajg.setClickable(true);
                            c0085a.ajg.setOnClickListener(this.mOnClickListener);
                            if (com.baidu.live.gift.b.a.X(item.rC(), t.ds(item.rC()))) {
                                c0085a.ajf.setAlpha(0.5f);
                                c0085a.ajj.setAlpha(0.5f);
                                c0085a.aji.setAlpha(0.5f);
                                c0085a.ajm.setVisibility(0);
                                c0085a.ajn.playAnimation();
                                c0085a.ajg.setVisibility(4);
                            } else {
                                c0085a.ajm.setVisibility(4);
                                c0085a.ajn.cancelAnimation();
                                c0085a.ajg.setVisibility(0);
                            }
                        } else {
                            a(c0085a, item);
                        }
                    } else {
                        a(c0085a, item);
                    }
                } else if (this.mType == 1 && aVar != null) {
                    if (aVar.agE > 999) {
                        c0085a.ajq.setImageResource(a.f.live_icon_gift_panel_package_count_large);
                        c0085a.ajr.setText("999+");
                    } else {
                        c0085a.ajq.setImageResource(a.f.live_icon_gift_panel_package_count_small);
                        c0085a.ajr.setText(String.valueOf(aVar.agE));
                    }
                    c0085a.ajp.setVisibility(0);
                }
            }
        }
        return view;
    }

    private void a(C0085a c0085a, g gVar) {
        c0085a.ajm.setVisibility(4);
        c0085a.ajn.cancelAnimation();
        if (gVar.rQ()) {
            c0085a.ajg.setVisibility(0);
            String sa = gVar.sa();
            c0085a.ajk.setText(sa);
            if (gVar.rS()) {
                if (TextUtils.isEmpty(sa)) {
                    c0085a.ajk.setText(a.i.ala_gift_type_activity);
                }
                c0085a.ajk.setBackgroundResource(a.f.live_gift_panel_item_script_activity);
            } else if (gVar.rR()) {
                if (TextUtils.isEmpty(sa)) {
                    c0085a.ajk.setText(a.i.ala_gift_type_discount);
                }
                c0085a.ajk.setBackgroundResource(a.f.live_gift_panel_item_script_discount);
            } else if (gVar.rT()) {
                if (TextUtils.isEmpty(sa)) {
                    c0085a.ajk.setText(a.i.ala_gift_type_privilege);
                }
                c0085a.ajk.setBackgroundResource(a.f.live_gift_panel_item_script_power);
            } else if (gVar.rV()) {
                if (TextUtils.isEmpty(sa)) {
                    c0085a.ajk.setText(a.i.ala_gift_broadcast_txt);
                }
                c0085a.ajk.setBackgroundResource(a.f.live_gift_panel_item_script_broadcast);
            } else if (gVar.rU()) {
                if (TextUtils.isEmpty(sa)) {
                    c0085a.ajk.setText(a.i.ala_gift_draw_txt);
                }
                c0085a.ajk.setBackgroundResource(a.f.live_gift_panel_item_script_graffiti);
            } else if (gVar.rW()) {
                if (TextUtils.isEmpty(sa)) {
                    sa = this.mContext.getPageActivity().getString(a.i.ala_gift_type_new);
                    c0085a.ajk.setText(a.i.ala_gift_type_new);
                }
                if (sa != null && sa.length() == 1) {
                    c0085a.ajk.setBackgroundResource(a.f.live_gift_panel_item_script_new);
                } else {
                    c0085a.ajk.setBackgroundResource(a.f.live_gift_panel_item_script_new_wide);
                }
            } else {
                c0085a.ajg.setVisibility(8);
            }
        } else if (gVar.sc()) {
            c0085a.ajg.setVisibility(0);
            String sa2 = gVar.sa();
            if (TextUtils.isEmpty(sa2)) {
                c0085a.ajk.setText(a.i.ala_gift_privilege_level);
            } else {
                c0085a.ajk.setText(sa2);
            }
            c0085a.ajk.setBackgroundResource(a.f.live_gift_panel_item_script_level);
        } else if (gVar.sb() && !this.ajd) {
            c0085a.ajf.setAlpha(0.5f);
            c0085a.ajj.setAlpha(0.5f);
            c0085a.aji.setAlpha(0.5f);
            c0085a.ajg.setVisibility(8);
            c0085a.ajh.setBackgroundResource(a.f.live_gift_item_script_lock_level);
            c0085a.ajh.setVisibility(0);
            c0085a.ajl.setText(a.i.ala_gift_privilege_throne);
        } else if (gVar.rK()) {
            c0085a.ajg.setVisibility(0);
            String sa3 = gVar.sa();
            if (TextUtils.isEmpty(sa3)) {
                c0085a.ajk.setText(a.i.ala_gift_draw_txt);
            } else {
                c0085a.ajk.setText(sa3);
            }
            c0085a.ajk.setBackgroundResource(a.f.live_gift_panel_item_script_graffiti);
        } else if (gVar.rL()) {
            c0085a.ajg.setVisibility(0);
            String sa4 = gVar.sa();
            if (TextUtils.isEmpty(sa4)) {
                c0085a.ajk.setText(a.i.ala_gift_combo_txt);
            } else {
                c0085a.ajk.setText(sa4);
            }
            c0085a.ajk.setBackgroundResource(a.f.live_gift_panel_item_script_graffiti);
        } else if (gVar.rX()) {
            String sa5 = gVar.sa();
            if (TextUtils.isEmpty(sa5)) {
                c0085a.ajk.setText(a.i.ala_gift_broadcast_txt);
            } else {
                c0085a.ajk.setText(sa5);
            }
            c0085a.ajk.setBackgroundResource(a.f.live_gift_panel_item_script_broadcast);
        } else if (!TextUtils.isEmpty(gVar.sa())) {
            String sa6 = gVar.sa();
            c0085a.ajg.setVisibility(0);
            c0085a.ajk.setText(sa6);
            if ("活动".equals(sa6)) {
                c0085a.ajk.setBackgroundResource(a.f.live_gift_panel_item_script_activity);
            } else if ("折扣".equals(sa6)) {
                c0085a.ajk.setBackgroundResource(a.f.live_gift_panel_item_script_discount);
            } else if (sa6 != null && sa6.length() == 1) {
                c0085a.ajk.setBackgroundResource(a.f.live_gift_panel_item_script_new);
            } else {
                c0085a.ajk.setBackgroundResource(a.f.live_gift_panel_item_script_new_wide);
            }
        } else {
            c0085a.ajg.setVisibility(8);
        }
    }

    /* renamed from: com.baidu.live.gift.container.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0085a {
        public TbImageView ajf;
        public RelativeLayout ajg;
        public LinearLayout ajh;
        public TextView aji;
        public TextView ajj;
        public TextView ajk;
        public TextView ajl;
        public View ajm;
        public LottieAnimationView ajn;
        public View ajo;
        public FrameLayout ajp;
        public ImageView ajq;
        public TextView ajr;
        public FrameLayout ajs;
        public TextView ajt;
        public AnimatorSet aju;

        public void recycle() {
            if (this.ajn != null) {
                this.ajn.cancelAnimation();
            }
            ts();
        }

        public void tq() {
            if (this.ajo != null) {
                this.ajo.setVisibility(0);
            }
            L(this.ajf);
        }

        public void tr() {
            if (this.ajo != null) {
                this.ajo.setVisibility(8);
            }
            ts();
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
            this.aju = new AnimatorSet();
            this.aju.play(ofFloat).with(ofFloat2);
            this.aju.start();
        }

        public void ts() {
            if (this.aju != null) {
                this.aju.cancel();
                this.aju = null;
            }
        }
    }

    private static String y(long j) {
        if (aiZ == null) {
            aiZ = new SimpleDateFormat("MM.dd");
        }
        return aiZ.format(Long.valueOf(1000 * j));
    }
}

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
import com.baidu.live.gift.u;
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
    private static SimpleDateFormat aBy;
    private int aBA;
    private int aBB;
    private boolean aBC;
    private int aBz;
    private TbPageContext mContext;
    private int mType;
    private int aBv = -1;
    private int mSelectedPosition = -1;
    private boolean aBx = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.gift.container.a.1
        private void a(g gVar, C0132a c0132a) {
            com.baidu.live.gift.c ey;
            if (gVar.wg() && !com.baidu.live.gift.b.b.yS().ec(gVar.vU()) && (ey = com.baidu.live.gift.b.b.yS().ey(gVar.vU())) != null) {
                com.baidu.live.gift.b.a.a(ey.ays, true);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view.getTag(a.g.TAG_GIFT_ITEM) instanceof g) && (view.getTag(a.g.TAG_GIFT_VIEW_HOLDER) instanceof C0132a)) {
                C0132a c0132a = (C0132a) view.getTag(a.g.TAG_GIFT_VIEW_HOLDER);
                g gVar = (g) view.getTag(a.g.TAG_GIFT_ITEM);
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(a.this.mContext.getPageActivity(), a.this.mContext.getString(a.i.sdk_neterror));
                } else {
                    a(gVar, c0132a);
                }
            }
        }
    };
    private List<g> aBw = Collections.synchronizedList(new ArrayList());

    public a(TbPageContext tbPageContext, int i) {
        this.mContext = tbPageContext;
        this.mType = i;
    }

    public void setGiftItems(List<g> list) {
        if (this.aBw == null) {
            this.aBw = Collections.synchronizedList(new ArrayList());
        } else {
            this.aBw.clear();
        }
        if (list != null) {
            this.aBw.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void v(String str, int i) {
        if (this.aBw != null) {
            for (g gVar : this.aBw) {
                if (gVar.ayT != null && gVar.vU().equals(str)) {
                    gVar.ayT.aza = i;
                }
            }
            notifyDataSetChanged();
        }
    }

    public void bI(int i) {
        this.aBv = i;
    }

    public void bJ(int i) {
        this.mSelectedPosition = i;
    }

    public int getSelectedPosition() {
        return this.mSelectedPosition;
    }

    public void ba(boolean z) {
        this.aBx = z;
    }

    public void bK(int i) {
        this.aBz = i;
        float dimensionPixelOffset = (i * 1.0f) / this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds192);
        this.aBA = (int) (this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds100) * dimensionPixelOffset);
        this.aBB = (int) (dimensionPixelOffset * this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds18));
    }

    public void aO(boolean z) {
        this.aBC = z;
    }

    public void a(AbsListView absListView, boolean z) {
        int firstVisiblePosition;
        View childAt;
        this.aBC = z;
        int count = getCount();
        if (count != 0) {
            for (int i = 0; i < count; i++) {
                if (getItem(i).wt() && i >= (firstVisiblePosition = absListView.getFirstVisiblePosition()) && i <= absListView.getLastVisiblePosition() && (childAt = absListView.getChildAt(i - firstVisiblePosition)) != null) {
                    getView(i, childAt, absListView);
                }
            }
        }
    }

    public void a(AbsListView absListView, String str, String str2) {
        int count;
        int firstVisiblePosition;
        View childAt;
        com.baidu.live.gift.c ey;
        if (!TextUtils.isEmpty(str) && (count = getCount()) != 0) {
            int i = 0;
            while (true) {
                if (i >= count) {
                    i = -1;
                    break;
                }
                g item = getItem(i);
                if (item != null && !TextUtils.isEmpty(item.vU()) && (ey = com.baidu.live.gift.b.b.yS().ey(item.vU())) != null && !TextUtils.isEmpty(ey.getDynamicGiftId()) && ey.getDynamicGiftId().equals(str) && u.ej(item.vU()).equals(str2)) {
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
        if (this.aBw == null) {
            return 0;
        }
        return this.aBw.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: bL */
    public g getItem(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.aBw.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0132a c0132a;
        g.a aVar;
        String formatGiftNumForTDouDisPlay;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.ala_gift_list_item, viewGroup, false);
            view.setBackgroundResource(a.f.sdk_transparent_bg);
            C0132a c0132a2 = new C0132a();
            c0132a2.aBE = (TbImageView) view.findViewById(a.g.gift_thumbnail);
            c0132a2.aBE.setDefaultBgResource(a.f.icon_live_gift_default);
            c0132a2.aBE.setDefaultErrorResource(a.f.icon_live_gift_default);
            c0132a2.aBE.setAutoChangeStyle(false);
            c0132a2.aBH = (TextView) view.findViewById(a.g.gift_name);
            c0132a2.aBI = (TextView) view.findViewById(a.g.gift_price);
            c0132a2.aBF = (RelativeLayout) view.findViewById(a.g.llCarom);
            c0132a2.aBJ = (TextView) view.findViewById(a.g.gift_carom_txt);
            c0132a2.aBL = view.findViewById(a.g.in_progress);
            c0132a2.aBM = (LottieAnimationView) view.findViewById(a.g.lottie_downloading);
            c0132a2.aBM.loop(true);
            c0132a2.aBM.setAnimation("live_gift_panel_downloading.json");
            c0132a2.aBN = view.findViewById(a.g.selected_bg);
            c0132a2.aBK = (TextView) view.findViewById(a.g.tv_privilege);
            c0132a2.aBG = (LinearLayout) view.findViewById(a.g.ll_privilege);
            c0132a2.aBO = (FrameLayout) view.findViewById(a.g.layout_pkg_count);
            c0132a2.aBP = (ImageView) view.findViewById(a.g.iv_pkg_count);
            c0132a2.aBQ = (TextView) view.findViewById(a.g.tv_pkg_count);
            c0132a2.aBR = (FrameLayout) view.findViewById(a.g.layout_script);
            c0132a2.aBS = (TextView) view.findViewById(a.g.tv_script);
            view.setTag(c0132a2);
            if (this.aBz <= 0 || this.aBA <= 0) {
                c0132a = c0132a2;
            } else {
                view.getLayoutParams().height = this.aBz;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c0132a2.aBE.getLayoutParams();
                layoutParams.width = this.aBA;
                layoutParams.height = this.aBA;
                layoutParams.topMargin = this.aBB;
                c0132a = c0132a2;
            }
        } else {
            c0132a = (C0132a) view.getTag();
        }
        c0132a.xI();
        if (i == this.mSelectedPosition) {
            c0132a.xH();
        }
        g item = getItem(i);
        if (this.mType != 1) {
            aVar = null;
        } else {
            aVar = item.ayT;
        }
        if (item != null) {
            if (item.isRed()) {
                c0132a.aBE.setImageResource(a.f.live_gift_red_enter);
                c0132a.aBH.setText(this.mContext.getPageActivity().getString(a.i.sdk_red_pkt_send));
                c0132a.aBI.setText("");
            } else {
                c0132a.aBE.startLoad(item.vX(), 10, false);
                c0132a.aBH.setText(item.vV());
                if (this.mType == 0) {
                    double d = JavaTypesHelper.toDouble(String.valueOf(item.getPrice()), 0.0d);
                    if (d >= 100.0d && ((this.aBx || com.baidu.live.v.a.En().aQu.asV) && !item.wf())) {
                        formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
                    } else {
                        formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(item.getPrice()));
                    }
                    c0132a.aBI.setText(formatGiftNumForTDouDisPlay);
                    if (item.wf()) {
                        c0132a.aBI.setText(this.mContext.getPageActivity().getString(a.i.ala_gift_price_flower_label, new Object[]{formatGiftNumForTDouDisPlay}));
                    } else {
                        c0132a.aBI.setText(this.mContext.getPageActivity().getString(a.i.ala_gift_price_tdou_label, new Object[]{formatGiftNumForTDouDisPlay}));
                    }
                } else if (this.mType == 1) {
                    if (aVar != null) {
                        c0132a.aBI.setText(W(aVar.azb) + " 失效");
                    } else {
                        c0132a.aBI.setText("");
                    }
                }
                c0132a.aBF.setClickable(false);
                c0132a.aBF.setVisibility(8);
                c0132a.aBJ.setBackgroundColor(0);
                c0132a.aBG.setVisibility(8);
                c0132a.aBE.setAlpha(1.0f);
                c0132a.aBI.setAlpha(1.0f);
                c0132a.aBH.setAlpha(1.0f);
                c0132a.aBO.setVisibility(8);
                c0132a.aBL.setVisibility(4);
                c0132a.aBM.cancelAnimation();
                if (this.mType == 0) {
                    if (item.wr()) {
                        c0132a.aBE.setAlpha(0.5f);
                        c0132a.aBI.setAlpha(0.5f);
                        c0132a.aBH.setAlpha(0.5f);
                        c0132a.aBF.setVisibility(8);
                        c0132a.aBG.setVisibility(0);
                        if (!TextUtils.isEmpty(item.ws())) {
                            c0132a.aBK.setText(item.ws());
                        } else {
                            c0132a.aBK.setText("");
                        }
                        String ws = item.ws();
                        if (item.wi()) {
                            if (item.wk()) {
                                c0132a.aBG.setBackgroundResource(a.f.live_gift_item_script_lock_activity);
                            } else if (item.wl()) {
                                c0132a.aBG.setBackgroundResource(a.f.live_gift_item_script_lock_power);
                            } else {
                                c0132a.aBG.setBackgroundResource(a.f.live_gift_item_script_lock_level);
                            }
                        } else if (ws.equals("活动")) {
                            c0132a.aBG.setBackgroundResource(a.f.live_gift_item_script_lock_activity);
                        } else {
                            c0132a.aBG.setBackgroundResource(a.f.live_gift_item_script_lock_level);
                        }
                    } else if (item.wg()) {
                        c0132a.aBF.setVisibility(0);
                        if (!com.baidu.live.gift.b.b.yS().ec(item.vU())) {
                            c0132a.aBJ.setText(" ");
                            c0132a.aBJ.setBackgroundResource(a.f.live_gift_panel_item_script_download);
                            c0132a.aBF.setTag(a.g.TAG_GIFT_ITEM, item);
                            c0132a.aBF.setTag(a.g.TAG_GIFT_VIEW_HOLDER, c0132a);
                            c0132a.aBF.setClickable(true);
                            c0132a.aBF.setOnClickListener(this.mOnClickListener);
                            if (com.baidu.live.gift.b.a.ab(item.vU(), u.ej(item.vU()))) {
                                c0132a.aBE.setAlpha(0.5f);
                                c0132a.aBI.setAlpha(0.5f);
                                c0132a.aBH.setAlpha(0.5f);
                                c0132a.aBL.setVisibility(0);
                                c0132a.aBM.playAnimation();
                                c0132a.aBF.setVisibility(4);
                            } else {
                                c0132a.aBL.setVisibility(4);
                                c0132a.aBM.cancelAnimation();
                                c0132a.aBF.setVisibility(0);
                            }
                        } else {
                            a(c0132a, item);
                        }
                    } else {
                        a(c0132a, item);
                    }
                } else if (this.mType == 1 && aVar != null) {
                    if (aVar.aza > 999) {
                        c0132a.aBP.setImageResource(a.f.live_icon_gift_panel_package_count_large);
                        c0132a.aBQ.setText("999+");
                    } else {
                        c0132a.aBP.setImageResource(a.f.live_icon_gift_panel_package_count_small);
                        c0132a.aBQ.setText(String.valueOf(aVar.aza));
                    }
                    c0132a.aBO.setVisibility(0);
                }
            }
        }
        return view;
    }

    private void a(C0132a c0132a, g gVar) {
        c0132a.aBL.setVisibility(4);
        c0132a.aBM.cancelAnimation();
        if (gVar.wi()) {
            c0132a.aBF.setVisibility(0);
            String ws = gVar.ws();
            c0132a.aBJ.setText(ws);
            if (gVar.wk()) {
                if (TextUtils.isEmpty(ws)) {
                    c0132a.aBJ.setText(a.i.ala_gift_type_activity);
                }
                c0132a.aBJ.setBackgroundResource(a.f.live_gift_panel_item_script_activity);
            } else if (gVar.wj()) {
                if (TextUtils.isEmpty(ws)) {
                    c0132a.aBJ.setText(a.i.ala_gift_type_discount);
                }
                c0132a.aBJ.setBackgroundResource(a.f.live_gift_panel_item_script_discount);
            } else if (gVar.wl()) {
                if (TextUtils.isEmpty(ws)) {
                    c0132a.aBJ.setText(a.i.ala_gift_type_privilege);
                }
                c0132a.aBJ.setBackgroundResource(a.f.live_gift_panel_item_script_power);
            } else if (gVar.wn()) {
                if (TextUtils.isEmpty(ws)) {
                    c0132a.aBJ.setText(a.i.ala_gift_broadcast_txt);
                }
                c0132a.aBJ.setBackgroundResource(a.f.live_gift_panel_item_script_broadcast);
            } else if (gVar.wm()) {
                if (TextUtils.isEmpty(ws)) {
                    c0132a.aBJ.setText(a.i.ala_gift_draw_txt);
                }
                c0132a.aBJ.setBackgroundResource(a.f.live_gift_panel_item_script_graffiti);
            } else if (gVar.wo()) {
                if (TextUtils.isEmpty(ws)) {
                    ws = this.mContext.getPageActivity().getString(a.i.ala_gift_type_new);
                    c0132a.aBJ.setText(a.i.ala_gift_type_new);
                }
                if (ws != null && ws.length() == 1) {
                    c0132a.aBJ.setBackgroundResource(a.f.live_gift_panel_item_script_new);
                } else {
                    c0132a.aBJ.setBackgroundResource(a.f.live_gift_panel_item_script_new_wide);
                }
            } else {
                c0132a.aBF.setVisibility(8);
            }
        } else if (gVar.wu()) {
            c0132a.aBF.setVisibility(0);
            String ws2 = gVar.ws();
            if (TextUtils.isEmpty(ws2)) {
                c0132a.aBJ.setText(a.i.ala_gift_privilege_level);
            } else {
                c0132a.aBJ.setText(ws2);
            }
            c0132a.aBJ.setBackgroundResource(a.f.live_gift_panel_item_script_level);
        } else if (gVar.wt() && !this.aBC) {
            c0132a.aBE.setAlpha(0.5f);
            c0132a.aBI.setAlpha(0.5f);
            c0132a.aBH.setAlpha(0.5f);
            c0132a.aBF.setVisibility(8);
            c0132a.aBG.setBackgroundResource(a.f.live_gift_item_script_lock_level);
            c0132a.aBG.setVisibility(0);
            c0132a.aBK.setText(a.i.ala_gift_privilege_throne);
        } else if (gVar.wc()) {
            c0132a.aBF.setVisibility(0);
            String ws3 = gVar.ws();
            if (TextUtils.isEmpty(ws3)) {
                c0132a.aBJ.setText(a.i.ala_gift_draw_txt);
            } else {
                c0132a.aBJ.setText(ws3);
            }
            c0132a.aBJ.setBackgroundResource(a.f.live_gift_panel_item_script_graffiti);
        } else if (gVar.wd()) {
            c0132a.aBF.setVisibility(0);
            String ws4 = gVar.ws();
            if (TextUtils.isEmpty(ws4)) {
                c0132a.aBJ.setText(a.i.ala_gift_combo_txt);
            } else {
                c0132a.aBJ.setText(ws4);
            }
            c0132a.aBJ.setBackgroundResource(a.f.live_gift_panel_item_script_graffiti);
        } else if (gVar.wp()) {
            String ws5 = gVar.ws();
            if (TextUtils.isEmpty(ws5)) {
                c0132a.aBJ.setText(a.i.ala_gift_broadcast_txt);
            } else {
                c0132a.aBJ.setText(ws5);
            }
            c0132a.aBJ.setBackgroundResource(a.f.live_gift_panel_item_script_broadcast);
        } else if (!TextUtils.isEmpty(gVar.ws())) {
            String ws6 = gVar.ws();
            c0132a.aBF.setVisibility(0);
            c0132a.aBJ.setText(ws6);
            if ("活动".equals(ws6)) {
                c0132a.aBJ.setBackgroundResource(a.f.live_gift_panel_item_script_activity);
            } else if ("折扣".equals(ws6)) {
                c0132a.aBJ.setBackgroundResource(a.f.live_gift_panel_item_script_discount);
            } else if (ws6 != null && ws6.length() == 1) {
                c0132a.aBJ.setBackgroundResource(a.f.live_gift_panel_item_script_new);
            } else {
                c0132a.aBJ.setBackgroundResource(a.f.live_gift_panel_item_script_new_wide);
            }
        } else {
            c0132a.aBF.setVisibility(8);
        }
    }

    /* renamed from: com.baidu.live.gift.container.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0132a {
        public TbImageView aBE;
        public RelativeLayout aBF;
        public LinearLayout aBG;
        public TextView aBH;
        public TextView aBI;
        public TextView aBJ;
        public TextView aBK;
        public View aBL;
        public LottieAnimationView aBM;
        public View aBN;
        public FrameLayout aBO;
        public ImageView aBP;
        public TextView aBQ;
        public FrameLayout aBR;
        public TextView aBS;
        public AnimatorSet aBT;

        public void recycle() {
            if (this.aBM != null) {
                this.aBM.cancelAnimation();
            }
            xJ();
        }

        public void xH() {
            if (this.aBN != null) {
                this.aBN.setVisibility(0);
            }
            N(this.aBE);
        }

        public void xI() {
            if (this.aBN != null) {
                this.aBN.setVisibility(8);
            }
            xJ();
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
            this.aBT = new AnimatorSet();
            this.aBT.play(ofFloat).with(ofFloat2);
            this.aBT.start();
        }

        public void xJ() {
            if (this.aBT != null) {
                this.aBT.cancel();
                this.aBT = null;
            }
        }
    }

    private static String W(long j) {
        if (aBy == null) {
            aBy = new SimpleDateFormat("MM.dd");
        }
        return aBy.format(Long.valueOf(1000 * j));
    }
}

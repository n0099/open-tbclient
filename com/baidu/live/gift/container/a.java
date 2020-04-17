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
    private static SimpleDateFormat aBs;
    private int aBt;
    private int aBu;
    private int aBv;
    private boolean aBw;
    private TbPageContext mContext;
    private int mType;
    private int aBp = -1;
    private int mSelectedPosition = -1;
    private boolean aBr = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.gift.container.a.1
        private void a(g gVar, C0111a c0111a) {
            com.baidu.live.gift.c ey;
            if (gVar.wh() && !com.baidu.live.gift.b.b.yT().ec(gVar.vV()) && (ey = com.baidu.live.gift.b.b.yT().ey(gVar.vV())) != null) {
                com.baidu.live.gift.b.a.a(ey.aym, true);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view.getTag(a.g.TAG_GIFT_ITEM) instanceof g) && (view.getTag(a.g.TAG_GIFT_VIEW_HOLDER) instanceof C0111a)) {
                C0111a c0111a = (C0111a) view.getTag(a.g.TAG_GIFT_VIEW_HOLDER);
                g gVar = (g) view.getTag(a.g.TAG_GIFT_ITEM);
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(a.this.mContext.getPageActivity(), a.this.mContext.getString(a.i.sdk_neterror));
                } else {
                    a(gVar, c0111a);
                }
            }
        }
    };
    private List<g> aBq = Collections.synchronizedList(new ArrayList());

    public a(TbPageContext tbPageContext, int i) {
        this.mContext = tbPageContext;
        this.mType = i;
    }

    public void setGiftItems(List<g> list) {
        if (this.aBq == null) {
            this.aBq = Collections.synchronizedList(new ArrayList());
        } else {
            this.aBq.clear();
        }
        if (list != null) {
            this.aBq.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void v(String str, int i) {
        if (this.aBq != null) {
            for (g gVar : this.aBq) {
                if (gVar.ayN != null && gVar.vV().equals(str)) {
                    gVar.ayN.ayU = i;
                }
            }
            notifyDataSetChanged();
        }
    }

    public void bI(int i) {
        this.aBp = i;
    }

    public void bJ(int i) {
        this.mSelectedPosition = i;
    }

    public int getSelectedPosition() {
        return this.mSelectedPosition;
    }

    public void ba(boolean z) {
        this.aBr = z;
    }

    public void bK(int i) {
        this.aBt = i;
        float dimensionPixelOffset = (i * 1.0f) / this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds192);
        this.aBu = (int) (this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds100) * dimensionPixelOffset);
        this.aBv = (int) (dimensionPixelOffset * this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds18));
    }

    public void aO(boolean z) {
        this.aBw = z;
    }

    public void a(AbsListView absListView, boolean z) {
        int firstVisiblePosition;
        View childAt;
        this.aBw = z;
        int count = getCount();
        if (count != 0) {
            for (int i = 0; i < count; i++) {
                if (getItem(i).wu() && i >= (firstVisiblePosition = absListView.getFirstVisiblePosition()) && i <= absListView.getLastVisiblePosition() && (childAt = absListView.getChildAt(i - firstVisiblePosition)) != null) {
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
                if (item != null && !TextUtils.isEmpty(item.vV()) && (ey = com.baidu.live.gift.b.b.yT().ey(item.vV())) != null && !TextUtils.isEmpty(ey.getDynamicGiftId()) && ey.getDynamicGiftId().equals(str) && u.ej(item.vV()).equals(str2)) {
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
        if (this.aBq == null) {
            return 0;
        }
        return this.aBq.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: bL */
    public g getItem(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.aBq.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0111a c0111a;
        g.a aVar;
        String formatGiftNumForTDouDisPlay;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.ala_gift_list_item, viewGroup, false);
            view.setBackgroundResource(a.f.sdk_transparent_bg);
            C0111a c0111a2 = new C0111a();
            c0111a2.aBy = (TbImageView) view.findViewById(a.g.gift_thumbnail);
            c0111a2.aBy.setDefaultBgResource(a.f.icon_live_gift_default);
            c0111a2.aBy.setDefaultErrorResource(a.f.icon_live_gift_default);
            c0111a2.aBy.setAutoChangeStyle(false);
            c0111a2.aBB = (TextView) view.findViewById(a.g.gift_name);
            c0111a2.aBC = (TextView) view.findViewById(a.g.gift_price);
            c0111a2.aBz = (RelativeLayout) view.findViewById(a.g.llCarom);
            c0111a2.aBD = (TextView) view.findViewById(a.g.gift_carom_txt);
            c0111a2.aBF = view.findViewById(a.g.in_progress);
            c0111a2.aBG = (LottieAnimationView) view.findViewById(a.g.lottie_downloading);
            c0111a2.aBG.loop(true);
            c0111a2.aBG.setAnimation("live_gift_panel_downloading.json");
            c0111a2.aBH = view.findViewById(a.g.selected_bg);
            c0111a2.aBE = (TextView) view.findViewById(a.g.tv_privilege);
            c0111a2.aBA = (LinearLayout) view.findViewById(a.g.ll_privilege);
            c0111a2.aBI = (FrameLayout) view.findViewById(a.g.layout_pkg_count);
            c0111a2.aBJ = (ImageView) view.findViewById(a.g.iv_pkg_count);
            c0111a2.aBK = (TextView) view.findViewById(a.g.tv_pkg_count);
            c0111a2.aBL = (FrameLayout) view.findViewById(a.g.layout_script);
            c0111a2.aBM = (TextView) view.findViewById(a.g.tv_script);
            view.setTag(c0111a2);
            if (this.aBt <= 0 || this.aBu <= 0) {
                c0111a = c0111a2;
            } else {
                view.getLayoutParams().height = this.aBt;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c0111a2.aBy.getLayoutParams();
                layoutParams.width = this.aBu;
                layoutParams.height = this.aBu;
                layoutParams.topMargin = this.aBv;
                c0111a = c0111a2;
            }
        } else {
            c0111a = (C0111a) view.getTag();
        }
        c0111a.xJ();
        if (i == this.mSelectedPosition) {
            c0111a.xI();
        }
        g item = getItem(i);
        if (this.mType != 1) {
            aVar = null;
        } else {
            aVar = item.ayN;
        }
        if (item != null) {
            if (item.isRed()) {
                c0111a.aBy.setImageResource(a.f.live_gift_red_enter);
                c0111a.aBB.setText(this.mContext.getPageActivity().getString(a.i.sdk_red_pkt_send));
                c0111a.aBC.setText("");
            } else {
                c0111a.aBy.startLoad(item.vY(), 10, false);
                c0111a.aBB.setText(item.vW());
                if (this.mType == 0) {
                    double d = JavaTypesHelper.toDouble(String.valueOf(item.getPrice()), 0.0d);
                    if (d >= 100.0d && ((this.aBr || com.baidu.live.v.a.Eo().aQp.asP) && !item.wg())) {
                        formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
                    } else {
                        formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(item.getPrice()));
                    }
                    c0111a.aBC.setText(formatGiftNumForTDouDisPlay);
                    if (item.wg()) {
                        c0111a.aBC.setText(this.mContext.getPageActivity().getString(a.i.ala_gift_price_flower_label, new Object[]{formatGiftNumForTDouDisPlay}));
                    } else {
                        c0111a.aBC.setText(this.mContext.getPageActivity().getString(a.i.ala_gift_price_tdou_label, new Object[]{formatGiftNumForTDouDisPlay}));
                    }
                } else if (this.mType == 1) {
                    if (aVar != null) {
                        c0111a.aBC.setText(W(aVar.ayV) + " 失效");
                    } else {
                        c0111a.aBC.setText("");
                    }
                }
                c0111a.aBz.setClickable(false);
                c0111a.aBz.setVisibility(8);
                c0111a.aBD.setBackgroundColor(0);
                c0111a.aBA.setVisibility(8);
                c0111a.aBy.setAlpha(1.0f);
                c0111a.aBC.setAlpha(1.0f);
                c0111a.aBB.setAlpha(1.0f);
                c0111a.aBI.setVisibility(8);
                c0111a.aBF.setVisibility(4);
                c0111a.aBG.cancelAnimation();
                if (this.mType == 0) {
                    if (item.ws()) {
                        c0111a.aBy.setAlpha(0.5f);
                        c0111a.aBC.setAlpha(0.5f);
                        c0111a.aBB.setAlpha(0.5f);
                        c0111a.aBz.setVisibility(8);
                        c0111a.aBA.setVisibility(0);
                        if (!TextUtils.isEmpty(item.wt())) {
                            c0111a.aBE.setText(item.wt());
                        } else {
                            c0111a.aBE.setText("");
                        }
                        String wt = item.wt();
                        if (item.wj()) {
                            if (item.wl()) {
                                c0111a.aBA.setBackgroundResource(a.f.live_gift_item_script_lock_activity);
                            } else if (item.wm()) {
                                c0111a.aBA.setBackgroundResource(a.f.live_gift_item_script_lock_power);
                            } else {
                                c0111a.aBA.setBackgroundResource(a.f.live_gift_item_script_lock_level);
                            }
                        } else if (wt.equals("活动")) {
                            c0111a.aBA.setBackgroundResource(a.f.live_gift_item_script_lock_activity);
                        } else {
                            c0111a.aBA.setBackgroundResource(a.f.live_gift_item_script_lock_level);
                        }
                    } else if (item.wh()) {
                        c0111a.aBz.setVisibility(0);
                        if (!com.baidu.live.gift.b.b.yT().ec(item.vV())) {
                            c0111a.aBD.setText(" ");
                            c0111a.aBD.setBackgroundResource(a.f.live_gift_panel_item_script_download);
                            c0111a.aBz.setTag(a.g.TAG_GIFT_ITEM, item);
                            c0111a.aBz.setTag(a.g.TAG_GIFT_VIEW_HOLDER, c0111a);
                            c0111a.aBz.setClickable(true);
                            c0111a.aBz.setOnClickListener(this.mOnClickListener);
                            if (com.baidu.live.gift.b.a.ab(item.vV(), u.ej(item.vV()))) {
                                c0111a.aBy.setAlpha(0.5f);
                                c0111a.aBC.setAlpha(0.5f);
                                c0111a.aBB.setAlpha(0.5f);
                                c0111a.aBF.setVisibility(0);
                                c0111a.aBG.playAnimation();
                                c0111a.aBz.setVisibility(4);
                            } else {
                                c0111a.aBF.setVisibility(4);
                                c0111a.aBG.cancelAnimation();
                                c0111a.aBz.setVisibility(0);
                            }
                        } else {
                            a(c0111a, item);
                        }
                    } else {
                        a(c0111a, item);
                    }
                } else if (this.mType == 1 && aVar != null) {
                    if (aVar.ayU > 999) {
                        c0111a.aBJ.setImageResource(a.f.live_icon_gift_panel_package_count_large);
                        c0111a.aBK.setText("999+");
                    } else {
                        c0111a.aBJ.setImageResource(a.f.live_icon_gift_panel_package_count_small);
                        c0111a.aBK.setText(String.valueOf(aVar.ayU));
                    }
                    c0111a.aBI.setVisibility(0);
                }
            }
        }
        return view;
    }

    private void a(C0111a c0111a, g gVar) {
        c0111a.aBF.setVisibility(4);
        c0111a.aBG.cancelAnimation();
        if (gVar.wj()) {
            c0111a.aBz.setVisibility(0);
            String wt = gVar.wt();
            c0111a.aBD.setText(wt);
            if (gVar.wl()) {
                if (TextUtils.isEmpty(wt)) {
                    c0111a.aBD.setText(a.i.ala_gift_type_activity);
                }
                c0111a.aBD.setBackgroundResource(a.f.live_gift_panel_item_script_activity);
            } else if (gVar.wk()) {
                if (TextUtils.isEmpty(wt)) {
                    c0111a.aBD.setText(a.i.ala_gift_type_discount);
                }
                c0111a.aBD.setBackgroundResource(a.f.live_gift_panel_item_script_discount);
            } else if (gVar.wm()) {
                if (TextUtils.isEmpty(wt)) {
                    c0111a.aBD.setText(a.i.ala_gift_type_privilege);
                }
                c0111a.aBD.setBackgroundResource(a.f.live_gift_panel_item_script_power);
            } else if (gVar.wo()) {
                if (TextUtils.isEmpty(wt)) {
                    c0111a.aBD.setText(a.i.ala_gift_broadcast_txt);
                }
                c0111a.aBD.setBackgroundResource(a.f.live_gift_panel_item_script_broadcast);
            } else if (gVar.wn()) {
                if (TextUtils.isEmpty(wt)) {
                    c0111a.aBD.setText(a.i.ala_gift_draw_txt);
                }
                c0111a.aBD.setBackgroundResource(a.f.live_gift_panel_item_script_graffiti);
            } else if (gVar.wp()) {
                if (TextUtils.isEmpty(wt)) {
                    wt = this.mContext.getPageActivity().getString(a.i.ala_gift_type_new);
                    c0111a.aBD.setText(a.i.ala_gift_type_new);
                }
                if (wt != null && wt.length() == 1) {
                    c0111a.aBD.setBackgroundResource(a.f.live_gift_panel_item_script_new);
                } else {
                    c0111a.aBD.setBackgroundResource(a.f.live_gift_panel_item_script_new_wide);
                }
            } else {
                c0111a.aBz.setVisibility(8);
            }
        } else if (gVar.wv()) {
            c0111a.aBz.setVisibility(0);
            String wt2 = gVar.wt();
            if (TextUtils.isEmpty(wt2)) {
                c0111a.aBD.setText(a.i.ala_gift_privilege_level);
            } else {
                c0111a.aBD.setText(wt2);
            }
            c0111a.aBD.setBackgroundResource(a.f.live_gift_panel_item_script_level);
        } else if (gVar.wu() && !this.aBw) {
            c0111a.aBy.setAlpha(0.5f);
            c0111a.aBC.setAlpha(0.5f);
            c0111a.aBB.setAlpha(0.5f);
            c0111a.aBz.setVisibility(8);
            c0111a.aBA.setBackgroundResource(a.f.live_gift_item_script_lock_level);
            c0111a.aBA.setVisibility(0);
            c0111a.aBE.setText(a.i.ala_gift_privilege_throne);
        } else if (gVar.wd()) {
            c0111a.aBz.setVisibility(0);
            String wt3 = gVar.wt();
            if (TextUtils.isEmpty(wt3)) {
                c0111a.aBD.setText(a.i.ala_gift_draw_txt);
            } else {
                c0111a.aBD.setText(wt3);
            }
            c0111a.aBD.setBackgroundResource(a.f.live_gift_panel_item_script_graffiti);
        } else if (gVar.we()) {
            c0111a.aBz.setVisibility(0);
            String wt4 = gVar.wt();
            if (TextUtils.isEmpty(wt4)) {
                c0111a.aBD.setText(a.i.ala_gift_combo_txt);
            } else {
                c0111a.aBD.setText(wt4);
            }
            c0111a.aBD.setBackgroundResource(a.f.live_gift_panel_item_script_graffiti);
        } else if (gVar.wq()) {
            String wt5 = gVar.wt();
            if (TextUtils.isEmpty(wt5)) {
                c0111a.aBD.setText(a.i.ala_gift_broadcast_txt);
            } else {
                c0111a.aBD.setText(wt5);
            }
            c0111a.aBD.setBackgroundResource(a.f.live_gift_panel_item_script_broadcast);
        } else if (!TextUtils.isEmpty(gVar.wt())) {
            String wt6 = gVar.wt();
            c0111a.aBz.setVisibility(0);
            c0111a.aBD.setText(wt6);
            if ("活动".equals(wt6)) {
                c0111a.aBD.setBackgroundResource(a.f.live_gift_panel_item_script_activity);
            } else if ("折扣".equals(wt6)) {
                c0111a.aBD.setBackgroundResource(a.f.live_gift_panel_item_script_discount);
            } else if (wt6 != null && wt6.length() == 1) {
                c0111a.aBD.setBackgroundResource(a.f.live_gift_panel_item_script_new);
            } else {
                c0111a.aBD.setBackgroundResource(a.f.live_gift_panel_item_script_new_wide);
            }
        } else {
            c0111a.aBz.setVisibility(8);
        }
    }

    /* renamed from: com.baidu.live.gift.container.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0111a {
        public LinearLayout aBA;
        public TextView aBB;
        public TextView aBC;
        public TextView aBD;
        public TextView aBE;
        public View aBF;
        public LottieAnimationView aBG;
        public View aBH;
        public FrameLayout aBI;
        public ImageView aBJ;
        public TextView aBK;
        public FrameLayout aBL;
        public TextView aBM;
        public AnimatorSet aBN;
        public TbImageView aBy;
        public RelativeLayout aBz;

        public void recycle() {
            if (this.aBG != null) {
                this.aBG.cancelAnimation();
            }
            xK();
        }

        public void xI() {
            if (this.aBH != null) {
                this.aBH.setVisibility(0);
            }
            N(this.aBy);
        }

        public void xJ() {
            if (this.aBH != null) {
                this.aBH.setVisibility(8);
            }
            xK();
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
            this.aBN = new AnimatorSet();
            this.aBN.play(ofFloat).with(ofFloat2);
            this.aBN.start();
        }

        public void xK() {
            if (this.aBN != null) {
                this.aBN.cancel();
                this.aBN = null;
            }
        }
    }

    private static String W(long j) {
        if (aBs == null) {
            aBs = new SimpleDateFormat("MM.dd");
        }
        return aBs.format(Long.valueOf(1000 * j));
    }
}

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
import com.baidu.live.gift.w;
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
    private static SimpleDateFormat aVp;
    private int aVq;
    private int aVr;
    private int aVs;
    private int aVt;
    private boolean aVu;
    private TbPageContext mContext;
    private int mType;
    private int aVm = -1;
    private int mSelectedPosition = -1;
    private boolean aVo = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.gift.container.a.1
        private void a(g gVar, C0181a c0181a) {
            com.baidu.live.gift.c hf;
            if (gVar.Fo() && !com.baidu.live.gift.b.b.Ik().gH(gVar.Fd()) && (hf = com.baidu.live.gift.b.b.Ik().hf(gVar.Fd())) != null) {
                com.baidu.live.gift.b.a.Ih().a(hf.aRQ, true);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view.getTag(a.g.TAG_GIFT_ITEM) instanceof g) && (view.getTag(a.g.TAG_GIFT_VIEW_HOLDER) instanceof C0181a)) {
                C0181a c0181a = (C0181a) view.getTag(a.g.TAG_GIFT_VIEW_HOLDER);
                g gVar = (g) view.getTag(a.g.TAG_GIFT_ITEM);
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(a.this.mContext.getPageActivity(), a.this.mContext.getString(a.i.sdk_neterror));
                } else {
                    a(gVar, c0181a);
                }
            }
        }
    };
    private List<g> aVn = Collections.synchronizedList(new ArrayList());

    public a(TbPageContext tbPageContext, int i) {
        this.mContext = tbPageContext;
        this.mType = i;
    }

    public void setGiftItems(List<g> list) {
        if (this.aVn == null) {
            this.aVn = Collections.synchronizedList(new ArrayList());
        } else {
            this.aVn.clear();
        }
        if (list != null) {
            this.aVn.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void A(String str, int i) {
        if (this.aVn != null) {
            for (g gVar : this.aVn) {
                if (gVar.aSt != null && gVar.Fd().equals(str)) {
                    gVar.aSt.aSG = i;
                }
            }
            notifyDataSetChanged();
        }
    }

    public void eb(int i) {
        this.aVm = i;
    }

    public void ec(int i) {
        this.mSelectedPosition = i;
    }

    public int getSelectedPosition() {
        return this.mSelectedPosition;
    }

    public void bs(boolean z) {
        this.aVo = z;
    }

    public void ed(int i) {
        this.aVq = i;
        float dimensionPixelOffset = (i * 1.0f) / this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds192);
        this.aVr = (int) (this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds100) * dimensionPixelOffset);
        this.aVs = (int) (this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds12) * dimensionPixelOffset);
        this.aVt = (int) (dimensionPixelOffset * this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds8));
    }

    public void bc(boolean z) {
        this.aVu = z;
    }

    public void a(AbsListView absListView, boolean z) {
        int firstVisiblePosition;
        View childAt;
        this.aVu = z;
        int count = getCount();
        if (count != 0) {
            for (int i = 0; i < count; i++) {
                if (getItem(i).FC() && i >= (firstVisiblePosition = absListView.getFirstVisiblePosition()) && i <= absListView.getLastVisiblePosition() && (childAt = absListView.getChildAt(i - firstVisiblePosition)) != null) {
                    getView(i, childAt, absListView);
                }
            }
        }
    }

    public void a(AbsListView absListView, String str, String str2) {
        int count;
        int firstVisiblePosition;
        View childAt;
        com.baidu.live.gift.c hf;
        if (!TextUtils.isEmpty(str) && (count = getCount()) != 0) {
            int i = 0;
            while (true) {
                if (i >= count) {
                    i = -1;
                    break;
                }
                g item = getItem(i);
                if (item != null && !TextUtils.isEmpty(item.Fd()) && (hf = com.baidu.live.gift.b.b.Ik().hf(item.Fd())) != null && !TextUtils.isEmpty(hf.getDynamicGiftId()) && hf.getDynamicGiftId().equals(str) && w.gR(item.Fd()).equals(str2)) {
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
        if (this.aVn == null) {
            return 0;
        }
        return this.aVn.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ee */
    public g getItem(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.aVn.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0181a c0181a;
        String formatGiftNumForTDouDisPlay;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.ala_gift_list_item, viewGroup, false);
            view.setBackgroundResource(a.f.sdk_transparent_bg);
            C0181a c0181a2 = new C0181a();
            c0181a2.aVw = (TbImageView) view.findViewById(a.g.gift_thumbnail);
            c0181a2.aVw.setDefaultBgResource(a.f.icon_live_gift_default);
            c0181a2.aVw.setDefaultErrorResource(a.f.icon_live_gift_default);
            c0181a2.aVw.setAutoChangeStyle(false);
            c0181a2.aVz = view.findViewById(a.g.layout_gift_item_name);
            c0181a2.aVA = (TextView) view.findViewById(a.g.gift_name);
            c0181a2.aVB = (TextView) view.findViewById(a.g.tv_gift_item_longpress_tip);
            c0181a2.aVC = (TextView) view.findViewById(a.g.gift_price);
            c0181a2.aVx = (RelativeLayout) view.findViewById(a.g.llCarom);
            c0181a2.aVD = (TextView) view.findViewById(a.g.gift_carom_txt);
            c0181a2.aVF = view.findViewById(a.g.in_progress);
            c0181a2.aVG = (LottieAnimationView) view.findViewById(a.g.lottie_downloading);
            c0181a2.aVG.loop(true);
            c0181a2.aVG.setAnimation("live_gift_panel_downloading.json");
            c0181a2.aVH = view.findViewById(a.g.selected_bg);
            c0181a2.aVE = (TextView) view.findViewById(a.g.tv_privilege);
            c0181a2.aVy = (LinearLayout) view.findViewById(a.g.ll_privilege);
            c0181a2.aVI = (FrameLayout) view.findViewById(a.g.layout_pkg_count);
            c0181a2.aVJ = (ImageView) view.findViewById(a.g.iv_pkg_count);
            c0181a2.aVK = (TextView) view.findViewById(a.g.tv_pkg_count);
            c0181a2.aVL = (FrameLayout) view.findViewById(a.g.layout_script);
            c0181a2.aVM = (TextView) view.findViewById(a.g.tv_script);
            view.setTag(c0181a2);
            if (this.aVq <= 0 || this.aVr <= 0) {
                c0181a = c0181a2;
            } else {
                view.getLayoutParams().height = this.aVq;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c0181a2.aVw.getLayoutParams();
                layoutParams.width = this.aVr;
                layoutParams.height = this.aVr;
                layoutParams.topMargin = this.aVs;
                ((RelativeLayout.LayoutParams) c0181a2.aVz.getLayoutParams()).topMargin = this.aVt;
                c0181a = c0181a2;
            }
        } else {
            c0181a = (C0181a) view.getTag();
        }
        c0181a.GW();
        if (i == this.mSelectedPosition) {
            c0181a.GV();
        }
        g item = getItem(i);
        g.b bVar = null;
        if (this.mType == 1) {
            bVar = item.aSt;
        }
        c0181a.aVB.setTag(a.g.TAG_GIFT_ITEM, item);
        if (viewGroup.getChildCount() == i) {
            c0181a.aVB.setVisibility(4);
        }
        if (item != null) {
            if (item.isRed()) {
                c0181a.aVw.setImageResource(a.f.live_gift_red_enter);
                c0181a.aVA.setText(this.mContext.getPageActivity().getString(a.i.sdk_red_pkt_send));
                c0181a.aVC.setText("");
            } else {
                c0181a.aVw.startLoad(item.getThumbnail_url(), 10, false);
                c0181a.aVA.setText(item.Fe());
                if (this.mType == 0) {
                    double d = JavaTypesHelper.toDouble(String.valueOf(item.getPrice()), 0.0d);
                    if (d >= 100.0d && ((this.aVo || com.baidu.live.x.a.OS().blo.aLc) && !item.Fn())) {
                        formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
                    } else {
                        formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(item.getPrice()));
                    }
                    c0181a.aVC.setText(formatGiftNumForTDouDisPlay);
                    if (item.Fn()) {
                        c0181a.aVC.setText(this.mContext.getPageActivity().getString(a.i.ala_gift_price_flower_label, new Object[]{formatGiftNumForTDouDisPlay}));
                    } else {
                        c0181a.aVC.setText(this.mContext.getPageActivity().getString(a.i.ala_gift_price_tdou_label, new Object[]{formatGiftNumForTDouDisPlay}));
                    }
                } else if (this.mType == 1) {
                    if (bVar != null) {
                        c0181a.aVC.setText(ac(bVar.aSH) + " 失效");
                    } else {
                        c0181a.aVC.setText("");
                    }
                }
                c0181a.aVx.setClickable(false);
                c0181a.aVx.setVisibility(8);
                c0181a.aVD.setBackgroundColor(0);
                c0181a.aVy.setVisibility(8);
                c0181a.aVw.setAlpha(1.0f);
                c0181a.aVC.setAlpha(1.0f);
                c0181a.aVA.setAlpha(1.0f);
                c0181a.aVI.setVisibility(8);
                c0181a.aVF.setVisibility(4);
                c0181a.aVG.cancelAnimation();
                if (this.mType == 0) {
                    if (item.FA()) {
                        c0181a.aVw.setAlpha(0.5f);
                        c0181a.aVC.setAlpha(0.5f);
                        c0181a.aVA.setAlpha(0.5f);
                        c0181a.aVx.setVisibility(8);
                        c0181a.aVy.setVisibility(0);
                        if (!TextUtils.isEmpty(item.FB())) {
                            c0181a.aVE.setText(item.FB());
                        } else {
                            c0181a.aVE.setText("");
                        }
                        String FB = item.FB();
                        if (item.Fq()) {
                            if (item.Fs()) {
                                c0181a.aVy.setBackgroundResource(a.f.live_gift_item_script_lock_activity);
                            } else if (item.Ft()) {
                                c0181a.aVy.setBackgroundResource(a.f.live_gift_item_script_lock_power);
                            } else {
                                c0181a.aVy.setBackgroundResource(a.f.live_gift_item_script_lock_level);
                            }
                        } else if (FB.equals("活动")) {
                            c0181a.aVy.setBackgroundResource(a.f.live_gift_item_script_lock_activity);
                        } else {
                            c0181a.aVy.setBackgroundResource(a.f.live_gift_item_script_lock_level);
                        }
                    } else if (item.Fo()) {
                        c0181a.aVx.setVisibility(0);
                        if (!com.baidu.live.gift.b.b.Ik().gH(item.Fd())) {
                            c0181a.aVD.setText(" ");
                            c0181a.aVD.setBackgroundResource(a.f.live_gift_panel_item_script_download);
                            c0181a.aVx.setTag(a.g.TAG_GIFT_ITEM, item);
                            c0181a.aVx.setTag(a.g.TAG_GIFT_VIEW_HOLDER, c0181a);
                            c0181a.aVx.setClickable(true);
                            c0181a.aVx.setOnClickListener(this.mOnClickListener);
                            if (com.baidu.live.gift.b.a.Ih().at(item.Fd(), w.gR(item.Fd()))) {
                                c0181a.aVw.setAlpha(0.5f);
                                c0181a.aVC.setAlpha(0.5f);
                                c0181a.aVA.setAlpha(0.5f);
                                c0181a.aVF.setVisibility(0);
                                c0181a.aVG.playAnimation();
                                c0181a.aVx.setVisibility(4);
                            } else {
                                c0181a.aVF.setVisibility(4);
                                c0181a.aVG.cancelAnimation();
                                c0181a.aVx.setVisibility(0);
                            }
                        } else {
                            a(c0181a, item);
                        }
                    } else {
                        a(c0181a, item);
                    }
                } else if (this.mType == 1 && bVar != null) {
                    if (bVar.aSG > 999) {
                        c0181a.aVJ.setImageResource(a.f.live_icon_gift_panel_package_count_large);
                        c0181a.aVK.setText("999+");
                    } else {
                        c0181a.aVJ.setImageResource(a.f.live_icon_gift_panel_package_count_small);
                        c0181a.aVK.setText(String.valueOf(bVar.aSG));
                    }
                    c0181a.aVI.setVisibility(0);
                }
            }
        }
        return view;
    }

    private void a(C0181a c0181a, g gVar) {
        c0181a.aVF.setVisibility(4);
        c0181a.aVG.cancelAnimation();
        if (gVar.Fq()) {
            c0181a.aVx.setVisibility(0);
            String FB = gVar.FB();
            c0181a.aVD.setText(FB);
            if (gVar.Fs()) {
                if (TextUtils.isEmpty(FB)) {
                    c0181a.aVD.setText(a.i.ala_gift_type_activity);
                }
                c0181a.aVD.setBackgroundResource(a.f.live_gift_panel_item_script_activity);
            } else if (gVar.Fr()) {
                if (TextUtils.isEmpty(FB)) {
                    c0181a.aVD.setText(a.i.ala_gift_type_discount);
                }
                c0181a.aVD.setBackgroundResource(a.f.live_gift_panel_item_script_discount);
            } else if (gVar.Ft()) {
                if (TextUtils.isEmpty(FB)) {
                    c0181a.aVD.setText(a.i.ala_gift_type_privilege);
                }
                c0181a.aVD.setBackgroundResource(a.f.live_gift_panel_item_script_power);
            } else if (gVar.Fv()) {
                if (TextUtils.isEmpty(FB)) {
                    c0181a.aVD.setText(a.i.ala_gift_broadcast_txt);
                }
                c0181a.aVD.setBackgroundResource(a.f.live_gift_panel_item_script_broadcast);
            } else if (gVar.Fu()) {
                if (TextUtils.isEmpty(FB)) {
                    c0181a.aVD.setText(a.i.ala_gift_draw_txt);
                }
                c0181a.aVD.setBackgroundResource(a.f.live_gift_panel_item_script_graffiti);
            } else if (gVar.Fx()) {
                if (TextUtils.isEmpty(FB)) {
                    FB = this.mContext.getPageActivity().getString(a.i.ala_gift_type_new);
                    c0181a.aVD.setText(a.i.ala_gift_type_new);
                }
                if (FB != null && FB.length() == 1) {
                    c0181a.aVD.setBackgroundResource(a.f.live_gift_panel_item_script_new);
                } else {
                    c0181a.aVD.setBackgroundResource(a.f.live_gift_panel_item_script_new_wide);
                }
            } else {
                c0181a.aVx.setVisibility(8);
            }
        } else if (gVar.FD()) {
            c0181a.aVx.setVisibility(0);
            String FB2 = gVar.FB();
            if (TextUtils.isEmpty(FB2)) {
                c0181a.aVD.setText(a.i.ala_gift_privilege_level);
            } else {
                c0181a.aVD.setText(FB2);
            }
            c0181a.aVD.setBackgroundResource(a.f.live_gift_panel_item_script_level);
        } else if (gVar.FC() && !this.aVu) {
            c0181a.aVw.setAlpha(0.5f);
            c0181a.aVC.setAlpha(0.5f);
            c0181a.aVA.setAlpha(0.5f);
            c0181a.aVx.setVisibility(8);
            c0181a.aVy.setBackgroundResource(a.f.live_gift_item_script_lock_level);
            c0181a.aVy.setVisibility(0);
            c0181a.aVE.setText(a.i.ala_gift_privilege_throne);
        } else if (gVar.Fk()) {
            c0181a.aVx.setVisibility(0);
            String FB3 = gVar.FB();
            if (TextUtils.isEmpty(FB3)) {
                c0181a.aVD.setText(a.i.ala_gift_draw_txt);
            } else {
                c0181a.aVD.setText(FB3);
            }
            c0181a.aVD.setBackgroundResource(a.f.live_gift_panel_item_script_graffiti);
        } else if (gVar.Fl()) {
            c0181a.aVx.setVisibility(0);
            String FB4 = gVar.FB();
            if (TextUtils.isEmpty(FB4)) {
                c0181a.aVD.setText(a.i.ala_gift_combo_txt);
            } else {
                c0181a.aVD.setText(FB4);
            }
            c0181a.aVD.setBackgroundResource(a.f.live_gift_panel_item_script_graffiti);
        } else if (gVar.Fy()) {
            String FB5 = gVar.FB();
            if (TextUtils.isEmpty(FB5)) {
                c0181a.aVD.setText(a.i.ala_gift_broadcast_txt);
            } else {
                c0181a.aVD.setText(FB5);
            }
            c0181a.aVD.setBackgroundResource(a.f.live_gift_panel_item_script_broadcast);
        } else if (!TextUtils.isEmpty(gVar.FB())) {
            String FB6 = gVar.FB();
            c0181a.aVx.setVisibility(0);
            c0181a.aVD.setText(FB6);
            if ("活动".equals(FB6)) {
                c0181a.aVD.setBackgroundResource(a.f.live_gift_panel_item_script_activity);
            } else if ("折扣".equals(FB6)) {
                c0181a.aVD.setBackgroundResource(a.f.live_gift_panel_item_script_discount);
            } else if (FB6 != null && FB6.length() == 1) {
                c0181a.aVD.setBackgroundResource(a.f.live_gift_panel_item_script_new);
            } else {
                c0181a.aVD.setBackgroundResource(a.f.live_gift_panel_item_script_new_wide);
            }
        } else {
            c0181a.aVx.setVisibility(8);
        }
    }

    /* renamed from: com.baidu.live.gift.container.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0181a {
        public TextView aVA;
        public TextView aVB;
        public TextView aVC;
        public TextView aVD;
        public TextView aVE;
        public View aVF;
        public LottieAnimationView aVG;
        public View aVH;
        public FrameLayout aVI;
        public ImageView aVJ;
        public TextView aVK;
        public FrameLayout aVL;
        public TextView aVM;
        public AnimatorSet aVN;
        public TbImageView aVw;
        public RelativeLayout aVx;
        public LinearLayout aVy;
        public View aVz;

        public void recycle() {
            if (this.aVG != null) {
                this.aVG.cancelAnimation();
            }
            GX();
        }

        public void GV() {
            if (this.aVH != null) {
                this.aVH.setVisibility(0);
            }
            N(this.aVw);
        }

        public void GW() {
            if (this.aVH != null) {
                this.aVH.setVisibility(8);
            }
            GX();
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
            this.aVN = new AnimatorSet();
            this.aVN.play(ofFloat).with(ofFloat2);
            this.aVN.start();
        }

        public void GX() {
            if (this.aVN != null) {
                this.aVN.cancel();
                this.aVN = null;
            }
        }
    }

    private static String ac(long j) {
        if (aVp == null) {
            aVp = new SimpleDateFormat("MM.dd");
        }
        return aVp.format(Long.valueOf(1000 * j));
    }
}

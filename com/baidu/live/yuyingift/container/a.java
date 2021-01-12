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
    private static SimpleDateFormat aWA;
    private int aWB;
    private int aWC;
    private int aWD;
    private int aWE;
    private boolean aWF;
    private int bUr;
    private TbPageContext mContext;
    private int mType;
    private int aWx = -1;
    private int mSelectedPosition = -1;
    private boolean aWz = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.yuyingift.container.a.1
        private void a(g gVar, C0235a c0235a) {
            com.baidu.live.gift.c go;
            if (gVar.CP() && gVar.aTb == 0 && !com.baidu.live.yuyingift.b.b.Xh().fJ(gVar.CC()) && (go = com.baidu.live.yuyingift.b.b.Xh().go(gVar.CC())) != null) {
                am.Em().a(go.aSo, true);
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
    private List<g> aWy = Collections.synchronizedList(new ArrayList());

    public a(TbPageContext tbPageContext, int i) {
        this.mContext = tbPageContext;
        this.mType = i;
    }

    public void setGiftItems(List<g> list) {
        if (this.aWy == null) {
            this.aWy = Collections.synchronizedList(new ArrayList());
        } else {
            this.aWy.clear();
        }
        if (list != null) {
            this.aWy.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void D(String str, int i) {
        if (this.aWy != null) {
            for (g gVar : this.aWy) {
                if (gVar.aSS != null && gVar.CC().equals(str)) {
                    gVar.aSS.aTh = i;
                }
            }
            notifyDataSetChanged();
        }
    }

    public void cK(int i) {
        this.aWx = i;
    }

    public void cL(int i) {
        this.mSelectedPosition = i;
    }

    public int EF() {
        return this.mSelectedPosition;
    }

    public void bA(boolean z) {
        this.aWz = z;
    }

    public void cM(int i) {
        this.aWB = i;
        float dimensionPixelOffset = (i * 1.0f) / this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds192);
        this.aWC = (int) (this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds100) * dimensionPixelOffset);
        this.aWD = (int) (this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds12) * dimensionPixelOffset);
        this.aWE = (int) (this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds8) * dimensionPixelOffset);
        this.bUr = (int) (dimensionPixelOffset * this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds4));
    }

    public void bh(boolean z) {
        this.aWF = z;
    }

    public void a(AbsListView absListView, boolean z) {
        int firstVisiblePosition;
        View childAt;
        this.aWF = z;
        int count = getCount();
        if (count != 0) {
            for (int i = 0; i < count; i++) {
                if (getItem(i).Dd() && i >= (firstVisiblePosition = absListView.getFirstVisiblePosition()) && i <= absListView.getLastVisiblePosition() && (childAt = absListView.getChildAt(i - firstVisiblePosition)) != null) {
                    getView(i, childAt, absListView);
                }
            }
        }
    }

    public void a(AbsListView absListView, String str, String str2, int i) {
        int count;
        int firstVisiblePosition;
        View childAt;
        com.baidu.live.gift.c go;
        if (!TextUtils.isEmpty(str) && (count = getCount()) != 0) {
            int i2 = 0;
            while (true) {
                if (i2 >= count) {
                    i2 = -1;
                    break;
                }
                g item = getItem(i2);
                if (item == null || TextUtils.isEmpty(item.CC()) || (go = com.baidu.live.yuyingift.b.b.Xh().go(item.CC())) == null || TextUtils.isEmpty(go.getDynamicGiftId()) || !go.getDynamicGiftId().equals(str) || !TextUtils.equals(aj.fV(item.CC()), str2)) {
                    i2++;
                } else {
                    item.aTb = i;
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
        if (this.aWy == null) {
            return 0;
        }
        return this.aWy.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: cN */
    public g getItem(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.aWy.get(i);
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
            c0235a2.aWH = (TbImageView) view.findViewById(a.f.gift_thumbnail);
            c0235a2.aWH.setDefaultBgResource(a.e.icon_live_gift_default);
            c0235a2.aWH.setDefaultErrorResource(a.e.icon_live_gift_default);
            c0235a2.aWH.setAutoChangeStyle(false);
            c0235a2.aWL = (TextView) view.findViewById(a.f.gift_name);
            c0235a2.aWN = (TextView) view.findViewById(a.f.gift_price);
            c0235a2.aWI = (RelativeLayout) view.findViewById(a.f.llCarom);
            c0235a2.bUu = (LottieAnimationView) view.findViewById(a.f.yuyin_ala_gift_lottie_downloading);
            c0235a2.bUt = (ImageView) view.findViewById(a.f.yuyin_gift_downloading_progress);
            c0235a2.aWO = (TextView) view.findViewById(a.f.gift_carom_txt);
            c0235a2.aWS = view.findViewById(a.f.selected_bg);
            c0235a2.aWP = (TextView) view.findViewById(a.f.tv_privilege);
            c0235a2.aWJ = (LinearLayout) view.findViewById(a.f.ll_privilege);
            c0235a2.bUv = (FrameLayout) view.findViewById(a.f.layout_pkg_count);
            c0235a2.bUw = (ImageView) view.findViewById(a.f.iv_pkg_count);
            c0235a2.bUx = (TextView) view.findViewById(a.f.tv_pkg_count);
            c0235a2.aWU = (FrameLayout) view.findViewById(a.f.layout_script);
            c0235a2.aWV = (TextView) view.findViewById(a.f.tv_script);
            c0235a2.bUu.loop(true);
            c0235a2.bUu.setAnimation("yuyin_live_gift_panel_downloading.json");
            view.setTag(c0235a2);
            if (this.aWB <= 0 || this.aWC <= 0) {
                c0235a = c0235a2;
            } else {
                view.getLayoutParams().height = this.aWB;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c0235a2.aWH.getLayoutParams();
                layoutParams.width = this.aWC;
                layoutParams.height = this.aWC;
                layoutParams.topMargin = this.aWD;
                ((RelativeLayout.LayoutParams) c0235a2.aWL.getLayoutParams()).topMargin = this.aWE;
                ((RelativeLayout.LayoutParams) c0235a2.aWN.getLayoutParams()).topMargin = this.bUr;
                c0235a = c0235a2;
            }
        } else {
            c0235a = (C0235a) view.getTag();
        }
        c0235a.EH();
        if (i == this.mSelectedPosition) {
            c0235a.EG();
        }
        g item = getItem(i);
        if (this.mType != 1) {
            bVar = null;
        } else {
            bVar = item.aSS;
        }
        if (item != null) {
            if (item.isRed()) {
                c0235a.aWH.setImageResource(a.e.live_gift_red_enter);
                c0235a.bUt.setVisibility(8);
                c0235a.bUu.setVisibility(8);
                c0235a.bUu.cancelAnimation();
                c0235a.aWL.setText(this.mContext.getPageActivity().getString(a.h.sdk_red_pkt_send));
                c0235a.aWN.setText("");
            } else {
                c0235a.aWH.startLoad(item.getThumbnail_url(), 10, false);
                c0235a.aWL.setText(item.CD());
                if (this.mType == 0) {
                    double d = JavaTypesHelper.toDouble(String.valueOf(item.getPrice()), 0.0d);
                    if (d >= 100.0d && ((this.aWz || com.baidu.live.af.a.OJ().bru.aJH) && !item.CO())) {
                        formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
                    } else {
                        formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(item.getPrice()));
                    }
                    c0235a.aWN.setText(formatGiftNumForTDouDisPlay);
                    if (item.CO()) {
                        c0235a.aWN.setText(this.mContext.getPageActivity().getString(a.h.ala_gift_price_flower_label, new Object[]{formatGiftNumForTDouDisPlay}));
                    } else {
                        c0235a.aWN.setText(this.mContext.getPageActivity().getString(a.h.ala_gift_price_tdou_label, new Object[]{formatGiftNumForTDouDisPlay}));
                    }
                } else if (this.mType == 1) {
                    if (bVar != null && bVar.aTi > 0) {
                        c0235a.aWN.setText(aM(bVar.aTi) + " 失效");
                    } else {
                        c0235a.aWN.setText("");
                    }
                }
                c0235a.aWI.setClickable(false);
                c0235a.aWI.setVisibility(8);
                c0235a.aWO.setBackgroundColor(0);
                c0235a.aWJ.setVisibility(8);
                c0235a.aWH.setAlpha(1.0f);
                c0235a.aWN.setAlpha(1.0f);
                c0235a.aWL.setAlpha(1.0f);
                c0235a.bUv.setVisibility(8);
                c0235a.bUu.setVisibility(8);
                c0235a.bUt.setVisibility(8);
                if (this.mType == 0) {
                    if (item.Db()) {
                        c0235a.aWH.setAlpha(0.5f);
                        c0235a.aWN.setAlpha(0.5f);
                        c0235a.aWL.setAlpha(0.5f);
                        c0235a.aWI.setVisibility(8);
                        c0235a.aWJ.setVisibility(0);
                        if (!TextUtils.isEmpty(item.Dc())) {
                            c0235a.aWP.setText(item.Dc());
                        } else {
                            c0235a.aWP.setText("");
                        }
                        String Dc = item.Dc();
                        if (item.CR()) {
                            if (item.CT()) {
                                c0235a.aWJ.setBackgroundResource(a.e.live_gift_item_script_lock_activity);
                            } else if (item.CU()) {
                                c0235a.aWJ.setBackgroundResource(a.e.live_gift_item_script_lock_power);
                            } else {
                                c0235a.aWJ.setBackgroundResource(a.e.live_gift_item_script_lock_level);
                            }
                        } else if (Dc.equals("活动")) {
                            c0235a.aWJ.setBackgroundResource(a.e.live_gift_item_script_lock_activity);
                        } else {
                            c0235a.aWJ.setBackgroundResource(a.e.live_gift_item_script_lock_level);
                        }
                    } else if (item.CP()) {
                        c0235a.aWI.setVisibility(0);
                        if (!com.baidu.live.yuyingift.b.b.Xh().fJ(item.CC())) {
                            c0235a.aWO.setText(" ");
                            c0235a.aWI.setClickable(true);
                            c0235a.bUt.setTag(a.f.TAG_GIFT_ITEM, item);
                            c0235a.bUt.setTag(a.f.TAG_GIFT_VIEW_HOLDER, c0235a);
                            c0235a.bUt.setOnClickListener(this.mOnClickListener);
                            if (item.aTb < 100) {
                                c0235a.aWH.setAlpha(0.5f);
                                c0235a.aWN.setAlpha(0.5f);
                                c0235a.aWL.setAlpha(0.5f);
                                c0235a.aWI.setVisibility(4);
                                if (item.aTb == 0) {
                                    c0235a.bUt.setVisibility(0);
                                    c0235a.bUu.setVisibility(8);
                                    c0235a.bUu.cancelAnimation();
                                } else {
                                    c0235a.bUu.setVisibility(0);
                                    c0235a.bUu.playAnimation();
                                }
                            } else if (com.baidu.live.yuyingift.b.b.Xh().go(item.CC()) != null) {
                                c0235a.bUu.setVisibility(8);
                                c0235a.bUu.cancelAnimation();
                                c0235a.aWI.setVisibility(0);
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
                    if (bVar.aTh > 999) {
                        c0235a.bUw.setImageResource(a.e.live_icon_gift_panel_package_count_large);
                        c0235a.bUx.setText("999+");
                    } else {
                        c0235a.bUw.setImageResource(a.e.live_icon_gift_panel_package_count_small);
                        c0235a.bUx.setText(String.valueOf(bVar.aTh));
                    }
                    c0235a.bUv.setVisibility(0);
                }
            }
        }
        return view;
    }

    private void a(C0235a c0235a, g gVar) {
        c0235a.bUt.setVisibility(8);
        c0235a.bUu.setVisibility(8);
        c0235a.bUu.cancelAnimation();
        if (gVar.CR()) {
            c0235a.aWI.setVisibility(0);
            String Dc = gVar.Dc();
            c0235a.aWO.setText(Dc);
            if (gVar.CT()) {
                if (TextUtils.isEmpty(Dc)) {
                    c0235a.aWO.setText(a.h.ala_gift_type_activity);
                }
                c0235a.aWO.setBackgroundResource(a.e.live_gift_panel_item_script_activity);
            } else if (gVar.CS()) {
                if (TextUtils.isEmpty(Dc)) {
                    c0235a.aWO.setText(a.h.ala_gift_type_discount);
                }
                c0235a.aWO.setBackgroundResource(a.e.live_gift_panel_item_script_discount);
            } else if (gVar.CU()) {
                if (TextUtils.isEmpty(Dc)) {
                    c0235a.aWO.setText(a.h.ala_gift_type_privilege);
                }
                c0235a.aWO.setBackgroundResource(a.e.live_gift_panel_item_script_power);
            } else if (gVar.CW()) {
                if (TextUtils.isEmpty(Dc)) {
                    c0235a.aWO.setText(a.h.ala_gift_broadcast_txt);
                }
                c0235a.aWO.setBackgroundResource(a.e.live_gift_panel_item_script_broadcast);
            } else if (gVar.CV()) {
                if (TextUtils.isEmpty(Dc)) {
                    c0235a.aWO.setText(a.h.ala_gift_draw_txt);
                }
                c0235a.aWO.setBackgroundResource(a.e.live_gift_panel_item_script_graffiti);
            } else if (gVar.CY()) {
                if (TextUtils.isEmpty(Dc)) {
                    Dc = this.mContext.getPageActivity().getString(a.h.ala_gift_type_new);
                    c0235a.aWO.setText(a.h.ala_gift_type_new);
                }
                if (Dc != null && Dc.length() == 1) {
                    c0235a.aWO.setBackgroundResource(a.e.live_gift_panel_item_script_new);
                } else {
                    c0235a.aWO.setBackgroundResource(a.e.live_gift_panel_item_script_new_wide);
                }
            } else {
                c0235a.aWI.setVisibility(8);
            }
        } else if (gVar.Df()) {
            c0235a.aWI.setVisibility(0);
            String Dc2 = gVar.Dc();
            if (TextUtils.isEmpty(Dc2)) {
                c0235a.aWO.setText(a.h.ala_gift_privilege_level);
            } else {
                c0235a.aWO.setText(Dc2);
            }
            c0235a.aWO.setBackgroundResource(a.e.live_gift_panel_item_script_level);
        } else if (gVar.Dd() && !this.aWF) {
            c0235a.aWH.setAlpha(0.5f);
            c0235a.aWN.setAlpha(0.5f);
            c0235a.aWL.setAlpha(0.5f);
            c0235a.aWI.setVisibility(8);
            c0235a.aWJ.setBackgroundResource(a.e.live_gift_item_script_lock_level);
            c0235a.aWJ.setVisibility(0);
            c0235a.aWP.setText(a.h.ala_gift_privilege_throne);
        } else if (gVar.CL()) {
            c0235a.aWI.setVisibility(0);
            String Dc3 = gVar.Dc();
            if (TextUtils.isEmpty(Dc3)) {
                c0235a.aWO.setText(a.h.ala_gift_draw_txt);
            } else {
                c0235a.aWO.setText(Dc3);
            }
            c0235a.aWO.setBackgroundResource(a.e.live_gift_panel_item_script_graffiti);
        } else if (gVar.CM()) {
            c0235a.aWI.setVisibility(0);
            String Dc4 = gVar.Dc();
            if (TextUtils.isEmpty(Dc4)) {
                c0235a.aWO.setText(a.h.ala_gift_combo_txt);
            } else {
                c0235a.aWO.setText(Dc4);
            }
            c0235a.aWO.setBackgroundResource(a.e.live_gift_panel_item_script_graffiti);
        } else if (gVar.CZ()) {
            String Dc5 = gVar.Dc();
            if (TextUtils.isEmpty(Dc5)) {
                c0235a.aWO.setText(a.h.ala_gift_broadcast_txt);
            } else {
                c0235a.aWO.setText(Dc5);
            }
            c0235a.aWO.setBackgroundResource(a.e.live_gift_panel_item_script_broadcast);
        } else if (!TextUtils.isEmpty(gVar.Dc())) {
            String Dc6 = gVar.Dc();
            c0235a.aWI.setVisibility(0);
            c0235a.aWO.setText(Dc6);
            if ("活动".equals(Dc6)) {
                c0235a.aWO.setBackgroundResource(a.e.live_gift_panel_item_script_activity);
            } else if ("折扣".equals(Dc6)) {
                c0235a.aWO.setBackgroundResource(a.e.live_gift_panel_item_script_discount);
            } else if (Dc6 != null && Dc6.length() == 1) {
                c0235a.aWO.setBackgroundResource(a.e.live_gift_panel_item_script_new);
            } else {
                c0235a.aWO.setBackgroundResource(a.e.live_gift_panel_item_script_new_wide);
            }
        } else {
            c0235a.aWI.setVisibility(8);
        }
    }

    /* renamed from: com.baidu.live.yuyingift.container.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0235a {
        public TbImageView aWH;
        public RelativeLayout aWI;
        public LinearLayout aWJ;
        public TextView aWL;
        public TextView aWN;
        public TextView aWO;
        public TextView aWP;
        public View aWS;
        public FrameLayout aWU;
        public TextView aWV;
        public AnimatorSet aWW;
        public ImageView bUt;
        public LottieAnimationView bUu;
        public FrameLayout bUv;
        public ImageView bUw;
        public TextView bUx;

        public void recycle() {
            EI();
        }

        public void EG() {
            if (this.aWS != null) {
                this.aWS.setVisibility(0);
            }
            N(this.aWH);
        }

        public void EH() {
            if (this.aWS != null) {
                this.aWS.setVisibility(8);
            }
            EI();
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
            this.aWW = new AnimatorSet();
            this.aWW.play(ofFloat).with(ofFloat2);
            this.aWW.start();
        }

        public void EI() {
            if (this.aWW != null) {
                this.aWW.cancel();
                this.aWW = null;
            }
        }
    }

    private static String aM(long j) {
        if (aWA == null) {
            aWA = new SimpleDateFormat("MM.dd");
        }
        return aWA.format(Long.valueOf(1000 * j));
    }
}

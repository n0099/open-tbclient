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
    private static SimpleDateFormat aZG;
    private int aZH;
    private int aZI;
    private int aZJ;
    private int aZK;
    private boolean aZL;
    private int bYt;
    private TbPageContext mContext;
    private int mType;
    private int aZD = -1;
    private int mSelectedPosition = -1;
    private boolean aZF = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.yuyingift.container.a.1
        private void a(g gVar, C0236a c0236a) {
            com.baidu.live.gift.c gM;
            if (gVar.Ef() && gVar.aWg == 0 && !com.baidu.live.yuyingift.b.b.YX().ge(gVar.DR()) && (gM = com.baidu.live.yuyingift.b.b.YX().gM(gVar.DR())) != null) {
                am.FC().a(gM.aVs, true);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view.getTag(a.f.TAG_GIFT_ITEM) instanceof g) && (view.getTag(a.f.TAG_GIFT_VIEW_HOLDER) instanceof C0236a)) {
                C0236a c0236a = (C0236a) view.getTag(a.f.TAG_GIFT_VIEW_HOLDER);
                g gVar = (g) view.getTag(a.f.TAG_GIFT_ITEM);
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(a.this.mContext.getPageActivity(), a.this.mContext.getString(a.h.sdk_neterror));
                } else {
                    a(gVar, c0236a);
                }
            }
        }
    };
    private List<g> aZE = Collections.synchronizedList(new ArrayList());

    public a(TbPageContext tbPageContext, int i) {
        this.mContext = tbPageContext;
        this.mType = i;
    }

    public void setGiftItems(List<g> list) {
        if (this.aZE == null) {
            this.aZE = Collections.synchronizedList(new ArrayList());
        } else {
            this.aZE.clear();
        }
        if (list != null) {
            this.aZE.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void E(String str, int i) {
        if (this.aZE != null) {
            for (g gVar : this.aZE) {
                if (gVar.aVX != null && gVar.DR().equals(str)) {
                    gVar.aVX.aWm = i;
                }
            }
            notifyDataSetChanged();
        }
    }

    public void cP(int i) {
        this.aZD = i;
    }

    public void cQ(int i) {
        this.mSelectedPosition = i;
    }

    public int FV() {
        return this.mSelectedPosition;
    }

    public void bF(boolean z) {
        this.aZF = z;
    }

    public void cR(int i) {
        this.aZH = i;
        float dimensionPixelOffset = (i * 1.0f) / this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds192);
        this.aZI = (int) (this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds100) * dimensionPixelOffset);
        this.aZJ = (int) (this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds12) * dimensionPixelOffset);
        this.aZK = (int) (this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds8) * dimensionPixelOffset);
        this.bYt = (int) (dimensionPixelOffset * this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds4));
    }

    public void bj(boolean z) {
        this.aZL = z;
    }

    public void a(AbsListView absListView, boolean z) {
        int firstVisiblePosition;
        View childAt;
        this.aZL = z;
        int count = getCount();
        if (count != 0) {
            for (int i = 0; i < count; i++) {
                if (getItem(i).Et() && i >= (firstVisiblePosition = absListView.getFirstVisiblePosition()) && i <= absListView.getLastVisiblePosition() && (childAt = absListView.getChildAt(i - firstVisiblePosition)) != null) {
                    getView(i, childAt, absListView);
                }
            }
        }
    }

    public void a(AbsListView absListView, String str, String str2, int i) {
        int count;
        int firstVisiblePosition;
        View childAt;
        com.baidu.live.gift.c gM;
        if (!TextUtils.isEmpty(str) && (count = getCount()) != 0) {
            int i2 = 0;
            while (true) {
                if (i2 >= count) {
                    i2 = -1;
                    break;
                }
                g item = getItem(i2);
                if (item == null || TextUtils.isEmpty(item.DR()) || (gM = com.baidu.live.yuyingift.b.b.YX().gM(item.DR())) == null || TextUtils.isEmpty(gM.getDynamicGiftId()) || !gM.getDynamicGiftId().equals(str) || !TextUtils.equals(aj.gr(item.DR()), str2)) {
                    i2++;
                } else {
                    item.aWg = i;
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
        if (this.aZE == null) {
            return 0;
        }
        return this.aZE.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: cS */
    public g getItem(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.aZE.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0236a c0236a;
        g.b bVar;
        String formatGiftNumForTDouDisPlay;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.g.yuyin_ala_gift_list_item, viewGroup, false);
            view.setBackgroundResource(a.e.sdk_transparent_bg);
            C0236a c0236a2 = new C0236a();
            c0236a2.aZN = (TbImageView) view.findViewById(a.f.gift_thumbnail);
            c0236a2.aZN.setDefaultBgResource(a.e.icon_live_gift_default);
            c0236a2.aZN.setDefaultErrorResource(a.e.icon_live_gift_default);
            c0236a2.aZN.setAutoChangeStyle(false);
            c0236a2.aZR = (TextView) view.findViewById(a.f.gift_name);
            c0236a2.aZT = (TextView) view.findViewById(a.f.gift_price);
            c0236a2.aZO = (RelativeLayout) view.findViewById(a.f.llCarom);
            c0236a2.bYw = (LottieAnimationView) view.findViewById(a.f.yuyin_ala_gift_lottie_downloading);
            c0236a2.bYv = (ImageView) view.findViewById(a.f.yuyin_gift_downloading_progress);
            c0236a2.aZU = (TextView) view.findViewById(a.f.gift_carom_txt);
            c0236a2.aZY = view.findViewById(a.f.selected_bg);
            c0236a2.aZV = (TextView) view.findViewById(a.f.tv_privilege);
            c0236a2.aZP = (LinearLayout) view.findViewById(a.f.ll_privilege);
            c0236a2.bYx = (FrameLayout) view.findViewById(a.f.layout_pkg_count);
            c0236a2.bYy = (ImageView) view.findViewById(a.f.iv_pkg_count);
            c0236a2.bYz = (TextView) view.findViewById(a.f.tv_pkg_count);
            c0236a2.baa = (FrameLayout) view.findViewById(a.f.layout_script);
            c0236a2.bab = (TextView) view.findViewById(a.f.tv_script);
            c0236a2.bYw.loop(true);
            c0236a2.bYw.setAnimation("yuyin_live_gift_panel_downloading.json");
            view.setTag(c0236a2);
            if (this.aZH <= 0 || this.aZI <= 0) {
                c0236a = c0236a2;
            } else {
                view.getLayoutParams().height = this.aZH;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c0236a2.aZN.getLayoutParams();
                layoutParams.width = this.aZI;
                layoutParams.height = this.aZI;
                layoutParams.topMargin = this.aZJ;
                ((RelativeLayout.LayoutParams) c0236a2.aZR.getLayoutParams()).topMargin = this.aZK;
                ((RelativeLayout.LayoutParams) c0236a2.aZT.getLayoutParams()).topMargin = this.bYt;
                c0236a = c0236a2;
            }
        } else {
            c0236a = (C0236a) view.getTag();
        }
        c0236a.FX();
        if (i == this.mSelectedPosition) {
            c0236a.FW();
        }
        g item = getItem(i);
        if (this.mType != 1) {
            bVar = null;
        } else {
            bVar = item.aVX;
        }
        if (item != null) {
            if (item.isRed()) {
                c0236a.aZN.setImageResource(a.e.live_gift_red_enter);
                c0236a.bYv.setVisibility(8);
                c0236a.bYw.setVisibility(8);
                c0236a.bYw.cancelAnimation();
                c0236a.aZR.setText(this.mContext.getPageActivity().getString(a.h.sdk_red_pkt_send));
                c0236a.aZT.setText("");
            } else {
                c0236a.aZN.startLoad(item.getThumbnail_url(), 10, false);
                c0236a.aZR.setText(item.DS());
                if (this.mType == 0) {
                    double d = JavaTypesHelper.toDouble(String.valueOf(item.getPrice()), 0.0d);
                    if (d >= 100.0d && ((this.aZF || com.baidu.live.ae.a.Qj().buX.aMr) && !item.Ee())) {
                        formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
                    } else {
                        formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(item.getPrice()));
                    }
                    c0236a.aZT.setText(formatGiftNumForTDouDisPlay);
                    if (item.Ee()) {
                        c0236a.aZT.setText(this.mContext.getPageActivity().getString(a.h.ala_gift_price_flower_label, new Object[]{formatGiftNumForTDouDisPlay}));
                    } else {
                        c0236a.aZT.setText(this.mContext.getPageActivity().getString(a.h.ala_gift_price_tdou_label, new Object[]{formatGiftNumForTDouDisPlay}));
                    }
                } else if (this.mType == 1) {
                    if (bVar != null && bVar.aWn > 0) {
                        c0236a.aZT.setText(aP(bVar.aWn) + " 失效");
                    } else {
                        c0236a.aZT.setText("");
                    }
                }
                c0236a.aZO.setClickable(false);
                c0236a.aZO.setVisibility(8);
                c0236a.aZU.setBackgroundColor(0);
                c0236a.aZP.setVisibility(8);
                c0236a.aZN.setAlpha(1.0f);
                c0236a.aZT.setAlpha(1.0f);
                c0236a.aZR.setAlpha(1.0f);
                c0236a.bYx.setVisibility(8);
                c0236a.bYw.setVisibility(8);
                c0236a.bYv.setVisibility(8);
                if (this.mType == 0) {
                    if (item.Er()) {
                        c0236a.aZN.setAlpha(0.5f);
                        c0236a.aZT.setAlpha(0.5f);
                        c0236a.aZR.setAlpha(0.5f);
                        c0236a.aZO.setVisibility(8);
                        c0236a.aZP.setVisibility(0);
                        if (!TextUtils.isEmpty(item.Es())) {
                            c0236a.aZV.setText(item.Es());
                        } else {
                            c0236a.aZV.setText("");
                        }
                        String Es = item.Es();
                        if (item.Eh()) {
                            if (item.Ej()) {
                                c0236a.aZP.setBackgroundResource(a.e.live_gift_item_script_lock_activity);
                            } else if (item.Ek()) {
                                c0236a.aZP.setBackgroundResource(a.e.live_gift_item_script_lock_power);
                            } else {
                                c0236a.aZP.setBackgroundResource(a.e.live_gift_item_script_lock_level);
                            }
                        } else if (Es.equals("活动")) {
                            c0236a.aZP.setBackgroundResource(a.e.live_gift_item_script_lock_activity);
                        } else {
                            c0236a.aZP.setBackgroundResource(a.e.live_gift_item_script_lock_level);
                        }
                    } else if (item.Ef()) {
                        c0236a.aZO.setVisibility(0);
                        if (!com.baidu.live.yuyingift.b.b.YX().ge(item.DR())) {
                            c0236a.aZU.setText(" ");
                            c0236a.aZO.setClickable(true);
                            c0236a.bYv.setTag(a.f.TAG_GIFT_ITEM, item);
                            c0236a.bYv.setTag(a.f.TAG_GIFT_VIEW_HOLDER, c0236a);
                            c0236a.bYv.setOnClickListener(this.mOnClickListener);
                            if (item.aWg < 100) {
                                c0236a.aZN.setAlpha(0.5f);
                                c0236a.aZT.setAlpha(0.5f);
                                c0236a.aZR.setAlpha(0.5f);
                                c0236a.aZO.setVisibility(4);
                                if (item.aWg == 0) {
                                    c0236a.bYv.setVisibility(0);
                                    c0236a.bYw.setVisibility(8);
                                    c0236a.bYw.cancelAnimation();
                                } else {
                                    c0236a.bYw.setVisibility(0);
                                    c0236a.bYw.playAnimation();
                                }
                            } else if (com.baidu.live.yuyingift.b.b.YX().gM(item.DR()) != null) {
                                c0236a.bYw.setVisibility(8);
                                c0236a.bYw.cancelAnimation();
                                c0236a.aZO.setVisibility(0);
                            } else {
                                a(c0236a, item);
                            }
                        } else {
                            a(c0236a, item);
                        }
                    } else {
                        a(c0236a, item);
                    }
                } else if (this.mType == 1 && bVar != null) {
                    if (bVar.aWm > 999) {
                        c0236a.bYy.setImageResource(a.e.live_icon_gift_panel_package_count_large);
                        c0236a.bYz.setText("999+");
                    } else {
                        c0236a.bYy.setImageResource(a.e.live_icon_gift_panel_package_count_small);
                        c0236a.bYz.setText(String.valueOf(bVar.aWm));
                    }
                    c0236a.bYx.setVisibility(0);
                }
            }
        }
        return view;
    }

    private void a(C0236a c0236a, g gVar) {
        c0236a.bYv.setVisibility(8);
        c0236a.bYw.setVisibility(8);
        c0236a.bYw.cancelAnimation();
        if (gVar.Eh()) {
            c0236a.aZO.setVisibility(0);
            String Es = gVar.Es();
            c0236a.aZU.setText(Es);
            if (gVar.Ej()) {
                if (TextUtils.isEmpty(Es)) {
                    c0236a.aZU.setText(a.h.ala_gift_type_activity);
                }
                c0236a.aZU.setBackgroundResource(a.e.live_gift_panel_item_script_activity);
            } else if (gVar.Ei()) {
                if (TextUtils.isEmpty(Es)) {
                    c0236a.aZU.setText(a.h.ala_gift_type_discount);
                }
                c0236a.aZU.setBackgroundResource(a.e.live_gift_panel_item_script_discount);
            } else if (gVar.Ek()) {
                if (TextUtils.isEmpty(Es)) {
                    c0236a.aZU.setText(a.h.ala_gift_type_privilege);
                }
                c0236a.aZU.setBackgroundResource(a.e.live_gift_panel_item_script_power);
            } else if (gVar.Em()) {
                if (TextUtils.isEmpty(Es)) {
                    c0236a.aZU.setText(a.h.ala_gift_broadcast_txt);
                }
                c0236a.aZU.setBackgroundResource(a.e.live_gift_panel_item_script_broadcast);
            } else if (gVar.El()) {
                if (TextUtils.isEmpty(Es)) {
                    c0236a.aZU.setText(a.h.ala_gift_draw_txt);
                }
                c0236a.aZU.setBackgroundResource(a.e.live_gift_panel_item_script_graffiti);
            } else if (gVar.Eo()) {
                if (TextUtils.isEmpty(Es)) {
                    Es = this.mContext.getPageActivity().getString(a.h.ala_gift_type_new);
                    c0236a.aZU.setText(a.h.ala_gift_type_new);
                }
                if (Es != null && Es.length() == 1) {
                    c0236a.aZU.setBackgroundResource(a.e.live_gift_panel_item_script_new);
                } else {
                    c0236a.aZU.setBackgroundResource(a.e.live_gift_panel_item_script_new_wide);
                }
            } else {
                c0236a.aZO.setVisibility(8);
            }
        } else if (gVar.Ev()) {
            c0236a.aZO.setVisibility(0);
            String Es2 = gVar.Es();
            if (TextUtils.isEmpty(Es2)) {
                c0236a.aZU.setText(a.h.ala_gift_privilege_level);
            } else {
                c0236a.aZU.setText(Es2);
            }
            c0236a.aZU.setBackgroundResource(a.e.live_gift_panel_item_script_level);
        } else if (gVar.Et() && !this.aZL) {
            c0236a.aZN.setAlpha(0.5f);
            c0236a.aZT.setAlpha(0.5f);
            c0236a.aZR.setAlpha(0.5f);
            c0236a.aZO.setVisibility(8);
            c0236a.aZP.setBackgroundResource(a.e.live_gift_item_script_lock_level);
            c0236a.aZP.setVisibility(0);
            c0236a.aZV.setText(a.h.ala_gift_privilege_throne);
        } else if (gVar.Eb()) {
            c0236a.aZO.setVisibility(0);
            String Es3 = gVar.Es();
            if (TextUtils.isEmpty(Es3)) {
                c0236a.aZU.setText(a.h.ala_gift_draw_txt);
            } else {
                c0236a.aZU.setText(Es3);
            }
            c0236a.aZU.setBackgroundResource(a.e.live_gift_panel_item_script_graffiti);
        } else if (gVar.Ec()) {
            c0236a.aZO.setVisibility(0);
            String Es4 = gVar.Es();
            if (TextUtils.isEmpty(Es4)) {
                c0236a.aZU.setText(a.h.ala_gift_combo_txt);
            } else {
                c0236a.aZU.setText(Es4);
            }
            c0236a.aZU.setBackgroundResource(a.e.live_gift_panel_item_script_graffiti);
        } else if (gVar.Ep()) {
            String Es5 = gVar.Es();
            if (TextUtils.isEmpty(Es5)) {
                c0236a.aZU.setText(a.h.ala_gift_broadcast_txt);
            } else {
                c0236a.aZU.setText(Es5);
            }
            c0236a.aZU.setBackgroundResource(a.e.live_gift_panel_item_script_broadcast);
        } else if (!TextUtils.isEmpty(gVar.Es())) {
            String Es6 = gVar.Es();
            c0236a.aZO.setVisibility(0);
            c0236a.aZU.setText(Es6);
            if ("活动".equals(Es6)) {
                c0236a.aZU.setBackgroundResource(a.e.live_gift_panel_item_script_activity);
            } else if ("折扣".equals(Es6)) {
                c0236a.aZU.setBackgroundResource(a.e.live_gift_panel_item_script_discount);
            } else if (Es6 != null && Es6.length() == 1) {
                c0236a.aZU.setBackgroundResource(a.e.live_gift_panel_item_script_new);
            } else {
                c0236a.aZU.setBackgroundResource(a.e.live_gift_panel_item_script_new_wide);
            }
        } else {
            c0236a.aZO.setVisibility(8);
        }
    }

    /* renamed from: com.baidu.live.yuyingift.container.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0236a {
        public TbImageView aZN;
        public RelativeLayout aZO;
        public LinearLayout aZP;
        public TextView aZR;
        public TextView aZT;
        public TextView aZU;
        public TextView aZV;
        public View aZY;
        public ImageView bYv;
        public LottieAnimationView bYw;
        public FrameLayout bYx;
        public ImageView bYy;
        public TextView bYz;
        public FrameLayout baa;
        public TextView bab;
        public AnimatorSet bac;

        public void recycle() {
            FY();
        }

        public void FW() {
            if (this.aZY != null) {
                this.aZY.setVisibility(0);
            }
            N(this.aZN);
        }

        public void FX() {
            if (this.aZY != null) {
                this.aZY.setVisibility(8);
            }
            FY();
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
            this.bac = new AnimatorSet();
            this.bac.play(ofFloat).with(ofFloat2);
            this.bac.start();
        }

        public void FY() {
            if (this.bac != null) {
                this.bac.cancel();
                this.bac = null;
            }
        }
    }

    private static String aP(long j) {
        if (aZG == null) {
            aZG = new SimpleDateFormat("MM.dd");
        }
        return aZG.format(Long.valueOf(1000 * j));
    }
}

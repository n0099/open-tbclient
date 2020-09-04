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
import com.baidu.live.gift.v;
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
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private static SimpleDateFormat aQc;
    private int aQd;
    private int aQe;
    private int aQf;
    private int aQg;
    private int aQh;
    private boolean aQi;
    private TbPageContext mContext;
    private int mType;
    private int aPZ = -1;
    private int mSelectedPosition = -1;
    private boolean aQb = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.gift.container.a.1
        private void a(g gVar, C0172a c0172a) {
            com.baidu.live.gift.c gJ;
            if (gVar.Ec() && !com.baidu.live.gift.b.b.GM().gj(gVar.DR()) && (gJ = com.baidu.live.gift.b.b.GM().gJ(gVar.DR())) != null) {
                com.baidu.live.gift.b.a.a(gJ.aMN, true);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view.getTag(a.g.TAG_GIFT_ITEM) instanceof g) && (view.getTag(a.g.TAG_GIFT_VIEW_HOLDER) instanceof C0172a)) {
                C0172a c0172a = (C0172a) view.getTag(a.g.TAG_GIFT_VIEW_HOLDER);
                g gVar = (g) view.getTag(a.g.TAG_GIFT_ITEM);
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(a.this.mContext.getPageActivity(), a.this.mContext.getString(a.i.sdk_neterror));
                } else {
                    a(gVar, c0172a);
                }
            }
        }
    };
    private List<g> aQa = Collections.synchronizedList(new ArrayList());

    public a(TbPageContext tbPageContext, int i) {
        this.mContext = tbPageContext;
        this.mType = i;
    }

    public void setGiftItems(List<g> list) {
        if (this.aQa == null) {
            this.aQa = Collections.synchronizedList(new ArrayList());
        } else {
            this.aQa.clear();
        }
        if (list != null) {
            this.aQa.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void A(String str, int i) {
        if (this.aQa != null) {
            for (g gVar : this.aQa) {
                if (gVar.aNp != null && gVar.DR().equals(str)) {
                    gVar.aNp.aNw = i;
                }
            }
            notifyDataSetChanged();
        }
    }

    public void dS(int i) {
        this.aPZ = i;
    }

    public void dT(int i) {
        this.mSelectedPosition = i;
    }

    public int getSelectedPosition() {
        return this.mSelectedPosition;
    }

    public void bn(boolean z) {
        this.aQb = z;
    }

    public void dU(int i) {
        this.aQd = i;
        float dimensionPixelOffset = (i * 1.0f) / this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds192);
        this.aQe = (int) (this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds100) * dimensionPixelOffset);
        this.aQf = (int) (this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds12) * dimensionPixelOffset);
        this.aQg = (int) (this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds8) * dimensionPixelOffset);
        this.aQh = (int) (dimensionPixelOffset * this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds4));
    }

    public void aY(boolean z) {
        this.aQi = z;
    }

    public void a(AbsListView absListView, boolean z) {
        int firstVisiblePosition;
        View childAt;
        this.aQi = z;
        int count = getCount();
        if (count != 0) {
            for (int i = 0; i < count; i++) {
                if (getItem(i).Ep() && i >= (firstVisiblePosition = absListView.getFirstVisiblePosition()) && i <= absListView.getLastVisiblePosition() && (childAt = absListView.getChildAt(i - firstVisiblePosition)) != null) {
                    getView(i, childAt, absListView);
                }
            }
        }
    }

    public void a(AbsListView absListView, String str, String str2) {
        int count;
        int firstVisiblePosition;
        View childAt;
        com.baidu.live.gift.c gJ;
        if (!TextUtils.isEmpty(str) && (count = getCount()) != 0) {
            int i = 0;
            while (true) {
                if (i >= count) {
                    i = -1;
                    break;
                }
                g item = getItem(i);
                if (item != null && !TextUtils.isEmpty(item.DR()) && (gJ = com.baidu.live.gift.b.b.GM().gJ(item.DR())) != null && !TextUtils.isEmpty(gJ.getDynamicGiftId()) && gJ.getDynamicGiftId().equals(str) && v.gt(item.DR()).equals(str2)) {
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
        if (this.aQa == null) {
            return 0;
        }
        return this.aQa.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: dV */
    public g getItem(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.aQa.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0172a c0172a;
        g.a aVar;
        String formatGiftNumForTDouDisPlay;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.ala_gift_list_item, viewGroup, false);
            view.setBackgroundResource(a.f.sdk_transparent_bg);
            C0172a c0172a2 = new C0172a();
            c0172a2.aQk = (TbImageView) view.findViewById(a.g.gift_thumbnail);
            c0172a2.aQk.setDefaultBgResource(a.f.icon_live_gift_default);
            c0172a2.aQk.setDefaultErrorResource(a.f.icon_live_gift_default);
            c0172a2.aQk.setAutoChangeStyle(false);
            c0172a2.aQn = (TextView) view.findViewById(a.g.gift_name);
            c0172a2.aQo = (TextView) view.findViewById(a.g.gift_price);
            c0172a2.aQl = (RelativeLayout) view.findViewById(a.g.llCarom);
            c0172a2.aQp = (TextView) view.findViewById(a.g.gift_carom_txt);
            c0172a2.aQr = view.findViewById(a.g.in_progress);
            c0172a2.aQs = (LottieAnimationView) view.findViewById(a.g.lottie_downloading);
            c0172a2.aQs.loop(true);
            c0172a2.aQs.setAnimation("live_gift_panel_downloading.json");
            c0172a2.aQt = view.findViewById(a.g.selected_bg);
            c0172a2.aQq = (TextView) view.findViewById(a.g.tv_privilege);
            c0172a2.aQm = (LinearLayout) view.findViewById(a.g.ll_privilege);
            c0172a2.aQu = (FrameLayout) view.findViewById(a.g.layout_pkg_count);
            c0172a2.aQv = (ImageView) view.findViewById(a.g.iv_pkg_count);
            c0172a2.aQw = (TextView) view.findViewById(a.g.tv_pkg_count);
            c0172a2.aQx = (FrameLayout) view.findViewById(a.g.layout_script);
            c0172a2.aQy = (TextView) view.findViewById(a.g.tv_script);
            view.setTag(c0172a2);
            if (this.aQd <= 0 || this.aQe <= 0) {
                c0172a = c0172a2;
            } else {
                view.getLayoutParams().height = this.aQd;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c0172a2.aQk.getLayoutParams();
                layoutParams.width = this.aQe;
                layoutParams.height = this.aQe;
                layoutParams.topMargin = this.aQf;
                ((RelativeLayout.LayoutParams) c0172a2.aQn.getLayoutParams()).topMargin = this.aQg;
                ((RelativeLayout.LayoutParams) c0172a2.aQo.getLayoutParams()).topMargin = this.aQh;
                c0172a = c0172a2;
            }
        } else {
            c0172a = (C0172a) view.getTag();
        }
        c0172a.FA();
        if (i == this.mSelectedPosition) {
            c0172a.Fz();
        }
        g item = getItem(i);
        if (this.mType != 1) {
            aVar = null;
        } else {
            aVar = item.aNp;
        }
        if (item != null) {
            if (item.isRed()) {
                c0172a.aQk.setImageResource(a.f.live_gift_red_enter);
                c0172a.aQn.setText(this.mContext.getPageActivity().getString(a.i.sdk_red_pkt_send));
                c0172a.aQo.setText("");
            } else {
                c0172a.aQk.startLoad(item.getThumbnail_url(), 10, false);
                c0172a.aQn.setText(item.DS());
                if (this.mType == 0) {
                    double d = JavaTypesHelper.toDouble(String.valueOf(item.getPrice()), 0.0d);
                    if (d >= 100.0d && ((this.aQb || com.baidu.live.w.a.Nk().beJ.aGJ) && !item.Eb())) {
                        formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
                    } else {
                        formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(item.getPrice()));
                    }
                    c0172a.aQo.setText(formatGiftNumForTDouDisPlay);
                    if (item.Eb()) {
                        c0172a.aQo.setText(this.mContext.getPageActivity().getString(a.i.ala_gift_price_flower_label, new Object[]{formatGiftNumForTDouDisPlay}));
                    } else {
                        c0172a.aQo.setText(this.mContext.getPageActivity().getString(a.i.ala_gift_price_tdou_label, new Object[]{formatGiftNumForTDouDisPlay}));
                    }
                } else if (this.mType == 1) {
                    if (aVar != null) {
                        c0172a.aQo.setText(ab(aVar.aNx) + " 失效");
                    } else {
                        c0172a.aQo.setText("");
                    }
                }
                c0172a.aQl.setClickable(false);
                c0172a.aQl.setVisibility(8);
                c0172a.aQp.setBackgroundColor(0);
                c0172a.aQm.setVisibility(8);
                c0172a.aQk.setAlpha(1.0f);
                c0172a.aQo.setAlpha(1.0f);
                c0172a.aQn.setAlpha(1.0f);
                c0172a.aQu.setVisibility(8);
                c0172a.aQr.setVisibility(4);
                c0172a.aQs.cancelAnimation();
                if (this.mType == 0) {
                    if (item.En()) {
                        c0172a.aQk.setAlpha(0.5f);
                        c0172a.aQo.setAlpha(0.5f);
                        c0172a.aQn.setAlpha(0.5f);
                        c0172a.aQl.setVisibility(8);
                        c0172a.aQm.setVisibility(0);
                        if (!TextUtils.isEmpty(item.Eo())) {
                            c0172a.aQq.setText(item.Eo());
                        } else {
                            c0172a.aQq.setText("");
                        }
                        String Eo = item.Eo();
                        if (item.Ee()) {
                            if (item.Eg()) {
                                c0172a.aQm.setBackgroundResource(a.f.live_gift_item_script_lock_activity);
                            } else if (item.Eh()) {
                                c0172a.aQm.setBackgroundResource(a.f.live_gift_item_script_lock_power);
                            } else {
                                c0172a.aQm.setBackgroundResource(a.f.live_gift_item_script_lock_level);
                            }
                        } else if (Eo.equals("活动")) {
                            c0172a.aQm.setBackgroundResource(a.f.live_gift_item_script_lock_activity);
                        } else {
                            c0172a.aQm.setBackgroundResource(a.f.live_gift_item_script_lock_level);
                        }
                    } else if (item.Ec()) {
                        c0172a.aQl.setVisibility(0);
                        if (!com.baidu.live.gift.b.b.GM().gj(item.DR())) {
                            c0172a.aQp.setText(" ");
                            c0172a.aQp.setBackgroundResource(a.f.live_gift_panel_item_script_download);
                            c0172a.aQl.setTag(a.g.TAG_GIFT_ITEM, item);
                            c0172a.aQl.setTag(a.g.TAG_GIFT_VIEW_HOLDER, c0172a);
                            c0172a.aQl.setClickable(true);
                            c0172a.aQl.setOnClickListener(this.mOnClickListener);
                            if (com.baidu.live.gift.b.a.ar(item.DR(), v.gt(item.DR()))) {
                                c0172a.aQk.setAlpha(0.5f);
                                c0172a.aQo.setAlpha(0.5f);
                                c0172a.aQn.setAlpha(0.5f);
                                c0172a.aQr.setVisibility(0);
                                c0172a.aQs.playAnimation();
                                c0172a.aQl.setVisibility(4);
                            } else {
                                c0172a.aQr.setVisibility(4);
                                c0172a.aQs.cancelAnimation();
                                c0172a.aQl.setVisibility(0);
                            }
                        } else {
                            a(c0172a, item);
                        }
                    } else {
                        a(c0172a, item);
                    }
                } else if (this.mType == 1 && aVar != null) {
                    if (aVar.aNw > 999) {
                        c0172a.aQv.setImageResource(a.f.live_icon_gift_panel_package_count_large);
                        c0172a.aQw.setText("999+");
                    } else {
                        c0172a.aQv.setImageResource(a.f.live_icon_gift_panel_package_count_small);
                        c0172a.aQw.setText(String.valueOf(aVar.aNw));
                    }
                    c0172a.aQu.setVisibility(0);
                }
            }
        }
        return view;
    }

    private void a(C0172a c0172a, g gVar) {
        c0172a.aQr.setVisibility(4);
        c0172a.aQs.cancelAnimation();
        if (gVar.Ee()) {
            c0172a.aQl.setVisibility(0);
            String Eo = gVar.Eo();
            c0172a.aQp.setText(Eo);
            if (gVar.Eg()) {
                if (TextUtils.isEmpty(Eo)) {
                    c0172a.aQp.setText(a.i.ala_gift_type_activity);
                }
                c0172a.aQp.setBackgroundResource(a.f.live_gift_panel_item_script_activity);
            } else if (gVar.Ef()) {
                if (TextUtils.isEmpty(Eo)) {
                    c0172a.aQp.setText(a.i.ala_gift_type_discount);
                }
                c0172a.aQp.setBackgroundResource(a.f.live_gift_panel_item_script_discount);
            } else if (gVar.Eh()) {
                if (TextUtils.isEmpty(Eo)) {
                    c0172a.aQp.setText(a.i.ala_gift_type_privilege);
                }
                c0172a.aQp.setBackgroundResource(a.f.live_gift_panel_item_script_power);
            } else if (gVar.Ej()) {
                if (TextUtils.isEmpty(Eo)) {
                    c0172a.aQp.setText(a.i.ala_gift_broadcast_txt);
                }
                c0172a.aQp.setBackgroundResource(a.f.live_gift_panel_item_script_broadcast);
            } else if (gVar.Ei()) {
                if (TextUtils.isEmpty(Eo)) {
                    c0172a.aQp.setText(a.i.ala_gift_draw_txt);
                }
                c0172a.aQp.setBackgroundResource(a.f.live_gift_panel_item_script_graffiti);
            } else if (gVar.Ek()) {
                if (TextUtils.isEmpty(Eo)) {
                    Eo = this.mContext.getPageActivity().getString(a.i.ala_gift_type_new);
                    c0172a.aQp.setText(a.i.ala_gift_type_new);
                }
                if (Eo != null && Eo.length() == 1) {
                    c0172a.aQp.setBackgroundResource(a.f.live_gift_panel_item_script_new);
                } else {
                    c0172a.aQp.setBackgroundResource(a.f.live_gift_panel_item_script_new_wide);
                }
            } else {
                c0172a.aQl.setVisibility(8);
            }
        } else if (gVar.Eq()) {
            c0172a.aQl.setVisibility(0);
            String Eo2 = gVar.Eo();
            if (TextUtils.isEmpty(Eo2)) {
                c0172a.aQp.setText(a.i.ala_gift_privilege_level);
            } else {
                c0172a.aQp.setText(Eo2);
            }
            c0172a.aQp.setBackgroundResource(a.f.live_gift_panel_item_script_level);
        } else if (gVar.Ep() && !this.aQi) {
            c0172a.aQk.setAlpha(0.5f);
            c0172a.aQo.setAlpha(0.5f);
            c0172a.aQn.setAlpha(0.5f);
            c0172a.aQl.setVisibility(8);
            c0172a.aQm.setBackgroundResource(a.f.live_gift_item_script_lock_level);
            c0172a.aQm.setVisibility(0);
            c0172a.aQq.setText(a.i.ala_gift_privilege_throne);
        } else if (gVar.DY()) {
            c0172a.aQl.setVisibility(0);
            String Eo3 = gVar.Eo();
            if (TextUtils.isEmpty(Eo3)) {
                c0172a.aQp.setText(a.i.ala_gift_draw_txt);
            } else {
                c0172a.aQp.setText(Eo3);
            }
            c0172a.aQp.setBackgroundResource(a.f.live_gift_panel_item_script_graffiti);
        } else if (gVar.DZ()) {
            c0172a.aQl.setVisibility(0);
            String Eo4 = gVar.Eo();
            if (TextUtils.isEmpty(Eo4)) {
                c0172a.aQp.setText(a.i.ala_gift_combo_txt);
            } else {
                c0172a.aQp.setText(Eo4);
            }
            c0172a.aQp.setBackgroundResource(a.f.live_gift_panel_item_script_graffiti);
        } else if (gVar.El()) {
            String Eo5 = gVar.Eo();
            if (TextUtils.isEmpty(Eo5)) {
                c0172a.aQp.setText(a.i.ala_gift_broadcast_txt);
            } else {
                c0172a.aQp.setText(Eo5);
            }
            c0172a.aQp.setBackgroundResource(a.f.live_gift_panel_item_script_broadcast);
        } else if (!TextUtils.isEmpty(gVar.Eo())) {
            String Eo6 = gVar.Eo();
            c0172a.aQl.setVisibility(0);
            c0172a.aQp.setText(Eo6);
            if ("活动".equals(Eo6)) {
                c0172a.aQp.setBackgroundResource(a.f.live_gift_panel_item_script_activity);
            } else if ("折扣".equals(Eo6)) {
                c0172a.aQp.setBackgroundResource(a.f.live_gift_panel_item_script_discount);
            } else if (Eo6 != null && Eo6.length() == 1) {
                c0172a.aQp.setBackgroundResource(a.f.live_gift_panel_item_script_new);
            } else {
                c0172a.aQp.setBackgroundResource(a.f.live_gift_panel_item_script_new_wide);
            }
        } else {
            c0172a.aQl.setVisibility(8);
        }
    }

    /* renamed from: com.baidu.live.gift.container.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0172a {
        public TbImageView aQk;
        public RelativeLayout aQl;
        public LinearLayout aQm;
        public TextView aQn;
        public TextView aQo;
        public TextView aQp;
        public TextView aQq;
        public View aQr;
        public LottieAnimationView aQs;
        public View aQt;
        public FrameLayout aQu;
        public ImageView aQv;
        public TextView aQw;
        public FrameLayout aQx;
        public TextView aQy;
        public AnimatorSet aQz;

        public void recycle() {
            if (this.aQs != null) {
                this.aQs.cancelAnimation();
            }
            FB();
        }

        public void Fz() {
            if (this.aQt != null) {
                this.aQt.setVisibility(0);
            }
            N(this.aQk);
        }

        public void FA() {
            if (this.aQt != null) {
                this.aQt.setVisibility(8);
            }
            FB();
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
            this.aQz = new AnimatorSet();
            this.aQz.play(ofFloat).with(ofFloat2);
            this.aQz.start();
        }

        public void FB() {
            if (this.aQz != null) {
                this.aQz.cancel();
                this.aQz = null;
            }
        }
    }

    private static String ab(long j) {
        if (aQc == null) {
            aQc = new SimpleDateFormat("MM.dd");
        }
        return aQc.format(Long.valueOf(1000 * j));
    }
}

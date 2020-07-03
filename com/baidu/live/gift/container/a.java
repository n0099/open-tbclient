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
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private static SimpleDateFormat aJr;
    private int aJs;
    private int aJt;
    private int aJu;
    private int aJv;
    private int aJw;
    private boolean aJx;
    private TbPageContext mContext;
    private int mType;
    private int aJo = -1;
    private int mSelectedPosition = -1;
    private boolean aJq = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.gift.container.a.1
        private void a(g gVar, C0165a c0165a) {
            com.baidu.live.gift.c fo;
            if (gVar.xX() && !com.baidu.live.gift.b.b.AH().eP(gVar.xM()) && (fo = com.baidu.live.gift.b.b.AH().fo(gVar.xM())) != null) {
                com.baidu.live.gift.b.a.a(fo.aGg, true);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view.getTag(a.g.TAG_GIFT_ITEM) instanceof g) && (view.getTag(a.g.TAG_GIFT_VIEW_HOLDER) instanceof C0165a)) {
                C0165a c0165a = (C0165a) view.getTag(a.g.TAG_GIFT_VIEW_HOLDER);
                g gVar = (g) view.getTag(a.g.TAG_GIFT_ITEM);
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(a.this.mContext.getPageActivity(), a.this.mContext.getString(a.i.sdk_neterror));
                } else {
                    a(gVar, c0165a);
                }
            }
        }
    };
    private List<g> aJp = Collections.synchronizedList(new ArrayList());

    public a(TbPageContext tbPageContext, int i) {
        this.mContext = tbPageContext;
        this.mType = i;
    }

    public void setGiftItems(List<g> list) {
        if (this.aJp == null) {
            this.aJp = Collections.synchronizedList(new ArrayList());
        } else {
            this.aJp.clear();
        }
        if (list != null) {
            this.aJp.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void z(String str, int i) {
        if (this.aJp != null) {
            for (g gVar : this.aJp) {
                if (gVar.aGH != null && gVar.xM().equals(str)) {
                    gVar.aGH.aGO = i;
                }
            }
            notifyDataSetChanged();
        }
    }

    public void bX(int i) {
        this.aJo = i;
    }

    public void bY(int i) {
        this.mSelectedPosition = i;
    }

    public int getSelectedPosition() {
        return this.mSelectedPosition;
    }

    public void bf(boolean z) {
        this.aJq = z;
    }

    public void bZ(int i) {
        this.aJs = i;
        float dimensionPixelOffset = (i * 1.0f) / this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds192);
        this.aJt = (int) (this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds100) * dimensionPixelOffset);
        this.aJu = (int) (this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds12) * dimensionPixelOffset);
        this.aJv = (int) (this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds8) * dimensionPixelOffset);
        this.aJw = (int) (dimensionPixelOffset * this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds4));
    }

    public void aR(boolean z) {
        this.aJx = z;
    }

    public void a(AbsListView absListView, boolean z) {
        int firstVisiblePosition;
        View childAt;
        this.aJx = z;
        int count = getCount();
        if (count != 0) {
            for (int i = 0; i < count; i++) {
                if (getItem(i).yk() && i >= (firstVisiblePosition = absListView.getFirstVisiblePosition()) && i <= absListView.getLastVisiblePosition() && (childAt = absListView.getChildAt(i - firstVisiblePosition)) != null) {
                    getView(i, childAt, absListView);
                }
            }
        }
    }

    public void a(AbsListView absListView, String str, String str2) {
        int count;
        int firstVisiblePosition;
        View childAt;
        com.baidu.live.gift.c fo;
        if (!TextUtils.isEmpty(str) && (count = getCount()) != 0) {
            int i = 0;
            while (true) {
                if (i >= count) {
                    i = -1;
                    break;
                }
                g item = getItem(i);
                if (item != null && !TextUtils.isEmpty(item.xM()) && (fo = com.baidu.live.gift.b.b.AH().fo(item.xM())) != null && !TextUtils.isEmpty(fo.getDynamicGiftId()) && fo.getDynamicGiftId().equals(str) && v.eY(item.xM()).equals(str2)) {
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
        if (this.aJp == null) {
            return 0;
        }
        return this.aJp.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ca */
    public g getItem(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.aJp.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0165a c0165a;
        g.a aVar;
        String formatGiftNumForTDouDisPlay;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.ala_gift_list_item, viewGroup, false);
            view.setBackgroundResource(a.f.sdk_transparent_bg);
            C0165a c0165a2 = new C0165a();
            c0165a2.aJz = (TbImageView) view.findViewById(a.g.gift_thumbnail);
            c0165a2.aJz.setDefaultBgResource(a.f.icon_live_gift_default);
            c0165a2.aJz.setDefaultErrorResource(a.f.icon_live_gift_default);
            c0165a2.aJz.setAutoChangeStyle(false);
            c0165a2.aJC = (TextView) view.findViewById(a.g.gift_name);
            c0165a2.aJD = (TextView) view.findViewById(a.g.gift_price);
            c0165a2.aJA = (RelativeLayout) view.findViewById(a.g.llCarom);
            c0165a2.aJE = (TextView) view.findViewById(a.g.gift_carom_txt);
            c0165a2.aJG = view.findViewById(a.g.in_progress);
            c0165a2.aJH = (LottieAnimationView) view.findViewById(a.g.lottie_downloading);
            c0165a2.aJH.loop(true);
            c0165a2.aJH.setAnimation("live_gift_panel_downloading.json");
            c0165a2.aJI = view.findViewById(a.g.selected_bg);
            c0165a2.aJF = (TextView) view.findViewById(a.g.tv_privilege);
            c0165a2.aJB = (LinearLayout) view.findViewById(a.g.ll_privilege);
            c0165a2.aJJ = (FrameLayout) view.findViewById(a.g.layout_pkg_count);
            c0165a2.aJK = (ImageView) view.findViewById(a.g.iv_pkg_count);
            c0165a2.aJL = (TextView) view.findViewById(a.g.tv_pkg_count);
            c0165a2.aJM = (FrameLayout) view.findViewById(a.g.layout_script);
            c0165a2.aJN = (TextView) view.findViewById(a.g.tv_script);
            view.setTag(c0165a2);
            if (this.aJs <= 0 || this.aJt <= 0) {
                c0165a = c0165a2;
            } else {
                view.getLayoutParams().height = this.aJs;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c0165a2.aJz.getLayoutParams();
                layoutParams.width = this.aJt;
                layoutParams.height = this.aJt;
                layoutParams.topMargin = this.aJu;
                ((RelativeLayout.LayoutParams) c0165a2.aJC.getLayoutParams()).topMargin = this.aJv;
                ((RelativeLayout.LayoutParams) c0165a2.aJD.getLayoutParams()).topMargin = this.aJw;
                c0165a = c0165a2;
            }
        } else {
            c0165a = (C0165a) view.getTag();
        }
        c0165a.zv();
        if (i == this.mSelectedPosition) {
            c0165a.zu();
        }
        g item = getItem(i);
        if (this.mType != 1) {
            aVar = null;
        } else {
            aVar = item.aGH;
        }
        if (item != null) {
            if (item.isRed()) {
                c0165a.aJz.setImageResource(a.f.live_gift_red_enter);
                c0165a.aJC.setText(this.mContext.getPageActivity().getString(a.i.sdk_red_pkt_send));
                c0165a.aJD.setText("");
            } else {
                c0165a.aJz.startLoad(item.getThumbnail_url(), 10, false);
                c0165a.aJC.setText(item.xN());
                if (this.mType == 0) {
                    double d = JavaTypesHelper.toDouble(String.valueOf(item.getPrice()), 0.0d);
                    if (d >= 100.0d && ((this.aJq || com.baidu.live.v.a.Hm().aZp.aAk) && !item.xW())) {
                        formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
                    } else {
                        formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(item.getPrice()));
                    }
                    c0165a.aJD.setText(formatGiftNumForTDouDisPlay);
                    if (item.xW()) {
                        c0165a.aJD.setText(this.mContext.getPageActivity().getString(a.i.ala_gift_price_flower_label, new Object[]{formatGiftNumForTDouDisPlay}));
                    } else {
                        c0165a.aJD.setText(this.mContext.getPageActivity().getString(a.i.ala_gift_price_tdou_label, new Object[]{formatGiftNumForTDouDisPlay}));
                    }
                } else if (this.mType == 1) {
                    if (aVar != null) {
                        c0165a.aJD.setText(aa(aVar.aGP) + " 失效");
                    } else {
                        c0165a.aJD.setText("");
                    }
                }
                c0165a.aJA.setClickable(false);
                c0165a.aJA.setVisibility(8);
                c0165a.aJE.setBackgroundColor(0);
                c0165a.aJB.setVisibility(8);
                c0165a.aJz.setAlpha(1.0f);
                c0165a.aJD.setAlpha(1.0f);
                c0165a.aJC.setAlpha(1.0f);
                c0165a.aJJ.setVisibility(8);
                c0165a.aJG.setVisibility(4);
                c0165a.aJH.cancelAnimation();
                if (this.mType == 0) {
                    if (item.yi()) {
                        c0165a.aJz.setAlpha(0.5f);
                        c0165a.aJD.setAlpha(0.5f);
                        c0165a.aJC.setAlpha(0.5f);
                        c0165a.aJA.setVisibility(8);
                        c0165a.aJB.setVisibility(0);
                        if (!TextUtils.isEmpty(item.yj())) {
                            c0165a.aJF.setText(item.yj());
                        } else {
                            c0165a.aJF.setText("");
                        }
                        String yj = item.yj();
                        if (item.xZ()) {
                            if (item.yb()) {
                                c0165a.aJB.setBackgroundResource(a.f.live_gift_item_script_lock_activity);
                            } else if (item.yc()) {
                                c0165a.aJB.setBackgroundResource(a.f.live_gift_item_script_lock_power);
                            } else {
                                c0165a.aJB.setBackgroundResource(a.f.live_gift_item_script_lock_level);
                            }
                        } else if (yj.equals("活动")) {
                            c0165a.aJB.setBackgroundResource(a.f.live_gift_item_script_lock_activity);
                        } else {
                            c0165a.aJB.setBackgroundResource(a.f.live_gift_item_script_lock_level);
                        }
                    } else if (item.xX()) {
                        c0165a.aJA.setVisibility(0);
                        if (!com.baidu.live.gift.b.b.AH().eP(item.xM())) {
                            c0165a.aJE.setText(" ");
                            c0165a.aJE.setBackgroundResource(a.f.live_gift_panel_item_script_download);
                            c0165a.aJA.setTag(a.g.TAG_GIFT_ITEM, item);
                            c0165a.aJA.setTag(a.g.TAG_GIFT_VIEW_HOLDER, c0165a);
                            c0165a.aJA.setClickable(true);
                            c0165a.aJA.setOnClickListener(this.mOnClickListener);
                            if (com.baidu.live.gift.b.a.ao(item.xM(), v.eY(item.xM()))) {
                                c0165a.aJz.setAlpha(0.5f);
                                c0165a.aJD.setAlpha(0.5f);
                                c0165a.aJC.setAlpha(0.5f);
                                c0165a.aJG.setVisibility(0);
                                c0165a.aJH.playAnimation();
                                c0165a.aJA.setVisibility(4);
                            } else {
                                c0165a.aJG.setVisibility(4);
                                c0165a.aJH.cancelAnimation();
                                c0165a.aJA.setVisibility(0);
                            }
                        } else {
                            a(c0165a, item);
                        }
                    } else {
                        a(c0165a, item);
                    }
                } else if (this.mType == 1 && aVar != null) {
                    if (aVar.aGO > 999) {
                        c0165a.aJK.setImageResource(a.f.live_icon_gift_panel_package_count_large);
                        c0165a.aJL.setText("999+");
                    } else {
                        c0165a.aJK.setImageResource(a.f.live_icon_gift_panel_package_count_small);
                        c0165a.aJL.setText(String.valueOf(aVar.aGO));
                    }
                    c0165a.aJJ.setVisibility(0);
                }
            }
        }
        return view;
    }

    private void a(C0165a c0165a, g gVar) {
        c0165a.aJG.setVisibility(4);
        c0165a.aJH.cancelAnimation();
        if (gVar.xZ()) {
            c0165a.aJA.setVisibility(0);
            String yj = gVar.yj();
            c0165a.aJE.setText(yj);
            if (gVar.yb()) {
                if (TextUtils.isEmpty(yj)) {
                    c0165a.aJE.setText(a.i.ala_gift_type_activity);
                }
                c0165a.aJE.setBackgroundResource(a.f.live_gift_panel_item_script_activity);
            } else if (gVar.ya()) {
                if (TextUtils.isEmpty(yj)) {
                    c0165a.aJE.setText(a.i.ala_gift_type_discount);
                }
                c0165a.aJE.setBackgroundResource(a.f.live_gift_panel_item_script_discount);
            } else if (gVar.yc()) {
                if (TextUtils.isEmpty(yj)) {
                    c0165a.aJE.setText(a.i.ala_gift_type_privilege);
                }
                c0165a.aJE.setBackgroundResource(a.f.live_gift_panel_item_script_power);
            } else if (gVar.ye()) {
                if (TextUtils.isEmpty(yj)) {
                    c0165a.aJE.setText(a.i.ala_gift_broadcast_txt);
                }
                c0165a.aJE.setBackgroundResource(a.f.live_gift_panel_item_script_broadcast);
            } else if (gVar.yd()) {
                if (TextUtils.isEmpty(yj)) {
                    c0165a.aJE.setText(a.i.ala_gift_draw_txt);
                }
                c0165a.aJE.setBackgroundResource(a.f.live_gift_panel_item_script_graffiti);
            } else if (gVar.yf()) {
                if (TextUtils.isEmpty(yj)) {
                    yj = this.mContext.getPageActivity().getString(a.i.ala_gift_type_new);
                    c0165a.aJE.setText(a.i.ala_gift_type_new);
                }
                if (yj != null && yj.length() == 1) {
                    c0165a.aJE.setBackgroundResource(a.f.live_gift_panel_item_script_new);
                } else {
                    c0165a.aJE.setBackgroundResource(a.f.live_gift_panel_item_script_new_wide);
                }
            } else {
                c0165a.aJA.setVisibility(8);
            }
        } else if (gVar.yl()) {
            c0165a.aJA.setVisibility(0);
            String yj2 = gVar.yj();
            if (TextUtils.isEmpty(yj2)) {
                c0165a.aJE.setText(a.i.ala_gift_privilege_level);
            } else {
                c0165a.aJE.setText(yj2);
            }
            c0165a.aJE.setBackgroundResource(a.f.live_gift_panel_item_script_level);
        } else if (gVar.yk() && !this.aJx) {
            c0165a.aJz.setAlpha(0.5f);
            c0165a.aJD.setAlpha(0.5f);
            c0165a.aJC.setAlpha(0.5f);
            c0165a.aJA.setVisibility(8);
            c0165a.aJB.setBackgroundResource(a.f.live_gift_item_script_lock_level);
            c0165a.aJB.setVisibility(0);
            c0165a.aJF.setText(a.i.ala_gift_privilege_throne);
        } else if (gVar.xT()) {
            c0165a.aJA.setVisibility(0);
            String yj3 = gVar.yj();
            if (TextUtils.isEmpty(yj3)) {
                c0165a.aJE.setText(a.i.ala_gift_draw_txt);
            } else {
                c0165a.aJE.setText(yj3);
            }
            c0165a.aJE.setBackgroundResource(a.f.live_gift_panel_item_script_graffiti);
        } else if (gVar.xU()) {
            c0165a.aJA.setVisibility(0);
            String yj4 = gVar.yj();
            if (TextUtils.isEmpty(yj4)) {
                c0165a.aJE.setText(a.i.ala_gift_combo_txt);
            } else {
                c0165a.aJE.setText(yj4);
            }
            c0165a.aJE.setBackgroundResource(a.f.live_gift_panel_item_script_graffiti);
        } else if (gVar.yg()) {
            String yj5 = gVar.yj();
            if (TextUtils.isEmpty(yj5)) {
                c0165a.aJE.setText(a.i.ala_gift_broadcast_txt);
            } else {
                c0165a.aJE.setText(yj5);
            }
            c0165a.aJE.setBackgroundResource(a.f.live_gift_panel_item_script_broadcast);
        } else if (!TextUtils.isEmpty(gVar.yj())) {
            String yj6 = gVar.yj();
            c0165a.aJA.setVisibility(0);
            c0165a.aJE.setText(yj6);
            if ("活动".equals(yj6)) {
                c0165a.aJE.setBackgroundResource(a.f.live_gift_panel_item_script_activity);
            } else if ("折扣".equals(yj6)) {
                c0165a.aJE.setBackgroundResource(a.f.live_gift_panel_item_script_discount);
            } else if (yj6 != null && yj6.length() == 1) {
                c0165a.aJE.setBackgroundResource(a.f.live_gift_panel_item_script_new);
            } else {
                c0165a.aJE.setBackgroundResource(a.f.live_gift_panel_item_script_new_wide);
            }
        } else {
            c0165a.aJA.setVisibility(8);
        }
    }

    /* renamed from: com.baidu.live.gift.container.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0165a {
        public RelativeLayout aJA;
        public LinearLayout aJB;
        public TextView aJC;
        public TextView aJD;
        public TextView aJE;
        public TextView aJF;
        public View aJG;
        public LottieAnimationView aJH;
        public View aJI;
        public FrameLayout aJJ;
        public ImageView aJK;
        public TextView aJL;
        public FrameLayout aJM;
        public TextView aJN;
        public AnimatorSet aJO;
        public TbImageView aJz;

        public void recycle() {
            if (this.aJH != null) {
                this.aJH.cancelAnimation();
            }
            zw();
        }

        public void zu() {
            if (this.aJI != null) {
                this.aJI.setVisibility(0);
            }
            K(this.aJz);
        }

        public void zv() {
            if (this.aJI != null) {
                this.aJI.setVisibility(8);
            }
            zw();
        }

        private void K(View view) {
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
            this.aJO = new AnimatorSet();
            this.aJO.play(ofFloat).with(ofFloat2);
            this.aJO.start();
        }

        public void zw() {
            if (this.aJO != null) {
                this.aJO.cancel();
                this.aJO = null;
            }
        }
    }

    private static String aa(long j) {
        if (aJr == null) {
            aJr = new SimpleDateFormat("MM.dd");
        }
        return aJr.format(Long.valueOf(1000 * j));
    }
}

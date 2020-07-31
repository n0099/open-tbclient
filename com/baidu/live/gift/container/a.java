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
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private static SimpleDateFormat aKN;
    private int aKO;
    private int aKP;
    private int aKQ;
    private int aKR;
    private int aKS;
    private boolean aKT;
    private TbPageContext mContext;
    private int mType;
    private int aKK = -1;
    private int mSelectedPosition = -1;
    private boolean aKM = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.gift.container.a.1
        private void a(g gVar, C0164a c0164a) {
            com.baidu.live.gift.c fn;
            if (gVar.yz() && !com.baidu.live.gift.b.b.Bj().eO(gVar.yo()) && (fn = com.baidu.live.gift.b.b.Bj().fn(gVar.yo())) != null) {
                com.baidu.live.gift.b.a.a(fn.aHB, true);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view.getTag(a.g.TAG_GIFT_ITEM) instanceof g) && (view.getTag(a.g.TAG_GIFT_VIEW_HOLDER) instanceof C0164a)) {
                C0164a c0164a = (C0164a) view.getTag(a.g.TAG_GIFT_VIEW_HOLDER);
                g gVar = (g) view.getTag(a.g.TAG_GIFT_ITEM);
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(a.this.mContext.getPageActivity(), a.this.mContext.getString(a.i.sdk_neterror));
                } else {
                    a(gVar, c0164a);
                }
            }
        }
    };
    private List<g> aKL = Collections.synchronizedList(new ArrayList());

    public a(TbPageContext tbPageContext, int i) {
        this.mContext = tbPageContext;
        this.mType = i;
    }

    public void setGiftItems(List<g> list) {
        if (this.aKL == null) {
            this.aKL = Collections.synchronizedList(new ArrayList());
        } else {
            this.aKL.clear();
        }
        if (list != null) {
            this.aKL.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void z(String str, int i) {
        if (this.aKL != null) {
            for (g gVar : this.aKL) {
                if (gVar.aIc != null && gVar.yo().equals(str)) {
                    gVar.aIc.aIj = i;
                }
            }
            notifyDataSetChanged();
        }
    }

    public void cd(int i) {
        this.aKK = i;
    }

    public void ce(int i) {
        this.mSelectedPosition = i;
    }

    public int getSelectedPosition() {
        return this.mSelectedPosition;
    }

    public void bi(boolean z) {
        this.aKM = z;
    }

    public void cf(int i) {
        this.aKO = i;
        float dimensionPixelOffset = (i * 1.0f) / this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds192);
        this.aKP = (int) (this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds100) * dimensionPixelOffset);
        this.aKQ = (int) (this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds12) * dimensionPixelOffset);
        this.aKR = (int) (this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds8) * dimensionPixelOffset);
        this.aKS = (int) (dimensionPixelOffset * this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds4));
    }

    public void aT(boolean z) {
        this.aKT = z;
    }

    public void a(AbsListView absListView, boolean z) {
        int firstVisiblePosition;
        View childAt;
        this.aKT = z;
        int count = getCount();
        if (count != 0) {
            for (int i = 0; i < count; i++) {
                if (getItem(i).yM() && i >= (firstVisiblePosition = absListView.getFirstVisiblePosition()) && i <= absListView.getLastVisiblePosition() && (childAt = absListView.getChildAt(i - firstVisiblePosition)) != null) {
                    getView(i, childAt, absListView);
                }
            }
        }
    }

    public void a(AbsListView absListView, String str, String str2) {
        int count;
        int firstVisiblePosition;
        View childAt;
        com.baidu.live.gift.c fn;
        if (!TextUtils.isEmpty(str) && (count = getCount()) != 0) {
            int i = 0;
            while (true) {
                if (i >= count) {
                    i = -1;
                    break;
                }
                g item = getItem(i);
                if (item != null && !TextUtils.isEmpty(item.yo()) && (fn = com.baidu.live.gift.b.b.Bj().fn(item.yo())) != null && !TextUtils.isEmpty(fn.getDynamicGiftId()) && fn.getDynamicGiftId().equals(str) && v.eX(item.yo()).equals(str2)) {
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
        if (this.aKL == null) {
            return 0;
        }
        return this.aKL.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: cg */
    public g getItem(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.aKL.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0164a c0164a;
        g.a aVar;
        String formatGiftNumForTDouDisPlay;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.ala_gift_list_item, viewGroup, false);
            view.setBackgroundResource(a.f.sdk_transparent_bg);
            C0164a c0164a2 = new C0164a();
            c0164a2.aKV = (TbImageView) view.findViewById(a.g.gift_thumbnail);
            c0164a2.aKV.setDefaultBgResource(a.f.icon_live_gift_default);
            c0164a2.aKV.setDefaultErrorResource(a.f.icon_live_gift_default);
            c0164a2.aKV.setAutoChangeStyle(false);
            c0164a2.aKY = (TextView) view.findViewById(a.g.gift_name);
            c0164a2.aKZ = (TextView) view.findViewById(a.g.gift_price);
            c0164a2.aKW = (RelativeLayout) view.findViewById(a.g.llCarom);
            c0164a2.aLa = (TextView) view.findViewById(a.g.gift_carom_txt);
            c0164a2.aLc = view.findViewById(a.g.in_progress);
            c0164a2.aLd = (LottieAnimationView) view.findViewById(a.g.lottie_downloading);
            c0164a2.aLd.loop(true);
            c0164a2.aLd.setAnimation("live_gift_panel_downloading.json");
            c0164a2.aLe = view.findViewById(a.g.selected_bg);
            c0164a2.aLb = (TextView) view.findViewById(a.g.tv_privilege);
            c0164a2.aKX = (LinearLayout) view.findViewById(a.g.ll_privilege);
            c0164a2.aLf = (FrameLayout) view.findViewById(a.g.layout_pkg_count);
            c0164a2.aLg = (ImageView) view.findViewById(a.g.iv_pkg_count);
            c0164a2.aLh = (TextView) view.findViewById(a.g.tv_pkg_count);
            c0164a2.aLi = (FrameLayout) view.findViewById(a.g.layout_script);
            c0164a2.aLj = (TextView) view.findViewById(a.g.tv_script);
            view.setTag(c0164a2);
            if (this.aKO <= 0 || this.aKP <= 0) {
                c0164a = c0164a2;
            } else {
                view.getLayoutParams().height = this.aKO;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c0164a2.aKV.getLayoutParams();
                layoutParams.width = this.aKP;
                layoutParams.height = this.aKP;
                layoutParams.topMargin = this.aKQ;
                ((RelativeLayout.LayoutParams) c0164a2.aKY.getLayoutParams()).topMargin = this.aKR;
                ((RelativeLayout.LayoutParams) c0164a2.aKZ.getLayoutParams()).topMargin = this.aKS;
                c0164a = c0164a2;
            }
        } else {
            c0164a = (C0164a) view.getTag();
        }
        c0164a.zX();
        if (i == this.mSelectedPosition) {
            c0164a.zW();
        }
        g item = getItem(i);
        if (this.mType != 1) {
            aVar = null;
        } else {
            aVar = item.aIc;
        }
        if (item != null) {
            if (item.isRed()) {
                c0164a.aKV.setImageResource(a.f.live_gift_red_enter);
                c0164a.aKY.setText(this.mContext.getPageActivity().getString(a.i.sdk_red_pkt_send));
                c0164a.aKZ.setText("");
            } else {
                c0164a.aKV.startLoad(item.getThumbnail_url(), 10, false);
                c0164a.aKY.setText(item.yp());
                if (this.mType == 0) {
                    double d = JavaTypesHelper.toDouble(String.valueOf(item.getPrice()), 0.0d);
                    if (d >= 100.0d && ((this.aKM || com.baidu.live.v.a.Hs().aZn.aBx) && !item.yy())) {
                        formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
                    } else {
                        formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(item.getPrice()));
                    }
                    c0164a.aKZ.setText(formatGiftNumForTDouDisPlay);
                    if (item.yy()) {
                        c0164a.aKZ.setText(this.mContext.getPageActivity().getString(a.i.ala_gift_price_flower_label, new Object[]{formatGiftNumForTDouDisPlay}));
                    } else {
                        c0164a.aKZ.setText(this.mContext.getPageActivity().getString(a.i.ala_gift_price_tdou_label, new Object[]{formatGiftNumForTDouDisPlay}));
                    }
                } else if (this.mType == 1) {
                    if (aVar != null) {
                        c0164a.aKZ.setText(aa(aVar.aIk) + " 失效");
                    } else {
                        c0164a.aKZ.setText("");
                    }
                }
                c0164a.aKW.setClickable(false);
                c0164a.aKW.setVisibility(8);
                c0164a.aLa.setBackgroundColor(0);
                c0164a.aKX.setVisibility(8);
                c0164a.aKV.setAlpha(1.0f);
                c0164a.aKZ.setAlpha(1.0f);
                c0164a.aKY.setAlpha(1.0f);
                c0164a.aLf.setVisibility(8);
                c0164a.aLc.setVisibility(4);
                c0164a.aLd.cancelAnimation();
                if (this.mType == 0) {
                    if (item.yK()) {
                        c0164a.aKV.setAlpha(0.5f);
                        c0164a.aKZ.setAlpha(0.5f);
                        c0164a.aKY.setAlpha(0.5f);
                        c0164a.aKW.setVisibility(8);
                        c0164a.aKX.setVisibility(0);
                        if (!TextUtils.isEmpty(item.yL())) {
                            c0164a.aLb.setText(item.yL());
                        } else {
                            c0164a.aLb.setText("");
                        }
                        String yL = item.yL();
                        if (item.yB()) {
                            if (item.yD()) {
                                c0164a.aKX.setBackgroundResource(a.f.live_gift_item_script_lock_activity);
                            } else if (item.yE()) {
                                c0164a.aKX.setBackgroundResource(a.f.live_gift_item_script_lock_power);
                            } else {
                                c0164a.aKX.setBackgroundResource(a.f.live_gift_item_script_lock_level);
                            }
                        } else if (yL.equals("活动")) {
                            c0164a.aKX.setBackgroundResource(a.f.live_gift_item_script_lock_activity);
                        } else {
                            c0164a.aKX.setBackgroundResource(a.f.live_gift_item_script_lock_level);
                        }
                    } else if (item.yz()) {
                        c0164a.aKW.setVisibility(0);
                        if (!com.baidu.live.gift.b.b.Bj().eO(item.yo())) {
                            c0164a.aLa.setText(" ");
                            c0164a.aLa.setBackgroundResource(a.f.live_gift_panel_item_script_download);
                            c0164a.aKW.setTag(a.g.TAG_GIFT_ITEM, item);
                            c0164a.aKW.setTag(a.g.TAG_GIFT_VIEW_HOLDER, c0164a);
                            c0164a.aKW.setClickable(true);
                            c0164a.aKW.setOnClickListener(this.mOnClickListener);
                            if (com.baidu.live.gift.b.a.an(item.yo(), v.eX(item.yo()))) {
                                c0164a.aKV.setAlpha(0.5f);
                                c0164a.aKZ.setAlpha(0.5f);
                                c0164a.aKY.setAlpha(0.5f);
                                c0164a.aLc.setVisibility(0);
                                c0164a.aLd.playAnimation();
                                c0164a.aKW.setVisibility(4);
                            } else {
                                c0164a.aLc.setVisibility(4);
                                c0164a.aLd.cancelAnimation();
                                c0164a.aKW.setVisibility(0);
                            }
                        } else {
                            a(c0164a, item);
                        }
                    } else {
                        a(c0164a, item);
                    }
                } else if (this.mType == 1 && aVar != null) {
                    if (aVar.aIj > 999) {
                        c0164a.aLg.setImageResource(a.f.live_icon_gift_panel_package_count_large);
                        c0164a.aLh.setText("999+");
                    } else {
                        c0164a.aLg.setImageResource(a.f.live_icon_gift_panel_package_count_small);
                        c0164a.aLh.setText(String.valueOf(aVar.aIj));
                    }
                    c0164a.aLf.setVisibility(0);
                }
            }
        }
        return view;
    }

    private void a(C0164a c0164a, g gVar) {
        c0164a.aLc.setVisibility(4);
        c0164a.aLd.cancelAnimation();
        if (gVar.yB()) {
            c0164a.aKW.setVisibility(0);
            String yL = gVar.yL();
            c0164a.aLa.setText(yL);
            if (gVar.yD()) {
                if (TextUtils.isEmpty(yL)) {
                    c0164a.aLa.setText(a.i.ala_gift_type_activity);
                }
                c0164a.aLa.setBackgroundResource(a.f.live_gift_panel_item_script_activity);
            } else if (gVar.yC()) {
                if (TextUtils.isEmpty(yL)) {
                    c0164a.aLa.setText(a.i.ala_gift_type_discount);
                }
                c0164a.aLa.setBackgroundResource(a.f.live_gift_panel_item_script_discount);
            } else if (gVar.yE()) {
                if (TextUtils.isEmpty(yL)) {
                    c0164a.aLa.setText(a.i.ala_gift_type_privilege);
                }
                c0164a.aLa.setBackgroundResource(a.f.live_gift_panel_item_script_power);
            } else if (gVar.yG()) {
                if (TextUtils.isEmpty(yL)) {
                    c0164a.aLa.setText(a.i.ala_gift_broadcast_txt);
                }
                c0164a.aLa.setBackgroundResource(a.f.live_gift_panel_item_script_broadcast);
            } else if (gVar.yF()) {
                if (TextUtils.isEmpty(yL)) {
                    c0164a.aLa.setText(a.i.ala_gift_draw_txt);
                }
                c0164a.aLa.setBackgroundResource(a.f.live_gift_panel_item_script_graffiti);
            } else if (gVar.yH()) {
                if (TextUtils.isEmpty(yL)) {
                    yL = this.mContext.getPageActivity().getString(a.i.ala_gift_type_new);
                    c0164a.aLa.setText(a.i.ala_gift_type_new);
                }
                if (yL != null && yL.length() == 1) {
                    c0164a.aLa.setBackgroundResource(a.f.live_gift_panel_item_script_new);
                } else {
                    c0164a.aLa.setBackgroundResource(a.f.live_gift_panel_item_script_new_wide);
                }
            } else {
                c0164a.aKW.setVisibility(8);
            }
        } else if (gVar.yN()) {
            c0164a.aKW.setVisibility(0);
            String yL2 = gVar.yL();
            if (TextUtils.isEmpty(yL2)) {
                c0164a.aLa.setText(a.i.ala_gift_privilege_level);
            } else {
                c0164a.aLa.setText(yL2);
            }
            c0164a.aLa.setBackgroundResource(a.f.live_gift_panel_item_script_level);
        } else if (gVar.yM() && !this.aKT) {
            c0164a.aKV.setAlpha(0.5f);
            c0164a.aKZ.setAlpha(0.5f);
            c0164a.aKY.setAlpha(0.5f);
            c0164a.aKW.setVisibility(8);
            c0164a.aKX.setBackgroundResource(a.f.live_gift_item_script_lock_level);
            c0164a.aKX.setVisibility(0);
            c0164a.aLb.setText(a.i.ala_gift_privilege_throne);
        } else if (gVar.yv()) {
            c0164a.aKW.setVisibility(0);
            String yL3 = gVar.yL();
            if (TextUtils.isEmpty(yL3)) {
                c0164a.aLa.setText(a.i.ala_gift_draw_txt);
            } else {
                c0164a.aLa.setText(yL3);
            }
            c0164a.aLa.setBackgroundResource(a.f.live_gift_panel_item_script_graffiti);
        } else if (gVar.yw()) {
            c0164a.aKW.setVisibility(0);
            String yL4 = gVar.yL();
            if (TextUtils.isEmpty(yL4)) {
                c0164a.aLa.setText(a.i.ala_gift_combo_txt);
            } else {
                c0164a.aLa.setText(yL4);
            }
            c0164a.aLa.setBackgroundResource(a.f.live_gift_panel_item_script_graffiti);
        } else if (gVar.yI()) {
            String yL5 = gVar.yL();
            if (TextUtils.isEmpty(yL5)) {
                c0164a.aLa.setText(a.i.ala_gift_broadcast_txt);
            } else {
                c0164a.aLa.setText(yL5);
            }
            c0164a.aLa.setBackgroundResource(a.f.live_gift_panel_item_script_broadcast);
        } else if (!TextUtils.isEmpty(gVar.yL())) {
            String yL6 = gVar.yL();
            c0164a.aKW.setVisibility(0);
            c0164a.aLa.setText(yL6);
            if ("活动".equals(yL6)) {
                c0164a.aLa.setBackgroundResource(a.f.live_gift_panel_item_script_activity);
            } else if ("折扣".equals(yL6)) {
                c0164a.aLa.setBackgroundResource(a.f.live_gift_panel_item_script_discount);
            } else if (yL6 != null && yL6.length() == 1) {
                c0164a.aLa.setBackgroundResource(a.f.live_gift_panel_item_script_new);
            } else {
                c0164a.aLa.setBackgroundResource(a.f.live_gift_panel_item_script_new_wide);
            }
        } else {
            c0164a.aKW.setVisibility(8);
        }
    }

    /* renamed from: com.baidu.live.gift.container.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0164a {
        public TbImageView aKV;
        public RelativeLayout aKW;
        public LinearLayout aKX;
        public TextView aKY;
        public TextView aKZ;
        public TextView aLa;
        public TextView aLb;
        public View aLc;
        public LottieAnimationView aLd;
        public View aLe;
        public FrameLayout aLf;
        public ImageView aLg;
        public TextView aLh;
        public FrameLayout aLi;
        public TextView aLj;
        public AnimatorSet aLk;

        public void recycle() {
            if (this.aLd != null) {
                this.aLd.cancelAnimation();
            }
            zY();
        }

        public void zW() {
            if (this.aLe != null) {
                this.aLe.setVisibility(0);
            }
            N(this.aKV);
        }

        public void zX() {
            if (this.aLe != null) {
                this.aLe.setVisibility(8);
            }
            zY();
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
            this.aLk = new AnimatorSet();
            this.aLk.play(ofFloat).with(ofFloat2);
            this.aLk.start();
        }

        public void zY() {
            if (this.aLk != null) {
                this.aLk.cancel();
                this.aLk = null;
            }
        }
    }

    private static String aa(long j) {
        if (aKN == null) {
            aKN = new SimpleDateFormat("MM.dd");
        }
        return aKN.format(Long.valueOf(1000 * j));
    }
}

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
    private static SimpleDateFormat aSe;
    private int aSf;
    private int aSg;
    private int aSh;
    private int aSi;
    private boolean aSj;
    private TbPageContext mContext;
    private int mType;
    private int aSb = -1;
    private int mSelectedPosition = -1;
    private boolean aSd = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.gift.container.a.1
        private void a(g gVar, C0174a c0174a) {
            com.baidu.live.gift.c gU;
            if (gVar.Es() && !com.baidu.live.gift.b.b.Hn().gt(gVar.Eh()) && (gU = com.baidu.live.gift.b.b.Hn().gU(gVar.Eh())) != null) {
                com.baidu.live.gift.b.a.a(gU.aOF, true);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view.getTag(a.g.TAG_GIFT_ITEM) instanceof g) && (view.getTag(a.g.TAG_GIFT_VIEW_HOLDER) instanceof C0174a)) {
                C0174a c0174a = (C0174a) view.getTag(a.g.TAG_GIFT_VIEW_HOLDER);
                g gVar = (g) view.getTag(a.g.TAG_GIFT_ITEM);
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(a.this.mContext.getPageActivity(), a.this.mContext.getString(a.i.sdk_neterror));
                } else {
                    a(gVar, c0174a);
                }
            }
        }
    };
    private List<g> aSc = Collections.synchronizedList(new ArrayList());

    public a(TbPageContext tbPageContext, int i) {
        this.mContext = tbPageContext;
        this.mType = i;
    }

    public void setGiftItems(List<g> list) {
        if (this.aSc == null) {
            this.aSc = Collections.synchronizedList(new ArrayList());
        } else {
            this.aSc.clear();
        }
        if (list != null) {
            this.aSc.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void A(String str, int i) {
        if (this.aSc != null) {
            for (g gVar : this.aSc) {
                if (gVar.aPi != null && gVar.Eh().equals(str)) {
                    gVar.aPi.aPv = i;
                }
            }
            notifyDataSetChanged();
        }
    }

    public void dW(int i) {
        this.aSb = i;
    }

    public void dX(int i) {
        this.mSelectedPosition = i;
    }

    public int getSelectedPosition() {
        return this.mSelectedPosition;
    }

    public void bo(boolean z) {
        this.aSd = z;
    }

    public void dY(int i) {
        this.aSf = i;
        float dimensionPixelOffset = (i * 1.0f) / this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds192);
        this.aSg = (int) (this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds100) * dimensionPixelOffset);
        this.aSh = (int) (this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds12) * dimensionPixelOffset);
        this.aSi = (int) (dimensionPixelOffset * this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds8));
    }

    public void aY(boolean z) {
        this.aSj = z;
    }

    public void a(AbsListView absListView, boolean z) {
        int firstVisiblePosition;
        View childAt;
        this.aSj = z;
        int count = getCount();
        if (count != 0) {
            for (int i = 0; i < count; i++) {
                if (getItem(i).EG() && i >= (firstVisiblePosition = absListView.getFirstVisiblePosition()) && i <= absListView.getLastVisiblePosition() && (childAt = absListView.getChildAt(i - firstVisiblePosition)) != null) {
                    getView(i, childAt, absListView);
                }
            }
        }
    }

    public void a(AbsListView absListView, String str, String str2) {
        int count;
        int firstVisiblePosition;
        View childAt;
        com.baidu.live.gift.c gU;
        if (!TextUtils.isEmpty(str) && (count = getCount()) != 0) {
            int i = 0;
            while (true) {
                if (i >= count) {
                    i = -1;
                    break;
                }
                g item = getItem(i);
                if (item != null && !TextUtils.isEmpty(item.Eh()) && (gU = com.baidu.live.gift.b.b.Hn().gU(item.Eh())) != null && !TextUtils.isEmpty(gU.getDynamicGiftId()) && gU.getDynamicGiftId().equals(str) && w.gD(item.Eh()).equals(str2)) {
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
        if (this.aSc == null) {
            return 0;
        }
        return this.aSc.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: dZ */
    public g getItem(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.aSc.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0174a c0174a;
        String formatGiftNumForTDouDisPlay;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.ala_gift_list_item, viewGroup, false);
            view.setBackgroundResource(a.f.sdk_transparent_bg);
            C0174a c0174a2 = new C0174a();
            c0174a2.aSl = (TbImageView) view.findViewById(a.g.gift_thumbnail);
            c0174a2.aSl.setDefaultBgResource(a.f.icon_live_gift_default);
            c0174a2.aSl.setDefaultErrorResource(a.f.icon_live_gift_default);
            c0174a2.aSl.setAutoChangeStyle(false);
            c0174a2.aSo = view.findViewById(a.g.layout_gift_item_name);
            c0174a2.aSp = (TextView) view.findViewById(a.g.gift_name);
            c0174a2.aSq = (TextView) view.findViewById(a.g.tv_gift_item_longpress_tip);
            c0174a2.aSr = (TextView) view.findViewById(a.g.gift_price);
            c0174a2.aSm = (RelativeLayout) view.findViewById(a.g.llCarom);
            c0174a2.aSs = (TextView) view.findViewById(a.g.gift_carom_txt);
            c0174a2.aSu = view.findViewById(a.g.in_progress);
            c0174a2.aSv = (LottieAnimationView) view.findViewById(a.g.lottie_downloading);
            c0174a2.aSv.loop(true);
            c0174a2.aSv.setAnimation("live_gift_panel_downloading.json");
            c0174a2.aSw = view.findViewById(a.g.selected_bg);
            c0174a2.aSt = (TextView) view.findViewById(a.g.tv_privilege);
            c0174a2.aSn = (LinearLayout) view.findViewById(a.g.ll_privilege);
            c0174a2.aSx = (FrameLayout) view.findViewById(a.g.layout_pkg_count);
            c0174a2.aSy = (ImageView) view.findViewById(a.g.iv_pkg_count);
            c0174a2.aSz = (TextView) view.findViewById(a.g.tv_pkg_count);
            c0174a2.aSA = (FrameLayout) view.findViewById(a.g.layout_script);
            c0174a2.aSB = (TextView) view.findViewById(a.g.tv_script);
            view.setTag(c0174a2);
            if (this.aSf <= 0 || this.aSg <= 0) {
                c0174a = c0174a2;
            } else {
                view.getLayoutParams().height = this.aSf;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c0174a2.aSl.getLayoutParams();
                layoutParams.width = this.aSg;
                layoutParams.height = this.aSg;
                layoutParams.topMargin = this.aSh;
                ((RelativeLayout.LayoutParams) c0174a2.aSo.getLayoutParams()).topMargin = this.aSi;
                c0174a = c0174a2;
            }
        } else {
            c0174a = (C0174a) view.getTag();
        }
        c0174a.Ga();
        if (i == this.mSelectedPosition) {
            c0174a.FZ();
        }
        g item = getItem(i);
        g.b bVar = null;
        if (this.mType == 1) {
            bVar = item.aPi;
        }
        c0174a.aSq.setTag(a.g.TAG_GIFT_ITEM, item);
        if (viewGroup.getChildCount() == i) {
            c0174a.aSq.setVisibility(4);
        }
        if (item != null) {
            if (item.isRed()) {
                c0174a.aSl.setImageResource(a.f.live_gift_red_enter);
                c0174a.aSp.setText(this.mContext.getPageActivity().getString(a.i.sdk_red_pkt_send));
                c0174a.aSr.setText("");
            } else {
                c0174a.aSl.startLoad(item.getThumbnail_url(), 10, false);
                c0174a.aSp.setText(item.Ei());
                if (this.mType == 0) {
                    double d = JavaTypesHelper.toDouble(String.valueOf(item.getPrice()), 0.0d);
                    if (d >= 100.0d && ((this.aSd || com.baidu.live.x.a.NN().bhy.aHY) && !item.Er())) {
                        formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
                    } else {
                        formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(item.getPrice()));
                    }
                    c0174a.aSr.setText(formatGiftNumForTDouDisPlay);
                    if (item.Er()) {
                        c0174a.aSr.setText(this.mContext.getPageActivity().getString(a.i.ala_gift_price_flower_label, new Object[]{formatGiftNumForTDouDisPlay}));
                    } else {
                        c0174a.aSr.setText(this.mContext.getPageActivity().getString(a.i.ala_gift_price_tdou_label, new Object[]{formatGiftNumForTDouDisPlay}));
                    }
                } else if (this.mType == 1) {
                    if (bVar != null) {
                        c0174a.aSr.setText(aa(bVar.aPw) + " 失效");
                    } else {
                        c0174a.aSr.setText("");
                    }
                }
                c0174a.aSm.setClickable(false);
                c0174a.aSm.setVisibility(8);
                c0174a.aSs.setBackgroundColor(0);
                c0174a.aSn.setVisibility(8);
                c0174a.aSl.setAlpha(1.0f);
                c0174a.aSr.setAlpha(1.0f);
                c0174a.aSp.setAlpha(1.0f);
                c0174a.aSx.setVisibility(8);
                c0174a.aSu.setVisibility(4);
                c0174a.aSv.cancelAnimation();
                if (this.mType == 0) {
                    if (item.EE()) {
                        c0174a.aSl.setAlpha(0.5f);
                        c0174a.aSr.setAlpha(0.5f);
                        c0174a.aSp.setAlpha(0.5f);
                        c0174a.aSm.setVisibility(8);
                        c0174a.aSn.setVisibility(0);
                        if (!TextUtils.isEmpty(item.EF())) {
                            c0174a.aSt.setText(item.EF());
                        } else {
                            c0174a.aSt.setText("");
                        }
                        String EF = item.EF();
                        if (item.Eu()) {
                            if (item.Ew()) {
                                c0174a.aSn.setBackgroundResource(a.f.live_gift_item_script_lock_activity);
                            } else if (item.Ex()) {
                                c0174a.aSn.setBackgroundResource(a.f.live_gift_item_script_lock_power);
                            } else {
                                c0174a.aSn.setBackgroundResource(a.f.live_gift_item_script_lock_level);
                            }
                        } else if (EF.equals("活动")) {
                            c0174a.aSn.setBackgroundResource(a.f.live_gift_item_script_lock_activity);
                        } else {
                            c0174a.aSn.setBackgroundResource(a.f.live_gift_item_script_lock_level);
                        }
                    } else if (item.Es()) {
                        c0174a.aSm.setVisibility(0);
                        if (!com.baidu.live.gift.b.b.Hn().gt(item.Eh())) {
                            c0174a.aSs.setText(" ");
                            c0174a.aSs.setBackgroundResource(a.f.live_gift_panel_item_script_download);
                            c0174a.aSm.setTag(a.g.TAG_GIFT_ITEM, item);
                            c0174a.aSm.setTag(a.g.TAG_GIFT_VIEW_HOLDER, c0174a);
                            c0174a.aSm.setClickable(true);
                            c0174a.aSm.setOnClickListener(this.mOnClickListener);
                            if (com.baidu.live.gift.b.a.ar(item.Eh(), w.gD(item.Eh()))) {
                                c0174a.aSl.setAlpha(0.5f);
                                c0174a.aSr.setAlpha(0.5f);
                                c0174a.aSp.setAlpha(0.5f);
                                c0174a.aSu.setVisibility(0);
                                c0174a.aSv.playAnimation();
                                c0174a.aSm.setVisibility(4);
                            } else {
                                c0174a.aSu.setVisibility(4);
                                c0174a.aSv.cancelAnimation();
                                c0174a.aSm.setVisibility(0);
                            }
                        } else {
                            a(c0174a, item);
                        }
                    } else {
                        a(c0174a, item);
                    }
                } else if (this.mType == 1 && bVar != null) {
                    if (bVar.aPv > 999) {
                        c0174a.aSy.setImageResource(a.f.live_icon_gift_panel_package_count_large);
                        c0174a.aSz.setText("999+");
                    } else {
                        c0174a.aSy.setImageResource(a.f.live_icon_gift_panel_package_count_small);
                        c0174a.aSz.setText(String.valueOf(bVar.aPv));
                    }
                    c0174a.aSx.setVisibility(0);
                }
            }
        }
        return view;
    }

    private void a(C0174a c0174a, g gVar) {
        c0174a.aSu.setVisibility(4);
        c0174a.aSv.cancelAnimation();
        if (gVar.Eu()) {
            c0174a.aSm.setVisibility(0);
            String EF = gVar.EF();
            c0174a.aSs.setText(EF);
            if (gVar.Ew()) {
                if (TextUtils.isEmpty(EF)) {
                    c0174a.aSs.setText(a.i.ala_gift_type_activity);
                }
                c0174a.aSs.setBackgroundResource(a.f.live_gift_panel_item_script_activity);
            } else if (gVar.Ev()) {
                if (TextUtils.isEmpty(EF)) {
                    c0174a.aSs.setText(a.i.ala_gift_type_discount);
                }
                c0174a.aSs.setBackgroundResource(a.f.live_gift_panel_item_script_discount);
            } else if (gVar.Ex()) {
                if (TextUtils.isEmpty(EF)) {
                    c0174a.aSs.setText(a.i.ala_gift_type_privilege);
                }
                c0174a.aSs.setBackgroundResource(a.f.live_gift_panel_item_script_power);
            } else if (gVar.Ez()) {
                if (TextUtils.isEmpty(EF)) {
                    c0174a.aSs.setText(a.i.ala_gift_broadcast_txt);
                }
                c0174a.aSs.setBackgroundResource(a.f.live_gift_panel_item_script_broadcast);
            } else if (gVar.Ey()) {
                if (TextUtils.isEmpty(EF)) {
                    c0174a.aSs.setText(a.i.ala_gift_draw_txt);
                }
                c0174a.aSs.setBackgroundResource(a.f.live_gift_panel_item_script_graffiti);
            } else if (gVar.EB()) {
                if (TextUtils.isEmpty(EF)) {
                    EF = this.mContext.getPageActivity().getString(a.i.ala_gift_type_new);
                    c0174a.aSs.setText(a.i.ala_gift_type_new);
                }
                if (EF != null && EF.length() == 1) {
                    c0174a.aSs.setBackgroundResource(a.f.live_gift_panel_item_script_new);
                } else {
                    c0174a.aSs.setBackgroundResource(a.f.live_gift_panel_item_script_new_wide);
                }
            } else {
                c0174a.aSm.setVisibility(8);
            }
        } else if (gVar.EH()) {
            c0174a.aSm.setVisibility(0);
            String EF2 = gVar.EF();
            if (TextUtils.isEmpty(EF2)) {
                c0174a.aSs.setText(a.i.ala_gift_privilege_level);
            } else {
                c0174a.aSs.setText(EF2);
            }
            c0174a.aSs.setBackgroundResource(a.f.live_gift_panel_item_script_level);
        } else if (gVar.EG() && !this.aSj) {
            c0174a.aSl.setAlpha(0.5f);
            c0174a.aSr.setAlpha(0.5f);
            c0174a.aSp.setAlpha(0.5f);
            c0174a.aSm.setVisibility(8);
            c0174a.aSn.setBackgroundResource(a.f.live_gift_item_script_lock_level);
            c0174a.aSn.setVisibility(0);
            c0174a.aSt.setText(a.i.ala_gift_privilege_throne);
        } else if (gVar.Eo()) {
            c0174a.aSm.setVisibility(0);
            String EF3 = gVar.EF();
            if (TextUtils.isEmpty(EF3)) {
                c0174a.aSs.setText(a.i.ala_gift_draw_txt);
            } else {
                c0174a.aSs.setText(EF3);
            }
            c0174a.aSs.setBackgroundResource(a.f.live_gift_panel_item_script_graffiti);
        } else if (gVar.Ep()) {
            c0174a.aSm.setVisibility(0);
            String EF4 = gVar.EF();
            if (TextUtils.isEmpty(EF4)) {
                c0174a.aSs.setText(a.i.ala_gift_combo_txt);
            } else {
                c0174a.aSs.setText(EF4);
            }
            c0174a.aSs.setBackgroundResource(a.f.live_gift_panel_item_script_graffiti);
        } else if (gVar.EC()) {
            String EF5 = gVar.EF();
            if (TextUtils.isEmpty(EF5)) {
                c0174a.aSs.setText(a.i.ala_gift_broadcast_txt);
            } else {
                c0174a.aSs.setText(EF5);
            }
            c0174a.aSs.setBackgroundResource(a.f.live_gift_panel_item_script_broadcast);
        } else if (!TextUtils.isEmpty(gVar.EF())) {
            String EF6 = gVar.EF();
            c0174a.aSm.setVisibility(0);
            c0174a.aSs.setText(EF6);
            if ("活动".equals(EF6)) {
                c0174a.aSs.setBackgroundResource(a.f.live_gift_panel_item_script_activity);
            } else if ("折扣".equals(EF6)) {
                c0174a.aSs.setBackgroundResource(a.f.live_gift_panel_item_script_discount);
            } else if (EF6 != null && EF6.length() == 1) {
                c0174a.aSs.setBackgroundResource(a.f.live_gift_panel_item_script_new);
            } else {
                c0174a.aSs.setBackgroundResource(a.f.live_gift_panel_item_script_new_wide);
            }
        } else {
            c0174a.aSm.setVisibility(8);
        }
    }

    /* renamed from: com.baidu.live.gift.container.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0174a {
        public FrameLayout aSA;
        public TextView aSB;
        public AnimatorSet aSC;
        public TbImageView aSl;
        public RelativeLayout aSm;
        public LinearLayout aSn;
        public View aSo;
        public TextView aSp;
        public TextView aSq;
        public TextView aSr;
        public TextView aSs;
        public TextView aSt;
        public View aSu;
        public LottieAnimationView aSv;
        public View aSw;
        public FrameLayout aSx;
        public ImageView aSy;
        public TextView aSz;

        public void recycle() {
            if (this.aSv != null) {
                this.aSv.cancelAnimation();
            }
            Gb();
        }

        public void FZ() {
            if (this.aSw != null) {
                this.aSw.setVisibility(0);
            }
            N(this.aSl);
        }

        public void Ga() {
            if (this.aSw != null) {
                this.aSw.setVisibility(8);
            }
            Gb();
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
            this.aSC = new AnimatorSet();
            this.aSC.play(ofFloat).with(ofFloat2);
            this.aSC.start();
        }

        public void Gb() {
            if (this.aSC != null) {
                this.aSC.cancel();
                this.aSC = null;
            }
        }
    }

    private static String aa(long j) {
        if (aSe == null) {
            aSe = new SimpleDateFormat("MM.dd");
        }
        return aSe.format(Long.valueOf(1000 * j));
    }
}

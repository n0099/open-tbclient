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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private static SimpleDateFormat agG;
    private int agH;
    private int agI;
    private int agJ;
    private boolean agK;
    private TbPageContext mContext;
    private int mType;
    private int agD = -1;
    private int mSelectedPosition = -1;
    private boolean agF = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.gift.container.a.1
        private void a(g gVar, C0078a c0078a) {
            com.baidu.live.gift.c dw;
            if ((gVar.qQ() || gVar.qR()) && !com.baidu.live.gift.b.b.ta().dc(gVar.qE()) && (dw = com.baidu.live.gift.b.b.ta().dw(gVar.qE())) != null) {
                com.baidu.live.gift.b.a.b(dw.getDynamicGiftId(), dw.adJ.adH.zipDownloadUrl, dw.adJ.adH.zipName, dw.adJ.adH.zipMD5, true);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view.getTag(a.g.TAG_GIFT_ITEM) instanceof g) && (view.getTag(a.g.TAG_GIFT_VIEW_HOLDER) instanceof C0078a)) {
                C0078a c0078a = (C0078a) view.getTag(a.g.TAG_GIFT_VIEW_HOLDER);
                g gVar = (g) view.getTag(a.g.TAG_GIFT_ITEM);
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(a.this.mContext.getPageActivity(), a.this.mContext.getString(a.i.sdk_neterror));
                } else {
                    a(gVar, c0078a);
                }
            }
        }
    };
    private List<g> agE = Collections.synchronizedList(new ArrayList());

    public a(TbPageContext tbPageContext, int i) {
        this.mContext = tbPageContext;
        this.mType = i;
    }

    public void setGiftItems(List<g> list) {
        if (this.agE == null) {
            this.agE = Collections.synchronizedList(new ArrayList());
        } else {
            this.agE.clear();
        }
        if (list != null) {
            this.agE.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void p(String str, int i) {
        if (this.agE != null) {
            for (g gVar : this.agE) {
                if (gVar.aeg != null && gVar.qE().equals(str)) {
                    gVar.aeg.aen = i;
                }
            }
            notifyDataSetChanged();
        }
    }

    public void bo(int i) {
        this.agD = i;
    }

    public void bp(int i) {
        this.mSelectedPosition = i;
    }

    public int getSelectedPosition() {
        return this.mSelectedPosition;
    }

    public void az(boolean z) {
        this.agF = z;
    }

    public void bq(int i) {
        this.agH = i;
        float dimensionPixelOffset = (i * 1.0f) / this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds192);
        this.agI = (int) (this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds100) * dimensionPixelOffset);
        this.agJ = (int) (dimensionPixelOffset * this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds18));
    }

    public void an(boolean z) {
        this.agK = z;
    }

    public void a(AbsListView absListView, boolean z) {
        int firstVisiblePosition;
        View childAt;
        this.agK = z;
        int count = getCount();
        if (count != 0) {
            for (int i = 0; i < count; i++) {
                if (getItem(i).qV() && i >= (firstVisiblePosition = absListView.getFirstVisiblePosition()) && i <= absListView.getLastVisiblePosition() && (childAt = absListView.getChildAt(i - firstVisiblePosition)) != null) {
                    getView(i, childAt, absListView);
                }
            }
        }
    }

    public void a(AbsListView absListView, String str) {
        int count;
        int firstVisiblePosition;
        View childAt;
        com.baidu.live.gift.c dw;
        if (!TextUtils.isEmpty(str) && (count = getCount()) != 0) {
            int i = 0;
            while (true) {
                if (i >= count) {
                    i = -1;
                    break;
                }
                g item = getItem(i);
                if (item != null && !TextUtils.isEmpty(item.qE()) && (dw = com.baidu.live.gift.b.b.ta().dw(item.qE())) != null && !TextUtils.isEmpty(dw.getDynamicGiftId()) && dw.getDynamicGiftId().equals(str)) {
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
        if (this.agE == null) {
            return 0;
        }
        return this.agE.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: br */
    public g getItem(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.agE.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0078a c0078a;
        g.a aVar;
        String formatGiftNumForTDouDisPlay;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.ala_gift_list_item, viewGroup, false);
            view.setBackgroundResource(a.f.sdk_transparent_bg);
            C0078a c0078a2 = new C0078a();
            c0078a2.agM = (TbImageView) view.findViewById(a.g.gift_thumbnail);
            c0078a2.agM.setDefaultBgResource(a.f.icon_live_gift_default);
            c0078a2.agM.setDefaultErrorResource(a.f.icon_live_gift_default);
            c0078a2.agM.setAutoChangeStyle(false);
            c0078a2.agP = (TextView) view.findViewById(a.g.gift_name);
            c0078a2.agQ = (TextView) view.findViewById(a.g.gift_price);
            c0078a2.agN = (RelativeLayout) view.findViewById(a.g.llCarom);
            c0078a2.agR = (TextView) view.findViewById(a.g.gift_carom_txt);
            c0078a2.agT = view.findViewById(a.g.in_progress);
            c0078a2.agU = (LottieAnimationView) view.findViewById(a.g.lottie_downloading);
            c0078a2.agU.loop(true);
            c0078a2.agU.setAnimation("live_gift_panel_downloading.json");
            c0078a2.agV = view.findViewById(a.g.selected_bg);
            c0078a2.agS = (TextView) view.findViewById(a.g.tv_privilege);
            c0078a2.agO = (LinearLayout) view.findViewById(a.g.ll_privilege);
            c0078a2.agW = (FrameLayout) view.findViewById(a.g.layout_pkg_count);
            c0078a2.agX = (ImageView) view.findViewById(a.g.iv_pkg_count);
            c0078a2.agY = (TextView) view.findViewById(a.g.tv_pkg_count);
            c0078a2.agZ = (FrameLayout) view.findViewById(a.g.layout_script);
            c0078a2.aha = (TextView) view.findViewById(a.g.tv_script);
            view.setTag(c0078a2);
            if (this.agH <= 0 || this.agI <= 0) {
                c0078a = c0078a2;
            } else {
                view.getLayoutParams().height = this.agH;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c0078a2.agM.getLayoutParams();
                layoutParams.width = this.agI;
                layoutParams.height = this.agI;
                layoutParams.topMargin = this.agJ;
                c0078a = c0078a2;
            }
        } else {
            c0078a = (C0078a) view.getTag();
        }
        c0078a.sa();
        if (i == this.mSelectedPosition) {
            c0078a.rZ();
        }
        g item = getItem(i);
        if (this.mType != 1) {
            aVar = null;
        } else {
            aVar = item.aeg;
        }
        if (item != null) {
            if (item.isRed()) {
                c0078a.agM.setImageResource(a.f.live_gift_red_enter);
                c0078a.agP.setText(this.mContext.getPageActivity().getString(a.i.sdk_red_pkt_send));
                c0078a.agQ.setText("");
            } else {
                c0078a.agM.startLoad(item.qH(), 10, false);
                c0078a.agP.setText(item.qF());
                if (this.mType == 0) {
                    double d = JavaTypesHelper.toDouble(String.valueOf(item.getPrice()), 0.0d);
                    if (d >= 100.0d && ((this.agF || com.baidu.live.s.a.wR().asq.Yy) && !item.qP())) {
                        formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
                    } else {
                        formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(item.getPrice()));
                    }
                    c0078a.agQ.setText(formatGiftNumForTDouDisPlay);
                    if (item.qP()) {
                        c0078a.agQ.setText(formatGiftNumForTDouDisPlay + " 花瓣");
                    } else {
                        c0078a.agQ.setText(formatGiftNumForTDouDisPlay + " T豆");
                    }
                } else if (this.mType == 1) {
                    if (aVar != null) {
                        c0078a.agQ.setText(x(aVar.aeo) + " 失效");
                    } else {
                        c0078a.agQ.setText("");
                    }
                }
                c0078a.agN.setClickable(false);
                c0078a.agO.setVisibility(8);
                c0078a.agM.setAlpha(1.0f);
                c0078a.agQ.setAlpha(1.0f);
                c0078a.agP.setAlpha(1.0f);
                c0078a.agW.setVisibility(8);
                c0078a.agT.setVisibility(4);
                c0078a.agU.cancelAnimation();
                if (this.mType == 0) {
                    if (item.qT()) {
                        c0078a.agM.setAlpha(0.5f);
                        c0078a.agQ.setAlpha(0.5f);
                        c0078a.agP.setAlpha(0.5f);
                        c0078a.agN.setVisibility(8);
                        c0078a.agO.setVisibility(0);
                        if (!TextUtils.isEmpty(item.qU())) {
                            c0078a.agS.setText(item.qU());
                        } else {
                            c0078a.agS.setText("");
                        }
                        String qU = item.qU();
                        if (qU.equals("等级")) {
                            c0078a.agO.setBackgroundResource(a.f.live_gift_item_script_lock_level);
                        } else if (qU.equals("活动")) {
                            c0078a.agO.setBackgroundResource(a.f.live_gift_item_script_lock_activity);
                        } else {
                            c0078a.agO.setBackgroundResource(a.f.live_gift_item_script_lock_level);
                        }
                    } else if (item.qW()) {
                        c0078a.agN.setVisibility(0);
                        c0078a.agR.setText(a.i.ala_gift_privilege_level);
                        c0078a.agR.setBackgroundResource(a.f.live_gift_panel_item_script_level);
                    } else if (item.qV() && !this.agK) {
                        c0078a.agM.setAlpha(0.5f);
                        c0078a.agQ.setAlpha(0.5f);
                        c0078a.agP.setAlpha(0.5f);
                        c0078a.agN.setVisibility(8);
                        c0078a.agO.setBackgroundResource(a.f.live_gift_item_script_lock_level);
                        c0078a.agO.setVisibility(0);
                        c0078a.agS.setText("王座");
                    } else if (item.qM()) {
                        c0078a.agN.setVisibility(0);
                        c0078a.agR.setText(a.i.ala_gift_draw_txt);
                        c0078a.agR.setBackgroundResource(a.f.live_gift_panel_item_script_graffiti);
                    } else if (item.qN()) {
                        c0078a.agN.setVisibility(0);
                        c0078a.agR.setText(a.i.ala_gift_combo_txt);
                        c0078a.agR.setBackgroundResource(a.f.live_gift_panel_item_script_graffiti);
                    } else if (item.qQ() || item.qR()) {
                        c0078a.agN.setVisibility(0);
                        if (!com.baidu.live.gift.b.b.ta().dc(item.qE())) {
                            c0078a.agR.setText(HanziToPinyin.Token.SEPARATOR);
                            c0078a.agR.setBackgroundResource(a.f.live_gift_panel_item_script_download);
                            c0078a.agN.setTag(a.g.TAG_GIFT_ITEM, item);
                            c0078a.agN.setTag(a.g.TAG_GIFT_VIEW_HOLDER, c0078a);
                            c0078a.agN.setClickable(true);
                            c0078a.agN.setOnClickListener(this.mOnClickListener);
                            if (com.baidu.live.gift.b.a.dv(item.qE())) {
                                c0078a.agM.setAlpha(0.5f);
                                c0078a.agQ.setAlpha(0.5f);
                                c0078a.agP.setAlpha(0.5f);
                                c0078a.agT.setVisibility(0);
                                c0078a.agU.playAnimation();
                                c0078a.agN.setVisibility(4);
                            } else {
                                c0078a.agT.setVisibility(4);
                                c0078a.agU.cancelAnimation();
                                c0078a.agN.setVisibility(0);
                            }
                        } else if (item.qR()) {
                            c0078a.agR.setText(a.i.ala_gift_broadcast_txt);
                            c0078a.agR.setBackgroundResource(a.f.live_gift_panel_item_script_broadcast);
                            c0078a.agT.setVisibility(4);
                            c0078a.agU.cancelAnimation();
                        } else if (!TextUtils.isEmpty(item.qU())) {
                            String qU2 = item.qU();
                            c0078a.agR.setText(qU2);
                            char c = 65535;
                            switch (qU2.hashCode()) {
                                case 807627:
                                    if (qU2.equals("折扣")) {
                                        c = 1;
                                        break;
                                    }
                                    break;
                                case 888013:
                                    if (qU2.equals("活动")) {
                                        c = 0;
                                        break;
                                    }
                                    break;
                            }
                            switch (c) {
                                case 0:
                                    c0078a.agR.setBackgroundResource(a.f.live_gift_panel_item_script_activity);
                                    break;
                                case 1:
                                    c0078a.agR.setBackgroundResource(a.f.live_gift_panel_item_script_discount);
                                    break;
                                default:
                                    if (qU2.length() == 1) {
                                        c0078a.agR.setBackgroundResource(a.f.live_gift_panel_item_script_new);
                                        break;
                                    } else {
                                        c0078a.agR.setBackgroundResource(a.f.live_gift_panel_item_script_new_wide);
                                        break;
                                    }
                            }
                            c0078a.agT.setVisibility(4);
                            c0078a.agU.cancelAnimation();
                        } else {
                            c0078a.agN.setVisibility(8);
                            c0078a.agT.setVisibility(4);
                            c0078a.agU.cancelAnimation();
                        }
                    } else if (!TextUtils.isEmpty(item.qU())) {
                        c0078a.agN.setVisibility(0);
                        c0078a.agT.setVisibility(4);
                        c0078a.agU.cancelAnimation();
                        String qU3 = item.qU();
                        c0078a.agR.setText(qU3);
                        char c2 = 65535;
                        switch (qU3.hashCode()) {
                            case 807627:
                                if (qU3.equals("折扣")) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                            case 888013:
                                if (qU3.equals("活动")) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                        }
                        switch (c2) {
                            case 0:
                                c0078a.agR.setBackgroundResource(a.f.live_gift_panel_item_script_activity);
                                break;
                            case 1:
                                c0078a.agR.setBackgroundResource(a.f.live_gift_panel_item_script_discount);
                                break;
                            default:
                                if (qU3.length() == 1) {
                                    c0078a.agR.setBackgroundResource(a.f.live_gift_panel_item_script_new);
                                    break;
                                } else {
                                    c0078a.agR.setBackgroundResource(a.f.live_gift_panel_item_script_new_wide);
                                    break;
                                }
                        }
                    } else {
                        c0078a.agN.setVisibility(8);
                    }
                } else if (this.mType == 1 && aVar != null) {
                    if (aVar.aen > 999) {
                        c0078a.agX.setImageResource(a.f.live_icon_gift_panel_package_count_large);
                        c0078a.agY.setText("999+");
                    } else {
                        c0078a.agX.setImageResource(a.f.live_icon_gift_panel_package_count_small);
                        c0078a.agY.setText(String.valueOf(aVar.aen));
                    }
                    c0078a.agW.setVisibility(0);
                }
            }
        }
        return view;
    }

    /* renamed from: com.baidu.live.gift.container.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0078a {
        public TbImageView agM;
        public RelativeLayout agN;
        public LinearLayout agO;
        public TextView agP;
        public TextView agQ;
        public TextView agR;
        public TextView agS;
        public View agT;
        public LottieAnimationView agU;
        public View agV;
        public FrameLayout agW;
        public ImageView agX;
        public TextView agY;
        public FrameLayout agZ;
        public TextView aha;
        public AnimatorSet ahb;

        public void recycle() {
            if (this.agU != null) {
                this.agU.cancelAnimation();
            }
            sb();
        }

        public void rZ() {
            if (this.agV != null) {
                this.agV.setVisibility(0);
            }
            L(this.agM);
        }

        public void sa() {
            if (this.agV != null) {
                this.agV.setVisibility(8);
            }
            sb();
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
            this.ahb = new AnimatorSet();
            this.ahb.play(ofFloat).with(ofFloat2);
            this.ahb.start();
        }

        public void sb() {
            if (this.ahb != null) {
                this.ahb.cancel();
                this.ahb = null;
            }
        }
    }

    private static String x(long j) {
        if (agG == null) {
            agG = new SimpleDateFormat("MM.dd");
        }
        return agG.format(Long.valueOf(1000 * j));
    }
}

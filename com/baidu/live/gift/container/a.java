package com.baidu.live.gift.container;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.live.q.a;
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
    private static SimpleDateFormat afW;
    private int afX;
    private int afY;
    private int afZ;
    private boolean aga;
    private TbPageContext mContext;
    private int mType;
    private int afT = -1;
    private int mSelectedPosition = -1;
    private boolean afV = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.gift.container.a.1
        private void a(g gVar, C0078a c0078a) {
            com.baidu.live.gift.c du;
            if ((gVar.qJ() || gVar.qK()) && !com.baidu.live.gift.b.b.sK().da(gVar.qx()) && (du = com.baidu.live.gift.b.b.sK().du(gVar.qx())) != null) {
                com.baidu.live.gift.b.a.b(du.getDynamicGiftId(), du.adu.ads.zipDownloadUrl, du.adu.ads.zipName, du.adu.ads.zipMD5, true);
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
    private List<g> afU = Collections.synchronizedList(new ArrayList());

    public a(TbPageContext tbPageContext, int i) {
        this.mContext = tbPageContext;
        this.mType = i;
    }

    public void setGiftItems(List<g> list) {
        if (this.afU == null) {
            this.afU = Collections.synchronizedList(new ArrayList());
        } else {
            this.afU.clear();
        }
        if (list != null) {
            this.afU.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void p(String str, int i) {
        if (this.afU != null) {
            for (g gVar : this.afU) {
                if (gVar.adR != null && gVar.qx().equals(str)) {
                    gVar.adR.adY = i;
                }
            }
            notifyDataSetChanged();
        }
    }

    public void bo(int i) {
        this.afT = i;
    }

    public void bp(int i) {
        this.mSelectedPosition = i;
    }

    public int getSelectedPosition() {
        return this.mSelectedPosition;
    }

    public void ax(boolean z) {
        this.afV = z;
    }

    public void bq(int i) {
        this.afX = i;
        float dimensionPixelOffset = (i * 1.0f) / this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds192);
        this.afY = (int) (this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds100) * dimensionPixelOffset);
        this.afZ = (int) (dimensionPixelOffset * this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds18));
    }

    public void an(boolean z) {
        this.aga = z;
    }

    public void a(AbsListView absListView, boolean z) {
        int firstVisiblePosition;
        View childAt;
        this.aga = z;
        int count = getCount();
        if (count != 0) {
            for (int i = 0; i < count; i++) {
                if (getItem(i).qO() && i >= (firstVisiblePosition = absListView.getFirstVisiblePosition()) && i <= absListView.getLastVisiblePosition() && (childAt = absListView.getChildAt(i - firstVisiblePosition)) != null) {
                    getView(i, childAt, absListView);
                }
            }
        }
    }

    public void a(AbsListView absListView, String str) {
        int count;
        int firstVisiblePosition;
        View childAt;
        com.baidu.live.gift.c du;
        if (!TextUtils.isEmpty(str) && (count = getCount()) != 0) {
            int i = 0;
            while (true) {
                if (i >= count) {
                    i = -1;
                    break;
                }
                g item = getItem(i);
                if (item != null && !TextUtils.isEmpty(item.qx()) && (du = com.baidu.live.gift.b.b.sK().du(item.qx())) != null && !TextUtils.isEmpty(du.getDynamicGiftId()) && du.getDynamicGiftId().equals(str)) {
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
        if (this.afU == null) {
            return 0;
        }
        return this.afU.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: br */
    public g getItem(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.afU.get(i);
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
            c0078a2.agc = (TbImageView) view.findViewById(a.g.gift_thumbnail);
            c0078a2.agc.setDefaultBgResource(a.f.icon_live_gift_default);
            c0078a2.agc.setDefaultErrorResource(a.f.icon_live_gift_default);
            c0078a2.agc.setAutoChangeStyle(false);
            c0078a2.agg = (TextView) view.findViewById(a.g.gift_name);
            c0078a2.agh = (TextView) view.findViewById(a.g.gift_price);
            c0078a2.agd = (RelativeLayout) view.findViewById(a.g.llCarom);
            c0078a2.agi = (TextView) view.findViewById(a.g.gift_carom_txt);
            c0078a2.agk = view.findViewById(a.g.in_progress);
            c0078a2.agl = (LottieAnimationView) view.findViewById(a.g.lottie_downloading);
            c0078a2.agl.loop(true);
            c0078a2.agl.setAnimation("live_gift_panel_downloading.json");
            c0078a2.agm = view.findViewById(a.g.selected_bg);
            c0078a2.agj = (TextView) view.findViewById(a.g.tv_privilege);
            c0078a2.agf = (LinearLayout) view.findViewById(a.g.ll_privilege);
            c0078a2.agn = (FrameLayout) view.findViewById(a.g.layout_pkg_count);
            c0078a2.ago = (ImageView) view.findViewById(a.g.iv_pkg_count);
            c0078a2.agp = (TextView) view.findViewById(a.g.tv_pkg_count);
            c0078a2.agq = (FrameLayout) view.findViewById(a.g.layout_script);
            c0078a2.agr = (TextView) view.findViewById(a.g.tv_script);
            view.setTag(c0078a2);
            if (this.afX <= 0 || this.afY <= 0) {
                c0078a = c0078a2;
            } else {
                view.getLayoutParams().height = this.afX;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c0078a2.agc.getLayoutParams();
                layoutParams.width = this.afY;
                layoutParams.height = this.afY;
                layoutParams.topMargin = this.afZ;
                c0078a = c0078a2;
            }
        } else {
            c0078a = (C0078a) view.getTag();
        }
        if (i == this.mSelectedPosition) {
            c0078a.agm.setVisibility(0);
        } else {
            c0078a.agm.setVisibility(8);
        }
        g item = getItem(i);
        if (this.mType != 1) {
            aVar = null;
        } else {
            aVar = item.adR;
        }
        if (item != null) {
            if (item.isRed()) {
                c0078a.agc.setImageResource(a.f.live_gift_red_enter);
                c0078a.agg.setText(this.mContext.getPageActivity().getString(a.i.sdk_red_pkt_send));
                c0078a.agh.setText("");
            } else {
                c0078a.agc.startLoad(item.qA(), 10, false);
                c0078a.agg.setText(item.qy());
                if (this.mType == 0) {
                    double d = JavaTypesHelper.toDouble(String.valueOf(item.getPrice()), 0.0d);
                    if (d >= 100.0d && ((this.afV || com.baidu.live.r.a.wA().arE.Ym) && !item.qI())) {
                        formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
                    } else {
                        formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(item.getPrice()));
                    }
                    c0078a.agh.setText(formatGiftNumForTDouDisPlay);
                    if (item.qI()) {
                        c0078a.agh.setText(formatGiftNumForTDouDisPlay + " 花瓣");
                    } else {
                        c0078a.agh.setText(formatGiftNumForTDouDisPlay + " T豆");
                    }
                } else if (this.mType == 1) {
                    if (aVar != null) {
                        c0078a.agh.setText(x(aVar.adZ) + " 失效");
                    } else {
                        c0078a.agh.setText("");
                    }
                }
                c0078a.agd.setClickable(false);
                c0078a.agf.setVisibility(8);
                c0078a.agc.setAlpha(1.0f);
                c0078a.agh.setAlpha(1.0f);
                c0078a.agg.setAlpha(1.0f);
                c0078a.agn.setVisibility(8);
                c0078a.agk.setVisibility(4);
                c0078a.agl.cancelAnimation();
                if (this.mType == 0) {
                    if (item.qM()) {
                        c0078a.agc.setAlpha(0.5f);
                        c0078a.agh.setAlpha(0.5f);
                        c0078a.agg.setAlpha(0.5f);
                        c0078a.agd.setVisibility(8);
                        c0078a.agf.setVisibility(0);
                        if (!TextUtils.isEmpty(item.qN())) {
                            c0078a.agj.setText(item.qN());
                        } else {
                            c0078a.agj.setText("");
                        }
                        String qN = item.qN();
                        if (qN.equals("等级")) {
                            c0078a.agf.setBackgroundResource(a.f.live_gift_item_script_lock_level);
                        } else if (qN.equals("活动")) {
                            c0078a.agf.setBackgroundResource(a.f.live_gift_item_script_lock_activity);
                        } else {
                            c0078a.agf.setBackgroundResource(a.f.live_gift_item_script_lock_level);
                        }
                    } else if (item.qP()) {
                        c0078a.agd.setVisibility(0);
                        c0078a.agi.setText(a.i.ala_gift_privilege_level);
                        c0078a.agi.setBackgroundResource(a.f.live_gift_panel_item_script_level);
                    } else if (item.qO() && !this.aga) {
                        c0078a.agc.setAlpha(0.5f);
                        c0078a.agh.setAlpha(0.5f);
                        c0078a.agg.setAlpha(0.5f);
                        c0078a.agd.setVisibility(8);
                        c0078a.agf.setBackgroundResource(a.f.live_gift_item_script_lock_level);
                        c0078a.agf.setVisibility(0);
                        c0078a.agj.setText("王座");
                    } else if (item.qF()) {
                        c0078a.agd.setVisibility(0);
                        c0078a.agi.setText(a.i.ala_gift_draw_txt);
                        c0078a.agi.setBackgroundResource(a.f.live_gift_panel_item_script_graffiti);
                    } else if (item.qG()) {
                        c0078a.agd.setVisibility(0);
                        c0078a.agi.setText(a.i.ala_gift_combo_txt);
                        c0078a.agi.setBackgroundResource(a.f.live_gift_panel_item_script_graffiti);
                    } else if (item.qJ() || item.qK()) {
                        c0078a.agd.setVisibility(0);
                        if (!com.baidu.live.gift.b.b.sK().da(item.qx())) {
                            c0078a.agi.setText(HanziToPinyin.Token.SEPARATOR);
                            c0078a.agi.setBackgroundResource(a.f.live_gift_panel_item_script_download);
                            c0078a.agd.setTag(a.g.TAG_GIFT_ITEM, item);
                            c0078a.agd.setTag(a.g.TAG_GIFT_VIEW_HOLDER, c0078a);
                            c0078a.agd.setClickable(true);
                            c0078a.agd.setOnClickListener(this.mOnClickListener);
                            if (com.baidu.live.gift.b.a.dt(item.qx())) {
                                c0078a.agc.setAlpha(0.5f);
                                c0078a.agh.setAlpha(0.5f);
                                c0078a.agg.setAlpha(0.5f);
                                c0078a.agk.setVisibility(0);
                                c0078a.agl.playAnimation();
                                c0078a.agd.setVisibility(4);
                            } else {
                                c0078a.agk.setVisibility(4);
                                c0078a.agl.cancelAnimation();
                                c0078a.agd.setVisibility(0);
                            }
                        } else if (item.qK()) {
                            c0078a.agi.setText(a.i.ala_gift_broadcast_txt);
                            c0078a.agi.setBackgroundResource(a.f.live_gift_panel_item_script_broadcast);
                            c0078a.agk.setVisibility(4);
                            c0078a.agl.cancelAnimation();
                        } else if (!TextUtils.isEmpty(item.qN())) {
                            String qN2 = item.qN();
                            c0078a.agi.setText(qN2);
                            char c = 65535;
                            switch (qN2.hashCode()) {
                                case 807627:
                                    if (qN2.equals("折扣")) {
                                        c = 1;
                                        break;
                                    }
                                    break;
                                case 888013:
                                    if (qN2.equals("活动")) {
                                        c = 0;
                                        break;
                                    }
                                    break;
                            }
                            switch (c) {
                                case 0:
                                    c0078a.agi.setBackgroundResource(a.f.live_gift_panel_item_script_activity);
                                    break;
                                case 1:
                                    c0078a.agi.setBackgroundResource(a.f.live_gift_panel_item_script_discount);
                                    break;
                                default:
                                    if (qN2.length() == 1) {
                                        c0078a.agi.setBackgroundResource(a.f.live_gift_panel_item_script_new);
                                        break;
                                    } else {
                                        c0078a.agi.setBackgroundResource(a.f.live_gift_panel_item_script_new_wide);
                                        break;
                                    }
                            }
                            c0078a.agk.setVisibility(4);
                            c0078a.agl.cancelAnimation();
                        } else {
                            c0078a.agd.setVisibility(8);
                            c0078a.agk.setVisibility(4);
                            c0078a.agl.cancelAnimation();
                        }
                    } else if (!TextUtils.isEmpty(item.qN())) {
                        c0078a.agd.setVisibility(0);
                        c0078a.agk.setVisibility(4);
                        c0078a.agl.cancelAnimation();
                        String qN3 = item.qN();
                        c0078a.agi.setText(qN3);
                        char c2 = 65535;
                        switch (qN3.hashCode()) {
                            case 807627:
                                if (qN3.equals("折扣")) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                            case 888013:
                                if (qN3.equals("活动")) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                        }
                        switch (c2) {
                            case 0:
                                c0078a.agi.setBackgroundResource(a.f.live_gift_panel_item_script_activity);
                                break;
                            case 1:
                                c0078a.agi.setBackgroundResource(a.f.live_gift_panel_item_script_discount);
                                break;
                            default:
                                if (qN3.length() == 1) {
                                    c0078a.agi.setBackgroundResource(a.f.live_gift_panel_item_script_new);
                                    break;
                                } else {
                                    c0078a.agi.setBackgroundResource(a.f.live_gift_panel_item_script_new_wide);
                                    break;
                                }
                        }
                    } else {
                        c0078a.agd.setVisibility(8);
                    }
                } else if (this.mType == 1 && aVar != null) {
                    if (aVar.adY > 999) {
                        c0078a.ago.setImageResource(a.f.live_icon_gift_panel_package_count_large);
                        c0078a.agp.setText("999+");
                    } else {
                        c0078a.ago.setImageResource(a.f.live_icon_gift_panel_package_count_small);
                        c0078a.agp.setText(String.valueOf(aVar.adY));
                    }
                    c0078a.agn.setVisibility(0);
                }
            }
        }
        return view;
    }

    /* renamed from: com.baidu.live.gift.container.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0078a {
        public TbImageView agc;
        public RelativeLayout agd;
        public LinearLayout agf;
        public TextView agg;
        public TextView agh;
        public TextView agi;
        public TextView agj;
        public View agk;
        public LottieAnimationView agl;
        public View agm;
        public FrameLayout agn;
        public ImageView ago;
        public TextView agp;
        public FrameLayout agq;
        public TextView agr;

        public void recycle() {
            if (this.agl != null) {
                this.agl.cancelAnimation();
            }
        }
    }

    private static String x(long j) {
        if (afW == null) {
            afW = new SimpleDateFormat("MM.dd");
        }
        return afW.format(Long.valueOf(1000 * j));
    }
}

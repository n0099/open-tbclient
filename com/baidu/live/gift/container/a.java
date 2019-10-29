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
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.widget.TbImageView;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends BaseAdapter {
    private static SimpleDateFormat Yo;
    private List<g> Ym;
    private int Yp;
    private int Yq;
    private int Yr;
    private TbPageContext mContext;
    private int mType;
    private int Yl = -1;
    private int mSelectedPosition = -1;
    private boolean Yn = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.gift.container.a.1
        /* JADX INFO: Access modifiers changed from: private */
        public void a(g gVar, C0064a c0064a) {
            com.baidu.live.gift.c cC;
            if ((gVar.pn() || gVar.po()) && !com.baidu.live.gift.b.b.rc().ci(gVar.pc()) && (cC = com.baidu.live.gift.b.b.rc().cC(gVar.pc())) != null) {
                com.baidu.live.gift.b.a.b(cC.getDynamicGiftId(), cC.Wm.Wk.zipDownloadUrl, cC.Wm.Wk.zipName, cC.Wm.Wk.zipMD5, true);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = true;
            if ((view.getTag(a.g.TAG_GIFT_ITEM) instanceof g) && (view.getTag(a.g.TAG_GIFT_VIEW_HOLDER) instanceof C0064a)) {
                final C0064a c0064a = (C0064a) view.getTag(a.g.TAG_GIFT_VIEW_HOLDER);
                final g gVar = (g) view.getTag(a.g.TAG_GIFT_ITEM);
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(a.this.mContext.getPageActivity(), a.this.mContext.getString(a.i.sdk_neterror));
                    return;
                }
                if (TbadkCoreApplication.getInst().isQuanmin() && ExtraParamsManager.getSaveFlowStatus()) {
                    z = false;
                }
                if (BdNetTypeUtil.isMobileNet() && z) {
                    BdAlertDialog bdAlertDialog = new BdAlertDialog(a.this.mContext.getPageActivity());
                    bdAlertDialog.setAutoNight(false);
                    bdAlertDialog.setMessage(a.this.mContext.getString(a.i.download_gift_toast));
                    bdAlertDialog.setPositiveButton(a.this.mContext.getString(a.i.sdk_download), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.a.1.1
                        @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                        public void onClick(BdAlertDialog bdAlertDialog2) {
                            a(gVar, c0064a);
                            bdAlertDialog2.dismiss();
                        }
                    });
                    bdAlertDialog.setNegativeButton(a.this.mContext.getString(a.i.sdk_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.a.1.2
                        @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                        public void onClick(BdAlertDialog bdAlertDialog2) {
                            bdAlertDialog2.dismiss();
                        }
                    });
                    bdAlertDialog.create(a.this.mContext).show();
                } else if (BdNetTypeUtil.isWifiNet() || (BdNetTypeUtil.isMobileNet() && !z)) {
                    a(gVar, c0064a);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext, int i) {
        this.mContext = tbPageContext;
        this.mType = i;
    }

    public void setGiftItems(List<g> list) {
        this.Ym = list;
        notifyDataSetChanged();
    }

    public void l(String str, int i) {
        if (this.Ym != null) {
            for (g gVar : this.Ym) {
                if (gVar.WH != null && gVar.pc().equals(str)) {
                    gVar.WH.WL = i;
                }
            }
            notifyDataSetChanged();
        }
    }

    public void bc(int i) {
        this.Yl = i;
    }

    public void bd(int i) {
        this.mSelectedPosition = i;
    }

    public int qd() {
        return this.mSelectedPosition;
    }

    public void ak(boolean z) {
        this.Yn = z;
    }

    public void be(int i) {
        this.Yp = i;
        float dimensionPixelOffset = (i * 1.0f) / this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds192);
        this.Yq = (int) (this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds100) * dimensionPixelOffset);
        this.Yr = (int) (dimensionPixelOffset * this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds18));
    }

    public void a(AbsListView absListView, String str) {
        int count;
        int firstVisiblePosition;
        View childAt;
        com.baidu.live.gift.c cC;
        if (!TextUtils.isEmpty(str) && (count = getCount()) != 0) {
            int i = 0;
            while (true) {
                if (i >= count) {
                    i = -1;
                    break;
                }
                g item = getItem(i);
                if (item != null && !TextUtils.isEmpty(item.pc()) && (cC = com.baidu.live.gift.b.b.rc().cC(item.pc())) != null && !TextUtils.isEmpty(cC.getDynamicGiftId()) && cC.getDynamicGiftId().equals(str)) {
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
        if (this.Ym == null) {
            return 0;
        }
        return this.Ym.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: bf */
    public g getItem(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.Ym.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0064a c0064a;
        g.a aVar;
        String formatGiftNumForTDouDisPlay;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.ala_gift_list_item, viewGroup, false);
            view.setBackgroundResource(a.f.sdk_transparent_bg);
            C0064a c0064a2 = new C0064a();
            c0064a2.Yw = (TbImageView) view.findViewById(a.g.gift_thumbnail);
            c0064a2.Yw.setDefaultBgResource(a.f.icon_live_gift_default);
            c0064a2.Yw.setDefaultErrorResource(a.f.icon_live_gift_default);
            c0064a2.Yw.setAutoChangeStyle(false);
            c0064a2.Yz = (TextView) view.findViewById(a.g.gift_name);
            c0064a2.YA = (TextView) view.findViewById(a.g.gift_price);
            c0064a2.Yx = (RelativeLayout) view.findViewById(a.g.llCarom);
            c0064a2.YB = (TextView) view.findViewById(a.g.gift_carom_txt);
            c0064a2.YD = view.findViewById(a.g.in_progress);
            c0064a2.YE = (LottieAnimationView) view.findViewById(a.g.lottie_downloading);
            c0064a2.YE.loop(true);
            c0064a2.YE.setAnimation("live_gift_panel_downloading.json");
            c0064a2.YF = view.findViewById(a.g.selected_bg);
            c0064a2.YC = (TextView) view.findViewById(a.g.tv_privilege);
            c0064a2.Yy = (LinearLayout) view.findViewById(a.g.ll_privilege);
            c0064a2.YG = (FrameLayout) view.findViewById(a.g.layout_pkg_count);
            c0064a2.YH = (ImageView) view.findViewById(a.g.iv_pkg_count);
            c0064a2.YI = (TextView) view.findViewById(a.g.tv_pkg_count);
            c0064a2.YJ = (FrameLayout) view.findViewById(a.g.layout_script);
            c0064a2.YK = (TextView) view.findViewById(a.g.tv_script);
            view.setTag(c0064a2);
            if (this.Yp <= 0 || this.Yq <= 0) {
                c0064a = c0064a2;
            } else {
                view.getLayoutParams().height = this.Yp;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c0064a2.Yw.getLayoutParams();
                layoutParams.width = this.Yq;
                layoutParams.height = this.Yq;
                layoutParams.topMargin = this.Yr;
                c0064a = c0064a2;
            }
        } else {
            c0064a = (C0064a) view.getTag();
        }
        if (i == this.mSelectedPosition) {
            c0064a.YF.setVisibility(0);
        } else {
            c0064a.YF.setVisibility(8);
        }
        g item = getItem(i);
        if (this.mType != 1) {
            aVar = null;
        } else {
            aVar = item.WH;
        }
        if (item != null) {
            c0064a.Yw.startLoad(item.pf(), 10, false);
            c0064a.Yz.setText(item.pd());
            if (this.mType == 0) {
                double d = JavaTypesHelper.toDouble(String.valueOf(item.getPrice()), 0.0d);
                if (d >= 100.0d && ((this.Yn || com.baidu.live.l.a.uA().ajX.Sb) && !item.pm())) {
                    formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
                } else {
                    formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(item.getPrice()));
                }
                c0064a.YA.setText(formatGiftNumForTDouDisPlay);
                if (item.pm()) {
                    c0064a.YA.setText(formatGiftNumForTDouDisPlay + " 花瓣");
                } else {
                    c0064a.YA.setText(formatGiftNumForTDouDisPlay + " T豆");
                }
            } else if (this.mType == 1) {
                if (aVar != null) {
                    c0064a.YA.setText(w(aVar.WM) + " 失效");
                } else {
                    c0064a.YA.setText("");
                }
            }
            c0064a.Yx.setClickable(false);
            c0064a.Yy.setVisibility(8);
            c0064a.Yw.setAlpha(1.0f);
            c0064a.YA.setAlpha(1.0f);
            c0064a.Yz.setAlpha(1.0f);
            c0064a.YG.setVisibility(8);
            c0064a.YD.setVisibility(4);
            c0064a.YE.cancelAnimation();
            if (this.mType == 0) {
                if (item.pq()) {
                    c0064a.Yw.setAlpha(0.5f);
                    c0064a.YA.setAlpha(0.5f);
                    c0064a.Yz.setAlpha(0.5f);
                    c0064a.Yx.setVisibility(8);
                    c0064a.Yy.setVisibility(0);
                    if (!TextUtils.isEmpty(item.pr())) {
                        c0064a.YC.setText(item.pr());
                    } else {
                        c0064a.YC.setText("");
                    }
                    String pr = item.pr();
                    if (pr.equals("等级")) {
                        c0064a.Yy.setBackgroundResource(a.f.live_gift_item_script_lock_level);
                    } else if (pr.equals("活动")) {
                        c0064a.Yy.setBackgroundResource(a.f.live_gift_item_script_lock_activity);
                    } else {
                        c0064a.Yy.setBackgroundResource(a.f.live_gift_item_script_lock_level);
                    }
                } else if (item.ps()) {
                    c0064a.Yx.setVisibility(0);
                    c0064a.YB.setText(a.i.ala_gift_privilege_level);
                    c0064a.YB.setBackgroundResource(a.f.live_gift_panel_item_script_level);
                } else if (item.pk()) {
                    c0064a.Yx.setVisibility(0);
                    c0064a.YB.setText(a.i.ala_gift_draw_txt);
                    c0064a.YB.setBackgroundResource(a.f.live_gift_panel_item_script_graffiti);
                } else if (item.pn() || item.po()) {
                    c0064a.Yx.setVisibility(0);
                    if (!com.baidu.live.gift.b.b.rc().ci(item.pc())) {
                        c0064a.YB.setText(HanziToPinyin.Token.SEPARATOR);
                        c0064a.YB.setBackgroundResource(a.f.live_gift_panel_item_script_download);
                        c0064a.Yx.setTag(a.g.TAG_GIFT_ITEM, item);
                        c0064a.Yx.setTag(a.g.TAG_GIFT_VIEW_HOLDER, c0064a);
                        c0064a.Yx.setClickable(true);
                        c0064a.Yx.setOnClickListener(this.mOnClickListener);
                        if (com.baidu.live.gift.b.a.cB(item.pc())) {
                            c0064a.Yw.setAlpha(0.5f);
                            c0064a.YA.setAlpha(0.5f);
                            c0064a.Yz.setAlpha(0.5f);
                            c0064a.YD.setVisibility(0);
                            c0064a.YE.playAnimation();
                            c0064a.Yx.setVisibility(4);
                        } else {
                            c0064a.YD.setVisibility(4);
                            c0064a.YE.cancelAnimation();
                            c0064a.Yx.setVisibility(0);
                        }
                    } else if (item.po()) {
                        c0064a.YB.setText(a.i.ala_gift_broadcast_txt);
                        c0064a.YB.setBackgroundResource(a.f.live_gift_panel_item_script_broadcast);
                        c0064a.YD.setVisibility(4);
                        c0064a.YE.cancelAnimation();
                    } else if (!TextUtils.isEmpty(item.pr())) {
                        String pr2 = item.pr();
                        c0064a.YB.setText(pr2);
                        char c = 65535;
                        switch (pr2.hashCode()) {
                            case 807627:
                                if (pr2.equals("折扣")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case 888013:
                                if (pr2.equals("活动")) {
                                    c = 0;
                                    break;
                                }
                                break;
                        }
                        switch (c) {
                            case 0:
                                c0064a.YB.setBackgroundResource(a.f.live_gift_panel_item_script_activity);
                                break;
                            case 1:
                                c0064a.YB.setBackgroundResource(a.f.live_gift_panel_item_script_discount);
                                break;
                            default:
                                if (pr2.length() == 1) {
                                    c0064a.YB.setBackgroundResource(a.f.live_gift_panel_item_script_new);
                                    break;
                                } else {
                                    c0064a.YB.setBackgroundResource(a.f.live_gift_panel_item_script_new_wide);
                                    break;
                                }
                        }
                        c0064a.YD.setVisibility(4);
                        c0064a.YE.cancelAnimation();
                    } else {
                        c0064a.Yx.setVisibility(8);
                        c0064a.YD.setVisibility(4);
                        c0064a.YE.cancelAnimation();
                    }
                } else if (!TextUtils.isEmpty(item.pr())) {
                    c0064a.Yx.setVisibility(0);
                    c0064a.YD.setVisibility(4);
                    c0064a.YE.cancelAnimation();
                    String pr3 = item.pr();
                    c0064a.YB.setText(pr3);
                    char c2 = 65535;
                    switch (pr3.hashCode()) {
                        case 807627:
                            if (pr3.equals("折扣")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 888013:
                            if (pr3.equals("活动")) {
                                c2 = 0;
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                            c0064a.YB.setBackgroundResource(a.f.live_gift_panel_item_script_activity);
                            break;
                        case 1:
                            c0064a.YB.setBackgroundResource(a.f.live_gift_panel_item_script_discount);
                            break;
                        default:
                            if (pr3.length() == 1) {
                                c0064a.YB.setBackgroundResource(a.f.live_gift_panel_item_script_new);
                                break;
                            } else {
                                c0064a.YB.setBackgroundResource(a.f.live_gift_panel_item_script_new_wide);
                                break;
                            }
                    }
                } else {
                    c0064a.Yx.setVisibility(8);
                }
            } else if (this.mType == 1 && aVar != null) {
                if (aVar.WL > 999) {
                    c0064a.YH.setImageResource(a.f.live_icon_gift_panel_package_count_large);
                    c0064a.YI.setText("999+");
                } else {
                    c0064a.YH.setImageResource(a.f.live_icon_gift_panel_package_count_small);
                    c0064a.YI.setText(String.valueOf(aVar.WL));
                }
                c0064a.YG.setVisibility(0);
            }
        }
        return view;
    }

    /* renamed from: com.baidu.live.gift.container.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0064a {
        public TextView YA;
        public TextView YB;
        public TextView YC;
        public View YD;
        public LottieAnimationView YE;
        public View YF;
        public FrameLayout YG;
        public ImageView YH;
        public TextView YI;
        public FrameLayout YJ;
        public TextView YK;
        public TbImageView Yw;
        public RelativeLayout Yx;
        public LinearLayout Yy;
        public TextView Yz;

        public void recycle() {
            if (this.YE != null) {
                this.YE.cancelAnimation();
            }
        }
    }

    private static String w(long j) {
        if (Yo == null) {
            Yo = new SimpleDateFormat("MM.dd");
        }
        return Yo.format(Long.valueOf(1000 * j));
    }
}

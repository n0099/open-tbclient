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
    private static SimpleDateFormat XW;
    private List<g> XU;
    private int XX;
    private int XY;
    private int XZ;
    private TbPageContext mContext;
    private int mType;
    private int XT = -1;
    private int mSelectedPosition = -1;
    private boolean XV = false;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.gift.container.a.1
        /* JADX INFO: Access modifiers changed from: private */
        public void a(g gVar, C0064a c0064a) {
            com.baidu.live.gift.c cC;
            if ((gVar.pn() || gVar.po()) && !com.baidu.live.gift.b.b.rd().ci(gVar.pc()) && (cC = com.baidu.live.gift.b.b.rd().cC(gVar.pc())) != null) {
                com.baidu.live.gift.b.a.b(cC.getDynamicGiftId(), cC.VT.VR.zipDownloadUrl, cC.VT.VR.zipName, cC.VT.VR.zipMD5, true);
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
        this.XU = list;
        notifyDataSetChanged();
    }

    public void l(String str, int i) {
        if (this.XU != null) {
            for (g gVar : this.XU) {
                if (gVar.Wo != null && gVar.pc().equals(str)) {
                    gVar.Wo.Ws = i;
                }
            }
            notifyDataSetChanged();
        }
    }

    public void bc(int i) {
        this.XT = i;
    }

    public void bd(int i) {
        this.mSelectedPosition = i;
    }

    public int qe() {
        return this.mSelectedPosition;
    }

    public void ak(boolean z) {
        this.XV = z;
    }

    public void be(int i) {
        this.XX = i;
        float dimensionPixelOffset = (i * 1.0f) / this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds192);
        this.XY = (int) (this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds100) * dimensionPixelOffset);
        this.XZ = (int) (dimensionPixelOffset * this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds18));
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
                if (item != null && !TextUtils.isEmpty(item.pc()) && (cC = com.baidu.live.gift.b.b.rd().cC(item.pc())) != null && !TextUtils.isEmpty(cC.getDynamicGiftId()) && cC.getDynamicGiftId().equals(str)) {
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
        if (this.XU == null) {
            return 0;
        }
        return this.XU.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: bf */
    public g getItem(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.XU.get(i);
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
            c0064a2.Ye = (TbImageView) view.findViewById(a.g.gift_thumbnail);
            c0064a2.Ye.setDefaultBgResource(a.f.icon_live_gift_default);
            c0064a2.Ye.setDefaultErrorResource(a.f.icon_live_gift_default);
            c0064a2.Ye.setAutoChangeStyle(false);
            c0064a2.Yh = (TextView) view.findViewById(a.g.gift_name);
            c0064a2.Yi = (TextView) view.findViewById(a.g.gift_price);
            c0064a2.Yf = (RelativeLayout) view.findViewById(a.g.llCarom);
            c0064a2.Yj = (TextView) view.findViewById(a.g.gift_carom_txt);
            c0064a2.Yl = view.findViewById(a.g.in_progress);
            c0064a2.Ym = (LottieAnimationView) view.findViewById(a.g.lottie_downloading);
            c0064a2.Ym.loop(true);
            c0064a2.Ym.setAnimation("live_gift_panel_downloading.json");
            c0064a2.Yn = view.findViewById(a.g.selected_bg);
            c0064a2.Yk = (TextView) view.findViewById(a.g.tv_privilege);
            c0064a2.Yg = (LinearLayout) view.findViewById(a.g.ll_privilege);
            c0064a2.Yo = (FrameLayout) view.findViewById(a.g.layout_pkg_count);
            c0064a2.Yp = (ImageView) view.findViewById(a.g.iv_pkg_count);
            c0064a2.Yq = (TextView) view.findViewById(a.g.tv_pkg_count);
            c0064a2.Yr = (FrameLayout) view.findViewById(a.g.layout_script);
            c0064a2.Ys = (TextView) view.findViewById(a.g.tv_script);
            view.setTag(c0064a2);
            if (this.XX <= 0 || this.XY <= 0) {
                c0064a = c0064a2;
            } else {
                view.getLayoutParams().height = this.XX;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c0064a2.Ye.getLayoutParams();
                layoutParams.width = this.XY;
                layoutParams.height = this.XY;
                layoutParams.topMargin = this.XZ;
                c0064a = c0064a2;
            }
        } else {
            c0064a = (C0064a) view.getTag();
        }
        if (i == this.mSelectedPosition) {
            c0064a.Yn.setVisibility(0);
        } else {
            c0064a.Yn.setVisibility(8);
        }
        g item = getItem(i);
        if (this.mType != 1) {
            aVar = null;
        } else {
            aVar = item.Wo;
        }
        if (item != null) {
            c0064a.Ye.startLoad(item.pf(), 10, false);
            c0064a.Yh.setText(item.pd());
            if (this.mType == 0) {
                double d = JavaTypesHelper.toDouble(String.valueOf(item.getPrice()), 0.0d);
                if (d >= 100.0d && ((this.XV || com.baidu.live.l.a.uB().ajF.Ry) && !item.pm())) {
                    formatGiftNumForTDouDisPlay = new DecimalFormat("0.###K").format(d / 1000.0d);
                } else {
                    formatGiftNumForTDouDisPlay = StringHelper.formatGiftNumForTDouDisPlay(Long.parseLong(item.getPrice()));
                }
                c0064a.Yi.setText(formatGiftNumForTDouDisPlay);
                if (item.pm()) {
                    c0064a.Yi.setText(formatGiftNumForTDouDisPlay + " 花瓣");
                } else {
                    c0064a.Yi.setText(formatGiftNumForTDouDisPlay + " T豆");
                }
            } else if (this.mType == 1) {
                if (aVar != null) {
                    c0064a.Yi.setText(v(aVar.Wt) + " 失效");
                } else {
                    c0064a.Yi.setText("");
                }
            }
            c0064a.Yf.setClickable(false);
            c0064a.Yg.setVisibility(8);
            c0064a.Ye.setAlpha(1.0f);
            c0064a.Yi.setAlpha(1.0f);
            c0064a.Yh.setAlpha(1.0f);
            c0064a.Yo.setVisibility(8);
            c0064a.Yl.setVisibility(4);
            c0064a.Ym.cancelAnimation();
            if (this.mType == 0) {
                if (item.pq()) {
                    c0064a.Ye.setAlpha(0.5f);
                    c0064a.Yi.setAlpha(0.5f);
                    c0064a.Yh.setAlpha(0.5f);
                    c0064a.Yf.setVisibility(8);
                    c0064a.Yg.setVisibility(0);
                    if (!TextUtils.isEmpty(item.pr())) {
                        c0064a.Yk.setText(item.pr());
                    } else {
                        c0064a.Yk.setText("");
                    }
                    String pr = item.pr();
                    if (pr.equals("等级")) {
                        c0064a.Yg.setBackgroundResource(a.f.live_gift_item_script_lock_level);
                    } else if (pr.equals("活动")) {
                        c0064a.Yg.setBackgroundResource(a.f.live_gift_item_script_lock_activity);
                    } else {
                        c0064a.Yg.setBackgroundResource(a.f.live_gift_item_script_lock_level);
                    }
                } else if (item.ps()) {
                    c0064a.Yf.setVisibility(0);
                    c0064a.Yj.setText(a.i.ala_gift_privilege_level);
                    c0064a.Yj.setBackgroundResource(a.f.live_gift_panel_item_script_level);
                } else if (item.pk()) {
                    c0064a.Yf.setVisibility(0);
                    c0064a.Yj.setText(a.i.ala_gift_draw_txt);
                    c0064a.Yj.setBackgroundResource(a.f.live_gift_panel_item_script_graffiti);
                } else if (item.pn() || item.po()) {
                    c0064a.Yf.setVisibility(0);
                    if (!com.baidu.live.gift.b.b.rd().ci(item.pc())) {
                        c0064a.Yj.setText(HanziToPinyin.Token.SEPARATOR);
                        c0064a.Yj.setBackgroundResource(a.f.live_gift_panel_item_script_download);
                        c0064a.Yf.setTag(a.g.TAG_GIFT_ITEM, item);
                        c0064a.Yf.setTag(a.g.TAG_GIFT_VIEW_HOLDER, c0064a);
                        c0064a.Yf.setClickable(true);
                        c0064a.Yf.setOnClickListener(this.mOnClickListener);
                        if (com.baidu.live.gift.b.a.cB(item.pc())) {
                            c0064a.Ye.setAlpha(0.5f);
                            c0064a.Yi.setAlpha(0.5f);
                            c0064a.Yh.setAlpha(0.5f);
                            c0064a.Yl.setVisibility(0);
                            c0064a.Ym.playAnimation();
                            c0064a.Yf.setVisibility(4);
                        } else {
                            c0064a.Yl.setVisibility(4);
                            c0064a.Ym.cancelAnimation();
                            c0064a.Yf.setVisibility(0);
                        }
                    } else if (item.po()) {
                        c0064a.Yj.setText(a.i.ala_gift_broadcast_txt);
                        c0064a.Yj.setBackgroundResource(a.f.live_gift_panel_item_script_broadcast);
                        c0064a.Yl.setVisibility(4);
                        c0064a.Ym.cancelAnimation();
                    } else if (!TextUtils.isEmpty(item.pr())) {
                        String pr2 = item.pr();
                        c0064a.Yj.setText(pr2);
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
                                c0064a.Yj.setBackgroundResource(a.f.live_gift_panel_item_script_activity);
                                break;
                            case 1:
                                c0064a.Yj.setBackgroundResource(a.f.live_gift_panel_item_script_discount);
                                break;
                            default:
                                if (pr2.length() == 1) {
                                    c0064a.Yj.setBackgroundResource(a.f.live_gift_panel_item_script_new);
                                    break;
                                } else {
                                    c0064a.Yj.setBackgroundResource(a.f.live_gift_panel_item_script_new_wide);
                                    break;
                                }
                        }
                        c0064a.Yl.setVisibility(4);
                        c0064a.Ym.cancelAnimation();
                    } else {
                        c0064a.Yf.setVisibility(8);
                        c0064a.Yl.setVisibility(4);
                        c0064a.Ym.cancelAnimation();
                    }
                } else if (!TextUtils.isEmpty(item.pr())) {
                    c0064a.Yf.setVisibility(0);
                    c0064a.Yl.setVisibility(4);
                    c0064a.Ym.cancelAnimation();
                    String pr3 = item.pr();
                    c0064a.Yj.setText(pr3);
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
                            c0064a.Yj.setBackgroundResource(a.f.live_gift_panel_item_script_activity);
                            break;
                        case 1:
                            c0064a.Yj.setBackgroundResource(a.f.live_gift_panel_item_script_discount);
                            break;
                        default:
                            if (pr3.length() == 1) {
                                c0064a.Yj.setBackgroundResource(a.f.live_gift_panel_item_script_new);
                                break;
                            } else {
                                c0064a.Yj.setBackgroundResource(a.f.live_gift_panel_item_script_new_wide);
                                break;
                            }
                    }
                } else {
                    c0064a.Yf.setVisibility(8);
                }
            } else if (this.mType == 1 && aVar != null) {
                if (aVar.Ws > 999) {
                    c0064a.Yp.setImageResource(a.f.live_icon_gift_panel_package_count_large);
                    c0064a.Yq.setText("999+");
                } else {
                    c0064a.Yp.setImageResource(a.f.live_icon_gift_panel_package_count_small);
                    c0064a.Yq.setText(String.valueOf(aVar.Ws));
                }
                c0064a.Yo.setVisibility(0);
            }
        }
        return view;
    }

    /* renamed from: com.baidu.live.gift.container.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0064a {
        public TbImageView Ye;
        public RelativeLayout Yf;
        public LinearLayout Yg;
        public TextView Yh;
        public TextView Yi;
        public TextView Yj;
        public TextView Yk;
        public View Yl;
        public LottieAnimationView Ym;
        public View Yn;
        public FrameLayout Yo;
        public ImageView Yp;
        public TextView Yq;
        public FrameLayout Yr;
        public TextView Ys;

        public void recycle() {
            if (this.Ym != null) {
                this.Ym.cancelAnimation();
            }
        }
    }

    private static String v(long j) {
        if (XW == null) {
            XW = new SimpleDateFormat("MM.dd");
        }
        return XW.format(Long.valueOf(1000 * j));
    }
}

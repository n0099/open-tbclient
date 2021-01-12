package com.baidu.live.gift.container;

import android.content.res.Resources;
import android.text.ClipboardManager;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.bubbleview.BubbleLayout;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.dialog.BdToast;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
/* loaded from: classes10.dex */
public class d implements View.OnClickListener {
    private BubbleLayout aXf;
    private PopupWindow aXg;
    private BdAlertDialog aXh;
    private Resources aXi;
    private TbPageContext mPageContext;

    public d(TbPageContext<AlaGiftTabActivity> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.aXi = this.mPageContext.getPageActivity().getResources();
    }

    public void O(View view) {
        int dimensionPixelSize = this.aXi.getDimensionPixelSize(a.d.sdk_ds300);
        if (this.aXf == null) {
            this.aXf = (BubbleLayout) View.inflate(this.mPageContext.getPageActivity(), a.g.ala_gift_official_tip, null);
            this.aXf.setOnClickListener(this);
            this.aXg = new PopupWindow((View) this.aXf, dimensionPixelSize, this.aXi.getDimensionPixelSize(a.d.sdk_ds86), true);
            this.aXg.setTouchable(true);
            this.aXg.setBackgroundDrawable(this.aXi.getDrawable(a.e.sdk_transparent_bg));
        }
        int dimensionPixelSize2 = this.aXi.getDimensionPixelSize(a.d.sdk_ds8);
        ShowUtil.showPopupWindowAsDropDown(this.aXg, view, ((-dimensionPixelSize) / 2) + (this.aXi.getDimensionPixelSize(a.d.sdk_ds52) / 2), -dimensionPixelSize2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aXf == view) {
            this.aXg.dismiss();
        }
    }

    public void n(String str, String str2, final String str3) {
        if (this.aXh == null) {
            this.aXh = new BdAlertDialog(this.mPageContext.getPageActivity());
            this.aXh.setCanceledOnTouchOutside(false);
        }
        this.aXh.setTitle(str);
        this.aXh.setMessage(str2);
        this.aXh.setTitleShowCenter(true);
        this.aXh.setMessageShowCenter(true);
        this.aXh.setMessageTextColor(this.mPageContext.getResources().getColor(a.c.sdk_cp_cont_f));
        this.aXh.isShowTitleAndMessage();
        this.aXh.setPositiveButton("复制添加", new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.d.2
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "tycoon_copy_clk"));
                d.this.copyToClipboard(str3);
                BdToast.makeText(d.this.mPageContext.getPageActivity(), d.this.mPageContext.getResources().getString(a.h.sdk_copy_tip)).setDuration(17).show();
                bdAlertDialog.dismiss();
            }
        }).setNegativeButton(a.h.sdk_live_iknow, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.d.1
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                bdAlertDialog.dismiss();
            }
        }).create(this.mPageContext);
        this.aXh.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void copyToClipboard(String str) {
        if (str == null) {
            str = "";
        }
        try {
            ((ClipboardManager) BdBaseApplication.getInst().getApp().getSystemService("clipboard")).setText(str);
        } catch (Throwable th) {
        }
    }
}

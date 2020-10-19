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
/* loaded from: classes4.dex */
public class d implements View.OnClickListener {
    private BubbleLayout aVV;
    private PopupWindow aVW;
    private BdAlertDialog aVX;
    private Resources aVY;
    private TbPageContext mPageContext;

    public d(TbPageContext<AlaGiftTabActivity> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.aVY = this.mPageContext.getPageActivity().getResources();
    }

    public void O(View view) {
        int dimensionPixelSize = this.aVY.getDimensionPixelSize(a.e.sdk_ds300);
        if (this.aVV == null) {
            this.aVV = (BubbleLayout) View.inflate(this.mPageContext.getPageActivity(), a.h.ala_gift_official_tip, null);
            this.aVV.setOnClickListener(this);
            this.aVW = new PopupWindow((View) this.aVV, dimensionPixelSize, this.aVY.getDimensionPixelSize(a.e.sdk_ds86), true);
            this.aVW.setTouchable(true);
            this.aVW.setBackgroundDrawable(this.aVY.getDrawable(a.f.sdk_transparent_bg));
        }
        int dimensionPixelSize2 = this.aVY.getDimensionPixelSize(a.e.sdk_ds8);
        ShowUtil.showPopupWindowAsDropDown(this.aVW, view, ((-dimensionPixelSize) / 2) + (this.aVY.getDimensionPixelSize(a.e.sdk_ds52) / 2), -dimensionPixelSize2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aVV == view) {
            this.aVW.dismiss();
        }
    }

    public void n(String str, String str2, final String str3) {
        if (this.aVX == null) {
            this.aVX = new BdAlertDialog(this.mPageContext.getPageActivity());
            this.aVX.setCanceledOnTouchOutside(false);
        }
        this.aVX.setTitle(str);
        this.aVX.setMessage(str2);
        this.aVX.setTitleShowCenter(true);
        this.aVX.setMessageShowCenter(true);
        this.aVX.setMessageTextColor(this.mPageContext.getResources().getColor(a.d.sdk_cp_cont_f));
        this.aVX.isShowTitleAndMessage();
        this.aVX.setPositiveButton("复制添加", new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.d.2
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "tycoon_copy_clk"));
                d.this.copyToClipboard(str3);
                BdToast.makeText(d.this.mPageContext.getPageActivity(), d.this.mPageContext.getResources().getString(a.i.sdk_copy_tip)).setDuration(17).show();
                bdAlertDialog.dismiss();
            }
        }).setNegativeButton(a.i.sdk_live_iknow, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.d.1
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                bdAlertDialog.dismiss();
            }
        }).create(this.mPageContext);
        this.aVX.show();
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

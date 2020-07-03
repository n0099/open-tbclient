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
/* loaded from: classes3.dex */
public class d implements View.OnClickListener {
    private BubbleLayout aJW;
    private PopupWindow aJX;
    private BdAlertDialog aJY;
    private Resources aJZ;
    private TbPageContext mPageContext;

    public d(TbPageContext<AlaGiftTabActivity> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.aJZ = this.mPageContext.getPageActivity().getResources();
    }

    public void L(View view) {
        int dimensionPixelSize = this.aJZ.getDimensionPixelSize(a.e.sdk_ds300);
        if (this.aJW == null) {
            this.aJW = (BubbleLayout) View.inflate(this.mPageContext.getPageActivity(), a.h.ala_gift_official_tip, null);
            this.aJW.setOnClickListener(this);
            this.aJX = new PopupWindow((View) this.aJW, dimensionPixelSize, this.aJZ.getDimensionPixelSize(a.e.sdk_ds86), true);
            this.aJX.setTouchable(true);
            this.aJX.setBackgroundDrawable(this.aJZ.getDrawable(a.f.sdk_transparent_bg));
        }
        int dimensionPixelSize2 = this.aJZ.getDimensionPixelSize(a.e.sdk_ds8);
        ShowUtil.showPopupWindowAsDropDown(this.aJX, view, ((-dimensionPixelSize) / 2) + (this.aJZ.getDimensionPixelSize(a.e.sdk_ds52) / 2), -dimensionPixelSize2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aJW == view) {
            this.aJX.dismiss();
        }
    }

    public void m(String str, String str2, final String str3) {
        if (this.aJY == null) {
            this.aJY = new BdAlertDialog(this.mPageContext.getPageActivity());
            this.aJY.setCanceledOnTouchOutside(false);
        }
        this.aJY.setTitle(str);
        this.aJY.setMessage(str2);
        this.aJY.setTitleShowCenter(true);
        this.aJY.setMessageShowCenter(true);
        this.aJY.setMessageTextColor(this.mPageContext.getResources().getColor(a.d.sdk_cp_cont_f));
        this.aJY.isShowTitleAndMessage();
        this.aJY.setPositiveButton("复制添加", new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.d.2
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
        this.aJY.show();
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

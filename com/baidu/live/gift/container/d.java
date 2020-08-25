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
/* loaded from: classes7.dex */
public class d implements View.OnClickListener {
    private BubbleLayout aQF;
    private PopupWindow aQG;
    private BdAlertDialog aQH;
    private Resources aQI;
    private TbPageContext mPageContext;

    public d(TbPageContext<AlaGiftTabActivity> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.aQI = this.mPageContext.getPageActivity().getResources();
    }

    public void O(View view) {
        int dimensionPixelSize = this.aQI.getDimensionPixelSize(a.e.sdk_ds300);
        if (this.aQF == null) {
            this.aQF = (BubbleLayout) View.inflate(this.mPageContext.getPageActivity(), a.h.ala_gift_official_tip, null);
            this.aQF.setOnClickListener(this);
            this.aQG = new PopupWindow((View) this.aQF, dimensionPixelSize, this.aQI.getDimensionPixelSize(a.e.sdk_ds86), true);
            this.aQG.setTouchable(true);
            this.aQG.setBackgroundDrawable(this.aQI.getDrawable(a.f.sdk_transparent_bg));
        }
        int dimensionPixelSize2 = this.aQI.getDimensionPixelSize(a.e.sdk_ds8);
        ShowUtil.showPopupWindowAsDropDown(this.aQG, view, ((-dimensionPixelSize) / 2) + (this.aQI.getDimensionPixelSize(a.e.sdk_ds52) / 2), -dimensionPixelSize2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aQF == view) {
            this.aQG.dismiss();
        }
    }

    public void n(String str, String str2, final String str3) {
        if (this.aQH == null) {
            this.aQH = new BdAlertDialog(this.mPageContext.getPageActivity());
            this.aQH.setCanceledOnTouchOutside(false);
        }
        this.aQH.setTitle(str);
        this.aQH.setMessage(str2);
        this.aQH.setTitleShowCenter(true);
        this.aQH.setMessageShowCenter(true);
        this.aQH.setMessageTextColor(this.mPageContext.getResources().getColor(a.d.sdk_cp_cont_f));
        this.aQH.isShowTitleAndMessage();
        this.aQH.setPositiveButton("复制添加", new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.d.2
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
        this.aQH.show();
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

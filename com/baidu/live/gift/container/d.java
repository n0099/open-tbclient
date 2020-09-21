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
    private BubbleLayout aSK;
    private PopupWindow aSL;
    private BdAlertDialog aSM;
    private Resources aSN;
    private TbPageContext mPageContext;

    public d(TbPageContext<AlaGiftTabActivity> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.aSN = this.mPageContext.getPageActivity().getResources();
    }

    public void O(View view) {
        int dimensionPixelSize = this.aSN.getDimensionPixelSize(a.e.sdk_ds300);
        if (this.aSK == null) {
            this.aSK = (BubbleLayout) View.inflate(this.mPageContext.getPageActivity(), a.h.ala_gift_official_tip, null);
            this.aSK.setOnClickListener(this);
            this.aSL = new PopupWindow((View) this.aSK, dimensionPixelSize, this.aSN.getDimensionPixelSize(a.e.sdk_ds86), true);
            this.aSL.setTouchable(true);
            this.aSL.setBackgroundDrawable(this.aSN.getDrawable(a.f.sdk_transparent_bg));
        }
        int dimensionPixelSize2 = this.aSN.getDimensionPixelSize(a.e.sdk_ds8);
        ShowUtil.showPopupWindowAsDropDown(this.aSL, view, ((-dimensionPixelSize) / 2) + (this.aSN.getDimensionPixelSize(a.e.sdk_ds52) / 2), -dimensionPixelSize2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aSK == view) {
            this.aSL.dismiss();
        }
    }

    public void n(String str, String str2, final String str3) {
        if (this.aSM == null) {
            this.aSM = new BdAlertDialog(this.mPageContext.getPageActivity());
            this.aSM.setCanceledOnTouchOutside(false);
        }
        this.aSM.setTitle(str);
        this.aSM.setMessage(str2);
        this.aSM.setTitleShowCenter(true);
        this.aSM.setMessageShowCenter(true);
        this.aSM.setMessageTextColor(this.mPageContext.getResources().getColor(a.d.sdk_cp_cont_f));
        this.aSM.isShowTitleAndMessage();
        this.aSM.setPositiveButton("复制添加", new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.d.2
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
        this.aSM.show();
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

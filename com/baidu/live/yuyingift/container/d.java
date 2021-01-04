package com.baidu.live.yuyingift.container;

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
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
/* loaded from: classes11.dex */
public class d implements View.OnClickListener {
    private BubbleLayout bbT;
    private PopupWindow bbU;
    private BdAlertDialog bbV;
    private Resources bbW;
    private TbPageContext mPageContext;

    public d(TbPageContext<AlaGiftTabActivity> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bbW = this.mPageContext.getPageActivity().getResources();
    }

    public void O(View view) {
        int dimensionPixelSize = this.bbW.getDimensionPixelSize(a.d.sdk_ds300);
        if (this.bbT == null) {
            this.bbT = (BubbleLayout) View.inflate(this.mPageContext.getPageActivity(), a.g.ala_gift_official_tip, null);
            this.bbT.setOnClickListener(this);
            this.bbU = new PopupWindow((View) this.bbT, dimensionPixelSize, this.bbW.getDimensionPixelSize(a.d.sdk_ds86), true);
            this.bbU.setTouchable(true);
            this.bbU.setBackgroundDrawable(this.bbW.getDrawable(a.e.sdk_transparent_bg));
        }
        int dimensionPixelSize2 = this.bbW.getDimensionPixelSize(a.d.sdk_ds8);
        ShowUtil.showPopupWindowAsDropDown(this.bbU, view, ((-dimensionPixelSize) / 2) + (this.bbW.getDimensionPixelSize(a.d.sdk_ds52) / 2), -dimensionPixelSize2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bbT == view) {
            this.bbU.dismiss();
        }
    }

    public void o(String str, String str2, final String str3) {
        if (this.bbV == null) {
            this.bbV = new BdAlertDialog(this.mPageContext.getPageActivity());
            this.bbV.setCanceledOnTouchOutside(false);
        }
        this.bbV.setTitle(str);
        this.bbV.setMessage(str2);
        this.bbV.setTitleShowCenter(true);
        this.bbV.setMessageShowCenter(true);
        this.bbV.setMessageTextColor(this.mPageContext.getResources().getColor(a.c.sdk_cp_cont_f));
        this.bbV.isShowTitleAndMessage();
        this.bbV.setPositiveButton("复制添加", new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.yuyingift.container.d.2
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "tycoon_copy_clk"));
                d.this.copyToClipboard(str3);
                BdToast.makeText(d.this.mPageContext.getPageActivity(), d.this.mPageContext.getResources().getString(a.h.sdk_copy_tip)).setDuration(17).show();
                bdAlertDialog.dismiss();
            }
        }).setNegativeButton(a.h.sdk_live_iknow, new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.yuyingift.container.d.1
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                bdAlertDialog.dismiss();
            }
        }).create(this.mPageContext);
        this.bbV.show();
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

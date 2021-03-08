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
/* loaded from: classes10.dex */
public class d implements View.OnClickListener {
    private BubbleLayout bbM;
    private PopupWindow bbN;
    private BdAlertDialog bbO;
    private Resources bbP;
    private TbPageContext mPageContext;

    public d(TbPageContext<AlaGiftTabActivity> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bbP = this.mPageContext.getPageActivity().getResources();
    }

    public void O(View view) {
        int dimensionPixelSize = this.bbP.getDimensionPixelSize(a.d.sdk_ds300);
        if (this.bbM == null) {
            this.bbM = (BubbleLayout) View.inflate(this.mPageContext.getPageActivity(), a.g.ala_gift_official_tip, null);
            this.bbM.setOnClickListener(this);
            this.bbN = new PopupWindow((View) this.bbM, dimensionPixelSize, this.bbP.getDimensionPixelSize(a.d.sdk_ds86), true);
            this.bbN.setTouchable(true);
            this.bbN.setBackgroundDrawable(this.bbP.getDrawable(a.e.sdk_transparent_bg));
        }
        int dimensionPixelSize2 = this.bbP.getDimensionPixelSize(a.d.sdk_ds8);
        ShowUtil.showPopupWindowAsDropDown(this.bbN, view, ((-dimensionPixelSize) / 2) + (this.bbP.getDimensionPixelSize(a.d.sdk_ds52) / 2), -dimensionPixelSize2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bbM == view) {
            this.bbN.dismiss();
        }
    }

    public void n(String str, String str2, final String str3) {
        if (this.bbO == null) {
            this.bbO = new BdAlertDialog(this.mPageContext.getPageActivity());
            this.bbO.setCanceledOnTouchOutside(false);
        }
        this.bbO.setTitle(str);
        this.bbO.setMessage(str2);
        this.bbO.setTitleShowCenter(true);
        this.bbO.setMessageShowCenter(true);
        this.bbO.setMessageTextColor(this.mPageContext.getResources().getColor(a.c.sdk_cp_cont_f));
        this.bbO.isShowTitleAndMessage();
        this.bbO.setPositiveButton("复制添加", new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.yuyingift.container.d.2
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
        this.bbO.show();
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

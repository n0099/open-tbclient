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
/* loaded from: classes11.dex */
public class d implements View.OnClickListener {
    private BubbleLayout bal;
    private PopupWindow bam;
    private BdAlertDialog ban;
    private Resources bao;
    private TbPageContext mPageContext;

    public d(TbPageContext<AlaGiftTabActivity> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bao = this.mPageContext.getPageActivity().getResources();
    }

    public void O(View view) {
        int dimensionPixelSize = this.bao.getDimensionPixelSize(a.d.sdk_ds300);
        if (this.bal == null) {
            this.bal = (BubbleLayout) View.inflate(this.mPageContext.getPageActivity(), a.g.ala_gift_official_tip, null);
            this.bal.setOnClickListener(this);
            this.bam = new PopupWindow((View) this.bal, dimensionPixelSize, this.bao.getDimensionPixelSize(a.d.sdk_ds86), true);
            this.bam.setTouchable(true);
            this.bam.setBackgroundDrawable(this.bao.getDrawable(a.e.sdk_transparent_bg));
        }
        int dimensionPixelSize2 = this.bao.getDimensionPixelSize(a.d.sdk_ds8);
        ShowUtil.showPopupWindowAsDropDown(this.bam, view, ((-dimensionPixelSize) / 2) + (this.bao.getDimensionPixelSize(a.d.sdk_ds52) / 2), -dimensionPixelSize2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bal == view) {
            this.bam.dismiss();
        }
    }

    public void n(String str, String str2, final String str3) {
        if (this.ban == null) {
            this.ban = new BdAlertDialog(this.mPageContext.getPageActivity());
            this.ban.setCanceledOnTouchOutside(false);
        }
        this.ban.setTitle(str);
        this.ban.setMessage(str2);
        this.ban.setTitleShowCenter(true);
        this.ban.setMessageShowCenter(true);
        this.ban.setMessageTextColor(this.mPageContext.getResources().getColor(a.c.sdk_cp_cont_f));
        this.ban.isShowTitleAndMessage();
        this.ban.setPositiveButton("复制添加", new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.d.2
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
        this.ban.show();
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

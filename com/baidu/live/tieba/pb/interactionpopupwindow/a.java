package com.baidu.live.tieba.pb.interactionpopupwindow;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tieba.pb.interactionpopupwindow.IBaseDialogData;
import com.baidu.live.tieba.pb.interactionpopupwindow.d;
/* loaded from: classes4.dex */
public abstract class a<V extends d, D extends IBaseDialogData> implements c {
    private DialogInterface.OnDismissListener bFI;
    protected V bFM;
    protected D bFN;
    private DialogInterface.OnCancelListener mCancelListenr;
    protected Context mContext;
    private AlertDialog mDialog;
    private DialogInterface.OnKeyListener mOnKeyListener;
    protected TbPageContext mPageContext;
    private int mDialogGravity = -1;
    private boolean bFJ = true;
    private boolean bFK = false;
    private boolean bFL = false;

    public a(TbPageContext tbPageContext, V v, D d) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.bFM = v;
        this.bFN = d;
        a((a<V, D>) d);
    }

    public void show() {
        if (this.mDialog != null) {
            ShowUtil.showDialog(this.mDialog, this.mPageContext.getPageActivity());
            return;
        }
        if (this.bFK) {
            if (this.bFL) {
                this.mDialog = new AlertDialog.Builder(this.mContext, a.i.sdk_search_dialog_from_bottom_in).create();
            } else {
                this.mDialog = new AlertDialog.Builder(this.mContext, a.i.sdk_search_dialog).create();
            }
        } else {
            this.mDialog = new AlertDialog.Builder(this.mContext).create();
        }
        this.mDialog.setCanceledOnTouchOutside(Ty());
        this.mDialog.setCancelable(Tz());
        this.mDialog.setOnKeyListener(this.mOnKeyListener);
        if (this.mCancelListenr != null) {
            this.mDialog.setOnCancelListener(this.mCancelListenr);
        }
        if (this.bFI != null) {
            this.mDialog.setOnDismissListener(this.bFI);
        }
        ShowUtil.showDialog(this.mDialog, this.mPageContext.getPageActivity());
        if (this.mDialog.getWindow().getDecorView().getParent() != null) {
            Window window = this.mDialog.getWindow();
            if (this.mDialogGravity == -1) {
                this.mDialogGravity = 17;
            }
            window.setGravity(this.mDialogGravity);
            window.setBackgroundDrawableResource(a.e.sdk_transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            DisplayMetrics screenSize = BdUtilHelper.getScreenSize(this.mPageContext.getPageActivity());
            if (screenSize != null) {
                int dialogMargin = getDialogMargin();
                if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                    attributes.width = screenSize.heightPixels - (dialogMargin * 2);
                } else {
                    attributes.width = screenSize.widthPixels - (dialogMargin * 2);
                }
            }
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.bFM.getViewGroup());
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public void dismiss() {
        if (this.mDialog != null) {
            ShowUtil.dismissDialog(this.mDialog, this.mPageContext.getPageActivity());
        }
    }

    public a a(DialogInterface.OnDismissListener onDismissListener) {
        this.bFI = onDismissListener;
        return this;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean isShowing() {
        if (this.mDialog != null) {
            return this.mDialog.isShowing();
        }
        return false;
    }

    public a gn(int i) {
        this.mDialogGravity = i;
        return this;
    }

    public a cX(boolean z) {
        this.bFK = z;
        return this;
    }

    public void a(D d) {
        if (this.bFM != null) {
            this.bFM.a(d);
        }
    }

    public void cY(boolean z) {
        this.bFL = z;
    }
}

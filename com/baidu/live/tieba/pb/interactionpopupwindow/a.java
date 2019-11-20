package com.baidu.live.tieba.pb.interactionpopupwindow;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tieba.pb.interactionpopupwindow.IBaseDialogData;
import com.baidu.live.tieba.pb.interactionpopupwindow.d;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public abstract class a<V extends d, D extends IBaseDialogData> implements c {
    protected V anK;
    protected D anL;
    private DialogInterface.OnCancelListener mCancelListenr;
    protected Context mContext;
    private AlertDialog mDialog;
    private DialogInterface.OnKeyListener mOnKeyListener;
    protected TbPageContext mPageContext;
    private int mDialogGravity = -1;
    private boolean anI = true;
    private boolean anJ = false;

    public a(TbPageContext tbPageContext, V v, D d) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.anK = v;
        this.anL = d;
        a(d);
    }

    public void show() {
        if (this.mDialog != null) {
            ShowUtil.showDialog(this.mDialog, this.mPageContext.getPageActivity());
            return;
        }
        if (this.anJ) {
            this.mDialog = new AlertDialog.Builder(this.mContext, a.j.sdk_search_dialog).create();
        } else {
            this.mDialog = new AlertDialog.Builder(this.mContext).create();
        }
        this.mDialog.setCanceledOnTouchOutside(vr());
        this.mDialog.setCancelable(vs());
        this.mDialog.setOnKeyListener(this.mOnKeyListener);
        if (this.mCancelListenr != null) {
            this.mDialog.setOnCancelListener(this.mCancelListenr);
        }
        ShowUtil.showDialog(this.mDialog, this.mPageContext.getPageActivity());
        if (this.mDialog.getWindow().getDecorView().getParent() != null) {
            Window window = this.mDialog.getWindow();
            if (this.mDialogGravity == -1) {
                this.mDialogGravity = 17;
            }
            window.setGravity(this.mDialogGravity);
            window.setBackgroundDrawableResource(a.f.sdk_transparent_bg);
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
            window.setContentView(this.anK.getViewGroup());
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            ViewHelper.processAllViewsIn(this.anK.getViewGroup(), false, new ViewHelper.ViewCallback() { // from class: com.baidu.live.tieba.pb.interactionpopupwindow.a.1
                @Override // com.baidu.live.tbadk.core.util.ViewHelper.ViewCallback
                public boolean onViewFound(View view) {
                    if (view instanceof EditText) {
                        atomicBoolean.set(true);
                        return true;
                    }
                    return false;
                }
            });
            if (atomicBoolean.get()) {
                window.clearFlags(131080);
            }
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public void dismiss() {
        if (this.mDialog != null) {
            ShowUtil.dismissDialog(this.mDialog, this.mPageContext.getPageActivity());
        }
    }

    public boolean isShowing() {
        if (this.mDialog != null) {
            return this.mDialog.isShowing();
        }
        return false;
    }

    public a ca(int i) {
        this.mDialogGravity = i;
        return this;
    }

    public a aI(boolean z) {
        this.anJ = z;
        return this;
    }

    public void a(D d) {
        if (this.anK != null) {
            this.anK.a(d);
        }
    }
}

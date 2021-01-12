package com.baidu.tbadk.core.business;

import android.app.Activity;
import android.app.AlertDialog;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a {
    private ViewGroup bgT;
    private com.baidu.tbadk.BdToken.completeTask.a eIf;
    private EMTextView eIg;
    private EMTextView eIh;
    private EMTextView eIi;
    private EMTextView eIj;
    private InterfaceC0559a eIk;
    private final Activity mActivity;
    private AlertDialog mDialog;
    private View mRootView;
    private boolean mDialogCreated = false;
    private boolean cancelableFlag = true;
    private int mDialogGravity = -1;
    private View.OnClickListener eIl = new View.OnClickListener() { // from class: com.baidu.tbadk.core.business.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.eIk != null) {
                a.this.eIk.onCancel();
                a.this.mDialog.dismiss();
            }
        }
    };
    private View.OnClickListener eIm = new View.OnClickListener() { // from class: com.baidu.tbadk.core.business.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.eIk != null) {
                a.this.eIk.bkb();
                a.this.mDialog.dismiss();
            }
        }
    };

    /* renamed from: com.baidu.tbadk.core.business.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0559a {
        void bkb();

        void onCancel();
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.bgT = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.business_alert_dialog, (ViewGroup) null);
    }

    public void a(com.baidu.tbadk.BdToken.completeTask.a aVar) {
        this.eIf = aVar;
    }

    public void a(InterfaceC0559a interfaceC0559a) {
        this.eIk = interfaceC0559a;
    }

    public a bkN() {
        if (!this.mDialogCreated) {
            this.mDialogCreated = true;
            this.mRootView = this.bgT.findViewById(R.id.root_dialog_view);
            this.eIg = (EMTextView) this.bgT.findViewById(R.id.title);
            this.eIh = (EMTextView) this.bgT.findViewById(R.id.content);
            this.eIi = (EMTextView) this.bgT.findViewById(R.id.cancel);
            this.eIj = (EMTextView) this.bgT.findViewById(R.id.confirm);
            this.eIi.setClickable(true);
            this.eIj.setClickable(true);
            this.eIi.setOnClickListener(this.eIl);
            this.eIj.setOnClickListener(this.eIm);
        }
        return this;
    }

    public a bkO() {
        if (!this.mDialogCreated) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        this.mDialog = new AlertDialog.Builder(this.mActivity).create();
        this.mDialog.setCanceledOnTouchOutside(this.cancelableFlag);
        g.showDialog(this.mDialog, this.mActivity);
        bkt();
        onChangeSkinType();
        Window window = this.mDialog.getWindow();
        if (this.mDialogGravity == -1) {
            this.mDialogGravity = 17;
        }
        window.setGravity(this.mDialogGravity);
        window.setBackgroundDrawableResource(R.drawable.transparent_bg);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.7f;
        attributes.width = -1;
        DisplayMetrics screenSize = l.getScreenSize(this.mActivity);
        if (screenSize != null) {
            int dimens = l.getDimens(this.mActivity, R.dimen.M_W_X009);
            if (UtilHelper.getRealScreenOrientation(this.mActivity) == 2) {
                attributes.width = screenSize.heightPixels - (dimens * 2);
            } else {
                attributes.width = screenSize.widthPixels - (dimens * 2);
            }
        }
        attributes.height = -2;
        window.setAttributes(attributes);
        window.setContentView(this.bgT);
        return this;
    }

    private void bkt() {
        if (this.eIf != null) {
            this.eIg.setText(this.eIf.title);
            this.eIh.setText(this.eIf.subTitle);
            this.eIi.setText(this.eIf.eDE);
            this.eIj.setText(this.eIf.eDH);
        }
    }

    private void onChangeSkinType() {
        if (this.eIf != null) {
            com.baidu.tbadk.core.elementsMaven.c.bv(this.mRootView).od(R.string.J_X06).setBackGroundColor(R.color.CAM_X0201);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.eIg).nX(R.string.F_X02).nV(R.color.CAM_X0105);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.eIh).nV(R.color.CAM_X0107);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.eIi).nV(R.color.CAM_X0105).od(R.string.J_X07).og(R.dimen.L_X02).of(R.color.CAM_X0902);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.eIj).nV(R.color.CAM_X0304).od(R.string.J_X07).oh(R.string.A_X07).og(R.dimen.L_X02).of(R.color.CAM_X0304);
        }
    }
}

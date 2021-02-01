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
    private ViewGroup bkk;
    private com.baidu.tbadk.BdToken.completeTask.a eKl;
    private EMTextView eKm;
    private EMTextView eKn;
    private EMTextView eKo;
    private EMTextView eKp;
    private InterfaceC0556a eKq;
    private final Activity mActivity;
    private AlertDialog mDialog;
    private View mRootView;
    private boolean mDialogCreated = false;
    private boolean cancelableFlag = true;
    private int mDialogGravity = -1;
    private View.OnClickListener eKr = new View.OnClickListener() { // from class: com.baidu.tbadk.core.business.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.eKq != null) {
                a.this.eKq.onCancel();
                a.this.mDialog.dismiss();
            }
        }
    };
    private View.OnClickListener eKs = new View.OnClickListener() { // from class: com.baidu.tbadk.core.business.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.eKq != null) {
                a.this.eKq.bkt();
                a.this.mDialog.dismiss();
            }
        }
    };

    /* renamed from: com.baidu.tbadk.core.business.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0556a {
        void bkt();

        void onCancel();
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.bkk = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.business_alert_dialog, (ViewGroup) null);
    }

    public void a(com.baidu.tbadk.BdToken.completeTask.a aVar) {
        this.eKl = aVar;
    }

    public void a(InterfaceC0556a interfaceC0556a) {
        this.eKq = interfaceC0556a;
    }

    public a blf() {
        if (!this.mDialogCreated) {
            this.mDialogCreated = true;
            this.mRootView = this.bkk.findViewById(R.id.root_dialog_view);
            this.eKm = (EMTextView) this.bkk.findViewById(R.id.title);
            this.eKn = (EMTextView) this.bkk.findViewById(R.id.content);
            this.eKo = (EMTextView) this.bkk.findViewById(R.id.cancel);
            this.eKp = (EMTextView) this.bkk.findViewById(R.id.confirm);
            this.eKo.setClickable(true);
            this.eKp.setClickable(true);
            this.eKo.setOnClickListener(this.eKr);
            this.eKp.setOnClickListener(this.eKs);
        }
        return this;
    }

    public a blg() {
        if (!this.mDialogCreated) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        this.mDialog = new AlertDialog.Builder(this.mActivity).create();
        this.mDialog.setCanceledOnTouchOutside(this.cancelableFlag);
        g.showDialog(this.mDialog, this.mActivity);
        bkL();
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
        window.setContentView(this.bkk);
        return this;
    }

    private void bkL() {
        if (this.eKl != null) {
            this.eKm.setText(this.eKl.title);
            this.eKn.setText(this.eKl.subTitle);
            this.eKo.setText(this.eKl.eFL);
            this.eKp.setText(this.eKl.eFO);
        }
    }

    private void onChangeSkinType() {
        if (this.eKl != null) {
            com.baidu.tbadk.core.elementsMaven.c.br(this.mRootView).og(R.string.J_X06).setBackGroundColor(R.color.CAM_X0201);
            com.baidu.tbadk.core.elementsMaven.c.br(this.eKm).oa(R.string.F_X02).nY(R.color.CAM_X0105);
            com.baidu.tbadk.core.elementsMaven.c.br(this.eKn).nY(R.color.CAM_X0107);
            com.baidu.tbadk.core.elementsMaven.c.br(this.eKo).nY(R.color.CAM_X0105).og(R.string.J_X07).ok(R.dimen.L_X02).oj(R.color.CAM_X0902);
            com.baidu.tbadk.core.elementsMaven.c.br(this.eKp).nY(R.color.CAM_X0304).og(R.string.J_X07).ol(R.string.A_X07).ok(R.dimen.L_X02).oj(R.color.CAM_X0304);
        }
    }
}

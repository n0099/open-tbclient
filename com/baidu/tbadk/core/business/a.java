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
    private ViewGroup blK;
    private com.baidu.tbadk.BdToken.completeTask.a eLM;
    private EMTextView eLN;
    private EMTextView eLO;
    private EMTextView eLP;
    private EMTextView eLQ;
    private InterfaceC0562a eLR;
    private final Activity mActivity;
    private AlertDialog mDialog;
    private View mRootView;
    private boolean mDialogCreated = false;
    private boolean cancelableFlag = true;
    private int mDialogGravity = -1;
    private View.OnClickListener eLS = new View.OnClickListener() { // from class: com.baidu.tbadk.core.business.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.eLR != null) {
                a.this.eLR.onCancel();
                a.this.mDialog.dismiss();
            }
        }
    };
    private View.OnClickListener eLT = new View.OnClickListener() { // from class: com.baidu.tbadk.core.business.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.eLR != null) {
                a.this.eLR.bkv();
                a.this.mDialog.dismiss();
            }
        }
    };

    /* renamed from: com.baidu.tbadk.core.business.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0562a {
        void bkv();

        void onCancel();
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.blK = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.business_alert_dialog, (ViewGroup) null);
    }

    public void a(com.baidu.tbadk.BdToken.completeTask.a aVar) {
        this.eLM = aVar;
    }

    public void a(InterfaceC0562a interfaceC0562a) {
        this.eLR = interfaceC0562a;
    }

    public a blh() {
        if (!this.mDialogCreated) {
            this.mDialogCreated = true;
            this.mRootView = this.blK.findViewById(R.id.root_dialog_view);
            this.eLN = (EMTextView) this.blK.findViewById(R.id.title);
            this.eLO = (EMTextView) this.blK.findViewById(R.id.content);
            this.eLP = (EMTextView) this.blK.findViewById(R.id.cancel);
            this.eLQ = (EMTextView) this.blK.findViewById(R.id.confirm);
            this.eLP.setClickable(true);
            this.eLQ.setClickable(true);
            this.eLP.setOnClickListener(this.eLS);
            this.eLQ.setOnClickListener(this.eLT);
        }
        return this;
    }

    public a bli() {
        if (!this.mDialogCreated) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        this.mDialog = new AlertDialog.Builder(this.mActivity).create();
        this.mDialog.setCanceledOnTouchOutside(this.cancelableFlag);
        g.showDialog(this.mDialog, this.mActivity);
        bkN();
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
        window.setContentView(this.blK);
        return this;
    }

    private void bkN() {
        if (this.eLM != null) {
            this.eLN.setText(this.eLM.title);
            this.eLO.setText(this.eLM.subTitle);
            this.eLP.setText(this.eLM.eHm);
            this.eLQ.setText(this.eLM.eHp);
        }
    }

    private void onChangeSkinType() {
        if (this.eLM != null) {
            com.baidu.tbadk.core.elementsMaven.c.br(this.mRootView).oh(R.string.J_X06).setBackGroundColor(R.color.CAM_X0201);
            com.baidu.tbadk.core.elementsMaven.c.br(this.eLN).ob(R.string.F_X02).nZ(R.color.CAM_X0105);
            com.baidu.tbadk.core.elementsMaven.c.br(this.eLO).nZ(R.color.CAM_X0107);
            com.baidu.tbadk.core.elementsMaven.c.br(this.eLP).nZ(R.color.CAM_X0105).oh(R.string.J_X07).ol(R.dimen.L_X02).ok(R.color.CAM_X0902);
            com.baidu.tbadk.core.elementsMaven.c.br(this.eLQ).nZ(R.color.CAM_X0304).oh(R.string.J_X07).om(R.string.A_X07).ol(R.dimen.L_X02).ok(R.color.CAM_X0304);
        }
    }
}

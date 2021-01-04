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
    private ViewGroup blI;
    private com.baidu.tbadk.BdToken.completeTask.a eMQ;
    private EMTextView eMR;
    private EMTextView eMS;
    private EMTextView eMT;
    private EMTextView eMU;
    private InterfaceC0576a eMV;
    private final Activity mActivity;
    private AlertDialog mDialog;
    private View mRootView;
    private boolean mDialogCreated = false;
    private boolean cancelableFlag = true;
    private int mDialogGravity = -1;
    private View.OnClickListener eMW = new View.OnClickListener() { // from class: com.baidu.tbadk.core.business.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.eMV != null) {
                a.this.eMV.onCancel();
                a.this.mDialog.dismiss();
            }
        }
    };
    private View.OnClickListener eMX = new View.OnClickListener() { // from class: com.baidu.tbadk.core.business.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.eMV != null) {
                a.this.eMV.bnU();
                a.this.mDialog.dismiss();
            }
        }
    };

    /* renamed from: com.baidu.tbadk.core.business.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0576a {
        void bnU();

        void onCancel();
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.blI = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.business_alert_dialog, (ViewGroup) null);
    }

    public void a(com.baidu.tbadk.BdToken.completeTask.a aVar) {
        this.eMQ = aVar;
    }

    public void a(InterfaceC0576a interfaceC0576a) {
        this.eMV = interfaceC0576a;
    }

    public a boG() {
        if (!this.mDialogCreated) {
            this.mDialogCreated = true;
            this.mRootView = this.blI.findViewById(R.id.root_dialog_view);
            this.eMR = (EMTextView) this.blI.findViewById(R.id.title);
            this.eMS = (EMTextView) this.blI.findViewById(R.id.content);
            this.eMT = (EMTextView) this.blI.findViewById(R.id.cancel);
            this.eMU = (EMTextView) this.blI.findViewById(R.id.confirm);
            this.eMT.setClickable(true);
            this.eMU.setClickable(true);
            this.eMT.setOnClickListener(this.eMW);
            this.eMU.setOnClickListener(this.eMX);
        }
        return this;
    }

    public a boH() {
        if (!this.mDialogCreated) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        this.mDialog = new AlertDialog.Builder(this.mActivity).create();
        this.mDialog.setCanceledOnTouchOutside(this.cancelableFlag);
        g.showDialog(this.mDialog, this.mActivity);
        bom();
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
        window.setContentView(this.blI);
        return this;
    }

    private void bom() {
        if (this.eMQ != null) {
            this.eMR.setText(this.eMQ.title);
            this.eMS.setText(this.eMQ.subTitle);
            this.eMT.setText(this.eMQ.eIp);
            this.eMU.setText(this.eMQ.eIs);
        }
    }

    private void onChangeSkinType() {
        if (this.eMQ != null) {
            com.baidu.tbadk.core.elementsMaven.c.bv(this.mRootView).pK(R.string.J_X06).setBackGroundColor(R.color.CAM_X0201);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.eMR).pE(R.string.F_X02).pC(R.color.CAM_X0105);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.eMS).pC(R.color.CAM_X0107);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.eMT).pC(R.color.CAM_X0105).pK(R.string.J_X07).pN(R.dimen.L_X02).pM(R.color.CAM_X0902);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.eMU).pC(R.color.CAM_X0304).pK(R.string.J_X07).pO(R.string.A_X07).pN(R.dimen.L_X02).pM(R.color.CAM_X0304);
        }
    }
}

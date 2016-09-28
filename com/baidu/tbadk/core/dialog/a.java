package com.baidu.tbadk.core.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.h.j;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tieba.r;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    private String VA;
    private String VB;
    private b VE;
    private b VF;
    private DialogInterface.OnCancelListener VG;
    private DialogInterface.OnKeyListener VH;
    private AlertDialog VI;
    private final ViewGroup VJ;
    private ViewGroup VK;
    private Object VN;
    private TextView VO;
    private TextView VP;
    private View VQ;
    private View VR;
    protected final Activity mActivity;
    private View mContentView;
    private String mMessage;
    private String mTitle;
    private int Vx = -1;
    private boolean Vy = false;
    private boolean Vz = false;
    private int VC = -1;
    private int VD = 0;
    private boolean VL = false;
    private boolean VM = true;
    private boolean mCancelable = true;
    private boolean isAutoNight = true;

    /* loaded from: classes.dex */
    public interface b {
        void onClick(a aVar);
    }

    public a cC(String str) {
        this.mTitle = str;
        return this;
    }

    public a bY(int i) {
        cC(this.mActivity.getResources().getString(i));
        return this;
    }

    public a cD(String str) {
        this.mMessage = str;
        return this;
    }

    public a z(View view) {
        this.mContentView = view;
        return this;
    }

    public a a(DialogInterface.OnCancelListener onCancelListener) {
        this.VG = onCancelListener;
        return this;
    }

    public a a(String str, b bVar) {
        this.VA = str;
        this.VE = bVar;
        return this;
    }

    public a b(String str, b bVar) {
        this.VB = str;
        this.VF = bVar;
        return this;
    }

    public a bZ(int i) {
        if (this.mActivity != null) {
            this.mMessage = this.mActivity.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, b bVar) {
        if (this.mActivity != null) {
            this.VA = this.mActivity.getResources().getString(i);
            this.VE = bVar;
        }
        return this;
    }

    public a b(int i, b bVar) {
        if (this.mActivity != null) {
            this.VB = this.mActivity.getResources().getString(i);
            this.VF = bVar;
        }
        return this;
    }

    public a aq(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public a ar(boolean z) {
        this.VM = z;
        return this;
    }

    public a(Activity activity) {
        this.mActivity = activity;
        this.VJ = (ViewGroup) LayoutInflater.from(activity).inflate(r.h.dialog_bdalert, (ViewGroup) null);
        this.VK = (ViewGroup) this.VJ.findViewById(r.g.real_view);
    }

    public a ca(int i) {
        if (isAutoNight()) {
            this.VC = av.getColor(i);
        } else {
            this.VC = this.mActivity.getResources().getColor(i);
        }
        return this;
    }

    public a cb(int i) {
        this.VD = i;
        return this;
    }

    public a b(com.baidu.adp.base.h<?> hVar) {
        boolean z;
        boolean z2 = true;
        if (!this.VL) {
            this.VL = true;
            LinearLayout linearLayout = (LinearLayout) this.VJ.findViewById(r.g.dialog_content);
            this.VO = (TextView) this.VJ.findViewById(r.g.yes);
            this.VP = (TextView) this.VJ.findViewById(r.g.no);
            this.VQ = this.VJ.findViewById(r.g.divider_yes_no_button);
            this.VR = this.VJ.findViewById(r.g.bdDialog_divider_line);
            if (this.mContentView != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.mContentView);
            } else {
                View tj = tj();
                if (tj != null) {
                    linearLayout.removeAllViews();
                    linearLayout.addView(tj);
                }
            }
            c(hVar);
            if (this.VC != -1) {
                if (this.VO != null) {
                    this.VO.setTextColor(this.VC);
                }
                if (this.VP != null) {
                    this.VP.setTextColor(this.VC);
                }
            }
            if (TextUtils.isEmpty(this.VA) || this.VO == null) {
                z = false;
            } else {
                this.VO.setText(this.VA);
                this.VO.setTag(this.VN);
                if (this.VE != null) {
                    this.VO.setOnClickListener(new View$OnClickListenerC0035a(this, this.VE));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.VB) || this.VP == null) {
                z2 = false;
            } else {
                this.VP.setText(this.VB);
                if (this.VF != null) {
                    this.VP.setOnClickListener(new View$OnClickListenerC0035a(this, this.VF));
                }
            }
            f(z, z2);
        }
        return this;
    }

    public View tj() {
        boolean z = !StringUtils.isNull(this.mTitle);
        boolean z2 = StringUtils.isNull(this.mMessage) ? false : true;
        if (z || z2) {
            if (z && z2) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(r.h.bdalert_two_message_view, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(r.g.title_view);
                TextView textView2 = (TextView) linearLayout.findViewById(r.g.message_view);
                if (this.Vy) {
                    textView.setGravity(17);
                    textView2.setGravity(17);
                }
                if (this.Vz) {
                    textView.setGravity(17);
                }
                textView.setText(this.mTitle);
                textView2.setText(this.mMessage);
                return linearLayout;
            }
            LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(r.h.bdalert_one_message_view, (ViewGroup) null);
            TextView textView3 = (TextView) linearLayout2.findViewById(r.g.message_view);
            if (z) {
                textView3.setText(this.mTitle);
                return linearLayout2;
            }
            textView3.setText(this.mMessage);
            return linearLayout2;
        }
        return null;
    }

    public void c(com.baidu.adp.base.h<?> hVar) {
        int skinType = isAutoNight() ? TbadkCoreApplication.m9getInst().getSkinType() : 0;
        if (hVar instanceof TbPageContext) {
            ((TbPageContext) hVar).getLayoutMode().ah(skinType == 1);
            ((TbPageContext) hVar).getLayoutMode().x(this.VJ);
            if (this.mContentView != null) {
                ((TbPageContext) hVar).getLayoutMode().x(this.mContentView);
            }
        }
        if (this.VJ != null) {
            this.VJ.setBackgroundResource(r.f.transparent_bg);
        }
    }

    private void f(boolean z, boolean z2) {
        if (z && z2) {
            if (this.VQ != null) {
                this.VQ.setVisibility(0);
            }
            if (this.VR != null) {
                this.VR.setVisibility(0);
                return;
            }
            return;
        }
        int skinType = isAutoNight() ? TbadkCoreApplication.m9getInst().getSkinType() : 0;
        if (this.VQ != null) {
            this.VQ.setVisibility(8);
        }
        if (!z && !z2) {
            if (this.VO != null && this.VP != null && this.VQ != null && this.VR != null) {
                this.VO.setVisibility(8);
                this.VP.setVisibility(8);
                this.VQ.setVisibility(8);
                this.VR.setVisibility(8);
            }
        } else if (z) {
            av.d(this.VO, r.f.dialog_single_button_bg_selector, skinType);
            if (this.VP != null && this.VQ != null && this.VR != null) {
                this.VR.setVisibility(0);
                this.VO.setVisibility(0);
                this.VP.setVisibility(8);
            }
        } else if (z2) {
            av.d(this.VP, r.f.dialog_single_button_bg_selector, skinType);
            if (this.VO != null && this.VQ != null && this.VR != null) {
                this.VR.setVisibility(0);
                this.VP.setVisibility(0);
                this.VO.setVisibility(8);
            }
        } else if (this.VO != null && this.VP != null && this.VR != null) {
            this.VR.setVisibility(8);
            this.VO.setVisibility(8);
            this.VP.setVisibility(8);
        }
    }

    public a tk() {
        return as(false);
    }

    private a as(boolean z) {
        if (!this.VL) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.VI != null) {
            if (z) {
                j.a(this.VI, this.mActivity);
            } else {
                this.VI.show();
            }
        } else {
            this.VI = new AlertDialog.Builder(this.mActivity).create();
            this.VI.setCanceledOnTouchOutside(this.VM && !this.mCancelable);
            this.VI.setCancelable(this.mCancelable);
            this.VI.setOnKeyListener(this.VH);
            if (this.VG != null) {
                this.VI.setOnCancelListener(this.VG);
            }
            if (z) {
                j.a(this.VI, this.mActivity);
            } else {
                this.VI.show();
            }
            Window window = this.VI.getWindow();
            if (this.Vx == -1) {
                this.Vx = 17;
            }
            window.setGravity(this.Vx);
            window.setBackgroundDrawableResource(r.f.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            DisplayMetrics n = k.n(this.mActivity);
            if (n != null) {
                attributes.width = n.widthPixels - (tl() * 2);
            }
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.VJ);
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bm.a(this.VJ, false, new com.baidu.tbadk.core.dialog.b(this, atomicBoolean));
            if (atomicBoolean.get()) {
                window.clearFlags(131080);
            }
        }
        return this;
    }

    public int tl() {
        return this.VD == 1 ? k.e(this.mActivity, r.e.ds40) : k.e(this.mActivity, r.e.ds90);
    }

    public boolean isShowing() {
        if (this.VI != null) {
            return this.VI.isShowing();
        }
        return false;
    }

    public void at(boolean z) {
        if (this.VO != null) {
            this.VO.setClickable(z);
        }
    }

    public void au(boolean z) {
        if (this.VP != null) {
            this.VP.setClickable(z);
        }
    }

    public a tm() {
        return as(true);
    }

    public void hide() {
        if (this.VI != null) {
            this.VI.hide();
        }
    }

    public void dismiss() {
        if (this.VI != null) {
            j.b(this.VI, this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.core.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0035a implements View.OnClickListener {
        private final a FD;
        private final b VU;

        public View$OnClickListenerC0035a(a aVar, b bVar) {
            this.FD = aVar;
            this.VU = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.VU != null) {
                this.VU.onClick(this.FD);
            }
        }
    }

    public ViewGroup tn() {
        return this.VK;
    }

    public void A(Object obj) {
        this.VN = obj;
    }

    public Object to() {
        return this.VN;
    }

    public boolean isAutoNight() {
        return this.isAutoNight;
    }

    public void setAutoNight(boolean z) {
        this.isAutoNight = z;
    }

    public Window getWindow() {
        return this.VI.getWindow();
    }

    public Dialog getDialog() {
        return this.VI;
    }

    public void av(boolean z) {
        this.Vy = z;
    }

    public void aw(boolean z) {
        this.Vz = z;
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.VH = onKeyListener;
    }

    public void reset() {
        this.VL = false;
    }
}

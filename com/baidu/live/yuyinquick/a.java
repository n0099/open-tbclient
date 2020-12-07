package com.baidu.live.yuyinquick;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.ci;
import com.baidu.live.gift.z;
import com.baidu.live.im.b.c;
import com.baidu.live.im.b.d;
import com.baidu.live.im.b.e;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.flex.FlexAdapter;
import com.baidu.live.tbadk.widget.flex.FlexLayout;
import com.baidu.live.view.Switch;
/* loaded from: classes4.dex */
public class a extends Dialog {
    private InterfaceC0250a bYe;
    private b bYf;
    private com.baidu.live.im.b.b bpS;
    private c bpU;
    private FrameLayout bpV;
    private FrameLayout bpW;
    private Switch bpX;
    private View buA;
    private FlexLayout buB;
    private BdPageContext buD;
    private View mContentView;

    /* renamed from: com.baidu.live.yuyinquick.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0250a {
        boolean NR();

        boolean Nh();

        int Nm();

        void QM();

        void b(int i, String str, ci ciVar);

        void onDismiss();
    }

    public a(@NonNull BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity(), a.i.sdk_TransparentDialog);
        this.buD = bdPageContext;
        init();
    }

    public void a(InterfaceC0250a interfaceC0250a) {
        this.bYe = interfaceC0250a;
    }

    public void a(String[] strArr, boolean z) {
        n(strArr);
        cG(z);
        show();
        if (this.mContentView != null) {
            this.mContentView.setVisibility(4);
            this.mContentView.post(new Runnable() { // from class: com.baidu.live.yuyinquick.a.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams;
                    if (a.this.buB != null && (layoutParams = a.this.buB.getLayoutParams()) != null) {
                        layoutParams.height = a.this.buB.realHeight;
                        a.this.buB.setLayoutParams(layoutParams);
                    }
                    a.this.JG();
                }
            });
        }
    }

    public void QN() {
        if (this.bpU != null) {
            this.bpU.f(z.Ii().Ik());
        }
    }

    private void init() {
        Ki();
        initView();
        HH();
    }

    private void Ki() {
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(17170445);
            window.setGravity(81);
            window.getDecorView().setPadding(0, 0, 0, 0);
            if (((WindowManager) getContext().getSystemService("window")) != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = -1;
                window.setAttributes(attributes);
            }
        }
    }

    private void initView() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        this.mContentView = LayoutInflater.from(getContext()).inflate(a.g.ala_im_quick_input_list, (ViewGroup) null);
        setContentView(this.mContentView);
        this.buA = findViewById(a.f.layout_barrage);
        this.bpX = (Switch) findViewById(a.f.switch_barrage);
        this.buB = (FlexLayout) findViewById(a.f.flex);
        this.bpW = (FrameLayout) findViewById(a.f.barrage_preview);
        this.bpV = (FrameLayout) findViewById(a.f.hlv_barrage_option);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501050, c.class, this.buD);
        if (runTask != null) {
            this.bpU = (c) runTask.getData();
        }
        if (this.bpU != null) {
            this.bpV.addView(this.bpU.getView());
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2501051, com.baidu.live.im.b.b.class, this.buD);
        if (runTask2 != null) {
            this.bpS = (com.baidu.live.im.b.b) runTask2.getData();
        }
        if (this.bpS != null) {
            this.bpW.addView(this.bpS.getView());
            this.bpW.setVisibility(8);
        }
        this.bpX.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.yuyinquick.a.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.cn(z);
            }
        });
        if (this.bpU != null) {
            this.bpU.setSelectEnabled(false);
            this.bpU.setCallback(new e() { // from class: com.baidu.live.yuyinquick.a.3
                @Override // com.baidu.live.im.b.e
                public boolean NR() {
                    return a.this.bYe != null && a.this.bYe.NR();
                }

                @Override // com.baidu.live.im.b.e
                public void fd(int i) {
                    a.this.co(false);
                }

                @Override // com.baidu.live.im.b.e
                public int Nm() {
                    if (a.this.bYe != null) {
                        return a.this.bYe.Nm();
                    }
                    return 0;
                }
            });
        }
        this.buB.setHorizontalSpacing(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds20));
        this.buB.setVerticalSpacing(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        this.buB.setOnItemClickListener(new FlexLayout.OnItemClickListener() { // from class: com.baidu.live.yuyinquick.a.4
            @Override // com.baidu.live.tbadk.widget.flex.FlexLayout.OnItemClickListener
            public void onItemClick(FlexLayout flexLayout, View view, int i) {
                ci ciVar;
                if (a.this.bYe != null) {
                    if (a.this.buA.getVisibility() == 0 && a.this.bpX.isChecked() && a.this.bpU != null) {
                        ci selectInfo = a.this.bpU.getSelectInfo();
                        if (selectInfo != null && selectInfo.type == 16 && (a.this.bYe == null || !a.this.bYe.NR())) {
                            BdUtilHelper.showToast(a.this.getContext().getApplicationContext(), a.h.sdk_throne_disabled_alert);
                            return;
                        } else if (selectInfo != null && selectInfo.type == 17 && selectInfo.aSI > a.this.bYe.Nm()) {
                            if (selectInfo.aSI == 7) {
                                BdUtilHelper.showToast(a.this.getContext().getApplicationContext(), a.h.sdk_noble_king_disabled_alert);
                                return;
                            } else {
                                BdUtilHelper.showToast(a.this.getContext().getApplicationContext(), a.h.sdk_noble_disabled_alert);
                                return;
                            }
                        } else {
                            ciVar = selectInfo;
                        }
                    } else {
                        ciVar = null;
                    }
                    a.this.bYe.b(i, a.this.bYf.getItem(i), ciVar);
                }
            }
        });
    }

    private void HH() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.live.yuyinquick.a.5
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (a.this.bYe != null) {
                    a.this.bYe.QM();
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.yuyinquick.a.6
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.bpS != null) {
                    a.this.bpS.release();
                }
                if (a.this.bYe != null) {
                    a.this.bYe.onDismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cn(boolean z) {
        if (z && this.bYe != null && !this.bYe.Nh()) {
            this.bpX.setChecked(false, false);
        } else if (this.bpU != null) {
            if (z) {
                this.bpU.setSwitchStatus(true);
                if (!TextUtils.isEmpty(d.NK().NO())) {
                    this.bpU.setSelectId(d.NK().NO());
                } else {
                    this.bpU.setSelectPos(0);
                }
                this.bpU.setSelectEnabled(true);
                co(true);
                return;
            }
            this.bpU.setSwitchStatus(false);
            this.bpU.setSelectEnabled(false);
            this.bpW.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void co(boolean z) {
        if (z && this.bpS != null) {
            this.bpS.setPreview();
        }
        if (this.bpS != null && this.bpU != null) {
            this.bpS.setUIInfo(this.bpU.getSelectInfo(), z);
        }
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.bpW.setVisibility(8);
        } else if (this.bpX != null && this.bpX.isChecked()) {
            this.bpW.setVisibility(0);
        }
    }

    private void cG(boolean z) {
        final ci[] fc = d.NK().fc(this.bYe != null ? this.bYe.Nm() : 0);
        if (fc == null || z) {
            if (this.bpX.isChecked()) {
                this.bpX.setChecked(false, false);
            } else {
                cn(false);
            }
            this.buA.setVisibility(8);
            return;
        }
        this.buA.setVisibility(0);
        if (this.bpU != null) {
            this.bpU.getView().post(new Runnable() { // from class: com.baidu.live.yuyinquick.a.7
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.bpU != null) {
                        a.this.bpU.setData(fc, z.Ii().Ik(), 1);
                        if (d.NK().NN()) {
                            if (a.this.bpX.isChecked()) {
                                a.this.bpU.setSelectId(d.NK().NO());
                                a.this.co(true);
                                return;
                            }
                            a.this.bpX.setChecked(true, false);
                        } else if (a.this.bpX.isChecked()) {
                            a.this.bpX.setChecked(false, false);
                        }
                    }
                }
            });
        }
    }

    private void n(String[] strArr) {
        if (this.bYf == null) {
            this.bYf = new b(strArr);
            this.buB.setAdapter(this.bYf);
            return;
        }
        this.bYf.setDatas(strArr);
        this.bYf.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JG() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.mContentView.startAnimation(translateAnimation);
        this.mContentView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b extends FlexAdapter<String> {
        b(String[] strArr) {
            super(strArr);
        }

        @Override // com.baidu.live.tbadk.widget.flex.FlexAdapter
        public View getView(int i, ViewGroup viewGroup) {
            QuickInputFlexTextView quickInputFlexTextView = new QuickInputFlexTextView(viewGroup.getContext());
            quickInputFlexTextView.setText(getItem(i));
            return quickInputFlexTextView;
        }
    }
}

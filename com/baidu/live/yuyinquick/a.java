package com.baidu.live.yuyinquick;

import android.app.Dialog;
import android.content.DialogInterface;
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
import androidx.annotation.NonNull;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.ck;
import com.baidu.live.gift.z;
import com.baidu.live.im.b.c;
import com.baidu.live.im.b.d;
import com.baidu.live.im.b.e;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.flex.FlexAdapter;
import com.baidu.live.tbadk.widget.flex.FlexLayout;
import com.baidu.live.view.Switch;
/* loaded from: classes10.dex */
public class a extends Dialog {
    private InterfaceC0241a bZY;
    private b bZZ;
    private com.baidu.live.im.b.b bmO;
    private c bmQ;
    private FrameLayout bmR;
    private FrameLayout bmS;
    private Switch bmT;
    private FlexLayout buA;
    private BdPageContext buC;
    private View buz;
    private View mContentView;

    /* renamed from: com.baidu.live.yuyinquick.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0241a {
        boolean IJ();

        int IP();

        boolean Jy();

        void b(int i, String str, ck ckVar);

        void onDismiss();

        void onShow();
    }

    public a(@NonNull BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity(), a.i.sdk_TransparentDialog);
        this.buC = bdPageContext;
        init();
    }

    public void a(InterfaceC0241a interfaceC0241a) {
        this.bZY = interfaceC0241a;
    }

    public void a(String[] strArr, boolean z) {
        n(strArr);
        show();
        if (this.mContentView != null) {
            this.mContentView.setVisibility(4);
            this.mContentView.post(new Runnable() { // from class: com.baidu.live.yuyinquick.a.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams;
                    if (a.this.buA != null && (layoutParams = a.this.buA.getLayoutParams()) != null) {
                        layoutParams.height = a.this.buA.realHeight;
                        a.this.buA.setLayoutParams(layoutParams);
                    }
                    a.this.Fn();
                }
            });
        }
    }

    public void NV() {
        if (this.bmQ != null) {
            this.bmQ.f(z.DO().DQ());
        }
    }

    private void init() {
        FP();
        initView();
        Dn();
    }

    private void FP() {
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
        this.mContentView = LayoutInflater.from(getContext()).inflate(a.g.ala_yuyin_im_quick_input_list, (ViewGroup) null);
        setContentView(this.mContentView);
        this.buz = findViewById(a.f.layout_barrage);
        this.bmT = (Switch) findViewById(a.f.switch_barrage);
        this.buA = (FlexLayout) findViewById(a.f.flex);
        this.bmS = (FrameLayout) findViewById(a.f.barrage_preview);
        this.bmR = (FrameLayout) findViewById(a.f.hlv_barrage_option);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501050, c.class, this.buC);
        if (runTask != null) {
            this.bmQ = (c) runTask.getData();
        }
        if (this.bmQ != null) {
            this.bmR.addView(this.bmQ.getView());
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2501051, com.baidu.live.im.b.b.class, this.buC);
        if (runTask2 != null) {
            this.bmO = (com.baidu.live.im.b.b) runTask2.getData();
        }
        if (this.bmO != null) {
            this.bmS.addView(this.bmO.getView());
            this.bmS.setVisibility(8);
        }
        this.bmT.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.yuyinquick.a.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.cl(z);
            }
        });
        if (this.bmQ != null) {
            this.bmQ.setSelectEnabled(false);
            this.bmQ.setCallback(new e() { // from class: com.baidu.live.yuyinquick.a.3
                @Override // com.baidu.live.im.b.e
                public boolean Jy() {
                    return a.this.bZY != null && a.this.bZY.Jy();
                }

                @Override // com.baidu.live.im.b.e
                public void dv(int i) {
                    a.this.cm(false);
                }

                @Override // com.baidu.live.im.b.e
                public int IP() {
                    if (a.this.bZY != null) {
                        return a.this.bZY.IP();
                    }
                    return 0;
                }
            });
        }
        this.buA.setHorizontalSpacing(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds20));
        this.buA.setVerticalSpacing(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        this.buA.setOnItemClickListener(new FlexLayout.OnItemClickListener() { // from class: com.baidu.live.yuyinquick.a.4
            @Override // com.baidu.live.tbadk.widget.flex.FlexLayout.OnItemClickListener
            public void onItemClick(FlexLayout flexLayout, View view, int i) {
                ck ckVar;
                if (a.this.bZY != null) {
                    if (a.this.buz.getVisibility() == 0 && a.this.bmT.isChecked() && a.this.bmQ != null) {
                        ck selectInfo = a.this.bmQ.getSelectInfo();
                        if (selectInfo != null && selectInfo.type == 16 && (a.this.bZY == null || !a.this.bZY.Jy())) {
                            BdUtilHelper.showToast(a.this.getContext().getApplicationContext(), a.h.sdk_throne_disabled_alert);
                            return;
                        } else if (selectInfo != null && selectInfo.type == 17 && selectInfo.aOT > a.this.bZY.IP()) {
                            if (selectInfo.aOT == 7) {
                                BdUtilHelper.showToast(a.this.getContext().getApplicationContext(), a.h.sdk_noble_king_disabled_alert);
                                return;
                            } else {
                                BdUtilHelper.showToast(a.this.getContext().getApplicationContext(), a.h.sdk_noble_disabled_alert);
                                return;
                            }
                        } else {
                            ckVar = selectInfo;
                        }
                    } else {
                        ckVar = null;
                    }
                    a.this.bZY.b(i, a.this.bZZ.getItem(i), ckVar);
                }
            }
        });
    }

    private void Dn() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.live.yuyinquick.a.5
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (a.this.bZY != null) {
                    a.this.bZY.onShow();
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.yuyinquick.a.6
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.bmO != null) {
                    a.this.bmO.release();
                }
                if (a.this.bZY != null) {
                    a.this.bZY.onDismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cl(boolean z) {
        if (z && this.bZY != null && !this.bZY.IJ()) {
            this.bmT.setChecked(false, false);
        } else if (this.bmQ != null) {
            if (z) {
                this.bmQ.setSwitchStatus(true);
                if (!TextUtils.isEmpty(d.Jp().Jt())) {
                    this.bmQ.setSelectId(d.Jp().Jt());
                } else {
                    this.bmQ.setSelectPos(0);
                }
                this.bmQ.setSelectEnabled(true);
                cm(true);
                return;
            }
            this.bmQ.setSwitchStatus(false);
            this.bmQ.setSelectEnabled(false);
            this.bmS.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cm(boolean z) {
        if (z && this.bmO != null) {
            this.bmO.setPreview();
        }
        if (this.bmO != null && this.bmQ != null) {
            this.bmO.setUIInfo(this.bmQ.getSelectInfo(), z);
        }
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.bmS.setVisibility(8);
        } else if (this.bmT != null && this.bmT.isChecked()) {
            this.bmS.setVisibility(0);
        }
    }

    private void n(String[] strArr) {
        if (this.bZZ == null) {
            this.bZZ = new b(strArr);
            this.buA.setAdapter(this.bZZ);
            return;
        }
        this.bZZ.setDatas(strArr);
        this.bZZ.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fn() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.mContentView.startAnimation(translateAnimation);
        this.mContentView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
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

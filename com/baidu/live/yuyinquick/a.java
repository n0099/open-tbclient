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
import com.baidu.live.data.cg;
import com.baidu.live.gift.y;
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
    private InterfaceC0243a bUy;
    private b bUz;
    private com.baidu.live.im.b.b bmu;
    private c bmw;
    private FrameLayout bmx;
    private FrameLayout bmy;
    private Switch bmz;
    private View bra;
    private FlexLayout brb;
    private BdPageContext brd;
    private View mContentView;

    /* renamed from: com.baidu.live.yuyinquick.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0243a {
        boolean LM();

        int LR();

        boolean Mn();

        void Pc();

        void b(int i, String str, cg cgVar);

        void onDismiss();
    }

    public a(@NonNull BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity(), a.i.sdk_TransparentDialog);
        this.brd = bdPageContext;
        init();
    }

    public void a(InterfaceC0243a interfaceC0243a) {
        this.bUy = interfaceC0243a;
    }

    public void a(String[] strArr, boolean z) {
        n(strArr);
        cq(z);
        show();
        if (this.mContentView != null) {
            this.mContentView.setVisibility(4);
            this.mContentView.post(new Runnable() { // from class: com.baidu.live.yuyinquick.a.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams;
                    if (a.this.brb != null && (layoutParams = a.this.brb.getLayoutParams()) != null) {
                        layoutParams.height = a.this.brb.realHeight;
                        a.this.brb.setLayoutParams(layoutParams);
                    }
                    a.this.Iy();
                }
            });
        }
    }

    public void Pd() {
        if (this.bmw != null) {
            this.bmw.f(y.Hc().He());
        }
    }

    private void init() {
        Pe();
        initView();
        GB();
    }

    private void Pe() {
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
        this.bra = findViewById(a.f.layout_barrage);
        this.bmz = (Switch) findViewById(a.f.switch_barrage);
        this.brb = (FlexLayout) findViewById(a.f.flex);
        this.bmy = (FrameLayout) findViewById(a.f.barrage_preview);
        this.bmx = (FrameLayout) findViewById(a.f.hlv_barrage_option);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501050, c.class, this.brd);
        if (runTask != null) {
            this.bmw = (c) runTask.getData();
        }
        if (this.bmw != null) {
            this.bmx.addView(this.bmw.getView());
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2501051, com.baidu.live.im.b.b.class, this.brd);
        if (runTask2 != null) {
            this.bmu = (com.baidu.live.im.b.b) runTask2.getData();
        }
        if (this.bmu != null) {
            this.bmy.addView(this.bmu.getView());
            this.bmy.setVisibility(8);
        }
        this.bmz.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.yuyinquick.a.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.cb(z);
            }
        });
        if (this.bmw != null) {
            this.bmw.setSelectEnabled(false);
            this.bmw.setCallback(new e() { // from class: com.baidu.live.yuyinquick.a.3
                @Override // com.baidu.live.im.b.e
                public boolean Mn() {
                    return a.this.bUy != null && a.this.bUy.Mn();
                }

                @Override // com.baidu.live.im.b.e
                public void ei(int i) {
                    a.this.cc(false);
                }

                @Override // com.baidu.live.im.b.e
                public int LR() {
                    if (a.this.bUy != null) {
                        return a.this.bUy.LR();
                    }
                    return 0;
                }
            });
        }
        this.brb.setHorizontalSpacing(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds20));
        this.brb.setVerticalSpacing(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        this.brb.setOnItemClickListener(new FlexLayout.OnItemClickListener() { // from class: com.baidu.live.yuyinquick.a.4
            @Override // com.baidu.live.tbadk.widget.flex.FlexLayout.OnItemClickListener
            public void onItemClick(FlexLayout flexLayout, View view, int i) {
                cg cgVar;
                if (a.this.bUy != null) {
                    if (a.this.bra.getVisibility() == 0 && a.this.bmz.isChecked() && a.this.bmw != null) {
                        cg selectInfo = a.this.bmw.getSelectInfo();
                        if (selectInfo != null && selectInfo.type == 16 && (a.this.bUy == null || !a.this.bUy.Mn())) {
                            BdUtilHelper.showToast(a.this.getContext().getApplicationContext(), a.h.sdk_throne_disabled_alert);
                            return;
                        } else if (selectInfo != null && selectInfo.type == 17 && selectInfo.aRr > a.this.bUy.LR()) {
                            if (selectInfo.aRr == 7) {
                                BdUtilHelper.showToast(a.this.getContext().getApplicationContext(), a.h.sdk_noble_king_disabled_alert);
                                return;
                            } else {
                                BdUtilHelper.showToast(a.this.getContext().getApplicationContext(), a.h.sdk_noble_disabled_alert);
                                return;
                            }
                        } else {
                            cgVar = selectInfo;
                        }
                    } else {
                        cgVar = null;
                    }
                    a.this.bUy.b(i, a.this.bUz.getItem(i), cgVar);
                }
            }
        });
    }

    private void GB() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.live.yuyinquick.a.5
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (a.this.bUy != null) {
                    a.this.bUy.Pc();
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.yuyinquick.a.6
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.bmu != null) {
                    a.this.bmu.release();
                }
                if (a.this.bUy != null) {
                    a.this.bUy.onDismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cb(boolean z) {
        if (z && this.bUy != null && !this.bUy.LM()) {
            this.bmz.setChecked(false, false);
        } else if (this.bmw != null) {
            if (z) {
                this.bmw.setSwitchStatus(true);
                if (!TextUtils.isEmpty(d.Mg().Mk())) {
                    this.bmw.setSelectId(d.Mg().Mk());
                } else {
                    this.bmw.setSelectPos(0);
                }
                this.bmw.setSelectEnabled(true);
                cc(true);
                return;
            }
            this.bmw.setSwitchStatus(false);
            this.bmw.setSelectEnabled(false);
            this.bmy.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cc(boolean z) {
        if (z && this.bmu != null) {
            this.bmu.setPreview();
        }
        if (this.bmu != null && this.bmw != null) {
            this.bmu.setUIInfo(this.bmw.getSelectInfo(), z);
        }
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.bmy.setVisibility(8);
        } else if (this.bmz != null && this.bmz.isChecked()) {
            this.bmy.setVisibility(0);
        }
    }

    private void cq(boolean z) {
        final cg[] eK = d.Mg().eK(this.bUy != null ? this.bUy.LR() : 0);
        if (eK == null || z) {
            if (this.bmz.isChecked()) {
                this.bmz.setChecked(false, false);
            } else {
                cb(false);
            }
            this.bra.setVisibility(8);
            return;
        }
        this.bra.setVisibility(0);
        if (this.bmw != null) {
            this.bmw.getView().post(new Runnable() { // from class: com.baidu.live.yuyinquick.a.7
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.bmw != null) {
                        a.this.bmw.setData(eK, y.Hc().He(), 1);
                        if (d.Mg().Mj()) {
                            if (a.this.bmz.isChecked()) {
                                a.this.bmw.setSelectId(d.Mg().Mk());
                                a.this.cc(true);
                                return;
                            }
                            a.this.bmz.setChecked(true, false);
                        } else if (a.this.bmz.isChecked()) {
                            a.this.bmz.setChecked(false, false);
                        }
                    }
                }
            });
        }
    }

    private void n(String[] strArr) {
        if (this.bUz == null) {
            this.bUz = new b(strArr);
            this.brb.setAdapter(this.bUz);
            return;
        }
        this.bUz.setDatas(strArr);
        this.bUz.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iy() {
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

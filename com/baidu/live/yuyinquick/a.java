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
import com.baidu.live.data.ce;
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
    private InterfaceC0231a bOO;
    private b bOP;
    private com.baidu.live.im.b.b bla;
    private c blc;
    private FrameLayout bld;
    private FrameLayout ble;
    private Switch blf;
    private View bpH;
    private FlexLayout bpI;
    private BdPageContext bpK;
    private View mContentView;

    /* renamed from: com.baidu.live.yuyinquick.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0231a {
        boolean LN();

        boolean Lm();

        int Lr();

        void OC();

        void b(int i, String str, ce ceVar);

        void onDismiss();
    }

    public a(@NonNull BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity(), a.j.sdk_TransparentDialog);
        this.bpK = bdPageContext;
        init();
    }

    public void a(InterfaceC0231a interfaceC0231a) {
        this.bOO = interfaceC0231a;
    }

    public void a(String[] strArr, boolean z) {
        n(strArr);
        cp(z);
        show();
        if (this.mContentView != null) {
            this.mContentView.setVisibility(4);
            this.mContentView.post(new Runnable() { // from class: com.baidu.live.yuyinquick.a.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams;
                    if (a.this.bpI != null && (layoutParams = a.this.bpI.getLayoutParams()) != null) {
                        layoutParams.height = a.this.bpI.realHeight;
                        a.this.bpI.setLayoutParams(layoutParams);
                    }
                    a.this.HX();
                }
            });
        }
    }

    public void OD() {
        if (this.blc != null) {
            this.blc.f(z.GB().GD());
        }
    }

    private void init() {
        OE();
        initView();
        Ga();
    }

    private void OE() {
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
        this.mContentView = LayoutInflater.from(getContext()).inflate(a.h.ala_im_quick_input_list, (ViewGroup) null);
        setContentView(this.mContentView);
        this.bpH = findViewById(a.g.layout_barrage);
        this.blf = (Switch) findViewById(a.g.switch_barrage);
        this.bpI = (FlexLayout) findViewById(a.g.flex);
        this.ble = (FrameLayout) findViewById(a.g.barrage_preview);
        this.bld = (FrameLayout) findViewById(a.g.hlv_barrage_option);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501050, c.class, this.bpK);
        if (runTask != null) {
            this.blc = (c) runTask.getData();
        }
        if (this.blc != null) {
            this.bld.addView(this.blc.getView());
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2501051, com.baidu.live.im.b.b.class, this.bpK);
        if (runTask2 != null) {
            this.bla = (com.baidu.live.im.b.b) runTask2.getData();
        }
        if (this.bla != null) {
            this.ble.addView(this.bla.getView());
            this.ble.setVisibility(8);
        }
        this.blf.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.yuyinquick.a.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.ca(z);
            }
        });
        if (this.blc != null) {
            this.blc.setSelectEnabled(false);
            this.blc.setCallback(new e() { // from class: com.baidu.live.yuyinquick.a.3
                @Override // com.baidu.live.im.b.e
                public boolean LN() {
                    return a.this.bOO != null && a.this.bOO.LN();
                }

                @Override // com.baidu.live.im.b.e
                public void ei(int i) {
                    a.this.cb(false);
                }

                @Override // com.baidu.live.im.b.e
                public int Lr() {
                    if (a.this.bOO != null) {
                        return a.this.bOO.Lr();
                    }
                    return 0;
                }
            });
        }
        this.bpI.setHorizontalSpacing(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20));
        this.bpI.setVerticalSpacing(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        this.bpI.setOnItemClickListener(new FlexLayout.OnItemClickListener() { // from class: com.baidu.live.yuyinquick.a.4
            @Override // com.baidu.live.tbadk.widget.flex.FlexLayout.OnItemClickListener
            public void onItemClick(FlexLayout flexLayout, View view, int i) {
                ce ceVar;
                if (a.this.bOO != null) {
                    if (a.this.bpH.getVisibility() == 0 && a.this.blf.isChecked() && a.this.blc != null) {
                        ce selectInfo = a.this.blc.getSelectInfo();
                        if (selectInfo != null && selectInfo.type == 16 && (a.this.bOO == null || !a.this.bOO.LN())) {
                            BdUtilHelper.showToast(a.this.getContext().getApplicationContext(), a.i.sdk_throne_disabled_alert);
                            return;
                        } else if (selectInfo != null && selectInfo.type == 17 && selectInfo.aQp > a.this.bOO.Lr()) {
                            if (selectInfo.aQp == 7) {
                                BdUtilHelper.showToast(a.this.getContext().getApplicationContext(), a.i.sdk_noble_king_disabled_alert);
                                return;
                            } else {
                                BdUtilHelper.showToast(a.this.getContext().getApplicationContext(), a.i.sdk_noble_disabled_alert);
                                return;
                            }
                        } else {
                            ceVar = selectInfo;
                        }
                    } else {
                        ceVar = null;
                    }
                    a.this.bOO.b(i, a.this.bOP.getItem(i), ceVar);
                }
            }
        });
    }

    private void Ga() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.live.yuyinquick.a.5
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (a.this.bOO != null) {
                    a.this.bOO.OC();
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.yuyinquick.a.6
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.bla != null) {
                    a.this.bla.release();
                }
                if (a.this.bOO != null) {
                    a.this.bOO.onDismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ca(boolean z) {
        if (z && this.bOO != null && !this.bOO.Lm()) {
            this.blf.setChecked(false, false);
        } else if (this.blc != null) {
            if (z) {
                this.blc.setSwitchStatus(true);
                if (!TextUtils.isEmpty(d.LG().LK())) {
                    this.blc.setSelectId(d.LG().LK());
                } else {
                    this.blc.setSelectPos(0);
                }
                this.blc.setSelectEnabled(true);
                cb(true);
                return;
            }
            this.blc.setSwitchStatus(false);
            this.blc.setSelectEnabled(false);
            this.ble.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cb(boolean z) {
        if (z && this.bla != null) {
            this.bla.setPreview();
        }
        if (this.bla != null && this.blc != null) {
            this.bla.setUIInfo(this.blc.getSelectInfo(), z);
        }
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.ble.setVisibility(8);
        } else if (this.blf != null && this.blf.isChecked()) {
            this.ble.setVisibility(0);
        }
    }

    private void cp(boolean z) {
        final ce[] eK = d.LG().eK(this.bOO != null ? this.bOO.Lr() : 0);
        if (eK == null || z) {
            if (this.blf.isChecked()) {
                this.blf.setChecked(false, false);
            } else {
                ca(false);
            }
            this.bpH.setVisibility(8);
            return;
        }
        this.bpH.setVisibility(0);
        if (this.blc != null) {
            this.blc.getView().post(new Runnable() { // from class: com.baidu.live.yuyinquick.a.7
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.blc != null) {
                        a.this.blc.setData(eK, z.GB().GD(), 1);
                        if (d.LG().LJ()) {
                            if (a.this.blf.isChecked()) {
                                a.this.blc.setSelectId(d.LG().LK());
                                a.this.cb(true);
                                return;
                            }
                            a.this.blf.setChecked(true, false);
                        } else if (a.this.blf.isChecked()) {
                            a.this.blf.setChecked(false, false);
                        }
                    }
                }
            });
        }
    }

    private void n(String[] strArr) {
        if (this.bOP == null) {
            this.bOP = new b(strArr);
            this.bpI.setAdapter(this.bOP);
            return;
        }
        this.bOP.setDatas(strArr);
        this.bOP.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HX() {
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

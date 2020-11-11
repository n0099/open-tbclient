package com.baidu.live.quick;

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
public class b extends Dialog {
    private com.baidu.live.im.b.b bmu;
    private c bmw;
    private FrameLayout bmx;
    private FrameLayout bmy;
    private Switch bmz;
    private a bqZ;
    private View bra;
    private FlexLayout brb;
    private C0196b brc;
    private BdPageContext brd;
    private View mContentView;

    /* loaded from: classes4.dex */
    public interface a {
        boolean LM();

        int LR();

        boolean Mn();

        void Pc();

        void b(int i, String str, cg cgVar);

        void onDismiss();
    }

    public b(@NonNull BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity(), a.i.sdk_TransparentDialog);
        this.brd = bdPageContext;
        init();
    }

    public void a(a aVar) {
        this.bqZ = aVar;
    }

    public void a(String[] strArr, boolean z) {
        n(strArr);
        cq(z);
        show();
        if (this.mContentView != null) {
            this.mContentView.setVisibility(4);
            this.mContentView.post(new Runnable() { // from class: com.baidu.live.quick.b.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams;
                    if (b.this.brb != null && (layoutParams = b.this.brb.getLayoutParams()) != null) {
                        layoutParams.height = b.this.brb.realHeight;
                        b.this.brb.setLayoutParams(layoutParams);
                    }
                    b.this.Iy();
                }
            });
        }
    }

    public void dI(int i) {
        ViewGroup.LayoutParams layoutParams;
        Window window = getWindow();
        if (window != null) {
            if (this.brb != null && (layoutParams = this.brb.getLayoutParams()) != null) {
                layoutParams.height = -2;
                this.brb.setLayoutParams(layoutParams);
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            window.setAttributes(attributes);
            if (i == 2) {
                this.bmy.setVisibility(4);
                if (this.mContentView != null) {
                    this.mContentView.post(new Runnable() { // from class: com.baidu.live.quick.b.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewGroup.LayoutParams layoutParams2;
                            if (b.this.brb != null && (layoutParams2 = b.this.brb.getLayoutParams()) != null) {
                                layoutParams2.height = b.this.brb.realHeight;
                                b.this.brb.setLayoutParams(layoutParams2);
                            }
                        }
                    });
                }
            } else if (this.bmz != null && this.bmz.isChecked()) {
                this.bmy.setVisibility(0);
            }
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
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913216, c.class, this.brd);
        if (runTask != null) {
            this.bmw = (c) runTask.getData();
        }
        if (this.bmw != null) {
            this.bmx.addView(this.bmw.getView());
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913215, com.baidu.live.im.b.b.class, this.brd);
        if (runTask2 != null) {
            this.bmu = (com.baidu.live.im.b.b) runTask2.getData();
        }
        if (this.bmu != null) {
            this.bmy.addView(this.bmu.getView());
        }
        this.bmz.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.quick.b.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                b.this.cb(z);
            }
        });
        if (this.bmw != null) {
            this.bmw.setSelectEnabled(false);
            this.bmw.setCallback(new e() { // from class: com.baidu.live.quick.b.4
                @Override // com.baidu.live.im.b.e
                public boolean Mn() {
                    return b.this.bqZ != null && b.this.bqZ.Mn();
                }

                @Override // com.baidu.live.im.b.e
                public void ei(int i) {
                    b.this.cc(false);
                }

                @Override // com.baidu.live.im.b.e
                public int LR() {
                    if (b.this.bqZ != null) {
                        return b.this.bqZ.LR();
                    }
                    return 0;
                }
            });
        }
        this.brb.setHorizontalSpacing(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds20));
        this.brb.setVerticalSpacing(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        this.brb.setOnItemClickListener(new FlexLayout.OnItemClickListener() { // from class: com.baidu.live.quick.b.5
            @Override // com.baidu.live.tbadk.widget.flex.FlexLayout.OnItemClickListener
            public void onItemClick(FlexLayout flexLayout, View view, int i) {
                cg cgVar;
                if (b.this.bqZ != null) {
                    if (b.this.bra.getVisibility() == 0 && b.this.bmz.isChecked() && b.this.bmw != null) {
                        cg selectInfo = b.this.bmw.getSelectInfo();
                        if (selectInfo != null && selectInfo.type == 16 && (b.this.bqZ == null || !b.this.bqZ.Mn())) {
                            BdUtilHelper.showToast(b.this.getContext(), a.h.sdk_throne_disabled_alert);
                            return;
                        } else if (selectInfo != null && selectInfo.type == 17 && selectInfo.aRr > b.this.bqZ.LR()) {
                            if (selectInfo.aRr == 7) {
                                BdUtilHelper.showToast(b.this.getContext(), a.h.sdk_noble_king_disabled_alert);
                                return;
                            } else {
                                BdUtilHelper.showToast(b.this.getContext(), a.h.sdk_noble_disabled_alert);
                                return;
                            }
                        } else {
                            cgVar = selectInfo;
                        }
                    } else {
                        cgVar = null;
                    }
                    b.this.bqZ.b(i, b.this.brc.getItem(i), cgVar);
                }
            }
        });
    }

    private void GB() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.live.quick.b.6
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (b.this.bqZ != null) {
                    b.this.bqZ.Pc();
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.quick.b.7
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (b.this.bmu != null) {
                    b.this.bmu.release();
                }
                if (b.this.bqZ != null) {
                    b.this.bqZ.onDismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cb(boolean z) {
        if (z && this.bqZ != null && !this.bqZ.LM()) {
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
            this.bmy.setVisibility(4);
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
            this.bmy.setVisibility(4);
        } else if (this.bmz != null && this.bmz.isChecked()) {
            this.bmy.setVisibility(0);
        }
    }

    private void cq(boolean z) {
        final cg[] e = d.Mg().e(this.bqZ != null && this.bqZ.Mn(), this.bqZ != null ? this.bqZ.LR() : 0);
        if (e == null || z) {
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
            this.bmw.getView().post(new Runnable() { // from class: com.baidu.live.quick.b.8
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.bmw != null) {
                        b.this.bmw.setData(e, y.Hc().He(), 1);
                        if (d.Mg().Mj()) {
                            if (b.this.bmz.isChecked()) {
                                b.this.bmw.setSelectId(d.Mg().Mk());
                                b.this.cc(true);
                                return;
                            }
                            b.this.bmz.setChecked(true, false);
                        } else if (b.this.bmz.isChecked()) {
                            b.this.bmz.setChecked(false, false);
                        }
                    }
                }
            });
        }
    }

    private void n(String[] strArr) {
        if (this.brc == null) {
            this.brc = new C0196b(strArr);
            this.brb.setAdapter(this.brc);
            return;
        }
        this.brc.setDatas(strArr);
        this.brc.notifyDataSetChanged();
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
    /* renamed from: com.baidu.live.quick.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0196b extends FlexAdapter<String> {
        C0196b(String[] strArr) {
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

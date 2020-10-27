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
public class b extends Dialog {
    private com.baidu.live.im.b.b bla;
    private c blc;
    private FrameLayout bld;
    private FrameLayout ble;
    private Switch blf;
    private a bpG;
    private View bpH;
    private FlexLayout bpI;
    private C0194b bpJ;
    private BdPageContext bpK;
    private View mContentView;

    /* loaded from: classes4.dex */
    public interface a {
        boolean LN();

        boolean Lm();

        int Lr();

        void OC();

        void b(int i, String str, ce ceVar);

        void onDismiss();
    }

    public b(@NonNull BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity(), a.j.sdk_TransparentDialog);
        this.bpK = bdPageContext;
        init();
    }

    public void a(a aVar) {
        this.bpG = aVar;
    }

    public void a(String[] strArr, boolean z) {
        n(strArr);
        cp(z);
        show();
        if (this.mContentView != null) {
            this.mContentView.setVisibility(4);
            this.mContentView.post(new Runnable() { // from class: com.baidu.live.quick.b.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams;
                    if (b.this.bpI != null && (layoutParams = b.this.bpI.getLayoutParams()) != null) {
                        layoutParams.height = b.this.bpI.realHeight;
                        b.this.bpI.setLayoutParams(layoutParams);
                    }
                    b.this.HX();
                }
            });
        }
    }

    public void dI(int i) {
        ViewGroup.LayoutParams layoutParams;
        Window window = getWindow();
        if (window != null) {
            if (this.bpI != null && (layoutParams = this.bpI.getLayoutParams()) != null) {
                layoutParams.height = -2;
                this.bpI.setLayoutParams(layoutParams);
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            window.setAttributes(attributes);
            if (i == 2) {
                this.ble.setVisibility(4);
                if (this.mContentView != null) {
                    this.mContentView.post(new Runnable() { // from class: com.baidu.live.quick.b.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewGroup.LayoutParams layoutParams2;
                            if (b.this.bpI != null && (layoutParams2 = b.this.bpI.getLayoutParams()) != null) {
                                layoutParams2.height = b.this.bpI.realHeight;
                                b.this.bpI.setLayoutParams(layoutParams2);
                            }
                        }
                    });
                }
            } else if (this.blf != null && this.blf.isChecked()) {
                this.ble.setVisibility(0);
            }
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
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913216, c.class, this.bpK);
        if (runTask != null) {
            this.blc = (c) runTask.getData();
        }
        if (this.blc != null) {
            this.bld.addView(this.blc.getView());
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913215, com.baidu.live.im.b.b.class, this.bpK);
        if (runTask2 != null) {
            this.bla = (com.baidu.live.im.b.b) runTask2.getData();
        }
        if (this.bla != null) {
            this.ble.addView(this.bla.getView());
        }
        this.blf.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.quick.b.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                b.this.ca(z);
            }
        });
        if (this.blc != null) {
            this.blc.setSelectEnabled(false);
            this.blc.setCallback(new e() { // from class: com.baidu.live.quick.b.4
                @Override // com.baidu.live.im.b.e
                public boolean LN() {
                    return b.this.bpG != null && b.this.bpG.LN();
                }

                @Override // com.baidu.live.im.b.e
                public void ei(int i) {
                    b.this.cb(false);
                }

                @Override // com.baidu.live.im.b.e
                public int Lr() {
                    if (b.this.bpG != null) {
                        return b.this.bpG.Lr();
                    }
                    return 0;
                }
            });
        }
        this.bpI.setHorizontalSpacing(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds20));
        this.bpI.setVerticalSpacing(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        this.bpI.setOnItemClickListener(new FlexLayout.OnItemClickListener() { // from class: com.baidu.live.quick.b.5
            @Override // com.baidu.live.tbadk.widget.flex.FlexLayout.OnItemClickListener
            public void onItemClick(FlexLayout flexLayout, View view, int i) {
                ce ceVar;
                if (b.this.bpG != null) {
                    if (b.this.bpH.getVisibility() == 0 && b.this.blf.isChecked() && b.this.blc != null) {
                        ce selectInfo = b.this.blc.getSelectInfo();
                        if (selectInfo != null && selectInfo.type == 16 && (b.this.bpG == null || !b.this.bpG.LN())) {
                            BdUtilHelper.showToast(b.this.getContext(), a.i.sdk_throne_disabled_alert);
                            return;
                        } else if (selectInfo != null && selectInfo.type == 17 && selectInfo.aQp > b.this.bpG.Lr()) {
                            if (selectInfo.aQp == 7) {
                                BdUtilHelper.showToast(b.this.getContext(), a.i.sdk_noble_king_disabled_alert);
                                return;
                            } else {
                                BdUtilHelper.showToast(b.this.getContext(), a.i.sdk_noble_disabled_alert);
                                return;
                            }
                        } else {
                            ceVar = selectInfo;
                        }
                    } else {
                        ceVar = null;
                    }
                    b.this.bpG.b(i, b.this.bpJ.getItem(i), ceVar);
                }
            }
        });
    }

    private void Ga() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.live.quick.b.6
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (b.this.bpG != null) {
                    b.this.bpG.OC();
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.quick.b.7
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (b.this.bla != null) {
                    b.this.bla.release();
                }
                if (b.this.bpG != null) {
                    b.this.bpG.onDismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ca(boolean z) {
        if (z && this.bpG != null && !this.bpG.Lm()) {
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
            this.ble.setVisibility(4);
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
            this.ble.setVisibility(4);
        } else if (this.blf != null && this.blf.isChecked()) {
            this.ble.setVisibility(0);
        }
    }

    private void cp(boolean z) {
        final ce[] e = d.LG().e(this.bpG != null && this.bpG.LN(), this.bpG != null ? this.bpG.Lr() : 0);
        if (e == null || z) {
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
            this.blc.getView().post(new Runnable() { // from class: com.baidu.live.quick.b.8
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.blc != null) {
                        b.this.blc.setData(e, z.GB().GD(), 1);
                        if (d.LG().LJ()) {
                            if (b.this.blf.isChecked()) {
                                b.this.blc.setSelectId(d.LG().LK());
                                b.this.cb(true);
                                return;
                            }
                            b.this.blf.setChecked(true, false);
                        } else if (b.this.blf.isChecked()) {
                            b.this.blf.setChecked(false, false);
                        }
                    }
                }
            });
        }
    }

    private void n(String[] strArr) {
        if (this.bpJ == null) {
            this.bpJ = new C0194b(strArr);
            this.bpI.setAdapter(this.bpJ);
            return;
        }
        this.bpJ.setDatas(strArr);
        this.bpJ.notifyDataSetChanged();
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
    /* renamed from: com.baidu.live.quick.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0194b extends FlexAdapter<String> {
        C0194b(String[] strArr) {
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

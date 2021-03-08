package com.baidu.live.quick;

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
import com.baidu.live.data.cr;
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
public class b extends Dialog {
    private com.baidu.live.im.b.b brP;
    private c brR;
    private FrameLayout brS;
    private FrameLayout brT;
    private Switch brU;
    private a bzv;
    private View bzw;
    private FlexLayout bzx;
    private C0200b bzy;
    private BdPageContext bzz;
    private View mContentView;

    /* loaded from: classes10.dex */
    public interface a {
        boolean KZ();

        boolean Kk();

        int Kq();

        boolean Kr();

        void b(int i, String str, cr crVar);

        void onDismiss();

        void onShow();
    }

    public b(@NonNull BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity(), a.i.sdk_TransparentDialog);
        this.bzz = bdPageContext;
        init();
    }

    public void a(a aVar) {
        this.bzv = aVar;
    }

    public void a(String[] strArr, boolean z) {
        n(strArr);
        cO(z);
        show();
        if (this.mContentView != null) {
            this.mContentView.setVisibility(4);
            this.mContentView.post(new Runnable() { // from class: com.baidu.live.quick.b.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams;
                    if (b.this.bzx != null && (layoutParams = b.this.bzx.getLayoutParams()) != null) {
                        layoutParams.height = b.this.bzx.realHeight;
                        b.this.bzx.setLayoutParams(layoutParams);
                    }
                    b.this.GG();
                }
            });
        }
    }

    public void cs(int i) {
        ViewGroup.LayoutParams layoutParams;
        Window window = getWindow();
        if (window != null) {
            if (this.bzx != null && (layoutParams = this.bzx.getLayoutParams()) != null) {
                layoutParams.height = -2;
                this.bzx.setLayoutParams(layoutParams);
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            window.setAttributes(attributes);
            if (i == 2) {
                this.brT.setVisibility(4);
                if (this.mContentView != null) {
                    this.mContentView.post(new Runnable() { // from class: com.baidu.live.quick.b.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewGroup.LayoutParams layoutParams2;
                            if (b.this.bzx != null && (layoutParams2 = b.this.bzx.getLayoutParams()) != null) {
                                layoutParams2.height = b.this.bzx.realHeight;
                                b.this.bzx.setLayoutParams(layoutParams2);
                            }
                        }
                    });
                }
            } else if (this.brU != null && this.brU.isChecked()) {
                this.brT.setVisibility(0);
            }
        }
    }

    public void Px() {
        if (this.brR != null) {
            this.brR.f(z.Fh().Fj());
        }
    }

    private void init() {
        Hi();
        initView();
        EG();
    }

    private void Hi() {
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
        this.bzw = findViewById(a.f.layout_barrage);
        this.brU = (Switch) findViewById(a.f.switch_barrage);
        this.bzx = (FlexLayout) findViewById(a.f.flex);
        this.brT = (FrameLayout) findViewById(a.f.barrage_preview);
        this.brS = (FrameLayout) findViewById(a.f.hlv_barrage_option);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913216, c.class, this.bzz);
        if (runTask != null) {
            this.brR = (c) runTask.getData();
        }
        if (this.brR != null) {
            this.brS.addView(this.brR.getView());
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913215, com.baidu.live.im.b.b.class, this.bzz);
        if (runTask2 != null) {
            this.brP = (com.baidu.live.im.b.b) runTask2.getData();
        }
        if (this.brP != null) {
            this.brT.addView(this.brP.getView());
        }
        this.brU.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.quick.b.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                b.this.cu(z);
            }
        });
        if (this.brR != null) {
            this.brR.setSelectEnabled(false);
            this.brR.setCallback(new e() { // from class: com.baidu.live.quick.b.4
                @Override // com.baidu.live.im.b.e
                public boolean KZ() {
                    return b.this.bzv != null && b.this.bzv.KZ();
                }

                @Override // com.baidu.live.im.b.e
                public void dC(int i) {
                    b.this.cv(false);
                }

                @Override // com.baidu.live.im.b.e
                public int Kq() {
                    if (b.this.bzv != null) {
                        return b.this.bzv.Kq();
                    }
                    return 0;
                }
            });
        }
        this.bzx.setHorizontalSpacing(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds20));
        this.bzx.setVerticalSpacing(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        this.bzx.setOnItemClickListener(new FlexLayout.OnItemClickListener() { // from class: com.baidu.live.quick.b.5
            @Override // com.baidu.live.tbadk.widget.flex.FlexLayout.OnItemClickListener
            public void onItemClick(FlexLayout flexLayout, View view, int i) {
                cr crVar;
                if (b.this.bzv != null) {
                    if (b.this.bzw.getVisibility() == 0 && b.this.brU.isChecked() && b.this.brR != null) {
                        cr selectInfo = b.this.brR.getSelectInfo();
                        if (selectInfo != null && selectInfo.type == 16 && (b.this.bzv == null || !b.this.bzv.KZ())) {
                            BdUtilHelper.showToast(b.this.getContext(), a.h.sdk_throne_disabled_alert);
                            return;
                        } else if (selectInfo != null && selectInfo.type == 17 && selectInfo.aTv > b.this.bzv.Kq()) {
                            if (selectInfo.aTv == 7) {
                                BdUtilHelper.showToast(b.this.getContext(), a.h.sdk_noble_king_disabled_alert);
                                return;
                            } else {
                                BdUtilHelper.showToast(b.this.getContext(), a.h.sdk_noble_disabled_alert);
                                return;
                            }
                        } else {
                            crVar = selectInfo;
                        }
                    } else {
                        crVar = null;
                    }
                    b.this.bzv.b(i, b.this.bzy.getItem(i), crVar);
                }
            }
        });
    }

    private void EG() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.live.quick.b.6
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (b.this.bzv != null) {
                    b.this.bzv.onShow();
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.quick.b.7
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (b.this.brP != null) {
                    b.this.brP.release();
                }
                if (b.this.bzv != null) {
                    b.this.bzv.onDismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cu(boolean z) {
        if (z && this.bzv != null && !this.bzv.Kk()) {
            this.brU.setChecked(false, false);
        } else if (this.brR != null) {
            if (z) {
                this.brR.setSwitchStatus(true);
                if (!TextUtils.isEmpty(d.KQ().KU())) {
                    this.brR.setSelectId(d.KQ().KU());
                } else {
                    this.brR.setSelectPos(0);
                }
                this.brR.setSelectEnabled(true);
                cv(true);
                return;
            }
            this.brR.setSwitchStatus(false);
            this.brR.setSelectEnabled(false);
            this.brT.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cv(boolean z) {
        if (z && this.brP != null) {
            this.brP.setPreview();
        }
        if (this.brP != null && this.brR != null) {
            this.brP.setUIInfo(this.brR.getSelectInfo(), z);
        }
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.brT.setVisibility(4);
        } else if (this.brU != null && this.brU.isChecked()) {
            this.brT.setVisibility(0);
        }
    }

    private void cO(boolean z) {
        final cr[] a2 = d.KQ().a(this.bzv != null && this.bzv.KZ(), this.bzv != null ? this.bzv.Kq() : 0, this.bzv != null ? this.bzv.Kr() : false);
        if (a2 == null || a2.length <= 0 || z) {
            if (this.brU.isChecked()) {
                this.brU.setChecked(false, false);
            } else {
                cu(false);
            }
            this.bzw.setVisibility(8);
            return;
        }
        this.bzw.setVisibility(0);
        if (this.brR != null) {
            this.brR.getView().post(new Runnable() { // from class: com.baidu.live.quick.b.8
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.brR != null) {
                        b.this.brR.setData(a2, z.Fh().Fj(), 1);
                        if (d.KQ().KT()) {
                            if (b.this.brU.isChecked()) {
                                b.this.brR.setSelectId(d.KQ().KU());
                                b.this.cv(true);
                                return;
                            }
                            b.this.brU.setChecked(true, false);
                        } else if (b.this.brU.isChecked()) {
                            b.this.brU.setChecked(false, false);
                        }
                    }
                }
            });
        }
    }

    private void n(String[] strArr) {
        if (this.bzy == null) {
            this.bzy = new C0200b(strArr);
            this.bzx.setAdapter(this.bzy);
            return;
        }
        this.bzy.setDatas(strArr);
        this.bzy.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GG() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.mContentView.startAnimation(translateAnimation);
        this.mContentView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.quick.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0200b extends FlexAdapter<String> {
        C0200b(String[] strArr) {
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

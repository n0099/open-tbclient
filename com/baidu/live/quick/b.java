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
/* loaded from: classes11.dex */
public class b extends Dialog {
    private com.baidu.live.im.b.b bqp;
    private c bqr;
    private FrameLayout bqs;
    private FrameLayout bqt;
    private Switch bqu;
    private a bxV;
    private View bxW;
    private FlexLayout bxX;
    private C0194b bxY;
    private BdPageContext bxZ;
    private View mContentView;

    /* loaded from: classes11.dex */
    public interface a {
        boolean KW();

        boolean Kh();

        int Kn();

        boolean Ko();

        void b(int i, String str, cr crVar);

        void onDismiss();

        void onShow();
    }

    public b(@NonNull BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity(), a.i.sdk_TransparentDialog);
        this.bxZ = bdPageContext;
        init();
    }

    public void a(a aVar) {
        this.bxV = aVar;
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
                    if (b.this.bxX != null && (layoutParams = b.this.bxX.getLayoutParams()) != null) {
                        layoutParams.height = b.this.bxX.realHeight;
                        b.this.bxX.setLayoutParams(layoutParams);
                    }
                    b.this.GD();
                }
            });
        }
    }

    public void cr(int i) {
        ViewGroup.LayoutParams layoutParams;
        Window window = getWindow();
        if (window != null) {
            if (this.bxX != null && (layoutParams = this.bxX.getLayoutParams()) != null) {
                layoutParams.height = -2;
                this.bxX.setLayoutParams(layoutParams);
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            window.setAttributes(attributes);
            if (i == 2) {
                this.bqt.setVisibility(4);
                if (this.mContentView != null) {
                    this.mContentView.post(new Runnable() { // from class: com.baidu.live.quick.b.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewGroup.LayoutParams layoutParams2;
                            if (b.this.bxX != null && (layoutParams2 = b.this.bxX.getLayoutParams()) != null) {
                                layoutParams2.height = b.this.bxX.realHeight;
                                b.this.bxX.setLayoutParams(layoutParams2);
                            }
                        }
                    });
                }
            } else if (this.bqu != null && this.bqu.isChecked()) {
                this.bqt.setVisibility(0);
            }
        }
    }

    public void Pu() {
        if (this.bqr != null) {
            this.bqr.f(z.Fe().Fg());
        }
    }

    private void init() {
        Hf();
        initView();
        ED();
    }

    private void Hf() {
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
        this.bxW = findViewById(a.f.layout_barrage);
        this.bqu = (Switch) findViewById(a.f.switch_barrage);
        this.bxX = (FlexLayout) findViewById(a.f.flex);
        this.bqt = (FrameLayout) findViewById(a.f.barrage_preview);
        this.bqs = (FrameLayout) findViewById(a.f.hlv_barrage_option);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913216, c.class, this.bxZ);
        if (runTask != null) {
            this.bqr = (c) runTask.getData();
        }
        if (this.bqr != null) {
            this.bqs.addView(this.bqr.getView());
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913215, com.baidu.live.im.b.b.class, this.bxZ);
        if (runTask2 != null) {
            this.bqp = (com.baidu.live.im.b.b) runTask2.getData();
        }
        if (this.bqp != null) {
            this.bqt.addView(this.bqp.getView());
        }
        this.bqu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.quick.b.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                b.this.cu(z);
            }
        });
        if (this.bqr != null) {
            this.bqr.setSelectEnabled(false);
            this.bqr.setCallback(new e() { // from class: com.baidu.live.quick.b.4
                @Override // com.baidu.live.im.b.e
                public boolean KW() {
                    return b.this.bxV != null && b.this.bxV.KW();
                }

                @Override // com.baidu.live.im.b.e
                public void dB(int i) {
                    b.this.cv(false);
                }

                @Override // com.baidu.live.im.b.e
                public int Kn() {
                    if (b.this.bxV != null) {
                        return b.this.bxV.Kn();
                    }
                    return 0;
                }
            });
        }
        this.bxX.setHorizontalSpacing(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds20));
        this.bxX.setVerticalSpacing(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        this.bxX.setOnItemClickListener(new FlexLayout.OnItemClickListener() { // from class: com.baidu.live.quick.b.5
            @Override // com.baidu.live.tbadk.widget.flex.FlexLayout.OnItemClickListener
            public void onItemClick(FlexLayout flexLayout, View view, int i) {
                cr crVar;
                if (b.this.bxV != null) {
                    if (b.this.bxW.getVisibility() == 0 && b.this.bqu.isChecked() && b.this.bqr != null) {
                        cr selectInfo = b.this.bqr.getSelectInfo();
                        if (selectInfo != null && selectInfo.type == 16 && (b.this.bxV == null || !b.this.bxV.KW())) {
                            BdUtilHelper.showToast(b.this.getContext(), a.h.sdk_throne_disabled_alert);
                            return;
                        } else if (selectInfo != null && selectInfo.type == 17 && selectInfo.aRV > b.this.bxV.Kn()) {
                            if (selectInfo.aRV == 7) {
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
                    b.this.bxV.b(i, b.this.bxY.getItem(i), crVar);
                }
            }
        });
    }

    private void ED() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.live.quick.b.6
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (b.this.bxV != null) {
                    b.this.bxV.onShow();
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.quick.b.7
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (b.this.bqp != null) {
                    b.this.bqp.release();
                }
                if (b.this.bxV != null) {
                    b.this.bxV.onDismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cu(boolean z) {
        if (z && this.bxV != null && !this.bxV.Kh()) {
            this.bqu.setChecked(false, false);
        } else if (this.bqr != null) {
            if (z) {
                this.bqr.setSwitchStatus(true);
                if (!TextUtils.isEmpty(d.KN().KR())) {
                    this.bqr.setSelectId(d.KN().KR());
                } else {
                    this.bqr.setSelectPos(0);
                }
                this.bqr.setSelectEnabled(true);
                cv(true);
                return;
            }
            this.bqr.setSwitchStatus(false);
            this.bqr.setSelectEnabled(false);
            this.bqt.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cv(boolean z) {
        if (z && this.bqp != null) {
            this.bqp.setPreview();
        }
        if (this.bqp != null && this.bqr != null) {
            this.bqp.setUIInfo(this.bqr.getSelectInfo(), z);
        }
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.bqt.setVisibility(4);
        } else if (this.bqu != null && this.bqu.isChecked()) {
            this.bqt.setVisibility(0);
        }
    }

    private void cO(boolean z) {
        final cr[] b2 = d.KN().b(this.bxV != null && this.bxV.KW(), this.bxV != null ? this.bxV.Kn() : 0, this.bxV != null ? this.bxV.Ko() : false);
        if (b2 == null || b2.length <= 0 || z) {
            if (this.bqu.isChecked()) {
                this.bqu.setChecked(false, false);
            } else {
                cu(false);
            }
            this.bxW.setVisibility(8);
            return;
        }
        this.bxW.setVisibility(0);
        if (this.bqr != null) {
            this.bqr.getView().post(new Runnable() { // from class: com.baidu.live.quick.b.8
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.bqr != null) {
                        b.this.bqr.setData(b2, z.Fe().Fg(), 1);
                        if (d.KN().KQ()) {
                            if (b.this.bqu.isChecked()) {
                                b.this.bqr.setSelectId(d.KN().KR());
                                b.this.cv(true);
                                return;
                            }
                            b.this.bqu.setChecked(true, false);
                        } else if (b.this.bqu.isChecked()) {
                            b.this.bqu.setChecked(false, false);
                        }
                    }
                }
            });
        }
    }

    private void n(String[] strArr) {
        if (this.bxY == null) {
            this.bxY = new C0194b(strArr);
            this.bxX.setAdapter(this.bxY);
            return;
        }
        this.bxY.setDatas(strArr);
        this.bxY.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GD() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.mContentView.startAnimation(translateAnimation);
        this.mContentView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.live.quick.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
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

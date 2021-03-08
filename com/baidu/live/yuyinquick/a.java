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
public class a extends Dialog {
    private com.baidu.live.im.b.b brP;
    private c brR;
    private FrameLayout brS;
    private FrameLayout brT;
    private Switch brU;
    private View bzw;
    private FlexLayout bzx;
    private BdPageContext bzz;
    private InterfaceC0248a cfE;
    private b cfF;
    private View mContentView;

    /* renamed from: com.baidu.live.yuyinquick.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0248a {
        boolean KZ();

        boolean Kk();

        int Kq();

        void b(int i, String str, cr crVar);

        void onDismiss();

        void onShow();
    }

    public a(@NonNull BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity(), a.i.sdk_TransparentDialog);
        this.bzz = bdPageContext;
        init();
    }

    public void a(InterfaceC0248a interfaceC0248a) {
        this.cfE = interfaceC0248a;
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
                    if (a.this.bzx != null && (layoutParams = a.this.bzx.getLayoutParams()) != null) {
                        layoutParams.height = a.this.bzx.realHeight;
                        a.this.bzx.setLayoutParams(layoutParams);
                    }
                    a.this.GG();
                }
            });
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
        this.mContentView = LayoutInflater.from(getContext()).inflate(a.g.ala_yuyin_im_quick_input_list, (ViewGroup) null);
        setContentView(this.mContentView);
        this.bzw = findViewById(a.f.layout_barrage);
        this.brU = (Switch) findViewById(a.f.switch_barrage);
        this.bzx = (FlexLayout) findViewById(a.f.flex);
        this.brT = (FrameLayout) findViewById(a.f.barrage_preview);
        this.brS = (FrameLayout) findViewById(a.f.hlv_barrage_option);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501050, c.class, this.bzz);
        if (runTask != null) {
            this.brR = (c) runTask.getData();
        }
        if (this.brR != null) {
            this.brS.addView(this.brR.getView());
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2501051, com.baidu.live.im.b.b.class, this.bzz);
        if (runTask2 != null) {
            this.brP = (com.baidu.live.im.b.b) runTask2.getData();
        }
        if (this.brP != null) {
            this.brT.addView(this.brP.getView());
            this.brT.setVisibility(8);
        }
        this.brU.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.yuyinquick.a.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.cu(z);
            }
        });
        if (this.brR != null) {
            this.brR.setSelectEnabled(false);
            this.brR.setCallback(new e() { // from class: com.baidu.live.yuyinquick.a.3
                @Override // com.baidu.live.im.b.e
                public boolean KZ() {
                    return a.this.cfE != null && a.this.cfE.KZ();
                }

                @Override // com.baidu.live.im.b.e
                public void dC(int i) {
                    a.this.cv(false);
                }

                @Override // com.baidu.live.im.b.e
                public int Kq() {
                    if (a.this.cfE != null) {
                        return a.this.cfE.Kq();
                    }
                    return 0;
                }
            });
        }
        this.bzx.setHorizontalSpacing(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds20));
        this.bzx.setVerticalSpacing(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        this.bzx.setOnItemClickListener(new FlexLayout.OnItemClickListener() { // from class: com.baidu.live.yuyinquick.a.4
            @Override // com.baidu.live.tbadk.widget.flex.FlexLayout.OnItemClickListener
            public void onItemClick(FlexLayout flexLayout, View view, int i) {
                cr crVar;
                if (a.this.cfE != null) {
                    if (a.this.bzw.getVisibility() == 0 && a.this.brU.isChecked() && a.this.brR != null) {
                        cr selectInfo = a.this.brR.getSelectInfo();
                        if (selectInfo != null && selectInfo.type == 16 && (a.this.cfE == null || !a.this.cfE.KZ())) {
                            BdUtilHelper.showToast(a.this.getContext().getApplicationContext(), a.h.sdk_throne_disabled_alert);
                            return;
                        } else if (selectInfo != null && selectInfo.type == 17 && selectInfo.aTv > a.this.cfE.Kq()) {
                            if (selectInfo.aTv == 7) {
                                BdUtilHelper.showToast(a.this.getContext().getApplicationContext(), a.h.sdk_noble_king_disabled_alert);
                                return;
                            } else {
                                BdUtilHelper.showToast(a.this.getContext().getApplicationContext(), a.h.sdk_noble_disabled_alert);
                                return;
                            }
                        } else {
                            crVar = selectInfo;
                        }
                    } else {
                        crVar = null;
                    }
                    a.this.cfE.b(i, a.this.cfF.getItem(i), crVar);
                }
            }
        });
    }

    private void EG() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.live.yuyinquick.a.5
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (a.this.cfE != null) {
                    a.this.cfE.onShow();
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.yuyinquick.a.6
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.brP != null) {
                    a.this.brP.release();
                }
                if (a.this.cfE != null) {
                    a.this.cfE.onDismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cu(boolean z) {
        if (z && this.cfE != null && !this.cfE.Kk()) {
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
            this.brT.setVisibility(8);
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
            this.brT.setVisibility(8);
        } else if (this.brU != null && this.brU.isChecked()) {
            this.brT.setVisibility(0);
        }
    }

    private void n(String[] strArr) {
        if (this.cfF == null) {
            this.cfF = new b(strArr);
            this.bzx.setAdapter(this.cfF);
            return;
        }
        this.cfF.setDatas(strArr);
        this.cfF.notifyDataSetChanged();
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

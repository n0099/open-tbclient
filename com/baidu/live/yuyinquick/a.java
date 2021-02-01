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
/* loaded from: classes11.dex */
public class a extends Dialog {
    private com.baidu.live.im.b.b bqp;
    private c bqr;
    private FrameLayout bqs;
    private FrameLayout bqt;
    private Switch bqu;
    private View bxW;
    private FlexLayout bxX;
    private BdPageContext bxZ;
    private InterfaceC0242a cee;
    private b cef;
    private View mContentView;

    /* renamed from: com.baidu.live.yuyinquick.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0242a {
        boolean KW();

        boolean Kh();

        int Kn();

        void b(int i, String str, cr crVar);

        void onDismiss();

        void onShow();
    }

    public a(@NonNull BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity(), a.i.sdk_TransparentDialog);
        this.bxZ = bdPageContext;
        init();
    }

    public void a(InterfaceC0242a interfaceC0242a) {
        this.cee = interfaceC0242a;
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
                    if (a.this.bxX != null && (layoutParams = a.this.bxX.getLayoutParams()) != null) {
                        layoutParams.height = a.this.bxX.realHeight;
                        a.this.bxX.setLayoutParams(layoutParams);
                    }
                    a.this.GD();
                }
            });
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
        this.mContentView = LayoutInflater.from(getContext()).inflate(a.g.ala_yuyin_im_quick_input_list, (ViewGroup) null);
        setContentView(this.mContentView);
        this.bxW = findViewById(a.f.layout_barrage);
        this.bqu = (Switch) findViewById(a.f.switch_barrage);
        this.bxX = (FlexLayout) findViewById(a.f.flex);
        this.bqt = (FrameLayout) findViewById(a.f.barrage_preview);
        this.bqs = (FrameLayout) findViewById(a.f.hlv_barrage_option);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501050, c.class, this.bxZ);
        if (runTask != null) {
            this.bqr = (c) runTask.getData();
        }
        if (this.bqr != null) {
            this.bqs.addView(this.bqr.getView());
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2501051, com.baidu.live.im.b.b.class, this.bxZ);
        if (runTask2 != null) {
            this.bqp = (com.baidu.live.im.b.b) runTask2.getData();
        }
        if (this.bqp != null) {
            this.bqt.addView(this.bqp.getView());
            this.bqt.setVisibility(8);
        }
        this.bqu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.yuyinquick.a.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.cu(z);
            }
        });
        if (this.bqr != null) {
            this.bqr.setSelectEnabled(false);
            this.bqr.setCallback(new e() { // from class: com.baidu.live.yuyinquick.a.3
                @Override // com.baidu.live.im.b.e
                public boolean KW() {
                    return a.this.cee != null && a.this.cee.KW();
                }

                @Override // com.baidu.live.im.b.e
                public void dB(int i) {
                    a.this.cv(false);
                }

                @Override // com.baidu.live.im.b.e
                public int Kn() {
                    if (a.this.cee != null) {
                        return a.this.cee.Kn();
                    }
                    return 0;
                }
            });
        }
        this.bxX.setHorizontalSpacing(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds20));
        this.bxX.setVerticalSpacing(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        this.bxX.setOnItemClickListener(new FlexLayout.OnItemClickListener() { // from class: com.baidu.live.yuyinquick.a.4
            @Override // com.baidu.live.tbadk.widget.flex.FlexLayout.OnItemClickListener
            public void onItemClick(FlexLayout flexLayout, View view, int i) {
                cr crVar;
                if (a.this.cee != null) {
                    if (a.this.bxW.getVisibility() == 0 && a.this.bqu.isChecked() && a.this.bqr != null) {
                        cr selectInfo = a.this.bqr.getSelectInfo();
                        if (selectInfo != null && selectInfo.type == 16 && (a.this.cee == null || !a.this.cee.KW())) {
                            BdUtilHelper.showToast(a.this.getContext().getApplicationContext(), a.h.sdk_throne_disabled_alert);
                            return;
                        } else if (selectInfo != null && selectInfo.type == 17 && selectInfo.aRV > a.this.cee.Kn()) {
                            if (selectInfo.aRV == 7) {
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
                    a.this.cee.b(i, a.this.cef.getItem(i), crVar);
                }
            }
        });
    }

    private void ED() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.live.yuyinquick.a.5
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (a.this.cee != null) {
                    a.this.cee.onShow();
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.yuyinquick.a.6
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.bqp != null) {
                    a.this.bqp.release();
                }
                if (a.this.cee != null) {
                    a.this.cee.onDismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cu(boolean z) {
        if (z && this.cee != null && !this.cee.Kh()) {
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
            this.bqt.setVisibility(8);
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
            this.bqt.setVisibility(8);
        } else if (this.bqu != null && this.bqu.isChecked()) {
            this.bqt.setVisibility(0);
        }
    }

    private void n(String[] strArr) {
        if (this.cef == null) {
            this.cef = new b(strArr);
            this.bxX.setAdapter(this.cef);
            return;
        }
        this.cef.setDatas(strArr);
        this.cef.notifyDataSetChanged();
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
    /* loaded from: classes11.dex */
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

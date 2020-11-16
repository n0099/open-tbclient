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
    private InterfaceC0241a bSO;
    private b bSP;
    private com.baidu.live.im.b.b bkJ;
    private c bkL;
    private FrameLayout bkM;
    private FrameLayout bkN;
    private Switch bkO;
    private View bpp;
    private FlexLayout bpq;
    private BdPageContext bps;
    private View mContentView;

    /* renamed from: com.baidu.live.yuyinquick.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0241a {
        boolean LE();

        boolean Ld();

        int Li();

        void Ot();

        void b(int i, String str, cg cgVar);

        void onDismiss();
    }

    public a(@NonNull BdPageContext bdPageContext) {
        super(bdPageContext.getPageActivity(), a.i.sdk_TransparentDialog);
        this.bps = bdPageContext;
        init();
    }

    public void a(InterfaceC0241a interfaceC0241a) {
        this.bSO = interfaceC0241a;
    }

    public void a(String[] strArr, boolean z) {
        n(strArr);
        cs(z);
        show();
        if (this.mContentView != null) {
            this.mContentView.setVisibility(4);
            this.mContentView.post(new Runnable() { // from class: com.baidu.live.yuyinquick.a.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams;
                    if (a.this.bpq != null && (layoutParams = a.this.bpq.getLayoutParams()) != null) {
                        layoutParams.height = a.this.bpq.realHeight;
                        a.this.bpq.setLayoutParams(layoutParams);
                    }
                    a.this.HP();
                }
            });
        }
    }

    public void Ou() {
        if (this.bkL != null) {
            this.bkL.f(y.Gt().Gv());
        }
    }

    private void init() {
        Ov();
        initView();
        FS();
    }

    private void Ov() {
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
        this.bpp = findViewById(a.f.layout_barrage);
        this.bkO = (Switch) findViewById(a.f.switch_barrage);
        this.bpq = (FlexLayout) findViewById(a.f.flex);
        this.bkN = (FrameLayout) findViewById(a.f.barrage_preview);
        this.bkM = (FrameLayout) findViewById(a.f.hlv_barrage_option);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501050, c.class, this.bps);
        if (runTask != null) {
            this.bkL = (c) runTask.getData();
        }
        if (this.bkL != null) {
            this.bkM.addView(this.bkL.getView());
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2501051, com.baidu.live.im.b.b.class, this.bps);
        if (runTask2 != null) {
            this.bkJ = (com.baidu.live.im.b.b) runTask2.getData();
        }
        if (this.bkJ != null) {
            this.bkN.addView(this.bkJ.getView());
            this.bkN.setVisibility(8);
        }
        this.bkO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.yuyinquick.a.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.cd(z);
            }
        });
        if (this.bkL != null) {
            this.bkL.setSelectEnabled(false);
            this.bkL.setCallback(new e() { // from class: com.baidu.live.yuyinquick.a.3
                @Override // com.baidu.live.im.b.e
                public boolean LE() {
                    return a.this.bSO != null && a.this.bSO.LE();
                }

                @Override // com.baidu.live.im.b.e
                public void ee(int i) {
                    a.this.ce(false);
                }

                @Override // com.baidu.live.im.b.e
                public int Li() {
                    if (a.this.bSO != null) {
                        return a.this.bSO.Li();
                    }
                    return 0;
                }
            });
        }
        this.bpq.setHorizontalSpacing(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds20));
        this.bpq.setVerticalSpacing(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        this.bpq.setOnItemClickListener(new FlexLayout.OnItemClickListener() { // from class: com.baidu.live.yuyinquick.a.4
            @Override // com.baidu.live.tbadk.widget.flex.FlexLayout.OnItemClickListener
            public void onItemClick(FlexLayout flexLayout, View view, int i) {
                cg cgVar;
                if (a.this.bSO != null) {
                    if (a.this.bpp.getVisibility() == 0 && a.this.bkO.isChecked() && a.this.bkL != null) {
                        cg selectInfo = a.this.bkL.getSelectInfo();
                        if (selectInfo != null && selectInfo.type == 16 && (a.this.bSO == null || !a.this.bSO.LE())) {
                            BdUtilHelper.showToast(a.this.getContext().getApplicationContext(), a.h.sdk_throne_disabled_alert);
                            return;
                        } else if (selectInfo != null && selectInfo.type == 17 && selectInfo.aPG > a.this.bSO.Li()) {
                            if (selectInfo.aPG == 7) {
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
                    a.this.bSO.b(i, a.this.bSP.getItem(i), cgVar);
                }
            }
        });
    }

    private void FS() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.live.yuyinquick.a.5
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (a.this.bSO != null) {
                    a.this.bSO.Ot();
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.yuyinquick.a.6
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.bkJ != null) {
                    a.this.bkJ.release();
                }
                if (a.this.bSO != null) {
                    a.this.bSO.onDismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cd(boolean z) {
        if (z && this.bSO != null && !this.bSO.Ld()) {
            this.bkO.setChecked(false, false);
        } else if (this.bkL != null) {
            if (z) {
                this.bkL.setSwitchStatus(true);
                if (!TextUtils.isEmpty(d.Lx().LB())) {
                    this.bkL.setSelectId(d.Lx().LB());
                } else {
                    this.bkL.setSelectPos(0);
                }
                this.bkL.setSelectEnabled(true);
                ce(true);
                return;
            }
            this.bkL.setSwitchStatus(false);
            this.bkL.setSelectEnabled(false);
            this.bkN.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ce(boolean z) {
        if (z && this.bkJ != null) {
            this.bkJ.setPreview();
        }
        if (this.bkJ != null && this.bkL != null) {
            this.bkJ.setUIInfo(this.bkL.getSelectInfo(), z);
        }
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.bkN.setVisibility(8);
        } else if (this.bkO != null && this.bkO.isChecked()) {
            this.bkN.setVisibility(0);
        }
    }

    private void cs(boolean z) {
        final cg[] eG = d.Lx().eG(this.bSO != null ? this.bSO.Li() : 0);
        if (eG == null || z) {
            if (this.bkO.isChecked()) {
                this.bkO.setChecked(false, false);
            } else {
                cd(false);
            }
            this.bpp.setVisibility(8);
            return;
        }
        this.bpp.setVisibility(0);
        if (this.bkL != null) {
            this.bkL.getView().post(new Runnable() { // from class: com.baidu.live.yuyinquick.a.7
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.bkL != null) {
                        a.this.bkL.setData(eG, y.Gt().Gv(), 1);
                        if (d.Lx().LA()) {
                            if (a.this.bkO.isChecked()) {
                                a.this.bkL.setSelectId(d.Lx().LB());
                                a.this.ce(true);
                                return;
                            }
                            a.this.bkO.setChecked(true, false);
                        } else if (a.this.bkO.isChecked()) {
                            a.this.bkO.setChecked(false, false);
                        }
                    }
                }
            });
        }
    }

    private void n(String[] strArr) {
        if (this.bSP == null) {
            this.bSP = new b(strArr);
            this.bpq.setAdapter(this.bSP);
            return;
        }
        this.bSP.setDatas(strArr);
        this.bSP.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HP() {
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

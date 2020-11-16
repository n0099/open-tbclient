package com.baidu.live.yuyingift.broadcastgift;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
/* loaded from: classes4.dex */
public class a extends Dialog implements DialogInterface.OnDismissListener, View.OnClickListener {
    private View bOa;
    private TextView bOb;
    private TextView bOc;
    private InterfaceC0233a bOd;
    public CustomMessageListener bcy;
    private Context mContext;
    private TextView mTitle;

    /* renamed from: com.baidu.live.yuyingift.broadcastgift.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0233a {
        void onCancel();

        void onConfirm();
    }

    public a(Context context) {
        super(context);
        this.bcy = new CustomMessageListener(2913097) { // from class: com.baidu.live.yuyingift.broadcastgift.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    a.this.dismiss();
                }
            }
        };
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.yuyin_layout_dialog_connnection_wheat_remind);
        WP();
        initView();
        initListener();
    }

    private void WP() {
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(getContext().getResources().getColor(a.c.sdk_black_alpha65)));
            window.getDecorView().setPadding(0, 0, 0, 0);
            if (((WindowManager) getContext().getSystemService("window")) != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
                    attributes.width = ScreenHelper.getRealScreenHeight(this.mContext);
                    attributes.height = -1;
                } else {
                    attributes.width = -1;
                    attributes.height = ScreenHelper.getRealScreenHeight(this.mContext) - UtilHelper.getStatusBarHeight();
                }
                window.setAttributes(attributes);
            }
        }
    }

    private void initView() {
        this.bOa = findViewById(a.f.view);
        this.mTitle = (TextView) findViewById(a.f.tv_title);
        this.bOb = (TextView) findViewById(a.f.tv_cancel);
        this.bOc = (TextView) findViewById(a.f.tv_confirm);
    }

    private void initListener() {
        this.bOa.setOnClickListener(this);
        this.bOb.setOnClickListener(this);
        this.bOc.setOnClickListener(this);
        setOnDismissListener(this);
    }

    public void setText(String str) {
        if (this.mTitle != null && !TextUtils.isEmpty(str)) {
            this.mTitle.setText(str);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        MessageManager.getInstance().registerListener(this.bcy);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bOa || view == this.bOb) {
            dismiss();
            if (this.bOd != null) {
                this.bOd.onCancel();
            }
        } else if (view == this.bOc) {
            dismiss();
            if (this.bOd != null) {
                this.bOd.onConfirm();
            }
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        MessageManager.getInstance().unRegisterListener(this.bcy);
    }

    public void a(InterfaceC0233a interfaceC0233a) {
        this.bOd = interfaceC0233a;
    }
}

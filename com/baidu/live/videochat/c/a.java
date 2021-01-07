package com.baidu.live.videochat.c;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.live.lottie.LottieAnimationView;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.view.fresco.SimpleDraweeView;
import com.facebook.drawee.generic.RoundingParams;
/* loaded from: classes11.dex */
public class a extends Dialog implements View.OnClickListener {
    private View bDN;
    private TextView bDO;
    private InterfaceC0229a bQj;
    private SimpleDraweeView bQk;
    private TextView bQl;
    private LottieAnimationView bQm;
    private TextView bQn;
    private Context mContext;
    private TextView mTitle;

    /* renamed from: com.baidu.live.videochat.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0229a {
        void TX();

        void Ye();

        void Yf();

        void Yg();
    }

    public void a(InterfaceC0229a interfaceC0229a) {
        this.bQj = interfaceC0229a;
    }

    public a(@NonNull Context context) {
        super(context, a.i.theme_manage_dialog_with_no_anim);
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.ala_live_link_mic_action_dialog);
        resize();
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        this.bQk = (SimpleDraweeView) findViewById(a.f.ala_link_mic_status_dialog_head_icon);
        this.mTitle = (TextView) findViewById(a.f.ala_link_mic_status_dialog_message);
        this.bQl = (TextView) findViewById(a.f.ala_link_mic_status_dialog_inviter);
        this.bDN = findViewById(a.f.ala_link_mic_status_dialog_btn_first);
        this.bDO = (TextView) findViewById(a.f.ala_link_mic_status_dialog_txt_first);
        this.bQm = (LottieAnimationView) findViewById(a.f.ala_link_mic_status_dialog_loading);
        this.bQm.setImageAssetsFolder("images/");
        this.bQn = (TextView) findViewById(a.f.ala_link_mic_status_dialog_btn_second);
        this.bQn.setVisibility(8);
        this.bQk.setBackgroundResource(a.e.sdk_default_avatar);
        RoundingParams ewa = this.bQk.getHierarchy().ewa();
        RoundingParams roundingParams = ewa == null ? new RoundingParams() : ewa;
        roundingParams.Bc(true);
        roundingParams.bI(6.0f);
        roundingParams.QC(-1);
        this.bQk.getHierarchy().a(roundingParams);
        this.bQk.setOnClickListener(this);
        this.bDN.setOnClickListener(this);
        this.bQn.setOnClickListener(this);
    }

    public void resize() {
        getWindow().setGravity(17);
    }

    public void iX(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bQk.setImageURI(str);
        }
    }

    public void setTitle(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mTitle.setText(str);
        }
    }

    public void iY(String str) {
        this.bQl.setText(str);
    }

    public void iz(String str) {
        this.bDO.setText(str);
    }

    public void iZ(String str) {
        this.bQn.setText(str);
    }

    public void fD(int i) {
        this.bDN.setVisibility(i);
    }

    public void gG(int i) {
        this.bQn.setVisibility(i);
    }

    public void gH(int i) {
        if (i == 0) {
            this.bQm.playAnimation();
        } else {
            this.bQm.cancelAnimation();
        }
        this.bQm.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bQk) {
            if (this.bQj != null) {
                this.bQj.Ye();
            }
        } else if (view == this.bDN) {
            if (this.bQj != null) {
                this.bQj.Yf();
            }
        } else if (view == this.bQn && this.bQj != null) {
            this.bQj.Yg();
        }
    }
}

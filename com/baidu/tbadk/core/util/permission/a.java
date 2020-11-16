package com.baidu.tbadk.core.util.permission;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.core.dialog.a {
    private TextView eOn;
    private TextView eOo;
    private TextView eOp;
    private String eOq;
    private InterfaceC0578a eOr;
    private ViewGroup mRootView;
    private TextView mTitleView;

    /* renamed from: com.baidu.tbadk.core.util.permission.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0578a {
        void d(Activity activity, String str);

        void e(Activity activity, String str);
    }

    public a(Activity activity) {
        super(activity);
        initView();
        ov(3);
        iW(false);
        iX(false);
        setAutoNight(false);
    }

    private void initView() {
        this.mRootView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.dialog_permission_request, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(R.id.tv_permission_request_title);
        this.eOn = (TextView) this.mRootView.findViewById(R.id.tv_permission_request_detail);
        this.eOo = (TextView) this.mRootView.findViewById(R.id.tv_permission_request_close);
        this.eOo.setText(R.string.close);
        this.eOp = (TextView) this.mRootView.findViewById(R.id.tv_permission_request_continue);
        this.eOp.setText(R.string.go_on);
        onChangeSkinType();
        bg(this.mRootView);
    }

    public void BF(String str) {
        this.eOq = str;
    }

    public void a(InterfaceC0578a interfaceC0578a) {
        this.eOr = interfaceC0578a;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        String string;
        String str = null;
        super.b(eVar);
        String str2 = this.eOq;
        char c = 65535;
        switch (str2.hashCode()) {
            case -63024214:
                if (str2.equals("android.permission.ACCESS_COARSE_LOCATION")) {
                    c = 2;
                    break;
                }
                break;
            case 463403621:
                if (str2.equals(PermissionRequest.RESOURCE_VIDEO_CAPTURE)) {
                    c = 0;
                    break;
                }
                break;
            case 1831139720:
                if (str2.equals(PermissionRequest.RESOURCE_AUDIO_CAPTURE)) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                string = eVar.getString(R.string.request_permission_title_camera);
                str = eVar.getString(R.string.request_permission_detail_camera);
                break;
            case 1:
                string = eVar.getString(R.string.request_permission_title_record_audio);
                str = eVar.getString(R.string.request_permission_detail_record_audio);
                break;
            case 2:
                string = eVar.getString(R.string.request_permission_title_location);
                str = eVar.getString(R.string.request_permission_detail_location);
                break;
            default:
                string = null;
                break;
        }
        this.mTitleView.setText(string);
        this.eOn.setText(str);
        this.eOo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.util.permission.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eOr != null) {
                    a.this.eOr.d(a.this.mActivity, a.this.eOq);
                }
            }
        });
        this.eOp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.util.permission.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eOr != null) {
                    a.this.eOr.e(a.this.mActivity, a.this.eOq);
                }
            }
        });
        return this;
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_permission_request_dialog);
        ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
        ap.setViewTextColor(this.eOn, R.color.CAM_X0107);
        ap.f(this.eOo, R.color.CAM_X0105, R.color.cp_cont_b_alpha50);
        ap.f(this.eOp, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50);
    }
}

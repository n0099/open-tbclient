package com.baidu.tbadk.core.util.permission;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.f;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.core.dialog.a {
    private TextView fei;
    private TextView fej;
    private TextView fek;
    private String fel;
    private InterfaceC0568a fem;
    private ViewGroup mRootView;
    private TextView mTitleView;

    /* renamed from: com.baidu.tbadk.core.util.permission.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0568a {
        void d(Activity activity, String str);

        void e(Activity activity, String str);
    }

    public a(Activity activity) {
        super(activity);
        initView();
        nB(3);
        jF(false);
        jG(false);
        setAutoNight(false);
    }

    private void initView() {
        this.mRootView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.dialog_permission_request, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(R.id.tv_permission_request_title);
        this.fei = (TextView) this.mRootView.findViewById(R.id.tv_permission_request_detail);
        this.fej = (TextView) this.mRootView.findViewById(R.id.tv_permission_request_close);
        this.fej.setText(R.string.close);
        this.fek = (TextView) this.mRootView.findViewById(R.id.tv_permission_request_continue);
        this.fek.setText(R.string.go_on);
        onChangeSkinType();
        bn(this.mRootView);
    }

    public void Bw(String str) {
        this.fel = str;
    }

    public void a(InterfaceC0568a interfaceC0568a) {
        this.fem = interfaceC0568a;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(f<?> fVar) {
        String string;
        String str;
        super.b(fVar);
        String str2 = this.fel;
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
                String string2 = fVar.getString(R.string.request_permission_title_camera);
                string = fVar.getString(R.string.request_permission_detail_camera);
                str = string2;
                break;
            case 1:
                String string3 = fVar.getString(R.string.request_permission_title_record_audio);
                string = fVar.getString(R.string.request_permission_detail_record_audio);
                str = string3;
                break;
            case 2:
                String string4 = fVar.getString(R.string.request_permission_title_location);
                string = fVar.getString(R.string.request_permission_detail_location);
                str = string4;
                break;
            default:
                string = null;
                str = null;
                break;
        }
        this.mTitleView.setText(str);
        this.fei.setText(string);
        this.fej.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.util.permission.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.fem != null) {
                    a.this.fem.d(a.this.mActivity, a.this.fel);
                }
            }
        });
        this.fek.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.util.permission.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.fem != null) {
                    a.this.fem.e(a.this.mActivity, a.this.fel);
                }
            }
        });
        return this;
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_permission_request_dialog);
        ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
        ap.setViewTextColor(this.fei, R.color.CAM_X0107);
        ap.k(this.fej, R.color.CAM_X0105, R.color.cp_cont_b_alpha50);
        ap.k(this.fek, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50);
    }
}

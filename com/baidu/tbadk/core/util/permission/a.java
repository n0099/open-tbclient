package com.baidu.tbadk.core.util.permission;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.f;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.core.dialog.a {
    private TextView fat;
    private TextView fau;
    private TextView fav;
    private String faw;
    private InterfaceC0565a fax;
    private ViewGroup mRootView;
    private TextView mTitleView;

    /* renamed from: com.baidu.tbadk.core.util.permission.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0565a {
        void d(Activity activity, String str);

        void e(Activity activity, String str);
    }

    public a(Activity activity) {
        super(activity);
        initView();
        nx(3);
        jD(false);
        jE(false);
        setAutoNight(false);
    }

    private void initView() {
        this.mRootView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.dialog_permission_request, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(R.id.tv_permission_request_title);
        this.fat = (TextView) this.mRootView.findViewById(R.id.tv_permission_request_detail);
        this.fau = (TextView) this.mRootView.findViewById(R.id.tv_permission_request_close);
        this.fau.setText(R.string.close);
        this.fav = (TextView) this.mRootView.findViewById(R.id.tv_permission_request_continue);
        this.fav.setText(R.string.go_on);
        onChangeSkinType();
        br(this.mRootView);
    }

    public void AY(String str) {
        this.faw = str;
    }

    public void a(InterfaceC0565a interfaceC0565a) {
        this.fax = interfaceC0565a;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(f<?> fVar) {
        String string;
        String str;
        super.b(fVar);
        String str2 = this.faw;
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
        this.fat.setText(string);
        this.fau.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.util.permission.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.fax != null) {
                    a.this.fax.d(a.this.mActivity, a.this.faw);
                }
            }
        });
        this.fav.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.util.permission.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.fax != null) {
                    a.this.fax.e(a.this.mActivity, a.this.faw);
                }
            }
        });
        return this;
    }

    public void onChangeSkinType() {
        ao.setBackgroundResource(this.mRootView, R.drawable.bg_permission_request_dialog);
        ao.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
        ao.setViewTextColor(this.fat, R.color.CAM_X0107);
        ao.k(this.fau, R.color.CAM_X0105, R.color.cp_cont_b_alpha50);
        ao.k(this.fav, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50);
    }
}

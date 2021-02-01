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
    private TextView fcJ;
    private TextView fcK;
    private TextView fcL;
    private String fcM;
    private InterfaceC0562a fcN;
    private ViewGroup mRootView;
    private TextView mTitleView;

    /* renamed from: com.baidu.tbadk.core.util.permission.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0562a {
        void d(Activity activity, String str);

        void e(Activity activity, String str);
    }

    public a(Activity activity) {
        super(activity);
        initView();
        nA(3);
        jF(false);
        jG(false);
        setAutoNight(false);
    }

    private void initView() {
        this.mRootView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.dialog_permission_request, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(R.id.tv_permission_request_title);
        this.fcJ = (TextView) this.mRootView.findViewById(R.id.tv_permission_request_detail);
        this.fcK = (TextView) this.mRootView.findViewById(R.id.tv_permission_request_close);
        this.fcK.setText(R.string.close);
        this.fcL = (TextView) this.mRootView.findViewById(R.id.tv_permission_request_continue);
        this.fcL.setText(R.string.go_on);
        onChangeSkinType();
        bn(this.mRootView);
    }

    public void Bp(String str) {
        this.fcM = str;
    }

    public void a(InterfaceC0562a interfaceC0562a) {
        this.fcN = interfaceC0562a;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(f<?> fVar) {
        String string;
        String str;
        super.b(fVar);
        String str2 = this.fcM;
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
        this.fcJ.setText(string);
        this.fcK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.util.permission.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.fcN != null) {
                    a.this.fcN.d(a.this.mActivity, a.this.fcM);
                }
            }
        });
        this.fcL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.util.permission.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.fcN != null) {
                    a.this.fcN.e(a.this.mActivity, a.this.fcM);
                }
            }
        });
        return this;
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_permission_request_dialog);
        ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
        ap.setViewTextColor(this.fcJ, R.color.CAM_X0107);
        ap.k(this.fcK, R.color.CAM_X0105, R.color.cp_cont_b_alpha50);
        ap.k(this.fcL, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50);
    }
}

package com.baidu.tbadk.core.util.permission;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.core.dialog.a {
    private TextView ecG;
    private TextView ecH;
    private TextView ecI;
    private String ecJ;
    private InterfaceC0495a ecK;
    private ViewGroup mRootView;
    private TextView mTitleView;

    /* renamed from: com.baidu.tbadk.core.util.permission.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0495a {
        void e(Activity activity, String str);

        void f(Activity activity, String str);
    }

    public a(Activity activity) {
        super(activity);
        initView();
        lq(3);
        hJ(false);
        hK(false);
        setAutoNight(false);
    }

    private void initView() {
        this.mRootView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.dialog_permission_request, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(R.id.tv_permission_request_title);
        this.ecG = (TextView) this.mRootView.findViewById(R.id.tv_permission_request_detail);
        this.ecH = (TextView) this.mRootView.findViewById(R.id.tv_permission_request_close);
        this.ecH.setText(R.string.close);
        this.ecI = (TextView) this.mRootView.findViewById(R.id.tv_permission_request_continue);
        this.ecI.setText(R.string.go_on);
        onChangeSkinType();
        aV(this.mRootView);
    }

    public void yb(String str) {
        this.ecJ = str;
    }

    public void a(InterfaceC0495a interfaceC0495a) {
        this.ecK = interfaceC0495a;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        String string;
        String str = null;
        super.b(eVar);
        String str2 = this.ecJ;
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
        this.ecG.setText(str);
        this.ecH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.util.permission.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ecK != null) {
                    a.this.ecK.e(a.this.mActivity, a.this.ecJ);
                }
            }
        });
        this.ecI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.util.permission.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ecK != null) {
                    a.this.ecK.f(a.this.mActivity, a.this.ecJ);
                }
            }
        });
        return this;
    }

    public void onChangeSkinType() {
        ao.setBackgroundResource(this.mRootView, R.drawable.bg_permission_request_dialog);
        ao.setViewTextColor(this.mTitleView, R.color.cp_cont_b);
        ao.setViewTextColor(this.ecG, R.color.cp_cont_j);
        ao.f(this.ecH, R.color.cp_cont_b, R.color.cp_cont_b_alpha50);
        ao.f(this.ecI, R.color.cp_link_tip_a, R.color.cp_link_tip_a_alpha50);
    }
}

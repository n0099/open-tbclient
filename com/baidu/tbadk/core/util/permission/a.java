package com.baidu.tbadk.core.util.permission;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.core.dialog.a {
    private TextView dPt;
    private TextView dPu;
    private TextView dPv;
    private String dPw;
    private InterfaceC0476a dPx;
    private ViewGroup mRootView;
    private TextView mTitleView;

    /* renamed from: com.baidu.tbadk.core.util.permission.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0476a {
        void e(Activity activity, String str);

        void f(Activity activity, String str);
    }

    public a(Activity activity) {
        super(activity);
        initView();
        kG(3);
        gW(false);
        gX(false);
        setAutoNight(false);
    }

    private void initView() {
        this.mRootView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.dialog_permission_request, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(R.id.tv_permission_request_title);
        this.dPt = (TextView) this.mRootView.findViewById(R.id.tv_permission_request_detail);
        this.dPu = (TextView) this.mRootView.findViewById(R.id.tv_permission_request_close);
        this.dPu.setText(R.string.close);
        this.dPv = (TextView) this.mRootView.findViewById(R.id.tv_permission_request_continue);
        this.dPv.setText(R.string.go_on);
        onChangeSkinType();
        aP(this.mRootView);
    }

    public void wC(String str) {
        this.dPw = str;
    }

    public void a(InterfaceC0476a interfaceC0476a) {
        this.dPx = interfaceC0476a;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        String string;
        String str = null;
        super.b(eVar);
        String str2 = this.dPw;
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
        this.dPt.setText(str);
        this.dPu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.util.permission.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dPx != null) {
                    a.this.dPx.e(a.this.mActivity, a.this.dPw);
                }
            }
        });
        this.dPv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.util.permission.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dPx != null) {
                    a.this.dPx.f(a.this.mActivity, a.this.dPw);
                }
            }
        });
        return this;
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.mRootView, R.drawable.bg_permission_request_dialog);
        am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.dPt, (int) R.color.cp_cont_j);
        am.d(this.dPu, R.color.cp_cont_b, R.color.cp_cont_b_alpha50);
        am.d(this.dPv, R.color.cp_link_tip_a, R.color.cp_link_tip_a_alpha50);
    }
}

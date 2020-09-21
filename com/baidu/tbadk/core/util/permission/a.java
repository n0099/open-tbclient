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
    private TextView eoM;
    private TextView eoN;
    private TextView eoO;
    private String eoP;
    private InterfaceC0536a eoQ;
    private ViewGroup mRootView;
    private TextView mTitleView;

    /* renamed from: com.baidu.tbadk.core.util.permission.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0536a {
        void d(Activity activity, String str);

        void e(Activity activity, String str);
    }

    public a(Activity activity) {
        super(activity);
        initView();
        nH(3);
        id(false);
        ie(false);
        setAutoNight(false);
    }

    private void initView() {
        this.mRootView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.dialog_permission_request, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(R.id.tv_permission_request_title);
        this.eoM = (TextView) this.mRootView.findViewById(R.id.tv_permission_request_detail);
        this.eoN = (TextView) this.mRootView.findViewById(R.id.tv_permission_request_close);
        this.eoN.setText(R.string.close);
        this.eoO = (TextView) this.mRootView.findViewById(R.id.tv_permission_request_continue);
        this.eoO.setText(R.string.go_on);
        onChangeSkinType();
        aZ(this.mRootView);
    }

    public void AM(String str) {
        this.eoP = str;
    }

    public void a(InterfaceC0536a interfaceC0536a) {
        this.eoQ = interfaceC0536a;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        String string;
        String str = null;
        super.b(eVar);
        String str2 = this.eoP;
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
        this.eoM.setText(str);
        this.eoN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.util.permission.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eoQ != null) {
                    a.this.eoQ.d(a.this.mActivity, a.this.eoP);
                }
            }
        });
        this.eoO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.util.permission.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.eoQ != null) {
                    a.this.eoQ.e(a.this.mActivity, a.this.eoP);
                }
            }
        });
        return this;
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_permission_request_dialog);
        ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b);
        ap.setViewTextColor(this.eoM, R.color.cp_cont_j);
        ap.e(this.eoN, R.color.cp_cont_b, R.color.cp_cont_b_alpha50);
        ap.e(this.eoO, R.color.cp_link_tip_a, R.color.cp_link_tip_a_alpha50);
    }
}

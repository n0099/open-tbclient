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
    private TextView dbG;
    private TextView dbH;
    private TextView dbI;
    private String dbJ;
    private InterfaceC0378a dbK;
    private ViewGroup mRootView;
    private TextView mTitleView;

    /* renamed from: com.baidu.tbadk.core.util.permission.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0378a {
        void e(Activity activity, String str);

        void f(Activity activity, String str);
    }

    public a(Activity activity) {
        super(activity);
        initView();
        jZ(3);
        fG(false);
        fH(false);
        setAutoNight(false);
    }

    private void initView() {
        this.mRootView = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.dialog_permission_request, (ViewGroup) null);
        this.mTitleView = (TextView) this.mRootView.findViewById(R.id.tv_permission_request_title);
        this.dbG = (TextView) this.mRootView.findViewById(R.id.tv_permission_request_detail);
        this.dbH = (TextView) this.mRootView.findViewById(R.id.tv_permission_request_close);
        this.dbH.setText(R.string.close);
        this.dbI = (TextView) this.mRootView.findViewById(R.id.tv_permission_request_continue);
        this.dbI.setText(R.string.go_on);
        onChangeSkinType();
        aO(this.mRootView);
    }

    public void tG(String str) {
        this.dbJ = str;
    }

    public void a(InterfaceC0378a interfaceC0378a) {
        this.dbK = interfaceC0378a;
    }

    @Override // com.baidu.tbadk.core.dialog.a
    public com.baidu.tbadk.core.dialog.a b(e<?> eVar) {
        String string;
        String str = null;
        super.b(eVar);
        String str2 = this.dbJ;
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
        this.dbG.setText(str);
        this.dbH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.util.permission.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dbK != null) {
                    a.this.dbK.e(a.this.mActivity, a.this.dbJ);
                }
            }
        });
        this.dbI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.util.permission.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dbK != null) {
                    a.this.dbK.f(a.this.mActivity, a.this.dbJ);
                }
            }
        });
        return this;
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.mRootView, R.drawable.bg_permission_request_dialog);
        am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.dbG, (int) R.color.cp_cont_j);
        am.b(this.dbH, R.color.cp_cont_b, R.color.cp_cont_b_alpha50);
        am.b(this.dbI, R.color.cp_link_tip_a, R.color.cp_link_tip_a_alpha50);
    }
}

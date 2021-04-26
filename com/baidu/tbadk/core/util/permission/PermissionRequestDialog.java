package com.baidu.tbadk.core.util.permission;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.webkit.sdk.PermissionRequest;
import d.a.c.a.f;
import d.a.i0.r.s.a;
/* loaded from: classes3.dex */
public class PermissionRequestDialog extends a {
    public TextView mCloseView;
    public TextView mContinueView;
    public TextView mDetailView;
    public OnClickCallback mOnClickCallback;
    public String mRequestPermission;
    public ViewGroup mRootView;
    public TextView mTitleView;

    /* loaded from: classes3.dex */
    public interface OnClickCallback {
        void onClickClose(Activity activity, String str);

        void onClickContinue(Activity activity, String str);
    }

    public PermissionRequestDialog(Activity activity) {
        super(activity);
        initView();
        setContentViewSize(3);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        setAutoNight(false);
    }

    private void initView() {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mActivity).inflate(R.layout.dialog_permission_request, (ViewGroup) null);
        this.mRootView = viewGroup;
        this.mTitleView = (TextView) viewGroup.findViewById(R.id.tv_permission_request_title);
        this.mDetailView = (TextView) this.mRootView.findViewById(R.id.tv_permission_request_detail);
        TextView textView = (TextView) this.mRootView.findViewById(R.id.tv_permission_request_close);
        this.mCloseView = textView;
        textView.setText(R.string.close);
        TextView textView2 = (TextView) this.mRootView.findViewById(R.id.tv_permission_request_continue);
        this.mContinueView = textView2;
        textView2.setText(R.string.go_on);
        onChangeSkinType();
        setContentView(this.mRootView);
    }

    @Override // d.a.i0.r.s.a
    public a create(f<?> fVar) {
        char c2;
        String string;
        super.create(fVar);
        String str = this.mRequestPermission;
        int hashCode = str.hashCode();
        if (hashCode == -63024214) {
            if (str.equals("android.permission.ACCESS_COARSE_LOCATION")) {
                c2 = 2;
            }
            c2 = 65535;
        } else if (hashCode != 463403621) {
            if (hashCode == 1831139720 && str.equals(PermissionRequest.RESOURCE_AUDIO_CAPTURE)) {
                c2 = 1;
            }
            c2 = 65535;
        } else {
            if (str.equals(PermissionRequest.RESOURCE_VIDEO_CAPTURE)) {
                c2 = 0;
            }
            c2 = 65535;
        }
        String str2 = null;
        if (c2 == 0) {
            str2 = fVar.getString(R.string.request_permission_title_camera);
            string = fVar.getString(R.string.request_permission_detail_camera);
        } else if (c2 == 1) {
            str2 = fVar.getString(R.string.request_permission_title_record_audio);
            string = fVar.getString(R.string.request_permission_detail_record_audio);
        } else if (c2 != 2) {
            string = null;
        } else {
            str2 = fVar.getString(R.string.request_permission_title_location);
            string = fVar.getString(R.string.request_permission_detail_location);
        }
        this.mTitleView.setText(str2);
        this.mDetailView.setText(string);
        this.mCloseView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.util.permission.PermissionRequestDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PermissionRequestDialog.this.mOnClickCallback != null) {
                    PermissionRequestDialog.this.mOnClickCallback.onClickClose(PermissionRequestDialog.this.mActivity, PermissionRequestDialog.this.mRequestPermission);
                }
            }
        });
        this.mContinueView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.util.permission.PermissionRequestDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PermissionRequestDialog.this.mOnClickCallback != null) {
                    PermissionRequestDialog.this.mOnClickCallback.onClickContinue(PermissionRequestDialog.this.mActivity, PermissionRequestDialog.this.mRequestPermission);
                }
            }
        });
        return this;
    }

    public void onChangeSkinType() {
        SkinManager.setBackgroundResource(this.mRootView, R.drawable.bg_permission_request_dialog);
        SkinManager.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.mDetailView, R.color.CAM_X0107);
        SkinManager.setViewTextColorSelector(this.mCloseView, R.color.CAM_X0105, R.color.cp_cont_b_alpha50);
        SkinManager.setViewTextColorSelector(this.mContinueView, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50);
    }

    public void setOnClickCallback(OnClickCallback onClickCallback) {
        this.mOnClickCallback = onClickCallback;
    }

    public void setRequestPermission(String str) {
        this.mRequestPermission = str;
    }
}

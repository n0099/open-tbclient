package com.baidu.searchbox.ng.ai.apps.core.handler;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AiAppAlertDialog;
import com.baidu.searchbox.ng.ai.apps.res.widget.toast.UniversalToast;
import com.baidu.webkit.sdk.GeolocationPermissions;
import org.apache.http.HttpHost;
/* loaded from: classes2.dex */
public class AiAppGeolocationDialog {
    private GeolocationPermissions.Callback mCallback;
    private Context mContext;
    private AiAppAlertDialog mGeoDialog;
    private TextView mMessage;
    private String mOrigin;
    private CheckBox mRemember;

    public AiAppGeolocationDialog(Context context, String str, GeolocationPermissions.Callback callback) {
        this.mContext = context;
        this.mCallback = callback;
        this.mOrigin = str;
        createDialog();
    }

    private void createDialog() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.aiapps_light_browser_geolocation_dialog, (ViewGroup) null);
        this.mRemember = (CheckBox) inflate.findViewById(R.id.remember);
        this.mMessage = (TextView) inflate.findViewById(R.id.message_text);
        this.mMessage.setTextColor(this.mContext.getResources().getColor(R.color.aiapps_box_dialog_message_text_color));
        this.mMessage.setText(getMessage());
        this.mGeoDialog = new AiAppAlertDialog.Builder(this.mContext).setTitle(R.string.aiapps_geolocation_permissions_prompt_title).setView(inflate).setNegativeButton(R.string.aiapps_geolocation_permissions_prompt_dont_share, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.handler.AiAppGeolocationDialog.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                AiAppGeolocationDialog.this.handleButtonClick(false);
            }
        }).setPositiveButton(R.string.aiapps_geolocation_permissions_prompt_share, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.handler.AiAppGeolocationDialog.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                AiAppGeolocationDialog.this.handleButtonClick(true);
            }
        }).create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleButtonClick(boolean z) {
        int i;
        boolean isChecked = this.mRemember.isChecked();
        if (isChecked) {
            if (z) {
                i = R.string.aiapps_geolocation_permissions_prompt_toast_allowed;
            } else {
                i = R.string.aiapps_geolocation_permissions_prompt_toast_disallowed;
            }
            UniversalToast.makeText(this.mContext.getApplicationContext(), i).setDuration(3).showToast();
        }
        this.mCallback.invoke(this.mOrigin, z, isChecked);
    }

    private String getMessage() {
        Uri parse = Uri.parse(this.mOrigin);
        String str = this.mOrigin;
        if (HttpHost.DEFAULT_SCHEME_NAME.equals(parse.getScheme())) {
            str = this.mOrigin.substring("http://".length());
        }
        return String.format(this.mContext.getResources().getString(R.string.aiapps_geolocation_permissions_prompt_message), str);
    }

    public void show() {
        if (this.mGeoDialog != null) {
            this.mGeoDialog.show();
        }
    }

    public void hide() {
        if (this.mGeoDialog != null) {
            this.mGeoDialog.hide();
        }
    }
}

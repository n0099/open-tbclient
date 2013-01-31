package com.baidu.browser.webkit;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.browser.webkit.BdGeolocationPermissions;
import com.baidu.loginshare.e;
/* loaded from: classes.dex */
public class BdGeolocationPermissionsPrompt extends LinearLayout {
    private BdGeolocationPermissions.BdCallback mCallback;
    private Button mDontShareButton;
    private LinearLayout mInner;
    private TextView mMessage;
    private String mOrigin;
    private CheckBox mRemember;
    private Button mShareButton;

    public BdGeolocationPermissionsPrompt(Context context) {
        this(context, null);
    }

    public BdGeolocationPermissionsPrompt(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void init() {
        this.mInner = (LinearLayout) findViewById(getContext().getResources().getIdentifier("inner", "id", getContext().getPackageName()));
        this.mMessage = (TextView) findViewById(getContext().getResources().getIdentifier("message", "id", getContext().getPackageName()));
        this.mShareButton = (Button) findViewById(getContext().getResources().getIdentifier("share_button", "id", getContext().getPackageName()));
        this.mDontShareButton = (Button) findViewById(getContext().getResources().getIdentifier("dont_share_button", "id", getContext().getPackageName()));
        this.mRemember = (CheckBox) findViewById(getContext().getResources().getIdentifier("remember", "id", getContext().getPackageName()));
        this.mShareButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.browser.webkit.BdGeolocationPermissionsPrompt.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BdGeolocationPermissionsPrompt.this.handleButtonClick(true);
            }
        });
        this.mDontShareButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.browser.webkit.BdGeolocationPermissionsPrompt.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BdGeolocationPermissionsPrompt.this.handleButtonClick(false);
            }
        });
    }

    public void show(String str, BdGeolocationPermissions.BdCallback bdCallback) {
        this.mOrigin = str;
        this.mCallback = bdCallback;
        Uri parse = Uri.parse(this.mOrigin);
        String str2 = this.mOrigin;
        if ("http".equals(parse.getScheme())) {
            str2 = this.mOrigin.substring(e.f.length());
        }
        setMessage(str2);
        this.mRemember.setChecked(true);
        showDialog(true);
    }

    public void hide() {
        showDialog(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleButtonClick(boolean z) {
        int identifier;
        showDialog(false);
        boolean isChecked = this.mRemember.isChecked();
        if (isChecked) {
            if (z) {
                identifier = getContext().getResources().getIdentifier("browser_geolocation_permissions_prompt_toast_allowed", "string", getContext().getPackageName());
            } else {
                identifier = getContext().getResources().getIdentifier("browser_geolocation_permissions_prompt_toast_disallowed", "string", getContext().getPackageName());
            }
            Toast makeText = Toast.makeText(getContext(), identifier, 1);
            makeText.setGravity(80, 0, 0);
            makeText.show();
        }
        this.mCallback.invoke(this.mOrigin, z, isChecked);
    }

    private void setMessage(CharSequence charSequence) {
        this.mMessage.setText(String.format(getResources().getString(getContext().getResources().getIdentifier("browser_geolocation_permissions_prompt_message", "string", getContext().getPackageName())), charSequence));
    }

    private void showDialog(boolean z) {
        if (z) {
            this.mInner.setVisibility(0);
        } else {
            this.mInner.setVisibility(8);
        }
    }
}

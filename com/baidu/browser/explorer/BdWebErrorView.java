package com.baidu.browser.explorer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.browser.core.BdNoProGuard;
import com.baidu.browser.webpool.BdWebPoolView;
/* loaded from: classes.dex */
public class BdWebErrorView extends ScrollView implements BdNoProGuard {
    public static final int BAD_NETWORK = 16;
    public static final int ERROR_CODE_400 = 400;
    public static final int ERROR_CODE_401 = 401;
    public static final int ERROR_CODE_403 = 403;
    public static final int ERROR_CODE_404 = 404;
    public static final int ERROR_CODE_405 = 405;
    public static final int ERROR_CODE_406 = 406;
    public static final int ERROR_CODE_407 = 407;
    public static final int ERROR_CODE_408 = 408;
    public static final int ERROR_CODE_409 = 409;
    public static final int ERROR_CODE_410 = 410;
    public static final int ERROR_CODE_411 = 411;
    public static final int ERROR_CODE_412 = 412;
    public static final int ERROR_CODE_413 = 413;
    public static final int ERROR_CODE_414 = 414;
    public static final int ERROR_CODE_415 = 415;
    public static final int ERROR_CODE_416 = 416;
    public static final int ERROR_CODE_417 = 417;
    public static final int ERROR_CODE_500 = 500;
    public static final int ERROR_CODE_501 = 501;
    public static final int ERROR_CODE_502 = 502;
    public static final int ERROR_CODE_503 = 503;
    public static final int ERROR_CODE_504 = 504;
    public static final int ERROR_CODE_505 = 505;
    public static final int ERROR_CODE_900 = 900;
    public static final int FILE_EXIST = 17;
    public static final int FILE_NAME_ERROR = 19;
    public static final int FILE_SIZE_ERROR = 20;
    public static final int HTTP_CONNECT_NO_FOUND = 7;
    public static final int HTTP_FORMAT_ERROR = 6;
    public static final int HTTP_ILLEGAL_ARGUMENT = 8;
    public static final int HTTP_INTERRUPT_ERROR = 12;
    public static final int HTTP_IO_ERROR = 9;
    public static final int HTTP_MOVE_ERROR = 3;
    public static final int HTTP_NOT_FOUND = 1;
    public static final int HTTP_NOT_MODIFIED = 13;
    public static final int HTTP_TIMEOUT = 2;
    public static final int HTTP_TRANS_DOWNLOAD = 11;
    public static final int HTTP_UNKONW_ERROR = 4;
    public static final int HTTP_USER_STOP = 5;
    public static final int HTTP_ZERO_BYTES = 10;
    public static final int NOT_PERMISSIONS = 15;
    public static final int NO_SDCARD = 18;
    public static final int OUT_OF_MEMORY = 14;
    public static final int PARSE_DATA_ERROR = 21;
    private BdWebPoolView mAttachedFixedWebView;
    private Button mButton;
    private TextView mDescriptionTextView;
    private ImageView mImageView;
    private BdErrorViewListener mListener;

    /* loaded from: classes.dex */
    public interface BdErrorViewListener {
        void onErrorPageGoBack();

        void onErrorPageRefresh();
    }

    public BdWebErrorView(Context context) {
        super(context);
        init();
    }

    public BdWebErrorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mDescriptionTextView = (TextView) findViewById(getContext().getResources().getIdentifier("webview_error_description_textview", "id", getContext().getPackageName()));
        this.mImageView = (ImageView) findViewById(getContext().getResources().getIdentifier("webview_error_imageview", "id", getContext().getPackageName()));
        this.mButton = (Button) findViewById(getContext().getResources().getIdentifier("webview_error_button", "id", getContext().getPackageName()));
    }

    public void setAttachedFixedWebView(BdWebPoolView bdWebPoolView) {
        this.mAttachedFixedWebView = bdWebPoolView;
    }

    public BdWebPoolView getAttachedFixedWebView() {
        return this.mAttachedFixedWebView;
    }

    public void setErrorCode(int i) {
        int identifier = getContext().getResources().getIdentifier("browser_webview_error_fail_connection", "string", getContext().getPackageName());
        int identifier2 = getContext().getResources().getIdentifier("borwser_errorpage_error", "drawable", getContext().getPackageName());
        boolean z = true;
        switch (i) {
            case -14:
            case -13:
                identifier = getContext().getResources().getIdentifier("browser_webview_error_file_not_found", "string", getContext().getPackageName());
                identifier2 = getContext().getResources().getIdentifier("borwser_errorpage_error_not_found", "drawable", getContext().getPackageName());
                z = false;
                break;
        }
        this.mDescriptionTextView.setText(identifier);
        this.mImageView.setImageResource(identifier2);
        this.mButton.setTag(Boolean.valueOf(z));
        if (z) {
            this.mButton.setText(getContext().getResources().getIdentifier("browser_webview_error_retry_button", "string", getContext().getPackageName()));
        } else {
            this.mButton.setText(getContext().getResources().getIdentifier("browser_webview_error_back_button", "string", getContext().getPackageName()));
        }
        this.mButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.browser.explorer.BdWebErrorView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BdWebErrorView.this.mAttachedFixedWebView != null) {
                    boolean booleanValue = ((Boolean) BdWebErrorView.this.mButton.getTag()).booleanValue();
                    if (BdWebErrorView.this.mListener != null) {
                        if (booleanValue) {
                            BdWebErrorView.this.mListener.onErrorPageRefresh();
                        } else {
                            BdWebErrorView.this.mListener.onErrorPageGoBack();
                        }
                    }
                }
            }
        });
    }

    public void setEventListener(BdErrorViewListener bdErrorViewListener) {
        this.mListener = bdErrorViewListener;
    }
}

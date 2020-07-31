package com.baidu.sapi2.views;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.g.a.a;
import com.baidu.sapi2.utils.SapiUtils;
/* loaded from: classes19.dex */
public class o extends Dialog {
    private Context a;
    private RippleSurfaceView b;

    public o(Context context) {
        super(context, a.h.sapi_sdk_speech_dialog);
        this.a = context;
    }

    public void a(int i) {
        this.b.setAmplitude(i);
    }

    @Override // android.app.Dialog
    @TargetApi(3)
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        window.setGravity(80);
        window.setWindowAnimations(a.h.sapi_sdk_anim_speech);
        setContentView(a.f.layout_sapi_sdk_dialog_speech_recognition);
        Display defaultDisplay = ((Activity) this.a).getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = (defaultDisplay.getWidth() * 91) / 100;
        attributes.height = (defaultDisplay.getHeight() * 3) / 10;
        attributes.y = SapiUtils.dip2px(getContext(), 17.0f);
        getWindow().setAttributes(attributes);
        this.b = (RippleSurfaceView) findViewById(a.e.ripple_view);
        findViewById(a.e.stop_speech_tx).setOnClickListener(new n(this));
    }
}

package com.baidu.pass.ecommerce.d;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.sapi2.ecommerce.R;
import com.baidu.sapi2.ecommerce.callback.AddressManageCallback;
import com.baidu.sapi2.utils.SapiUtils;
/* loaded from: classes15.dex */
public class b extends Dialog {
    public static final int p = 9000;
    public static final int q = 0;
    public static final int r = 1;
    public static final int s = 2;
    public static final int t = 0;
    public static final int u = 1;

    /* renamed from: a  reason: collision with root package name */
    private Activity f4111a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f4112b;
    private ImageView c;
    private RelativeLayout d;
    private RelativeLayout e;
    private RelativeLayout f;
    private ViewStub g;
    private View h;
    private ImageView i;
    private TextView j;
    private com.baidu.pass.ecommerce.d.a k;
    private com.baidu.pass.ecommerce.d.c l;
    private g m;
    private h n;
    public int o;

    /* loaded from: classes15.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.n != null) {
                b.this.n.onStopSpeech();
            }
        }
    }

    /* renamed from: com.baidu.pass.ecommerce.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    class View$OnClickListenerC0286b implements View.OnClickListener {
        View$OnClickListenerC0286b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.a();
        }
    }

    /* loaded from: classes15.dex */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", b.this.f4111a.getPackageName(), null));
            b.this.f4111a.startActivityForResult(intent, b.p);
        }
    }

    /* loaded from: classes15.dex */
    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.n != null) {
                b.this.n.onStopSpeech();
            }
        }
    }

    /* loaded from: classes15.dex */
    public interface g {
        void onReset();
    }

    /* loaded from: classes15.dex */
    public interface h {
        void onStopSpeech();
    }

    public b(Activity activity) {
        super(activity, R.style.sapi_sdk_speech_dialog);
        this.o = 1;
        this.f4111a = activity;
    }

    public void c(int i) {
        RelativeLayout relativeLayout = this.f;
        if (relativeLayout != null && this.e != null) {
            relativeLayout.setVisibility(8);
            this.e.setVisibility(8);
        }
        this.g = (ViewStub) findViewById(R.id.voice_error_parent_view);
        ViewStub viewStub = this.g;
        this.h = viewStub != null ? viewStub.inflate() : this.h;
        View view = this.h;
        if (view != null) {
            if (4 != view.getVisibility()) {
                this.h.setVisibility(0);
            }
            ImageView imageView = (ImageView) this.h.findViewById(R.id.error_icon);
            TextView textView = (TextView) this.h.findViewById(R.id.error_title);
            TextView textView2 = (TextView) this.h.findViewById(R.id.error_content);
            TextView textView3 = (TextView) this.h.findViewById(R.id.error_desc);
            Button button = (Button) this.h.findViewById(R.id.error_btn);
            button.setVisibility(8);
            textView3.setVisibility(8);
            button.setOnClickListener(new d());
            ((ImageView) this.h.findViewById(R.id.close_button_stub)).setOnClickListener(new e());
            switch (i) {
                case AddressManageCallback.VoiceRecognitionResult.ERROR_CODE_VOICE_RECOGNITION_INTERRUPT /* -506 */:
                    imageView.setImageResource(R.drawable.sapi_sdk_speech_error_microphone);
                    textView.setText(R.string.sapi_sdk_speech_recognition_error_interrupt_title);
                    textView2.setText(R.string.sapi_sdk_speech_recognition_error_interrupt_tips);
                    b(0);
                    return;
                case AddressManageCallback.VoiceRecognitionResult.ERROR_CODE_VOICE_RECOGNITION_NET_TIME_OUT /* -505 */:
                    imageView.setImageResource(R.drawable.sapi_sdk_speech_error_no_net);
                    textView.setText(R.string.sapi_sdk_speech_recognition_error_net_time_out_title);
                    textView2.setText(R.string.sapi_sdk_speech_recognition_error_net_time_out_content);
                    break;
                case AddressManageCallback.VoiceRecognitionResult.ERROR_CODE_VOICE_RECOGNITION_MICRO_OFF /* -504 */:
                    imageView.setImageResource(R.drawable.sapi_sdk_speech_error_microphone);
                    textView.setText(R.string.sapi_sdk_speech_recognition_error_microphone_title);
                    textView2.setText(R.string.sapi_sdk_speech_recognition_error_microphone_content);
                    button.setVisibility(0);
                    textView3.setVisibility(0);
                    break;
                case AddressManageCallback.VoiceRecognitionResult.ERROR_CODE_VOICE_RECOGNITION_NET_OFF /* -503 */:
                    imageView.setImageResource(R.drawable.sapi_sdk_speech_error_no_net);
                    textView.setText(R.string.sapi_sdk_speech_recognition_error_net_off_title);
                    textView2.setText(R.string.sapi_sdk_speech_recognition_error_net_off_content);
                    break;
                case AddressManageCallback.VoiceRecognitionResult.ERROR_CODE_VOICE_RECOGNITION_INIT_FAIL /* -502 */:
                    imageView.setImageResource(R.drawable.sapi_sdk_speech_error_warn);
                    textView.setText(R.string.sapi_sdk_speech_recognition_error_init_fail);
                    textView2.setText(R.string.sapi_sdk_speech_recognition_error_retry);
                    break;
                default:
                    imageView.setImageResource(R.drawable.sapi_sdk_speech_error_warn);
                    textView.setText(R.string.sapi_sdk_speech_recognition_error_unkown);
                    textView2.setText(R.string.sapi_sdk_speech_recognition_error_retry);
                    break;
            }
        }
        b(2);
    }

    @Override // android.app.Dialog
    @TargetApi(3)
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        window.setGravity(80);
        window.setWindowAnimations(R.style.sapi_sdk_anim_speech);
        setContentView(R.layout.layout_sapi_sdk_dialog_speech_recognition);
        Display defaultDisplay = this.f4111a.getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = defaultDisplay.getWidth();
        attributes.height = SapiUtils.dip2px(getContext(), 297.0f);
        getWindow().setAttributes(attributes);
        this.f4112b = (TextView) findViewById(R.id.tips_tx);
        this.e = (RelativeLayout) findViewById(R.id.voice_parent_layout);
        this.c = (ImageView) findViewById(R.id.close_button);
        this.d = (RelativeLayout) findViewById(R.id.stop_speech_background_layout);
        this.f = (RelativeLayout) findViewById(R.id.tips_area_layout);
        this.i = (ImageView) findViewById(R.id.microphone_icon);
        this.j = (TextView) findViewById(R.id.stop_speech_tx);
        this.l = new com.baidu.pass.ecommerce.d.c(getContext());
        this.l.a(this.e);
        this.l.b();
        this.d.setOnClickListener(new a());
        this.c.setOnClickListener(new View$OnClickListenerC0286b());
    }

    public void a(int i) {
        com.baidu.pass.ecommerce.d.c cVar = this.l;
        if (cVar != null) {
            cVar.a(i);
        }
    }

    public void b() {
        this.k = new com.baidu.pass.ecommerce.d.a(getContext(), SapiUtils.dip2px(getContext(), 25.0f), -1);
        RelativeLayout relativeLayout = this.e;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
            this.e.addView(this.k);
            this.k.a();
        }
    }

    public void a(String str) {
        TextView textView = this.f4112b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void a() {
        RelativeLayout relativeLayout = this.f;
        if (relativeLayout != null && this.e != null) {
            relativeLayout.setVisibility(0);
            this.e.setVisibility(0);
            this.e.removeAllViews();
            this.l = new com.baidu.pass.ecommerce.d.c(getContext());
            this.l.a(this.e);
            this.l.b();
        }
        View view = this.h;
        if (view != null) {
            view.setVisibility(8);
        }
        RelativeLayout relativeLayout2 = this.d;
        if (relativeLayout2 != null) {
            relativeLayout2.setOnClickListener(new f());
        }
        this.j.setText(R.string.sapi_sdk_speech_recognition_stop_speech);
        g gVar = this.m;
        if (gVar != null) {
            gVar.onReset();
        }
    }

    public void b(int i) {
        RelativeLayout relativeLayout;
        if (i == 0) {
            this.d.setBackgroundResource(R.drawable.sapi_sdk_stop_speech_layout_rounded_coener);
            this.d.setOnClickListener(new c());
            this.j.setText(R.string.sapi_sdk_speech_recognition_error_interrupt_content);
            this.j.setVisibility(0);
        } else if (i == 1) {
            RelativeLayout relativeLayout2 = this.d;
            if (relativeLayout2 != null && this.j != null) {
                relativeLayout2.setClickable(false);
                this.d.setBackgroundResource(R.drawable.sapi_sdk_stop_speech_pressed_layout_rounded_coener);
                this.j.setText(R.string.sapi_sdk_speech_recognition_is_identifying);
                this.j.setVisibility(0);
            }
        } else if (i == 2 && (relativeLayout = this.d) != null && this.i != null && this.j != null) {
            relativeLayout.setClickable(false);
            this.d.setBackgroundResource(R.drawable.sapi_sdk_stop_speech_gray_layout_rounded_coener);
            this.i.setImageResource(R.drawable.sapi_sdk_speech_microphone_error_logo);
            this.j.setVisibility(8);
        }
    }

    public void a(g gVar) {
        this.m = gVar;
    }

    public void a(h hVar) {
        this.n = hVar;
    }
}

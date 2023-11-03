package com.baidu.swan.apps.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.dl3;
import com.baidu.tieba.rm1;
import com.facebook.drawee.view.SimpleDraweeView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes4.dex */
public class BearLayout extends LinearLayout {
    public static final boolean j = rm1.a;
    public TextView a;
    public SimpleDraweeView b;
    public BdBaseImageView c;
    public FrameLayout d;
    public TextView e;
    public BdBaseImageView f;
    public boolean g;
    public d h;
    public Context i;

    /* loaded from: classes4.dex */
    public interface d {
        void a(boolean z);

        void b(String str);
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ SwanAppBearInfo a;

        public a(SwanAppBearInfo swanAppBearInfo) {
            this.a = swanAppBearInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            BearLayout.this.j(this.a.bearHomeUrl);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public final /* synthetic */ dl3 a;
        public final /* synthetic */ SwanAppBearInfo b;

        public b(dl3 dl3Var, SwanAppBearInfo swanAppBearInfo) {
            this.a = dl3Var;
            this.b = swanAppBearInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (!BearLayout.this.g) {
                BearLayout.this.l();
                this.a.b();
                return;
            }
            BearLayout.this.j(this.b.bearHomeUrl);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d {
        public c() {
        }

        @Override // com.baidu.swan.apps.view.BearLayout.d
        public void a(boolean z) {
            CharSequence text;
            int i;
            int i2;
            BearLayout.this.g = z;
            if (BearLayout.this.f != null && BearLayout.this.e != null) {
                BearLayout.this.f.clearAnimation();
                BearLayout.this.f.setVisibility(4);
                BearLayout.this.e.setVisibility(0);
                TextView textView = BearLayout.this.e;
                BearLayout bearLayout = BearLayout.this;
                if (z) {
                    text = bearLayout.i.getText(R.string.obfuscated_res_0x7f0f0145);
                } else {
                    text = bearLayout.i.getText(R.string.obfuscated_res_0x7f0f0190);
                }
                textView.setText(text);
                TextView textView2 = BearLayout.this.e;
                if (z) {
                    i = -16777216;
                } else {
                    i = -1;
                }
                textView2.setTextColor(i);
                FrameLayout frameLayout = BearLayout.this.d;
                if (z) {
                    i2 = R.drawable.obfuscated_res_0x7f080148;
                } else {
                    i2 = R.drawable.obfuscated_res_0x7f080149;
                }
                frameLayout.setBackgroundResource(i2);
            }
        }

        @Override // com.baidu.swan.apps.view.BearLayout.d
        public void b(String str) {
            if (BearLayout.j) {
                Log.d("BearLayout", str);
            }
            if (BearLayout.this.f != null && BearLayout.this.e != null) {
                BearLayout.this.f.clearAnimation();
                BearLayout.this.f.setVisibility(4);
                BearLayout.this.e.setVisibility(0);
            }
        }
    }

    public d getCallback() {
        return this.h;
    }

    public BearLayout(Context context) {
        super(context);
        this.g = false;
    }

    public BearLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = false;
    }

    private void setVipLogo(String str) {
        if (this.c == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.c.setVisibility(8);
            return;
        }
        int i = R.drawable.obfuscated_res_0x7f08017e;
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 1567) {
            switch (hashCode) {
                case 49:
                    if (str.equals("1")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 50:
                    if (str.equals("2")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 51:
                    if (str.equals("3")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
        } else if (str.equals("10")) {
            c2 = 3;
        }
        if (c2 != 1) {
            if (c2 != 2) {
                if (c2 == 3) {
                    i = R.drawable.obfuscated_res_0x7f08017c;
                }
            } else {
                i = R.drawable.obfuscated_res_0x7f08017f;
            }
        } else {
            i = R.drawable.obfuscated_res_0x7f08017d;
        }
        this.c.setVisibility(0);
        this.c.setImageDrawable(this.i.getResources().getDrawable(i));
    }

    @SuppressLint({"BDOfflineUrl"})
    public final void j(String str) {
        String str2;
        try {
            str2 = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            if (j) {
                e.printStackTrace();
            }
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        SchemeRouter.invoke(getContext(), "baiduboxapp://v1/easybrowse/open?url=" + str + "&newbrowser=1&forbidautorotate=1");
    }

    public void k(@NonNull Context context, @NonNull SwanAppBearInfo swanAppBearInfo, dl3 dl3Var) {
        this.i = context;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d009f, this);
        linearLayout.setOnClickListener(new a(swanAppBearInfo));
        TextView textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0903e4);
        this.a = textView;
        textView.setText(swanAppBearInfo.bearName);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0903e3);
        this.b = simpleDraweeView;
        simpleDraweeView.setImageURI(swanAppBearInfo.bearLogo);
        this.c = (BdBaseImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0903e5);
        setVipLogo(swanAppBearInfo.bearVipType);
        this.d = (FrameLayout) linearLayout.findViewById(R.id.obfuscated_res_0x7f0903de);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0903df);
        this.e = textView2;
        textView2.setOnClickListener(new b(dl3Var, swanAppBearInfo));
        BdBaseImageView bdBaseImageView = (BdBaseImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0903e2);
        this.f = bdBaseImageView;
        bdBaseImageView.setVisibility(8);
        this.h = new c();
    }

    public final void l() {
        TextView textView;
        if (this.f != null && (textView = this.e) != null) {
            textView.setVisibility(4);
            this.f.setVisibility(0);
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setRepeatCount(-1);
            rotateAnimation.setDuration(1000L);
            rotateAnimation.setFillAfter(true);
            rotateAnimation.setInterpolator(new LinearInterpolator());
            this.f.startAnimation(rotateAnimation);
        }
    }
}

package com.baidu.sapi2.views.logindialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.baidu.pass.view.CommonDialog;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.dto.WebRegDTO;
import com.baidu.sapi2.enums.LoginTypes;
import com.baidu.sapi2.result.GetDynamicPwdResult;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ToastUtil;
import com.baidu.sapi2.views.logindialog.bean.QuickLoginResult;
import com.baidu.sapi2.views.logindialog.callback.QuickLoginDialogCallback;
import com.baidu.sapi2.views.logindialog.enums.ColorType;
import com.baidu.sapi2.views.logindialog.enums.QuickLoginType;
import com.baidu.sapi2.views.logindialog.interf.IPagerLoadCallback;
import com.baidu.sapi2.views.logindialog.interf.IQuickLoginDialogCallback;
import com.baidu.sapi2.views.logindialog.interf.ISendSmsCallback;
import com.baidu.sapi2.views.logindialog.page.LoginPager;
import com.baidu.sapi2.views.logindialog.page.SmsPager;
import com.baidu.sapi2.views.logindialog.utils.ViewUtils;
import com.baidu.sapi2.views.logindialog.view.LoadingView;
import com.baidu.sapi2.views.logindialog.view.NoScrollViewPager;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class QuickLoginDialog extends Dialog implements View.OnClickListener, IPagerLoadCallback, ISendSmsCallback, IQuickLoginDialogCallback {
    public static final int HEIGHT_HISTORY = 256;
    public static final int HEIGHT_ONEKEY = 238;
    public static final int HEIGHT_SHARE = 256;
    public static final int HEIGHT_SMS = 181;
    public static final int HEIGHT_VERITFY_CODE = 181;
    public static final String STAG = "QuickLoginDialog";
    public Context a;
    public ColorType b;
    public LinearLayout c;
    public ImageView d;
    public TextView e;
    public ImageView f;
    public NoScrollViewPager g;
    public LoadingView h;
    public LoginPager i;
    public SmsPager j;
    public List<Integer> k;
    public com.baidu.sapi2.views.logindialog.a.a l;
    public int m;
    public IQuickLoginDialogCallback n;

    @Override // com.baidu.sapi2.views.logindialog.interf.IQuickLoginDialogCallback
    public void onDismiss() {
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.IQuickLoginDialogCallback
    public void onPreShowDialog(ColorType colorType, LinearLayout linearLayout, TextView textView) {
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.IQuickLoginDialogCallback
    public void onPreShowLoading(ColorType colorType, LoadingView loadingView) {
    }

    @Override // android.app.Dialog
    @Deprecated
    public void setOnCancelListener(@Nullable DialogInterface.OnCancelListener onCancelListener) {
    }

    @Override // android.app.Dialog
    @Deprecated
    public void setOnDismissListener(@Nullable DialogInterface.OnDismissListener onDismissListener) {
    }

    /* loaded from: classes3.dex */
    public static class Builder implements NoProguard {
        public final Activity a;
        public ColorType b = ColorType.LIGHT;
        public QuickLoginDialogCallback c;

        public Builder(@NonNull Activity activity) {
            this.a = activity;
        }

        public Builder setColorType(ColorType colorType) {
            this.b = colorType;
            return this;
        }

        public Builder setDialogCallback(QuickLoginDialogCallback quickLoginDialogCallback) {
            this.c = quickLoginDialogCallback;
            return this;
        }

        public QuickLoginDialog build() {
            return new QuickLoginDialog(this);
        }
    }

    /* loaded from: classes3.dex */
    public class a implements DialogInterface.OnDismissListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            com.baidu.sapi2.views.logindialog.utils.a.c();
            if (QuickLoginDialog.this.n != null) {
                QuickLoginDialog.this.n.onDismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ViewPager.OnPageChangeListener {
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == 0) {
                QuickLoginDialog.this.d.setVisibility(8);
                QuickLoginDialog.this.e.setText("登录你的百度，精彩永相随");
                if (QuickLoginDialog.this.n != null) {
                    QuickLoginDialog.this.n.onPreShowDialog(QuickLoginDialog.this.b, QuickLoginDialog.this.c, QuickLoginDialog.this.e);
                }
            } else {
                QuickLoginDialog.this.d.setVisibility(0);
                QuickLoginDialog.this.e.setText("请输入短信验证码");
            }
            ViewGroup.LayoutParams layoutParams = QuickLoginDialog.this.g.getLayoutParams();
            layoutParams.height = ((Integer) QuickLoginDialog.this.k.get(i)).intValue();
            QuickLoginDialog.this.g.setLayoutParams(layoutParams);
            QuickLoginDialog.this.m = i;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public final /* synthetic */ String a;

        public c(String str) {
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            QuickLoginDialog.this.openRegister(this.a);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
        }

        public d() {
        }
    }

    /* loaded from: classes3.dex */
    public class e extends WebAuthListener {
        public e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            ToastUtil.show("登录失败：" + webAuthResult.getResultMsg());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            if (QuickLoginDialog.this.n != null) {
                QuickLoginResult quickLoginResult = new QuickLoginResult();
                quickLoginResult.setResultCode(webAuthResult.getResultCode());
                quickLoginResult.setResultMsg(webAuthResult.getResultMsg());
                quickLoginResult.mLoginType = QuickLoginType.FULL_SCREEN;
                QuickLoginDialog.this.n.onLoginSuccess(quickLoginResult);
            }
            QuickLoginDialog.this.cancel();
        }
    }

    /* loaded from: classes3.dex */
    public class f extends WebAuthListener {
        public f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            ToastUtil.show("注册失败：" + webAuthResult.getResultMsg());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            if (QuickLoginDialog.this.n != null) {
                QuickLoginResult quickLoginResult = new QuickLoginResult();
                quickLoginResult.setResultCode(webAuthResult.getResultCode());
                quickLoginResult.setResultMsg(webAuthResult.getResultMsg());
                quickLoginResult.mLoginType = QuickLoginType.REGISTER;
                QuickLoginDialog.this.n.onLoginSuccess(quickLoginResult);
            }
            QuickLoginDialog.this.cancel();
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class g {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[QuickLoginType.values().length];
            a = iArr;
            try {
                iArr[QuickLoginType.HISTORY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[QuickLoginType.SHARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[QuickLoginType.ONEKEY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public QuickLoginDialog(@NonNull Context context, int i, @NonNull Builder builder) {
        super(context, i);
        this.k = new ArrayList();
        this.a = context;
        this.b = builder.b;
        this.n = builder.c;
        b();
        super.setOnDismissListener(new a());
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.IQuickLoginDialogCallback
    public void onPreShowAgreementWithOperator(TextView textView, String str, SpannableStringBuilder spannableStringBuilder) {
        IQuickLoginDialogCallback iQuickLoginDialogCallback = this.n;
        if (iQuickLoginDialogCallback != null) {
            iQuickLoginDialogCallback.onPreShowAgreementWithOperator(textView, str, spannableStringBuilder);
        }
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.IQuickLoginDialogCallback
    public void onPreShowLogin(ColorType colorType, QuickLoginType quickLoginType, TextView textView) {
        IQuickLoginDialogCallback iQuickLoginDialogCallback = this.n;
        if (iQuickLoginDialogCallback != null) {
            iQuickLoginDialogCallback.onPreShowLogin(colorType, quickLoginType, textView);
        }
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.ISendSmsCallback
    public void onSendSmsSuccess(boolean z, String str, GetDynamicPwdResult getDynamicPwdResult) {
        int i = this.m;
        if (i == 0) {
            this.i.hideSendMsgErrorTip();
        } else if (i == 1) {
            this.j.b();
        }
        onChange2SmsPage(str, getDynamicPwdResult.smsCodeLength);
    }

    public QuickLoginDialog(@NonNull Context context, @NonNull Builder builder) {
        this(context, R.style.obfuscated_res_0x7f10040f, builder);
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.IPagerLoadCallback
    public void onChange2SmsPage(String str, int i) {
        this.j.a(str, i);
        this.j.c();
        this.g.setCurrentItem(1);
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.IQuickLoginDialogCallback
    public void onPreShowAgreement(TextView textView, SpannableStringBuilder spannableStringBuilder) {
        IQuickLoginDialogCallback iQuickLoginDialogCallback = this.n;
        if (iQuickLoginDialogCallback != null) {
            iQuickLoginDialogCallback.onPreShowAgreement(textView, spannableStringBuilder);
        }
    }

    public QuickLoginDialog(@NonNull Builder builder) {
        this(builder.a, builder);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2.getId() == R.id.sapi_sdk_close_view) {
            com.baidu.sapi2.views.logindialog.utils.a.a("close");
            cancel();
        } else if (view2.getId() == R.id.sapi_sdk_back_view) {
            com.baidu.sapi2.views.logindialog.utils.a.a("back");
            onChange2LoginPage();
        }
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.IPagerLoadCallback
    public void onPageShow(int i) {
        int dp2px = ViewUtils.dp2px(this.a, i);
        if (this.k.isEmpty()) {
            a(i);
        } else {
            this.k.set(0, Integer.valueOf(dp2px));
        }
        ViewGroup.LayoutParams layoutParams = this.g.getLayoutParams();
        layoutParams.height = dp2px;
        this.g.setLayoutParams(layoutParams);
        this.h.setVisibility(8);
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (a(getContext(), motionEvent) && motionEvent.getAction() == 1) {
            com.baidu.sapi2.views.logindialog.utils.a.a("cancel");
        }
        return super.onTouchEvent(motionEvent);
    }

    public void openRegister(String str) {
        WebRegDTO webRegDTO = new WebRegDTO();
        webRegDTO.regType = WebRegDTO.EXTRA_REGISTER_MOBILE;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("loginUserName", str));
        webRegDTO.extraParams.addAll(arrayList);
        CoreViewRouter.getInstance().startRegister(new f(), webRegDTO);
    }

    private void a() {
        if (ColorType.DARK == this.b) {
            this.c.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.pass_quick_login_dialog_bg_dark));
            this.e.setTextColor(Color.parseColor("#FFFFFF"));
            this.h.a();
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        try {
            super.cancel();
        } catch (Exception e2) {
            Log.e(e2.getMessage(), new Object[0]);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e2) {
            Log.e(e2.getMessage(), new Object[0]);
        }
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.IPagerLoadCallback
    public void onChange2LoginPage() {
        this.j.a();
        this.g.setCurrentItem(0);
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.IPagerLoadCallback
    public void onPageLoading() {
        IQuickLoginDialogCallback iQuickLoginDialogCallback = this.n;
        if (iQuickLoginDialogCallback != null) {
            iQuickLoginDialogCallback.onPreShowLoading(this.b, this.h);
        }
        this.h.setVisibility(0);
    }

    @Override // android.app.Dialog
    public void show() {
        if (Build.VERSION.SDK_INT >= 17) {
            Context context = this.a;
            if ((context instanceof Activity) && ((Activity) context).isDestroyed()) {
                return;
            }
        }
        try {
            super.show();
        } catch (Exception e2) {
            Log.e(e2.getMessage(), new Object[0]);
        }
    }

    private void a(int i) {
        this.k.add(0, Integer.valueOf(ViewUtils.dp2px(this.a, i)));
        this.k.add(1, Integer.valueOf(ViewUtils.dp2px(this.a, 181.0f)));
    }

    private void a(String str) {
        boolean z;
        CommonDialog.Builder message = new CommonDialog.Builder(this.a).setTitle("提示").setMessage("您的手机号还未注册，点击完成注册");
        if (ColorType.DARK == this.b) {
            z = true;
        } else {
            z = false;
        }
        message.setDarkMode(z).setNegativeButton("取消", new d()).setPositiveBtn("去注册", new c(str)).build().show();
    }

    private boolean a(Context context, MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int scaledWindowTouchSlop = ViewConfiguration.get(context).getScaledWindowTouchSlop();
        View decorView = getWindow().getDecorView();
        int i = -scaledWindowTouchSlop;
        if (x >= i && y >= i && x <= decorView.getWidth() + scaledWindowTouchSlop && y <= decorView.getHeight() + scaledWindowTouchSlop) {
            return false;
        }
        return true;
    }

    private void b() {
        setContentView(R.layout.layout_sapi_dialog_quick_login);
        Window window = getWindow();
        window.setGravity(83);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        this.c = (LinearLayout) findViewById(R.id.sapi_sdk_ll_dialog_content);
        this.d = (ImageView) findViewById(R.id.sapi_sdk_back_view);
        this.e = (TextView) findViewById(R.id.sapi_sdk_tv_title_view);
        this.f = (ImageView) findViewById(R.id.sapi_sdk_close_view);
        this.h = (LoadingView) findViewById(R.id.sapi_sdk_login_dialog_loadingview);
        this.g = (NoScrollViewPager) findViewById(R.id.sapi_sdk_login_dialog_viewpager);
        this.d.setOnClickListener(this);
        this.f.setOnClickListener(this);
        c();
        if (this.k.isEmpty()) {
            a(181);
        }
        a();
        IQuickLoginDialogCallback iQuickLoginDialogCallback = this.n;
        if (iQuickLoginDialogCallback != null) {
            iQuickLoginDialogCallback.onPreShowDialog(this.b, this.c, this.e);
        }
    }

    private void c() {
        this.g.setScanScroll(false);
        ArrayList arrayList = new ArrayList();
        LoginPager loginPager = new LoginPager(this.a, this.b, this, this, this);
        this.i = loginPager;
        arrayList.add(loginPager);
        SmsPager smsPager = new SmsPager(this.a, this.b, this, this, this);
        this.j = smsPager;
        arrayList.add(smsPager);
        com.baidu.sapi2.views.logindialog.a.a aVar = new com.baidu.sapi2.views.logindialog.a.a(arrayList);
        this.l = aVar;
        this.g.setAdapter(aVar);
        this.g.addOnPageChangeListener(new b());
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.IQuickLoginDialogCallback
    public void onLoginFailure(QuickLoginResult quickLoginResult) {
        Log.e(STAG, "login result code : " + quickLoginResult.getResultCode() + ", result msg : " + quickLoginResult.getResultMsg());
        ToastUtil.show(quickLoginResult.getResultMsg());
        this.h.setVisibility(8);
        IQuickLoginDialogCallback iQuickLoginDialogCallback = this.n;
        if (iQuickLoginDialogCallback != null) {
            iQuickLoginDialogCallback.onLoginFailure(quickLoginResult);
        }
        this.h.setVisibility(8);
        QuickLoginType quickLoginType = quickLoginResult.mLoginType;
        if (quickLoginType == QuickLoginType.HISTORY || quickLoginType == QuickLoginType.SHARE || quickLoginType == QuickLoginType.ONEKEY) {
            openScreenLogin(quickLoginResult.mLoginType, "");
        }
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.IQuickLoginDialogCallback
    public void onLoginSuccess(QuickLoginResult quickLoginResult) {
        if (TextUtils.isEmpty(quickLoginResult.mOperator)) {
            com.baidu.sapi2.views.logindialog.utils.a.a("0", quickLoginResult.mLoginType);
        } else {
            com.baidu.sapi2.views.logindialog.utils.a.a("0", quickLoginResult.mLoginType.getValue() + "_" + quickLoginResult.mOperator.toLowerCase());
        }
        IQuickLoginDialogCallback iQuickLoginDialogCallback = this.n;
        if (iQuickLoginDialogCallback != null) {
            iQuickLoginDialogCallback.onLoginSuccess(quickLoginResult);
        }
        this.h.setVisibility(8);
        Log.e(STAG, "login result code : " + quickLoginResult.getResultCode() + ", result msg : " + quickLoginResult.getResultMsg());
        cancel();
    }

    @Override // com.baidu.sapi2.views.logindialog.interf.ISendSmsCallback
    public void onSendSmsFailure(String str, GetDynamicPwdResult getDynamicPwdResult) {
        int resultCode = getDynamicPwdResult.getResultCode();
        if (resultCode != 4) {
            if (resultCode != 5) {
                if (resultCode != 12) {
                    ToastUtil.show("发送短信失败：" + getDynamicPwdResult.getResultMsg());
                    openScreenLogin(null, str);
                    return;
                }
                a(str);
                return;
            }
            openScreenLogin(null, str);
            return;
        }
        int i = this.m;
        if (i == 0) {
            this.i.showSendMsgErrorTip(getDynamicPwdResult.getResultMsg());
        } else if (i == 1) {
            this.j.c(getDynamicPwdResult.getResultMsg());
        }
    }

    public void openScreenLogin(QuickLoginType quickLoginType, String str) {
        WebLoginDTO webLoginDTO = new WebLoginDTO();
        webLoginDTO.config = null;
        if (quickLoginType != null) {
            int i = g.a[quickLoginType.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        webLoginDTO.excludeTypes = LoginTypes.ONE_KEY_LOGIN;
                    }
                } else {
                    webLoginDTO.excludeTypes = LoginTypes.SHARE;
                }
            } else {
                webLoginDTO.excludeTypes = LoginTypes.HISTORY;
            }
        }
        if (!TextUtils.isEmpty(str)) {
            webLoginDTO.preSetUname = str;
        }
        CoreViewRouter.getInstance().startLogin(new e(), webLoginDTO);
    }
}

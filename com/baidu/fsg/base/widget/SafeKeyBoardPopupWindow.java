package com.baidu.fsg.base.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import com.baidu.fsg.base.utils.ResUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Random;
/* loaded from: classes2.dex */
public class SafeKeyBoardPopupWindow extends PopupWindow implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public Button f5664a;

    /* renamed from: b  reason: collision with root package name */
    public Button f5665b;

    /* renamed from: c  reason: collision with root package name */
    public Button f5666c;
    public View contentView;

    /* renamed from: d  reason: collision with root package name */
    public Button f5667d;

    /* renamed from: e  reason: collision with root package name */
    public Button f5668e;

    /* renamed from: f  reason: collision with root package name */
    public Button f5669f;

    /* renamed from: g  reason: collision with root package name */
    public Button f5670g;

    /* renamed from: h  reason: collision with root package name */
    public Button f5671h;

    /* renamed from: i  reason: collision with root package name */
    public Button f5672i;
    public Button j;
    public ImageButton k;
    public a l;
    public boolean m;
    public Button mButtonX;
    public Context mContext;
    public SafeScrollView mSafeScrollView;
    public SafeKeyBoardEditText mySafeEditText;

    /* loaded from: classes2.dex */
    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<SafeKeyBoardPopupWindow> f5673a;

        public a(SafeKeyBoardPopupWindow safeKeyBoardPopupWindow) {
            this.f5673a = new WeakReference<>(safeKeyBoardPopupWindow);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.f5673a.get();
            if (safeKeyBoardPopupWindow == null) {
                return;
            }
            if (!TextUtils.isEmpty(safeKeyBoardPopupWindow.mySafeEditText.getText())) {
                int selectionStart = safeKeyBoardPopupWindow.mySafeEditText.getSelectionStart();
                int selectionEnd = safeKeyBoardPopupWindow.mySafeEditText.getSelectionEnd();
                Editable text = safeKeyBoardPopupWindow.mySafeEditText.getText();
                if (selectionStart >= 0) {
                    if (selectionStart < selectionEnd) {
                        text.replace(selectionStart, selectionEnd, "", 0, 0);
                    } else if (selectionStart != selectionEnd) {
                        text.replace(selectionEnd, selectionStart, "", 0, 0);
                    } else if (selectionStart > 0) {
                        text.replace(selectionStart - 1, selectionStart, "", 0, 0);
                    }
                    removeCallbacksAndMessages(null);
                    sendEmptyMessageDelayed(1, 200L);
                    return;
                }
                return;
            }
            removeCallbacksAndMessages(null);
        }
    }

    public SafeKeyBoardPopupWindow(Context context) {
        super(context);
        this.mContext = context;
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.l == null) {
            this.l = new a(this);
        }
        this.l.sendEmptyMessage(1);
    }

    public int getLayoutId() {
        return ResUtils.layout(this.mContext, this.m ? "rim_base_safekeyboard_popupwindow_mini" : "rim_base_safekeyboard_popupwindow");
    }

    public int getPopupWindowHeight() {
        return this.contentView.getHeight();
    }

    public void initKeyNum(boolean z) {
        int[] a2 = a(z);
        Button button = this.j;
        button.setText("" + a2[0]);
        this.j.setTag(Integer.valueOf(a2[0]));
        Button button2 = this.f5664a;
        button2.setText("" + a2[1]);
        this.f5664a.setTag(Integer.valueOf(a2[1]));
        Button button3 = this.f5665b;
        button3.setText("" + a2[2]);
        this.f5665b.setTag(Integer.valueOf(a2[2]));
        Button button4 = this.f5666c;
        button4.setText("" + a2[3]);
        this.f5666c.setTag(Integer.valueOf(a2[3]));
        Button button5 = this.f5667d;
        button5.setText("" + a2[4]);
        this.f5667d.setTag(Integer.valueOf(a2[4]));
        Button button6 = this.f5668e;
        button6.setText("" + a2[5]);
        this.f5668e.setTag(Integer.valueOf(a2[5]));
        Button button7 = this.f5669f;
        button7.setText("" + a2[6]);
        this.f5669f.setTag(Integer.valueOf(a2[6]));
        Button button8 = this.f5670g;
        button8.setText("" + a2[7]);
        this.f5670g.setTag(Integer.valueOf(a2[7]));
        Button button9 = this.f5671h;
        button9.setText("" + a2[8]);
        this.f5671h.setTag(Integer.valueOf(a2[8]));
        Button button10 = this.f5672i;
        button10.setText("" + a2[9]);
        this.f5672i.setTag(Integer.valueOf(a2[9]));
        if (this.mySafeEditText.getUseKeyX()) {
            this.mButtonX.setEnabled(true);
            this.mButtonX.setBackgroundResource(ResUtils.drawable(this.mContext, "rim_base_safekeyboard_numkey_selector"));
            this.mButtonX.setText("X");
            this.mButtonX.setTag("X");
        } else if (this.mySafeEditText.getUseKeyDot()) {
            this.mButtonX.setEnabled(true);
            this.mButtonX.setBackgroundResource(ResUtils.drawable(this.mContext, "rim_base_safekeyboard_numkey_selector"));
            this.mButtonX.setText(".");
            this.mButtonX.setTag(".");
        } else {
            this.mButtonX.setEnabled(false);
            this.mButtonX.setText("");
            this.mButtonX.setBackgroundResource(ResUtils.drawable(this.mContext, "rim_base_safekeyboard_delkey_selector"));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == ResUtils.id(this.mContext, "btn_del")) {
            if (TextUtils.isEmpty(this.mySafeEditText.getText())) {
                return;
            }
            new Handler().post(new h(this));
            return;
        }
        new Handler().post(new i(this, view));
    }

    public void setSafeEditTet(SafeKeyBoardEditText safeKeyBoardEditText) {
        this.mySafeEditText = safeKeyBoardEditText;
    }

    public void setScrollView(SafeScrollView safeScrollView) {
        this.mSafeScrollView = safeScrollView;
    }

    @Override // android.widget.PopupWindow
    public void update() {
        SafeKeyBoardEditText safeKeyBoardEditText;
        super.update();
        if (!isShowing() || (safeKeyBoardEditText = this.mySafeEditText) == null) {
            return;
        }
        safeKeyBoardEditText.isShowLogoLockAnim();
    }

    @TargetApi(24)
    private boolean a() {
        Context context;
        if (Build.VERSION.SDK_INT < 24 || (context = this.mContext) == null) {
            return false;
        }
        return ((Activity) context).isInMultiWindowMode();
    }

    private void b() {
        this.m = a();
        View inflate = LayoutInflater.from(this.mContext).inflate(getLayoutId(), (ViewGroup) null);
        this.contentView = inflate;
        setContentView(inflate);
        setHeight(-2);
        setWidth(-1);
        setBackgroundDrawable(new BitmapDrawable());
        setAnimationStyle(ResUtils.style(this.mContext, "rim_base_safekeyboard_popwindown_anim"));
        this.j = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn0"));
        this.f5664a = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn1"));
        this.f5665b = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn2"));
        this.f5666c = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn3"));
        this.f5667d = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn4"));
        this.f5668e = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn5"));
        this.f5669f = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn6"));
        this.f5670g = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn7"));
        this.f5671h = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn8"));
        this.f5672i = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn9"));
        this.mButtonX = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn_x"));
        this.k = (ImageButton) this.contentView.findViewById(ResUtils.id(this.mContext, "btn_del"));
        this.j.setOnClickListener(this);
        this.f5664a.setOnClickListener(this);
        this.f5665b.setOnClickListener(this);
        this.f5666c.setOnClickListener(this);
        this.f5667d.setOnClickListener(this);
        this.f5668e.setOnClickListener(this);
        this.f5669f.setOnClickListener(this);
        this.f5670g.setOnClickListener(this);
        this.f5671h.setOnClickListener(this);
        this.f5672i.setOnClickListener(this);
        this.mButtonX.setOnClickListener(this);
        this.k.setOnFocusChangeListener(new f(this));
        this.k.setOnTouchListener(new g(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.l == null) {
            this.l = new a(this);
        }
        this.l.removeCallbacksAndMessages(null);
    }

    private int[] a(boolean z) {
        int i2;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (true) {
            if (i3 >= 10) {
                break;
            }
            arrayList.add(Integer.valueOf(i3));
            i3++;
        }
        int[] iArr = new int[10];
        if (z) {
            Random random = new Random();
            for (i2 = 10; i2 > 0; i2--) {
                int nextInt = random.nextInt(i2);
                iArr[10 - i2] = ((Integer) arrayList.get(nextInt)).intValue();
                arrayList.remove(nextInt);
            }
        } else {
            for (int i4 = 0; i4 < 10; i4++) {
                iArr[i4] = ((Integer) arrayList.get(i4)).intValue();
            }
        }
        return iArr;
    }
}

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
/* loaded from: classes16.dex */
public class SafeKeyBoardPopupWindow extends PopupWindow implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Button f1543a;
    private Button b;
    private Button c;
    protected View contentView;
    private Button d;
    private Button e;
    private Button f;
    private Button g;
    private Button h;
    private Button i;
    private Button j;
    private ImageButton k;
    private a l;
    private boolean m;
    protected Button mButtonX;
    protected Context mContext;
    protected SafeScrollView mSafeScrollView;
    protected SafeKeyBoardEditText mySafeEditText;

    public SafeKeyBoardPopupWindow(Context context) {
        super(context);
        this.mContext = context;
        b();
    }

    public void setSafeEditTet(SafeKeyBoardEditText safeKeyBoardEditText) {
        this.mySafeEditText = safeKeyBoardEditText;
    }

    public void setScrollView(SafeScrollView safeScrollView) {
        this.mSafeScrollView = safeScrollView;
    }

    @TargetApi(24)
    private boolean a() {
        if (Build.VERSION.SDK_INT < 24 || this.mContext == null) {
            return false;
        }
        return ((Activity) this.mContext).isInMultiWindowMode();
    }

    private void b() {
        this.m = a();
        this.contentView = LayoutInflater.from(this.mContext).inflate(getLayoutId(), (ViewGroup) null);
        setContentView(this.contentView);
        setHeight(-2);
        setWidth(-1);
        setBackgroundDrawable(new BitmapDrawable());
        setAnimationStyle(ResUtils.style(this.mContext, "rim_base_safekeyboard_popwindown_anim"));
        this.j = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn0"));
        this.f1543a = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn1"));
        this.b = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn2"));
        this.c = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn3"));
        this.d = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn4"));
        this.e = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn5"));
        this.f = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn6"));
        this.g = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn7"));
        this.h = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn8"));
        this.i = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn9"));
        this.mButtonX = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn_x"));
        this.k = (ImageButton) this.contentView.findViewById(ResUtils.id(this.mContext, "btn_del"));
        this.j.setOnClickListener(this);
        this.f1543a.setOnClickListener(this);
        this.b.setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.i.setOnClickListener(this);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.l == null) {
            this.l = new a(this);
        }
        this.l.sendEmptyMessage(1);
    }

    public void initKeyNum(boolean z) {
        int[] a2 = a(z);
        this.j.setText("" + a2[0]);
        this.j.setTag(Integer.valueOf(a2[0]));
        this.f1543a.setText("" + a2[1]);
        this.f1543a.setTag(Integer.valueOf(a2[1]));
        this.b.setText("" + a2[2]);
        this.b.setTag(Integer.valueOf(a2[2]));
        this.c.setText("" + a2[3]);
        this.c.setTag(Integer.valueOf(a2[3]));
        this.d.setText("" + a2[4]);
        this.d.setTag(Integer.valueOf(a2[4]));
        this.e.setText("" + a2[5]);
        this.e.setTag(Integer.valueOf(a2[5]));
        this.f.setText("" + a2[6]);
        this.f.setTag(Integer.valueOf(a2[6]));
        this.g.setText("" + a2[7]);
        this.g.setTag(Integer.valueOf(a2[7]));
        this.h.setText("" + a2[8]);
        this.h.setTag(Integer.valueOf(a2[8]));
        this.i.setText("" + a2[9]);
        this.i.setTag(Integer.valueOf(a2[9]));
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

    private int[] a(boolean z) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            arrayList.add(Integer.valueOf(i));
        }
        int[] iArr = new int[10];
        if (z) {
            Random random = new Random();
            for (int i2 = 10; i2 > 0; i2--) {
                int nextInt = random.nextInt(i2);
                iArr[10 - i2] = ((Integer) arrayList.get(nextInt)).intValue();
                arrayList.remove(nextInt);
            }
        } else {
            for (int i3 = 0; i3 < 10; i3++) {
                iArr[i3] = ((Integer) arrayList.get(i3)).intValue();
            }
        }
        return iArr;
    }

    public int getPopupWindowHeight() {
        return this.contentView.getHeight();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == ResUtils.id(this.mContext, "btn_del")) {
            if (!TextUtils.isEmpty(this.mySafeEditText.getText())) {
                new Handler().post(new h(this));
                return;
            }
            return;
        }
        new Handler().post(new i(this, view));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        WeakReference<SafeKeyBoardPopupWindow> f1544a;

        public a(SafeKeyBoardPopupWindow safeKeyBoardPopupWindow) {
            this.f1544a = new WeakReference<>(safeKeyBoardPopupWindow);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.f1544a.get();
            if (safeKeyBoardPopupWindow != null) {
                if (!TextUtils.isEmpty(safeKeyBoardPopupWindow.mySafeEditText.getText())) {
                    int selectionStart = safeKeyBoardPopupWindow.mySafeEditText.getSelectionStart();
                    int selectionEnd = safeKeyBoardPopupWindow.mySafeEditText.getSelectionEnd();
                    Editable text = safeKeyBoardPopupWindow.mySafeEditText.getText();
                    if (selectionStart >= 0) {
                        if (selectionStart < selectionEnd) {
                            text.replace(selectionStart, selectionEnd, "", 0, 0);
                        } else if (selectionStart == selectionEnd) {
                            if (selectionStart > 0) {
                                text.replace(selectionStart - 1, selectionStart, "", 0, 0);
                            }
                        } else {
                            text.replace(selectionEnd, selectionStart, "", 0, 0);
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
    }

    protected int getLayoutId() {
        return ResUtils.layout(this.mContext, this.m ? "rim_base_safekeyboard_popupwindow_mini" : "rim_base_safekeyboard_popupwindow");
    }

    @Override // android.widget.PopupWindow
    public void update() {
        super.update();
        if (!isShowing() || this.mySafeEditText == null || this.mySafeEditText.isShowLogoLockAnim()) {
        }
    }
}

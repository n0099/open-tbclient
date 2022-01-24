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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Random;
/* loaded from: classes10.dex */
public class SafeKeyBoardPopupWindow extends PopupWindow implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Button a;

    /* renamed from: b  reason: collision with root package name */
    public Button f33973b;

    /* renamed from: c  reason: collision with root package name */
    public Button f33974c;
    public View contentView;

    /* renamed from: d  reason: collision with root package name */
    public Button f33975d;

    /* renamed from: e  reason: collision with root package name */
    public Button f33976e;

    /* renamed from: f  reason: collision with root package name */
    public Button f33977f;

    /* renamed from: g  reason: collision with root package name */
    public Button f33978g;

    /* renamed from: h  reason: collision with root package name */
    public Button f33979h;

    /* renamed from: i  reason: collision with root package name */
    public Button f33980i;

    /* renamed from: j  reason: collision with root package name */
    public Button f33981j;
    public ImageButton k;
    public a l;
    public boolean m;
    public Button mButtonX;
    public Context mContext;
    public SafeScrollView mSafeScrollView;
    public SafeKeyBoardEditText mySafeEditText;

    /* loaded from: classes10.dex */
    public static class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<SafeKeyBoardPopupWindow> a;

        public a(SafeKeyBoardPopupWindow safeKeyBoardPopupWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {safeKeyBoardPopupWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(safeKeyBoardPopupWindow);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2;
            int i3;
            String str;
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.a.get();
                if (safeKeyBoardPopupWindow == null) {
                    return;
                }
                if (TextUtils.isEmpty(safeKeyBoardPopupWindow.mySafeEditText.getText())) {
                    removeCallbacksAndMessages(null);
                    return;
                }
                int selectionStart = safeKeyBoardPopupWindow.mySafeEditText.getSelectionStart();
                int selectionEnd = safeKeyBoardPopupWindow.mySafeEditText.getSelectionEnd();
                Editable text = safeKeyBoardPopupWindow.mySafeEditText.getText();
                if (selectionStart >= 0) {
                    if (selectionStart < selectionEnd) {
                        i2 = 0;
                        i3 = 0;
                        str = "";
                        i4 = selectionStart;
                        selectionStart = selectionEnd;
                    } else if (selectionStart == selectionEnd) {
                        if (selectionStart > 0) {
                            i4 = selectionStart - 1;
                            i2 = 0;
                            i3 = 0;
                            str = "";
                        }
                        removeCallbacksAndMessages(null);
                        sendEmptyMessageDelayed(1, 200L);
                    } else {
                        i2 = 0;
                        i3 = 0;
                        str = "";
                        i4 = selectionEnd;
                    }
                    text.replace(i4, selectionStart, str, i2, i3);
                    removeCallbacksAndMessages(null);
                    sendEmptyMessageDelayed(1, 200L);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SafeKeyBoardPopupWindow(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            if (this.l == null) {
                this.l = new a(this);
            }
            this.l.removeCallbacksAndMessages(null);
        }
    }

    private int[] a(boolean z) {
        InterceptResult invokeZ;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65539, this, z)) == null) {
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
        return (int[]) invokeZ.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            if (this.l == null) {
                this.l = new a(this);
            }
            this.l.sendEmptyMessage(1);
        }
    }

    @TargetApi(24)
    private boolean c() {
        InterceptResult invokeV;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            if (Build.VERSION.SDK_INT < 24 || (context = this.mContext) == null) {
                return false;
            }
            return ((Activity) context).isInMultiWindowMode();
        }
        return invokeV.booleanValue;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.m = c();
            View inflate = LayoutInflater.from(this.mContext).inflate(getLayoutId(), (ViewGroup) null);
            this.contentView = inflate;
            setContentView(inflate);
            setHeight(-2);
            setWidth(-1);
            setBackgroundDrawable(new BitmapDrawable());
            setAnimationStyle(ResUtils.style(this.mContext, "rim_base_safekeyboard_popwindown_anim"));
            this.f33981j = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn0"));
            this.a = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn1"));
            this.f33973b = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn2"));
            this.f33974c = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn3"));
            this.f33975d = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn4"));
            this.f33976e = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn5"));
            this.f33977f = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn6"));
            this.f33978g = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn7"));
            this.f33979h = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn8"));
            this.f33980i = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn9"));
            this.mButtonX = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn_x"));
            this.k = (ImageButton) this.contentView.findViewById(ResUtils.id(this.mContext, "btn_del"));
            this.f33981j.setOnClickListener(this);
            this.a.setOnClickListener(this);
            this.f33973b.setOnClickListener(this);
            this.f33974c.setOnClickListener(this);
            this.f33975d.setOnClickListener(this);
            this.f33976e.setOnClickListener(this);
            this.f33977f.setOnClickListener(this);
            this.f33978g.setOnClickListener(this);
            this.f33979h.setOnClickListener(this);
            this.f33980i.setOnClickListener(this);
            this.mButtonX.setOnClickListener(this);
            this.k.setOnFocusChangeListener(new f(this));
            this.k.setOnTouchListener(new g(this));
        }
    }

    public int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return ResUtils.layout(this.mContext, this.m ? "rim_base_safekeyboard_popupwindow_mini" : "rim_base_safekeyboard_popupwindow");
        }
        return invokeV.intValue;
    }

    public int getPopupWindowHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.contentView.getHeight() : invokeV.intValue;
    }

    public void initKeyNum(boolean z) {
        Button button;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            int[] a2 = a(z);
            Button button2 = this.f33981j;
            button2.setText("" + a2[0]);
            this.f33981j.setTag(Integer.valueOf(a2[0]));
            Button button3 = this.a;
            button3.setText("" + a2[1]);
            this.a.setTag(Integer.valueOf(a2[1]));
            Button button4 = this.f33973b;
            button4.setText("" + a2[2]);
            this.f33973b.setTag(Integer.valueOf(a2[2]));
            Button button5 = this.f33974c;
            button5.setText("" + a2[3]);
            this.f33974c.setTag(Integer.valueOf(a2[3]));
            Button button6 = this.f33975d;
            button6.setText("" + a2[4]);
            this.f33975d.setTag(Integer.valueOf(a2[4]));
            Button button7 = this.f33976e;
            button7.setText("" + a2[5]);
            this.f33976e.setTag(Integer.valueOf(a2[5]));
            Button button8 = this.f33977f;
            button8.setText("" + a2[6]);
            this.f33977f.setTag(Integer.valueOf(a2[6]));
            Button button9 = this.f33978g;
            button9.setText("" + a2[7]);
            this.f33978g.setTag(Integer.valueOf(a2[7]));
            Button button10 = this.f33979h;
            button10.setText("" + a2[8]);
            this.f33979h.setTag(Integer.valueOf(a2[8]));
            Button button11 = this.f33980i;
            button11.setText("" + a2[9]);
            this.f33980i.setTag(Integer.valueOf(a2[9]));
            if (this.mySafeEditText.getUseKeyX()) {
                this.mButtonX.setEnabled(true);
                this.mButtonX.setBackgroundResource(ResUtils.drawable(this.mContext, "rim_base_safekeyboard_numkey_selector"));
                button = this.mButtonX;
                str = "X";
            } else if (!this.mySafeEditText.getUseKeyDot()) {
                this.mButtonX.setEnabled(false);
                this.mButtonX.setText("");
                this.mButtonX.setBackgroundResource(ResUtils.drawable(this.mContext, "rim_base_safekeyboard_delkey_selector"));
                return;
            } else {
                this.mButtonX.setEnabled(true);
                this.mButtonX.setBackgroundResource(ResUtils.drawable(this.mContext, "rim_base_safekeyboard_numkey_selector"));
                button = this.mButtonX;
                str = ".";
            }
            button.setText(str);
            this.mButtonX.setTag(str);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (view.getId() != ResUtils.id(this.mContext, "btn_del")) {
                new Handler().post(new i(this, view));
            } else if (TextUtils.isEmpty(this.mySafeEditText.getText())) {
            } else {
                new Handler().post(new h(this));
            }
        }
    }

    public void setSafeEditTet(SafeKeyBoardEditText safeKeyBoardEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, safeKeyBoardEditText) == null) {
            this.mySafeEditText = safeKeyBoardEditText;
        }
    }

    public void setScrollView(SafeScrollView safeScrollView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, safeScrollView) == null) {
            this.mSafeScrollView = safeScrollView;
        }
    }

    @Override // android.widget.PopupWindow
    public void update() {
        SafeKeyBoardEditText safeKeyBoardEditText;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.update();
            if (!isShowing() || (safeKeyBoardEditText = this.mySafeEditText) == null) {
                return;
            }
            safeKeyBoardEditText.isShowLogoLockAnim();
        }
    }
}

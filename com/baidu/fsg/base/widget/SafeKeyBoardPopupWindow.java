package com.baidu.fsg.base.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
/* loaded from: classes5.dex */
public class SafeKeyBoardPopupWindow extends PopupWindow implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Button f39490a;

    /* renamed from: b  reason: collision with root package name */
    public Button f39491b;

    /* renamed from: c  reason: collision with root package name */
    public Button f39492c;
    public View contentView;

    /* renamed from: d  reason: collision with root package name */
    public Button f39493d;

    /* renamed from: e  reason: collision with root package name */
    public Button f39494e;

    /* renamed from: f  reason: collision with root package name */
    public Button f39495f;

    /* renamed from: g  reason: collision with root package name */
    public Button f39496g;

    /* renamed from: h  reason: collision with root package name */
    public Button f39497h;

    /* renamed from: i  reason: collision with root package name */
    public Button f39498i;

    /* renamed from: j  reason: collision with root package name */
    public Button f39499j;
    public ImageButton k;
    public a l;
    public boolean m;
    public Button mButtonX;
    public Context mContext;
    public SafeScrollView mSafeScrollView;
    public SafeKeyBoardEditText mySafeEditText;

    /* loaded from: classes5.dex */
    public static class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<SafeKeyBoardPopupWindow> f39505a;

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
            this.f39505a = new WeakReference<>(safeKeyBoardPopupWindow);
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
                SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.f39505a.get();
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
        b();
    }

    @TargetApi(24)
    private boolean a() {
        InterceptResult invokeV;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (Build.VERSION.SDK_INT < 24 || (context = this.mContext) == null) {
                return false;
            }
            return ((Activity) context).isInMultiWindowMode();
        }
        return invokeV.booleanValue;
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

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.m = a();
            View inflate = LayoutInflater.from(this.mContext).inflate(getLayoutId(), (ViewGroup) null);
            this.contentView = inflate;
            setContentView(inflate);
            setHeight(-2);
            setWidth(-1);
            setBackgroundDrawable(new BitmapDrawable());
            setAnimationStyle(ResUtils.style(this.mContext, "rim_base_safekeyboard_popwindown_anim"));
            this.f39499j = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn0"));
            this.f39490a = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn1"));
            this.f39491b = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn2"));
            this.f39492c = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn3"));
            this.f39493d = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn4"));
            this.f39494e = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn5"));
            this.f39495f = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn6"));
            this.f39496g = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn7"));
            this.f39497h = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn8"));
            this.f39498i = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn9"));
            this.mButtonX = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn_x"));
            this.k = (ImageButton) this.contentView.findViewById(ResUtils.id(this.mContext, "btn_del"));
            this.f39499j.setOnClickListener(this);
            this.f39490a.setOnClickListener(this);
            this.f39491b.setOnClickListener(this);
            this.f39492c.setOnClickListener(this);
            this.f39493d.setOnClickListener(this);
            this.f39494e.setOnClickListener(this);
            this.f39495f.setOnClickListener(this);
            this.f39496g.setOnClickListener(this);
            this.f39497h.setOnClickListener(this);
            this.f39498i.setOnClickListener(this);
            this.mButtonX.setOnClickListener(this);
            this.k.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: com.baidu.fsg.base.widget.SafeKeyBoardPopupWindow.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ SafeKeyBoardPopupWindow f39500a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f39500a = this;
                }

                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View view, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLZ(1048576, this, view, z) == null) {
                    }
                }
            });
            this.k.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.baidu.fsg.base.widget.SafeKeyBoardPopupWindow.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ SafeKeyBoardPopupWindow f39501a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f39501a = this;
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                        if (motionEvent.getAction() == 0) {
                            this.f39501a.d();
                            return false;
                        } else if (motionEvent.getAction() != 1 && (motionEvent.getAction() != 2 || this.f39501a.k.isPressed())) {
                            return false;
                        } else {
                            this.f39501a.c();
                            return false;
                        }
                    }
                    return invokeLL.booleanValue;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            if (this.l == null) {
                this.l = new a(this);
            }
            this.l.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            if (this.l == null) {
                this.l = new a(this);
            }
            this.l.sendEmptyMessage(1);
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
            Button button2 = this.f39499j;
            button2.setText("" + a2[0]);
            this.f39499j.setTag(Integer.valueOf(a2[0]));
            Button button3 = this.f39490a;
            button3.setText("" + a2[1]);
            this.f39490a.setTag(Integer.valueOf(a2[1]));
            Button button4 = this.f39491b;
            button4.setText("" + a2[2]);
            this.f39491b.setTag(Integer.valueOf(a2[2]));
            Button button5 = this.f39492c;
            button5.setText("" + a2[3]);
            this.f39492c.setTag(Integer.valueOf(a2[3]));
            Button button6 = this.f39493d;
            button6.setText("" + a2[4]);
            this.f39493d.setTag(Integer.valueOf(a2[4]));
            Button button7 = this.f39494e;
            button7.setText("" + a2[5]);
            this.f39494e.setTag(Integer.valueOf(a2[5]));
            Button button8 = this.f39495f;
            button8.setText("" + a2[6]);
            this.f39495f.setTag(Integer.valueOf(a2[6]));
            Button button9 = this.f39496g;
            button9.setText("" + a2[7]);
            this.f39496g.setTag(Integer.valueOf(a2[7]));
            Button button10 = this.f39497h;
            button10.setText("" + a2[8]);
            this.f39497h.setTag(Integer.valueOf(a2[8]));
            Button button11 = this.f39498i;
            button11.setText("" + a2[9]);
            this.f39498i.setTag(Integer.valueOf(a2[9]));
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
                new Handler().post(new Runnable(this, view) { // from class: com.baidu.fsg.base.widget.SafeKeyBoardPopupWindow.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ View f39503a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ SafeKeyBoardPopupWindow f39504b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, view};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f39504b = this;
                        this.f39503a = view;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        String obj;
                        int i2;
                        int length;
                        Editable editable;
                        int i3;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            int selectionStart = this.f39504b.mySafeEditText.getSelectionStart();
                            int selectionEnd = this.f39504b.mySafeEditText.getSelectionEnd();
                            Editable text = this.f39504b.mySafeEditText.getText();
                            if (selectionStart >= 0) {
                                if (selectionStart < selectionEnd) {
                                    obj = this.f39503a.getTag().toString();
                                    i2 = 0;
                                    length = this.f39503a.getTag().toString().length();
                                    editable = text;
                                    i3 = selectionStart;
                                    selectionStart = selectionEnd;
                                } else if (selectionStart != selectionEnd) {
                                    text.replace(selectionEnd, selectionStart, this.f39503a.getTag().toString(), 0, this.f39503a.getTag().toString().length());
                                    int selectionEnd2 = this.f39504b.mySafeEditText.getSelectionEnd() + this.f39503a.getTag().toString().length();
                                    if (selectionEnd2 >= 0 && selectionEnd2 <= this.f39504b.mySafeEditText.getText().toString().length()) {
                                        Selection.setSelection(this.f39504b.mySafeEditText.getEditableText(), selectionEnd2);
                                    }
                                    Selection.setSelection(text, text.length());
                                } else {
                                    obj = this.f39503a.getTag().toString();
                                    i2 = 0;
                                    length = this.f39503a.getTag().toString().length();
                                    editable = text;
                                    i3 = selectionStart;
                                }
                                editable.replace(i3, selectionStart, obj, i2, length);
                                Selection.setSelection(text, text.length());
                            }
                        }
                    }
                });
            } else if (TextUtils.isEmpty(this.mySafeEditText.getText())) {
            } else {
                new Handler().post(new Runnable(this) { // from class: com.baidu.fsg.base.widget.SafeKeyBoardPopupWindow.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ SafeKeyBoardPopupWindow f39502a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f39502a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        int i2;
                        int i3;
                        String str;
                        int i4;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            int selectionStart = this.f39502a.mySafeEditText.getSelectionStart();
                            int selectionEnd = this.f39502a.mySafeEditText.getSelectionEnd();
                            Editable text = this.f39502a.mySafeEditText.getText();
                            if (selectionStart >= 0) {
                                if (selectionStart < selectionEnd) {
                                    i2 = 0;
                                    i3 = 0;
                                    str = "";
                                    i4 = selectionStart;
                                    selectionStart = selectionEnd;
                                } else if (selectionStart != selectionEnd) {
                                    i2 = 0;
                                    i3 = 0;
                                    str = "";
                                    i4 = selectionEnd;
                                } else if (selectionStart <= 0) {
                                    return;
                                } else {
                                    i4 = selectionStart - 1;
                                    i2 = 0;
                                    i3 = 0;
                                    str = "";
                                }
                                text.replace(i4, selectionStart, str, i2, i3);
                            }
                        }
                    }
                });
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

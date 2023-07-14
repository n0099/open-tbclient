package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.tieba.bc8;
import com.baidu.tieba.d85;
import com.baidu.tieba.eh8;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.mj5;
import com.baidu.tieba.yi;
import com.baidu.tieba.zg;
import com.baidu.tieba.zi5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class SendVoiceView extends LinearLayout implements mj5, bc8, ISendVoiceView {
    public static /* synthetic */ Interceptable $ic;
    public static final int m;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public TextView b;
    public ImageView c;
    public int d;
    public EditorTools e;
    public FloatNewRecordView f;
    public PopupWindow g;
    public eh8 h;
    public boolean i;
    public long j;
    public boolean k;
    public Runnable l;

    @Override // com.baidu.tieba.aj5
    public void B(zi5 zi5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, zi5Var) == null) {
        }
    }

    @Override // com.baidu.tieba.mj5
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    @Override // com.baidu.tieba.oj
    public void onDeletedVoice(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.oj
    public void onSendVoice(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048594, this, str, i) == null) {
        }
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SendVoiceView a;

        public a(SendVoiceView sendVoiceView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sendVoiceView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sendVoiceView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1435464356, "Lcom/baidu/audiorecorder/lib/voice/SendVoiceView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1435464356, "Lcom/baidu/audiorecorder/lib/voice/SendVoiceView;");
                return;
            }
        }
        m = yi.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
    }

    public void a() {
        FloatNewRecordView floatNewRecordView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (floatNewRecordView = this.f) != null && floatNewRecordView.getParent() != null) {
            this.f.b();
        }
    }

    public void b() {
        FloatNewRecordView floatNewRecordView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (floatNewRecordView = this.f) != null && floatNewRecordView.getParent() != null) {
            this.k = false;
            this.f.c();
            u();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            PopupWindow popupWindow = new PopupWindow();
            this.g = popupWindow;
            popupWindow.setHeight(-1);
            this.g.setWidth(-1);
            this.g.setClippingEnabled(false);
        }
    }

    @Override // com.baidu.tieba.mj5
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921790, Boolean.TRUE));
            setVisibility(0);
        }
    }

    public void e() {
        FloatNewRecordView floatNewRecordView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (floatNewRecordView = this.f) != null && floatNewRecordView.getParent() != null) {
            this.f.f();
        }
    }

    public void f() {
        FloatNewRecordView floatNewRecordView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (floatNewRecordView = this.f) != null && floatNewRecordView.getParent() != null) {
            this.k = true;
            this.f.g();
        }
    }

    @Override // com.baidu.tieba.mj5
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.mj5
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921790, Boolean.FALSE));
            setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.oj
    public boolean isOnCancle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            FloatNewRecordView floatNewRecordView = this.f;
            if (floatNewRecordView != null && floatNewRecordView.getParent() != null) {
                return this.f.isOnCancle();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.oj
    public void onStopingRecorder() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && !this.k) {
            u();
        }
    }

    @Override // com.baidu.tieba.bc8
    public void u() {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && (popupWindow = this.g) != null && popupWindow.isShowing()) {
            this.i = false;
            this.g.dismiss();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendVoiceView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = null;
        this.d = 0;
        this.k = false;
        this.l = new a(this);
        if (context == null) {
            return;
        }
        this.a = context;
        int i3 = m;
        setPadding(0, i3, 0, i3);
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0897, this);
        this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f09243a);
        this.c = (ImageView) findViewById(R.id.obfuscated_res_0x7f09121c);
        setFocusable(true);
        setFocusableInTouchMode(true);
        c();
    }

    @Override // com.baidu.tieba.mj5
    public void G(zi5 zi5Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zi5Var) == null) && (editorTools = this.e) != null) {
            editorTools.D(zi5Var);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            if (motionEvent.getAction() == 2) {
                super.requestDisallowInterceptTouchEvent(true);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, motionEvent)) == null) {
            if (motionEvent.getAction() != 2) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.oj
    public void onShowRecordTime(int i) {
        FloatNewRecordView floatNewRecordView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048596, this, i) == null) && (floatNewRecordView = this.f) != null && floatNewRecordView.getParent() != null && i > 500) {
            this.f.onShowRecordTime(i);
        }
    }

    @Override // com.baidu.tieba.oj
    public void onShowRecording(int i) {
        FloatNewRecordView floatNewRecordView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048597, this, i) == null) && (floatNewRecordView = this.f) != null && floatNewRecordView.getParent() != null) {
            this.f.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.mj5
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, editorTools) == null) {
            this.e = editorTools;
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void setRecoding(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.i = z;
        }
    }

    @Override // com.baidu.tieba.mj5
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.d = i;
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void setTouchCallBack(eh8 eh8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, eh8Var) == null) {
            this.h = eh8Var;
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                this.b.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0cbe));
            } else {
                this.b.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0cbf));
            }
        }
    }

    @Override // com.baidu.tieba.mj5
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            TextView textView = this.b;
            if (textView != null) {
                d85.d(textView).x(R.color.CAM_X0107);
            }
            ImageView imageView = this.c;
            if (imageView != null) {
                WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_im_bottom_voice_btn, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            d85 d = d85.d(this);
            d.o(R.string.J_X01);
            d.m(R.dimen.L_X01);
            d.l(R.color.CAM_X0209);
            d.f(R.color.CAM_X0212);
        }
    }

    public void g() {
        PopupWindow popupWindow;
        FloatNewRecordView floatNewRecordView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && TbadkCoreApplication.getInst().getCurrentActivity() != null && (popupWindow = this.g) != null && (floatNewRecordView = this.f) != null) {
            this.i = true;
            popupWindow.setContentView(floatNewRecordView);
            GreyUtil.grey(this.g);
            this.g.showAtLocation(TbadkCoreApplication.getInst().getCurrentActivity().findViewById(16908290), 0, 0, 0);
            this.f.h();
        }
    }

    @Override // com.baidu.tieba.oj
    public void onShowErr(int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048595, this, i, str) == null) && !StringUtils.isNull(str) && i == 3) {
            u();
        }
    }

    @Override // com.baidu.tieba.oj
    public void onStartedRecorder(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            FloatNewRecordView floatNewRecordView = new FloatNewRecordView(getContext());
            this.f = floatNewRecordView;
            floatNewRecordView.setMaxDuring(i);
            this.f.onStartedRecorder(z, i);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, motionEvent)) == null) {
            if (motionEvent.getAction() == 0) {
                eh8 eh8Var = this.h;
                if (eh8Var != null && eh8Var.a()) {
                    if (this.k) {
                        zg.a().removeCallbacks(this.l);
                        b();
                    }
                    this.j = System.currentTimeMillis();
                    this.h.startRecord();
                    a();
                    d(true);
                    g();
                }
            } else if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                if (this.i && motionEvent.getAction() == 2) {
                    if (motionEvent.getY() < -1.0f && Math.abs(motionEvent.getY()) > yi.d(this.a, 67.0f)) {
                        e();
                    } else {
                        g();
                    }
                }
            } else {
                if (this.i) {
                    if (motionEvent.getY() < -1.0f && Math.abs(motionEvent.getY()) > yi.d(this.a, 67.0f)) {
                        eh8 eh8Var2 = this.h;
                        if (eh8Var2 != null) {
                            eh8Var2.b();
                        }
                        a();
                        u();
                    } else {
                        eh8 eh8Var3 = this.h;
                        if (eh8Var3 != null && !eh8Var3.isForeground()) {
                            this.h.b();
                            u();
                        } else {
                            eh8 eh8Var4 = this.h;
                            if (eh8Var4 != null) {
                                eh8Var4.stopRecord();
                            }
                            if (System.currentTimeMillis() > 0 && System.currentTimeMillis() - this.j < 1000) {
                                f();
                                zg.a().postDelayed(this.l, 2000L);
                            } else {
                                u();
                            }
                        }
                    }
                }
                d(false);
            }
            eh8 eh8Var5 = this.h;
            if (eh8Var5 != null) {
                eh8Var5.setRecoding(this.i);
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}

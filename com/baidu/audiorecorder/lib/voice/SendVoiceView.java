package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a77;
import com.repackage.d27;
import com.repackage.f05;
import com.repackage.li;
import com.repackage.mg;
import com.repackage.sz4;
import com.repackage.wq4;
/* loaded from: classes.dex */
public class SendVoiceView extends LinearLayout implements f05, d27, ISendVoiceView {
    public static /* synthetic */ Interceptable $ic;
    public static final int k;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public TextView b;
    public ImageView c;
    public int d;
    public EditorTools e;
    public FloatNewRecordView f;
    public PopupWindow g;
    public a77 h;
    public boolean i;
    public long j;

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
                this.a.closeRecordTooShort();
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
        k = li.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
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
        if (context == null) {
            return;
        }
        this.a = context;
        int i3 = k;
        setPadding(0, i3, 0, i3);
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d074c, this);
        this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f091f04);
        this.c = (ImageView) findViewById(R.id.obfuscated_res_0x7f090fc1);
        setFocusable(true);
        setFocusableInTouchMode(true);
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            PopupWindow popupWindow = new PopupWindow();
            this.g = popupWindow;
            popupWindow.setHeight(-1);
            this.g.setWidth(-1);
            this.g.setClippingEnabled(false);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                this.b.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0af3));
            } else {
                this.b.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0af4));
            }
        }
    }

    public void c() {
        FloatNewRecordView floatNewRecordView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (floatNewRecordView = this.f) == null || floatNewRecordView.getParent() == null) {
            return;
        }
        this.f.d();
    }

    @Override // com.repackage.d27
    public void closeRecordCancel() {
        FloatNewRecordView floatNewRecordView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (floatNewRecordView = this.f) == null || floatNewRecordView.getParent() == null) {
            return;
        }
        this.f.closeRecordCancel();
    }

    @Override // com.repackage.d27
    public void closeRecordTooShort() {
        FloatNewRecordView floatNewRecordView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (floatNewRecordView = this.f) == null || floatNewRecordView.getParent() == null) {
            return;
        }
        this.f.closeRecordTooShort();
        f();
    }

    public void d() {
        FloatNewRecordView floatNewRecordView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (floatNewRecordView = this.f) == null || floatNewRecordView.getParent() == null) {
            return;
        }
        this.f.e();
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

    @Override // com.repackage.f05
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            setVisibility(0);
        }
    }

    @Override // com.repackage.d27
    public void f() {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (popupWindow = this.g) != null && popupWindow.isShowing()) {
            this.g.dismiss();
        }
    }

    @Override // com.repackage.f05
    public void g(sz4 sz4Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, sz4Var) == null) || (editorTools = this.e) == null) {
            return;
        }
        editorTools.A(sz4Var);
    }

    @Override // com.repackage.f05
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.d : invokeV.intValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || TbadkCoreApplication.getInst().getCurrentActivity() == null) {
            return;
        }
        this.g.setContentView(this.f);
        this.g.showAtLocation(TbadkCoreApplication.getInst().getCurrentActivity().findViewById(16908290), 0, 0, 0);
        this.f.g();
    }

    @Override // com.repackage.f05
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            setVisibility(8);
        }
    }

    @Override // com.repackage.f05
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    @Override // com.repackage.aj
    public boolean isOnCancle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            FloatNewRecordView floatNewRecordView = this.f;
            if (floatNewRecordView == null || floatNewRecordView.getParent() == null) {
                return false;
            }
            return this.f.isOnCancle();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.tz4
    public void onAction(sz4 sz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, sz4Var) == null) {
        }
    }

    @Override // com.repackage.f05
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            TextView textView = this.b;
            if (textView != null) {
                wq4.d(textView).v(R.color.CAM_X0107);
            }
            ImageView imageView = this.c;
            if (imageView != null) {
                WebPManager.setPureDrawable(imageView, R.drawable.obfuscated_res_0x7f080934, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            wq4 d = wq4.d(this);
            d.n(R.string.J_X01);
            d.l(R.dimen.L_X01);
            d.k(R.color.CAM_X0209);
            d.f(R.color.CAM_X0212);
        }
    }

    @Override // com.repackage.aj
    public void onDeletedVoice(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, motionEvent)) == null) {
            if (motionEvent.getAction() != 2) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.aj
    public void onSendVoice(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048595, this, str, i) == null) {
        }
    }

    @Override // com.repackage.aj
    public void onShowErr(int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048596, this, i, str) == null) && !StringUtils.isNull(str) && i == 3) {
            f();
        }
    }

    @Override // com.repackage.aj
    public void onShowRecordTime(int i) {
        FloatNewRecordView floatNewRecordView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048597, this, i) == null) || (floatNewRecordView = this.f) == null || floatNewRecordView.getParent() == null || i <= 500) {
            return;
        }
        this.f.onShowRecordTime(i);
    }

    @Override // com.repackage.aj
    public void onShowRecording(int i) {
        FloatNewRecordView floatNewRecordView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048598, this, i) == null) || (floatNewRecordView = this.f) == null || floatNewRecordView.getParent() == null) {
            return;
        }
        this.f.onShowRecording(i);
    }

    @Override // com.repackage.aj
    public void onStartedRecorder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            FloatNewRecordView floatNewRecordView = new FloatNewRecordView(getContext());
            this.f = floatNewRecordView;
            floatNewRecordView.onStartedRecorder(z);
        }
    }

    @Override // com.repackage.aj
    public void onStopingRecorder() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            f();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, motionEvent)) == null) {
            if (motionEvent.getAction() == 0) {
                a77 a77Var = this.h;
                if (a77Var != null && a77Var.a()) {
                    this.j = System.currentTimeMillis();
                    this.h.startRecord();
                    closeRecordCancel();
                    b(true);
                    h();
                    this.i = true;
                }
            } else if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                if (this.i && motionEvent.getAction() == 2) {
                    if (motionEvent.getY() < -1.0f && Math.abs(motionEvent.getY()) > li.d(this.a, 67.0f)) {
                        c();
                    } else {
                        h();
                    }
                }
            } else {
                if (motionEvent.getY() < -1.0f && Math.abs(motionEvent.getY()) > li.d(this.a, 67.0f)) {
                    a77 a77Var2 = this.h;
                    if (a77Var2 != null) {
                        a77Var2.c();
                    }
                    closeRecordCancel();
                    f();
                } else {
                    a77 a77Var3 = this.h;
                    if (a77Var3 != null && !a77Var3.b()) {
                        this.h.c();
                        f();
                    } else {
                        a77 a77Var4 = this.h;
                        if (a77Var4 != null) {
                            a77Var4.stopRecord();
                        }
                        if (System.currentTimeMillis() > 0 && System.currentTimeMillis() - this.j < 1000) {
                            d();
                            mg.a().postDelayed(new a(this), 2000L);
                        } else {
                            f();
                        }
                    }
                }
                b(false);
                this.i = false;
            }
            this.h.setRecoding(this.i);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.f05
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, editorTools) == null) {
            this.e = editorTools;
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void setRecoding(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.i = z;
        }
    }

    @Override // com.repackage.f05
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.d = i;
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void setTouchCallBack(a77 a77Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, a77Var) == null) {
            this.h = a77Var;
        }
    }
}

package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.w.a;
import c.a.o0.w.n;
import c.a.p0.l4.e;
import c.a.p0.u1.f.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class SendVoiceView extends LinearLayout implements n, b, ISendVoiceView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public int f24860b;

    /* renamed from: c  reason: collision with root package name */
    public EditorTools f24861c;

    /* renamed from: d  reason: collision with root package name */
    public FloatRecordView f24862d;

    /* renamed from: e  reason: collision with root package name */
    public WindowManager f24863e;

    /* renamed from: f  reason: collision with root package name */
    public WindowManager.LayoutParams f24864f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendVoiceView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f24860b = 0;
        if (context == null) {
            return;
        }
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d076d, this);
        this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f091f19);
        setFocusable(true);
        setFocusableInTouchMode(true);
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f24862d = new FloatRecordView(getContext());
            this.f24863e = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.f24864f = layoutParams;
            layoutParams.type = e.a(2002);
            WindowManager.LayoutParams layoutParams2 = this.f24864f;
            layoutParams2.format = 1;
            layoutParams2.flags = 56;
            layoutParams2.gravity = 17;
            layoutParams2.x = 0;
            layoutParams2.y = 0;
            layoutParams2.width = getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702a3);
            this.f24864f.height = getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702a3);
        }
    }

    @Override // c.a.o0.w.n
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setVisibility(0);
        }
    }

    public void c() {
        FloatRecordView floatRecordView;
        LinearLayout b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (floatRecordView = this.f24862d) == null || this.f24863e == null || this.f24864f == null || (b2 = floatRecordView.b()) == null || b2.getParent() != null) {
            return;
        }
        this.f24863e.addView(b2, this.f24864f);
        this.f24862d.e();
    }

    @Override // c.a.p0.u1.f.b
    public void closeRecordCancel() {
        FloatRecordView floatRecordView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (floatRecordView = this.f24862d) == null || this.f24863e == null || this.f24864f == null) {
            return;
        }
        floatRecordView.closeRecordCancel();
        LinearLayout a = this.f24862d.a();
        if (a == null || a.getParent() == null) {
            return;
        }
        this.f24863e.removeView(a);
    }

    @Override // c.a.p0.u1.f.b
    public void closeRecordTooShort() {
        FloatRecordView floatRecordView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (floatRecordView = this.f24862d) == null || this.f24863e == null || this.f24864f == null) {
            return;
        }
        floatRecordView.closeRecordTooShort();
        LinearLayout b2 = this.f24862d.b();
        if (b2 == null || b2.getParent() == null) {
            return;
        }
        this.f24863e.removeView(b2);
    }

    @Override // c.a.o0.w.n
    public void d(a aVar) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) || (editorTools = this.f24861c) == null) {
            return;
        }
        editorTools.A(aVar);
    }

    @Override // c.a.o0.w.n
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f24860b : invokeV.intValue;
    }

    @Override // c.a.o0.w.n
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            setVisibility(8);
        }
    }

    @Override // c.a.o0.w.n
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // c.a.o0.w.b
    public void onAction(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
        }
    }

    @Override // c.a.o0.w.n
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
        }
    }

    @Override // c.a.d.f.q.f
    public void onDeletedVoice(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
        }
    }

    @Override // c.a.d.f.q.f
    public void onSendVoice(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, str, i) == null) {
        }
    }

    @Override // c.a.d.f.q.f
    public void onShowErr(int i, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048589, this, i, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        if (i == 3) {
            stopRecordVoice();
        } else if (i == 2) {
            closeRecordCancel();
            closeRecordTooShort();
            c();
        }
    }

    @Override // c.a.d.f.q.f
    public void onShowRecordTime(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
        }
    }

    @Override // c.a.d.f.q.f
    public void onShowRecording(int i) {
        FloatRecordView floatRecordView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i) == null) || (floatRecordView = this.f24862d) == null || this.f24863e == null || this.f24864f == null) {
            return;
        }
        floatRecordView.onShowRecording(i);
    }

    @Override // c.a.d.f.q.f
    public void onStartedRecorder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
        }
    }

    @Override // c.a.d.f.q.f
    public void onStopingRecorder() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            if (z) {
                this.a.setBackgroundResource(R.drawable.obfuscated_res_0x7f08042c);
                this.a.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0ade));
                return;
            }
            this.a.setBackgroundResource(R.drawable.obfuscated_res_0x7f08042b);
            this.a.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0adf));
        }
    }

    @Override // c.a.o0.w.n
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, editorTools) == null) {
            this.f24861c = editorTools;
        }
    }

    @Override // c.a.o0.w.n
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.f24860b = i;
        }
    }

    @Override // c.a.p0.u1.f.b
    public void showRecordCancel() {
        FloatRecordView floatRecordView;
        LinearLayout a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (floatRecordView = this.f24862d) == null || this.f24863e == null || this.f24864f == null || (a = floatRecordView.a()) == null || a.getParent() != null) {
            return;
        }
        this.f24863e.addView(a, this.f24864f);
        this.f24862d.showRecordCancel();
    }

    @Override // c.a.p0.u1.f.b
    public void startRecordVoice() {
        FloatRecordView floatRecordView;
        LinearLayout c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (floatRecordView = this.f24862d) == null || this.f24863e == null || this.f24864f == null || (c2 = floatRecordView.c()) == null || c2.getParent() != null) {
            return;
        }
        this.f24863e.addView(c2, this.f24864f);
        this.f24862d.startRecordVoice();
    }

    @Override // c.a.p0.u1.f.b
    public void stopRecordVoice() {
        FloatRecordView floatRecordView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (floatRecordView = this.f24862d) == null || this.f24863e == null || this.f24864f == null) {
            return;
        }
        floatRecordView.stopRecordVoice();
        LinearLayout c2 = this.f24862d.c();
        if (c2 == null || c2.getParent() == null) {
            return;
        }
        this.f24863e.removeView(c2);
    }
}

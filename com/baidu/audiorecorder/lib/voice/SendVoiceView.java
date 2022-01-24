package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.x.a;
import c.a.s0.x.n;
import c.a.t0.i4.d;
import c.a.t0.t1.f.b;
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
/* loaded from: classes10.dex */
public class SendVoiceView extends LinearLayout implements n, b, ISendVoiceView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f32895e;

    /* renamed from: f  reason: collision with root package name */
    public int f32896f;

    /* renamed from: g  reason: collision with root package name */
    public EditorTools f32897g;

    /* renamed from: h  reason: collision with root package name */
    public FloatRecordView f32898h;

    /* renamed from: i  reason: collision with root package name */
    public WindowManager f32899i;

    /* renamed from: j  reason: collision with root package name */
    public WindowManager.LayoutParams f32900j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendVoiceView(Context context) {
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
        this.f32895e = null;
        this.f32896f = 0;
        if (context == null) {
            return;
        }
        LayoutInflater.from(context).inflate(R.layout.send_voice_view, this);
        this.f32895e = (TextView) findViewById(R.id.tex_send_voice);
        setFocusable(true);
        setFocusableInTouchMode(true);
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f32898h = new FloatRecordView(getContext());
            this.f32899i = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.f32900j = layoutParams;
            layoutParams.type = d.a(2002);
            WindowManager.LayoutParams layoutParams2 = this.f32900j;
            layoutParams2.format = 1;
            layoutParams2.flags = 56;
            layoutParams2.gravity = 17;
            layoutParams2.x = 0;
            layoutParams2.y = 0;
            layoutParams2.width = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
            this.f32900j.height = getContext().getResources().getDimensionPixelSize(R.dimen.ds360);
        }
    }

    @Override // c.a.t0.t1.f.b
    public void closeRecordCancel() {
        FloatRecordView floatRecordView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (floatRecordView = this.f32898h) == null || this.f32899i == null || this.f32900j == null) {
            return;
        }
        floatRecordView.closeRecordCancel();
        LinearLayout a = this.f32898h.a();
        if (a == null || a.getParent() == null) {
            return;
        }
        this.f32899i.removeView(a);
    }

    @Override // c.a.t0.t1.f.b
    public void closeRecordTooShort() {
        FloatRecordView floatRecordView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (floatRecordView = this.f32898h) == null || this.f32899i == null || this.f32900j == null) {
            return;
        }
        floatRecordView.closeRecordTooShort();
        LinearLayout b2 = this.f32898h.b();
        if (b2 == null || b2.getParent() == null) {
            return;
        }
        this.f32899i.removeView(b2);
    }

    @Override // c.a.s0.x.n
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setVisibility(0);
        }
    }

    @Override // c.a.s0.x.n
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f32896f : invokeV.intValue;
    }

    @Override // c.a.s0.x.n
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setVisibility(8);
        }
    }

    @Override // c.a.s0.x.n
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // c.a.s0.x.b
    public void onAction(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
        }
    }

    @Override // c.a.s0.x.n
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
        }
    }

    @Override // c.a.d.f.q.f
    public void onDeletedVoice(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
        }
    }

    @Override // c.a.d.f.q.f
    public void onSendVoice(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, str, i2) == null) {
        }
    }

    @Override // c.a.d.f.q.f
    public void onShowErr(int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048587, this, i2, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        if (i2 == 3) {
            stopRecordVoice();
        } else if (i2 == 2) {
            closeRecordCancel();
            closeRecordTooShort();
            showRecordTooShort();
        }
    }

    @Override // c.a.d.f.q.f
    public void onShowRecordTime(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
        }
    }

    @Override // c.a.d.f.q.f
    public void onShowRecording(int i2) {
        FloatRecordView floatRecordView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || (floatRecordView = this.f32898h) == null || this.f32899i == null || this.f32900j == null) {
            return;
        }
        floatRecordView.onShowRecording(i2);
    }

    @Override // c.a.d.f.q.f
    public void onStartedRecorder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
        }
    }

    @Override // c.a.d.f.q.f
    public void onStopingRecorder() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    @Override // com.baidu.tieba.im.chat.ISendVoiceView
    public void refreshSendVoiceText(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            if (z) {
                this.f32895e.setBackgroundResource(R.drawable.but_talk_s);
                this.f32895e.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_no_push));
                return;
            }
            this.f32895e.setBackgroundResource(R.drawable.but_talk_n);
            this.f32895e.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.msglist_push_talk));
        }
    }

    @Override // c.a.s0.x.n
    public void sendAction(a aVar) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, aVar) == null) || (editorTools = this.f32897g) == null) {
            return;
        }
        editorTools.sendAction(aVar);
    }

    @Override // c.a.s0.x.n
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, editorTools) == null) {
            this.f32897g = editorTools;
        }
    }

    @Override // c.a.s0.x.n
    public void setToolId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.f32896f = i2;
        }
    }

    @Override // c.a.t0.t1.f.b
    public void showRecordCancel() {
        FloatRecordView floatRecordView;
        LinearLayout a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (floatRecordView = this.f32898h) == null || this.f32899i == null || this.f32900j == null || (a = floatRecordView.a()) == null || a.getParent() != null) {
            return;
        }
        this.f32899i.addView(a, this.f32900j);
        this.f32898h.showRecordCancel();
    }

    public void showRecordTooShort() {
        FloatRecordView floatRecordView;
        LinearLayout b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (floatRecordView = this.f32898h) == null || this.f32899i == null || this.f32900j == null || (b2 = floatRecordView.b()) == null || b2.getParent() != null) {
            return;
        }
        this.f32899i.addView(b2, this.f32900j);
        this.f32898h.e();
    }

    @Override // c.a.t0.t1.f.b
    public void startRecordVoice() {
        FloatRecordView floatRecordView;
        LinearLayout c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (floatRecordView = this.f32898h) == null || this.f32899i == null || this.f32900j == null || (c2 = floatRecordView.c()) == null || c2.getParent() != null) {
            return;
        }
        this.f32899i.addView(c2, this.f32900j);
        this.f32898h.startRecordVoice();
    }

    @Override // c.a.t0.t1.f.b
    public void stopRecordVoice() {
        FloatRecordView floatRecordView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (floatRecordView = this.f32898h) == null || this.f32899i == null || this.f32900j == null) {
            return;
        }
        floatRecordView.stopRecordVoice();
        LinearLayout c2 = this.f32898h.c();
        if (c2 == null || c2.getParent() == null) {
            return;
        }
        this.f32899i.removeView(c2);
    }
}

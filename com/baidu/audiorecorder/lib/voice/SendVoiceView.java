package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
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
import com.repackage.bs8;
import com.repackage.i05;
import com.repackage.v05;
import com.repackage.x47;
/* loaded from: classes.dex */
public class SendVoiceView extends LinearLayout implements v05, x47, ISendVoiceView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public int b;
    public EditorTools c;
    public FloatRecordView d;
    public WindowManager e;
    public WindowManager.LayoutParams f;

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
        this.b = 0;
        if (context == null) {
            return;
        }
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0764, this);
        this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f091f05);
        setFocusable(true);
        setFocusableInTouchMode(true);
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.d = new FloatRecordView(getContext());
            this.e = (WindowManager) TbadkCoreApplication.getInst().getContext().getSystemService("window");
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.f = layoutParams;
            layoutParams.type = bs8.a(2002);
            WindowManager.LayoutParams layoutParams2 = this.f;
            layoutParams2.format = 1;
            layoutParams2.flags = 56;
            layoutParams2.gravity = 17;
            layoutParams2.x = 0;
            layoutParams2.y = 0;
            layoutParams2.width = getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702ad);
            this.f.height = getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702ad);
        }
    }

    @Override // com.repackage.v05
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setVisibility(0);
        }
    }

    public void c() {
        FloatRecordView floatRecordView;
        LinearLayout b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (floatRecordView = this.d) == null || this.e == null || this.f == null || (b = floatRecordView.b()) == null || b.getParent() != null) {
            return;
        }
        this.e.addView(b, this.f);
        this.d.e();
    }

    @Override // com.repackage.x47
    public void closeRecordCancel() {
        FloatRecordView floatRecordView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (floatRecordView = this.d) == null || this.e == null || this.f == null) {
            return;
        }
        floatRecordView.closeRecordCancel();
        LinearLayout a = this.d.a();
        if (a == null || a.getParent() == null) {
            return;
        }
        this.e.removeView(a);
    }

    @Override // com.repackage.x47
    public void closeRecordTooShort() {
        FloatRecordView floatRecordView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (floatRecordView = this.d) == null || this.e == null || this.f == null) {
            return;
        }
        floatRecordView.closeRecordTooShort();
        LinearLayout b = this.d.b();
        if (b == null || b.getParent() == null) {
            return;
        }
        this.e.removeView(b);
    }

    @Override // com.repackage.v05
    public void d(i05 i05Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, i05Var) == null) || (editorTools = this.c) == null) {
            return;
        }
        editorTools.A(i05Var);
    }

    @Override // com.repackage.v05
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.b : invokeV.intValue;
    }

    @Override // com.repackage.v05
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            setVisibility(8);
        }
    }

    @Override // com.repackage.v05
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // com.repackage.j05
    public void onAction(i05 i05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, i05Var) == null) {
        }
    }

    @Override // com.repackage.v05
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
        }
    }

    @Override // com.repackage.ej
    public void onDeletedVoice(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
        }
    }

    @Override // com.repackage.ej
    public void onSendVoice(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, str, i) == null) {
        }
    }

    @Override // com.repackage.ej
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

    @Override // com.repackage.ej
    public void onShowRecordTime(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
        }
    }

    @Override // com.repackage.ej
    public void onShowRecording(int i) {
        FloatRecordView floatRecordView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i) == null) || (floatRecordView = this.d) == null || this.e == null || this.f == null) {
            return;
        }
        floatRecordView.onShowRecording(i);
    }

    @Override // com.repackage.ej
    public void onStartedRecorder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
        }
    }

    @Override // com.repackage.ej
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
                this.a.setBackgroundResource(R.drawable.obfuscated_res_0x7f080429);
                this.a.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0ae0));
                return;
            }
            this.a.setBackgroundResource(R.drawable.obfuscated_res_0x7f080428);
            this.a.setText(TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0ae1));
        }
    }

    @Override // com.repackage.v05
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, editorTools) == null) {
            this.c = editorTools;
        }
    }

    @Override // com.repackage.v05
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.b = i;
        }
    }

    @Override // com.repackage.x47
    public void showRecordCancel() {
        FloatRecordView floatRecordView;
        LinearLayout a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (floatRecordView = this.d) == null || this.e == null || this.f == null || (a = floatRecordView.a()) == null || a.getParent() != null) {
            return;
        }
        this.e.addView(a, this.f);
        this.d.showRecordCancel();
    }

    @Override // com.repackage.x47
    public void startRecordVoice() {
        FloatRecordView floatRecordView;
        LinearLayout c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (floatRecordView = this.d) == null || this.e == null || this.f == null || (c = floatRecordView.c()) == null || c.getParent() != null) {
            return;
        }
        this.e.addView(c, this.f);
        this.d.startRecordVoice();
    }

    @Override // com.repackage.x47
    public void stopRecordVoice() {
        FloatRecordView floatRecordView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (floatRecordView = this.d) == null || this.e == null || this.f == null) {
            return;
        }
        floatRecordView.stopRecordVoice();
        LinearLayout c = this.d.c();
        if (c == null || c.getParent() == null) {
            return;
        }
        this.e.removeView(c);
    }
}

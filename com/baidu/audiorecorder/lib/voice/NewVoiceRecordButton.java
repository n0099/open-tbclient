package com.baidu.audiorecorder.lib.voice;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.tieba.cx4;
import com.baidu.tieba.d9;
import com.baidu.tieba.ej;
import com.baidu.tieba.gj;
import com.baidu.tieba.i9;
import com.baidu.tieba.m75;
import com.baidu.tieba.n25;
import com.baidu.tieba.wr4;
import com.baidu.tieba.z25;
import com.baidu.tieba.zm8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes.dex */
public class NewVoiceRecordButton extends LinearLayout implements gj, z25 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout a;
    public ImageView b;
    public RecordingAnimView c;
    public TextView d;
    public TextView e;
    public EditorTools f;
    public int g;
    public VoiceData.VoiceModel h;
    public boolean i;
    public wr4 j;
    public PermissionJudgePolicy k;

    /* loaded from: classes.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewVoiceRecordButton a;

        public a(NewVoiceRecordButton newVoiceRecordButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newVoiceRecordButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newVoiceRecordButton;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 1) {
                        if (this.a.h == null) {
                            this.a.l();
                        } else {
                            this.a.j();
                        }
                    }
                } else if (this.a.h == null) {
                    this.a.k();
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements wr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewVoiceRecordButton a;

        public b(NewVoiceRecordButton newVoiceRecordButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newVoiceRecordButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newVoiceRecordButton;
        }

        @Override // com.baidu.tieba.wr4.e
        public void onClick(wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wr4Var) == null) {
                wr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements wr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewVoiceRecordButton a;

        public c(NewVoiceRecordButton newVoiceRecordButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newVoiceRecordButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newVoiceRecordButton;
        }

        @Override // com.baidu.tieba.wr4.e
        public void onClick(wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wr4Var) == null) {
                wr4Var.dismiss();
                this.a.J(new n25(11, -1, null));
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewVoiceRecordButton a;

        public d(NewVoiceRecordButton newVoiceRecordButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newVoiceRecordButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newVoiceRecordButton;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.d == null || this.a.i) {
                return;
            }
            this.a.d.setVisibility(4);
            this.a.d.setText("");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewVoiceRecordButton(Context context) {
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
        this.g = 0;
        g();
    }

    @Override // com.baidu.tieba.o25
    public void A(n25 n25Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, n25Var) == null) || n25Var == null) {
            return;
        }
        int i = n25Var.a;
        if (i == 1) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 6));
        } else if (i == 9) {
            i();
        } else if (i != 52) {
        } else {
            Object obj = n25Var.c;
            if (obj instanceof VoiceData.VoiceModel) {
                this.h = (VoiceData.VoiceModel) obj;
                this.e.setText(getResources().getText(R.string.obfuscated_res_0x7f0f1575));
                return;
            }
            i();
        }
    }

    @Override // com.baidu.tieba.z25
    public void J(n25 n25Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, n25Var) == null) || (editorTools = this.f) == null) {
            return;
        }
        editorTools.A(n25Var);
    }

    @Override // com.baidu.tieba.z25
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setVisibility(0);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0486, this);
            this.a = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091287);
            this.b = (ImageView) findViewById(R.id.obfuscated_res_0x7f09100a);
            RecordingAnimView recordingAnimView = (RecordingAnimView) findViewById(R.id.obfuscated_res_0x7f091b68);
            this.c = recordingAnimView;
            recordingAnimView.setCertainColumnCount(8);
            this.c.setColumnColor(R.color.CAM_X0111);
            this.c.setColumnWidth(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224));
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f092336);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f0923bb);
            this.a.setOnTouchListener(new a(this));
            zm8 recorderManager = getRecorderManager();
            if (recorderManager != null) {
                recorderManager.e(this);
                recorderManager.d(ej.a);
            }
        }
    }

    public zm8 getRecorderManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager == null || voiceManager.getRecorderManager() == null) {
                return null;
            }
            return voiceManager.getRecorderManager();
        }
        return (zm8) invokeV.objValue;
    }

    @Override // com.baidu.tieba.z25
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.g : invokeV.intValue;
    }

    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Context context = getContext();
            if (context instanceof VoiceManager.j) {
                return ((VoiceManager.j) context).t0();
            }
            if ((i9.a(getContext()) instanceof d9) && (tbPageContext = (TbPageContext) i9.a(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.j)) {
                return ((VoiceManager.j) tbPageContext.getOrignalPage()).t0();
            }
            return null;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tieba.z25
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            setVisibility(8);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.h = null;
            this.e.setText(getResources().getText(R.string.obfuscated_res_0x7f0f1570));
            this.d.setText("");
            this.d.setVisibility(4);
        }
    }

    @Override // com.baidu.tieba.z25
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // com.baidu.tieba.gj
    public boolean isOnCancle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.j == null) {
                wr4 wr4Var = new wr4(i9.a(getContext()).getPageActivity());
                this.j = wr4Var;
                wr4Var.setMessage(getContext().getString(R.string.obfuscated_res_0x7f0f1576)).setPositiveButton(getContext().getString(R.string.obfuscated_res_0x7f0f1575), new c(this)).setNegativeButton(getContext().getString(R.string.obfuscated_res_0x7f0f0371), new b(this)).create(i9.a(getContext()));
            }
            this.j.show();
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (getContext() instanceof Activity) {
                if (this.k == null) {
                    this.k = new PermissionJudgePolicy();
                }
                this.k.clearRequestPermissionList();
                this.k.appendRequestPermission((Activity) getContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
                this.k.appendRequestPermission((Activity) getContext(), PermissionRequest.RESOURCE_AUDIO_CAPTURE);
                if (this.k.startRequestPermission((Activity) getContext())) {
                    return;
                }
            }
            VoiceData.VoiceModel voiceModel = this.h;
            if (voiceModel != null) {
                cx4.a(cx4.b(voiceModel.voiceId));
            }
            zm8 recorderManager = getRecorderManager();
            if (recorderManager == null || !recorderManager.f()) {
                return;
            }
            this.i = recorderManager.c(this, -1);
            m75.b().l(true);
            this.d.setVisibility(0);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.b.setVisibility(0);
            this.c.g();
            this.c.setVisibility(4);
            this.e.setText(getResources().getText(R.string.obfuscated_res_0x7f0f1570));
            this.d.setVisibility(4);
            zm8 recorderManager = getRecorderManager();
            if (this.i && recorderManager != null) {
                recorderManager.stopRecord();
            }
            this.i = false;
            m75.b().l(false);
        }
    }

    @Override // com.baidu.tieba.z25
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            SkinManager.setViewTextColor(this.e, R.color.CAM_X0106, 1, i);
            SkinManager.setViewTextColor(this.d, R.color.CAM_X0302, 1, i);
            SkinManager.setBackgroundResource(this.b, R.drawable.ic_post_record, i);
            this.c.f(i);
        }
    }

    @Override // com.baidu.tieba.gj
    public void onDeletedVoice(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.gj
    public void onSendVoice(String str, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048592, this, str, i) == null) || TextUtils.isEmpty(str) || i <= 0) {
            return;
        }
        VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
        this.h = voiceModel;
        voiceModel.duration = i;
        voiceModel.isLocal = true;
        voiceModel.voiceId = str;
        voiceModel.voice_status = 1;
        this.e.setText(getResources().getText(R.string.obfuscated_res_0x7f0f1575));
        J(new n25(10, -1, this.h));
    }

    @Override // com.baidu.tieba.gj
    public void onShowErr(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048593, this, i, str) == null) {
            this.d.setVisibility(0);
            this.d.setText(str);
            postDelayed(new d(this), 2000L);
        }
    }

    @Override // com.baidu.tieba.gj
    public void onShowRecordTime(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.d.setText(VoiceManager.formatVoiceTime(i / 1000));
        }
    }

    @Override // com.baidu.tieba.gj
    public void onShowRecording(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
        }
    }

    @Override // com.baidu.tieba.gj
    public void onStartedRecorder(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048596, this, z) == null) && z) {
            this.b.setVisibility(4);
            this.c.setVisibility(0);
            this.c.h();
            this.e.setText(getResources().getText(R.string.obfuscated_res_0x7f0f1571));
        }
    }

    @Override // com.baidu.tieba.gj
    public void onStopingRecorder() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    @Override // com.baidu.tieba.z25
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, editorTools) == null) {
            this.f = editorTools;
        }
    }

    @Override // com.baidu.tieba.z25
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.g = i;
        }
    }
}

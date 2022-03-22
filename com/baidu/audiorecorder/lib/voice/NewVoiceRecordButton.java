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
import c.a.d.a.j;
import c.a.d.f.q.f;
import c.a.o0.r.t.a;
import c.a.o0.w.n;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class NewVoiceRecordButton extends LinearLayout implements f, n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f24846b;

    /* renamed from: c  reason: collision with root package name */
    public RecordingAnimView f24847c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f24848d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f24849e;

    /* renamed from: f  reason: collision with root package name */
    public EditorTools f24850f;

    /* renamed from: g  reason: collision with root package name */
    public int f24851g;

    /* renamed from: h  reason: collision with root package name */
    public VoiceData.VoiceModel f24852h;
    public boolean i;
    public c.a.o0.r.t.a j;
    public PermissionJudgePolicy k;

    /* loaded from: classes3.dex */
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
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 1) {
                        if (this.a.f24852h == null) {
                            this.a.n();
                        } else {
                            this.a.l();
                        }
                    }
                } else if (this.a.f24852h == null) {
                    this.a.m();
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.e {
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

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements a.e {
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

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                this.a.d(new c.a.o0.w.a(11, -1, null));
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f24848d == null || this.a.i) {
                return;
            }
            this.a.f24848d.setVisibility(4);
            this.a.f24848d.setText("");
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
        this.f24851g = 0;
        j();
    }

    @Override // c.a.o0.w.n
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setVisibility(0);
        }
    }

    @Override // c.a.o0.w.n
    public void d(c.a.o0.w.a aVar) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || (editorTools = this.f24850f) == null) {
            return;
        }
        editorTools.A(aVar);
    }

    public c.a.p0.a4.s0.a getRecorderManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager == null || voiceManager.getRecorderManager() == null) {
                return null;
            }
            return voiceManager.getRecorderManager();
        }
        return (c.a.p0.a4.s0.a) invokeV.objValue;
    }

    @Override // c.a.o0.w.n
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f24851g : invokeV.intValue;
    }

    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Context context = getContext();
            if (context instanceof VoiceManager.j) {
                return ((VoiceManager.j) context).getVoiceManager();
            }
            if ((j.a(getContext()) instanceof c.a.d.a.f) && (tbPageContext = (TbPageContext) j.a(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.j)) {
                return ((VoiceManager.j) tbPageContext.getOrignalPage()).getVoiceManager();
            }
            return null;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // c.a.o0.w.n
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setVisibility(8);
        }
    }

    @Override // c.a.o0.w.n
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d048c, this);
            this.a = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0911f3);
            this.f24846b = (ImageView) findViewById(R.id.obfuscated_res_0x7f090ff4);
            RecordingAnimView recordingAnimView = (RecordingAnimView) findViewById(R.id.obfuscated_res_0x7f091a1a);
            this.f24847c = recordingAnimView;
            recordingAnimView.setCertainColumnCount(8);
            this.f24847c.setColumnColor(R.color.CAM_X0111);
            this.f24847c.setColumnWidth(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224));
            this.f24848d = (TextView) findViewById(R.id.obfuscated_res_0x7f0921a4);
            this.f24849e = (TextView) findViewById(R.id.obfuscated_res_0x7f09221c);
            this.a.setOnTouchListener(new a(this));
            c.a.p0.a4.s0.a recorderManager = getRecorderManager();
            if (recorderManager != null) {
                recorderManager.d(this);
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f24852h = null;
            this.f24849e.setText(getResources().getText(R.string.obfuscated_res_0x7f0f1520));
            this.f24848d.setText("");
            this.f24848d.setVisibility(4);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.j == null) {
                c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(j.a(getContext()).getPageActivity());
                this.j = aVar;
                aVar.setMessage(getContext().getString(R.string.obfuscated_res_0x7f0f1525)).setPositiveButton(getContext().getString(R.string.obfuscated_res_0x7f0f1524), new c(this)).setNegativeButton(getContext().getString(R.string.obfuscated_res_0x7f0f036c), new b(this)).create(j.a(getContext()));
            }
            this.j.show();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (getContext() instanceof Activity) {
                if (this.k == null) {
                    this.k = new PermissionJudgePolicy();
                }
                this.k.clearRequestPermissionList();
                this.k.appendRequestPermission((Activity) getContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
                this.k.appendRequestPermission((Activity) getContext(), "android.permission.RECORD_AUDIO");
                if (this.k.startRequestPermission((Activity) getContext())) {
                    return;
                }
            }
            VoiceData.VoiceModel voiceModel = this.f24852h;
            if (voiceModel != null) {
                c.a.o0.r.m0.a.a(c.a.o0.r.m0.a.b(voiceModel.voiceId));
            }
            c.a.p0.a4.s0.a recorderManager = getRecorderManager();
            if (recorderManager == null || !recorderManager.e()) {
                return;
            }
            this.i = recorderManager.c(this, -1);
            c.a.o0.i0.g.c.b().l(true);
            this.f24848d.setVisibility(0);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f24846b.setVisibility(0);
            this.f24847c.g();
            this.f24847c.setVisibility(4);
            this.f24849e.setText(getResources().getText(R.string.obfuscated_res_0x7f0f1520));
            this.f24848d.setVisibility(4);
            c.a.p0.a4.s0.a recorderManager = getRecorderManager();
            if (this.i && recorderManager != null) {
                recorderManager.stopRecord();
            }
            this.i = false;
            c.a.o0.i0.g.c.b().l(false);
        }
    }

    @Override // c.a.o0.w.b
    public void onAction(c.a.o0.w.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) || aVar == null) {
            return;
        }
        int i = aVar.a;
        if (i == 1) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 6));
        } else if (i == 9) {
            k();
        } else if (i != 52) {
        } else {
            Object obj = aVar.f11499c;
            if (obj instanceof VoiceData.VoiceModel) {
                this.f24852h = (VoiceData.VoiceModel) obj;
                this.f24849e.setText(getResources().getText(R.string.obfuscated_res_0x7f0f1524));
                return;
            }
            k();
        }
    }

    @Override // c.a.o0.w.n
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            SkinManager.setViewTextColor(this.f24849e, R.color.CAM_X0106, 1, i);
            SkinManager.setViewTextColor(this.f24848d, R.color.CAM_X0302, 1, i);
            SkinManager.setBackgroundResource(this.f24846b, R.drawable.ic_post_record, i);
            this.f24847c.f(i);
        }
    }

    @Override // c.a.d.f.q.f
    public void onDeletedVoice(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
        }
    }

    @Override // c.a.d.f.q.f
    public void onSendVoice(String str, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048591, this, str, i) == null) || TextUtils.isEmpty(str) || i <= 0) {
            return;
        }
        VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
        this.f24852h = voiceModel;
        voiceModel.duration = i;
        voiceModel.isLocal = true;
        voiceModel.voiceId = str;
        voiceModel.voice_status = 1;
        this.f24849e.setText(getResources().getText(R.string.obfuscated_res_0x7f0f1524));
        d(new c.a.o0.w.a(10, -1, this.f24852h));
    }

    @Override // c.a.d.f.q.f
    public void onShowErr(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048592, this, i, str) == null) {
            this.f24848d.setVisibility(0);
            this.f24848d.setText(str);
            postDelayed(new d(this), 2000L);
        }
    }

    @Override // c.a.d.f.q.f
    public void onShowRecordTime(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.f24848d.setText(VoiceManager.formatVoiceTime(i));
        }
    }

    @Override // c.a.d.f.q.f
    public void onShowRecording(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
        }
    }

    @Override // c.a.d.f.q.f
    public void onStartedRecorder(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048595, this, z) == null) && z) {
            this.f24846b.setVisibility(4);
            this.f24847c.setVisibility(0);
            this.f24847c.h();
            this.f24849e.setText(getResources().getText(R.string.obfuscated_res_0x7f0f1521));
        }
    }

    @Override // c.a.d.f.q.f
    public void onStopingRecorder() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
        }
    }

    @Override // c.a.o0.w.n
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, editorTools) == null) {
            this.f24850f = editorTools;
        }
    }

    @Override // c.a.o0.w.n
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.f24851g = i;
        }
    }
}

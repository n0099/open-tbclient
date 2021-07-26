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
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
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
import com.baidu.webkit.sdk.PermissionRequest;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.d.a.j;
import d.a.d.e.q.f;
import d.a.p0.s.s.a;
import d.a.p0.x.n;
/* loaded from: classes.dex */
public class NewVoiceRecordButton extends LinearLayout implements f, n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f4270e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f4271f;

    /* renamed from: g  reason: collision with root package name */
    public RecordingAnimView f4272g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f4273h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f4274i;
    public EditorTools j;
    public int k;
    public VoiceData$VoiceModel l;
    public boolean m;
    public d.a.p0.s.s.a n;
    public PermissionJudgePolicy o;

    /* loaded from: classes.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewVoiceRecordButton f4275e;

        public a(NewVoiceRecordButton newVoiceRecordButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newVoiceRecordButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4275e = newVoiceRecordButton;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 1) {
                        if (this.f4275e.l == null) {
                            this.f4275e.n();
                        } else {
                            this.f4275e.l();
                        }
                    }
                } else if (this.f4275e.l == null) {
                    this.f4275e.m();
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewVoiceRecordButton f4276e;

        public b(NewVoiceRecordButton newVoiceRecordButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newVoiceRecordButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4276e = newVoiceRecordButton;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewVoiceRecordButton f4277e;

        public c(NewVoiceRecordButton newVoiceRecordButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newVoiceRecordButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4277e = newVoiceRecordButton;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                this.f4277e.d(new d.a.p0.x.a(11, -1, null));
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewVoiceRecordButton f4278e;

        public d(NewVoiceRecordButton newVoiceRecordButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newVoiceRecordButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4278e = newVoiceRecordButton;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f4278e.f4273h == null || this.f4278e.m) {
                return;
            }
            this.f4278e.f4273h.setVisibility(4);
            this.f4278e.f4273h.setText("");
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = 0;
        j();
    }

    @Override // d.a.p0.x.n
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setVisibility(0);
        }
    }

    @Override // d.a.p0.x.n
    public void d(d.a.p0.x.a aVar) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || (editorTools = this.j) == null) {
            return;
        }
        editorTools.A(aVar);
    }

    public d.a.q0.h3.p0.a getRecorderManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager == null || voiceManager.getRecorderManager() == null) {
                return null;
            }
            return voiceManager.getRecorderManager();
        }
        return (d.a.q0.h3.p0.a) invokeV.objValue;
    }

    @Override // d.a.p0.x.n
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : invokeV.intValue;
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
            if ((j.a(getContext()) instanceof d.a.d.a.f) && (tbPageContext = (TbPageContext) j.a(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.j)) {
                return ((VoiceManager.j) tbPageContext.getOrignalPage()).getVoiceManager();
            }
            return null;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // d.a.p0.x.n
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setVisibility(8);
        }
    }

    @Override // d.a.p0.x.n
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            LinearLayout.inflate(getContext(), R.layout.layou_new_record_button, this);
            this.f4270e = (FrameLayout) findViewById(R.id.layout_record_button);
            this.f4271f = (ImageView) findViewById(R.id.iv_record_init);
            RecordingAnimView recordingAnimView = (RecordingAnimView) findViewById(R.id.record_anim_view);
            this.f4272g = recordingAnimView;
            recordingAnimView.setCertainColumnCount(8);
            this.f4272g.setColumnColor(R.color.CAM_X0111);
            this.f4272g.setColumnWidth(getResources().getDimensionPixelSize(R.dimen.ds4));
            this.f4273h = (TextView) findViewById(R.id.tv_duration);
            this.f4274i = (TextView) findViewById(R.id.tv_tip);
            this.f4270e.setOnTouchListener(new a(this));
            d.a.q0.h3.p0.a recorderManager = getRecorderManager();
            if (recorderManager != null) {
                recorderManager.e(this);
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.l = null;
            this.f4274i.setText(getResources().getText(R.string.voice_record_press_to_record));
            this.f4273h.setText("");
            this.f4273h.setVisibility(4);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.n == null) {
                d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(j.a(getContext()).getPageActivity());
                this.n = aVar;
                aVar.setMessage(getContext().getString(R.string.voice_restart_tip)).setPositiveButton(getContext().getString(R.string.voice_restart), new c(this)).setNegativeButton(getContext().getString(R.string.cancel), new b(this)).create(j.a(getContext()));
            }
            this.n.show();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (getContext() instanceof Activity) {
                if (this.o == null) {
                    this.o = new PermissionJudgePolicy();
                }
                this.o.clearRequestPermissionList();
                this.o.appendRequestPermission((Activity) getContext(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                this.o.appendRequestPermission((Activity) getContext(), PermissionRequest.RESOURCE_AUDIO_CAPTURE);
                if (this.o.startRequestPermission((Activity) getContext())) {
                    return;
                }
            }
            VoiceData$VoiceModel voiceData$VoiceModel = this.l;
            if (voiceData$VoiceModel != null) {
                d.a.p0.s.g0.a.a(d.a.p0.s.g0.a.b(voiceData$VoiceModel.voiceId));
            }
            d.a.q0.h3.p0.a recorderManager = getRecorderManager();
            if (recorderManager == null || !recorderManager.f()) {
                return;
            }
            this.m = recorderManager.b(this, -1);
            this.f4273h.setVisibility(0);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f4271f.setVisibility(0);
            this.f4272g.g();
            this.f4272g.setVisibility(4);
            this.f4274i.setText(getResources().getText(R.string.voice_record_press_to_record));
            this.f4273h.setVisibility(4);
            d.a.q0.h3.p0.a recorderManager = getRecorderManager();
            if (this.m && recorderManager != null) {
                recorderManager.stopRecord();
            }
            this.m = false;
        }
    }

    @Override // d.a.p0.x.b
    public void onAction(d.a.p0.x.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) || aVar == null) {
            return;
        }
        int i2 = aVar.f54158a;
        if (i2 == 1) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 6));
        } else if (i2 == 9) {
            k();
        } else if (i2 != 52) {
        } else {
            Object obj = aVar.f54160c;
            if (obj instanceof VoiceData$VoiceModel) {
                this.l = (VoiceData$VoiceModel) obj;
                this.f4274i.setText(getResources().getText(R.string.voice_restart));
                return;
            }
            k();
        }
    }

    @Override // d.a.p0.x.n
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            SkinManager.setViewTextColor(this.f4274i, R.color.CAM_X0106, 1, i2);
            SkinManager.setViewTextColor(this.f4273h, R.color.CAM_X0302, 1, i2);
            SkinManager.setBackgroundResource(this.f4271f, R.drawable.ic_post_record, i2);
            this.f4272g.f(i2);
        }
    }

    @Override // d.a.d.e.q.f
    public void onDeletedVoice(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
        }
    }

    @Override // d.a.d.e.q.f
    public void onSendVoice(String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048591, this, str, i2) == null) || TextUtils.isEmpty(str) || i2 <= 0) {
            return;
        }
        VoiceData$VoiceModel voiceData$VoiceModel = new VoiceData$VoiceModel();
        this.l = voiceData$VoiceModel;
        voiceData$VoiceModel.duration = i2;
        voiceData$VoiceModel.isLocal = true;
        voiceData$VoiceModel.voiceId = str;
        voiceData$VoiceModel.voice_status = 1;
        this.f4274i.setText(getResources().getText(R.string.voice_restart));
        d(new d.a.p0.x.a(10, -1, this.l));
    }

    @Override // d.a.d.e.q.f
    public void onShowErr(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048592, this, i2, str) == null) {
            this.f4273h.setVisibility(0);
            this.f4273h.setText(str);
            postDelayed(new d(this), 2000L);
        }
    }

    @Override // d.a.d.e.q.f
    public void onShowRecordTime(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.f4273h.setText(VoiceManager.formatVoiceTime(i2));
        }
    }

    @Override // d.a.d.e.q.f
    public void onShowRecording(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
        }
    }

    @Override // d.a.d.e.q.f
    public void onStartedRecorder(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048595, this, z) == null) && z) {
            this.f4271f.setVisibility(4);
            this.f4272g.setVisibility(0);
            this.f4272g.h();
            this.f4274i.setText(getResources().getText(R.string.voice_record_release_to_stop));
        }
    }

    @Override // d.a.d.e.q.f
    public void onStopingRecorder() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
        }
    }

    @Override // d.a.p0.x.n
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, editorTools) == null) {
            this.j = editorTools;
        }
    }

    @Override // d.a.p0.x.n
    public void setToolId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.k = i2;
        }
    }
}

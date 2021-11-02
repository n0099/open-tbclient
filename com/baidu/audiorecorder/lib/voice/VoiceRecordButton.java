package com.baidu.audiorecorder.lib.voice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.a.j;
import b.a.q0.s.s.a;
import b.a.q0.x.n;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.voice.VoiceButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
/* loaded from: classes7.dex */
public class VoiceRecordButton extends ViewGroup implements View.OnClickListener, b.a.e.e.q.f, VoiceManager.i, n {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int SKIN_TYPE_NIGHT = 1;
    public static final int SKIN_TYPE_NONE = -1;
    public static final int SKIN_TYPE_NORMAL = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public Paint A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public final BitmapDrawable J;
    public final Paint K;
    public final Rect L;
    public final RectF M;
    public TextView N;
    public TextView O;
    public TextView P;
    public TextView Q;
    public VoiceButton R;
    public ImageView S;
    public TextView T;
    public float U;
    public float V;
    public b.a.q0.s.s.a W;
    public long a0;
    public long b0;
    public EditorTools c0;

    /* renamed from: e  reason: collision with root package name */
    public long f36502e;

    /* renamed from: f  reason: collision with root package name */
    public final int[] f36503f;

    /* renamed from: g  reason: collision with root package name */
    public int f36504g;

    /* renamed from: h  reason: collision with root package name */
    public int f36505h;

    /* renamed from: i  reason: collision with root package name */
    public final int f36506i;
    public int i0;
    public final int j;
    public final int[] j0;
    public final int k;
    public final g k0;
    public final int l;
    public SweepGradient l0;
    public final int m;
    public VoiceData$VoiceModel m0;
    public int n;
    public int n0;
    public int o;
    public int o0;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public Paint x;
    public Paint y;
    public Paint z;

    /* loaded from: classes7.dex */
    public class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VoiceRecordButton f36507e;

        public a(VoiceRecordButton voiceRecordButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voiceRecordButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36507e = voiceRecordButton;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.l3.r0.a f36508e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VoiceRecordButton f36509f;

        public b(VoiceRecordButton voiceRecordButton, b.a.r0.l3.r0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voiceRecordButton, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36509f = voiceRecordButton;
            this.f36508e = aVar;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            VoiceData$VoiceModel voiceData$VoiceModel;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                this.f36509f.o();
                if (this.f36509f.getVoiceManager() == null || (voiceData$VoiceModel = this.f36509f.m0) == null) {
                    return;
                }
                b.a.r0.l3.r0.a aVar2 = this.f36508e;
                if (aVar2 != null) {
                    aVar2.b(voiceData$VoiceModel.voiceId);
                }
                this.f36509f.m0 = null;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VoiceRecordButton f36510e;

        public c(VoiceRecordButton voiceRecordButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voiceRecordButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36510e = voiceRecordButton;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f36510e.Q == null) {
                return;
            }
            this.f36510e.Q.setVisibility(4);
            this.f36510e.Q.setText("");
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VoiceRecordButton f36511e;

        public d(VoiceRecordButton voiceRecordButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voiceRecordButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36511e = voiceRecordButton;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f36511e.O == null) {
                return;
            }
            this.f36511e.O.setVisibility(4);
            this.f36511e.O.setText("");
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VoiceRecordButton f36512e;

        public e(VoiceRecordButton voiceRecordButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voiceRecordButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36512e = voiceRecordButton;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f36512e.O == null) {
                return;
            }
            this.f36512e.O.setVisibility(4);
            this.f36512e.O.setText("");
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VoiceRecordButton f36513e;

        public f(VoiceRecordButton voiceRecordButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voiceRecordButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36513e = voiceRecordButton;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f36513e.O == null) {
                return;
            }
            this.f36513e.O.setVisibility(4);
            this.f36513e.O.setText("");
        }
    }

    /* loaded from: classes7.dex */
    public class g extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VoiceRecordButton f36514a;

        public g(VoiceRecordButton voiceRecordButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voiceRecordButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36514a = voiceRecordButton;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1) {
                if (this.f36514a.V >= 360.0f) {
                    this.f36514a.V = 360.0f;
                    this.f36514a.o = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    this.f36514a.a0 = uptimeMillis;
                    this.f36514a.b0 = uptimeMillis + 200;
                    this.f36514a.V += this.f36514a.U * (((float) (uptimeMillis - this.f36514a.a0)) / 1000.0f);
                    sendEmptyMessageAtTime(1, this.f36514a.b0);
                    VoiceRecordButton.j(this.f36514a);
                }
                VoiceRecordButton voiceRecordButton = this.f36514a;
                voiceRecordButton.n = voiceRecordButton.o % 6;
                this.f36514a.invalidate();
            }
        }

        public /* synthetic */ g(VoiceRecordButton voiceRecordButton, a aVar) {
            this(voiceRecordButton);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VoiceRecordButton(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static VoiceRecordButton instance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) ? new VoiceRecordButton(context) : (VoiceRecordButton) invokeL.objValue;
    }

    public static /* synthetic */ int j(VoiceRecordButton voiceRecordButton) {
        int i2 = voiceRecordButton.o;
        voiceRecordButton.o = i2 + 1;
        return i2;
    }

    public void deleteVoiceModel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            o();
            if (getVoiceManager() == null || getVoiceManager().getRecorderManager() == null || this.m0 == null) {
                return;
            }
            getVoiceManager().getRecorderManager().b(this.m0.voiceId);
            this.m0 = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            drawCircle(canvas);
            super.dispatchDraw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSetPressed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
        }
    }

    @Override // b.a.q0.x.n
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setVisibility(0);
        }
    }

    public void drawCircle(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.x.setColor(this.F);
                this.y.setColor(this.G);
                this.z.setColor(this.H);
                this.A.setColor(this.I);
            } else {
                this.x.setColor(this.B);
                this.y.setColor(this.C);
                this.z.setColor(this.D);
                this.A.setColor(this.E);
            }
            int i2 = this.n;
            if (i2 == 2) {
                canvas.drawCircle(this.p, this.q, this.r, this.x);
            } else if (i2 == 3) {
                canvas.drawCircle(this.p, this.q, this.r, this.x);
                canvas.drawCircle(this.p, this.q, this.s, this.y);
            } else if (i2 == 4) {
                canvas.drawCircle(this.p, this.q, this.r, this.x);
                canvas.drawCircle(this.p, this.q, this.s, this.y);
                canvas.drawCircle(this.p, this.q, this.t, this.z);
            } else if (i2 == 5) {
                canvas.drawCircle(this.p, this.q, this.r, this.x);
                canvas.drawCircle(this.p, this.q, this.s, this.y);
                canvas.drawCircle(this.p, this.q, this.t, this.z);
                canvas.drawCircle(this.p, this.q, this.u, this.A);
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceManager.i getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this : (VoiceManager.i) invokeV.objValue;
    }

    public b.a.r0.l3.r0.a getRecorderManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager == null || voiceManager.getRecorderManager() == null) {
                return null;
            }
            return voiceManager.getRecorderManager();
        }
        return (b.a.r0.l3.r0.a) invokeV.objValue;
    }

    @Override // b.a.q0.x.n
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.i0 : invokeV.intValue;
    }

    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Context context = getContext();
            if (context instanceof VoiceManager.j) {
                return ((VoiceManager.j) context).getVoiceManager();
            }
            return null;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceData$VoiceModel getVoiceModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.m0 : (VoiceData$VoiceModel) invokeV.objValue;
    }

    @Override // b.a.q0.x.n
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            setVisibility(8);
        }
    }

    @Override // b.a.q0.x.n
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    public void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, context) == null) {
            p(context);
            initCirclePaints();
            this.j0[0] = SkinManager.getColor(R.color.common_color_10151);
            this.j0[1] = SkinManager.getColor(R.color.common_color_10152);
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(false);
            }
        }
    }

    public void initCirclePaints() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            Paint paint = new Paint();
            this.x = paint;
            paint.setAntiAlias(true);
            this.x.setStyle(Paint.Style.STROKE);
            this.x.setStrokeWidth(2.0f);
            Paint paint2 = new Paint();
            this.y = paint2;
            paint2.setAntiAlias(true);
            this.y.setStyle(Paint.Style.STROKE);
            this.y.setStrokeWidth(2.0f);
            Paint paint3 = new Paint();
            this.z = paint3;
            paint3.setAntiAlias(true);
            this.z.setStyle(Paint.Style.STROKE);
            this.z.setStrokeWidth(2.0f);
            Paint paint4 = new Paint();
            this.A = paint4;
            paint4.setAntiAlias(true);
            this.A.setStyle(Paint.Style.STROKE);
            this.A.setStrokeWidth(2.0f);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            SkinManager.setImageResource(this.R, R.drawable.but_posts_record_zero_selector);
            this.R.setVisibility(0);
            this.n = 0;
            this.S.setVisibility(4);
            this.T.setVisibility(4);
            this.N.setVisibility(4);
            this.Q.setVisibility(4);
            SkinManager.setViewTextColor(this.P, R.color.CAM_X0301, 1);
            this.P.setText(getContext().getString(R.string.voice_record_press_to_record));
        }
    }

    @Override // b.a.q0.x.b
    public void onAction(b.a.q0.x.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) || aVar == null) {
            return;
        }
        if (aVar.f14195a == 9) {
            reset();
            sendAction(new b.a.q0.x.a(2, 6, null));
        }
        if (aVar.f14195a == 52) {
            if (aVar.f14197c instanceof VoiceData$VoiceModel) {
                s();
                onRefreshByPlayStatus((VoiceData$VoiceModel) aVar.f14197c);
                this.m0 = (VoiceData$VoiceModel) aVar.f14197c;
                return;
            }
            reset();
            sendAction(new b.a.q0.x.a(2, 6, null));
        }
    }

    @Override // b.a.q0.x.n
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        VoiceData$VoiceModel voiceData$VoiceModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, view) == null) || view == null || (voiceManager = getVoiceManager()) == null) {
            return;
        }
        int id = view.getId();
        if (id == R.id.restart) {
            voiceManager.stopPlay();
            r();
        } else if (id != R.id.play_img || (voiceData$VoiceModel = this.m0) == null) {
        } else {
            if (voiceData$VoiceModel.voice_status.intValue() == 3) {
                voiceManager.stopPlay();
            } else if (this.m0.voice_status.intValue() == 1) {
                voiceManager.setAllowChangeVoiceMode(false);
                voiceManager.startPlay(this);
            }
        }
    }

    @Override // b.a.e.e.q.f
    public void onDeletedVoice(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.m0 = null;
            sendAction(new b.a.q0.x.a(11, -1, str));
            sendAction(new b.a.q0.x.a(2, 6, null));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onDetachedFromWindow();
            if (getVoiceManager() == null) {
                return;
            }
            getVoiceManager().stopPlay();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int i6 = i4 - i2;
            int measuredWidth = this.R.getMeasuredWidth();
            int measuredHeight = this.R.getMeasuredHeight();
            int measuredWidth2 = this.O.getMeasuredWidth();
            int measuredHeight2 = this.O.getMeasuredHeight();
            int i7 = this.f36504g;
            this.O.layout((i6 - measuredWidth2) >> 1, i3 + i7, (measuredWidth2 + i6) >> 1, i7 + i3 + measuredHeight2);
            int bottom = this.O.getBottom();
            int i8 = (i6 - measuredWidth) >> 1;
            this.R.layout(i8, bottom, (i6 + measuredWidth) >> 1, bottom + measuredHeight);
            this.p = (measuredWidth / 2) + i8;
            this.q = (measuredHeight / 2) + bottom;
            int measuredWidth3 = this.Q.getMeasuredWidth();
            int measuredHeight3 = this.Q.getMeasuredHeight();
            int top = this.R.getTop();
            this.Q.layout((i6 - measuredWidth3) >> 1, top - measuredHeight3, (measuredWidth3 + i6) >> 1, top);
            int measuredWidth4 = this.N.getMeasuredWidth();
            int measuredHeight4 = this.N.getMeasuredHeight();
            this.R.getRight();
            this.R.getBottom();
            TextView textView = this.N;
            int i9 = this.v;
            int i10 = this.w;
            textView.layout(i8 + i9, bottom + i10, i8 + i9 + measuredWidth4, i10 + bottom + measuredHeight4);
            int measuredWidth5 = this.S.getMeasuredWidth();
            this.S.layout((i6 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i6) >> 1, this.S.getMeasuredHeight() + bottom);
            int measuredWidth6 = this.T.getMeasuredWidth();
            this.T.layout((i6 - measuredWidth6) >> 1, (this.N.getTop() - this.T.getMeasuredHeight()) - this.j, (measuredWidth6 + i6) >> 1, (i3 + this.N.getTop()) - this.j);
            this.R.getLeft();
            this.R.getRight();
            int measuredWidth7 = this.P.getMeasuredWidth();
            int measuredHeight5 = this.P.getMeasuredHeight();
            int bottom2 = this.R.getBottom();
            int[] iArr = this.f36503f;
            this.P.layout((i6 - measuredWidth7) >> 1, iArr[3] + bottom2, (measuredWidth7 + i6) >> 1, bottom2 + iArr[3] + measuredHeight5);
            this.L.set((i6 - this.J.getIntrinsicWidth()) >> 1, this.S.getTop() - this.k, (i6 + this.J.getIntrinsicHeight()) >> 1, (this.S.getTop() + this.J.getIntrinsicHeight()) - this.k);
            this.J.setBounds(this.L);
            this.M.set(this.S.getLeft() + (this.l >> 1) + this.m, this.S.getTop() + (this.l >> 1) + this.m, (this.S.getRight() - (this.l >> 1)) - this.m, (this.S.getBottom() - (this.l >> 1)) - this.m);
            if (this.l0 == null) {
                this.l0 = new SweepGradient(this.M.centerX(), this.M.centerY(), this.j0, new float[]{0.0f, 0.7f});
                Matrix matrix = new Matrix();
                this.l0.getLocalMatrix(matrix);
                matrix.postRotate(-90.0f, this.M.centerX(), this.M.centerY());
                this.l0.setLocalMatrix(matrix);
                this.K.setShader(this.l0);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048597, this, i2, i3) == null) {
            int i4 = i2 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            int i5 = i3 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (childAt != null) {
                    measureChild(childAt, i4 - 2147483648, Integer.MIN_VALUE + i5);
                }
            }
            setMeasuredDimension(i4, i5);
            this.f36504g = getContext().getResources().getDimensionPixelSize(R.dimen.ds6) + ((i5 - getContext().getResources().getDimensionPixelSize(R.dimen.ds460)) / 2);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void onPlayElapse(int i2) {
        VoiceData$VoiceModel voiceData$VoiceModel;
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048598, this, i2) == null) || (voiceData$VoiceModel = this.m0) == null || (textView = this.T) == null) {
            return;
        }
        int i3 = i2 / 1000;
        if (this.o0 != i3) {
            textView.setText(VoiceManager.formatVoiceTime(voiceData$VoiceModel.duration - i3));
        }
        this.o0 = i3;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void onPlayPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void onRefreshByPlayStatus(VoiceData$VoiceModel voiceData$VoiceModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, voiceData$VoiceModel) == null) || this.S == null || this.T == null) {
            return;
        }
        int intValue = voiceData$VoiceModel.voice_status.intValue();
        if (intValue == 1) {
            SkinManager.setViewTextColor(this.T, R.color.CAM_X0106, 1);
            this.T.setText(VoiceManager.formatVoiceTime(voiceData$VoiceModel.duration));
            SkinManager.setImageResource(this.S, R.drawable.but_posts_record_play_selector);
            this.S.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(voiceData$VoiceModel.duration)));
            this.P.setText(getContext().getString(R.string.voice_play_tip));
            t();
        } else if (intValue != 3) {
        } else {
            SkinManager.setViewTextColor(this.T, R.color.CAM_X0106, 1);
            SkinManager.setImageResource(this.S, R.drawable.but_posts_record_stop_selector);
            this.S.setContentDescription(getContext().getString(R.string.pause_load));
            this.P.setText(getContext().getString(R.string.voice_stop_tip));
            q();
        }
    }

    @Override // b.a.e.e.q.f
    public void onSendVoice(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048601, this, str, i2) == null) {
            this.O.setVisibility(4);
            VoiceData$VoiceModel voiceData$VoiceModel = new VoiceData$VoiceModel();
            voiceData$VoiceModel.duration = i2;
            voiceData$VoiceModel.isLocal = true;
            voiceData$VoiceModel.voiceId = str;
            voiceData$VoiceModel.voice_status = 1;
            recorderFinish(voiceData$VoiceModel);
        }
    }

    @Override // b.a.e.e.q.f
    public void onShowErr(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048602, this, i2, str) == null) {
            SkinManager.setViewTextColor(this.Q, R.color.CAM_X0101, 1);
            SkinManager.setViewTextColor(this.O, R.color.CAM_X0101, 1);
            SkinManager.setViewTextColor(this.P, R.color.CAM_X0108, 1);
            if (StringUtils.isNull(str)) {
                return;
            }
            if (i2 == 3) {
                this.Q.setVisibility(0);
                this.Q.setText(str);
                postDelayed(new c(this), 2000L);
            } else if (i2 == 2) {
                this.O.setVisibility(0);
                this.O.setText(str);
                this.P.setText(R.string.voice_record_press_to_record);
                postDelayed(new d(this), 2000L);
            } else if (i2 == 5) {
                this.O.setVisibility(0);
                this.O.setText(str);
                postDelayed(new e(this), 2000L);
            } else {
                o();
                this.O.setVisibility(0);
                this.O.setText(str);
                postDelayed(new f(this), 2000L);
            }
        }
    }

    @Override // b.a.e.e.q.f
    public void onShowRecordTime(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            SkinManager.setViewTextColor(this.O, R.color.CAM_X0101, 1);
            this.O.setVisibility(0);
            this.O.setText(VoiceManager.formatVoiceTime(i2));
        }
    }

    @Override // b.a.e.e.q.f
    public void onShowRecording(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.n0 = Math.max(i2, this.n0);
            long uptimeMillis = SystemClock.uptimeMillis();
            if (uptimeMillis - this.f36502e > 200) {
                this.n0 = 0;
                this.f36502e = uptimeMillis;
            }
            int i3 = this.n0;
            if (i3 < 10) {
                this.n = 1;
                invalidate();
            } else if (i3 < 20) {
                this.n = 2;
                invalidate();
            } else if (i3 < 30) {
                this.n = 3;
                invalidate();
            } else if (i3 < 40) {
                this.n = 4;
                invalidate();
            } else {
                this.n = 5;
                invalidate();
            }
        }
    }

    @Override // b.a.e.e.q.f
    public void onStartedRecorder(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048605, this, z) == null) && z) {
            o();
            this.P.setText(getContext().getString(R.string.voice_record_release_to_stop));
        }
    }

    @Override // b.a.e.e.q.f
    public void onStopingRecorder() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
        }
    }

    public final void p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.record_voice_area, (ViewGroup) this, true);
            setClickable(true);
            TextView textView = (TextView) findViewById(R.id.tip_error);
            this.O = textView;
            SkinManager.setViewTextColor(textView, R.color.CAM_X0101, 1);
            this.P = (TextView) findViewById(R.id.tip_operator);
            this.Q = (TextView) findViewById(R.id.tip_time_out);
            this.R = (VoiceButton) findViewById(R.id.voice_bnt);
            this.N = (TextView) findViewById(R.id.restart);
            this.S = (ImageView) findViewById(R.id.play_img);
            TextView textView2 = (TextView) findViewById(R.id.play_time);
            this.T = textView2;
            textView2.setClickable(false);
            this.N.setOnClickListener(this);
            this.S.setOnClickListener(this);
            this.R.setRecorderView(this);
            o();
        }
    }

    public final void q() {
        VoiceData$VoiceModel voiceData$VoiceModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (voiceData$VoiceModel = this.m0) == null) {
            return;
        }
        this.n = 0;
        int i2 = voiceData$VoiceModel.duration2;
        this.U = 360.0f / (i2 > 0 ? i2 / 1000.0f : voiceData$VoiceModel.duration);
        long uptimeMillis = SystemClock.uptimeMillis();
        this.a0 = uptimeMillis;
        long j = uptimeMillis + 200;
        this.b0 = j;
        this.k0.sendEmptyMessageAtTime(1, j);
        invalidate();
    }

    public final void r() {
        VoiceData$VoiceModel voiceData$VoiceModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            b.a.r0.l3.r0.a recorderManager = getRecorderManager();
            if (this.W == null) {
                b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(j.a(getContext()).getPageActivity());
                this.W = aVar;
                aVar.setMessage(getContext().getString(R.string.voice_restart_tip)).setPositiveButton(getContext().getString(R.string.voice_restart), new b(this, recorderManager)).setNegativeButton(getContext().getString(R.string.cancel), new a(this)).create(j.a(getContext()));
            }
            try {
                this.W.show();
            } catch (Exception unused) {
                if (getVoiceManager() == null || (voiceData$VoiceModel = this.m0) == null) {
                    return;
                }
                if (recorderManager != null) {
                    recorderManager.b(voiceData$VoiceModel.voiceId);
                }
                this.m0 = null;
            }
        }
    }

    public void recorderFinish(VoiceData$VoiceModel voiceData$VoiceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, voiceData$VoiceModel) == null) {
            this.m0 = voiceData$VoiceModel;
            this.O.setText("");
            this.O.setVisibility(4);
            this.n = 0;
            s();
            sendAction(new b.a.q0.x.a(10, -1, voiceData$VoiceModel));
            sendAction(new b.a.q0.x.a(2, 6, " "));
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            o();
            this.m0 = null;
            this.n = 0;
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.R.setVisibility(4);
            this.T.setVisibility(0);
            this.N.setVisibility(0);
            SkinManager.setViewTextColor(this.T, R.color.CAM_X0106, 1);
            SkinManager.setViewTextColor(this.N, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(this.N, R.drawable.but_posts_record_again_selector);
            this.S.setVisibility(0);
            VoiceData$VoiceModel voiceData$VoiceModel = this.m0;
            if (voiceData$VoiceModel != null) {
                this.T.setText(VoiceManager.formatVoiceTime(voiceData$VoiceModel.duration));
                this.S.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(this.m0.duration)));
                SkinManager.setImageResource(this.S, R.drawable.but_posts_record_play_selector);
            }
            SkinManager.setViewTextColor(this.P, R.color.CAM_X0108, 1);
            this.P.setText(getContext().getString(R.string.voice_play_tip));
        }
    }

    @Override // b.a.q0.x.n
    public void sendAction(b.a.q0.x.a aVar) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, aVar) == null) || (editorTools = this.c0) == null) {
            return;
        }
        editorTools.sendAction(aVar);
    }

    public void setCallback(b.a.i.a.a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, fVar) == null) {
        }
    }

    @Override // b.a.q0.x.n
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, editorTools) == null) {
            this.c0 = editorTools;
        }
    }

    @Override // b.a.q0.x.n
    public void setToolId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            this.i0 = i2;
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            if (getVisibility() == 0 && (i2 == 4 || i2 == 8)) {
                if (getVoiceManager() == null) {
                    return;
                }
                getVoiceManager().stopPlay();
            }
            super.setVisibility(i2);
        }
    }

    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048618, this) == null) || getVoiceManager() == null) {
            return;
        }
        getVoiceManager().stopPlay();
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.n = 0;
            this.o = 0;
            this.U = 0.0f;
            this.V = 0.0f;
            this.k0.removeMessages(1);
            ((ViewGroup) getParent()).invalidate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceRecordButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f36502e = 0L;
        this.f36503f = new int[4];
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.B = -1724676609;
        this.C = 1546880511;
        this.D = 674465279;
        this.E = 255034879;
        this.F = -1725669966;
        this.G = 1545887154;
        this.H = 673471922;
        this.I = 254041522;
        this.K = new Paint(1);
        this.L = new Rect();
        this.M = new RectF();
        this.i0 = 0;
        this.j0 = new int[2];
        this.k0 = new g(this, null);
        this.n0 = 0;
        this.o0 = 0;
        this.f36503f[0] = context.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.f36503f[1] = context.getResources().getDimensionPixelSize(R.dimen.ds8);
        this.f36503f[2] = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        this.f36503f[3] = context.getResources().getDimensionPixelSize(R.dimen.ds36);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.ds134);
        this.r = dimensionPixelSize;
        int dimensionPixelSize2 = dimensionPixelSize + context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.s = dimensionPixelSize2;
        int dimensionPixelSize3 = dimensionPixelSize2 + context.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.t = dimensionPixelSize3;
        this.u = dimensionPixelSize3 + context.getResources().getDimensionPixelSize(R.dimen.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.v = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.w = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.v = context.getResources().getDimensionPixelSize(R.dimen.ds70);
            this.w = context.getResources().getDimensionPixelSize(R.dimen.ds210);
        }
        this.f36504g = context.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.f36505h = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.f36506i = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.j = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.k = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.l = context.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.m = context.getResources().getDimensionPixelSize(R.dimen.ds2);
        this.K.setStyle(Paint.Style.STROKE);
        this.K.setStrokeWidth(this.l);
        this.J = (BitmapDrawable) getResources().getDrawable(R.drawable.dot_play_schedule);
        init(context);
    }
}

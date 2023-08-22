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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.tieba.jp5;
import com.baidu.tieba.l9;
import com.baidu.tieba.mi5;
import com.baidu.tieba.s45;
import com.baidu.tieba.si;
import com.baidu.tieba.tbadkCore.voice.VoiceButton;
import com.baidu.tieba.tha;
import com.baidu.tieba.uo;
import com.baidu.tieba.zh5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
/* loaded from: classes3.dex */
public class VoiceRecordButton extends ViewGroup implements View.OnClickListener, si, VoiceManager.IPlayView, mi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public final BitmapDrawable F;
    public final Paint G;
    public final Rect H;
    public final RectF I;
    public TextView J;
    public TextView K;
    public TextView L;
    public TextView M;
    public VoiceButton N;
    public ImageView O;
    public TextView P;
    public float Q;
    public float R;
    public s45 S;

    /* renamed from: T  reason: collision with root package name */
    public long f1039T;
    public long U;
    public EditorTools V;
    public int W;
    public long a;
    public final int[] a0;
    public final int[] b;
    public final g b0;
    public int c;
    public SweepGradient c0;
    public int d;
    public VoiceData.VoiceModel d0;
    public final int e;
    public int e0;
    public final int f;
    public int f0;
    public final int g;
    public final int h;
    public final int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public Paint t;
    public Paint u;
    public Paint v;
    public Paint w;
    public int x;
    public int y;
    public int z;

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSetPressed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.IPlayView
    public VoiceManager.IPlayView getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this : (VoiceManager.IPlayView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mi5
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    @Override // com.baidu.tieba.si
    public boolean isOnCancle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.mi5
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.IPlayView
    public void onPlayPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
        }
    }

    @Override // com.baidu.tieba.si
    public void onStopingRecorder() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
        }
    }

    public void setCallback(uo uoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, uoVar) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public class a implements s45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VoiceRecordButton a;

        public a(VoiceRecordButton voiceRecordButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voiceRecordButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = voiceRecordButton;
        }

        @Override // com.baidu.tieba.s45.e
        public void onClick(s45 s45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s45Var) == null) {
                s45Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements s45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tha a;
        public final /* synthetic */ VoiceRecordButton b;

        public b(VoiceRecordButton voiceRecordButton, tha thaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voiceRecordButton, thaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = voiceRecordButton;
            this.a = thaVar;
        }

        @Override // com.baidu.tieba.s45.e
        public void onClick(s45 s45Var) {
            VoiceData.VoiceModel voiceModel;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s45Var) == null) {
                s45Var.dismiss();
                this.b.p();
                if (this.b.getVoiceManager() == null || (voiceModel = this.b.d0) == null) {
                    return;
                }
                tha thaVar = this.a;
                if (thaVar != null) {
                    thaVar.b(voiceModel.getVoiceId());
                }
                this.b.d0 = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VoiceRecordButton a;

        public c(VoiceRecordButton voiceRecordButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voiceRecordButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = voiceRecordButton;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.M != null) {
                this.a.M.setVisibility(4);
                this.a.M.setText("");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VoiceRecordButton a;

        public d(VoiceRecordButton voiceRecordButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voiceRecordButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = voiceRecordButton;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.K != null) {
                this.a.K.setVisibility(4);
                this.a.K.setText("");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VoiceRecordButton a;

        public e(VoiceRecordButton voiceRecordButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voiceRecordButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = voiceRecordButton;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.K != null) {
                this.a.K.setVisibility(4);
                this.a.K.setText("");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VoiceRecordButton a;

        public f(VoiceRecordButton voiceRecordButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voiceRecordButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = voiceRecordButton;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.K != null) {
                this.a.K.setVisibility(4);
                this.a.K.setText("");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VoiceRecordButton a;

        public g(VoiceRecordButton voiceRecordButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voiceRecordButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = voiceRecordButton;
        }

        public /* synthetic */ g(VoiceRecordButton voiceRecordButton, a aVar) {
            this(voiceRecordButton);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1) {
                if (this.a.R < 360.0f) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    this.a.f1039T = uptimeMillis;
                    this.a.U = uptimeMillis + 200;
                    this.a.R += this.a.Q * (((float) (uptimeMillis - this.a.f1039T)) / 1000.0f);
                    sendEmptyMessageAtTime(1, this.a.U);
                    VoiceRecordButton.j(this.a);
                } else {
                    this.a.R = 360.0f;
                    this.a.k = 0;
                }
                VoiceRecordButton voiceRecordButton = this.a;
                voiceRecordButton.j = voiceRecordButton.k % 6;
                this.a.invalidate();
            }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, context) == null) {
            s(context);
            r();
            this.a0[0] = SkinManager.getColor(R.color.common_color_10151);
            this.a0[1] = SkinManager.getColor(R.color.common_color_10152);
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(false);
            }
        }
    }

    public void x(VoiceData.VoiceModel voiceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, voiceModel) == null) {
            this.d0 = voiceModel;
            this.K.setText("");
            this.K.setVisibility(4);
            this.j = 0;
            A();
            S(new zh5(10, -1, voiceModel));
            S(new zh5(2, 6, " "));
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0L;
        this.b = new int[4];
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.x = -1724676609;
        this.y = 1546880511;
        this.z = 674465279;
        this.A = 255034879;
        this.B = -1725669966;
        this.C = 1545887154;
        this.D = 673471922;
        this.E = 254041522;
        this.G = new Paint(1);
        this.H = new Rect();
        this.I = new RectF();
        this.W = 0;
        this.a0 = new int[2];
        this.b0 = new g(this, null);
        this.e0 = 0;
        this.f0 = 0;
        this.b[0] = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8);
        this.b[1] = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07041c);
        this.b[2] = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070399);
        this.b[3] = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070215);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07036c);
        this.n = dimensionPixelSize;
        int dimensionPixelSize2 = dimensionPixelSize + context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701b2);
        this.o = dimensionPixelSize2;
        int dimensionPixelSize3 = dimensionPixelSize2 + context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be);
        this.p = dimensionPixelSize3;
        this.q = dimensionPixelSize3 + context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070385);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.r = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.s = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.r = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070266);
            this.s = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070395);
        }
        this.c = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f0);
        this.d = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070359);
        this.e = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701b2);
        this.f = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224);
        this.g = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224);
        this.h = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070363);
        this.i = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d4);
        this.G.setStyle(Paint.Style.STROKE);
        this.G.setStrokeWidth(this.h);
        this.F = (BitmapDrawable) getResources().getDrawable(R.drawable.obfuscated_res_0x7f0805b7);
        q(context);
    }

    public static /* synthetic */ int j(VoiceRecordButton voiceRecordButton) {
        int i = voiceRecordButton.k;
        voiceRecordButton.k = i + 1;
        return i;
    }

    public static VoiceRecordButton t(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) {
            return new VoiceRecordButton(context);
        }
        return (VoiceRecordButton) invokeL.objValue;
    }

    @Override // com.baidu.tieba.mi5
    public void S(zh5 zh5Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, zh5Var) == null) && (editorTools = this.V) != null) {
            editorTools.D(zh5Var);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            o(canvas);
            super.dispatchDraw(canvas);
        }
    }

    @Override // com.baidu.tieba.si
    public void onDeletedVoice(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.d0 = null;
            S(new zh5(11, -1, str));
            S(new zh5(2, 6, null));
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.IPlayView
    public void onPlayElapse(int i) {
        VoiceData.VoiceModel voiceModel;
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048598, this, i) == null) && (voiceModel = this.d0) != null && (textView = this.P) != null) {
            int i2 = i / 1000;
            if (this.f0 != i2) {
                textView.setText(VoiceManager.formatVoiceTime(voiceModel.getDuration() - i2));
            }
            this.f0 = i2;
        }
    }

    @Override // com.baidu.tieba.si
    public void onShowRecordTime(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            SkinManager.setViewTextColor(this.K, R.color.CAM_X0101, 1);
            this.K.setVisibility(0);
            this.K.setText(VoiceManager.formatVoiceTime(i / 1000));
        }
    }

    @Override // com.baidu.tieba.mi5
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, editorTools) == null) {
            this.V = editorTools;
        }
    }

    @Override // com.baidu.tieba.mi5
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i) == null) {
            this.W = i;
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            if (getVisibility() == 0 && (i == 4 || i == 8)) {
                if (getVoiceManager() == null) {
                    return;
                }
                getVoiceManager().stopPlay();
            }
            super.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.si
    public void onSendVoice(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048601, this, str, i) == null) {
            this.K.setVisibility(4);
            VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
            voiceModel.setDuration(i);
            voiceModel.isLocal = true;
            voiceModel.setVoiceId(str);
            voiceModel.voice_status = 1;
            x(voiceModel);
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.N.setVisibility(4);
            this.P.setVisibility(0);
            this.J.setVisibility(0);
            SkinManager.setViewTextColor(this.P, R.color.CAM_X0106, 1);
            SkinManager.setViewTextColor(this.J, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(this.J, R.drawable.but_posts_record_again_selector);
            this.O.setVisibility(0);
            VoiceData.VoiceModel voiceModel = this.d0;
            if (voiceModel != null) {
                this.P.setText(VoiceManager.formatVoiceTime(voiceModel.getDuration()));
                this.O.setContentDescription(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f0b99), Integer.valueOf(this.d0.getDuration())));
                SkinManager.setImageResource(this.O, R.drawable.but_posts_record_play_selector);
            }
            SkinManager.setViewTextColor(this.L, R.color.CAM_X0108, 1);
            this.L.setText(getContext().getString(R.string.obfuscated_res_0x7f0f1859));
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            Paint paint = new Paint();
            this.t = paint;
            paint.setAntiAlias(true);
            this.t.setStyle(Paint.Style.STROKE);
            this.t.setStrokeWidth(2.0f);
            Paint paint2 = new Paint();
            this.u = paint2;
            paint2.setAntiAlias(true);
            this.u.setStyle(Paint.Style.STROKE);
            this.u.setStrokeWidth(2.0f);
            Paint paint3 = new Paint();
            this.v = paint3;
            paint3.setAntiAlias(true);
            this.v.setStyle(Paint.Style.STROKE);
            this.v.setStrokeWidth(2.0f);
            Paint paint4 = new Paint();
            this.w = paint4;
            paint4.setAntiAlias(true);
            this.w.setStyle(Paint.Style.STROKE);
            this.w.setStrokeWidth(2.0f);
        }
    }

    public final void z() {
        VoiceData.VoiceModel voiceModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            tha recorderManager = getRecorderManager();
            if (this.S == null) {
                s45 s45Var = new s45(l9.a(getContext()).getPageActivity());
                this.S = s45Var;
                s45Var.setMessage(getContext().getString(R.string.obfuscated_res_0x7f0f1861)).setPositiveButton(getContext().getString(R.string.obfuscated_res_0x7f0f1860), new b(this, recorderManager)).setNegativeButton(getContext().getString(R.string.obfuscated_res_0x7f0f03cf), new a(this)).create(l9.a(getContext()));
            }
            try {
                this.S.show();
            } catch (Exception unused) {
                if (getVoiceManager() != null && (voiceModel = this.d0) != null) {
                    if (recorderManager != null) {
                        recorderManager.b(voiceModel.getVoiceId());
                    }
                    this.d0 = null;
                }
            }
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.j = 0;
            this.k = 0;
            this.Q = 0.0f;
            this.R = 0.0f;
            this.b0.removeMessages(1);
            ((ViewGroup) getParent()).invalidate();
        }
    }

    @Override // com.baidu.tieba.mi5
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            setVisibility(0);
        }
    }

    public tha getRecorderManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.getRecorderManager() != null) {
                return voiceManager.getRecorderManager();
            }
            return null;
        }
        return (tha) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mi5
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.W;
        }
        return invokeV.intValue;
    }

    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            Context context = getContext();
            if (context instanceof VoiceManager.i) {
                return ((VoiceManager.i) context).G0();
            }
            return null;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.IPlayView
    public VoiceData.VoiceModel getVoiceModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.d0;
        }
        return (VoiceData.VoiceModel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mi5
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            setVisibility(8);
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

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            p();
            this.d0 = null;
            this.j = 0;
        }
    }

    @Override // com.baidu.tieba.ai5
    public void E(zh5 zh5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zh5Var) != null) || zh5Var == null) {
            return;
        }
        if (zh5Var.a == 9) {
            y();
            S(new zh5(2, 6, null));
        }
        if (zh5Var.a == 52) {
            if (zh5Var.c instanceof VoiceData.VoiceModel) {
                A();
                onRefreshByPlayStatus((VoiceData.VoiceModel) zh5Var.c);
                this.d0 = (VoiceData.VoiceModel) zh5Var.c;
                return;
            }
            y();
            S(new zh5(2, 6, null));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        VoiceManager voiceManager;
        VoiceData.VoiceModel voiceModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048593, this, view2) != null) || view2 == null || (voiceManager = getVoiceManager()) == null) {
            return;
        }
        int id = view2.getId();
        if (id == R.id.obfuscated_res_0x7f091f0e) {
            voiceManager.stopPlay();
            z();
        } else if (id == R.id.obfuscated_res_0x7f091cc4 && (voiceModel = this.d0) != null) {
            if (voiceModel.voice_status.intValue() == 3) {
                voiceManager.stopPlay();
            } else if (this.d0.voice_status.intValue() == 1) {
                voiceManager.setAllowChangeVoiceMode(false);
                voiceManager.startPlay(this);
            }
        }
    }

    @Override // com.baidu.tieba.si
    public void onShowRecording(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.e0 = Math.max(i, this.e0);
            long uptimeMillis = SystemClock.uptimeMillis();
            if (uptimeMillis - this.a > 200) {
                this.e0 = 0;
                this.a = uptimeMillis;
            }
            int i2 = this.e0;
            if (i2 < 10) {
                this.j = 1;
                invalidate();
            } else if (i2 < 20) {
                this.j = 2;
                invalidate();
            } else if (i2 < 30) {
                this.j = 3;
                invalidate();
            } else if (i2 < 40) {
                this.j = 4;
                invalidate();
            } else {
                this.j = 5;
                invalidate();
            }
        }
    }

    public void o(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, canvas) == null) {
            boolean z = true;
            if (TbadkCoreApplication.getInst().getSkinType() != 1) {
                z = false;
            }
            if (z) {
                this.t.setColor(this.B);
                this.u.setColor(this.C);
                this.v.setColor(this.D);
                this.w.setColor(this.E);
            } else {
                this.t.setColor(this.x);
                this.u.setColor(this.y);
                this.v.setColor(this.z);
                this.w.setColor(this.A);
            }
            int i = this.j;
            if (i == 2) {
                canvas.drawCircle(this.l, this.m, this.n, this.t);
            } else if (i == 3) {
                canvas.drawCircle(this.l, this.m, this.n, this.t);
                canvas.drawCircle(this.l, this.m, this.o, this.u);
            } else if (i == 4) {
                canvas.drawCircle(this.l, this.m, this.n, this.t);
                canvas.drawCircle(this.l, this.m, this.o, this.u);
                canvas.drawCircle(this.l, this.m, this.p, this.v);
            } else if (i == 5) {
                canvas.drawCircle(this.l, this.m, this.n, this.t);
                canvas.drawCircle(this.l, this.m, this.o, this.u);
                canvas.drawCircle(this.l, this.m, this.p, this.v);
                canvas.drawCircle(this.l, this.m, this.q, this.w);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int i5 = i3 - i;
            int measuredWidth = this.N.getMeasuredWidth();
            int measuredHeight = this.N.getMeasuredHeight();
            int measuredWidth2 = this.K.getMeasuredWidth();
            int measuredHeight2 = this.K.getMeasuredHeight();
            int i6 = this.c;
            this.K.layout((i5 - measuredWidth2) >> 1, i2 + i6, (measuredWidth2 + i5) >> 1, i6 + i2 + measuredHeight2);
            int bottom = this.K.getBottom();
            int i7 = (i5 - measuredWidth) >> 1;
            this.N.layout(i7, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
            this.l = (measuredWidth / 2) + i7;
            this.m = (measuredHeight / 2) + bottom;
            int measuredWidth3 = this.M.getMeasuredWidth();
            int measuredHeight3 = this.M.getMeasuredHeight();
            int top = this.N.getTop();
            this.M.layout((i5 - measuredWidth3) >> 1, top - measuredHeight3, (measuredWidth3 + i5) >> 1, top);
            int measuredWidth4 = this.J.getMeasuredWidth();
            int measuredHeight4 = this.J.getMeasuredHeight();
            this.N.getRight();
            this.N.getBottom();
            TextView textView = this.J;
            int i8 = this.r;
            int i9 = this.s;
            textView.layout(i7 + i8, bottom + i9, i7 + i8 + measuredWidth4, i9 + bottom + measuredHeight4);
            int measuredWidth5 = this.O.getMeasuredWidth();
            this.O.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.O.getMeasuredHeight() + bottom);
            int measuredWidth6 = this.P.getMeasuredWidth();
            this.P.layout((i5 - measuredWidth6) >> 1, (this.J.getTop() - this.P.getMeasuredHeight()) - this.f, (measuredWidth6 + i5) >> 1, (i2 + this.J.getTop()) - this.f);
            this.N.getLeft();
            this.N.getRight();
            int measuredWidth7 = this.L.getMeasuredWidth();
            int measuredHeight5 = this.L.getMeasuredHeight();
            int bottom2 = this.N.getBottom();
            int[] iArr = this.b;
            this.L.layout((i5 - measuredWidth7) >> 1, iArr[3] + bottom2, (measuredWidth7 + i5) >> 1, bottom2 + iArr[3] + measuredHeight5);
            this.H.set((i5 - this.F.getIntrinsicWidth()) >> 1, this.O.getTop() - this.g, (i5 + this.F.getIntrinsicHeight()) >> 1, (this.O.getTop() + this.F.getIntrinsicHeight()) - this.g);
            this.F.setBounds(this.H);
            this.I.set(this.O.getLeft() + (this.h >> 1) + this.i, this.O.getTop() + (this.h >> 1) + this.i, (this.O.getRight() - (this.h >> 1)) - this.i, (this.O.getBottom() - (this.h >> 1)) - this.i);
            if (this.c0 == null) {
                this.c0 = new SweepGradient(this.I.centerX(), this.I.centerY(), this.a0, new float[]{0.0f, 0.7f});
                Matrix matrix = new Matrix();
                this.c0.getLocalMatrix(matrix);
                matrix.postRotate(-90.0f, this.I.centerX(), this.I.centerY());
                this.c0.setLocalMatrix(matrix);
                this.G.setShader(this.c0);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048597, this, i, i2) == null) {
            int i3 = i & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            int i4 = i2 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (childAt != null) {
                    measureChild(childAt, i3 - 2147483648, Integer.MIN_VALUE + i4);
                }
            }
            setMeasuredDimension(i3, i4);
            this.c = getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070400) + ((i4 - getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703e2)) / 2);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.IPlayView
    public void onRefreshByPlayStatus(VoiceData.VoiceModel voiceModel) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, voiceModel) == null) && this.O != null && this.P != null) {
            int intValue = voiceModel.voice_status.intValue();
            if (intValue != 1) {
                if (intValue == 3) {
                    SkinManager.setViewTextColor(this.P, R.color.CAM_X0106, 1);
                    SkinManager.setImageResource(this.O, R.drawable.but_posts_record_stop_selector);
                    this.O.setContentDescription(getContext().getString(R.string.pause_load));
                    this.L.setText(getContext().getString(R.string.obfuscated_res_0x7f0f1867));
                    u();
                    return;
                }
                return;
            }
            SkinManager.setViewTextColor(this.P, R.color.CAM_X0106, 1);
            this.P.setText(VoiceManager.formatVoiceTime(voiceModel.getDuration()));
            SkinManager.setImageResource(this.O, R.drawable.but_posts_record_play_selector);
            this.O.setContentDescription(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f0b99), Integer.valueOf(voiceModel.getDuration())));
            this.L.setText(getContext().getString(R.string.obfuscated_res_0x7f0f1859));
            if (jp5.b().d()) {
                jp5.b().n(false);
                jp5.b().l(false);
            }
            C();
        }
    }

    @Override // com.baidu.tieba.si
    public void onShowErr(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048602, this, i, str) == null) {
            SkinManager.setViewTextColor(this.M, R.color.CAM_X0101, 1);
            SkinManager.setViewTextColor(this.K, R.color.CAM_X0101, 1);
            SkinManager.setViewTextColor(this.L, R.color.CAM_X0108, 1);
            if (!StringUtils.isNull(str)) {
                if (i == 3) {
                    this.M.setVisibility(0);
                    this.M.setText(str);
                    postDelayed(new c(this), 2000L);
                } else if (i == 2) {
                    this.K.setVisibility(0);
                    this.K.setText(str);
                    this.L.setText(R.string.obfuscated_res_0x7f0f185a);
                    postDelayed(new d(this), 2000L);
                } else if (i == 5) {
                    this.K.setVisibility(0);
                    this.K.setText(str);
                    postDelayed(new e(this), 2000L);
                } else {
                    p();
                    this.K.setVisibility(0);
                    this.K.setText(str);
                    postDelayed(new f(this), 2000L);
                }
            }
        }
    }

    @Override // com.baidu.tieba.si
    public void onStartedRecorder(boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && z) {
            p();
            this.L.setText(getContext().getString(R.string.obfuscated_res_0x7f0f185b));
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            SkinManager.setImageResource(this.N, R.drawable.but_posts_record_zero_selector);
            this.N.setVisibility(0);
            this.j = 0;
            this.O.setVisibility(4);
            this.P.setVisibility(4);
            this.J.setVisibility(4);
            this.M.setVisibility(4);
            SkinManager.setViewTextColor(this.L, R.color.CAM_X0301, 1);
            this.L.setText(getContext().getString(R.string.obfuscated_res_0x7f0f185a));
        }
    }

    public final void s(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0868, (ViewGroup) this, true);
            setClickable(true);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f092574);
            this.K = textView;
            SkinManager.setViewTextColor(textView, R.color.CAM_X0101, 1);
            this.L = (TextView) findViewById(R.id.obfuscated_res_0x7f092584);
            this.M = (TextView) findViewById(R.id.obfuscated_res_0x7f092589);
            this.N = (VoiceButton) findViewById(R.id.obfuscated_res_0x7f0929cb);
            this.J = (TextView) findViewById(R.id.obfuscated_res_0x7f091f0e);
            this.O = (ImageView) findViewById(R.id.obfuscated_res_0x7f091cc4);
            TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f091cc7);
            this.P = textView2;
            textView2.setClickable(false);
            this.J.setOnClickListener(this);
            this.O.setOnClickListener(this);
            this.N.setRecorderView(this);
            p();
        }
    }

    public final void u() {
        VoiceData.VoiceModel voiceModel;
        float duration;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048615, this) != null) || (voiceModel = this.d0) == null) {
            return;
        }
        this.j = 0;
        int i = voiceModel.duration2;
        if (i > 0) {
            duration = i / 1000.0f;
        } else {
            duration = voiceModel.getDuration();
        }
        this.Q = 360.0f / duration;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.f1039T = uptimeMillis;
        long j = uptimeMillis + 200;
        this.U = j;
        this.b0.sendEmptyMessageAtTime(1, j);
        invalidate();
    }
}

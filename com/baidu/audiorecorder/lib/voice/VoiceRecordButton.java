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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.voice.VoiceButton;
import d.b.c.a.j;
import d.b.h0.r.s.a;
import d.b.h0.w.n;
/* loaded from: classes.dex */
public class VoiceRecordButton extends ViewGroup implements View.OnClickListener, d.b.c.e.q.f, VoiceManager.i, n {
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
    public d.b.h0.r.s.a W;
    public long a0;
    public long b0;
    public EditorTools c0;
    public int d0;

    /* renamed from: e  reason: collision with root package name */
    public long f4291e;
    public final int[] e0;

    /* renamed from: f  reason: collision with root package name */
    public final int[] f4292f;
    public final g f0;

    /* renamed from: g  reason: collision with root package name */
    public int f4293g;
    public SweepGradient g0;

    /* renamed from: h  reason: collision with root package name */
    public int f4294h;
    public VoiceData$VoiceModel h0;
    public final int i;
    public int i0;
    public final int j;
    public int j0;
    public final int k;
    public final int l;
    public final int m;
    public int n;
    public int o;
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

    /* loaded from: classes.dex */
    public class a implements a.e {
        public a() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.d3.p0.a f4296e;

        public b(d.b.i0.d3.p0.a aVar) {
            this.f4296e = aVar;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            VoiceData$VoiceModel voiceData$VoiceModel;
            aVar.dismiss();
            VoiceRecordButton.this.s();
            if (VoiceRecordButton.this.getVoiceManager() == null || (voiceData$VoiceModel = VoiceRecordButton.this.h0) == null) {
                return;
            }
            d.b.i0.d3.p0.a aVar2 = this.f4296e;
            if (aVar2 != null) {
                aVar2.a(voiceData$VoiceModel.voiceId);
            }
            VoiceRecordButton.this.h0 = null;
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VoiceRecordButton.this.Q != null) {
                VoiceRecordButton.this.Q.setVisibility(4);
                VoiceRecordButton.this.Q.setText("");
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VoiceRecordButton.this.O != null) {
                VoiceRecordButton.this.O.setVisibility(4);
                VoiceRecordButton.this.O.setText("");
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VoiceRecordButton.this.O != null) {
                VoiceRecordButton.this.O.setVisibility(4);
                VoiceRecordButton.this.O.setText("");
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VoiceRecordButton.this.O != null) {
                VoiceRecordButton.this.O.setVisibility(4);
                VoiceRecordButton.this.O.setText("");
            }
        }
    }

    /* loaded from: classes.dex */
    public class g extends Handler {
        public g() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                if (VoiceRecordButton.this.V >= 360.0f) {
                    VoiceRecordButton.this.V = 360.0f;
                    VoiceRecordButton.this.o = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    VoiceRecordButton.this.a0 = uptimeMillis;
                    VoiceRecordButton.this.b0 = uptimeMillis + 200;
                    VoiceRecordButton.this.V += VoiceRecordButton.this.U * (((float) (uptimeMillis - VoiceRecordButton.this.a0)) / 1000.0f);
                    sendEmptyMessageAtTime(1, VoiceRecordButton.this.b0);
                    VoiceRecordButton.m(VoiceRecordButton.this);
                }
                VoiceRecordButton voiceRecordButton = VoiceRecordButton.this;
                voiceRecordButton.n = voiceRecordButton.o % 6;
                VoiceRecordButton.this.invalidate();
            }
        }

        public /* synthetic */ g(VoiceRecordButton voiceRecordButton, a aVar) {
            this();
        }
    }

    public VoiceRecordButton(Context context) {
        this(context, null);
    }

    public static /* synthetic */ int m(VoiceRecordButton voiceRecordButton) {
        int i = voiceRecordButton.o;
        voiceRecordButton.o = i + 1;
        return i;
    }

    public static VoiceRecordButton x(Context context) {
        return new VoiceRecordButton(context);
    }

    public void A() {
        s();
        this.h0 = null;
        this.n = 0;
    }

    public final void B() {
        VoiceData$VoiceModel voiceData$VoiceModel;
        d.b.i0.d3.p0.a recorderManager = getRecorderManager();
        if (this.W == null) {
            d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(j.a(getContext()).getPageActivity());
            this.W = aVar;
            aVar.setMessage(getContext().getString(R.string.voice_restart_tip)).setPositiveButton(getContext().getString(R.string.voice_restart), new b(recorderManager)).setNegativeButton(getContext().getString(R.string.cancel), new a()).create(j.a(getContext()));
        }
        try {
            this.W.show();
        } catch (Exception unused) {
            if (getVoiceManager() == null || (voiceData$VoiceModel = this.h0) == null) {
                return;
            }
            if (recorderManager != null) {
                recorderManager.a(voiceData$VoiceModel.voiceId);
            }
            this.h0 = null;
        }
    }

    public final void E() {
        this.R.setVisibility(4);
        this.T.setVisibility(0);
        this.N.setVisibility(0);
        SkinManager.setViewTextColor(this.T, R.color.CAM_X0106, 1);
        SkinManager.setViewTextColor(this.N, R.color.CAM_X0106, 1);
        SkinManager.setBackgroundResource(this.N, R.drawable.but_posts_record_again_selector);
        this.S.setVisibility(0);
        VoiceData$VoiceModel voiceData$VoiceModel = this.h0;
        if (voiceData$VoiceModel != null) {
            this.T.setText(VoiceManager.formatVoiceTime(voiceData$VoiceModel.duration));
            this.S.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(this.h0.duration)));
            SkinManager.setImageResource(this.S, R.drawable.but_posts_record_play_selector);
        }
        SkinManager.setViewTextColor(this.P, R.color.CAM_X0108, 1);
        this.P.setText(getContext().getString(R.string.voice_play_tip));
    }

    public final void F() {
        this.n = 0;
        this.o = 0;
        this.U = 0.0f;
        this.V = 0.0f;
        this.f0.removeMessages(1);
        ((ViewGroup) getParent()).invalidate();
    }

    @Override // d.b.h0.w.n
    public void b() {
        setVisibility(0);
    }

    @Override // d.b.h0.w.n
    public void d(d.b.h0.w.a aVar) {
        EditorTools editorTools = this.c0;
        if (editorTools != null) {
            editorTools.A(aVar);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        r(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSetPressed(boolean z) {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceManager.i getRealView() {
        return this;
    }

    public d.b.i0.d3.p0.a getRecorderManager() {
        VoiceManager voiceManager = getVoiceManager();
        if (voiceManager == null || voiceManager.getRecorderManager() == null) {
            return null;
        }
        return voiceManager.getRecorderManager();
    }

    @Override // d.b.h0.w.n
    public int getToolId() {
        return this.d0;
    }

    public VoiceManager getVoiceManager() {
        Context context = getContext();
        if (context instanceof VoiceManager.j) {
            return ((VoiceManager.j) context).getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceData$VoiceModel getVoiceModel() {
        return this.h0;
    }

    @Override // d.b.h0.w.n
    public void hide() {
        setVisibility(8);
    }

    @Override // d.b.h0.w.n
    public void init() {
    }

    @Override // d.b.h0.w.b
    public void onAction(d.b.h0.w.a aVar) {
        if (aVar == null) {
            return;
        }
        if (aVar.f51942a == 9) {
            A();
            d(new d.b.h0.w.a(2, 6, null));
        }
        if (aVar.f51942a == 52) {
            if (aVar.f51944c instanceof VoiceData$VoiceModel) {
                E();
                onRefreshByPlayStatus((VoiceData$VoiceModel) aVar.f51944c);
                this.h0 = (VoiceData$VoiceModel) aVar.f51944c;
                return;
            }
            A();
            d(new d.b.h0.w.a(2, 6, null));
        }
    }

    @Override // d.b.h0.w.n
    public void onChangeSkinType(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        VoiceData$VoiceModel voiceData$VoiceModel;
        if (view == null || (voiceManager = getVoiceManager()) == null) {
            return;
        }
        int id = view.getId();
        if (id == R.id.restart) {
            voiceManager.stopPlay();
            B();
        } else if (id != R.id.play_img || (voiceData$VoiceModel = this.h0) == null) {
        } else {
            if (voiceData$VoiceModel.voice_status.intValue() == 3) {
                voiceManager.stopPlay();
            } else if (this.h0.voice_status.intValue() == 1) {
                voiceManager.setAllowChangeVoiceMode(false);
                voiceManager.startPlay(this);
            }
        }
    }

    @Override // d.b.c.e.q.f
    public void onDeletedVoice(String str) {
        this.h0 = null;
        d(new d.b.h0.w.a(11, -1, str));
        d(new d.b.h0.w.a(2, 6, null));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (getVoiceManager() == null) {
            return;
        }
        getVoiceManager().stopPlay();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.R.getMeasuredWidth();
        int measuredHeight = this.R.getMeasuredHeight();
        int measuredWidth2 = this.O.getMeasuredWidth();
        int measuredHeight2 = this.O.getMeasuredHeight();
        int i6 = this.f4293g;
        this.O.layout((i5 - measuredWidth2) >> 1, i2 + i6, (measuredWidth2 + i5) >> 1, i6 + i2 + measuredHeight2);
        int bottom = this.O.getBottom();
        int i7 = (i5 - measuredWidth) >> 1;
        this.R.layout(i7, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        this.p = (measuredWidth / 2) + i7;
        this.q = (measuredHeight / 2) + bottom;
        int measuredWidth3 = this.Q.getMeasuredWidth();
        int measuredHeight3 = this.Q.getMeasuredHeight();
        int top = this.R.getTop();
        this.Q.layout((i5 - measuredWidth3) >> 1, top - measuredHeight3, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.N.getMeasuredWidth();
        int measuredHeight4 = this.N.getMeasuredHeight();
        this.R.getRight();
        this.R.getBottom();
        TextView textView = this.N;
        int i8 = this.v;
        int i9 = this.w;
        textView.layout(i7 + i8, bottom + i9, i7 + i8 + measuredWidth4, i9 + bottom + measuredHeight4);
        int measuredWidth5 = this.S.getMeasuredWidth();
        this.S.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.S.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.T.getMeasuredWidth();
        this.T.layout((i5 - measuredWidth6) >> 1, (this.N.getTop() - this.T.getMeasuredHeight()) - this.j, (measuredWidth6 + i5) >> 1, (i2 + this.N.getTop()) - this.j);
        this.R.getLeft();
        this.R.getRight();
        int measuredWidth7 = this.P.getMeasuredWidth();
        int measuredHeight5 = this.P.getMeasuredHeight();
        int bottom2 = this.R.getBottom();
        int[] iArr = this.f4292f;
        this.P.layout((i5 - measuredWidth7) >> 1, iArr[3] + bottom2, (measuredWidth7 + i5) >> 1, bottom2 + iArr[3] + measuredHeight5);
        this.L.set((i5 - this.J.getIntrinsicWidth()) >> 1, this.S.getTop() - this.k, (i5 + this.J.getIntrinsicHeight()) >> 1, (this.S.getTop() + this.J.getIntrinsicHeight()) - this.k);
        this.J.setBounds(this.L);
        this.M.set(this.S.getLeft() + (this.l >> 1) + this.m, this.S.getTop() + (this.l >> 1) + this.m, (this.S.getRight() - (this.l >> 1)) - this.m, (this.S.getBottom() - (this.l >> 1)) - this.m);
        if (this.g0 == null) {
            this.g0 = new SweepGradient(this.M.centerX(), this.M.centerY(), this.e0, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.g0.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.M.centerX(), this.M.centerY());
            this.g0.setLocalMatrix(matrix);
            this.K.setShader(this.g0);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3 = i & 1073741823;
        int i4 = i2 & 1073741823;
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                measureChild(childAt, i3 - 2147483648, Integer.MIN_VALUE + i4);
            }
        }
        setMeasuredDimension(i3, i4);
        this.f4293g = getContext().getResources().getDimensionPixelSize(R.dimen.ds6) + ((i4 - getContext().getResources().getDimensionPixelSize(R.dimen.ds460)) / 2);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void onPlayElapse(int i) {
        TextView textView;
        VoiceData$VoiceModel voiceData$VoiceModel = this.h0;
        if (voiceData$VoiceModel == null || (textView = this.T) == null) {
            return;
        }
        int i2 = i / 1000;
        if (this.j0 != i2) {
            textView.setText(VoiceManager.formatVoiceTime(voiceData$VoiceModel.duration - i2));
        }
        this.j0 = i2;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void onPlayPrepared() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void onRefreshByPlayStatus(VoiceData$VoiceModel voiceData$VoiceModel) {
        if (this.S == null || this.T == null) {
            return;
        }
        int intValue = voiceData$VoiceModel.voice_status.intValue();
        if (intValue == 1) {
            SkinManager.setViewTextColor(this.T, R.color.CAM_X0106, 1);
            this.T.setText(VoiceManager.formatVoiceTime(voiceData$VoiceModel.duration));
            SkinManager.setImageResource(this.S, R.drawable.but_posts_record_play_selector);
            this.S.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(voiceData$VoiceModel.duration)));
            this.P.setText(getContext().getString(R.string.voice_play_tip));
            F();
        } else if (intValue != 3) {
        } else {
            SkinManager.setViewTextColor(this.T, R.color.CAM_X0106, 1);
            SkinManager.setImageResource(this.S, R.drawable.but_posts_record_stop_selector);
            this.S.setContentDescription(getContext().getString(R.string.pause_load));
            this.P.setText(getContext().getString(R.string.voice_stop_tip));
            y();
        }
    }

    @Override // d.b.c.e.q.f
    public void onSendVoice(String str, int i) {
        this.O.setVisibility(4);
        VoiceData$VoiceModel voiceData$VoiceModel = new VoiceData$VoiceModel();
        voiceData$VoiceModel.duration = i;
        voiceData$VoiceModel.isLocal = true;
        voiceData$VoiceModel.voiceId = str;
        voiceData$VoiceModel.voice_status = 1;
        z(voiceData$VoiceModel);
    }

    @Override // d.b.c.e.q.f
    public void onShowErr(int i, String str) {
        SkinManager.setViewTextColor(this.Q, R.color.CAM_X0101, 1);
        SkinManager.setViewTextColor(this.O, R.color.CAM_X0101, 1);
        SkinManager.setViewTextColor(this.P, R.color.CAM_X0108, 1);
        if (StringUtils.isNull(str)) {
            return;
        }
        if (i == 3) {
            this.Q.setVisibility(0);
            this.Q.setText(str);
            postDelayed(new c(), 2000L);
        } else if (i == 2) {
            this.O.setVisibility(0);
            this.O.setText(str);
            this.P.setText(R.string.voice_record_press_to_record);
            postDelayed(new d(), 2000L);
        } else if (i == 5) {
            this.O.setVisibility(0);
            this.O.setText(str);
            postDelayed(new e(), 2000L);
        } else {
            s();
            this.O.setVisibility(0);
            this.O.setText(str);
            postDelayed(new f(), 2000L);
        }
    }

    @Override // d.b.c.e.q.f
    public void onShowRecordTime(int i) {
        SkinManager.setViewTextColor(this.O, R.color.CAM_X0101, 1);
        this.O.setVisibility(0);
        this.O.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // d.b.c.e.q.f
    public void onShowRecording(int i) {
        this.i0 = Math.max(i, this.i0);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.f4291e > 200) {
            this.i0 = 0;
            this.f4291e = uptimeMillis;
        }
        int i2 = this.i0;
        if (i2 < 10) {
            this.n = 1;
            invalidate();
        } else if (i2 < 20) {
            this.n = 2;
            invalidate();
        } else if (i2 < 30) {
            this.n = 3;
            invalidate();
        } else if (i2 < 40) {
            this.n = 4;
            invalidate();
        } else {
            this.n = 5;
            invalidate();
        }
    }

    @Override // d.b.c.e.q.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            s();
            this.P.setText(getContext().getString(R.string.voice_record_release_to_stop));
        }
    }

    @Override // d.b.c.e.q.f
    public void onStopingRecorder() {
    }

    public void r(Canvas canvas) {
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
        int i = this.n;
        if (i == 2) {
            canvas.drawCircle(this.p, this.q, this.r, this.x);
        } else if (i == 3) {
            canvas.drawCircle(this.p, this.q, this.r, this.x);
            canvas.drawCircle(this.p, this.q, this.s, this.y);
        } else if (i == 4) {
            canvas.drawCircle(this.p, this.q, this.r, this.x);
            canvas.drawCircle(this.p, this.q, this.s, this.y);
            canvas.drawCircle(this.p, this.q, this.t, this.z);
        } else if (i == 5) {
            canvas.drawCircle(this.p, this.q, this.r, this.x);
            canvas.drawCircle(this.p, this.q, this.s, this.y);
            canvas.drawCircle(this.p, this.q, this.t, this.z);
            canvas.drawCircle(this.p, this.q, this.u, this.A);
        }
    }

    public final void s() {
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

    public void setCallback(d.b.f.a.a.f fVar) {
    }

    @Override // d.b.h0.w.n
    public void setEditorTools(EditorTools editorTools) {
        this.c0 = editorTools;
    }

    @Override // d.b.h0.w.n
    public void setToolId(int i) {
        this.d0 = i;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (getVisibility() == 0 && (i == 4 || i == 8)) {
            if (getVoiceManager() == null) {
                return;
            }
            getVoiceManager().stopPlay();
        }
        super.setVisibility(i);
    }

    public void u(Context context) {
        w(context);
        v();
        this.e0[0] = SkinManager.getColor(R.color.common_color_10151);
        this.e0[1] = SkinManager.getColor(R.color.common_color_10152);
        VoiceManager voiceManager = getVoiceManager();
        if (voiceManager != null) {
            voiceManager.setAllowChangeVoiceMode(false);
        }
    }

    public void v() {
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

    public final void w(Context context) {
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
        s();
    }

    public final void y() {
        VoiceData$VoiceModel voiceData$VoiceModel = this.h0;
        if (voiceData$VoiceModel == null) {
            return;
        }
        this.n = 0;
        int i = voiceData$VoiceModel.duration2;
        this.U = 360.0f / (i > 0 ? i / 1000.0f : voiceData$VoiceModel.duration);
        long uptimeMillis = SystemClock.uptimeMillis();
        this.a0 = uptimeMillis;
        long j = uptimeMillis + 200;
        this.b0 = j;
        this.f0.sendEmptyMessageAtTime(1, j);
        invalidate();
    }

    public void z(VoiceData$VoiceModel voiceData$VoiceModel) {
        this.h0 = voiceData$VoiceModel;
        this.O.setText("");
        this.O.setVisibility(4);
        this.n = 0;
        E();
        d(new d.b.h0.w.a(10, -1, voiceData$VoiceModel));
        d(new d.b.h0.w.a(2, 6, " "));
    }

    public VoiceRecordButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4291e = 0L;
        this.f4292f = new int[4];
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
        this.d0 = 0;
        this.e0 = new int[2];
        this.f0 = new g(this, null);
        this.i0 = 0;
        this.j0 = 0;
        this.f4292f[0] = context.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.f4292f[1] = context.getResources().getDimensionPixelSize(R.dimen.ds8);
        this.f4292f[2] = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        this.f4292f[3] = context.getResources().getDimensionPixelSize(R.dimen.ds36);
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
        this.f4293g = context.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.f4294h = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.i = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.j = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.k = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.l = context.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.m = context.getResources().getDimensionPixelSize(R.dimen.ds2);
        this.K.setStyle(Paint.Style.STROKE);
        this.K.setStrokeWidth(this.l);
        this.J = (BitmapDrawable) getResources().getDrawable(R.drawable.dot_play_schedule);
        u(context);
    }
}

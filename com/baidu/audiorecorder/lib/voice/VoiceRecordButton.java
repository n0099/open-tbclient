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
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.voice.VoiceButton;
/* loaded from: classes6.dex */
public class VoiceRecordButton extends ViewGroup implements View.OnClickListener, com.baidu.adp.lib.voice.f, VoiceManager.b, l {
    private EditorTools TA;
    private int TB;
    private com.baidu.tbadk.core.dialog.a TD;
    private int Ts;
    private long Tt;
    private int UB;
    private int UC;
    private int UD;
    private int UE;
    private int UF;
    private int UG;
    private int UH;
    private int UI;
    private final BitmapDrawable UJ;
    private final Paint UK;
    private final Rect UL;
    private final RectF UM;
    private TextView UN;
    private TextView UO;
    private TextView UQ;
    private TextView UR;
    private VoiceButton US;
    private ImageView UT;
    private TextView UU;
    private float UV;
    private float UW;
    private f UX;
    private long UY;
    private long UZ;
    private final int[] Uh;
    private int Ui;
    private final int Uj;
    private final int Uk;
    private final int Ul;
    private final int Um;
    private final int Un;
    private int Uo;
    private int Up;
    private int Uq;
    private int Ur;
    private int Us;
    private int Ut;
    private int Uu;
    private int Uv;
    private Paint Uw;
    private Paint Ux;
    private Paint Uy;
    private Paint Uz;
    private final int[] Va;
    private final a Vb;
    private SweepGradient Vc;
    private int Vd;
    private int centerX;
    private int centerY;
    VoiceData.VoiceModel mModel;
    private int mPaddingTop;

    static /* synthetic */ int e(VoiceRecordButton voiceRecordButton) {
        int i = voiceRecordButton.Up;
        voiceRecordButton.Up = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                if (VoiceRecordButton.this.UW >= 360.0f) {
                    VoiceRecordButton.this.UW = 360.0f;
                    VoiceRecordButton.this.Up = 0;
                } else {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    VoiceRecordButton.this.UY = uptimeMillis;
                    VoiceRecordButton.this.UZ = uptimeMillis + 200;
                    VoiceRecordButton.this.UW += (((float) (uptimeMillis - VoiceRecordButton.this.UY)) / 1000.0f) * VoiceRecordButton.this.UV;
                    sendEmptyMessageAtTime(1, VoiceRecordButton.this.UZ);
                    VoiceRecordButton.e(VoiceRecordButton.this);
                }
                VoiceRecordButton.this.Uo = VoiceRecordButton.this.Up % 6;
                VoiceRecordButton.this.invalidate();
            }
        }
    }

    public static VoiceRecordButton an(Context context) {
        return new VoiceRecordButton(context);
    }

    public VoiceRecordButton(Context context) {
        this(context, null);
    }

    public VoiceRecordButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Tt = 0L;
        this.Uh = new int[4];
        this.Uo = 0;
        this.Up = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.Uq = 0;
        this.Ur = 0;
        this.Us = 0;
        this.Ut = 0;
        this.Uu = 0;
        this.Uv = 0;
        this.UB = -1724676609;
        this.UC = 1546880511;
        this.UD = 674465279;
        this.UE = 255034879;
        this.UF = -1725669966;
        this.UG = 1545887154;
        this.UH = 673471922;
        this.UI = 254041522;
        this.UK = new Paint(1);
        this.UL = new Rect();
        this.UM = new RectF();
        this.TB = 0;
        this.Va = new int[2];
        this.Vb = new a();
        this.Ts = 0;
        this.Vd = 0;
        this.Uh[0] = context.getResources().getDimensionPixelSize(R.dimen.ds24);
        this.Uh[1] = context.getResources().getDimensionPixelSize(R.dimen.ds8);
        this.Uh[2] = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        this.Uh[3] = context.getResources().getDimensionPixelSize(R.dimen.ds36);
        this.Uq = context.getResources().getDimensionPixelSize(R.dimen.ds134);
        this.Ur = this.Uq + context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.Us = this.Ur + context.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.Ut = this.Us + context.getResources().getDimensionPixelSize(R.dimen.ds18);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.heightPixels == 960 && displayMetrics.widthPixels == 540 && displayMetrics.densityDpi == 240) {
            this.Uu = (int) TypedValue.applyDimension(1, 31.0f, displayMetrics);
            this.Uv = (int) TypedValue.applyDimension(1, 93.0f, displayMetrics);
        } else {
            this.Uu = context.getResources().getDimensionPixelSize(R.dimen.ds70);
            this.Uv = context.getResources().getDimensionPixelSize(R.dimen.ds210);
        }
        this.mPaddingTop = context.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.Ui = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        this.Uj = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.Uk = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.Ul = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        this.Um = context.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.Un = context.getResources().getDimensionPixelSize(R.dimen.ds2);
        this.UK.setStyle(Paint.Style.STROKE);
        this.UK.setStrokeWidth(this.Um);
        this.UJ = (BitmapDrawable) getResources().getDrawable(R.drawable.dot_play_schedule);
        init(context);
    }

    public void init(Context context) {
        ao(context);
        qc();
        this.Va[0] = al.getColor(R.color.common_color_10151);
        this.Va[1] = al.getColor(R.color.common_color_10152);
        VoiceManager voiceManager = getVoiceManager();
        if (voiceManager != null) {
            voiceManager.setAllowChangeVoiceMode(false);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = i & 1073741823;
        int i4 = i2 & 1073741823;
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                measureChild(childAt, i3 - 2147483648, i4 - 2147483648);
            }
        }
        setMeasuredDimension(i3, i4);
        this.mPaddingTop = ((i4 - getContext().getResources().getDimensionPixelSize(R.dimen.ds460)) / 2) + getContext().getResources().getDimensionPixelSize(R.dimen.ds6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int measuredWidth = this.US.getMeasuredWidth();
        int measuredHeight = this.US.getMeasuredHeight();
        int measuredWidth2 = this.UO.getMeasuredWidth();
        this.UO.layout((i5 - measuredWidth2) >> 1, this.mPaddingTop + i2, (measuredWidth2 + i5) >> 1, this.UO.getMeasuredHeight() + this.mPaddingTop + i2);
        int bottom = this.UO.getBottom();
        this.US.layout((i5 - measuredWidth) >> 1, bottom, (i5 + measuredWidth) >> 1, bottom + measuredHeight);
        int i6 = (i5 - measuredWidth) >> 1;
        this.centerX = (measuredWidth / 2) + i6;
        this.centerY = bottom + (measuredHeight / 2);
        int measuredWidth3 = this.UR.getMeasuredWidth();
        int measuredHeight2 = this.UR.getMeasuredHeight();
        int top = this.US.getTop();
        this.UR.layout((i5 - measuredWidth3) >> 1, top - measuredHeight2, (measuredWidth3 + i5) >> 1, top);
        int measuredWidth4 = this.UN.getMeasuredWidth();
        int measuredHeight3 = this.UN.getMeasuredHeight();
        int right = this.US.getRight() - this.Ui;
        int bottom2 = this.US.getBottom() - this.Uj;
        this.UN.layout(this.Uu + i6, this.Uv + bottom, measuredWidth4 + i6 + this.Uu, measuredHeight3 + this.Uv + bottom);
        int measuredWidth5 = this.UT.getMeasuredWidth();
        this.UT.layout((i5 - measuredWidth5) >> 1, bottom, (measuredWidth5 + i5) >> 1, this.UT.getMeasuredHeight() + bottom);
        int measuredWidth6 = this.UU.getMeasuredWidth();
        this.UU.layout((i5 - measuredWidth6) >> 1, (this.UN.getTop() - this.UU.getMeasuredHeight()) - this.Uk, (measuredWidth6 + i5) >> 1, (this.UN.getTop() + i2) - this.Uk);
        this.US.getLeft();
        this.US.getRight();
        int measuredWidth7 = this.UQ.getMeasuredWidth();
        int measuredHeight4 = this.UQ.getMeasuredHeight();
        int bottom3 = this.US.getBottom();
        this.UQ.layout((i5 - measuredWidth7) >> 1, this.Uh[3] + bottom3, (measuredWidth7 + i5) >> 1, measuredHeight4 + bottom3 + this.Uh[3]);
        this.UL.set((i5 - this.UJ.getIntrinsicWidth()) >> 1, this.UT.getTop() - this.Ul, (i5 + this.UJ.getIntrinsicHeight()) >> 1, (this.UT.getTop() + this.UJ.getIntrinsicHeight()) - this.Ul);
        this.UJ.setBounds(this.UL);
        this.UM.set(this.UT.getLeft() + (this.Um >> 1) + this.Un, this.UT.getTop() + (this.Um >> 1) + this.Un, (this.UT.getRight() - (this.Um >> 1)) - this.Un, (this.UT.getBottom() - (this.Um >> 1)) - this.Un);
        if (this.Vc == null) {
            this.Vc = new SweepGradient(this.UM.centerX(), this.UM.centerY(), this.Va, new float[]{0.0f, 0.7f});
            Matrix matrix = new Matrix();
            this.Vc.getLocalMatrix(matrix);
            matrix.postRotate(-90.0f, this.UM.centerX(), this.UM.centerY());
            this.Vc.setLocalMatrix(matrix);
            this.UK.setShader(this.Vc);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        f(canvas);
        super.dispatchDraw(canvas);
    }

    private void pN() {
        final com.baidu.tieba.tbadkCore.voice.a recorderManager = getRecorderManager();
        if (this.TD == null) {
            this.TD = new com.baidu.tbadk.core.dialog.a(i.ab(getContext()).getPageActivity());
            this.TD.mD(getContext().getString(R.string.voice_restart_tip)).a(getContext().getString(R.string.voice_restart), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    VoiceRecordButton.this.pY();
                    if (VoiceRecordButton.this.getVoiceManager() != null && VoiceRecordButton.this.mModel != null) {
                        if (recorderManager != null) {
                            recorderManager.cd(VoiceRecordButton.this.mModel.voiceId);
                        }
                        VoiceRecordButton.this.mModel = null;
                    }
                }
            }).b(getContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(i.ab(getContext()));
        }
        try {
            this.TD.afG();
        } catch (Exception e) {
            if (getVoiceManager() != null && this.mModel != null) {
                if (recorderManager != null) {
                    recorderManager.cd(this.mModel.voiceId);
                }
                this.mModel = null;
            }
        }
    }

    private void ao(Context context) {
        LayoutInflater.from(context).inflate(R.layout.record_voice_area, (ViewGroup) this, true);
        setClickable(true);
        this.UO = (TextView) findViewById(R.id.tip_error);
        al.f(this.UO, R.color.cp_btn_a, 1);
        this.UQ = (TextView) findViewById(R.id.tip_operator);
        this.UR = (TextView) findViewById(R.id.tip_time_out);
        this.US = (VoiceButton) findViewById(R.id.voice_bnt);
        this.UN = (TextView) findViewById(R.id.restart);
        this.UT = (ImageView) findViewById(R.id.play_img);
        this.UU = (TextView) findViewById(R.id.play_time);
        this.UU.setClickable(false);
        this.UN.setOnClickListener(this);
        this.UT.setOnClickListener(this);
        this.US.setRecorderView(this);
        pY();
    }

    private void pX() {
        this.US.setVisibility(4);
        this.UU.setVisibility(0);
        this.UN.setVisibility(0);
        al.f(this.UU, R.color.cp_cont_f, 1);
        al.f(this.UN, R.color.cp_cont_f, 1);
        al.k(this.UN, R.drawable.but_posts_record_again_selector);
        this.UT.setVisibility(0);
        if (this.mModel != null) {
            this.UU.setText(VoiceManager.formatVoiceTime(this.mModel.duration));
            this.UT.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(this.mModel.duration)));
            al.c(this.UT, (int) R.drawable.but_posts_record_play_selector);
        }
        al.f(this.UQ, R.color.cp_cont_c, 1);
        this.UQ.setText(getContext().getString(R.string.voice_play_tip));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pY() {
        al.c(this.US, (int) R.drawable.but_posts_record_zero_selector);
        this.US.setVisibility(0);
        this.Uo = 0;
        this.UT.setVisibility(4);
        this.UU.setVisibility(4);
        this.UN.setVisibility(4);
        this.UR.setVisibility(4);
        al.f(this.UQ, R.color.cp_cont_c, 1);
        this.UQ.setText(getContext().getString(R.string.voice_record_press_to_record));
    }

    public void reset() {
        pY();
        this.mModel = null;
        this.Uo = 0;
    }

    public void a(VoiceData.VoiceModel voiceModel) {
        this.mModel = voiceModel;
        this.UO.setText("");
        this.UO.setVisibility(4);
        this.Uo = 0;
        pX();
        b(new com.baidu.tbadk.editortools.a(10, -1, voiceModel));
        b(new com.baidu.tbadk.editortools.a(2, 6, " "));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
            pY();
            this.UQ.setText(getContext().getString(R.string.voice_record_release_to_stop));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStopingRecorder() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (this.UT != null && this.UU != null) {
            switch (voiceModel.voice_status.intValue()) {
                case 1:
                    al.f(this.UU, R.color.cp_cont_f, 1);
                    this.UU.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
                    al.c(this.UT, (int) R.drawable.but_posts_record_play_selector);
                    this.UT.setContentDescription(String.format(getContext().getString(R.string.listen_time), Integer.valueOf(voiceModel.duration)));
                    this.UQ.setText(getContext().getString(R.string.voice_play_tip));
                    qa();
                    return;
                case 2:
                default:
                    return;
                case 3:
                    al.f(this.UU, R.color.cp_cont_f, 1);
                    al.c(this.UT, (int) R.drawable.but_posts_record_stop_selector);
                    this.UT.setContentDescription(getContext().getString(R.string.pause_load));
                    this.UQ.setText(getContext().getString(R.string.voice_stop_tip));
                    pZ();
                    return;
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        al.f(this.UR, R.color.cp_btn_a, 1);
        al.f(this.UO, R.color.cp_btn_a, 1);
        al.f(this.UQ, R.color.cp_cont_c, 1);
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.UR.setVisibility(0);
                this.UR.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.UR != null) {
                            VoiceRecordButton.this.UR.setVisibility(4);
                            VoiceRecordButton.this.UR.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 2) {
                this.UO.setVisibility(0);
                this.UO.setText(str);
                this.UQ.setText(R.string.voice_record_press_to_record);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.UO != null) {
                            VoiceRecordButton.this.UO.setVisibility(4);
                            VoiceRecordButton.this.UO.setText("");
                        }
                    }
                }, 2000L);
            } else if (i == 5) {
                this.UO.setVisibility(0);
                this.UO.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.UO != null) {
                            VoiceRecordButton.this.UO.setVisibility(4);
                            VoiceRecordButton.this.UO.setText("");
                        }
                    }
                }, 2000L);
            } else {
                pY();
                this.UO.setVisibility(0);
                this.UO.setText(str);
                postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.VoiceRecordButton.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VoiceRecordButton.this.UO != null) {
                            VoiceRecordButton.this.UO.setVisibility(4);
                            VoiceRecordButton.this.UO.setText("");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        this.UO.setVisibility(4);
        VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
        voiceModel.duration = i;
        voiceModel.isLocal = true;
        voiceModel.voiceId = str;
        voiceModel.voice_status = 1;
        a(voiceModel);
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onDeletedVoice(String str) {
        this.mModel = null;
        b(new com.baidu.tbadk.editortools.a(11, -1, str));
        b(new com.baidu.tbadk.editortools.a(2, 6, null));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecordTime(int i) {
        al.f(this.UO, R.color.cp_btn_a, 1);
        this.UO.setVisibility(0);
        this.UO.setText(VoiceManager.formatVoiceTime(i));
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        this.Ts = Math.max(i, this.Ts);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.Tt > 200) {
            this.Ts = 0;
            this.Tt = uptimeMillis;
        }
        if (this.Ts < 10) {
            this.Uo = 1;
            invalidate();
        } else if (this.Ts < 20) {
            this.Uo = 2;
            invalidate();
        } else if (this.Ts < 30) {
            this.Uo = 3;
            invalidate();
        } else if (this.Ts < 40) {
            this.Uo = 4;
            invalidate();
        } else {
            this.Uo = 5;
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bl(int i) {
        if (this.mModel != null && this.UU != null) {
            int i2 = i / 1000;
            if (this.Vd != i2) {
                this.UU.setText(VoiceManager.formatVoiceTime(this.mModel.duration - i2));
            }
            this.Vd = i2;
        }
    }

    private void pZ() {
        if (this.mModel != null) {
            this.Uo = 0;
            this.UV = 360.0f / (this.mModel.duration2 > 0 ? this.mModel.duration2 / 1000.0f : this.mModel.duration);
            this.UY = SystemClock.uptimeMillis();
            this.UZ = this.UY + 200;
            this.Vb.sendEmptyMessageAtTime(1, this.UZ);
            invalidate();
        }
    }

    private void qa() {
        this.Uo = 0;
        this.Up = 0;
        this.UV = 0.0f;
        this.UW = 0.0f;
        this.Vb.removeMessages(1);
        ((ViewGroup) getParent()).invalidate();
    }

    public VoiceManager getVoiceManager() {
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        return null;
    }

    public com.baidu.tieba.tbadkCore.voice.a getRecorderManager() {
        VoiceManager voiceManager = getVoiceManager();
        if (voiceManager == null || voiceManager.getRecorderManager() == null) {
            return null;
        }
        return voiceManager.getRecorderManager();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (view != null && (voiceManager = getVoiceManager()) != null) {
            int id = view.getId();
            if (id == R.id.restart) {
                voiceManager.stopPlay();
                pN();
            } else if (id == R.id.play_img && this.mModel != null) {
                if (this.mModel.voice_status.intValue() == 3) {
                    voiceManager.stopPlay();
                } else if (this.mModel.voice_status.intValue() == 1) {
                    voiceManager.setAllowChangeVoiceMode(false);
                    voiceManager.startPlay(this);
                }
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (getVisibility() == 0 && (i == 4 || i == 8)) {
            if (getVoiceManager() != null) {
                getVoiceManager().stopPlay();
            } else {
                return;
            }
        }
        super.setVisibility(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (getVoiceManager() != null) {
            getVoiceManager().stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.mModel;
    }

    public void setCallback(f fVar) {
        this.UX = fVar;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void qb() {
    }

    public void qc() {
        this.Uw = new Paint();
        this.Uw.setAntiAlias(true);
        this.Uw.setStyle(Paint.Style.STROKE);
        this.Uw.setStrokeWidth(2.0f);
        this.Ux = new Paint();
        this.Ux.setAntiAlias(true);
        this.Ux.setStyle(Paint.Style.STROKE);
        this.Ux.setStrokeWidth(2.0f);
        this.Uy = new Paint();
        this.Uy.setAntiAlias(true);
        this.Uy.setStyle(Paint.Style.STROKE);
        this.Uy.setStrokeWidth(2.0f);
        this.Uz = new Paint();
        this.Uz.setAntiAlias(true);
        this.Uz.setStyle(Paint.Style.STROKE);
        this.Uz.setStrokeWidth(2.0f);
    }

    public void f(Canvas canvas) {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.Uw.setColor(this.UF);
            this.Ux.setColor(this.UG);
            this.Uy.setColor(this.UH);
            this.Uz.setColor(this.UI);
        } else {
            this.Uw.setColor(this.UB);
            this.Ux.setColor(this.UC);
            this.Uy.setColor(this.UD);
            this.Uz.setColor(this.UE);
        }
        if (this.Uo == 2) {
            canvas.drawCircle(this.centerX, this.centerY, this.Uq, this.Uw);
        } else if (this.Uo == 3) {
            canvas.drawCircle(this.centerX, this.centerY, this.Uq, this.Uw);
            canvas.drawCircle(this.centerX, this.centerY, this.Ur, this.Ux);
        } else if (this.Uo == 4) {
            canvas.drawCircle(this.centerX, this.centerY, this.Uq, this.Uw);
            canvas.drawCircle(this.centerX, this.centerY, this.Ur, this.Ux);
            canvas.drawCircle(this.centerX, this.centerY, this.Us, this.Uy);
        } else if (this.Uo == 5) {
            canvas.drawCircle(this.centerX, this.centerY, this.Uq, this.Uw);
            canvas.drawCircle(this.centerX, this.centerY, this.Ur, this.Ux);
            canvas.drawCircle(this.centerX, this.centerY, this.Us, this.Uy);
            canvas.drawCircle(this.centerX, this.centerY, this.Ut, this.Uz);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            if (aVar.code == 9) {
                reset();
                b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
            if (aVar.code == 52) {
                if (aVar.data instanceof VoiceData.VoiceModel) {
                    pX();
                    b((VoiceData.VoiceModel) aVar.data);
                    this.mModel = (VoiceData.VoiceModel) aVar.data;
                    return;
                }
                reset();
                b(new com.baidu.tbadk.editortools.a(2, 6, null));
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pO() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.TB;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.TA != null) {
            this.TA.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.TA = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.TB = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
    }
}

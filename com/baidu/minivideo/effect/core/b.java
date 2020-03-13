package com.baidu.minivideo.effect.core;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.minivideo.effect.core.entity.AEffectAnimatorGroup;
import com.baidu.minivideo.effect.core.entity.AEffectAnimatorParams;
import com.baidu.minivideo.effect.core.entity.AEffectOneAnimator;
import com.baidu.minivideo.effect.core.entity.AEffectParams;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes13.dex */
public class b {
    protected int a;
    private final SparseArray<AEffectParams> aNF;
    private AEffectAnimatorGroup aNG;
    private AEffectAnimatorGroup aNH;
    protected float[] b;
    protected float[] c;
    private final LinkedList<Runnable> d;
    private final String e;
    private final String f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private boolean m;
    private final SparseArray<String> n;
    private int p;
    private long q;
    private float r;
    private float s;
    private String t;
    private List<AEffectAnimatorGroup> u;
    private long v;
    private int y;

    public b() {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "precision highp float;\n \nvarying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\nuniform float alpha;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate) * alpha;\n}");
    }

    public b(String str, String str2) {
        this.a = 3553;
        this.d = new LinkedList<>();
        this.n = new SparseArray<>();
        this.aNF = new SparseArray<>();
        this.e = str;
        this.f = str2;
        if (TextUtils.isEmpty(str2) || !str2.contains("samplerExternalOES")) {
            return;
        }
        this.a = 36197;
    }

    public static String a(Context context, int i) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(i)));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append('\n');
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public static String a(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    fileInputStream.close();
                    return sb.toString();
                }
                sb.append(readLine);
                sb.append('\n');
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private void a(AEffectAnimatorParams aEffectAnimatorParams, float[] fArr, boolean z, float f, boolean z2) {
        if (aEffectAnimatorParams.interpolator != null) {
            String str = aEffectAnimatorParams.interpolator;
            char c = 65535;
            switch (str.hashCode()) {
                case -1383205240:
                    if (str.equals("bounce")) {
                        c = 6;
                        break;
                    }
                    break;
                case -1354466595:
                    if (str.equals("accelerate")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1263948740:
                    if (str.equals("decelerate")) {
                        c = 1;
                        break;
                    }
                    break;
                case -749065269:
                    if (str.equals("overshoot")) {
                        c = 3;
                        break;
                    }
                    break;
                case 95131878:
                    if (str.equals("cycle")) {
                        c = 4;
                        break;
                    }
                    break;
                case 475910905:
                    if (str.equals("accelerateDecelerate")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1088816001:
                    if (str.equals("anticipateOvershoot")) {
                        c = 5;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    f *= f;
                    break;
                case 1:
                    f = 1.0f - ((1.0f - f) * (1.0f - f));
                    break;
                case 2:
                    f = (float) ((Math.cos((1.0f + f) * 3.141592653589793d) / 2.0d) + 0.5d);
                    break;
                case 3:
                    float f2 = f - 1.0f;
                    f = (((f2 * 3.0f) + 2.0f) * f2 * f2) + 1.0f;
                    break;
                case 4:
                    f = (float) Math.sin(6.283185307179586d * f);
                    break;
                case 5:
                    if (f >= 0.5f) {
                        f = 0.5f * ((((2.0f * f) - ((2.0f * f) * 2.0f)) - (2.0f * ((((4.0f * f) * 2.0f) - 2.0f) + 3.0f))) + 2.0f);
                        break;
                    } else {
                        f = 0.5f * f * 2.0f * f * 2.0f * (((4.0f * f) * 2.0f) - 3.0f);
                        break;
                    }
                case 6:
                    float f3 = 1.1226f * f;
                    if (f3 >= 0.3535f) {
                        if (f3 >= 0.7408f) {
                            if (f3 >= 0.9644f) {
                                f = ((f3 - 1.0435f) * (f3 - 1.0435f) * 8.0f) + 0.95f;
                                break;
                            } else {
                                f = ((f3 - 0.8526f) * (f3 - 0.8526f) * 8.0f) + 0.9f;
                                break;
                            }
                        } else {
                            f = ((f3 - 0.54719f) * (f3 - 0.54719f) * 8.0f) + 0.7f;
                            break;
                        }
                    } else {
                        f = f3 * f3 * 8.0f;
                        break;
                    }
            }
        }
        String str2 = aEffectAnimatorParams.name;
        char c2 = 65535;
        switch (str2.hashCode()) {
            case -1909310045:
                if (str2.equals("transitionX")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1909310044:
                if (str2.equals("transitionY")) {
                    c2 = 4;
                    break;
                }
                break;
            case -908189618:
                if (str2.equals("scaleX")) {
                    c2 = 1;
                    break;
                }
                break;
            case -908189617:
                if (str2.equals("scaleY")) {
                    c2 = 2;
                    break;
                }
                break;
            case -40300674:
                if (str2.equals("rotation")) {
                    c2 = 5;
                    break;
                }
                break;
            case 109250890:
                if (str2.equals("scale")) {
                    c2 = 0;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                Matrix.scaleM(fArr, 0, f, f, 1.0f);
                break;
            case 1:
                Matrix.scaleM(fArr, 0, f, 1.0f, 1.0f);
                break;
            case 2:
                Matrix.scaleM(fArr, 0, 1.0f, f, 1.0f);
                break;
            case 3:
                Matrix.translateM(fArr, 0, 2.0f * f, 0.0f, 1.0f);
                break;
            case 4:
                Matrix.translateM(fArr, 0, 0.0f, 2.0f * f, 1.0f);
                break;
            case 5:
                float f4 = this.k > this.l ? this.k / this.l : this.l / this.k;
                Matrix.orthoM(fArr, 0, -1.0f, 1.0f, -f4, f4, 0.1f, 0.0f);
                Matrix.rotateM(fArr, 0, aEffectAnimatorParams.angle * f, 0.0f, 0.0f, 1.0f);
                Matrix.scaleM(fArr, 0, 1.0f, f4, 1.0f);
                break;
        }
        if (z) {
            if (z2) {
                GLES20.glUniform1f(GLES20.glGetUniformLocation(n(), "alpha"), f);
            }
            g(g(), fArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        AEffectParams aEffectParams;
        if (this.n.size() != 0) {
            AEffectParams aEffectParams2 = this.aNF.get(this.n.keyAt(0));
            if (aEffectParams2 != null && aEffectParams2.values != null && aEffectParams2.values.length > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                if (aEffectParams2.timeInterval == 0.0f || ((float) (currentTimeMillis - this.q)) > aEffectParams2.timeInterval * 1000.0f) {
                    this.p++;
                    if (this.p >= aEffectParams2.values.length) {
                        this.p = 0;
                    }
                    this.q = currentTimeMillis;
                }
            }
            for (int i = 0; i < this.n.size(); i++) {
                int keyAt = this.n.keyAt(i);
                if (this.aNF.size() > 0 && (aEffectParams = this.aNF.get(keyAt)) != null) {
                    if (AEffectParams.VALUE_TYPE_FLOAT.equals(aEffectParams.type)) {
                        if (aEffectParams.values != null && aEffectParams.values.length > this.p) {
                            GLES20.glUniform1f(keyAt, aEffectParams.values[this.p]);
                        }
                    } else if ("array".equals(aEffectParams.type)) {
                        if (aEffectParams.values != null && aEffectParams.values.length > 0) {
                            a(keyAt, aEffectParams.values);
                        }
                    } else if (AEffectParams.VALUE_TYPE_STEP.equals(aEffectParams.type)) {
                        if (aEffectParams.values != null && aEffectParams.values.length >= 3) {
                            if (this.r < aEffectParams.values[0]) {
                                this.r = aEffectParams.values[0];
                            }
                            this.r += aEffectParams.values[2];
                            if (this.r > aEffectParams.values[1]) {
                                this.r = aEffectParams.values[1];
                            }
                            GLES20.glUniform1f(keyAt, this.r);
                        }
                    } else if (AEffectParams.IMAGE_WIDTH.equals(aEffectParams.name)) {
                        GLES20.glUniform1f(keyAt, this.k);
                    } else if (AEffectParams.IMAGE_HEIGHT.equals(aEffectParams.name)) {
                        GLES20.glUniform1f(keyAt, this.l);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        boolean z;
        if (this.v == 0 || this.aNG == null || this.aNG.sceneGroup == null) {
            return;
        }
        long currentTimeMillis = (System.currentTimeMillis() - this.v) % (this.s * 1000.0f);
        for (AEffectOneAnimator aEffectOneAnimator : this.aNG.sceneGroup) {
            if (aEffectOneAnimator.animParams == null || aEffectOneAnimator.beginTime * 1000.0f > ((float) currentTimeMillis) || aEffectOneAnimator.endTime * 1000.0f <= ((float) currentTimeMillis)) {
                GLES20.glUniform1f(GLES20.glGetUniformLocation(n(), "alpha"), 1.0f);
            } else {
                long j = (aEffectOneAnimator.endTime - aEffectOneAnimator.beginTime) * 1000.0f;
                float f = ((((float) currentTimeMillis) - (aEffectOneAnimator.beginTime * 1000.0f)) % ((float) j)) / (((float) j) * 1.0f);
                if (f >= 0.0f && f <= 1.0f) {
                    float[] fArr = new float[16];
                    Matrix.setIdentityM(fArr, 0);
                    int i = 0;
                    boolean z2 = false;
                    while (i < aEffectOneAnimator.animParams.size()) {
                        AEffectAnimatorParams aEffectAnimatorParams = aEffectOneAnimator.animParams.get(i);
                        if ("value".equals(aEffectAnimatorParams.type)) {
                            GLES20.glUniform1f(GLES20.glGetUniformLocation(n(), aEffectAnimatorParams.name), ((aEffectAnimatorParams.endValue - aEffectAnimatorParams.beginValue) * f) + aEffectAnimatorParams.beginValue);
                            z = z2;
                        } else {
                            float f2 = aEffectAnimatorParams.beginValue + ((aEffectAnimatorParams.endValue - aEffectAnimatorParams.beginValue) * f);
                            boolean z3 = "alpha".equals(aEffectAnimatorParams.type) ? true : z2;
                            a(aEffectAnimatorParams, fArr, i == aEffectOneAnimator.animParams.size() + (-1), f2, z3);
                            z = z3;
                        }
                        i++;
                        z2 = z;
                    }
                    if (z2) {
                        return;
                    }
                    GLES20.glUniform1f(GLES20.glGetUniformLocation(n(), "alpha"), 1.0f);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        boolean z;
        if (this.v == 0 || this.aNG == null || this.aNG.transitionGroup == null || this.aNG.transitionGroup.size() <= this.y) {
            return;
        }
        long j = this.aNG.transitionDuration * 1000.0f;
        long currentTimeMillis = (System.currentTimeMillis() - this.v) % (this.s * 1000.0f);
        if (currentTimeMillis < 0 || currentTimeMillis >= j) {
            return;
        }
        AEffectOneAnimator aEffectOneAnimator = this.aNG.transitionGroup.get(this.y);
        float f = ((float) ((currentTimeMillis - 0) % j)) / (1.0f * ((float) j));
        if (f < 0.0f || f > 1.0f) {
            return;
        }
        if (aEffectOneAnimator.animParams == null) {
            GLES20.glUniform1f(GLES20.glGetUniformLocation(n(), "alpha"), 1.0f);
            return;
        }
        float[] fArr = new float[16];
        Matrix.setIdentityM(fArr, 0);
        if (this.aNH != null && this.aNH.sceneGroup != null && this.y == 0) {
            AEffectOneAnimator aEffectOneAnimator2 = this.aNH.sceneGroup.get(this.aNH.sceneGroup.size() - 1);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aEffectOneAnimator2.animParams.size()) {
                    break;
                }
                AEffectAnimatorParams aEffectAnimatorParams = aEffectOneAnimator2.animParams.get(i2);
                if (AEffectOneAnimator.ANIM_TYPE_ANIMATORVALUE.equals(aEffectAnimatorParams.type) && (aEffectAnimatorParams.name.contains("transition") || aEffectAnimatorParams.name.contains("rotation"))) {
                    a(aEffectAnimatorParams, fArr, i2 == aEffectOneAnimator.animParams.size() + (-1), aEffectAnimatorParams.endValue, false);
                }
                i = i2 + 1;
            }
        }
        int i3 = 0;
        boolean z2 = false;
        while (i3 < aEffectOneAnimator.animParams.size()) {
            AEffectAnimatorParams aEffectAnimatorParams2 = aEffectOneAnimator.animParams.get(i3);
            if ("value".equals(aEffectAnimatorParams2.type)) {
                GLES20.glUniform1f(GLES20.glGetUniformLocation(n(), aEffectAnimatorParams2.name), ((aEffectAnimatorParams2.endValue - aEffectAnimatorParams2.beginValue) * f) + aEffectAnimatorParams2.beginValue);
                z = z2;
            } else {
                float f2 = aEffectAnimatorParams2.beginValue + ((aEffectAnimatorParams2.endValue - aEffectAnimatorParams2.beginValue) * f);
                boolean z3 = "alpha".equals(aEffectAnimatorParams2.name) ? true : z2;
                a(aEffectAnimatorParams2, fArr, i3 == aEffectOneAnimator.animParams.size() + (-1), f2, z3);
                z = z3;
            }
            i3++;
            z2 = z;
        }
        if (z2) {
            return;
        }
        GLES20.glUniform1f(GLES20.glGetUniformLocation(n(), "alpha"), 1.0f);
    }

    public int a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        return 0;
    }

    public final void a() {
        if (this.m) {
            return;
        }
        b();
        c();
    }

    public void a(float f, String str, List<AEffectAnimatorGroup> list) {
        this.s = f;
        this.t = str;
        this.u = list;
    }

    public void a(int i) {
        this.y = i;
    }

    protected void a(final int i, final float f) {
        a(new Runnable() { // from class: com.baidu.minivideo.effect.core.b.5
            @Override // java.lang.Runnable
            public void run() {
                b.this.d();
                GLES20.glUniform1f(i, f);
            }
        });
    }

    public void a(int i, int i2) {
        this.k = i;
        this.l = i2;
    }

    public void a(int i, long j) {
        this.v = j;
        if (this.aNG != null) {
            this.aNH = this.aNG;
        }
        if (this.u == null || this.u.size() <= 0) {
            return;
        }
        if (this.u.size() == 1) {
            this.aNG = this.u.get(0);
            return;
        }
        if (this.u.size() <= i) {
            i = 0;
        }
        this.aNG = this.u.get(i);
    }

    public void a(int i, String str, AEffectParams aEffectParams) {
        if (aEffectParams == null) {
            return;
        }
        this.n.put(i, str);
        this.aNF.put(i, aEffectParams);
    }

    public void a(int i, float[] fArr) {
        switch (fArr.length) {
            case 0:
                return;
            case 1:
                a(i, fArr[0]);
                return;
            case 2:
                b(i, fArr);
                return;
            case 3:
                c(i, fArr);
                return;
            case 4:
                d(i, fArr);
                return;
            case 9:
                f(i, fArr);
                return;
            case 16:
                g(i, fArr);
                return;
            default:
                e(i, fArr);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Runnable runnable) {
        synchronized (this.d) {
            this.d.addLast(runnable);
        }
    }

    public void b() {
        this.g = f.a(this.e, this.f);
        this.h = GLES20.glGetAttribLocation(this.g, "position");
        this.i = GLES20.glGetUniformLocation(this.g, "inputImageTexture");
        this.j = GLES20.glGetAttribLocation(this.g, "inputTextureCoordinate");
        this.m = true;
    }

    public void b(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        f.a("draw start");
        GLES20.glUseProgram(this.g);
        f.a("glUseProgram");
        k();
        if (this.m) {
            if (i != -1) {
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(this.a, i);
                GLES20.glUniform1i(this.i, 0);
            }
            floatBuffer.position(0);
            GLES20.glEnableVertexAttribArray(this.h);
            f.a("glEnableVertexAttribPositionArray");
            GLES20.glVertexAttribPointer(this.h, 2, 5126, false, 0, (Buffer) floatBuffer);
            f.a("glVertexAttribPositionPointer");
            floatBuffer2.position(0);
            GLES20.glEnableVertexAttribArray(this.j);
            f.a("glEnableVertexAttribTextureArray");
            GLES20.glVertexAttribPointer(this.j, 2, 5126, false, 0, (Buffer) floatBuffer2);
            f.a("glVertexAttribTexturePointer");
            i();
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.h);
            GLES20.glDisableVertexAttribArray(this.j);
            j();
            GLES20.glBindTexture(this.a, 0);
            GLES20.glUseProgram(0);
        }
    }

    protected void b(final int i, final float[] fArr) {
        a(new Runnable() { // from class: com.baidu.minivideo.effect.core.b.6
            @Override // java.lang.Runnable
            public void run() {
                b.this.d();
                GLES20.glUniform2fv(i, 1, FloatBuffer.wrap(fArr));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
    }

    protected void c(final int i, final float[] fArr) {
        a(new Runnable() { // from class: com.baidu.minivideo.effect.core.b.7
            @Override // java.lang.Runnable
            public void run() {
                b.this.d();
                GLES20.glUniform3fv(i, 1, FloatBuffer.wrap(fArr));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        if (this.m) {
            return;
        }
        a();
    }

    protected void d(final int i, final float[] fArr) {
        a(new Runnable() { // from class: com.baidu.minivideo.effect.core.b.8
            @Override // java.lang.Runnable
            public void run() {
                b.this.d();
                GLES20.glUniform4fv(i, 1, FloatBuffer.wrap(fArr));
            }
        });
    }

    public final void e() {
        this.m = false;
        GLES20.glDeleteProgram(this.g);
        f();
    }

    protected void e(final int i, final float[] fArr) {
        a(new Runnable() { // from class: com.baidu.minivideo.effect.core.b.9
            @Override // java.lang.Runnable
            public void run() {
                b.this.d();
                GLES20.glUniform1fv(i, fArr.length, FloatBuffer.wrap(fArr));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f() {
    }

    protected void f(final int i, final float[] fArr) {
        a(new Runnable() { // from class: com.baidu.minivideo.effect.core.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.d();
                GLES20.glUniformMatrix3fv(i, 1, false, fArr, 0);
            }
        });
    }

    protected int g() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(final int i, final float[] fArr) {
        a(new Runnable() { // from class: com.baidu.minivideo.effect.core.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.d();
                GLES20.glUniformMatrix4fv(i, 1, false, fArr, 0);
            }
        });
    }

    public void h() {
    }

    protected void i() {
    }

    protected void j() {
    }

    protected void k() {
        while (!this.d.isEmpty()) {
            this.d.removeFirst().run();
        }
    }

    public int l() {
        return this.k;
    }

    public int m() {
        return this.l;
    }

    public int n() {
        return this.g;
    }

    public boolean o() {
        if (this.u == null || this.aNG == null || this.aNG.transitionGroup == null || this.v == 0) {
            return false;
        }
        long currentTimeMillis = (System.currentTimeMillis() - this.v) % (this.s * 1000.0f);
        return currentTimeMillis >= 0 && ((float) currentTimeMillis) < this.aNG.transitionDuration * 1000.0f;
    }

    public void p() {
        a(new Runnable() { // from class: com.baidu.minivideo.effect.core.b.1
            @Override // java.lang.Runnable
            public void run() {
                GLES20.glUniform1f(GLES20.glGetUniformLocation(b.this.n(), "alpha"), 1.0f);
                GLES20.glUniformMatrix4fv(b.this.g(), 1, false, b.this.b, 0);
            }
        });
    }

    public void q() {
        a(new Runnable() { // from class: com.baidu.minivideo.effect.core.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.d();
                GLES20.glUniform1f(GLES20.glGetUniformLocation(b.this.n(), "alpha"), 1.0f);
                if (b.this.o()) {
                    b.this.t();
                } else {
                    b.this.s();
                }
                b.this.r();
            }
        });
    }
}

package com.baidu.c.a.c;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.c.a.e.b;
import com.baidu.crius.CriusAlign;
import com.baidu.crius.CriusConstants;
import com.baidu.crius.CriusDisplay;
import com.baidu.crius.CriusEdge;
import com.baidu.crius.CriusFlexDirection;
import com.baidu.crius.CriusJustify;
import com.baidu.crius.CriusMeasureFunction;
import com.baidu.crius.CriusMeasureMode;
import com.baidu.crius.CriusMeasureOutput;
import com.baidu.crius.CriusNode;
import com.baidu.crius.CriusPositionType;
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
@TargetApi(23)
/* loaded from: classes11.dex */
public class a {
    public final int QB;
    public final int Qz;
    private final CriusMeasureFunction RA;
    public String RB;
    public String RC;
    public String RD;
    public String RE;
    public String RF;
    public int RG;
    public int RH;
    public int RI;
    public String RJ;
    public String RK;
    public double RL;
    public double RO;
    private String RP;
    private String RQ;
    private String RR;
    private String RT;
    private String RU;
    private String RV;
    private double RW;
    private double RX;
    private double RY;
    private double RZ;
    public String Rp;
    protected int Ru;
    protected int Rv;
    protected int Rw;
    private CriusNode Rx;
    public final CriusNode Ry;
    private TextView Rz;
    public String SA;
    public String SB;
    public Typeface SC;
    public String SD;
    public String SF;
    public String SG;
    public String SH;
    public String SJ;
    public String SK;
    public String SL;
    public String SM;
    public String SO;
    public double SQ;
    public String SR;
    public String SS;
    public String ST;
    public String SU;
    public String SV;
    public final List<a> SW;
    private double Sa;
    private double Sb;
    private double Sc;
    private double Se;
    private double Sf;
    private double Sg;
    private double Sh;
    private double Si;
    private double Sj;
    private double Sk;
    private double Sl;
    private double Sm;
    private double Sn;
    private double So;
    private double Sp;
    private double Sq;
    private double Sr;
    private double Ss;
    private double St;
    public String Su;
    public double Sv;
    public double Sw;
    public double Sx;
    public double Sy;
    public double Sz;
    public String backgroundColor;
    public String borderColor;
    public double borderRadius;
    private InterfaceC0048a businessConverter;
    public String color;
    public final float density;
    public double fontSize;
    public int gravity;
    private double height;
    public String id;
    public int maxLines;
    public String name;
    public double opacity;
    private String position;
    public String poster;
    public String shareContent;
    public String shareTitle;
    public String src;
    public String text;
    public String type;
    public int videoDuration;
    private double width;

    /* renamed from: com.baidu.c.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0048a {
        String cv(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"PrivateApi"})
    public void a(@NonNull StaticLayout.Builder builder, boolean z) {
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                Method declaredMethod = builder.getClass().getDeclaredMethod("setUseLineSpacingFromFallbacks", Boolean.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(builder, Boolean.valueOf(z));
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView, a aVar) {
        if (!TextUtils.isEmpty(aVar.text)) {
            if (aVar.maxLines > 0) {
                if (aVar.maxLines == 1) {
                    textView.setSingleLine(true);
                } else {
                    textView.setSingleLine(false);
                }
                textView.setMaxLines(aVar.maxLines);
            }
            textView.setEllipsize(TextUtils.TruncateAt.END);
            if (Double.compare(aVar.nR(), 0.0d) > 0) {
                textView.setTextSize(0, (float) (aVar.nR() * textView.getContext().getResources().getDisplayMetrics().density));
            }
            textView.setIncludeFontPadding(false);
            textView.setTypeface(aVar.SC);
            textView.setGravity(aVar.gravity);
            float d = aVar.RL > 0.0d ? d(aVar.RL) : 0.0f;
            float f = aVar.RO > 0.0d ? (float) aVar.RO : 1.0f;
            if (d > 0.0f || f > 0.0f) {
                textView.setLineSpacing(d, f);
            }
        }
    }

    public static boolean cr(String str) {
        return Pattern.compile("[^一-龥]").matcher(str).find();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float G(float f) {
        if (Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) {
            return (1.12f * f) + 0.5f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float H(float f) {
        if ((Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) && this.maxLines == 1 && cr(this.text)) {
            return (1.09859f * f) + 0.5f;
        }
        return f;
    }

    private void d(JSONObject jSONObject) {
        this.id = b.g(jSONObject, "id");
        this.name = b.g(jSONObject, "name");
        this.type = b.g(jSONObject, "type");
        if (ox()) {
            this.Ry.setMeasureFunction(this.RA);
        }
        this.RB = b.g(jSONObject, "component");
        this.src = b.g(jSONObject, UserAccountActionItem.KEY_SRC);
        this.poster = b.g(jSONObject, "poster");
        this.RC = b.g(jSONObject, "href");
        this.text = b.g(jSONObject, "text");
        if ("time".equalsIgnoreCase(this.RB) && this.businessConverter != null) {
            this.text = this.businessConverter.cv(this.text);
        }
        this.maxLines = jSONObject.optInt("max-lines", 1);
        this.RL = b.h(jSONObject, "line-space");
        this.RO = b.h(jSONObject, "line-multi");
        this.videoDuration = jSONObject.optInt("data-video-duration");
        this.RD = jSONObject.optString("data-als-stat");
        this.RE = jSONObject.optString("data-url-stat");
        this.RF = jSONObject.optString("data-href-pop");
        this.RG = b.i(jSONObject, "data-share-num");
        this.RH = b.i(jSONObject, "data-reply-num");
        this.RI = b.i(jSONObject, "data-agree-num");
        this.shareTitle = jSONObject.optString("data-share-title");
        this.shareContent = jSONObject.optString("data-share-content");
        this.RJ = jSONObject.optString("data-share-image");
        this.RK = jSONObject.optString("data-share-link");
    }

    private void e(JSONObject jSONObject) {
        this.RP = b.g(jSONObject, LogConfig.KEY_DISPLAY);
        op();
        this.RQ = b.g(jSONObject, "flex-direction");
        ow();
        this.RR = b.g(jSONObject, "justify-content");
        ov();
        this.RT = b.g(jSONObject, "align-items");
        ou();
        this.RU = b.g(jSONObject, "align-self");
        ot();
        this.RV = b.g(jSONObject, "align-content");
        os();
        this.RW = b.h(jSONObject, "flex");
        oo();
        this.RX = b.h(jSONObject, "flex-grow");
        on();
        this.RY = b.h(jSONObject, "flex-shrink");
        om();
        this.RZ = b.h(jSONObject, "flex-basis");
        ol();
        this.position = b.g(jSONObject, "position");
        or();
        this.Sa = b.h(jSONObject, "left");
        this.Sb = b.h(jSONObject, VerticalTranslateLayout.TOP);
        this.Sc = b.h(jSONObject, HorizontalTranslateLayout.RIGHT);
        this.Se = b.h(jSONObject, VerticalTranslateLayout.BOTTOM);
        oq();
        this.Sf = b.h(jSONObject, "margin");
        ok();
        this.Sg = b.h(jSONObject, "margin-left");
        og();
        this.Sh = b.h(jSONObject, "margin-top");
        oj();
        this.Si = b.h(jSONObject, "margin-right");
        oi();
        this.Sj = b.h(jSONObject, "margin-bottom");
        oh();
        this.Sk = b.h(jSONObject, "padding");
        initPadding();
        this.Sl = b.h(jSONObject, "padding-left");
        ob();
        this.Sm = b.h(jSONObject, "padding-top");
        oe();
        this.Sn = b.h(jSONObject, "padding-right");
        od();
        this.So = b.h(jSONObject, "padding-bottom");
        oc();
        this.width = b.h(jSONObject, "width");
        oa();
        this.height = b.h(jSONObject, "height");
        nZ();
        this.Sp = b.h(jSONObject, "min-width");
        nY();
        this.Sq = b.h(jSONObject, "min-height");
        nX();
        this.Sr = b.h(jSONObject, "max-width");
        nU();
        this.Ss = b.h(jSONObject, "max-height");
        nW();
        this.St = b.h(jSONObject, "aspect-ratio");
        nV();
    }

    private void f(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SharedPrefConfig.ACTIVE_STATE)) != null) {
            this.SS = b.g(optJSONObject, "background-image");
            this.ST = b.g(optJSONObject, "background-color");
            this.SU = b.g(optJSONObject, "border-color");
            this.SV = b.g(optJSONObject, "color");
        }
    }

    private void g(JSONObject jSONObject) {
        this.SL = b.g(jSONObject, "background-image");
        this.SM = b.g(jSONObject, "background-color");
        this.SO = b.g(jSONObject, "border-color");
        this.SQ = b.h(jSONObject, "opacity");
        this.SR = b.g(jSONObject, "color");
    }

    private void h(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SharedPrefConfig.ACTIVE_STATE)) != null) {
            this.SG = b.g(optJSONObject, "background-image");
            this.SH = b.g(optJSONObject, "background-color");
            this.SJ = b.g(optJSONObject, "border-color");
            this.SK = b.g(optJSONObject, "color");
        }
    }

    private void i(JSONObject jSONObject) {
        this.Su = b.g(jSONObject, "background-image");
        this.backgroundColor = b.g(jSONObject, "background-color");
        this.borderColor = b.g(jSONObject, "border-color");
        this.opacity = b.h(jSONObject, "opacity");
        this.color = b.g(jSONObject, "color");
        this.Sv = b.h(jSONObject, "border-width");
        this.borderRadius = b.h(jSONObject, "border-radius");
        this.Sw = b.h(jSONObject, "border-top-left-radius");
        this.Sx = b.h(jSONObject, "border-bottom-left-radius");
        this.Sy = b.h(jSONObject, "border-top-right-radius");
        this.Sz = b.h(jSONObject, "border-bottom-right-radius");
        this.SA = b.g(jSONObject, "font-style");
        this.SB = b.g(jSONObject, "font-weight");
        this.SC = Typeface.create(Typeface.DEFAULT, nS());
        this.fontSize = jSONObject.optDouble("font-size", 12.0d);
        this.SD = b.g(jSONObject, "text-align");
        this.SF = b.g(jSONObject, "vertical-align");
        this.gravity = nT();
        this.Rp = b.g(jSONObject, "download-style");
    }

    public a(Context context, JSONObject jSONObject, InterfaceC0048a interfaceC0048a, boolean z) {
        this.Ru = Build.VERSION.SDK_INT < 23 ? 0 : 1;
        if (Build.VERSION.SDK_INT < 23) {
        }
        this.Rv = 0;
        if (Build.VERSION.SDK_INT < 26) {
        }
        this.Rw = 0;
        this.RA = new CriusMeasureFunction() { // from class: com.baidu.c.a.c.a.1
            @Override // com.baidu.crius.CriusMeasureFunction
            @SuppressLint({"WrongConstant"})
            public long measure(CriusNode criusNode, float f, CriusMeasureMode criusMeasureMode, float f2, CriusMeasureMode criusMeasureMode2) {
                float f3;
                boolean z2;
                Layout build;
                Layout build2;
                SpannableString spannableString = new SpannableString(a.this.text);
                a.this.a(a.this.Rz, a.this);
                TextPaint paint = a.this.Rz.getPaint();
                BoringLayout.Metrics isBoring = BoringLayout.isBoring(spannableString, paint);
                float desiredWidth = isBoring == null ? Layout.getDesiredWidth(spannableString, paint) : Float.NaN;
                if (a.this.RL > 0.0d) {
                    f3 = a.this.d(a.this.RL);
                } else {
                    f3 = 0.0f;
                }
                float f4 = a.this.RO > 0.0d ? (float) a.this.RO : 1.0f;
                boolean z3 = criusMeasureMode == CriusMeasureMode.UNDEFINED || f < 0.0f;
                if (isBoring == null && (z3 || (!CriusConstants.isUndefined(desiredWidth) && desiredWidth <= f))) {
                    int ceil = (int) Math.ceil(desiredWidth);
                    if (Build.VERSION.SDK_INT < 23) {
                        build2 = new StaticLayout(spannableString, paint, ceil, Layout.Alignment.ALIGN_NORMAL, f4, f3, false);
                    } else {
                        StaticLayout.Builder hyphenationFrequency = StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), paint, ceil).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(f3, f4).setIncludePad(false).setBreakStrategy(a.this.Ru).setHyphenationFrequency(a.this.Rv);
                        if (Build.VERSION.SDK_INT >= 26) {
                            hyphenationFrequency.setJustificationMode(a.this.Rw);
                        }
                        a.this.a(hyphenationFrequency, true);
                        build2 = hyphenationFrequency.build();
                    }
                    z2 = false;
                    build = build2;
                } else if (isBoring != null && (z3 || isBoring.width <= f)) {
                    build = BoringLayout.make(spannableString, paint, isBoring.width, Layout.Alignment.ALIGN_NORMAL, f4, f3, isBoring, false);
                    z2 = true;
                } else if (Build.VERSION.SDK_INT < 23) {
                    Layout staticLayout = new StaticLayout(spannableString, paint, (int) f, Layout.Alignment.ALIGN_NORMAL, f4, f3, false);
                    z2 = false;
                    build = staticLayout;
                } else {
                    StaticLayout.Builder hyphenationFrequency2 = StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), paint, (int) f).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(f3, f4).setIncludePad(false).setBreakStrategy(a.this.Ru).setHyphenationFrequency(a.this.Rv);
                    if (Build.VERSION.SDK_INT >= 26) {
                        hyphenationFrequency2.setJustificationMode(a.this.Rw);
                    }
                    a.this.a(hyphenationFrequency2, true);
                    z2 = false;
                    build = hyphenationFrequency2.build();
                }
                if (build != null && a.this.maxLines < build.getLineCount()) {
                    return CriusMeasureOutput.make(a.this.H(build.getWidth()), a.this.G(build.getLineBottom(a.this.maxLines - 1)) - f3);
                }
                if (build != null) {
                    float H = a.this.H(build.getWidth());
                    float G = a.this.G(build.getHeight());
                    if (!z2) {
                        boolean z4 = false;
                        if (TbadkCoreApplication.getInst().isMIUIRom()) {
                            if (Build.VERSION.SDK_INT < 23) {
                                z4 = true;
                            }
                        } else {
                            z4 = true;
                        }
                        if (z4) {
                            float lineDescent = (build.getLineDescent(0) - build.getLineAscent(0)) - f3;
                            float lineCount = ((build.getLineCount() - 1) * f3) + (build.getLineCount() * lineDescent);
                            if (lineDescent > 0.0f && G > lineCount) {
                                G -= f3;
                            }
                        }
                    }
                    return CriusMeasureOutput.make(H, G);
                }
                return CriusMeasureOutput.make(f, f2);
            }
        };
        this.SQ = -10000.0d;
        this.Ry = new CriusNode();
        this.businessConverter = interfaceC0048a;
        this.density = context.getResources().getDisplayMetrics().density;
        this.Qz = context.getResources().getDisplayMetrics().widthPixels;
        this.QB = context.getResources().getDisplayMetrics().heightPixels;
        this.Rz = new TextView(context);
        d(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("style");
        if (optJSONObject != null) {
            e(optJSONObject);
            i(optJSONObject);
            h(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("night-style");
        if (optJSONObject2 != null) {
            g(optJSONObject2);
            f(optJSONObject2);
        }
        if (jSONObject.has("children")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("children");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.SW = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    a aVar = new a(context, optJSONArray.optJSONObject(i), interfaceC0048a, false);
                    this.SW.add(aVar);
                    this.Ry.addChildAt(aVar.Ry, i);
                }
            } else {
                this.SW = null;
            }
        } else {
            this.SW = null;
        }
        if (z) {
            this.Rx = new CriusNode();
            this.Rx.addChildAt(this.Ry, 0);
            this.Rx.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    public double nR() {
        return this.fontSize;
    }

    private int nS() {
        return "italic".equalsIgnoreCase(this.SA) ? (TextUtils.isEmpty(this.SB) || "normal".equalsIgnoreCase(this.SB) || !"bold".equalsIgnoreCase(this.SB)) ? 2 : 3 : (TextUtils.isEmpty(this.SB) || "normal".equalsIgnoreCase(this.SB) || !"bold".equalsIgnoreCase(this.SB)) ? 0 : 1;
    }

    private int nT() {
        int i;
        if ("left".equalsIgnoreCase(this.SD)) {
            i = 3;
        } else if (HorizontalTranslateLayout.RIGHT.equalsIgnoreCase(this.SD)) {
            i = 5;
        } else if ("center".equalsIgnoreCase(this.SD)) {
            i = 1;
        } else {
            i = 0;
        }
        if (VerticalTranslateLayout.TOP.equalsIgnoreCase(this.SF)) {
            return i | 48;
        }
        if (VerticalTranslateLayout.BOTTOM.equalsIgnoreCase(this.SF)) {
            return i | 80;
        }
        if ("middle".equalsIgnoreCase(this.SF)) {
            return i | 16;
        }
        return i | 0;
    }

    private void nU() {
        if (this.Sr >= 0.0d) {
            this.Ry.setMaxWidth(d(this.Sr));
        } else if (this.Sr > -10000.0d) {
            this.Ry.setMaxWidth(this.Qz);
        }
    }

    private void nV() {
        if (this.St > 0.0d) {
            this.Ry.setAspectRatio((float) this.St);
        }
    }

    private void nW() {
        if (this.Ss >= 0.0d) {
            this.Ry.setMaxHeight(d(this.Ss));
        } else if (this.Ss > -10000.0d) {
            this.Ry.setMaxHeight(this.QB);
        }
    }

    private void nX() {
        if (this.Sq >= 0.0d) {
            this.Ry.setMinHeight(d(this.Sq));
        } else if (this.Sq > -10000.0d) {
            this.Ry.setMinHeight(this.QB);
        }
    }

    private void nY() {
        if (this.Sp >= 0.0d) {
            this.Ry.setMinWidth(d(this.Sp));
        } else if (this.Sp > -10000.0d) {
            this.Ry.setMinWidth(this.Qz);
        }
    }

    private void nZ() {
        if (this.height >= 0.0d) {
            this.Ry.setHeight(d(this.height));
        } else if (this.height > -10000.0d) {
            this.Ry.setHeight(this.QB);
        }
    }

    private void oa() {
        if (this.width >= 0.0d) {
            this.Ry.setWidth(d(this.width));
        } else if (this.width > -10000.0d) {
            this.Ry.setWidth(this.Qz);
        }
    }

    private void ob() {
        if (this.Sl >= -1.0d) {
            this.Ry.setPadding(CriusEdge.LEFT, d(this.Sl));
        }
    }

    private void oc() {
        if (this.So >= -1.0d) {
            this.Ry.setPadding(CriusEdge.BOTTOM, d(this.So));
        }
    }

    private void od() {
        if (this.Sn >= -1.0d) {
            this.Ry.setPadding(CriusEdge.RIGHT, d(this.Sn));
        }
    }

    private void oe() {
        if (this.Sm >= -1.0d) {
            this.Ry.setPadding(CriusEdge.TOP, d(this.Sm));
        }
    }

    private void initPadding() {
        if (this.Sk >= -1.0d) {
            this.Ry.setPadding(CriusEdge.ALL, d(this.Sk));
        }
    }

    private void og() {
        if (this.Sg >= -1.0d) {
            this.Ry.setMargin(CriusEdge.LEFT, d(this.Sg));
        }
    }

    private void oh() {
        if (this.Sj >= -1.0d) {
            this.Ry.setMargin(CriusEdge.BOTTOM, d(this.Sj));
        }
    }

    private void oi() {
        if (this.Si >= -1.0d) {
            this.Ry.setMargin(CriusEdge.RIGHT, d(this.Si));
        }
    }

    private void oj() {
        if (this.Sh >= -1.0d) {
            this.Ry.setMargin(CriusEdge.TOP, d(this.Sh));
        }
    }

    private void ok() {
        if (this.Sf >= -1.0d) {
            this.Ry.setMargin(CriusEdge.ALL, d(this.Sf));
        }
    }

    private void ol() {
        if (this.RZ >= -1.0d) {
            this.Ry.setFlexBasis(d(this.RZ));
        }
    }

    private void om() {
        if (this.RY >= -1.0d) {
            this.Ry.setFlexShrink((float) this.RY);
        }
    }

    private void on() {
        if (this.RX >= -1.0d) {
            this.Ry.setFlexGrow((float) this.RX);
        }
    }

    private void oo() {
        if (this.RW >= -1.0d) {
            this.Ry.setFlex((float) this.RW);
        }
    }

    private void op() {
        if (!TextUtils.isEmpty(this.RP)) {
            if ("flex".equalsIgnoreCase(this.RP)) {
                this.Ry.setDisplay(CriusDisplay.FLEX);
            } else if ("none".equalsIgnoreCase(this.RP)) {
                this.Ry.setDisplay(CriusDisplay.NONE);
            } else {
                this.Ry.setDisplay(CriusDisplay.FLEX);
            }
        }
    }

    private void oq() {
        if (!b.b(this.Sa, -10000.0d)) {
            this.Ry.setPosition(CriusEdge.LEFT, d(this.Sa));
        }
        if (!b.b(this.Sb, -10000.0d)) {
            this.Ry.setPosition(CriusEdge.TOP, d(this.Sb));
        }
        if (!b.b(this.Sc, -10000.0d)) {
            this.Ry.setPosition(CriusEdge.RIGHT, d(this.Sc));
        }
        if (!b.b(this.Se, -10000.0d)) {
            this.Ry.setPosition(CriusEdge.BOTTOM, d(this.Se));
        }
    }

    private void or() {
        if (!TextUtils.isEmpty(this.position)) {
            if ("relative".equalsIgnoreCase(this.position)) {
                this.Ry.setPositionType(CriusPositionType.RELATIVE);
            } else if ("absolute".equalsIgnoreCase(this.position)) {
                this.Ry.setPositionType(CriusPositionType.ABSOLUTE);
            }
        }
    }

    private void os() {
        if (!TextUtils.isEmpty(this.RV)) {
            if ("flex-start".equalsIgnoreCase(this.RV)) {
                this.Ry.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.RV)) {
                this.Ry.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.RV)) {
                this.Ry.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.RV)) {
                this.Ry.setAlignSelf(CriusAlign.STRETCH);
            } else if ("space-between".equalsIgnoreCase(this.RV)) {
                this.Ry.setAlignSelf(CriusAlign.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.RV)) {
                this.Ry.setAlignSelf(CriusAlign.SPACE_AROUND);
            } else {
                this.Ry.setAlignSelf(CriusAlign.FLEX_START);
            }
        }
    }

    private void ot() {
        if (!TextUtils.isEmpty(this.RU)) {
            if ("auto".equalsIgnoreCase(this.RU)) {
                this.Ry.setAlignSelf(CriusAlign.AUTO);
            } else if ("flex-start".equalsIgnoreCase(this.RU)) {
                this.Ry.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.RU)) {
                this.Ry.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.RU)) {
                this.Ry.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.RU)) {
                this.Ry.setAlignSelf(CriusAlign.STRETCH);
            } else {
                this.Ry.setAlignSelf(CriusAlign.AUTO);
            }
        }
    }

    private void ou() {
        if (!TextUtils.isEmpty(this.RT)) {
            if ("flex-start".equalsIgnoreCase(this.RT)) {
                this.Ry.setAlignItems(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.RT)) {
                this.Ry.setAlignItems(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.RT)) {
                this.Ry.setAlignItems(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.RT)) {
                this.Ry.setAlignItems(CriusAlign.STRETCH);
            } else {
                this.Ry.setAlignItems(CriusAlign.STRETCH);
            }
        }
    }

    private void ov() {
        if (!TextUtils.isEmpty(this.RR)) {
            if ("flex-start".equalsIgnoreCase(this.RR)) {
                this.Ry.setJustifyContent(CriusJustify.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.RR)) {
                this.Ry.setJustifyContent(CriusJustify.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.RR)) {
                this.Ry.setJustifyContent(CriusJustify.FLEX_END);
            } else if ("space-between".equalsIgnoreCase(this.RR)) {
                this.Ry.setJustifyContent(CriusJustify.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.RR)) {
                this.Ry.setJustifyContent(CriusJustify.SPACE_AROUND);
            } else {
                this.Ry.setJustifyContent(CriusJustify.FLEX_START);
            }
        }
    }

    private void ow() {
        if (!TextUtils.isEmpty(this.RQ)) {
            if ("column".equalsIgnoreCase(this.RQ)) {
                this.Ry.setFlexDirection(CriusFlexDirection.COLUMN);
            } else if ("column-reverse".equalsIgnoreCase(this.RQ)) {
                this.Ry.setFlexDirection(CriusFlexDirection.COLUMN_REVERSE);
            } else if ("row".equalsIgnoreCase(this.RQ)) {
                this.Ry.setFlexDirection(CriusFlexDirection.ROW);
            } else if ("row-reverse".equalsIgnoreCase(this.RQ)) {
                this.Ry.setFlexDirection(CriusFlexDirection.ROW_REVERSE);
            } else {
                this.Ry.setFlexDirection(CriusFlexDirection.COLUMN);
            }
        }
    }

    public boolean ox() {
        return "text".equals(this.type);
    }

    public a cs(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.id)) {
            if (this.SW != null && this.SW.size() > 0) {
                for (a aVar : this.SW) {
                    a cs = aVar.cs(str);
                    if (cs != null) {
                        return cs;
                    }
                }
            }
            return null;
        }
        return this;
    }

    public a ct(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.RB)) {
            if (this.SW != null && this.SW.size() > 0) {
                for (a aVar : this.SW) {
                    a ct = aVar.ct(str);
                    if (ct != null) {
                        return ct;
                    }
                }
            }
            return null;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float d(double d) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (this.density * d);
    }

    public static float a(double d, float f) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (f * d);
    }

    public boolean cu(String str) {
        a ct;
        if (this.Rx == null || (ct = ct(str)) == null || ct.Ry == null) {
            return false;
        }
        ct.Ry.setDisplay(CriusDisplay.NONE);
        ct.Ry.dirty();
        this.Rx.calculateLayout(Float.NaN, Float.NaN);
        return true;
    }

    public void c(String str, float f) {
        a cs;
        if (this.Rx != null && (cs = cs(str)) != null && cs.Ry != null) {
            cs.fontSize = f;
            cs.Ry.dirty();
            this.Rx.calculateLayout(Float.NaN, Float.NaN);
        }
    }
}

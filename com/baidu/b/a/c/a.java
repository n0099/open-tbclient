package com.baidu.b.a.c;

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
import com.baidu.b.a.e.c;
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
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
@TargetApi(23)
/* loaded from: classes13.dex */
public class a {
    public final int alk;
    public final int alm;
    public double anA;
    private String anB;
    private String anC;
    private String anD;
    private String anE;
    private String anF;
    private String anG;
    private double anH;
    private double anI;
    private double anJ;
    private double anK;
    private double anL;
    private double anM;
    private double anN;
    private double anO;
    private double anP;
    private double anQ;
    private double anR;
    private double anS;
    private double anT;
    private double anU;
    private double anV;
    private double anW;
    private double anX;
    private double anY;
    private double anZ;
    public String anc;
    protected int anh;
    protected int ani;
    protected int anj;
    private CriusNode ank;
    public final CriusNode anl;
    public final float anm;
    private TextView ann;
    private final CriusMeasureFunction ano;
    public String anp;
    public String anq;
    public String anr;
    public String ans;
    public String ant;
    public int anu;
    public int anv;
    public int anw;
    public String anx;
    public String any;
    public double anz;
    public String aoA;
    public String aoB;
    public final List<a> aoC;
    private double aoa;
    private double aob;
    private double aoc;
    private double aod;
    public String aoe;
    public double aof;
    public double aog;
    public double aoh;
    public double aoi;
    public double aoj;
    public String aok;
    public String aol;
    public Typeface aom;
    public String aon;
    public String aoo;
    public String aop;
    public String aoq;
    public String aor;
    public String aos;
    public String aot;
    public String aou;
    public String aov;
    public double aow;
    public String aox;
    public String aoy;
    public String aoz;
    public String backgroundColor;
    public String borderColor;
    public double borderRadius;
    private InterfaceC0089a businessConverter;
    public String color;
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

    /* renamed from: com.baidu.b.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0089a {
        String dQ(String str);
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
            if (Double.compare(aVar.th(), 0.0d) > 0) {
                textView.setTextSize(0, (float) (aVar.th() * textView.getContext().getResources().getDisplayMetrics().density));
            }
            textView.setIncludeFontPadding(false);
            textView.setTypeface(aVar.aom);
            textView.setGravity(aVar.gravity);
            float h = aVar.anz > 0.0d ? h(aVar.anz) : 0.0f;
            float f = aVar.anA > 0.0d ? (float) aVar.anA : 1.0f;
            if (h > 0.0f || f > 0.0f) {
                textView.setLineSpacing(h, f);
            }
        }
    }

    public static boolean dM(String str) {
        return Pattern.compile("[^一-龥]").matcher(str).find();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float n(float f) {
        if (Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) {
            return (1.12f * f) + 0.5f;
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float o(float f) {
        if ((Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) && this.maxLines == 1 && dM(this.text)) {
            return (1.09859f * f) + 0.5f;
        }
        return f;
    }

    private void i(JSONObject jSONObject) {
        this.id = c.l(jSONObject, "id");
        this.name = c.l(jSONObject, "name");
        this.type = c.l(jSONObject, "type");
        if (tN()) {
            this.anl.setMeasureFunction(this.ano);
        }
        this.anp = c.l(jSONObject, "component");
        this.src = c.l(jSONObject, UserAccountActionItem.KEY_SRC);
        this.poster = c.l(jSONObject, "poster");
        this.anq = c.l(jSONObject, "href");
        this.text = c.l(jSONObject, "text");
        if ("time".equalsIgnoreCase(this.anp) && this.businessConverter != null) {
            this.text = this.businessConverter.dQ(this.text);
        }
        this.maxLines = jSONObject.optInt("max-lines", 1);
        this.anz = c.m(jSONObject, "line-space");
        this.anA = c.m(jSONObject, "line-multi");
        this.videoDuration = jSONObject.optInt("data-video-duration");
        this.anr = jSONObject.optString("data-als-stat");
        this.ans = jSONObject.optString("data-url-stat");
        this.ant = jSONObject.optString("data-href-pop");
        this.anu = c.n(jSONObject, "data-share-num");
        this.anv = c.n(jSONObject, "data-reply-num");
        this.anw = c.n(jSONObject, "data-agree-num");
        this.shareTitle = jSONObject.optString("data-share-title");
        this.shareContent = jSONObject.optString("data-share-content");
        this.anx = jSONObject.optString("data-share-image");
        this.any = jSONObject.optString("data-share-link");
    }

    private void j(JSONObject jSONObject) {
        this.anB = c.l(jSONObject, "display");
        tF();
        this.anC = c.l(jSONObject, "flex-direction");
        tM();
        this.anD = c.l(jSONObject, "justify-content");
        tL();
        this.anE = c.l(jSONObject, "align-items");
        tK();
        this.anF = c.l(jSONObject, "align-self");
        tJ();
        this.anG = c.l(jSONObject, "align-content");
        tI();
        this.anH = c.m(jSONObject, "flex");
        tE();
        this.anI = c.m(jSONObject, "flex-grow");
        tD();
        this.anJ = c.m(jSONObject, "flex-shrink");
        tC();
        this.anK = c.m(jSONObject, "flex-basis");
        tB();
        this.position = c.l(jSONObject, "position");
        tH();
        this.anL = c.m(jSONObject, "left");
        this.anM = c.m(jSONObject, VerticalTranslateLayout.TOP);
        this.anN = c.m(jSONObject, HorizontalTranslateLayout.DIRECTION_RIGHT);
        this.anO = c.m(jSONObject, VerticalTranslateLayout.BOTTOM);
        tG();
        this.anP = c.m(jSONObject, "margin");
        tA();
        this.anQ = c.m(jSONObject, "margin-left");
        tw();
        this.anR = c.m(jSONObject, "margin-top");
        tz();
        this.anS = c.m(jSONObject, "margin-right");
        ty();
        this.anT = c.m(jSONObject, "margin-bottom");
        tx();
        this.anU = c.m(jSONObject, "padding");
        initPadding();
        this.anV = c.m(jSONObject, "padding-left");
        ts();
        this.anW = c.m(jSONObject, "padding-top");
        tv();
        this.anX = c.m(jSONObject, "padding-right");
        tu();
        this.anY = c.m(jSONObject, "padding-bottom");
        tt();
        this.width = c.m(jSONObject, "width");
        tr();
        this.height = c.m(jSONObject, "height");
        tq();
        this.anZ = c.m(jSONObject, "min-width");
        tp();
        this.aoa = c.m(jSONObject, "min-height");
        tn();
        this.aob = c.m(jSONObject, "max-width");
        tk();
        this.aoc = c.m(jSONObject, "max-height");
        tm();
        this.aod = c.m(jSONObject, "aspect-ratio");
        tl();
    }

    private void k(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SharedPrefConfig.ACTIVE_STATE)) != null) {
            this.aoy = c.l(optJSONObject, "background-image");
            this.aoz = c.l(optJSONObject, "background-color");
            this.aoA = c.l(optJSONObject, "border-color");
            this.aoB = c.l(optJSONObject, "color");
        }
    }

    private void l(JSONObject jSONObject) {
        this.aot = c.l(jSONObject, "background-image");
        this.aou = c.l(jSONObject, "background-color");
        this.aov = c.l(jSONObject, "border-color");
        this.aow = c.m(jSONObject, "opacity");
        this.aox = c.l(jSONObject, "color");
    }

    private void m(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SharedPrefConfig.ACTIVE_STATE)) != null) {
            this.aop = c.l(optJSONObject, "background-image");
            this.aoq = c.l(optJSONObject, "background-color");
            this.aor = c.l(optJSONObject, "border-color");
            this.aos = c.l(optJSONObject, "color");
        }
    }

    private void n(JSONObject jSONObject) {
        this.aoe = c.l(jSONObject, "background-image");
        this.backgroundColor = c.l(jSONObject, "background-color");
        this.borderColor = c.l(jSONObject, "border-color");
        this.opacity = c.m(jSONObject, "opacity");
        this.color = c.l(jSONObject, "color");
        this.aof = c.m(jSONObject, "border-width");
        this.borderRadius = c.m(jSONObject, "border-radius");
        this.aog = c.m(jSONObject, "border-top-left-radius");
        this.aoh = c.m(jSONObject, "border-bottom-left-radius");
        this.aoi = c.m(jSONObject, "border-top-right-radius");
        this.aoj = c.m(jSONObject, "border-bottom-right-radius");
        this.aok = c.l(jSONObject, "font-style");
        this.aol = c.l(jSONObject, "font-weight");
        this.aom = Typeface.create(Typeface.DEFAULT, ti());
        this.fontSize = jSONObject.optDouble("font-size", 12.0d);
        this.aon = c.l(jSONObject, "text-align");
        this.aoo = c.l(jSONObject, "vertical-align");
        this.gravity = tj();
        this.anc = c.l(jSONObject, "download-style");
    }

    public a(Context context, JSONObject jSONObject, InterfaceC0089a interfaceC0089a, boolean z) {
        this.anh = Build.VERSION.SDK_INT < 23 ? 0 : 1;
        if (Build.VERSION.SDK_INT < 23) {
        }
        this.ani = 0;
        if (Build.VERSION.SDK_INT < 26) {
        }
        this.anj = 0;
        this.ano = new CriusMeasureFunction() { // from class: com.baidu.b.a.c.a.1
            @Override // com.baidu.crius.CriusMeasureFunction
            @SuppressLint({"WrongConstant"})
            public long measure(CriusNode criusNode, float f, CriusMeasureMode criusMeasureMode, float f2, CriusMeasureMode criusMeasureMode2) {
                float f3;
                boolean z2;
                Layout build;
                Layout build2;
                SpannableString spannableString = new SpannableString(a.this.text);
                a.this.a(a.this.ann, a.this);
                TextPaint paint = a.this.ann.getPaint();
                BoringLayout.Metrics isBoring = BoringLayout.isBoring(spannableString, paint);
                float desiredWidth = isBoring == null ? Layout.getDesiredWidth(spannableString, paint) : Float.NaN;
                if (a.this.anz > 0.0d) {
                    f3 = a.this.h(a.this.anz);
                } else {
                    f3 = 0.0f;
                }
                float f4 = a.this.anA > 0.0d ? (float) a.this.anA : 1.0f;
                boolean z3 = criusMeasureMode == CriusMeasureMode.UNDEFINED || f < 0.0f;
                if (isBoring == null && (z3 || (!CriusConstants.isUndefined(desiredWidth) && desiredWidth <= f))) {
                    int ceil = (int) Math.ceil(desiredWidth);
                    if (Build.VERSION.SDK_INT < 23) {
                        build2 = new StaticLayout(spannableString, paint, ceil, Layout.Alignment.ALIGN_NORMAL, f4, f3, false);
                    } else {
                        StaticLayout.Builder hyphenationFrequency = StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), paint, ceil).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(f3, f4).setIncludePad(false).setBreakStrategy(a.this.anh).setHyphenationFrequency(a.this.ani);
                        if (Build.VERSION.SDK_INT >= 26) {
                            hyphenationFrequency.setJustificationMode(a.this.anj);
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
                    StaticLayout.Builder hyphenationFrequency2 = StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), paint, (int) f).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(f3, f4).setIncludePad(false).setBreakStrategy(a.this.anh).setHyphenationFrequency(a.this.ani);
                    if (Build.VERSION.SDK_INT >= 26) {
                        hyphenationFrequency2.setJustificationMode(a.this.anj);
                    }
                    a.this.a(hyphenationFrequency2, true);
                    z2 = false;
                    build = hyphenationFrequency2.build();
                }
                if (build != null && a.this.maxLines < build.getLineCount()) {
                    return CriusMeasureOutput.make(a.this.o(build.getWidth()), a.this.n(build.getLineBottom(a.this.maxLines - 1)) - f3);
                }
                if (build != null) {
                    float o = a.this.o(build.getWidth());
                    float n = a.this.n(build.getHeight());
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
                            if (lineDescent > 0.0f && n > lineCount) {
                                n -= f3;
                            }
                        }
                    }
                    return CriusMeasureOutput.make(o, n);
                }
                return CriusMeasureOutput.make(f, f2);
            }
        };
        this.aow = -10000.0d;
        this.anl = new CriusNode();
        this.businessConverter = interfaceC0089a;
        this.anm = context.getResources().getDisplayMetrics().density;
        this.alk = context.getResources().getDisplayMetrics().widthPixels;
        this.alm = context.getResources().getDisplayMetrics().heightPixels;
        this.ann = new TextView(context);
        i(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("style");
        if (optJSONObject != null) {
            j(optJSONObject);
            n(optJSONObject);
            m(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("night-style");
        if (optJSONObject2 != null) {
            l(optJSONObject2);
            k(optJSONObject2);
        }
        if (jSONObject.has("children")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("children");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.aoC = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    a aVar = new a(context, optJSONArray.optJSONObject(i), interfaceC0089a, false);
                    this.aoC.add(aVar);
                    this.anl.addChildAt(aVar.anl, i);
                }
            } else {
                this.aoC = null;
            }
        } else {
            this.aoC = null;
        }
        if (z) {
            this.ank = new CriusNode();
            this.ank.addChildAt(this.anl, 0);
            this.ank.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    public double th() {
        return this.fontSize;
    }

    private int ti() {
        return "italic".equalsIgnoreCase(this.aok) ? (TextUtils.isEmpty(this.aol) || "normal".equalsIgnoreCase(this.aol) || !"bold".equalsIgnoreCase(this.aol)) ? 2 : 3 : (TextUtils.isEmpty(this.aol) || "normal".equalsIgnoreCase(this.aol) || !"bold".equalsIgnoreCase(this.aol)) ? 0 : 1;
    }

    private int tj() {
        int i;
        if ("left".equalsIgnoreCase(this.aon)) {
            i = 3;
        } else if (HorizontalTranslateLayout.DIRECTION_RIGHT.equalsIgnoreCase(this.aon)) {
            i = 5;
        } else if ("center".equalsIgnoreCase(this.aon)) {
            i = 1;
        } else {
            i = 0;
        }
        if (VerticalTranslateLayout.TOP.equalsIgnoreCase(this.aoo)) {
            return i | 48;
        }
        if (VerticalTranslateLayout.BOTTOM.equalsIgnoreCase(this.aoo)) {
            return i | 80;
        }
        if ("middle".equalsIgnoreCase(this.aoo)) {
            return i | 16;
        }
        return i | 0;
    }

    private void tk() {
        if (this.aob >= 0.0d) {
            this.anl.setMaxWidth(h(this.aob));
        } else if (this.aob > -10000.0d) {
            this.anl.setMaxWidth(this.alk);
        }
    }

    private void tl() {
        if (this.aod > 0.0d) {
            this.anl.setAspectRatio((float) this.aod);
        }
    }

    private void tm() {
        if (this.aoc >= 0.0d) {
            this.anl.setMaxHeight(h(this.aoc));
        } else if (this.aoc > -10000.0d) {
            this.anl.setMaxHeight(this.alm);
        }
    }

    private void tn() {
        if (this.aoa >= 0.0d) {
            this.anl.setMinHeight(h(this.aoa));
        } else if (this.aoa > -10000.0d) {
            this.anl.setMinHeight(this.alm);
        }
    }

    private void tp() {
        if (this.anZ >= 0.0d) {
            this.anl.setMinWidth(h(this.anZ));
        } else if (this.anZ > -10000.0d) {
            this.anl.setMinWidth(this.alk);
        }
    }

    private void tq() {
        if (this.height >= 0.0d) {
            this.anl.setHeight(h(this.height));
        } else if (this.height > -10000.0d) {
            this.anl.setHeight(this.alm);
        }
    }

    private void tr() {
        if (this.width >= 0.0d) {
            this.anl.setWidth(h(this.width));
        } else if (this.width > -10000.0d) {
            this.anl.setWidth(this.alk);
        }
    }

    private void ts() {
        if (this.anV >= -1.0d) {
            this.anl.setPadding(CriusEdge.LEFT, h(this.anV));
        }
    }

    private void tt() {
        if (this.anY >= -1.0d) {
            this.anl.setPadding(CriusEdge.BOTTOM, h(this.anY));
        }
    }

    private void tu() {
        if (this.anX >= -1.0d) {
            this.anl.setPadding(CriusEdge.RIGHT, h(this.anX));
        }
    }

    private void tv() {
        if (this.anW >= -1.0d) {
            this.anl.setPadding(CriusEdge.TOP, h(this.anW));
        }
    }

    private void initPadding() {
        if (this.anU >= -1.0d) {
            this.anl.setPadding(CriusEdge.ALL, h(this.anU));
        }
    }

    private void tw() {
        if (this.anQ >= -1.0d) {
            this.anl.setMargin(CriusEdge.LEFT, h(this.anQ));
        }
    }

    private void tx() {
        if (this.anT >= -1.0d) {
            this.anl.setMargin(CriusEdge.BOTTOM, h(this.anT));
        }
    }

    private void ty() {
        if (this.anS >= -1.0d) {
            this.anl.setMargin(CriusEdge.RIGHT, h(this.anS));
        }
    }

    private void tz() {
        if (this.anR >= -1.0d) {
            this.anl.setMargin(CriusEdge.TOP, h(this.anR));
        }
    }

    private void tA() {
        if (this.anP >= -1.0d) {
            this.anl.setMargin(CriusEdge.ALL, h(this.anP));
        }
    }

    private void tB() {
        if (this.anK >= -1.0d) {
            this.anl.setFlexBasis(h(this.anK));
        }
    }

    private void tC() {
        if (this.anJ >= -1.0d) {
            this.anl.setFlexShrink((float) this.anJ);
        }
    }

    private void tD() {
        if (this.anI >= -1.0d) {
            this.anl.setFlexGrow((float) this.anI);
        }
    }

    private void tE() {
        if (this.anH >= -1.0d) {
            this.anl.setFlex((float) this.anH);
        }
    }

    private void tF() {
        if (!TextUtils.isEmpty(this.anB)) {
            if ("flex".equalsIgnoreCase(this.anB)) {
                this.anl.setDisplay(CriusDisplay.FLEX);
            } else if ("none".equalsIgnoreCase(this.anB)) {
                this.anl.setDisplay(CriusDisplay.NONE);
            } else {
                this.anl.setDisplay(CriusDisplay.FLEX);
            }
        }
    }

    private void tG() {
        if (!c.b(this.anL, -10000.0d)) {
            this.anl.setPosition(CriusEdge.LEFT, h(this.anL));
        }
        if (!c.b(this.anM, -10000.0d)) {
            this.anl.setPosition(CriusEdge.TOP, h(this.anM));
        }
        if (!c.b(this.anN, -10000.0d)) {
            this.anl.setPosition(CriusEdge.RIGHT, h(this.anN));
        }
        if (!c.b(this.anO, -10000.0d)) {
            this.anl.setPosition(CriusEdge.BOTTOM, h(this.anO));
        }
    }

    private void tH() {
        if (!TextUtils.isEmpty(this.position)) {
            if ("relative".equalsIgnoreCase(this.position)) {
                this.anl.setPositionType(CriusPositionType.RELATIVE);
            } else if ("absolute".equalsIgnoreCase(this.position)) {
                this.anl.setPositionType(CriusPositionType.ABSOLUTE);
            }
        }
    }

    private void tI() {
        if (!TextUtils.isEmpty(this.anG)) {
            if ("flex-start".equalsIgnoreCase(this.anG)) {
                this.anl.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.anG)) {
                this.anl.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.anG)) {
                this.anl.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.anG)) {
                this.anl.setAlignSelf(CriusAlign.STRETCH);
            } else if ("space-between".equalsIgnoreCase(this.anG)) {
                this.anl.setAlignSelf(CriusAlign.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.anG)) {
                this.anl.setAlignSelf(CriusAlign.SPACE_AROUND);
            } else {
                this.anl.setAlignSelf(CriusAlign.FLEX_START);
            }
        }
    }

    private void tJ() {
        if (!TextUtils.isEmpty(this.anF)) {
            if ("auto".equalsIgnoreCase(this.anF)) {
                this.anl.setAlignSelf(CriusAlign.AUTO);
            } else if ("flex-start".equalsIgnoreCase(this.anF)) {
                this.anl.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.anF)) {
                this.anl.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.anF)) {
                this.anl.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.anF)) {
                this.anl.setAlignSelf(CriusAlign.STRETCH);
            } else {
                this.anl.setAlignSelf(CriusAlign.AUTO);
            }
        }
    }

    private void tK() {
        if (!TextUtils.isEmpty(this.anE)) {
            if ("flex-start".equalsIgnoreCase(this.anE)) {
                this.anl.setAlignItems(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.anE)) {
                this.anl.setAlignItems(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.anE)) {
                this.anl.setAlignItems(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.anE)) {
                this.anl.setAlignItems(CriusAlign.STRETCH);
            } else {
                this.anl.setAlignItems(CriusAlign.STRETCH);
            }
        }
    }

    private void tL() {
        if (!TextUtils.isEmpty(this.anD)) {
            if ("flex-start".equalsIgnoreCase(this.anD)) {
                this.anl.setJustifyContent(CriusJustify.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.anD)) {
                this.anl.setJustifyContent(CriusJustify.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.anD)) {
                this.anl.setJustifyContent(CriusJustify.FLEX_END);
            } else if ("space-between".equalsIgnoreCase(this.anD)) {
                this.anl.setJustifyContent(CriusJustify.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.anD)) {
                this.anl.setJustifyContent(CriusJustify.SPACE_AROUND);
            } else {
                this.anl.setJustifyContent(CriusJustify.FLEX_START);
            }
        }
    }

    private void tM() {
        if (!TextUtils.isEmpty(this.anC)) {
            if ("column".equalsIgnoreCase(this.anC)) {
                this.anl.setFlexDirection(CriusFlexDirection.COLUMN);
            } else if ("column-reverse".equalsIgnoreCase(this.anC)) {
                this.anl.setFlexDirection(CriusFlexDirection.COLUMN_REVERSE);
            } else if ("row".equalsIgnoreCase(this.anC)) {
                this.anl.setFlexDirection(CriusFlexDirection.ROW);
            } else if ("row-reverse".equalsIgnoreCase(this.anC)) {
                this.anl.setFlexDirection(CriusFlexDirection.ROW_REVERSE);
            } else {
                this.anl.setFlexDirection(CriusFlexDirection.COLUMN);
            }
        }
    }

    public boolean tN() {
        return "text".equals(this.type);
    }

    public a dN(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.id)) {
            if (this.aoC != null && this.aoC.size() > 0) {
                for (a aVar : this.aoC) {
                    a dN = aVar.dN(str);
                    if (dN != null) {
                        return dN;
                    }
                }
            }
            return null;
        }
        return this;
    }

    public a dO(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.anp)) {
            if (this.aoC != null && this.aoC.size() > 0) {
                for (a aVar : this.aoC) {
                    a dO = aVar.dO(str);
                    if (dO != null) {
                        return dO;
                    }
                }
            }
            return null;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float h(double d) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (this.anm * d);
    }

    public static float a(double d, float f) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (f * d);
    }

    public boolean dP(String str) {
        a dO;
        if (this.ank == null || (dO = dO(str)) == null || dO.anl == null) {
            return false;
        }
        dO.anl.setDisplay(CriusDisplay.NONE);
        dO.anl.dirty();
        this.ank.calculateLayout(Float.NaN, Float.NaN);
        return true;
    }

    public void c(String str, float f) {
        a dN;
        if (this.ank != null && (dN = dN(str)) != null && dN.anl != null) {
            dN.fontSize = f;
            dN.anl.dirty();
            this.ank.calculateLayout(Float.NaN, Float.NaN);
        }
    }
}

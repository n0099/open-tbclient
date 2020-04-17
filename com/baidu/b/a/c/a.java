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
    public final int akA;
    public final int akz;
    protected int alA;
    protected int alB;
    private CriusNode alC;
    public final CriusNode alD;
    public final float alE;
    private TextView alF;
    private final CriusMeasureFunction alG;
    public String alH;
    public String alI;
    public String alJ;
    public String alK;
    public String alL;
    public int alM;
    public int alN;
    public int alO;
    public String alP;
    public String alQ;
    public double alR;
    public double alS;
    private String alT;
    private String alU;
    private String alV;
    private String alW;
    private String alX;
    private String alY;
    private double alZ;
    public String alu;
    protected int alz;
    public double amA;
    public double amB;
    public String amC;
    public String amD;
    public Typeface amE;
    public String amF;
    public String amG;
    public String amH;
    public String amI;
    public String amJ;
    public String amK;
    public String amL;
    public String amM;
    public String amN;
    public double amO;
    public String amP;
    public String amQ;
    public String amR;
    public String amS;
    public String amT;
    public final List<a> amU;
    private double ama;
    private double amb;
    private double amc;
    private double amd;
    private double ame;
    private double amf;
    private double amg;
    private double amh;
    private double ami;
    private double amj;
    private double amk;
    private double aml;
    private double amm;
    private double amn;
    private double amo;
    private double amp;
    private double amq;
    private double amr;
    private double ams;
    private double amt;
    private double amu;
    private double amv;
    public String amw;
    public double amx;
    public double amy;
    public double amz;
    public String backgroundColor;
    public String borderColor;
    public double borderRadius;
    private InterfaceC0066a businessConverter;
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
    public interface InterfaceC0066a {
        String dx(String str);
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
            if (Double.compare(aVar.sZ(), 0.0d) > 0) {
                textView.setTextSize(0, (float) (aVar.sZ() * textView.getContext().getResources().getDisplayMetrics().density));
            }
            textView.setIncludeFontPadding(false);
            textView.setTypeface(aVar.amE);
            textView.setGravity(aVar.gravity);
            float h = aVar.alR > 0.0d ? h(aVar.alR) : 0.0f;
            float f = aVar.alS > 0.0d ? (float) aVar.alS : 1.0f;
            if (h > 0.0f || f > 0.0f) {
                textView.setLineSpacing(h, f);
            }
        }
    }

    public static boolean dt(String str) {
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
        if ((Build.VERSION.SDK_INT == 19 || TbadkCoreApplication.getInst().isMIUIRom()) && this.maxLines == 1 && dt(this.text)) {
            return (1.09859f * f) + 0.5f;
        }
        return f;
    }

    private void i(JSONObject jSONObject) {
        this.id = c.g(jSONObject, "id");
        this.name = c.g(jSONObject, "name");
        this.type = c.g(jSONObject, "type");
        if (tF()) {
            this.alD.setMeasureFunction(this.alG);
        }
        this.alH = c.g(jSONObject, "component");
        this.src = c.g(jSONObject, UserAccountActionItem.KEY_SRC);
        this.poster = c.g(jSONObject, "poster");
        this.alI = c.g(jSONObject, "href");
        this.text = c.g(jSONObject, "text");
        if ("time".equalsIgnoreCase(this.alH) && this.businessConverter != null) {
            this.text = this.businessConverter.dx(this.text);
        }
        this.maxLines = jSONObject.optInt("max-lines", 1);
        this.alR = c.h(jSONObject, "line-space");
        this.alS = c.h(jSONObject, "line-multi");
        this.videoDuration = jSONObject.optInt("data-video-duration");
        this.alJ = jSONObject.optString("data-als-stat");
        this.alK = jSONObject.optString("data-url-stat");
        this.alL = jSONObject.optString("data-href-pop");
        this.alM = c.i(jSONObject, "data-share-num");
        this.alN = c.i(jSONObject, "data-reply-num");
        this.alO = c.i(jSONObject, "data-agree-num");
        this.shareTitle = jSONObject.optString("data-share-title");
        this.shareContent = jSONObject.optString("data-share-content");
        this.alP = jSONObject.optString("data-share-image");
        this.alQ = jSONObject.optString("data-share-link");
    }

    private void j(JSONObject jSONObject) {
        this.alT = c.g(jSONObject, "display");
        tx();
        this.alU = c.g(jSONObject, "flex-direction");
        tE();
        this.alV = c.g(jSONObject, "justify-content");
        tD();
        this.alW = c.g(jSONObject, "align-items");
        tC();
        this.alX = c.g(jSONObject, "align-self");
        tB();
        this.alY = c.g(jSONObject, "align-content");
        tA();
        this.alZ = c.h(jSONObject, "flex");
        tw();
        this.ama = c.h(jSONObject, "flex-grow");
        tv();
        this.amb = c.h(jSONObject, "flex-shrink");
        tu();
        this.amc = c.h(jSONObject, "flex-basis");
        tt();
        this.position = c.g(jSONObject, "position");
        tz();
        this.amd = c.h(jSONObject, "left");
        this.ame = c.h(jSONObject, VerticalTranslateLayout.TOP);
        this.amf = c.h(jSONObject, HorizontalTranslateLayout.DIRECTION_RIGHT);
        this.amg = c.h(jSONObject, VerticalTranslateLayout.BOTTOM);
        ty();
        this.amh = c.h(jSONObject, "margin");
        ts();
        this.ami = c.h(jSONObject, "margin-left");
        tn();
        this.amj = c.h(jSONObject, "margin-top");
        tr();
        this.amk = c.h(jSONObject, "margin-right");
        tq();
        this.aml = c.h(jSONObject, "margin-bottom");
        tp();
        this.amm = c.h(jSONObject, "padding");
        initPadding();
        this.amn = c.h(jSONObject, "padding-left");
        tj();
        this.amo = c.h(jSONObject, "padding-top");
        tm();
        this.amp = c.h(jSONObject, "padding-right");
        tl();
        this.amq = c.h(jSONObject, "padding-bottom");
        tk();
        this.width = c.h(jSONObject, "width");
        ti();
        this.height = c.h(jSONObject, "height");
        th();
        this.amr = c.h(jSONObject, "min-width");
        tg();
        this.ams = c.h(jSONObject, "min-height");
        tf();
        this.amt = c.h(jSONObject, "max-width");
        tc();
        this.amu = c.h(jSONObject, "max-height");
        te();
        this.amv = c.h(jSONObject, "aspect-ratio");
        td();
    }

    private void k(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SharedPrefConfig.ACTIVE_STATE)) != null) {
            this.amQ = c.g(optJSONObject, "background-image");
            this.amR = c.g(optJSONObject, "background-color");
            this.amS = c.g(optJSONObject, "border-color");
            this.amT = c.g(optJSONObject, "color");
        }
    }

    private void l(JSONObject jSONObject) {
        this.amL = c.g(jSONObject, "background-image");
        this.amM = c.g(jSONObject, "background-color");
        this.amN = c.g(jSONObject, "border-color");
        this.amO = c.h(jSONObject, "opacity");
        this.amP = c.g(jSONObject, "color");
    }

    private void m(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SharedPrefConfig.ACTIVE_STATE)) != null) {
            this.amH = c.g(optJSONObject, "background-image");
            this.amI = c.g(optJSONObject, "background-color");
            this.amJ = c.g(optJSONObject, "border-color");
            this.amK = c.g(optJSONObject, "color");
        }
    }

    private void n(JSONObject jSONObject) {
        this.amw = c.g(jSONObject, "background-image");
        this.backgroundColor = c.g(jSONObject, "background-color");
        this.borderColor = c.g(jSONObject, "border-color");
        this.opacity = c.h(jSONObject, "opacity");
        this.color = c.g(jSONObject, "color");
        this.amx = c.h(jSONObject, "border-width");
        this.borderRadius = c.h(jSONObject, "border-radius");
        this.amy = c.h(jSONObject, "border-top-left-radius");
        this.amz = c.h(jSONObject, "border-bottom-left-radius");
        this.amA = c.h(jSONObject, "border-top-right-radius");
        this.amB = c.h(jSONObject, "border-bottom-right-radius");
        this.amC = c.g(jSONObject, "font-style");
        this.amD = c.g(jSONObject, "font-weight");
        this.amE = Typeface.create(Typeface.DEFAULT, ta());
        this.fontSize = jSONObject.optDouble("font-size", 12.0d);
        this.amF = c.g(jSONObject, "text-align");
        this.amG = c.g(jSONObject, "vertical-align");
        this.gravity = tb();
        this.alu = c.g(jSONObject, "download-style");
    }

    public a(Context context, JSONObject jSONObject, InterfaceC0066a interfaceC0066a, boolean z) {
        this.alz = Build.VERSION.SDK_INT < 23 ? 0 : 1;
        if (Build.VERSION.SDK_INT < 23) {
        }
        this.alA = 0;
        if (Build.VERSION.SDK_INT < 26) {
        }
        this.alB = 0;
        this.alG = new CriusMeasureFunction() { // from class: com.baidu.b.a.c.a.1
            @Override // com.baidu.crius.CriusMeasureFunction
            @SuppressLint({"WrongConstant"})
            public long measure(CriusNode criusNode, float f, CriusMeasureMode criusMeasureMode, float f2, CriusMeasureMode criusMeasureMode2) {
                float f3;
                boolean z2;
                Layout build;
                Layout build2;
                SpannableString spannableString = new SpannableString(a.this.text);
                a.this.a(a.this.alF, a.this);
                TextPaint paint = a.this.alF.getPaint();
                BoringLayout.Metrics isBoring = BoringLayout.isBoring(spannableString, paint);
                float desiredWidth = isBoring == null ? Layout.getDesiredWidth(spannableString, paint) : Float.NaN;
                if (a.this.alR > 0.0d) {
                    f3 = a.this.h(a.this.alR);
                } else {
                    f3 = 0.0f;
                }
                float f4 = a.this.alS > 0.0d ? (float) a.this.alS : 1.0f;
                boolean z3 = criusMeasureMode == CriusMeasureMode.UNDEFINED || f < 0.0f;
                if (isBoring == null && (z3 || (!CriusConstants.isUndefined(desiredWidth) && desiredWidth <= f))) {
                    int ceil = (int) Math.ceil(desiredWidth);
                    if (Build.VERSION.SDK_INT < 23) {
                        build2 = new StaticLayout(spannableString, paint, ceil, Layout.Alignment.ALIGN_NORMAL, f4, f3, false);
                    } else {
                        StaticLayout.Builder hyphenationFrequency = StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), paint, ceil).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(f3, f4).setIncludePad(false).setBreakStrategy(a.this.alz).setHyphenationFrequency(a.this.alA);
                        if (Build.VERSION.SDK_INT >= 26) {
                            hyphenationFrequency.setJustificationMode(a.this.alB);
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
                    StaticLayout.Builder hyphenationFrequency2 = StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), paint, (int) f).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(f3, f4).setIncludePad(false).setBreakStrategy(a.this.alz).setHyphenationFrequency(a.this.alA);
                    if (Build.VERSION.SDK_INT >= 26) {
                        hyphenationFrequency2.setJustificationMode(a.this.alB);
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
        this.amO = -10000.0d;
        this.alD = new CriusNode();
        this.businessConverter = interfaceC0066a;
        this.alE = context.getResources().getDisplayMetrics().density;
        this.akz = context.getResources().getDisplayMetrics().widthPixels;
        this.akA = context.getResources().getDisplayMetrics().heightPixels;
        this.alF = new TextView(context);
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
                this.amU = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    a aVar = new a(context, optJSONArray.optJSONObject(i), interfaceC0066a, false);
                    this.amU.add(aVar);
                    this.alD.addChildAt(aVar.alD, i);
                }
            } else {
                this.amU = null;
            }
        } else {
            this.amU = null;
        }
        if (z) {
            this.alC = new CriusNode();
            this.alC.addChildAt(this.alD, 0);
            this.alC.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    public double sZ() {
        return this.fontSize;
    }

    private int ta() {
        return "italic".equalsIgnoreCase(this.amC) ? (TextUtils.isEmpty(this.amD) || "normal".equalsIgnoreCase(this.amD) || !"bold".equalsIgnoreCase(this.amD)) ? 2 : 3 : (TextUtils.isEmpty(this.amD) || "normal".equalsIgnoreCase(this.amD) || !"bold".equalsIgnoreCase(this.amD)) ? 0 : 1;
    }

    private int tb() {
        int i;
        if ("left".equalsIgnoreCase(this.amF)) {
            i = 3;
        } else if (HorizontalTranslateLayout.DIRECTION_RIGHT.equalsIgnoreCase(this.amF)) {
            i = 5;
        } else if ("center".equalsIgnoreCase(this.amF)) {
            i = 1;
        } else {
            i = 0;
        }
        if (VerticalTranslateLayout.TOP.equalsIgnoreCase(this.amG)) {
            return i | 48;
        }
        if (VerticalTranslateLayout.BOTTOM.equalsIgnoreCase(this.amG)) {
            return i | 80;
        }
        if ("middle".equalsIgnoreCase(this.amG)) {
            return i | 16;
        }
        return i | 0;
    }

    private void tc() {
        if (this.amt >= 0.0d) {
            this.alD.setMaxWidth(h(this.amt));
        } else if (this.amt > -10000.0d) {
            this.alD.setMaxWidth(this.akz);
        }
    }

    private void td() {
        if (this.amv > 0.0d) {
            this.alD.setAspectRatio((float) this.amv);
        }
    }

    private void te() {
        if (this.amu >= 0.0d) {
            this.alD.setMaxHeight(h(this.amu));
        } else if (this.amu > -10000.0d) {
            this.alD.setMaxHeight(this.akA);
        }
    }

    private void tf() {
        if (this.ams >= 0.0d) {
            this.alD.setMinHeight(h(this.ams));
        } else if (this.ams > -10000.0d) {
            this.alD.setMinHeight(this.akA);
        }
    }

    private void tg() {
        if (this.amr >= 0.0d) {
            this.alD.setMinWidth(h(this.amr));
        } else if (this.amr > -10000.0d) {
            this.alD.setMinWidth(this.akz);
        }
    }

    private void th() {
        if (this.height >= 0.0d) {
            this.alD.setHeight(h(this.height));
        } else if (this.height > -10000.0d) {
            this.alD.setHeight(this.akA);
        }
    }

    private void ti() {
        if (this.width >= 0.0d) {
            this.alD.setWidth(h(this.width));
        } else if (this.width > -10000.0d) {
            this.alD.setWidth(this.akz);
        }
    }

    private void tj() {
        if (this.amn >= -1.0d) {
            this.alD.setPadding(CriusEdge.LEFT, h(this.amn));
        }
    }

    private void tk() {
        if (this.amq >= -1.0d) {
            this.alD.setPadding(CriusEdge.BOTTOM, h(this.amq));
        }
    }

    private void tl() {
        if (this.amp >= -1.0d) {
            this.alD.setPadding(CriusEdge.RIGHT, h(this.amp));
        }
    }

    private void tm() {
        if (this.amo >= -1.0d) {
            this.alD.setPadding(CriusEdge.TOP, h(this.amo));
        }
    }

    private void initPadding() {
        if (this.amm >= -1.0d) {
            this.alD.setPadding(CriusEdge.ALL, h(this.amm));
        }
    }

    private void tn() {
        if (this.ami >= -1.0d) {
            this.alD.setMargin(CriusEdge.LEFT, h(this.ami));
        }
    }

    private void tp() {
        if (this.aml >= -1.0d) {
            this.alD.setMargin(CriusEdge.BOTTOM, h(this.aml));
        }
    }

    private void tq() {
        if (this.amk >= -1.0d) {
            this.alD.setMargin(CriusEdge.RIGHT, h(this.amk));
        }
    }

    private void tr() {
        if (this.amj >= -1.0d) {
            this.alD.setMargin(CriusEdge.TOP, h(this.amj));
        }
    }

    private void ts() {
        if (this.amh >= -1.0d) {
            this.alD.setMargin(CriusEdge.ALL, h(this.amh));
        }
    }

    private void tt() {
        if (this.amc >= -1.0d) {
            this.alD.setFlexBasis(h(this.amc));
        }
    }

    private void tu() {
        if (this.amb >= -1.0d) {
            this.alD.setFlexShrink((float) this.amb);
        }
    }

    private void tv() {
        if (this.ama >= -1.0d) {
            this.alD.setFlexGrow((float) this.ama);
        }
    }

    private void tw() {
        if (this.alZ >= -1.0d) {
            this.alD.setFlex((float) this.alZ);
        }
    }

    private void tx() {
        if (!TextUtils.isEmpty(this.alT)) {
            if ("flex".equalsIgnoreCase(this.alT)) {
                this.alD.setDisplay(CriusDisplay.FLEX);
            } else if ("none".equalsIgnoreCase(this.alT)) {
                this.alD.setDisplay(CriusDisplay.NONE);
            } else {
                this.alD.setDisplay(CriusDisplay.FLEX);
            }
        }
    }

    private void ty() {
        if (!c.b(this.amd, -10000.0d)) {
            this.alD.setPosition(CriusEdge.LEFT, h(this.amd));
        }
        if (!c.b(this.ame, -10000.0d)) {
            this.alD.setPosition(CriusEdge.TOP, h(this.ame));
        }
        if (!c.b(this.amf, -10000.0d)) {
            this.alD.setPosition(CriusEdge.RIGHT, h(this.amf));
        }
        if (!c.b(this.amg, -10000.0d)) {
            this.alD.setPosition(CriusEdge.BOTTOM, h(this.amg));
        }
    }

    private void tz() {
        if (!TextUtils.isEmpty(this.position)) {
            if ("relative".equalsIgnoreCase(this.position)) {
                this.alD.setPositionType(CriusPositionType.RELATIVE);
            } else if ("absolute".equalsIgnoreCase(this.position)) {
                this.alD.setPositionType(CriusPositionType.ABSOLUTE);
            }
        }
    }

    private void tA() {
        if (!TextUtils.isEmpty(this.alY)) {
            if ("flex-start".equalsIgnoreCase(this.alY)) {
                this.alD.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.alY)) {
                this.alD.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.alY)) {
                this.alD.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.alY)) {
                this.alD.setAlignSelf(CriusAlign.STRETCH);
            } else if ("space-between".equalsIgnoreCase(this.alY)) {
                this.alD.setAlignSelf(CriusAlign.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.alY)) {
                this.alD.setAlignSelf(CriusAlign.SPACE_AROUND);
            } else {
                this.alD.setAlignSelf(CriusAlign.FLEX_START);
            }
        }
    }

    private void tB() {
        if (!TextUtils.isEmpty(this.alX)) {
            if ("auto".equalsIgnoreCase(this.alX)) {
                this.alD.setAlignSelf(CriusAlign.AUTO);
            } else if ("flex-start".equalsIgnoreCase(this.alX)) {
                this.alD.setAlignSelf(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.alX)) {
                this.alD.setAlignSelf(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.alX)) {
                this.alD.setAlignSelf(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.alX)) {
                this.alD.setAlignSelf(CriusAlign.STRETCH);
            } else {
                this.alD.setAlignSelf(CriusAlign.AUTO);
            }
        }
    }

    private void tC() {
        if (!TextUtils.isEmpty(this.alW)) {
            if ("flex-start".equalsIgnoreCase(this.alW)) {
                this.alD.setAlignItems(CriusAlign.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.alW)) {
                this.alD.setAlignItems(CriusAlign.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.alW)) {
                this.alD.setAlignItems(CriusAlign.FLEX_END);
            } else if ("stretch".equalsIgnoreCase(this.alW)) {
                this.alD.setAlignItems(CriusAlign.STRETCH);
            } else {
                this.alD.setAlignItems(CriusAlign.STRETCH);
            }
        }
    }

    private void tD() {
        if (!TextUtils.isEmpty(this.alV)) {
            if ("flex-start".equalsIgnoreCase(this.alV)) {
                this.alD.setJustifyContent(CriusJustify.FLEX_START);
            } else if ("center".equalsIgnoreCase(this.alV)) {
                this.alD.setJustifyContent(CriusJustify.CENTER);
            } else if ("flex-end".equalsIgnoreCase(this.alV)) {
                this.alD.setJustifyContent(CriusJustify.FLEX_END);
            } else if ("space-between".equalsIgnoreCase(this.alV)) {
                this.alD.setJustifyContent(CriusJustify.SPACE_BETWEEN);
            } else if ("space-around".equalsIgnoreCase(this.alV)) {
                this.alD.setJustifyContent(CriusJustify.SPACE_AROUND);
            } else {
                this.alD.setJustifyContent(CriusJustify.FLEX_START);
            }
        }
    }

    private void tE() {
        if (!TextUtils.isEmpty(this.alU)) {
            if ("column".equalsIgnoreCase(this.alU)) {
                this.alD.setFlexDirection(CriusFlexDirection.COLUMN);
            } else if ("column-reverse".equalsIgnoreCase(this.alU)) {
                this.alD.setFlexDirection(CriusFlexDirection.COLUMN_REVERSE);
            } else if ("row".equalsIgnoreCase(this.alU)) {
                this.alD.setFlexDirection(CriusFlexDirection.ROW);
            } else if ("row-reverse".equalsIgnoreCase(this.alU)) {
                this.alD.setFlexDirection(CriusFlexDirection.ROW_REVERSE);
            } else {
                this.alD.setFlexDirection(CriusFlexDirection.COLUMN);
            }
        }
    }

    public boolean tF() {
        return "text".equals(this.type);
    }

    public a du(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.id)) {
            if (this.amU != null && this.amU.size() > 0) {
                for (a aVar : this.amU) {
                    a du = aVar.du(str);
                    if (du != null) {
                        return du;
                    }
                }
            }
            return null;
        }
        return this;
    }

    public a dv(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase(this.alH)) {
            if (this.amU != null && this.amU.size() > 0) {
                for (a aVar : this.amU) {
                    a dv = aVar.dv(str);
                    if (dv != null) {
                        return dv;
                    }
                }
            }
            return null;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float h(double d) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (this.alE * d);
    }

    public static float a(double d, float f) {
        return d < 1.0d ? (float) (10.0d * d) : (float) (f * d);
    }

    public boolean dw(String str) {
        a dv;
        if (this.alC == null || (dv = dv(str)) == null || dv.alD == null) {
            return false;
        }
        dv.alD.setDisplay(CriusDisplay.NONE);
        dv.alD.dirty();
        this.alC.calculateLayout(Float.NaN, Float.NaN);
        return true;
    }

    public void c(String str, float f) {
        a du;
        if (this.alC != null && (du = du(str)) != null && du.alD != null) {
            du.fontSize = f;
            du.alD.dirty();
            this.alC.calculateLayout(Float.NaN, Float.NaN);
        }
    }
}

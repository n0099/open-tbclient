package com.baidu.baiduarsdk.filter.configdata;

import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class FilterData {
    int a;
    PassType b;
    PassSubType c;
    String d;
    String e;
    String f;
    List<String> g;
    JSONObject h;

    /* loaded from: classes3.dex */
    public enum AdjustType {
        NONE(-1),
        INT(0),
        FLOAT(1),
        POINT(2),
        VEC3(3),
        VEC4(4),
        SIZE(5),
        MAP(6),
        MAT3(7),
        MAT4(8);
        
        private final int mValue;

        AdjustType(int i) {
            this.mValue = i;
        }

        public static AdjustType a(int i) {
            AdjustType[] values;
            for (AdjustType adjustType : values()) {
                if (adjustType.a() == i) {
                    return adjustType;
                }
            }
            return NONE;
        }

        public int a() {
            return this.mValue;
        }
    }

    /* loaded from: classes3.dex */
    public enum PassSubType {
        NONE("none"),
        BRIGHTNESS("brightness"),
        CONTRAST("contrast"),
        EXPOSURE("exposure"),
        SATURATION("saturation"),
        HSB("hsb"),
        SATURATION_PS("saturation_ps"),
        GRAY_SCALE("grayscale"),
        CURVE_PS("curve_ps"),
        CURVE_RIGHT("curve_right"),
        CURVE_LEFT("curve_left"),
        MULTI_PICTURE_BLEND("multi_picture_blend"),
        LOOK_UP("look_up"),
        GAUSSIAN_BLUR("gaussian_blur");
        
        private final String mValue;

        PassSubType(String str) {
            this.mValue = str;
        }

        public static PassSubType a(String str) {
            PassSubType[] values;
            if (str == null) {
                return NONE;
            }
            for (PassSubType passSubType : values()) {
                if (passSubType.a().equalsIgnoreCase(str)) {
                    return passSubType;
                }
            }
            return NONE;
        }

        public String a() {
            return this.mValue;
        }
    }

    /* loaded from: classes3.dex */
    public enum PassType {
        NONE("none"),
        CURVE("curve"),
        COLOR_ADJUST("color_adjust"),
        BEAUTY("beauty"),
        MASK_BLEND("mask_blend"),
        CUSTOM("custom"),
        STYLIZE("stylize");
        
        private final String mValue;

        PassType(String str) {
            this.mValue = str;
        }

        public static PassType a(String str) {
            PassType[] values;
            if (str == null) {
                return NONE;
            }
            for (PassType passType : values()) {
                if (passType.a().equalsIgnoreCase(str)) {
                    return passType;
                }
            }
            return NONE;
        }

        public String a() {
            return this.mValue;
        }
    }

    /* loaded from: classes3.dex */
    public enum ResetType {
        NONE(-1),
        UPDATE(0),
        ADD(1),
        DELETE(2);
        
        private final int mValue;

        ResetType(int i) {
            this.mValue = i;
        }

        public static ResetType a(int i) {
            ResetType[] values;
            for (ResetType resetType : values()) {
                if (resetType.a() == i) {
                    return resetType;
                }
            }
            return NONE;
        }

        public int a() {
            return this.mValue;
        }
    }

    public int a() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(PassSubType passSubType) {
        this.c = passSubType;
    }

    public void a(PassType passType) {
        this.b = passType;
    }

    public void a(String str) {
        this.d = str;
    }

    public void a(List<String> list) {
        this.g = list;
    }

    public void a(JSONObject jSONObject) {
        this.h = jSONObject;
    }

    public PassType b() {
        return this.b;
    }

    public void b(String str) {
        this.e = str;
    }

    public PassSubType c() {
        return this.c;
    }

    public void c(String str) {
        this.f = str;
    }

    public String d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public String f() {
        return this.f;
    }

    public List<String> g() {
        return this.g;
    }

    public JSONObject h() {
        return this.h;
    }
}

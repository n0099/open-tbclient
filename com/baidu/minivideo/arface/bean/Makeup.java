package com.baidu.minivideo.arface.bean;
/* loaded from: classes5.dex */
public class Makeup extends BaseBeautyItem {
    private String mResPath;
    private BeautyType mType;
    private float mValue;

    public String getResPath() {
        return this.mResPath;
    }

    public void setResPath(String str) {
        this.mResPath = str;
    }

    public float getValue() {
        return this.mValue;
    }

    public void setValue(float f) {
        this.mValue = f;
    }

    public BeautyType getType() {
        return this.mType;
    }

    public void setType(BeautyType beautyType) {
        this.mType = beautyType;
    }

    public String getInfo() {
        return "type: " + this.mType + ", value: " + this.mValue + ", Res: " + this.mResPath;
    }
}

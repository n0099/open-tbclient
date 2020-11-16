package com.baidu.minivideo.arface.bean;

import java.io.File;
/* loaded from: classes14.dex */
public class Filter extends BaseBeautyItem {
    public static final int DATA_TYPE_DU_SINGLE = 1;
    private int mDataType;
    private File mFile;
    private float mLevel;
    private String mParam;

    public void setDataType(int i) {
        this.mDataType = i;
    }

    public int getDataType() {
        return this.mDataType;
    }

    public String getPath() {
        if (this.mFile != null) {
            return this.mFile.getAbsolutePath();
        }
        return null;
    }

    public void setFile(File file) {
        this.mFile = file;
    }

    public File getFile() {
        return this.mFile;
    }

    public void setParam(String str) {
        this.mParam = str;
    }

    public float getLevel() {
        return this.mLevel;
    }

    public void setLevel(float f) {
        this.mLevel = f;
    }

    public String getParam() {
        return this.mParam;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("param:").append(this.mParam).append(", type:").append(this.mDataType).append(", level:").append(this.mLevel).append(", path:").append(this.mFile == null ? "null" : this.mFile.getAbsoluteFile());
        return sb.toString();
    }
}

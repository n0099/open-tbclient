package com.baidu.live.alablmsdk.config.enums;
/* loaded from: classes4.dex */
public enum BLMViewShapeType {
    RECTANGLE("r"),
    CIRCLE("c");
    
    private String shapeType;

    BLMViewShapeType(String str) {
        this.shapeType = str;
    }

    public String getShapeType() {
        return this.shapeType;
    }
}

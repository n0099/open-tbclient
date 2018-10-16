package com.baidu.searchbox.ng.ai.apps.model.view.base;
/* loaded from: classes2.dex */
public class AiAppsRectPosition {
    protected int height;
    protected int left;
    protected boolean mHeightAuto;
    protected boolean mWidthAuto;
    protected int top;
    protected int width;

    public AiAppsRectPosition() {
        this.mWidthAuto = false;
        this.mHeightAuto = false;
    }

    public AiAppsRectPosition(AiAppsRectPosition aiAppsRectPosition) {
        this.mWidthAuto = false;
        this.mHeightAuto = false;
        if (aiAppsRectPosition != null) {
            this.left = aiAppsRectPosition.left;
            this.top = aiAppsRectPosition.top;
            this.width = aiAppsRectPosition.width;
            this.height = aiAppsRectPosition.height;
            this.mWidthAuto = aiAppsRectPosition.mWidthAuto;
            this.mHeightAuto = aiAppsRectPosition.mHeightAuto;
        }
    }

    public AiAppsRectPosition(int i, int i2, int i3, int i4) {
        this.mWidthAuto = false;
        this.mHeightAuto = false;
        this.left = i;
        this.top = i2;
        this.width = i3;
        this.height = i4;
    }

    public static AiAppsRectPosition createDefaultPosition() {
        AiAppsRectPosition aiAppsRectPosition = new AiAppsRectPosition();
        aiAppsRectPosition.setWidthAuto(true);
        aiAppsRectPosition.setHeightAuto(true);
        aiAppsRectPosition.setWidth(-1);
        aiAppsRectPosition.setHeight(-1);
        return aiAppsRectPosition;
    }

    public void setWidthAuto(boolean z) {
        this.mWidthAuto = z;
    }

    public void setHeightAuto(boolean z) {
        this.mHeightAuto = z;
    }

    public int getLeft() {
        return this.left;
    }

    public void setLeft(int i) {
        this.left = i;
    }

    public int getTop() {
        return this.top;
    }

    public void setTop(int i) {
        this.top = i;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public boolean isValid() {
        boolean z = false;
        boolean z2 = this.mWidthAuto || this.width >= 0;
        if (this.mHeightAuto || this.height >= 0) {
            z = true;
        }
        return z2 & z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AiAppsRectPosition) {
            AiAppsRectPosition aiAppsRectPosition = (AiAppsRectPosition) obj;
            return this.left == aiAppsRectPosition.left && this.top == aiAppsRectPosition.top && this.height == aiAppsRectPosition.height && this.width == aiAppsRectPosition.width;
        }
        return false;
    }

    public String toString() {
        return "Position{l=" + this.left + ", t=" + this.top + ", w=" + this.width + ", h=" + this.height + ", WAuto=" + this.mWidthAuto + ", HAuto=" + this.mHeightAuto + '}';
    }
}
